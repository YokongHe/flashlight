package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.iu;
import com.flurry.sdk.je;
import com.flurry.sdk.jn;
import com.flurry.sdk.jn$a;
import com.flurry.sdk.jn$b;
import com.flurry.sdk.jr;
import com.flurry.sdk.ne;
import com.flurry.sdk.ng;
import com.flurry.sdk.qs;

abstract class jn$c extends jn {
   protected int i;

   protected jn$c(iu var1, iq var2, ne var3, ng var4, jr var5, qs var6, je var7, int var8) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.i = var8;
   }

   protected jn$c(jn$c var1, jn$a var2, ng var3) {
      super(var1, var2, var3);
      this.i = var1.i;
   }

   static int d(Class var0) {
      Enum[] var5 = (Enum[])var0.getEnumConstants();
      int var3 = var5.length;
      int var2 = 0;

      int var1;
      for(var1 = 0; var2 < var3; ++var2) {
         Enum var4 = var5[var2];
         if(((jn$b)var4).a()) {
            var1 |= ((jn$b)var4).b();
         }
      }

      return var1;
   }

   @Deprecated
   public void a(jn$b var1) {
      this.i &= ~var1.b();
   }

   @Deprecated
   public void a(jn$b var1, boolean var2) {
      if(var2) {
         this.b(var1);
      } else {
         this.a(var1);
      }
   }

   @Deprecated
   public void b(jn$b var1) {
      this.i |= var1.b();
   }
}
