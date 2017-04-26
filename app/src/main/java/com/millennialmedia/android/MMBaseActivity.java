package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.millennialmedia.android.MMActivity;
import java.io.File;

class MMBaseActivity {
   MMActivity activity;

   public boolean dispatchTouchEvent(MotionEvent var1) {
      return this.activity.dispatchTouchEventSuper(var1);
   }

   public void finish() {
      this.activity.finishSuper();
   }

   public File getCacheDir() {
      return this.activity.getCacheDir();
   }

   public ContentResolver getContentResolver() {
      return this.activity.getContentResolver();
   }

   public Intent getIntent() {
      return this.activity.getIntent();
   }

   public Object getLastNonConfigurationInstance() {
      return this.activity.getLastNonConfigurationInstance();
   }

   public Object getSystemService(String var1) {
      return this.activity.getSystemService(var1);
   }

   public Window getWindow() {
      return this.activity.getWindow();
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      this.activity.onActivityResultSuper(var1, var2, var3);
   }

   public void onConfigurationChanged(Configuration var1) {
      this.activity.onConfigurationChangedSuper(var1);
   }

   protected void onCreate(Bundle var1) {
      this.activity.onCreateSuper(var1);
   }

   protected void onDestroy() {
      this.activity.onDestroySuper();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return this.activity.onKeyDownSuper(var1, var2);
   }

   protected void onPause() {
      this.activity.onPauseSuper();
   }

   protected void onRestart() {
      this.activity.onRestartSuper();
   }

   protected void onRestoreInstanceState(Bundle var1) {
      this.activity.onRestoreInstanceStateSuper(var1);
   }

   protected void onResume() {
      this.activity.onResumeSuper();
   }

   public Object onRetainNonConfigurationInstance() {
      return this.activity.onRetainNonConfigurationInstanceSuper();
   }

   protected void onSaveInstanceState(Bundle var1) {
      this.activity.onSaveInstanceStateSuper(var1);
   }

   protected void onStart() {
      this.activity.onStartSuper();
   }

   protected void onStop() {
      this.activity.onStopSuper();
   }

   public void onWindowFocusChanged(boolean var1) {
      this.activity.onWindowFocusChangedSuper(var1);
   }

   public Intent registerReceiver(BroadcastReceiver var1, IntentFilter var2) {
      return this.activity.registerReceiver(var1, var2);
   }

   public final boolean requestWindowFeature(int var1) {
      return this.activity.requestWindowFeature(var1);
   }

   public final void runOnUiThread(Runnable var1) {
      this.activity.runOnUiThread(var1);
   }

   public void setContentView(View var1) {
      this.activity.setContentView(var1);
   }

   public void setRequestedOrientation(int var1) {
      this.activity.setRequestedOrientation(var1);
   }

   public final void setResult(int var1) {
      this.activity.setResult(var1);
   }

   public void setTheme(int var1) {
      this.activity.setTheme(var1);
   }

   public void startActivity(Intent var1) {
      this.activity.startActivity(var1);
   }

   public void startActivityForResult(Intent var1, int var2) {
      this.activity.startActivityForResult(var1, var2);
   }

   public void unregisterReceiver(BroadcastReceiver var1) {
      this.activity.unregisterReceiver(var1);
   }
}
