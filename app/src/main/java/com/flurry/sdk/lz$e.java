package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.lz$k;

@kb
public final class lz$e extends lz$k {
   public lz$e(Class var1, Character var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final Character b(hj var1, iz var2) {
      hm var4 = var1.e();
      if(var4 == hm.i) {
         int var3 = var1.t();
         if(var3 >= 0 && var3 <= '\uffff') {
            return Character.valueOf((char)var3);
         }
      } else if(var4 == hm.h) {
         String var5 = var1.k();
         if(var5.length() == 1) {
            return Character.valueOf(var5.charAt(0));
         }

         if(var5.length() == 0) {
            return (Character)this.c();
         }
      }

      throw var2.a(this.q, var4);
   }
}
