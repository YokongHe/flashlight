package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.mc;
import java.math.BigInteger;

@kb
public class lz$b extends mc {
   public lz$b() {
      super(BigInteger.class);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public BigInteger b(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 == hm.i) {
         switch(null.b[var1.q().ordinal()]) {
         case 1:
         case 2:
            return BigInteger.valueOf(var1.u());
         }
      } else {
         if(var3 == hm.j) {
            return var1.y().toBigInteger();
         }

         if(var3 != hm.h) {
            throw var2.a(this.q, var3);
         }
      }

      String var5 = var1.k().trim();
      if(var5.length() == 0) {
         return null;
      } else {
         try {
            BigInteger var6 = new BigInteger(var5);
            return var6;
         } catch (IllegalArgumentException var4) {
            throw var2.b(this.q, "not a valid representation");
         }
      }
   }
}
