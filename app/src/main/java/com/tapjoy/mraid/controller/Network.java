package com.tapjoy.mraid.controller;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.util.NetworkBroadcastReceiver;
import com.tapjoy.mraid.view.MraidView;

public class Network extends Abstract {
   private ConnectivityManager c;
   private int d;
   private NetworkBroadcastReceiver e;
   private IntentFilter f;

   public Network(MraidView var1, Context var2) {
      super(var1, var2);
      this.c = (ConnectivityManager)var2.getSystemService("connectivity");
   }

   public String getNetwork() {
      NetworkInfo var2 = null;

      label28: {
         NetworkInfo var3;
         try {
            var3 = this.c.getActiveNetworkInfo();
         } catch (Exception var4) {
            var4.printStackTrace();
            break label28;
         }

         var2 = var3;
      }

      String var5;
      if(var2 == null) {
         var5 = "offline";
      } else {
         switch(null.a[var2.getState().ordinal()]) {
         case 1:
            var5 = "unknown";
            break;
         case 2:
            var5 = "offline";
            break;
         default:
            int var1 = var2.getType();
            if(var1 == 0) {
               var5 = "cell";
            } else if(var1 == 1) {
               var5 = "wifi";
            } else {
               var5 = "unknown";
            }
         }
      }

      TapjoyLog.d("MRAID Network", "getNetwork: " + var5);
      return var5;
   }

   public void onConnectionChanged() {
      String var1 = "window.mraidview.fireChangeEvent({ network: \'" + this.getNetwork() + "\'});";
      TapjoyLog.d("MRAID Network", var1);
      this.a.injectMraidJavaScript(var1);
   }

   public void startNetworkListener() {
      if(this.d == 0) {
         this.e = new NetworkBroadcastReceiver(this);
         this.f = new IntentFilter();
         this.f.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      }

      ++this.d;
      this.b.registerReceiver(this.e, this.f);
   }

   public void stopAllListeners() {
      this.d = 0;

      try {
         this.b.unregisterReceiver(this.e);
      } catch (Exception var2) {
         ;
      }
   }

   public void stopNetworkListener() {
      --this.d;
      if(this.d == 0) {
         this.b.unregisterReceiver(this.e);
         this.e = null;
         this.f = null;
      }

   }
}
