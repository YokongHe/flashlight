package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.lk;
import com.flurry.sdk.rj;

final class lv$a extends lk {
   protected static final lv$a a = new lv$a();

   protected lv$a() {
      super(rj.class);
   }

   public static lv$a d() {
      return a;
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final rj b(hj var1, iz var2) {
      if(var1.j()) {
         return this.b(var1, var2, var2.e());
      } else {
         throw var2.b(rj.class);
      }
   }
}
