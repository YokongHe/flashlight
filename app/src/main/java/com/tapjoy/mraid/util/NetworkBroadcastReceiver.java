package com.tapjoy.mraid.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.mraid.controller.Network;

public class NetworkBroadcastReceiver extends BroadcastReceiver {
   private Network a;

   public NetworkBroadcastReceiver(Network var1) {
      this.a = var1;
   }

   public void onReceive(Context var1, Intent var2) {
      if(var2.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
         this.a.onConnectionChanged();
      }

   }
}
