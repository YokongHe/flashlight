package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.flurry.sdk.eo;
import com.flurry.sdk.fe;

public final class InstallReceiver extends BroadcastReceiver {
   static final String a = InstallReceiver.class.getSimpleName();

   public final void onReceive(Context var1, Intent var2) {
      eo.a(4, a, "Received an Install nofication of " + var2.getAction());
      String var3 = var2.getExtras().getString("referrer");
      eo.a(4, a, "Received an Install referrer of " + var3);
      if(var3 != null && "com.android.vending.INSTALL_REFERRER".equals(var2.getAction())) {
         String var4 = var3;
         if(!var3.contains("=")) {
            eo.a(4, a, "referrer is before decoding: " + var3);
            var4 = fe.c(var3);
            eo.a(4, a, "referrer is: " + var4);
         }

         (new com.flurry.sdk.cy(var1)).a(var4);
      } else {
         eo.a(5, a, "referrer is null");
      }
   }
}
