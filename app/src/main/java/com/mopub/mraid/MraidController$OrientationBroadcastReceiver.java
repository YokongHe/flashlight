package com.mopub.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;

@VisibleForTesting
class MraidController$OrientationBroadcastReceiver extends BroadcastReceiver {
   private Context mContext;
   private int mLastRotation;
   // $FF: synthetic field
   final MraidController this$0;

   MraidController$OrientationBroadcastReceiver(MraidController var1) {
      this.this$0 = var1;
      this.mLastRotation = -1;
   }

   public void onReceive(Context var1, Intent var2) {
      if(this.mContext != null && "android.intent.action.CONFIGURATION_CHANGED".equals(var2.getAction())) {
         int var3 = MraidController.access$2(this.this$0);
         if(var3 != this.mLastRotation) {
            this.mLastRotation = var3;
            this.this$0.handleOrientationChange(this.mLastRotation);
            return;
         }
      }

   }

   public void register(Context var1) {
      this.mContext = var1;
      this.mContext.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
   }

   public void unregister() {
      if(this.mContext != null) {
         this.mContext.unregisterReceiver(this);
         this.mContext = null;
      }

   }
}
