package com.inmobi.commons.analytics.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.inmobi.commons.analytics.net.AnalyticsConnectivityReceiver$a;

public class AnalyticsConnectivityReceiver extends BroadcastReceiver {
   private AnalyticsConnectivityReceiver$a a;
   private boolean b;

   public AnalyticsConnectivityReceiver(Context var1, AnalyticsConnectivityReceiver$a var2) {
      this.a = var2;
      this.bind(var1);
   }

   public final void bind(Context var1) {
      IntentFilter var2 = new IntentFilter();
      var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var1.registerReceiver(this, var2);
   }

   public boolean isConnected() {
      return this.b;
   }

   public void onReceive(Context var1, Intent var2) {
      if(var2.getBooleanExtra("noConnectivity", false)) {
         this.b = false;
         if(this.a != null) {
            this.a.b();
         }
      } else if(!var2.getBooleanExtra("noConnectivity", false)) {
         this.b = true;
         if(this.a != null) {
            this.a.a();
            return;
         }
      }

   }

   public void unbind(Context var1) {
      var1.unregisterReceiver(this);
   }
}
