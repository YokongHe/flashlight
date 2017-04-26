package com.ihs.app.push.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class GcmBroadcastReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      if(var2 != null) {
         (new StringBuilder("onReceive: ")).append(var2.getAction()).toString();
         String var3 = var2.getAction();
         if(!TextUtils.isEmpty(var3)) {
            (new StringBuilder("handle intent entrance, action is ")).append(var3).toString();
            if(var3.equalsIgnoreCase("com.google.android.c2dm.intent.RECEIVE")) {
               var2.putExtra("platform", "Android");
               com.ihs.app.push.impl.a.a();
               com.ihs.app.push.impl.a.a(var2);
               return;
            }

            if(var3.equalsIgnoreCase("com.google.android.c2dm.intent.REGISTRATION")) {
               var2.putExtra("platform", "Android");
               var3 = var2.getStringExtra("registration_id");
               String var4 = var2.getStringExtra("error");
               (new StringBuilder("handle GCM token, token is ")).append(var3).append(", error is ").append(var4).toString();
               if(var3 != null) {
                  com.ihs.app.push.impl.a.a().a(var3);
                  return;
               }

               if(var4 != null) {
                  com.ihs.app.push.impl.a.a().b(var4);
                  return;
               }
            }
         }
      }

   }
}
