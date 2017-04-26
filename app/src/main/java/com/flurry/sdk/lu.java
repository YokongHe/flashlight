package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.mc;
import com.flurry.sdk.sh;

public class lu extends mc {
   public lu() {
      super(sh.class);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public sh b(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 == hm.h) {
         String var4 = var1.k().trim();
         return var4.length() == 0?(sh)this.c():var2.f().b(var4);
      } else if(var3 == hm.g) {
         return (sh)var1.z();
      } else {
         throw var2.b(this.q);
      }
   }
}
