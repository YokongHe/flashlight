package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.mc;
import java.math.BigDecimal;

@kb
public class lz$a extends mc {
   public lz$a() {
      super(BigDecimal.class);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public BigDecimal b(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 != hm.i && var3 != hm.j) {
         if(var3 == hm.h) {
            String var5 = var1.k().trim();
            if(var5.length() == 0) {
               return null;
            } else {
               try {
                  BigDecimal var6 = new BigDecimal(var5);
                  return var6;
               } catch (IllegalArgumentException var4) {
                  throw var2.b(this.q, "not a valid representation");
               }
            }
         } else {
            throw var2.a(this.q, var3);
         }
      } else {
         return var1.y();
      }
   }
}
