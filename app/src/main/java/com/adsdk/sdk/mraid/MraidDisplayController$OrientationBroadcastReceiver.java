package com.adsdk.sdk.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.adsdk.sdk.mraid.MraidDisplayController;

class MraidDisplayController$OrientationBroadcastReceiver extends BroadcastReceiver {
   private Context mContext;
   private int mLastRotation;
   // $FF: synthetic field
   final MraidDisplayController this$0;

   MraidDisplayController$OrientationBroadcastReceiver(MraidDisplayController var1) {
      this.this$0 = var1;
   }

   private boolean isRegistered() {
      return this.mContext != null;
   }

   public void onReceive(Context var1, Intent var2) {
      if(this.isRegistered() && var2.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
         int var3 = MraidDisplayController.access$3(this.this$0);
         if(var3 != this.mLastRotation) {
            this.mLastRotation = var3;
            MraidDisplayController.access$4(this.this$0, this.mLastRotation);
            return;
         }
      }

   }

   public void register(Context var1) {
      this.mContext = var1;
      var1.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
   }

   public void unregister() {
      this.mContext.unregisterReceiver(this);
      this.mContext = null;
   }
}
