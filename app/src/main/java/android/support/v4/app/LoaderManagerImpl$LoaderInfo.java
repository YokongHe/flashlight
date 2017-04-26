package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager$LoaderCallbacks;
import android.support.v4.app.LoaderManagerImpl;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader$OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl$LoaderInfo implements Loader$OnLoadCompleteListener {
   final Bundle mArgs;
   LoaderManager$LoaderCallbacks mCallbacks;
   Object mData;
   boolean mDeliveredData;
   boolean mDestroyed;
   boolean mHaveData;
   final int mId;
   boolean mListenerRegistered;
   Loader mLoader;
   LoaderManagerImpl$LoaderInfo mPendingLoader;
   boolean mReportNextStart;
   boolean mRetaining;
   boolean mRetainingStarted;
   boolean mStarted;
   // $FF: synthetic field
   final LoaderManagerImpl this$0;

   public LoaderManagerImpl$LoaderInfo(LoaderManagerImpl var1, int var2, Bundle var3, LoaderManager$LoaderCallbacks var4) {
      this.this$0 = var1;
      this.mId = var2;
      this.mArgs = var3;
      this.mCallbacks = var4;
   }

   final void callOnLoadFinished(Loader var1, Object var2) {
      if(this.mCallbacks != null) {
         String var3;
         if(this.this$0.mActivity != null) {
            var3 = this.this$0.mActivity.mFragments.mNoTransactionsBecause;
            this.this$0.mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
         } else {
            var3 = null;
         }

         try {
            if(LoaderManagerImpl.DEBUG) {
               Log.v("LoaderManager", "  onLoadFinished in " + var1 + ": " + var1.dataToString(var2));
            }

            this.mCallbacks.onLoadFinished(var1, var2);
         } finally {
            if(this.this$0.mActivity != null) {
               this.this$0.mActivity.mFragments.mNoTransactionsBecause = var3;
            }

         }

         this.mDeliveredData = true;
      }

   }

   final void destroy() {
      LoaderManagerImpl$LoaderInfo var2 = this;

      while(true) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Destroying: " + var2);
         }

         var2.mDestroyed = true;
         boolean var1 = var2.mDeliveredData;
         var2.mDeliveredData = false;
         if(var2.mCallbacks != null && var2.mLoader != null && var2.mHaveData && var1) {
            if(LoaderManagerImpl.DEBUG) {
               Log.v("LoaderManager", "  Reseting: " + var2);
            }

            String var3;
            if(var2.this$0.mActivity != null) {
               var3 = var2.this$0.mActivity.mFragments.mNoTransactionsBecause;
               var2.this$0.mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
            } else {
               var3 = null;
            }

            try {
               var2.mCallbacks.onLoaderReset(var2.mLoader);
            } finally {
               if(var2.this$0.mActivity != null) {
                  var2.this$0.mActivity.mFragments.mNoTransactionsBecause = var3;
               }

            }
         }

         var2.mCallbacks = null;
         var2.mData = null;
         var2.mHaveData = false;
         if(var2.mLoader != null) {
            if(var2.mListenerRegistered) {
               var2.mListenerRegistered = false;
               var2.mLoader.unregisterListener(var2);
            }

            var2.mLoader.reset();
         }

         if(var2.mPendingLoader == null) {
            return;
         }

         var2 = var2.mPendingLoader;
      }
   }

   public final void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      String var5 = var1;
      LoaderManagerImpl$LoaderInfo var6 = this;

      while(true) {
         var3.print(var5);
         var3.print("mId=");
         var3.print(var6.mId);
         var3.print(" mArgs=");
         var3.println(var6.mArgs);
         var3.print(var5);
         var3.print("mCallbacks=");
         var3.println(var6.mCallbacks);
         var3.print(var5);
         var3.print("mLoader=");
         var3.println(var6.mLoader);
         if(var6.mLoader != null) {
            var6.mLoader.dump(var5 + "  ", var2, var3, var4);
         }

         if(var6.mHaveData || var6.mDeliveredData) {
            var3.print(var5);
            var3.print("mHaveData=");
            var3.print(var6.mHaveData);
            var3.print("  mDeliveredData=");
            var3.println(var6.mDeliveredData);
            var3.print(var5);
            var3.print("mData=");
            var3.println(var6.mData);
         }

         var3.print(var5);
         var3.print("mStarted=");
         var3.print(var6.mStarted);
         var3.print(" mReportNextStart=");
         var3.print(var6.mReportNextStart);
         var3.print(" mDestroyed=");
         var3.println(var6.mDestroyed);
         var3.print(var5);
         var3.print("mRetaining=");
         var3.print(var6.mRetaining);
         var3.print(" mRetainingStarted=");
         var3.print(var6.mRetainingStarted);
         var3.print(" mListenerRegistered=");
         var3.println(var6.mListenerRegistered);
         if(var6.mPendingLoader == null) {
            return;
         }

         var3.print(var5);
         var3.println("Pending Loader ");
         var3.print(var6.mPendingLoader);
         var3.println(":");
         var6 = var6.mPendingLoader;
         var5 = var5 + "  ";
      }
   }

   final void finishRetain() {
      if(this.mRetaining) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Finished Retaining: " + this);
         }

         this.mRetaining = false;
         if(this.mStarted != this.mRetainingStarted && !this.mStarted) {
            this.stop();
         }
      }

      if(this.mStarted && this.mHaveData && !this.mReportNextStart) {
         this.callOnLoadFinished(this.mLoader, this.mData);
      }

   }

   public final void onLoadComplete(Loader var1, Object var2) {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "onLoadComplete: " + this);
      }

      if(this.mDestroyed) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
         }
      } else if(this.this$0.mLoaders.get(this.mId) != this) {
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
            return;
         }
      } else {
         LoaderManagerImpl$LoaderInfo var3 = this.mPendingLoader;
         if(var3 != null) {
            if(LoaderManagerImpl.DEBUG) {
               Log.v("LoaderManager", "  Switching to pending loader: " + var3);
            }

            this.mPendingLoader = null;
            this.this$0.mLoaders.put(this.mId, (Object)null);
            this.destroy();
            this.this$0.installLoader(var3);
            return;
         }

         if(this.mData != var2 || !this.mHaveData) {
            this.mData = var2;
            this.mHaveData = true;
            if(this.mStarted) {
               this.callOnLoadFinished(var1, var2);
            }
         }

         LoaderManagerImpl$LoaderInfo var4 = (LoaderManagerImpl$LoaderInfo)this.this$0.mInactiveLoaders.get(this.mId);
         if(var4 != null && var4 != this) {
            var4.mDeliveredData = false;
            var4.destroy();
            this.this$0.mInactiveLoaders.remove(this.mId);
         }

         if(this.this$0.mActivity != null && !this.this$0.hasRunningLoaders()) {
            this.this$0.mActivity.mFragments.startPendingDeferredFragments();
            return;
         }
      }

   }

   final void reportStart() {
      if(this.mStarted && this.mReportNextStart) {
         this.mReportNextStart = false;
         if(this.mHaveData) {
            this.callOnLoadFinished(this.mLoader, this.mData);
         }
      }

   }

   final void retain() {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "  Retaining: " + this);
      }

      this.mRetaining = true;
      this.mRetainingStarted = this.mStarted;
      this.mStarted = false;
      this.mCallbacks = null;
   }

   final void start() {
      if(this.mRetaining && this.mRetainingStarted) {
         this.mStarted = true;
      } else if(!this.mStarted) {
         this.mStarted = true;
         if(LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Starting: " + this);
         }

         if(this.mLoader == null && this.mCallbacks != null) {
            this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
         }

         if(this.mLoader != null) {
            if(this.mLoader.getClass().isMemberClass() && !Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
               throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
            }

            if(!this.mListenerRegistered) {
               this.mLoader.registerListener(this.mId, this);
               this.mListenerRegistered = true;
            }

            this.mLoader.startLoading();
            return;
         }
      }

   }

   final void stop() {
      if(LoaderManagerImpl.DEBUG) {
         Log.v("LoaderManager", "  Stopping: " + this);
      }

      this.mStarted = false;
      if(!this.mRetaining && this.mLoader != null && this.mListenerRegistered) {
         this.mListenerRegistered = false;
         this.mLoader.unregisterListener(this);
         this.mLoader.stopLoading();
      }

   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder(64);
      var1.append("LoaderInfo{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      var1.append(" #");
      var1.append(this.mId);
      var1.append(" : ");
      DebugUtils.buildShortClassTag(this.mLoader, var1);
      var1.append("}}");
      return var1.toString();
   }
}
