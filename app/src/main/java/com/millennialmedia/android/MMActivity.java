package com.millennialmedia.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMBaseActivity;
import com.millennialmedia.android.MMSDK$Event;

public class MMActivity extends Activity {
   private static final String TAG = "MMActivity";
   long creatorAdImplInternalId;
   private MMBaseActivity mmBaseActivity;
   GestureDetector tapDetector;

   public boolean dispatchTouchEvent(MotionEvent var1) {
      if(this.tapDetector != null) {
         this.tapDetector.onTouchEvent(var1);
      }

      return this.mmBaseActivity != null?this.mmBaseActivity.dispatchTouchEvent(var1):super.dispatchTouchEvent(var1);
   }

   boolean dispatchTouchEventSuper(MotionEvent var1) {
      return super.dispatchTouchEvent(var1);
   }

   public void finish() {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.finish();
      } else {
         MMSDK$Event.overlayClosed(MMAdImplController.getAdImplWithId(this.creatorAdImplInternalId));
         super.finish();
      }
   }

   public void finishSuper() {
      MMSDK$Event.overlayClosed(MMAdImplController.getAdImplWithId(this.creatorAdImplInternalId));
      super.finish();
   }

   protected MMBaseActivity getWrappedActivity() {
      return this.mmBaseActivity;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onActivityResult(var1, var2, var3);
      } else {
         super.onActivityResult(var1, var2, var3);
      }
   }

   void onActivityResultSuper(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
   }

   public void onConfigurationChanged(Configuration var1) {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onConfigurationChanged(var1);
      } else {
         super.onConfigurationChanged(var1);
      }
   }

   void onConfigurationChangedSuper(Configuration var1) {
      super.onConfigurationChanged(var1);
   }

   protected void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   void onCreateSuper(Bundle var1) {
      super.onCreate(var1);
   }

   protected void onDestroy() {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onDestroy();
      } else {
         super.onDestroy();
      }
   }

   void onDestroySuper() {
      super.onDestroy();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return this.mmBaseActivity != null?this.mmBaseActivity.onKeyDown(var1, var2):super.onKeyDown(var1, var2);
   }

   boolean onKeyDownSuper(int var1, KeyEvent var2) {
      return super.onKeyDown(var1, var2);
   }

   protected void onPause() {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onPause();
      } else {
         super.onPause();
      }
   }

   void onPauseSuper() {
      super.onPause();
   }

   protected void onRestart() {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onRestart();
      } else {
         super.onRestart();
      }
   }

   void onRestartSuper() {
      super.onRestart();
   }

   protected void onRestoreInstanceState(Bundle var1) {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onRestoreInstanceState(var1);
      } else {
         super.onRestoreInstanceState(var1);
      }
   }

   void onRestoreInstanceStateSuper(Bundle var1) {
      super.onRestoreInstanceState(var1);
   }

   protected void onResume() {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onResume();
      } else {
         super.onResume();
      }
   }

   void onResumeSuper() {
      super.onResume();
   }

   public Object onRetainNonConfigurationInstance() {
      return this.mmBaseActivity != null?this.mmBaseActivity.onRetainNonConfigurationInstance():super.onRetainNonConfigurationInstance();
   }

   Object onRetainNonConfigurationInstanceSuper() {
      return super.onRetainNonConfigurationInstance();
   }

   protected void onSaveInstanceState(Bundle var1) {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onSaveInstanceState(var1);
      } else {
         super.onSaveInstanceState(var1);
      }
   }

   void onSaveInstanceStateSuper(Bundle var1) {
      super.onSaveInstanceState(var1);
   }

   protected void onStart() {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onStart();
      } else {
         super.onStart();
      }
   }

   void onStartSuper() {
      super.onStart();
   }

   protected void onStop() {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onStop();
      } else {
         super.onStop();
      }
   }

   void onStopSuper() {
      super.onStop();
   }

   public void onWindowFocusChanged(boolean var1) {
      if(this.mmBaseActivity != null) {
         this.mmBaseActivity.onWindowFocusChanged(var1);
      } else {
         super.onWindowFocusChanged(var1);
      }
   }

   void onWindowFocusChangedSuper(boolean var1) {
      super.onWindowFocusChanged(var1);
   }
}
