package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tapjoy.internal.fx;

public class GCMReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      boolean var3 = fx.a(var1).a((Intent)var2);
      if(this.isOrderedBroadcast()) {
         this.setResult(-1, (String)null, (Bundle)null);
         if(var3) {
            this.abortBroadcast();
         }
      }

   }
}
