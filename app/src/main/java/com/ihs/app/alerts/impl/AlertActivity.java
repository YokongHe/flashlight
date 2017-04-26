package com.ihs.app.alerts.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

public class AlertActivity extends Activity {
   private AlertDialog a;
   private boolean b = false;
   private final com.ihs.a.d.d c = new com.ihs.a.d.d() {
      public final void a(String var1, com.ihs.a.e.e var2) {
         AlertActivity.this.finish();
      }
   };

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(1);
      this.getWindow().addFlags(4718592);
      this.getWindow().addFlags(2097280);
      com.ihs.a.d.a.a("hs.app.session.SESSION_END", this.c);
   }

   protected void onDestroy() {
      com.ihs.a.d.a.a(this.c);
      super.onDestroy();
   }

   protected void onResume() {
      super.onResume();
      if(!this.b) {
         this.b = true;
         Intent var3 = this.getIntent();
         if(var3 != null) {
            String var2 = var3.getStringExtra("AlertName");
            int var1 = var3.getIntExtra("AlertType", -1);
            Bundle var4 = var3.getBundleExtra("bundle");
            (new StringBuilder("AlertName: ")).append(var2).toString();
            this.a = (new com.ihs.app.alerts.impl.a(this, true)).a(var2, var1, var4);
            if(this.a != null) {
               this.a.show();
               return;
            }
         }
      }

   }

   protected void onStop() {
      if(this.isFinishing() && this.a != null) {
         this.a.dismiss();
      }

      super.onStop();
   }
}
