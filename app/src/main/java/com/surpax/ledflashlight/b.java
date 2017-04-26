package com.surpax.ledflashlight;

import android.content.Intent;
import android.util.Log;
import com.surpax.ledflashlight.StartLightReceiverLarge;

final class b implements Runnable {
   // $FF: synthetic field
   final StartLightReceiverLarge a;

   private b(StartLightReceiverLarge var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   b(StartLightReceiverLarge var1, byte var2) {
      this(var1);
   }

   public final void run() {
      try {
         com.surpax.a.a.H = 3;
         Log.d("ihswidget", "from index = " + com.surpax.a.a.H);
         Intent var1 = new Intent();
         var1.setClassName(this.a.a, "com.surpax.ledflashlight.FlashlightActivity");
         var1.setFlags(268435456);
         this.a.a.startActivity(var1);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
