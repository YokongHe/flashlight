package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.is$a;
import com.flurry.sdk.iy;
import com.flurry.sdk.iz;
import com.flurry.sdk.jc;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.jl;
import com.flurry.sdk.js;
import com.flurry.sdk.jy;
import com.flurry.sdk.kb;
import com.flurry.sdk.kt;
import com.flurry.sdk.kx;
import com.flurry.sdk.ld;
import com.flurry.sdk.lf;
import com.flurry.sdk.lo;
import com.flurry.sdk.qv;
import com.flurry.sdk.qw;
import com.flurry.sdk.sh;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

@kb
public class lw extends lo implements js {
   protected final sh a;
   protected final jl b;
   protected final jg c;
   protected final jy d;
   protected final kx e;
   protected final boolean f;
   protected ld g;
   protected jg h;
   protected HashSet i;

   public lw(sh var1, kx var2, jl var3, jg var4, jy var5) {
      super(Map.class);
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var2;
      if(var2.j()) {
         this.g = new ld(var2);
      } else {
         this.g = null;
      }

      this.f = var2.h();
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Object a(hj var1, iz var2, jy var3) {
      return var3.a(var1, var2);
   }

   public Map a(hj var1, iz var2, Map var3) {
      hm var4 = var1.e();
      if(var4 != hm.b && var4 != hm.f) {
         throw var2.b(this.e());
      } else {
         this.b(var1, var2, var3);
         return var3;
      }
   }

   public void a(iy var1, jc var2) {
      if(this.e.i()) {
         sh var3 = this.e.l();
         if(var3 == null) {
            throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.a + ": value instantiator (" + this.e.getClass().getName() + ") returned true for \'canCreateUsingDelegate()\', but null for \'getDelegateType()\'");
         }

         this.h = this.a(var1, var2, var3, new is$a((String)null, var3, (qv)null, this.e.o()));
      }

      if(this.g != null) {
         Iterator var5 = this.g.a().iterator();

         while(var5.hasNext()) {
            kt var4 = (kt)var5.next();
            if(!var4.f()) {
               this.g.a(var4, this.a(var1, var2, var4.a(), var4));
            }
         }
      }

   }

   protected void a(Throwable var1, Object var2) {
      while(var1 instanceof InvocationTargetException && var1.getCause() != null) {
         var1 = var1.getCause();
      }

      if(var1 instanceof Error) {
         throw (Error)var1;
      } else if(var1 instanceof IOException && !(var1 instanceof jh)) {
         throw (IOException)var1;
      } else {
         throw jh.a((Throwable)var1, (Object)var2, (String)null);
      }
   }

   public void a(String[] var1) {
      HashSet var2;
      if(var1 != null && var1.length != 0) {
         var2 = qw.a(var1);
      } else {
         var2 = null;
      }

      this.i = var2;
   }

   public Map b(hj var1, iz var2) {
      if(this.g != null) {
         return this.c(var1, var2);
      } else if(this.h != null) {
         return (Map)this.e.a(this.h.a(var1, var2));
      } else if(!this.f) {
         throw var2.a(this.e(), "No default constructor found");
      } else {
         hm var3 = var1.e();
         if(var3 != hm.b && var3 != hm.f && var3 != hm.c) {
            if(var3 == hm.h) {
               return (Map)this.e.a(var1.k());
            } else {
               throw var2.b(this.e());
            }
         } else {
            Map var4 = (Map)this.e.m();
            this.b(var1, var2, var4);
            return var4;
         }
      }
   }

   protected final void b(hj var1, iz var2, Map var3) {
      hm var5 = var1.e();
      hm var4 = var5;
      if(var5 == hm.b) {
         var4 = var1.b();
      }

      jl var11 = this.b;
      jg var6 = this.c;

      for(jy var7 = this.d; var4 == hm.f; var4 = var1.b()) {
         String var10 = var1.g();
         Object var8 = var11.a(var10, var2);
         hm var9 = var1.b();
         if(this.i != null && this.i.contains(var10)) {
            var1.d();
         } else {
            Object var12;
            if(var9 == hm.m) {
               var12 = null;
            } else if(var7 == null) {
               var12 = var6.a(var1, var2);
            } else {
               var12 = var6.a(var1, var2, var7);
            }

            var3.put(var8, var12);
         }
      }

   }

   public Map c(hj var1, iz var2) {
      ld var5 = this.g;
      lf var6 = var5.a(var1, var2);
      hm var4 = var1.e();
      hm var3 = var4;
      if(var4 == hm.b) {
         var3 = var1.b();
      }

      jg var12 = this.c;

      for(jy var7 = this.d; var3 == hm.f; var3 = var1.b()) {
         String var8 = var1.g();
         var3 = var1.b();
         if(this.i != null && this.i.contains(var8)) {
            var1.d();
         } else {
            kt var15 = var5.a(var8);
            Object var13;
            if(var15 != null) {
               var13 = var15.a(var1, var2);
               if(var6.a(var15.j(), var13)) {
                  var1.b();

                  Map var14;
                  try {
                     var14 = (Map)var5.a(var6);
                  } catch (Exception var9) {
                     this.a((Throwable)var9, (Object)this.a.p());
                     return null;
                  }

                  this.b(var1, var2, var14);
                  return var14;
               }
            } else {
               var8 = var1.g();
               Object var16 = this.b.a(var8, var2);
               if(var3 == hm.m) {
                  var13 = null;
               } else if(var7 == null) {
                  var13 = var12.a(var1, var2);
               } else {
                  var13 = var12.a(var1, var2, var7);
               }

               var6.a(var16, var13);
            }
         }
      }

      try {
         Map var11 = (Map)var5.a(var6);
         return var11;
      } catch (Exception var10) {
         this.a((Throwable)var10, (Object)this.a.p());
         return null;
      }
   }

   public jg d() {
      return this.c;
   }

   public final Class e() {
      return this.a.p();
   }
}
