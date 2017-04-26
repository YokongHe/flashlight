package com.inneractive.api.ads.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.inneractive.api.ads.sdk.IAmraidWebViewController;

final class IAmraidWebViewController$b extends BroadcastReceiver {
   private Context mContext;
   private int mLastRotation;
   // $FF: synthetic field
   final IAmraidWebViewController this$0;

   IAmraidWebViewController$b(IAmraidWebViewController var1) {
      this.this$0 = var1;
   }

   private boolean isRegistered() {
      return this.mContext != null;
   }

   public final void onReceive(Context var1, Intent var2) {
      if(this.isRegistered() && "android.intent.action.CONFIGURATION_CHANGED".equals(var2.getAction())) {
         int var3 = an.c(var1);
         if(var3 != this.mLastRotation) {
            this.mLastRotation = var3;
            IAmraidWebViewController.access$700(this.this$0, this.mLastRotation);
            return;
         }
      }

   }

   final void register(Context var1) {
      this.mContext = var1;
      var1.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
   }

   final void unregister() {
      if(this.mContext != null) {
         this.mContext.unregisterReceiver(this);
         this.mContext = null;
      }

   }
}
