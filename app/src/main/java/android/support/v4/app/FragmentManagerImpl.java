package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.app.BackStackRecord;
import android.support.v4.app.BackStackState;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment$SavedState;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager$BackStackEntry;
import android.support.v4.app.FragmentManager$OnBackStackChangedListener;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NoSaveStateFrameLayout;
import android.support.v4.app.SuperNotCalledException;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

final class FragmentManagerImpl extends FragmentManager {
   static final Interpolator ACCELERATE_CUBIC;
   static final Interpolator ACCELERATE_QUINT;
   static final int ANIM_DUR = 220;
   public static final int ANIM_STYLE_CLOSE_ENTER = 3;
   public static final int ANIM_STYLE_CLOSE_EXIT = 4;
   public static final int ANIM_STYLE_FADE_ENTER = 5;
   public static final int ANIM_STYLE_FADE_EXIT = 6;
   public static final int ANIM_STYLE_OPEN_ENTER = 1;
   public static final int ANIM_STYLE_OPEN_EXIT = 2;
   static boolean DEBUG;
   static final Interpolator DECELERATE_CUBIC;
   static final Interpolator DECELERATE_QUINT;
   static final boolean HONEYCOMB;
   static final String TAG = "FragmentManager";
   static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
   static final String TARGET_STATE_TAG = "android:target_state";
   static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
   static final String VIEW_STATE_TAG = "android:view_state";
   ArrayList mActive;
   FragmentActivity mActivity;
   ArrayList mAdded;
   ArrayList mAvailBackStackIndices;
   ArrayList mAvailIndices;
   ArrayList mBackStack;
   ArrayList mBackStackChangeListeners;
   ArrayList mBackStackIndices;
   FragmentContainer mContainer;
   ArrayList mCreatedMenus;
   int mCurState = 0;
   boolean mDestroyed;
   Runnable mExecCommit = new Runnable() {
      public void run() {
         FragmentManagerImpl.this.execPendingActions();
      }
   };
   boolean mExecutingActions;
   boolean mHavePendingDeferredStart;
   boolean mNeedMenuInvalidate;
   String mNoTransactionsBecause;
   Fragment mParent;
   ArrayList mPendingActions;
   SparseArray mStateArray = null;
   Bundle mStateBundle = null;
   boolean mStateSaved;
   Runnable[] mTmpActions;

   static {
      boolean var0 = false;
      DEBUG = false;
      if(VERSION.SDK_INT >= 11) {
         var0 = true;
      }

      HONEYCOMB = var0;
      DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
      DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
      ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
      ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
   }

   private void checkStateLoss() {
      if(this.mStateSaved) {
         throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
      } else if(this.mNoTransactionsBecause != null) {
         throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
      }
   }

   static Animation makeFadeAnimation(Context var0, float var1, float var2) {
      AlphaAnimation var3 = new AlphaAnimation(var1, var2);
      var3.setInterpolator(DECELERATE_CUBIC);
      var3.setDuration(220L);
      return var3;
   }

   static Animation makeOpenCloseAnimation(Context var0, float var1, float var2, float var3, float var4) {
      AnimationSet var7 = new AnimationSet(false);
      ScaleAnimation var5 = new ScaleAnimation(var1, var2, var1, var2, 1, 0.5F, 1, 0.5F);
      var5.setInterpolator(DECELERATE_QUINT);
      var5.setDuration(220L);
      var7.addAnimation(var5);
      AlphaAnimation var6 = new AlphaAnimation(var3, var4);
      var6.setInterpolator(DECELERATE_CUBIC);
      var6.setDuration(220L);
      var7.addAnimation(var6);
      return var7;
   }

   public static int reverseTransit(int var0) {
      switch(var0) {
      case 4097:
         return 8194;
      case 4099:
         return 4099;
      case 8194:
         return 4097;
      default:
         return 0;
      }
   }

   private void throwException(RuntimeException var1) {
      Log.e("FragmentManager", var1.getMessage());
      Log.e("FragmentManager", "Activity state:");
      PrintWriter var2 = new PrintWriter(new LogWriter("FragmentManager"));
      if(this.mActivity != null) {
         try {
            this.mActivity.dump("  ", (FileDescriptor)null, var2, new String[0]);
         } catch (Exception var4) {
            Log.e("FragmentManager", "Failed dumping state", var4);
         }
      } else {
         try {
            this.dump("  ", (FileDescriptor)null, var2, new String[0]);
         } catch (Exception var3) {
            Log.e("FragmentManager", "Failed dumping state", var3);
         }
      }

      throw var1;
   }

   public static int transitToStyleIndex(int var0, boolean var1) {
      switch(var0) {
      case 4097:
         if(var1) {
            return 1;
         }

         return 2;
      case 4099:
         if(var1) {
            return 5;
         }

         return 6;
      case 8194:
         if(var1) {
            return 3;
         }

         return 4;
      default:
         return -1;
      }
   }

   final void addBackStackState(BackStackRecord var1) {
      if(this.mBackStack == null) {
         this.mBackStack = new ArrayList();
      }

      this.mBackStack.add(var1);
      this.reportBackStackChanged();
   }

   public final void addFragment(Fragment var1, boolean var2) {
      if(this.mAdded == null) {
         this.mAdded = new ArrayList();
      }

      if(DEBUG) {
         Log.v("FragmentManager", "add: " + var1);
      }

      this.makeActive(var1);
      if(!var1.mDetached) {
         if(this.mAdded.contains(var1)) {
            throw new IllegalStateException("Fragment already added: " + var1);
         }

         this.mAdded.add(var1);
         var1.mAdded = true;
         var1.mRemoving = false;
         if(var1.mHasMenu && var1.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
         }

         if(var2) {
            this.moveToState(var1);
         }
      }

   }

   public final void addOnBackStackChangedListener(FragmentManager$OnBackStackChangedListener var1) {
      if(this.mBackStackChangeListeners == null) {
         this.mBackStackChangeListeners = new ArrayList();
      }

      this.mBackStackChangeListeners.add(var1);
   }

