package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.au$a;
import java.net.URL;

public final class gp {
   public static final com.tapjoy.internal.bo b;
   private static final com.tapjoy.internal.as c;
   public URL a;
   private Bitmap d;

   static {
      Object var0 = new com.tapjoy.internal.aw();
      if(!(var0 instanceof com.tapjoy.internal.ax)) {
         var0 = new au$a((com.tapjoy.internal.av)var0);
      }

      c = (com.tapjoy.internal.as)var0;
      b = new com.tapjoy.internal.bo() {
         // $FF: synthetic method
         public final Object a(com.tapjoy.internal.bt var1) {
            return new gp(var1);
         }
      };
   }

   gp(com.tapjoy.internal.bt var1) {
      if(var1.b()) {
         this.a = var1.f();
      } else {
         var1.i();
         String var2 = var1.m();

         while(var1.k()) {
            if("url".equals(var2)) {
               this.a = var1.f();
            } else {
               var1.t();
            }
         }

         var1.j();
      }
   }

   public final Bitmap a() {
      return this.d;
   }

   public final void b() {
      this.d = (Bitmap)c.a(this.a);
      if(this.d == null) {
         com.tapjoy.internal.u var1 = com.tapjoy.internal.u.a;
         this.d = com.tapjoy.internal.u.a(this.a.openConnection());
         c.a(this.a, this.d);
      }

   }
}
