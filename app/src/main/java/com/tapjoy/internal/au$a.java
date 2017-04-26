package com.tapjoy.internal;

public final class au$a implements com.tapjoy.internal.ax {
   private final com.tapjoy.internal.av a;

   public au$a(com.tapjoy.internal.av var1) {
      this.a = var1;
   }

   public final Object a(Object var1) {
      com.tapjoy.internal.av var2 = this.a;
      com.tapjoy.internal.at var5;
      synchronized(var2) {
         var5 = this.a.a(var1, false);
      }

      if(var5 != null) {
         synchronized(var5) {
            Object var6 = var5.a();
            return var6;
         }
      } else {
         return null;
      }
   }

   public final void a(Object var1, Object var2) {
      com.tapjoy.internal.av var3 = this.a;
      com.tapjoy.internal.at var6;
      synchronized(var3) {
         var6 = this.a.a(var1, true);
      }

      synchronized(var6) {
         var6.a(var2);
      }
   }
}
