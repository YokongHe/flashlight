package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.ma;
import com.flurry.sdk.mr;
import com.flurry.sdk.qy;
import com.flurry.sdk.ra;

final class ma$g extends ma {
   protected final ra b;
   protected final mr c;

   protected ma$g(ra var1, mr var2) {
      super(var1.a());
      this.b = var1;
      this.c = var2;
   }

   public final Object b(String var1, iz var2) {
      Object var3;
      if(this.c != null) {
         try {
            var3 = this.c.a((Object)var1);
            return var3;
         } catch (Exception var5) {
            qy.c((Throwable)var5);
         }
      }

      Enum var4 = this.b.a(var1);
      var3 = var4;
      if(var4 == null) {
         throw var2.a(this.a, var1, "not one of values for Enum class");
      } else {
         return var3;
      }
   }
}
