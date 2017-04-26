package com.tapjoy.internal;

public final class ci implements Runnable {
   private final com.tapjoy.internal.cg a;
   private final com.tapjoy.internal.cl b;

   protected ci(com.tapjoy.internal.cg var1, com.tapjoy.internal.cl var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void run() {
      com.tapjoy.internal.cl var1;
      com.tapjoy.internal.cg var3;
      Object var4;
      try {
         var4 = this.a.f();
      } catch (Throwable var2) {
         if(this.b == null) {
            return;
         }

         if(this.b instanceof com.tapjoy.internal.cm) {
            var1 = this.b;
            var3 = this.a;
            return;
         }

         this.b.a(this.a);
         return;
      }

      if(this.b != null) {
         if(!(this.b instanceof com.tapjoy.internal.cm)) {
            this.b.a(this.a, var4);
            return;
         }

         var1 = this.b;
         var3 = this.a;
      }

   }
}
