package com.tapjoy.mraid.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.mraid.controller.Display;

public class ConfigBroadcastReceiver extends BroadcastReceiver {
   private Display a;
   private int b;

   public ConfigBroadcastReceiver(Display var1) {
      this.a = var1;
      this.b = this.a.getOrientation();
   }

   public void onReceive(Context var1, Intent var2) {
      if(var2.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
         int var3 = this.a.getOrientation();
         if(var3 != this.b) {
            this.b = var3;
            this.a.onOrientationChanged(this.b);
         }
      }

   }
}
