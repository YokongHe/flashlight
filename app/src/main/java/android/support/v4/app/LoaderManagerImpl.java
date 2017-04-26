package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager$LoaderCallbacks;
import android.support.v4.app.LoaderManagerImpl$LoaderInfo;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl extends LoaderManager {
   static boolean DEBUG = false;
   static final String TAG = "LoaderManager";
   FragmentActivity mActivity;
   boolean mCreatingLoader;
   final SparseArrayCompat mInactiveLoaders = new SparseArrayCompat();
   final SparseArrayCompat mLoaders = new SparseArrayCompat();
   boolean mRetaining;
   boolean mRetainingStarted;
   boolean mStarted;
   final String mWho;

   LoaderManagerImpl(String var1, FragmentActivity var2, boolean var3) {
      this.mWho = var1;
      this.mActivity = var2;
      this.mStarted = var3;
   }

   private LoaderManagerImpl$LoaderInfo createAndInstallLoader(int var1, Bundle var2, LoaderManager$LoaderCallbacks var3) {
      LoaderManagerImpl$LoaderInfo var6;
      try {
         this.mCreatingLoader = true;
         var6 = this.createLoader(var1, var2, var3);
         this.installLoader(var6);
      } finally {
         this.mCreatingLoader = false;
      }

      return var6;
   }

   private LoaderManagerImpl$LoaderInfo createLoader(int var1, Bundle var2, LoaderManager$LoaderCallbacks var3) {
      LoaderManagerImpl$LoaderInfo var4 = new LoaderManagerImpl$LoaderInfo(this, var1, var2, var3);
      var4.mLoader = var3.onCreateLoader(var1, var2);
      return var4;
   }

   public void destroyLoader(int var1) {
      if(this.mCreatingLoader) {
         throw new IllegalStateException("Called while creating a loader");
      } else {
         if(DEBUG) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + var1);
         }

         int var2 = this.mLoaders.indexOfKey(var1);
         LoaderManagerImpl$LoaderInfo var3;
         if(var2 >= 0) {
            var3 = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var2);
            this.mLoaders.removeAt(var2);
            var3.destroy();
         }

         var1 = this.mInactiveLoaders.indexOfKey(var1);
         if(var1 >= 0) {
            var3 = (LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.valueAt(var1);
            this.mInactiveLoaders.removeAt(var1);
            var3.destroy();
         }

         if(this.mActivity != null && !this.hasRunningLoaders()) {
            this.mActivity.mFragments.startPendingDeferredFragments();
         }

      }
   }

   void doDestroy() {
      int var1;
      if(!this.mRetaining) {
         if(DEBUG) {
            Log.v("LoaderManager", "Destroying Active in " + this);
         }

         for(var1 = this.mLoaders.size() - 1; var1 >= 0; --var1) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var1)).destroy();
         }

         this.mLoaders.clear();
      }

      if(DEBUG) {
         Log.v("LoaderManager", "Destroying Inactive in " + this);
      }

      for(var1 = this.mInactiveLoaders.size() - 1; var1 >= 0; --var1) {
         ((LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.valueAt(var1)).destroy();
      }

      this.mInactiveLoaders.clear();
   }

   void doReportNextStart() {
      for(int var1 = this.mLoaders.size() - 1; var1 >= 0; --var1) {
         ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var1)).mReportNextStart = true;
      }

   }

   void doReportStart() {
      for(int var1 = this.mLoaders.size() - 1; var1 >= 0; --var1) {
         ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var1)).reportStart();
      }

   }

   void doRetain() {
      if(DEBUG) {
         Log.v("LoaderManager", "Retaining in " + this);
      }

      if(!this.mStarted) {
         RuntimeException var2 = new RuntimeException("here");
         var2.fillInStackTrace();
         Log.w("LoaderManager", "Called doRetain when not started: " + this, var2);
      } else {
         this.mRetaining = true;
         this.mStarted = false;

         for(int var1 = this.mLoaders.size() - 1; var1 >= 0; --var1) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var1)).retain();
         }
      }

   }

   void doStart() {
      if(DEBUG) {
         Log.v("LoaderManager", "Starting in " + this);
      }

      if(this.mStarted) {
         RuntimeException var2 = new RuntimeException("here");
         var2.fillInStackTrace();
         Log.w("LoaderManager", "Called doStart when already started: " + this, var2);
      } else {
         this.mStarted = true;

         for(int var1 = this.mLoaders.size() - 1; var1 >= 0; --var1) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var1)).start();
         }
      }

   }

   void doStop() {
      if(DEBUG) {
         Log.v("LoaderManager", "Stopping in " + this);
      }

      if(!this.mStarted) {
         RuntimeException var2 = new RuntimeException("here");
         var2.fillInStackTrace();
         Log.w("LoaderManager", "Called doStop when not started: " + this, var2);
      } else {
         for(int var1 = this.mLoaders.size() - 1; var1 >= 0; --var1) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var1)).stop();
         }

         this.mStarted = false;
      }
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      byte var6 = 0;
      int var5;
      String var7;
      LoaderManagerImpl$LoaderInfo var8;
      if(this.mLoaders.size() > 0) {
         var3.print(var1);
         var3.println("Active Loaders:");
         var7 = var1 + "    ";

         for(var5 = 0; var5 < this.mLoaders.size(); ++var5) {
            var8 = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var5);
            var3.print(var1);
            var3.print("  #");
            var3.print(this.mLoaders.keyAt(var5));
            var3.print(": ");
            var3.println(var8.toString());
            var8.dump(var7, var2, var3, var4);
         }
      }

      if(this.mInactiveLoaders.size() > 0) {
         var3.print(var1);
         var3.println("Inactive Loaders:");
         var7 = var1 + "    ";

         for(var5 = var6; var5 < this.mInactiveLoaders.size(); ++var5) {
            var8 = (LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.valueAt(var5);
            var3.print(var1);
            var3.print("  #");
            var3.print(this.mInactiveLoaders.keyAt(var5));
            var3.print(": ");
            var3.println(var8.toString());
            var8.dump(var7, var2, var3, var4);
         }
      }

   }

   void finishRetain() {
      if(this.mRetaining) {
         if(DEBUG) {
            Log.v("LoaderManager", "Finished Retaining in " + this);
         }

         this.mRetaining = false;

         for(int var1 = this.mLoaders.size() - 1; var1 >= 0; --var1) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var1)).finishRetain();
         }
      }

   }

   public Loader getLoader(int var1) {
      if(this.mCreatingLoader) {
         throw new IllegalStateException("Called while creating a loader");
      } else {
         LoaderManagerImpl$LoaderInfo var2 = (LoaderManagerImpl$LoaderInfo)this.mLoaders.get(var1);
         return var2 != null?(var2.mPendingLoader != null?var2.mPendingLoader.mLoader:var2.mLoader):null;
      }
   }

   public boolean hasRunningLoaders() {
      int var3 = this.mLoaders.size();
      int var1 = 0;

      boolean var4;
      for(var4 = false; var1 < var3; ++var1) {
         LoaderManagerImpl$LoaderInfo var5 = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(var1);
         boolean var2;
         if(var5.mStarted && !var5.mDeliveredData) {
            var2 = true;
         } else {
            var2 = false;
         }

         var4 |= var2;
      }

      return var4;
   }

   public Loader initLoader(int var1, Bundle var2, LoaderManager$LoaderCallbacks var3) {
      if(this.mCreatingLoader) {
         throw new IllegalStateException("Called while creating a loader");
      } else {
         LoaderManagerImpl$LoaderInfo var4 = (LoaderManagerImpl$LoaderInfo)this.mLoaders.get(var1);
         if(DEBUG) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + var2);
         }

         LoaderManagerImpl$LoaderInfo var5;
         if(var4 == null) {
            LoaderManagerImpl$LoaderInfo var6 = this.createAndInstallLoader(var1, var2, var3);
            var5 = var6;
            if(DEBUG) {
               Log.v("LoaderManager", "  Created new loader " + var6);
               var5 = var6;
            }
         } else {
            if(DEBUG) {
               Log.v("LoaderManager", "  Re-using existing loader " + var4);
            }

            var4.mCallbacks = var3;
            var5 = var4;
         }

         if(var5.mHaveData && this.mStarted) {
            var5.callOnLoadFinished(var5.mLoader, var5.mData);
         }

         return var5.mLoader;
      }
   }

   void installLoader(LoaderManagerImpl$LoaderInfo var1) {
      this.mLoaders.put(var1.mId, var1);
      if(this.mStarted) {
         var1.start();
      }

   }

   public Loader restartLoader(int var1, Bundle var2, LoaderManager$LoaderCallbacks var3) {
      if(this.mCreatingLoader) {
         throw new IllegalStateException("Called while creating a loader");
      } else {
         LoaderManagerImpl$LoaderInfo var4 = (LoaderManagerImpl$LoaderInfo)this.mLoaders.get(var1);
         if(DEBUG) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + var2);
         }

         if(var4 != null) {
            LoaderManagerImpl$LoaderInfo var5 = (LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.get(var1);
            if(var5 != null) {
               if(!var4.mHaveData) {
                  if(var4.mStarted) {
                     if(var4.mPendingLoader != null) {
                        if(DEBUG) {
                           Log.v("LoaderManager", "  Removing pending loader: " + var4.mPendingLoader);
                        }

                        var4.mPendingLoader.destroy();
                        var4.mPendingLoader = null;
                     }

                     if(DEBUG) {
                        Log.v("LoaderManager", "  Enqueuing as new pending loader");
                     }

                     var4.mPendingLoader = this.createLoader(var1, var2, var3);
                     return var4.mPendingLoader.mLoader;
                  }

                  if(DEBUG) {
                     Log.v("LoaderManager", "  Current loader is stopped; replacing");
                  }

                  this.mLoaders.put(var1, (Object)null);
                  var4.destroy();
                  return this.createAndInstallLoader(var1, var2, var3).mLoader;
               }

               if(DEBUG) {
                  Log.v("LoaderManager", "  Removing last inactive loader: " + var4);
               }

               var5.mDeliveredData = false;
               var5.destroy();
            } else if(DEBUG) {
               Log.v("LoaderManager", "  Making last loader inactive: " + var4);
            }

            var4.mLoader.abandon();
            this.mInactiveLoaders.put(var1, var4);
         }

         return this.createAndInstallLoader(var1, var2, var3).mLoader;
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("LoaderManager{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      var1.append(" in ");
      DebugUtils.buildShortClassTag(this.mActivity, var1);
      var1.append("}}");
      return var1.toString();
   }

   void updateActivity(FragmentActivity var1) {
      this.mActivity = var1;
   }
}
