package com.flurry.sdk;

import com.flurry.sdk.dm;
import com.flurry.sdk.dm$b;
import java.util.TimerTask;

class dm$a extends TimerTask {
   // $FF: synthetic field
   final dm a;
   private dm$b b;

   dm$a(dm var1, dm$b var2) {
      this.a = var1;
      this.b = var2;
   }

   public void run() {
      this.a.a();
      if(this.b != null) {
         this.b.q();
      }

   }
}
