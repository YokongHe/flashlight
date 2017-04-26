package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pw;

@kb
public final class py$d extends pw {
   public py$d() {
      super(char[].class);
   }

   private final void a(hf var1, char[] var2) {
      int var3 = 0;

      for(int var4 = var2.length; var3 < var4; ++var3) {
         var1.a(var2, var3, 1);
      }

   }

   public final void a(char[] var1, hf var2, jw var3) {
      if(var3.a(ju$a.s)) {
         var2.b();
         this.a(var2, var1);
         var2.c();
      } else {
         var2.a(var1, 0, var1.length);
      }
   }

   public final void a(char[] var1, hf var2, jw var3, jz var4) {
      if(var3.a(ju$a.s)) {
         var4.c(var1, var2);
         this.a(var2, var1);
         var4.f(var1, var2);
      } else {
         var4.a(var1, var2);
         var2.a(var1, 0, var1.length);
         var4.d(var1, var2);
      }
   }
}
