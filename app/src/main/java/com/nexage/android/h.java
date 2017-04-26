package com.nexage.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.nexage.android.NexageAdView;

final class h extends BroadcastReceiver {
   // $FF: synthetic field
   final NexageAdView a;

   private h(NexageAdView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   h(NexageAdView var1, byte var2) {
      this(var1);
   }

   public final void onReceive(Context var1, Intent var2) {
      if(var2.getAction().equals("android.intent.action.USER_PRESENT")) {
         com.nexage.android.a.p.b("NAV", "received Intent.ACTION_USER_PRESENT");
         NexageAdView.b(this.a, true);
         this.a.a(true);
      } else if(var2.getAction().equals("android.intent.action.SCREEN_OFF")) {
         com.nexage.android.a.p.b("NAV", "received Intent.ACTION_SCREEN_OFF");
         NexageAdView.b(this.a, false);
         return;
      }

   }
}
