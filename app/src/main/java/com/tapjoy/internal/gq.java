package com.tapjoy.internal;

import com.tapjoy.internal.fo;
import com.tapjoy.internal.gi;

final class gq extends gi implements fo {
   public static final com.tapjoy.internal.bo a = new com.tapjoy.internal.bo() {
      // $FF: synthetic method
      public final Object a(com.tapjoy.internal.bt var1) {
         String var5 = null;
         int var2 = 1;
         var1.i();
         String var4 = null;
         String var3 = null;

         while(var1.k()) {
            String var6 = var1.m();
            if("id".equals(var6)) {
               var3 = var1.n();
            } else if("name".equals(var6)) {
               var4 = var1.n();
            } else if("quantity".equals(var6)) {
               var2 = var1.s();
            } else if("token".equals(var6)) {
               var5 = var1.n();
            } else {
               var1.t();
            }
         }

         var1.j();
         return new gq(var3, var4, var2, var5);
      }
   };
   private final String b;
   private final String c;
   private final int d;
   private final String e;

   gq(String var1, String var2, int var3, String var4) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
   }

   public final String a() {
      return this.b;
   }

   public final String b() {
      return this.c;
   }

   public final int c() {
      return this.d;
   }

   public final String d() {
      return this.e;
   }
}
