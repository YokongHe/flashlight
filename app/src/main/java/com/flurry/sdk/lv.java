package com.flurry.sdk;

import com.flurry.sdk.hh;
import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.lk;
import com.flurry.sdk.lv$a;
import com.flurry.sdk.lv$b;
import com.flurry.sdk.rj;
import com.flurry.sdk.rw;

public class lv extends lk {
   private static final lv a = new lv();

   protected lv() {
      super(hh.class);
   }

   public static jg a(Class var0) {
      return (jg)(var0 == rw.class?lv$b.d():(var0 == rj.class?lv$a.d():a));
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public hh b(hj var1, iz var2) {
      switch(null.a[var1.e().ordinal()]) {
      case 1:
         return this.a(var1, var2, var2.e());
      case 2:
         return this.b(var1, var2, var2.e());
      default:
         return this.c(var1, var2, var2.e());
      }
   }
}
