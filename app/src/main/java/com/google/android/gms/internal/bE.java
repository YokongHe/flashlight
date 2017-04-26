package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class bE extends BroadcastReceiver {
   private bE() {
   }

   // $FF: synthetic method
   bE(byte var1) {
      this();
   }

   public final void onReceive(Context var1, Intent var2) {
      if("android.intent.action.USER_PRESENT".equals(var2.getAction())) {
         com.google.android.gms.internal.bD.a(true);
      } else if("android.intent.action.SCREEN_OFF".equals(var2.getAction())) {
         com.google.android.gms.internal.bD.a(false);
         return;
      }

   }
}
