package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jh;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.of;
import com.flurry.sdk.oh;
import com.flurry.sdk.oi;
import com.flurry.sdk.on;
import com.flurry.sdk.pf;
import com.flurry.sdk.pw;
import com.flurry.sdk.sh;

public abstract class pc extends pw implements jt {
   protected static final oi[] a = new oi[0];
   protected final oi[] b;
   protected final oi[] c;
   protected final of d;
   protected final Object e;

   protected pc(pc var1) {
      this(var1.k, var1.b, var1.c, var1.d, var1.e);
   }

   protected pc(sh var1, oi[] var2, oi[] var3, of var4, Object var5) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public pc(Class var1, oi[] var2, oi[] var3, of var4, Object var5) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public void a(jw var1) {
      int var2;
      if(this.c == null) {
         var2 = 0;
      } else {
         var2 = this.c.length;
      }

      int var4 = this.b.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         oi var8 = this.b[var3];
         if(!var8.e()) {
            sh var5 = var8.f();
            sh var6 = var5;
            if(var5 == null) {
               var5 = var1.a(var8.g());
               var6 = var5;
               if(!var5.u()) {
                  if(var5.f() || var5.h() > 0) {
                     var8.a(var5);
                  }
                  continue;
               }
            }

            jk var7 = var1.a((sh)var6, (is)var8);
            Object var9 = var7;
            if(var6.f()) {
               jz var10 = (jz)var6.g().o();
               var9 = var7;
               if(var10 != null) {
                  var9 = var7;
                  if(var7 instanceof pf) {
                     var9 = ((pf)var7).b(var10);
                  }
               }
            }

            oi var11 = var8.a((jk)var9);
            this.b[var3] = var11;
            if(var3 < var2) {
               var11 = this.c[var3];
               if(var11 != null) {
                  this.c[var3] = var11.a((jk)var9);
               }
            }
         }
      }

      if(this.d != null) {
         this.d.a(var1);
      }

   }

   public void a(Object var1, hf var2, jw var3, jz var4) {
      var4.b(var1, var2);
      if(this.e != null) {
         this.c(var1, var2, var3);
      } else {
         this.b(var1, var2, var3);
      }

      var4.e(var1, var2);
   }

   protected oh b(jw var1) {
      Object var2 = this.e;
      on var3 = var1.b();
      if(var3 == null) {
         throw new jh("Can not resolve BeanPropertyFilter with id \'" + var2 + "\'; no FilterProvider configured");
      } else {
         return var3.a(var2);
      }
   }

   protected void b(Object param1, hf param2, jw param3) {
      // $FF: Couldn't be decompiled
   }

   protected void c(Object param1, hf param2, jw param3) {
      // $FF: Couldn't be decompiled
   }
}
