package com.flurry.sdk;

import com.flurry.sdk.jk;
import com.flurry.sdk.ov;
import com.flurry.sdk.ov$f;

final class ov$c extends ov {
   private final ov$f[] a;

   public ov$c(ov$f[] var1) {
      this.a = var1;
   }

   public final jk a(Class var1) {
      int var2 = 0;

      for(int var3 = this.a.length; var2 < var3; ++var2) {
         ov$f var4 = this.a[var2];
         if(var4.a == var1) {
            return var4.b;
         }
      }

      return null;
   }

   public final ov a(Class var1, jk var2) {
      int var3 = this.a.length;
      if(var3 == 8) {
         return this;
      } else {
         ov$f[] var4 = new ov$f[var3 + 1];
         System.arraycopy(this.a, 0, var4, 0, var3);
         var4[var3] = new ov$f(var1, var2);
         return new ov$c(var4);
      }
   }
}
