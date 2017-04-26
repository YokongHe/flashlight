package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class f extends BroadcastReceiver {
   public static String a(Intent var0) {
      return "com.android.vending.INSTALL_REFERRER".equals(var0.getAction())?var0.getStringExtra("referrer"):null;
   }

   private static boolean a(Context param0, String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public final void onReceive(Context var1, Intent var2) {
      String var3 = a(var2);
      if(var3 != null) {
         a(var1, "install_referrer", var3);
      }

   }
}
