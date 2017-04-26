package com.surpax.ledflashlight;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.ihs.app.framework.activity.HSActivity;

public class HoneyCombInnerActivity extends HSActivity {
   public static int a = -1;

   // $FF: synthetic method
   static void a(HoneyCombInnerActivity var0, Activity var1, String var2) {
      try {
         if(com.ihs.app.b.a.a("com.android.vending")) {
            Uri var4 = Uri.parse("market://details?id=" + var2);
            Intent var5 = new Intent("android.intent.action.VIEW");
            var5.setData(var4);
            var1.startActivity(var5);
         } else {
            var1.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + var2)));
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903042);
      ((TextView)this.findViewById(2131492887)).setText(com.surpax.b.a.a().c());
      ((TextView)this.findViewById(2131492888)).setText(com.surpax.b.a.a().d());
      Button var2 = (Button)this.findViewById(2131492889);
      var2.setText(com.surpax.b.a.a().e());
      var2.setOnClickListener(new OnClickListener() {
         public final void onClick(View var1) {
            com.ihs.app.a.b.a("HC_Ad_InApp_Download_Clicked");
            HoneyCombInnerActivity.a(HoneyCombInnerActivity.this, HoneyCombInnerActivity.this, com.surpax.b.a.a);
            HoneyCombInnerActivity.this.finish();
         }
      });
   }

   protected void onDestroy() {
      super.onDestroy();
   }

   protected void onResume() {
      com.ihs.app.a.b.a("HC_Ad_InApp_Viewed");
      super.onResume();
   }

   protected void onStop() {
      super.onStop();
   }
}
