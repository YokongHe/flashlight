package com.ihs.app.framework.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NativeActivity;
import android.os.Bundle;
import android.view.KeyEvent;

@SuppressLint({"NewApi"})
public class HSNativeActivity extends NativeActivity implements com.ihs.app.framework.activity.a {
   protected AlertDialog a;
   private boolean b = false;

   private void a() {
      if(this.a != null) {
         this.a.dismiss();
         this.a = null;
      }

   }

   public final boolean a(AlertDialog var1) {
      this.a();
      this.a = var1;
      this.a.show();
      return true;
   }

   public void onBackPressed() {
      super.onBackPressed();
      this.b = true;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      com.ihs.app.framework.b.a(this);
   }

   protected void onDestroy() {
      super.onDestroy();
      this.a();
      com.ihs.app.framework.b.b(this);
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4 && var2.getRepeatCount() == 0) {
         this.b = false;
      }

      return super.onKeyDown(var1, var2);
   }

   protected void onPause() {
      super.onPause();
   }

   protected void onRestart() {
      super.onRestart();
   }

   protected void onResume() {
      super.onResume();
   }

   protected void onStart() {
      super.onStart();
      com.ihs.app.framework.b.c(this);
   }

   protected void onStop() {
      super.onStop();
      com.ihs.app.framework.b.a(this, this.b);
   }
}