   public final int allocBackStackIndex(BackStackRecord var1) {
      synchronized(this) {
         int var2;
         if(this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
            var2 = ((Integer)this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
            if(DEBUG) {
               Log.v("FragmentManager", "Adding back stack index " + var2 + " with " + var1);
            }

            this.mBackStackIndices.set(var2, var1);
            return var2;
         } else {
            if(this.mBackStackIndices == null) {
               this.mBackStackIndices = new ArrayList();
            }

            var2 = this.mBackStackIndices.size();
            if(DEBUG) {
               Log.v("FragmentManager", "Setting back stack index " + var2 + " to " + var1);
            }

            this.mBackStackIndices.add(var1);
            return var2;
         }
      }
   }

   public final void attachActivity(FragmentActivity var1, FragmentContainer var2, Fragment var3) {
      if(this.mActivity != null) {
         throw new IllegalStateException("Already attached");
      } else {
         this.mActivity = var1;
         this.mContainer = var2;
         this.mParent = var3;
      }
   }

   public final void attachFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "attach: " + var1);
      }

      if(var1.mDetached) {
         var1.mDetached = false;
         if(!var1.mAdded) {
            if(this.mAdded == null) {
               this.mAdded = new ArrayList();
            }

            if(this.mAdded.contains(var1)) {
               throw new IllegalStateException("Fragment already added: " + var1);
            }

            if(DEBUG) {
               Log.v("FragmentManager", "add from attach: " + var1);
            }

            this.mAdded.add(var1);
            var1.mAdded = true;
            if(var1.mHasMenu && var1.mMenuVisible) {
               this.mNeedMenuInvalidate = true;
            }

            this.moveToState(var1, this.mCurState, var2, var3, false);
         }
      }

   }

   public final FragmentTransaction beginTransaction() {
      return new BackStackRecord(this);
   }

   public final void detachFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "detach: " + var1);
      }

      if(!var1.mDetached) {
         var1.mDetached = true;
         if(var1.mAdded) {
            if(this.mAdded != null) {
               if(DEBUG) {
                  Log.v("FragmentManager", "remove from detach: " + var1);
               }

               this.mAdded.remove(var1);
            }

            if(var1.mHasMenu && var1.mMenuVisible) {
               this.mNeedMenuInvalidate = true;
            }

            var1.mAdded = false;
            this.moveToState(var1, 1, var2, var3, false);
         }
      }

   }

   public final void dispatchActivityCreated() {
      this.mStateSaved = false;
      this.moveToState(2, false);
   }

   public final void dispatchConfigurationChanged(Configuration var1) {
      if(this.mAdded != null) {
         for(int var2 = 0; var2 < this.mAdded.size(); ++var2) {
            Fragment var3 = (Fragment)this.mAdded.get(var2);
            if(var3 != null) {
               var3.performConfigurationChanged(var1);
            }
         }
      }

   }

   public final boolean dispatchContextItemSelected(MenuItem var1) {
      boolean var4 = false;
      boolean var3 = var4;
      if(this.mAdded != null) {
         int var2 = 0;

         while(true) {
            var3 = var4;
            if(var2 >= this.mAdded.size()) {
               break;
            }

            Fragment var5 = (Fragment)this.mAdded.get(var2);
            if(var5 != null && var5.performContextItemSelected(var1)) {
               var3 = true;
               break;
            }

            ++var2;
         }
      }

      return var3;
   }

   public final void dispatchCreate() {
      this.mStateSaved = false;
      this.moveToState(1, false);
   }

   public final boolean dispatchCreateOptionsMenu(Menu var1, MenuInflater var2) {
      byte var4 = 0;
      ArrayList var8 = null;
      ArrayList var7 = null;
      int var3;
      boolean var6;
      if(this.mAdded != null) {
         var3 = 0;
         boolean var5 = false;

         while(true) {
            var8 = var7;
            var6 = var5;
            if(var3 >= this.mAdded.size()) {
               break;
            }

            Fragment var9 = (Fragment)this.mAdded.get(var3);
            var8 = var7;
            var6 = var5;
            if(var9 != null) {
               var8 = var7;
               var6 = var5;
               if(var9.performCreateOptionsMenu(var1, var2)) {
                  var6 = true;
                  var8 = var7;
                  if(var7 == null) {
                     var8 = new ArrayList();
                  }

                  var8.add(var9);
               }
            }

            ++var3;
            var5 = var6;
            var7 = var8;
         }
      } else {
         var6 = false;
      }

      if(this.mCreatedMenus != null) {
         for(var3 = var4; var3 < this.mCreatedMenus.size(); ++var3) {
            Fragment var10 = (Fragment)this.mCreatedMenus.get(var3);
            if(var8 == null || !var8.contains(var10)) {
               var10.onDestroyOptionsMenu();
            }
         }
      }

      this.mCreatedMenus = var8;
      return var6;
   }

   public final void dispatchDestroy() {
      this.mDestroyed = true;
      this.execPendingActions();
      this.moveToState(0, false);
      this.mActivity = null;
      this.mContainer = null;
      this.mParent = null;
   }

   public final void dispatchDestroyView() {
      this.moveToState(1, false);
   }

   public final void dispatchLowMemory() {
      if(this.mAdded != null) {
         for(int var1 = 0; var1 < this.mAdded.size(); ++var1) {
            Fragment var2 = (Fragment)this.mAdded.get(var1);
            if(var2 != null) {
               var2.performLowMemory();
            }
         }
      }

   }

   public final boolean dispatchOptionsItemSelected(MenuItem var1) {
      boolean var4 = false;
      boolean var3 = var4;
      if(this.mAdded != null) {
         int var2 = 0;

         while(true) {
            var3 = var4;
            if(var2 >= this.mAdded.size()) {
               break;
            }

            Fragment var5 = (Fragment)this.mAdded.get(var2);
            if(var5 != null && var5.performOptionsItemSelected(var1)) {
               var3 = true;
               break;
            }

            ++var2;
         }
      }

      return var3;
   }

   public final void dispatchOptionsMenuClosed(Menu var1) {
      if(this.mAdded != null) {
         for(int var2 = 0; var2 < this.mAdded.size(); ++var2) {
            Fragment var3 = (Fragment)this.mAdded.get(var2);
            if(var3 != null) {
               var3.performOptionsMenuClosed(var1);
            }
         }
      }

   }

   public final void dispatchPause() {
      this.moveToState(4, false);
   }

   public final boolean dispatchPrepareOptionsMenu(Menu var1) {
      boolean var4;
      if(this.mAdded != null) {
         int var2 = 0;
         boolean var3 = false;

         while(true) {
            var4 = var3;
            if(var2 >= this.mAdded.size()) {
               break;
            }

            Fragment var5 = (Fragment)this.mAdded.get(var2);
            var4 = var3;
            if(var5 != null) {
               var4 = var3;
               if(var5.performPrepareOptionsMenu(var1)) {
                  var4 = true;
               }
            }

            ++var2;
            var3 = var4;
         }
      } else {
         var4 = false;
      }

      return var4;
   }

   public final void dispatchReallyStop() {
      this.moveToState(2, false);
   }

   public final void dispatchResume() {
      this.mStateSaved = false;
      this.moveToState(5, false);
   }

   public final void dispatchStart() {
      this.mStateSaved = false;
      this.moveToState(4, false);
   }

   public final void dispatchStop() {
      this.mStateSaved = true;
      this.moveToState(3, false);
   }

   public final void dump(String param1, FileDescriptor param2, PrintWriter param3, String[] param4) {
      // $FF: Couldn't be decompiled
   }

   public final void enqueueAction(Runnable var1, boolean var2) {
      if(!var2) {
         this.checkStateLoss();
      }

      synchronized(this) {
         if(!this.mDestroyed && this.mActivity != null) {
            if(this.mPendingActions == null) {
               this.mPendingActions = new ArrayList();
            }

            this.mPendingActions.add(var1);
            if(this.mPendingActions.size() == 1) {
               this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
               this.mActivity.mHandler.post(this.mExecCommit);
            }

         } else {
            throw new IllegalStateException("Activity has been destroyed");
         }
      }
   }

   public final boolean execPendingActions() {
      if(this.mExecutingActions) {
         throw new IllegalStateException("Recursive entry to executePendingTransactions");
      } else if(Looper.myLooper() != this.mActivity.mHandler.getLooper()) {
         throw new IllegalStateException("Must be called from main thread of process");
      } else {
         boolean var4 = false;

         int var1;
         while(true) {
            int var2;
            synchronized(this) {
               if(this.mPendingActions == null || this.mPendingActions.size() == 0) {
                  break;
               }

               var2 = this.mPendingActions.size();
               if(this.mTmpActions == null || this.mTmpActions.length < var2) {
                  this.mTmpActions = new Runnable[var2];
               }

               this.mPendingActions.toArray(this.mTmpActions);
               this.mPendingActions.clear();
               this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
            }

            this.mExecutingActions = true;

            for(var1 = 0; var1 < var2; ++var1) {
               this.mTmpActions[var1].run();
               this.mTmpActions[var1] = null;
            }

            this.mExecutingActions = false;
            var4 = true;
         }

         if(this.mHavePendingDeferredStart) {
            var1 = 0;

            boolean var3;
            boolean var7;
            for(var7 = false; var1 < this.mActive.size(); var7 = var3) {
               Fragment var5 = (Fragment)this.mActive.get(var1);
               var3 = var7;
               if(var5 != null) {
                  var3 = var7;
                  if(var5.mLoaderManager != null) {
                     var3 = var7 | var5.mLoaderManager.hasRunningLoaders();
                  }
               }

               ++var1;
            }

            if(!var7) {
               this.mHavePendingDeferredStart = false;
               this.startPendingDeferredFragments();
            }
         }

         return var4;
      }
   }

   public final boolean executePendingTransactions() {
      return this.execPendingActions();
   }

   public final Fragment findFragmentById(int var1) {
      int var2;
      Fragment var3;
      if(this.mAdded != null) {
         for(var2 = this.mAdded.size() - 1; var2 >= 0; --var2) {
            var3 = (Fragment)this.mAdded.get(var2);
            if(var3 != null && var3.mFragmentId == var1) {
               return var3;
            }
         }
      }

      if(this.mActive != null) {
         for(var2 = this.mActive.size() - 1; var2 >= 0; --var2) {
            Fragment var4 = (Fragment)this.mActive.get(var2);
            if(var4 != null) {
               var3 = var4;
               if(var4.mFragmentId == var1) {
                  return var3;
               }
            }
         }
      }

      return null;
   }

   public final Fragment findFragmentByTag(String var1) {
      int var2;
      Fragment var3;
      if(this.mAdded != null && var1 != null) {
         for(var2 = this.mAdded.size() - 1; var2 >= 0; --var2) {
            var3 = (Fragment)this.mAdded.get(var2);
            if(var3 != null && var1.equals(var3.mTag)) {
               return var3;
            }
         }
      }

      if(this.mActive == null || var1 == null) {
         return null;
      } else {
         for(var2 = this.mActive.size() - 1; var2 >= 0; --var2) {
            Fragment var4 = (Fragment)this.mActive.get(var2);
            if(var4 != null) {
               var3 = var4;
               if(var1.equals(var4.mTag)) {
                  return var3;
               }
            }
         }

         return null;
      }
   }

   public final Fragment findFragmentByWho(String var1) {
      if(this.mActive != null && var1 != null) {
         for(int var2 = this.mActive.size() - 1; var2 >= 0; --var2) {
            Fragment var3 = (Fragment)this.mActive.get(var2);
            if(var3 != null) {
               var3 = var3.findFragmentByWho(var1);
               if(var3 != null) {
                  return var3;
               }
            }
         }
      }

      return null;
   }

   public final void freeBackStackIndex(int var1) {
      synchronized(this) {
         this.mBackStackIndices.set(var1, (Object)null);
         if(this.mAvailBackStackIndices == null) {
            this.mAvailBackStackIndices = new ArrayList();
         }

         if(DEBUG) {
            Log.v("FragmentManager", "Freeing back stack index " + var1);
         }

         this.mAvailBackStackIndices.add(Integer.valueOf(var1));
      }
   }

   public final FragmentManager$BackStackEntry getBackStackEntryAt(int var1) {
      return (FragmentManager$BackStackEntry)this.mBackStack.get(var1);
   }

   public final int getBackStackEntryCount() {
      return this.mBackStack != null?this.mBackStack.size():0;
   }

   public final Fragment getFragment(Bundle var1, String var2) {
      int var3 = var1.getInt(var2, -1);
      Fragment var5;
      if(var3 == -1) {
         var5 = null;
      } else {
         if(var3 >= this.mActive.size()) {
            this.throwException(new IllegalStateException("Fragement no longer exists for key " + var2 + ": index " + var3));
         }

         Fragment var4 = (Fragment)this.mActive.get(var3);
         var5 = var4;
         if(var4 == null) {
            this.throwException(new IllegalStateException("Fragement no longer exists for key " + var2 + ": index " + var3));
            return var4;
         }
      }

      return var5;
   }

   public final List getFragments() {
      return this.mActive;
   }

   public final void hideFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "hide: " + var1);
      }

      if(!var1.mHidden) {
         var1.mHidden = true;
         if(var1.mView != null) {
            Animation var4 = this.loadAnimation(var1, var2, false, var3);
            if(var4 != null) {
               var1.mView.startAnimation(var4);
            }

            var1.mView.setVisibility(8);
         }

         if(var1.mAdded && var1.mHasMenu && var1.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
         }

         var1.onHiddenChanged(true);
      }

   }

   public final boolean isDestroyed() {
      return this.mDestroyed;
   }

   final Animation loadAnimation(Fragment var1, int var2, boolean var3, int var4) {
      Animation var5 = var1.onCreateAnimation(var2, var3, var1.mNextAnim);
      Animation var6;
      if(var5 != null) {
         var6 = var5;
         return var6;
      } else {
         if(var1.mNextAnim != 0) {
            var5 = AnimationUtils.loadAnimation(this.mActivity, var1.mNextAnim);
            var6 = var5;
            if(var5 != null) {
               return var6;
            }
         }

         if(var2 == 0) {
            return null;
         } else {
            var2 = transitToStyleIndex(var2, var3);
            if(var2 < 0) {
               return null;
            } else {
               switch(var2) {
               case 1:
                  return makeOpenCloseAnimation(this.mActivity, 1.125F, 1.0F, 0.0F, 1.0F);
               case 2:
                  return makeOpenCloseAnimation(this.mActivity, 1.0F, 0.975F, 1.0F, 0.0F);
               case 3:
                  return makeOpenCloseAnimation(this.mActivity, 0.975F, 1.0F, 0.0F, 1.0F);
               case 4:
                  return makeOpenCloseAnimation(this.mActivity, 1.0F, 1.075F, 1.0F, 0.0F);
               case 5:
                  return makeFadeAnimation(this.mActivity, 0.0F, 1.0F);
               case 6:
                  return makeFadeAnimation(this.mActivity, 1.0F, 0.0F);
               default:
                  var2 = var4;
                  if(var4 == 0) {
                     var2 = var4;
                     if(this.mActivity.getWindow() != null) {
                        var2 = this.mActivity.getWindow().getAttributes().windowAnimations;
                     }
                  }

                  if(var2 == 0) {
                     return null;
                  } else {
                     return null;
                  }
               }
            }
         }
      }
   }

   final void makeActive(Fragment var1) {
      if(var1.mIndex < 0) {
         if(this.mAvailIndices != null && this.mAvailIndices.size() > 0) {
            var1.setIndex(((Integer)this.mAvailIndices.remove(this.mAvailIndices.size() - 1)).intValue(), this.mParent);
            this.mActive.set(var1.mIndex, var1);
         } else {
            if(this.mActive == null) {
               this.mActive = new ArrayList();
            }

            var1.setIndex(this.mActive.size(), this.mParent);
            this.mActive.add(var1);
         }

         if(DEBUG) {
            Log.v("FragmentManager", "Allocated fragment index " + var1);
            return;
         }
      }

   }

   final void makeInactive(Fragment var1) {
      if(var1.mIndex >= 0) {
         if(DEBUG) {
            Log.v("FragmentManager", "Freeing fragment index " + var1);
         }

         this.mActive.set(var1.mIndex, (Object)null);
         if(this.mAvailIndices == null) {
            this.mAvailIndices = new ArrayList();
         }

         this.mAvailIndices.add(Integer.valueOf(var1.mIndex));
         this.mActivity.invalidateSupportFragment(var1.mWho);
         var1.initState();
      }
   }

   final void moveToState(int var1, int var2, int var3, boolean var4) {
      if(this.mActivity == null && var1 != 0) {
         throw new IllegalStateException("No activity");
      } else {
         if(var4 || this.mCurState != var1) {
            this.mCurState = var1;
            if(this.mActive != null) {
               int var6 = 0;

               boolean var5;
               for(var5 = false; var6 < this.mActive.size(); ++var6) {
                  Fragment var7 = (Fragment)this.mActive.get(var6);
                  if(var7 != null) {
                     this.moveToState(var7, var1, var2, var3, false);
                     if(var7.mLoaderManager != null) {
                        var5 |= var7.mLoaderManager.hasRunningLoaders();
                     }
                  }
               }

               if(!var5) {
                  this.startPendingDeferredFragments();
               }

               if(this.mNeedMenuInvalidate && this.mActivity != null && this.mCurState == 5) {
                  this.mActivity.supportInvalidateOptionsMenu();
                  this.mNeedMenuInvalidate = false;
                  return;
               }
            }
         }

      }
   }

   final void moveToState(int var1, boolean var2) {
      this.moveToState(var1, 0, 0, var2);
   }

   final void moveToState(Fragment var1) {
      this.moveToState(var1, this.mCurState, 0, 0, false);
   }

   final void moveToState(final Fragment var1, int var2, int var3, int var4, boolean var5) {
      int var6;
      label232: {
         if(var1.mAdded) {
            var6 = var2;
            if(!var1.mDetached) {
               break label232;
            }
         }

         var6 = var2;
         if(var2 > 1) {
            var6 = 1;
         }
      }

      int var7 = var6;
      if(var1.mRemoving) {
         var7 = var6;
         if(var6 > var1.mState) {
            var7 = var1.mState;
         }
      }

      var2 = var7;
      if(var1.mDeferStart) {
         var2 = var7;
         if(var1.mState < 4) {
            var2 = var7;
            if(var7 > 3) {
               var2 = 3;
            }
         }
      }

      if(var1.mState < var2) {
         if(var1.mFromLayout && !var1.mInLayout) {
            return;
         }

         if(var1.mAnimatingAway != null) {
            var1.mAnimatingAway = null;
            this.moveToState(var1, var1.mStateAfterAnimating, 0, 0, true);
         }

         var6 = var2;
         int var8 = var2;
         var7 = var2;
         switch(var1.mState) {
         case 0:
            if(DEBUG) {
               Log.v("FragmentManager", "moveto CREATED: " + var1);
            }

            var7 = var2;
            if(var1.mSavedFragmentState != null) {
               var1.mSavedViewState = var1.mSavedFragmentState.getSparseParcelableArray("android:view_state");
               var1.mTarget = this.getFragment(var1.mSavedFragmentState, "android:target_state");
               if(var1.mTarget != null) {
                  var1.mTargetRequestCode = var1.mSavedFragmentState.getInt("android:target_req_state", 0);
               }

               var1.mUserVisibleHint = var1.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
               var7 = var2;
               if(!var1.mUserVisibleHint) {
                  var1.mDeferStart = true;
                  var7 = var2;
                  if(var2 > 3) {
                     var7 = 3;
                  }
               }
            }

            var1.mActivity = this.mActivity;
            var1.mParentFragment = this.mParent;
            FragmentManagerImpl var9;
            if(this.mParent != null) {
               var9 = this.mParent.mChildFragmentManager;
            } else {
               var9 = this.mActivity.mFragments;
            }

            var1.mFragmentManager = var9;
            var1.mCalled = false;
            var1.onAttach(this.mActivity);
            if(!var1.mCalled) {
               throw new SuperNotCalledException("Fragment " + var1 + " did not call through to super.onAttach()");
            }

            if(var1.mParentFragment == null) {
               this.mActivity.onAttachFragment(var1);
            }

            if(!var1.mRetaining) {
               var1.performCreate(var1.mSavedFragmentState);
            }

            var1.mRetaining = false;
            var6 = var7;
            if(var1.mFromLayout) {
               var1.mView = var1.performCreateView(var1.getLayoutInflater(var1.mSavedFragmentState), (ViewGroup)null, var1.mSavedFragmentState);
               if(var1.mView != null) {
                  var1.mInnerView = var1.mView;
                  var1.mView = NoSaveStateFrameLayout.wrap(var1.mView);
                  if(var1.mHidden) {
                     var1.mView.setVisibility(8);
                  }

                  var1.onViewCreated(var1.mView, var1.mSavedFragmentState);
                  var6 = var7;
               } else {
                  var1.mInnerView = null;
                  var6 = var7;
               }
            }
         case 1:
            var8 = var6;
            if(var6 > 1) {
               if(DEBUG) {
                  Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + var1);
               }

               if(!var1.mFromLayout) {
                  ViewGroup var11;
                  if(var1.mContainerId != 0) {
                     ViewGroup var10 = (ViewGroup)this.mContainer.findViewById(var1.mContainerId);
                     var11 = var10;
                     if(var10 == null) {
                        var11 = var10;
                        if(!var1.mRestored) {
                           this.throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(var1.mContainerId) + " (" + var1.getResources().getResourceName(var1.mContainerId) + ") for fragment " + var1));
                           var11 = var10;
                        }
                     }
                  } else {
                     var11 = null;
                  }

                  var1.mContainer = var11;
                  var1.mView = var1.performCreateView(var1.getLayoutInflater(var1.mSavedFragmentState), var11, var1.mSavedFragmentState);
                  if(var1.mView != null) {
                     var1.mInnerView = var1.mView;
                     var1.mView = NoSaveStateFrameLayout.wrap(var1.mView);
                     if(var11 != null) {
                        Animation var12 = this.loadAnimation(var1, var3, true, var4);
                        if(var12 != null) {
                           var1.mView.startAnimation(var12);
                        }

                        var11.addView(var1.mView);
                     }

                     if(var1.mHidden) {
                        var1.mView.setVisibility(8);
                     }

                     var1.onViewCreated(var1.mView, var1.mSavedFragmentState);
                  } else {
                     var1.mInnerView = null;
                  }
               }

               var1.performActivityCreated(var1.mSavedFragmentState);
               if(var1.mView != null) {
                  var1.restoreViewState(var1.mSavedFragmentState);
               }

               var1.mSavedFragmentState = null;
               var8 = var6;
            }
         case 2:
         case 3:
            var7 = var8;
            if(var8 > 3) {
               if(DEBUG) {
                  Log.v("FragmentManager", "moveto STARTED: " + var1);
               }

               var1.performStart();
               var7 = var8;
            }
         case 4:
            var6 = var7;
            if(var7 > 4) {
               if(DEBUG) {
                  Log.v("FragmentManager", "moveto RESUMED: " + var1);
               }

               var1.mResumed = true;
               var1.performResume();
               var1.mSavedFragmentState = null;
               var1.mSavedViewState = null;
               var6 = var7;
            }
            break;
         default:
            var6 = var2;
         }
      } else {
         var6 = var2;
         if(var1.mState > var2) {
            switch(var1.mState) {
            case 5:
               if(var2 < 5) {
                  if(DEBUG) {
                     Log.v("FragmentManager", "movefrom RESUMED: " + var1);
                  }

                  var1.performPause();
                  var1.mResumed = false;
               }
            case 4:
               if(var2 < 4) {
                  if(DEBUG) {
                     Log.v("FragmentManager", "movefrom STARTED: " + var1);
                  }

                  var1.performStop();
               }
            case 3:
               if(var2 < 3) {
                  if(DEBUG) {
                     Log.v("FragmentManager", "movefrom STOPPED: " + var1);
                  }

                  var1.performReallyStop();
               }
            case 2:
               if(var2 < 2) {
                  if(DEBUG) {
                     Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + var1);
                  }

                  if(var1.mView != null && !this.mActivity.isFinishing() && var1.mSavedViewState == null) {
                     this.saveFragmentViewState(var1);
                  }

                  var1.performDestroyView();
                  if(var1.mView != null && var1.mContainer != null) {
                     Animation var13;
                     if(this.mCurState > 0 && !this.mDestroyed) {
                        var13 = this.loadAnimation(var1, var3, false, var4);
                     } else {
                        var13 = null;
                     }

                     if(var13 != null) {
                        var1.mAnimatingAway = var1.mView;
                        var1.mStateAfterAnimating = var2;
                        var13.setAnimationListener(new AnimationListener() {
                           public void onAnimationEnd(Animation var1x) {
                              if(var1.mAnimatingAway != null) {
                                 var1.mAnimatingAway = null;
                                 FragmentManagerImpl.this.moveToState(var1, var1.mStateAfterAnimating, 0, 0, false);
                              }

                           }

                           public void onAnimationRepeat(Animation var1x) {
                           }

                           public void onAnimationStart(Animation var1x) {
                           }
                        });
                        var1.mView.startAnimation(var13);
                     }

                     var1.mContainer.removeView(var1.mView);
                  }

                  var1.mContainer = null;
                  var1.mView = null;
                  var1.mInnerView = null;
               }
            case 1:
               var6 = var2;
               if(var2 <= 0) {
                  if(this.mDestroyed && var1.mAnimatingAway != null) {
                     View var14 = var1.mAnimatingAway;
                     var1.mAnimatingAway = null;
                     var14.clearAnimation();
                  }

                  if(var1.mAnimatingAway != null) {
                     var1.mStateAfterAnimating = var2;
                     var6 = 1;
                  } else {
                     if(DEBUG) {
                        Log.v("FragmentManager", "movefrom CREATED: " + var1);
                     }

                     if(!var1.mRetaining) {
                        var1.performDestroy();
                     }

                     var1.mCalled = false;
                     var1.onDetach();
                     if(!var1.mCalled) {
                        throw new SuperNotCalledException("Fragment " + var1 + " did not call through to super.onDetach()");
                     }

                     var6 = var2;
                     if(!var5) {
                        if(!var1.mRetaining) {
                           this.makeInactive(var1);
                           var6 = var2;
                        } else {
                           var1.mActivity = null;
                           var1.mFragmentManager = null;
                           var6 = var2;
                        }
                     }
                  }
               }
               break;
            default:
               var6 = var2;
            }
         }
      }

      var1.mState = var6;
   }

   public final void noteStateNotSaved() {
      this.mStateSaved = false;
   }

   public final void performPendingDeferredStart(Fragment var1) {
      if(var1.mDeferStart) {
         if(!this.mExecutingActions) {
            var1.mDeferStart = false;
            this.moveToState(var1, this.mCurState, 0, 0, false);
            return;
         }

         this.mHavePendingDeferredStart = true;
      }

   }

   public final void popBackStack() {
      this.enqueueAction(new Runnable() {
         public void run() {
            FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, (String)null, -1, 0);
         }
      }, false);
   }

   public final void popBackStack(final int var1, final int var2) {
      if(var1 < 0) {
         throw new IllegalArgumentException("Bad id: " + var1);
      } else {
         this.enqueueAction(new Runnable() {
            public void run() {
               FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, (String)null, var1, var2);
            }
         }, false);
      }
   }

   public final void popBackStack(final String var1, final int var2) {
      this.enqueueAction(new Runnable() {
         public void run() {
            FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, var1, -1, var2);
         }
      }, false);
   }

   public final boolean popBackStackImmediate() {
      this.checkStateLoss();
      this.executePendingTransactions();
      return this.popBackStackState(this.mActivity.mHandler, (String)null, -1, 0);
   }

   public final boolean popBackStackImmediate(int var1, int var2) {
      this.checkStateLoss();
      this.executePendingTransactions();
      if(var1 < 0) {
         throw new IllegalArgumentException("Bad id: " + var1);
      } else {
         return this.popBackStackState(this.mActivity.mHandler, (String)null, var1, var2);
      }
   }

   public final boolean popBackStackImmediate(String var1, int var2) {
      this.checkStateLoss();
      this.executePendingTransactions();
      return this.popBackStackState(this.mActivity.mHandler, var1, -1, var2);
   }

   final boolean popBackStackState(Handler var1, String var2, int var3, int var4) {
      if(this.mBackStack != null) {
         if(var2 == null && var3 < 0 && (var4 & 1) == 0) {
            var3 = this.mBackStack.size() - 1;
            if(var3 < 0) {
               return false;
            }

            ((BackStackRecord)this.mBackStack.remove(var3)).popFromBackStack(true);
         } else {
            int var5 = -1;
            if(var2 != null || var3 >= 0) {
               int var6;
               BackStackRecord var8;
               for(var6 = this.mBackStack.size() - 1; var6 >= 0; --var6) {
                  var8 = (BackStackRecord)this.mBackStack.get(var6);
                  if(var2 != null && var2.equals(var8.getName()) || var3 >= 0 && var3 == var8.mIndex) {
                     break;
                  }
               }

               if(var6 < 0) {
                  return false;
               }

               var5 = var6;
               if((var4 & 1) != 0) {
                  var4 = var6 - 1;

                  while(true) {
                     var5 = var4;
                     if(var4 < 0) {
                        break;
                     }

                     var8 = (BackStackRecord)this.mBackStack.get(var4);
                     if(var2 == null || !var2.equals(var8.getName())) {
                        var5 = var4;
                        if(var3 < 0) {
                           break;
                        }

                        var5 = var4;
                        if(var3 != var8.mIndex) {
                           break;
                        }
                     }

                     --var4;
                  }
               }
            }

            if(var5 == this.mBackStack.size() - 1) {
               return false;
            }

            ArrayList var9 = new ArrayList();

            for(var3 = this.mBackStack.size() - 1; var3 > var5; --var3) {
               var9.add(this.mBackStack.remove(var3));
            }

            var4 = var9.size() - 1;

            for(var3 = 0; var3 <= var4; ++var3) {
               if(DEBUG) {
                  Log.v("FragmentManager", "Popping back stack state: " + var9.get(var3));
               }

               BackStackRecord var10 = (BackStackRecord)var9.get(var3);
               boolean var7;
               if(var3 == var4) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               var10.popFromBackStack(var7);
            }
         }

         this.reportBackStackChanged();
         return true;
      } else {
         return false;
      }
   }

   public final void putFragment(Bundle var1, String var2, Fragment var3) {
      if(var3.mIndex < 0) {
         this.throwException(new IllegalStateException("Fragment " + var3 + " is not currently in the FragmentManager"));
      }

      var1.putInt(var2, var3.mIndex);
   }

   public final void removeFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "remove: " + var1 + " nesting=" + var1.mBackStackNesting);
      }

      boolean var4;
      if(!var1.isInBackStack()) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(!var1.mDetached || var4) {
         if(this.mAdded != null) {
            this.mAdded.remove(var1);
         }

         if(var1.mHasMenu && var1.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
         }

         var1.mAdded = false;
         var1.mRemoving = true;
         byte var5;
         if(var4) {
            var5 = 0;
         } else {
            var5 = 1;
         }

         this.moveToState(var1, var5, var2, var3, false);
      }

   }

   public final void removeOnBackStackChangedListener(FragmentManager$OnBackStackChangedListener var1) {
      if(this.mBackStackChangeListeners != null) {
         this.mBackStackChangeListeners.remove(var1);
      }

   }

   final void reportBackStackChanged() {
      if(this.mBackStackChangeListeners != null) {
         for(int var1 = 0; var1 < this.mBackStackChangeListeners.size(); ++var1) {
            ((FragmentManager$OnBackStackChangedListener)this.mBackStackChangeListeners.get(var1)).onBackStackChanged();
         }
      }

   }

   final void restoreAllState(Parcelable var1, ArrayList var2) {
      if(var1 != null) {
         FragmentManagerState var6 = (FragmentManagerState)var1;
         if(var6.mActive != null) {
            int var3;
            Fragment var4;
            if(var2 != null) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  var4 = (Fragment)var2.get(var3);
                  if(DEBUG) {
                     Log.v("FragmentManager", "restoreAllState: re-attaching retained " + var4);
                  }

                  FragmentState var5 = var6.mActive[var4.mIndex];
                  var5.mInstance = var4;
                  var4.mSavedViewState = null;
                  var4.mBackStackNesting = 0;
                  var4.mInLayout = false;
                  var4.mAdded = false;
                  var4.mTarget = null;
                  if(var5.mSavedFragmentState != null) {
                     var5.mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
                     var4.mSavedViewState = var5.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                  }
               }
            }

            this.mActive = new ArrayList(var6.mActive.length);
            if(this.mAvailIndices != null) {
               this.mAvailIndices.clear();
            }

            for(var3 = 0; var3 < var6.mActive.length; ++var3) {
               FragmentState var9 = var6.mActive[var3];
               if(var9 != null) {
                  Fragment var10 = var9.instantiate(this.mActivity, this.mParent);
                  if(DEBUG) {
                     Log.v("FragmentManager", "restoreAllState: active #" + var3 + ": " + var10);
                  }

                  this.mActive.add(var10);
                  var9.mInstance = null;
               } else {
                  this.mActive.add((Object)null);
                  if(this.mAvailIndices == null) {
                     this.mAvailIndices = new ArrayList();
                  }

                  if(DEBUG) {
                     Log.v("FragmentManager", "restoreAllState: avail #" + var3);
                  }

                  this.mAvailIndices.add(Integer.valueOf(var3));
               }
            }

            if(var2 != null) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  var4 = (Fragment)var2.get(var3);
                  if(var4.mTargetIndex >= 0) {
                     if(var4.mTargetIndex < this.mActive.size()) {
                        var4.mTarget = (Fragment)this.mActive.get(var4.mTargetIndex);
                     } else {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + var4 + " target no longer exists: " + var4.mTargetIndex);
                        var4.mTarget = null;
                     }
                  }
               }
            }

            if(var6.mAdded != null) {
               this.mAdded = new ArrayList(var6.mAdded.length);

               for(var3 = 0; var3 < var6.mAdded.length; ++var3) {
                  Fragment var7 = (Fragment)this.mActive.get(var6.mAdded[var3]);
                  if(var7 == null) {
                     this.throwException(new IllegalStateException("No instantiated fragment for index #" + var6.mAdded[var3]));
                  }

                  var7.mAdded = true;
                  if(DEBUG) {
                     Log.v("FragmentManager", "restoreAllState: added #" + var3 + ": " + var7);
                  }

                  if(this.mAdded.contains(var7)) {
                     throw new IllegalStateException("Already added!");
                  }

                  this.mAdded.add(var7);
               }
            } else {
               this.mAdded = null;
            }

            if(var6.mBackStack == null) {
               this.mBackStack = null;
               return;
            }

            this.mBackStack = new ArrayList(var6.mBackStack.length);

            for(var3 = 0; var3 < var6.mBackStack.length; ++var3) {
               BackStackRecord var8 = var6.mBackStack[var3].instantiate(this);
               if(DEBUG) {
                  Log.v("FragmentManager", "restoreAllState: back stack #" + var3 + " (index " + var8.mIndex + "): " + var8);
                  var8.dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
               }

               this.mBackStack.add(var8);
               if(var8.mIndex >= 0) {
                  this.setBackStackIndex(var8.mIndex, var8);
               }
            }
         }
      }

   }

   final ArrayList retainNonConfig() {
      ArrayList var4 = null;
      ArrayList var3 = null;
      if(this.mActive != null) {
         int var1 = 0;

         while(true) {
            var4 = var3;
            if(var1 >= this.mActive.size()) {
               break;
            }

            Fragment var6 = (Fragment)this.mActive.get(var1);
            ArrayList var5 = var3;
            if(var6 != null) {
               var5 = var3;
               if(var6.mRetainInstance) {
                  var4 = var3;
                  if(var3 == null) {
                     var4 = new ArrayList();
                  }

                  var4.add(var6);
                  var6.mRetaining = true;
                  int var2;
                  if(var6.mTarget != null) {
                     var2 = var6.mTarget.mIndex;
                  } else {
                     var2 = -1;
                  }

                  var6.mTargetIndex = var2;
                  var5 = var4;
                  if(DEBUG) {
                     Log.v("FragmentManager", "retainNonConfig: keeping retained " + var6);
                     var5 = var4;
                  }
               }
            }

            ++var1;
            var3 = var5;
         }
      }

      return var4;
   }

   final Parcelable saveAllState() {
      BackStackState[] var6 = null;
      this.execPendingActions();
      if(HONEYCOMB) {
         this.mStateSaved = true;
      }

      if(this.mActive != null && this.mActive.size() > 0) {
         int var3 = this.mActive.size();
         FragmentState[] var7 = new FragmentState[var3];
         int var2 = 0;

         boolean var1;
         for(var1 = false; var2 < var3; ++var2) {
            Fragment var4 = (Fragment)this.mActive.get(var2);
            if(var4 != null) {
               if(var4.mIndex < 0) {
                  this.throwException(new IllegalStateException("Failure saving state: active " + var4 + " has cleared index: " + var4.mIndex));
               }

               FragmentState var5 = new FragmentState(var4);
               var7[var2] = var5;
               if(var4.mState > 0 && var5.mSavedFragmentState == null) {
                  var5.mSavedFragmentState = this.saveFragmentBasicState(var4);
                  if(var4.mTarget != null) {
                     if(var4.mTarget.mIndex < 0) {
                        this.throwException(new IllegalStateException("Failure saving state: " + var4 + " has target not in fragment manager: " + var4.mTarget));
                     }

                     if(var5.mSavedFragmentState == null) {
                        var5.mSavedFragmentState = new Bundle();
                     }

                     this.putFragment(var5.mSavedFragmentState, "android:target_state", var4.mTarget);
                     if(var4.mTargetRequestCode != 0) {
                        var5.mSavedFragmentState.putInt("android:target_req_state", var4.mTargetRequestCode);
                     }
                  }
               } else {
                  var5.mSavedFragmentState = var4.mSavedFragmentState;
               }

               if(DEBUG) {
                  Log.v("FragmentManager", "Saved state of " + var4 + ": " + var5.mSavedFragmentState);
               }

               var1 = true;
            }
         }

         if(var1) {
            int var8;
            int[] var9;
            label82: {
               if(this.mAdded != null) {
                  var2 = this.mAdded.size();
                  if(var2 > 0) {
                     int[] var10 = new int[var2];
                     var8 = 0;

                     while(true) {
                        var9 = var10;
                        if(var8 >= var2) {
                           break label82;
                        }

                        var10[var8] = ((Fragment)this.mAdded.get(var8)).mIndex;
                        if(var10[var8] < 0) {
                           this.throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(var8) + " has cleared index: " + var10[var8]));
                        }

                        if(DEBUG) {
                           Log.v("FragmentManager", "saveAllState: adding fragment #" + var8 + ": " + this.mAdded.get(var8));
                        }

                        ++var8;
                     }
                  }
               }

               var9 = null;
            }

            BackStackState[] var11 = var6;
            if(this.mBackStack != null) {
               var2 = this.mBackStack.size();
               var11 = var6;
               if(var2 > 0) {
                  var6 = new BackStackState[var2];
                  var8 = 0;

                  while(true) {
                     var11 = var6;
                     if(var8 >= var2) {
                        break;
                     }

                     var6[var8] = new BackStackState(this, (BackStackRecord)this.mBackStack.get(var8));
                     if(DEBUG) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + var8 + ": " + this.mBackStack.get(var8));
                     }

                     ++var8;
                  }
               }
            }

            FragmentManagerState var12 = new FragmentManagerState();
            var12.mActive = var7;
            var12.mAdded = var9;
            var12.mBackStack = var11;
            return var12;
         }

         if(DEBUG) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
         }
      }

      return null;
   }

   final Bundle saveFragmentBasicState(Fragment var1) {
      if(this.mStateBundle == null) {
         this.mStateBundle = new Bundle();
      }

      var1.performSaveInstanceState(this.mStateBundle);
      Bundle var3;
      if(!this.mStateBundle.isEmpty()) {
         var3 = this.mStateBundle;
         this.mStateBundle = null;
      } else {
         var3 = null;
      }

      if(var1.mView != null) {
         this.saveFragmentViewState(var1);
      }

      Bundle var2 = var3;
      if(var1.mSavedViewState != null) {
         var2 = var3;
         if(var3 == null) {
            var2 = new Bundle();
         }

         var2.putSparseParcelableArray("android:view_state", var1.mSavedViewState);
      }

      var3 = var2;
      if(!var1.mUserVisibleHint) {
         var3 = var2;
         if(var2 == null) {
            var3 = new Bundle();
         }

         var3.putBoolean("android:user_visible_hint", var1.mUserVisibleHint);
      }

      return var3;
   }

   public final Fragment$SavedState saveFragmentInstanceState(Fragment var1) {
      Object var3 = null;
      if(var1.mIndex < 0) {
         this.throwException(new IllegalStateException("Fragment " + var1 + " is not currently in the FragmentManager"));
      }

      Fragment$SavedState var2 = (Fragment$SavedState)var3;
      if(var1.mState > 0) {
         Bundle var4 = this.saveFragmentBasicState(var1);
         var2 = (Fragment$SavedState)var3;
         if(var4 != null) {
            var2 = new Fragment$SavedState(var4);
         }
      }

      return var2;
   }

   final void saveFragmentViewState(Fragment var1) {
      if(var1.mInnerView != null) {
         if(this.mStateArray == null) {
            this.mStateArray = new SparseArray();
         } else {
            this.mStateArray.clear();
         }

         var1.mInnerView.saveHierarchyState(this.mStateArray);
         if(this.mStateArray.size() > 0) {
            var1.mSavedViewState = this.mStateArray;
            this.mStateArray = null;
            return;
         }
      }

   }

   public final void setBackStackIndex(int param1, BackStackRecord param2) {
      // $FF: Couldn't be decompiled
   }

   public final void showFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "show: " + var1);
      }

      if(var1.mHidden) {
         var1.mHidden = false;
         if(var1.mView != null) {
            Animation var4 = this.loadAnimation(var1, var2, true, var3);
            if(var4 != null) {
               var1.mView.startAnimation(var4);
            }

            var1.mView.setVisibility(0);
         }

         if(var1.mAdded && var1.mHasMenu && var1.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
         }

         var1.onHiddenChanged(false);
      }

   }

   final void startPendingDeferredFragments() {
      if(this.mActive != null) {
         for(int var1 = 0; var1 < this.mActive.size(); ++var1) {
            Fragment var2 = (Fragment)this.mActive.get(var1);
            if(var2 != null) {
               this.performPendingDeferredStart(var2);
            }
         }
      }

   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("FragmentManager{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      var1.append(" in ");
      if(this.mParent != null) {
         DebugUtils.buildShortClassTag(this.mParent, var1);
      } else {
         DebugUtils.buildShortClassTag(this.mActivity, var1);
      }

      var1.append("}}");
      return var1.toString();
   }
}
