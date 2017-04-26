package com.tapjoy.internal;

import com.tapjoy.internal.ek;

final class ep extends Thread {
   private Runnable a = null;

   public ep(Runnable var1) {
      this.a = var1;
   }

   public final ek a() {
      return this.a instanceof ek?(ek)this.a:null;
   }

   public final void interrupt() {
      if(this.a instanceof ek) {
         ((ek)this.a).c();
      }

      super.interrupt();
   }

   public final void run() {
      this.a.run();
   }
}
