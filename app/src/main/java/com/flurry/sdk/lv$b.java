package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.lk;
import com.flurry.sdk.rw;

final class lv$b extends lk {
   protected static final lv$b a = new lv$b();

   protected lv$b() {
      super(rw.class);
   }

   public static lv$b d() {
      return a;
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final rw b(hj var1, iz var2) {
      if(var1.e() == hm.b) {
         var1.b();
         return this.a(var1, var2, var2.e());
      } else if(var1.e() == hm.f) {
         return this.a(var1, var2, var2.e());
      } else {
         throw var2.b(rw.class);
      }
   }
}
