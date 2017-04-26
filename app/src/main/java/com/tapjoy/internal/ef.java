package com.tapjoy.internal;

import com.tapjoy.internal.fc;
import java.util.concurrent.CountDownLatch;

class ef implements Runnable {
   private fc a = null;
   private CountDownLatch b = null;

   public ef(fc var1) {
      this.a = var1;
      this.b = null;
   }

   public void run() {
      this.a.e();
      if(this.b != null) {
         this.b.countDown();
      }

   }
}
