package com.tapjoy.internal;

import com.tapjoy.internal.fn;
import com.tapjoy.internal.gi;

final class go extends gi implements fn {
   public static final com.tapjoy.internal.bo a = new com.tapjoy.internal.bo() {
      // $FF: synthetic method
      public final Object a(com.tapjoy.internal.bt var1) {
         String var2 = "";
         String var3 = "";
         var1.i();

         while(var1.k()) {
            String var4 = var1.m();
            if("campaign_id".equals(var4)) {
               var2 = var1.c("");
            } else if("product_id".equals(var4)) {
               var3 = var1.c("");
            } else {
               var1.t();
            }
         }

         var1.j();
         return new go(var2, var3);
      }
   };
   private final String b;
   private final String c;

   go(String var1, String var2) {
      this.b = var1;
      this.c = var2;
   }

   public final String a() {
      return this.b;
   }

   public final String b() {
      return this.c;
   }
}
