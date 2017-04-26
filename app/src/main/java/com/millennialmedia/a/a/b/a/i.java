package com.millennialmedia.a.a.b.a;

import java.util.ArrayList;

public final class i extends com.millennialmedia.a.a.s {
   public static final com.millennialmedia.a.a.t a = new com.millennialmedia.a.a.t() {
      public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
         return var2.a() == Object.class?new i(var1, (byte)0):null;
      }
   };
   private final com.millennialmedia.a.a.e b;

   private i(com.millennialmedia.a.a.e var1) {
      this.b = var1;
   }

   // $FF: synthetic method
   i(com.millennialmedia.a.a.e var1, byte var2) {
      this(var1);
   }

   public final Object a(com.millennialmedia.a.a.d.a var1) {
      com.millennialmedia.a.a.d.b var2 = var1.f();
      switch(null.a[var2.ordinal()]) {
      case 1:
         ArrayList var4 = new ArrayList();
         var1.a();

         while(var1.e()) {
            var4.add(this.a(var1));
         }

         var1.b();
         return var4;
      case 2:
         com.millennialmedia.a.a.b.j var3 = new com.millennialmedia.a.a.b.j();
         var1.c();

         while(var1.e()) {
            var3.put(var1.g(), this.a(var1));
         }

         var1.d();
         return var3;
      case 3:
         return var1.h();
      case 4:
         return Double.valueOf(var1.k());
      case 5:
         return Boolean.valueOf(var1.i());
      case 6:
         var1.j();
         return null;
      default:
         throw new IllegalStateException();
      }
   }

   public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
      if(var2 == null) {
         var1.f();
      } else {
         com.millennialmedia.a.a.s var3 = this.b.a(var2.getClass());
         if(var3 instanceof i) {
            var1.d();
            var1.e();
         } else {
            var3.a(var1, var2);
         }
      }
   }
}
