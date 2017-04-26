package com.surpax.ledflashlight;

import android.content.Intent;
import android.util.Log;
import com.surpax.ledflashlight.StartLightReceiver;

final class a implements Runnable {
   // $FF: synthetic field
   final StartLightReceiver a;

   private a(StartLightReceiver var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   a(StartLightReceiver var1, byte var2) {
      this(var1);
   }

   public final void run() {
      try {
         com.surpax.a.a.H = 1;
         Log.d("ihsflashlight", "from index = " + com.surpax.a.a.H);
         Intent var1 = new Intent();
         var1.setClassName(this.a.a, "com.surpax.ledflashlight.FlashlightActivity");
         var1.setFlags(268435456);
         this.a.a.startActivity(var1);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
