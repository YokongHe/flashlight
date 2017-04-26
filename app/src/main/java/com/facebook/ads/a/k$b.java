package com.facebook.ads.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class k$b extends BroadcastReceiver {
   // $FF: synthetic field
   final com.facebook.ads.a.k a;

   private k$b(com.facebook.ads.a.k var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   k$b(com.facebook.ads.a.k var1, Object var2) {
      this(var1);
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      if("android.intent.action.SCREEN_OFF".equals(var3)) {
         com.facebook.ads.a.k.a(this.a, var2.getAction());
      } else if("android.intent.action.SCREEN_ON".equals(var3) && com.facebook.ads.a.k.b(this.a) == 0) {
         this.a.a(var2.getAction());
         return;
      }

   }
}
