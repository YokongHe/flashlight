package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pf;
import com.flurry.sdk.py$a;

@kb
public final class py$j extends py$a implements jt {
   protected jk a;

   public py$j(is var1) {
      super(String[].class, (jz)null, var1);
   }

   private void a(String[] var1, hf var2, jw var3, jk var4) {
      int var5 = 0;

      for(int var6 = var1.length; var5 < var6; ++var5) {
         if(var1[var5] == null) {
            var3.a(var2);
         } else {
            var4.a(var1[var5], var2, var3);
         }
      }

   }

   public final pf a(jz var1) {
      return this;
   }

   public final void a(jw var1) {
      jk var2 = var1.a(String.class, this.f);
      if(var2 != null && var2.getClass().getAnnotation(kb.class) == null) {
         this.a = var2;
      }

   }

   public final void a(String[] var1, hf var2, jw var3) {
      int var5 = var1.length;
      if(var5 != 0) {
         if(this.a != null) {
            this.a(var1, var2, var3, this.a);
            return;
         }

         for(int var4 = 0; var4 < var5; ++var4) {
            if(var1[var4] == null) {
               var2.f();
            } else {
               var2.b(var1[var4]);
            }
         }
      }

   }

   // $FF: synthetic method
   public final void b(Object var1, hf var2, jw var3) {
      this.a((String[])var1, var2, var3);
   }
}
