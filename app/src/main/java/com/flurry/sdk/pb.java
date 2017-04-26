package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.ov;
import com.flurry.sdk.ov$d;
import com.flurry.sdk.pf;
import com.flurry.sdk.sh;

public abstract class pb extends pf implements jt {
   protected final boolean a;
   protected final sh b;
   protected final jz c;
   protected jk d;
   protected final is e;
   protected ov f;

   protected pb(Class var1, sh var2, boolean var3, jz var4, is var5, jk var6) {
      label14: {
         boolean var7 = false;
         super(var1, false);
         this.b = var2;
         if(!var3) {
            var3 = var7;
            if(var2 == null) {
               break label14;
            }

            var3 = var7;
            if(!var2.u()) {
               break label14;
            }
         }

         var3 = true;
      }

      this.a = var3;
      this.c = var4;
      this.e = var5;
      this.d = var6;
      this.f = ov.a();
   }

   protected final jk a(ov var1, sh var2, jw var3) {
      ov$d var4 = var1.a(var2, var3, this.e);
      if(var1 != var4.b) {
         this.f = var4.b;
      }

      return var4.a;
   }

   protected final jk a(ov var1, Class var2, jw var3) {
      ov$d var4 = var1.a(var2, var3, this.e);
      if(var1 != var4.b) {
         this.f = var4.b;
      }

      return var4.a;
   }

   public void a(jw var1) {
      if(this.a && this.b != null && this.d == null) {
         this.d = var1.a(this.b, this.e);
      }

   }

   public final void a(Object var1, hf var2, jw var3) {
      var2.b();
      this.b(var1, var2, var3);
      var2.c();
   }

   public final void a(Object var1, hf var2, jw var3, jz var4) {
      var4.c(var1, var2);
      this.b(var1, var2, var3);
      var4.f(var1, var2);
   }

   protected abstract void b(Object var1, hf var2, jw var3);
}
