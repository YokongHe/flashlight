package com.facebook.ads.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import java.util.Map;

class ac$b extends BroadcastReceiver {
   // $FF: synthetic field
   final com.facebook.ads.a.ac a;

   private ac$b(com.facebook.ads.a.ac var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   ac$b(com.facebook.ads.a.ac var1, Object var2) {
      this(var1);
   }

   public void a() {
      IntentFilter var1 = new IntentFilter();
      var1.addAction("com.facebook.ads.native.impression:" + com.facebook.ads.a.ac.access$1200(this.a));
      var1.addAction("com.facebook.ads.native.click:" + com.facebook.ads.a.ac.access$1200(this.a));
      LocalBroadcastManager.getInstance(com.facebook.ads.a.ac.access$800(this.a)).registerReceiver(this, var1);
   }

   public void b() {
      try {
         LocalBroadcastManager.getInstance(com.facebook.ads.a.ac.access$800(this.a)).unregisterReceiver(this);
      } catch (Exception var2) {
         ;
      }
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction().split(":")[0];
      if("com.facebook.ads.native.impression".equals(var3)) {
         com.facebook.ads.a.ac.access$1100(this.a).d();
      } else if("com.facebook.ads.native.click".equals(var3)) {
         com.facebook.ads.a.ac.access$200(this.a).a(var1, (Map)null, true);
         return;
      }

   }
}
