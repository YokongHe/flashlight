package com.ihs.app.framework.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.KeyEvent;

public class HSActivity extends Activity implements com.ihs.app.framework.activity.a {
   private boolean a = false;
   private AlertDialog b;

   private void a() {
      if(this.b != null) {
         this.b.dismiss();
         this.b = null;
      }

   }

   public final boolean a(AlertDialog var1) {
      this.a();
      this.b = var1;
      this.b.show();
      return true;
   }

   public void onBackPressed() {
      super.onBackPressed();
      this.a = true;
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
         this.a = false;
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
      this.a = false;
      com.ihs.app.framework.b.c(this);
   }

   protected void onStop() {
      super.onStop();
      com.ihs.app.framework.b.a(this, this.a);
   }
}
