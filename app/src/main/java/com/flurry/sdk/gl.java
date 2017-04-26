package com.flurry.sdk;

import com.flurry.sdk.fl;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.gb;
import com.flurry.sdk.gf;
import com.flurry.sdk.gg;
import com.flurry.sdk.gm;
import com.flurry.sdk.go;
import com.flurry.sdk.gq;
import com.flurry.sdk.gq$a;
import com.flurry.sdk.gq$b;
import com.flurry.sdk.gq$c;
import com.flurry.sdk.gq$d;
import com.flurry.sdk.gq$e;
import com.flurry.sdk.gq$k;
import com.flurry.sdk.gq$n;
import com.flurry.sdk.gq$p;
import com.flurry.sdk.gq$q;

public class gl extends gm {
   // $FF: synthetic field
   static final boolean b;
   private gf d;

   static {
      boolean var0;
      if(!gl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      b = var0;
   }

   gl(fn var1, fn var2, gf var3) {
      this(a(var1, var2), var3);
   }

   private gl(Object var1, gf var2) {
      super((gq)var1, var2);
   }

   public static Object a(fn var0, fn var1) {
      if(var0 == null) {
         throw new NullPointerException("writer cannot be null!");
      } else if(var1 == null) {
         throw new NullPointerException("reader cannot be null!");
      } else {
         return (new go()).a(var0, var1);
      }
   }

   public gq a(gq var1, gq var2) {
      if(var2 instanceof gq$e) {
         return var1 == gq.s?var2:null;
      } else if(var2 instanceof gq$k) {
         gq$k var5 = (gq$k)var2;
         if(var5.B != var1) {
            throw new fl("Found " + var5.B + " while looking for " + var1);
         } else {
            return var5.z;
         }
      } else {
         if(var2 instanceof gq$n) {
            var1 = ((gq$n)var2).z;
            this.a.d(var1);
         } else if(var2 instanceof gq$q) {
            gq$a var3 = (gq$a)this.a.c();
            this.a.c(var3.a(this.c.s()));
         } else {
            if(var2 instanceof gq$d) {
               throw new fl(((gq$d)var2).z);
            }

            if(var2 instanceof gq$b) {
               gq$b var4 = (gq$b)var2;
               this.d = this.c;
               this.c = gg.a().a((byte[])var4.z, (gb)null);
            } else {
               if(var2 != gq.x) {
                  throw new fl("Unknown action: " + var2);
               }

               this.c = this.d;
            }
         }

         return null;
      }
   }

   public long e() {
      gq var1 = this.a.a(gq.f);
      if(var1 == gq.e) {
         return (long)this.c.d();
      } else if(var1 == gq.h) {
         return (long)this.c.g();
      } else if(!b && var1 != gq.f) {
         throw new AssertionError();
      } else {
         return this.c.e();
      }
   }

   public float f() {
      gq var1 = this.a.a(gq.g);
      if(var1 == gq.e) {
         return (float)this.c.d();
      } else if(var1 == gq.f) {
         return (float)this.c.e();
      } else if(!b && var1 != gq.g) {
         throw new AssertionError();
      } else {
         return this.c.f();
      }
   }

   public double g() {
      gq var1 = this.a.a(gq.h);
      if(var1 == gq.e) {
         return (double)this.c.d();
      } else if(var1 == gq.f) {
         return (double)this.c.e();
      } else if(var1 == gq.g) {
         return (double)this.c.f();
      } else if(!b && var1 != gq.h) {
         throw new AssertionError();
      } else {
         return this.c.g();
      }
   }

   public int k() {
      this.a.a(gq.l);
      gq$c var2 = (gq$c)this.a.c();
      int var1 = this.c.k();
      Object var3 = var2.z[var1];
      if(var3 instanceof Integer) {
         return ((Integer)var3).intValue();
      } else {
         throw new fl((String)var3);
      }
   }

   public void l() {
      gq var1 = this.a.c();
      if(var1 instanceof gq$k) {
         this.a.c(((gq$k)var1).z);
      } else {
         if(var1 instanceof gq$n) {
            this.a.c(((gq$n)var1).z);
            return;
         }

         if(var1 instanceof gq$q) {
            gq$a var3 = (gq$a)this.a.c();
            this.a.c(var3.a(this.c.s()));
            return;
         }

         if(var1 instanceof gq$d) {
            throw new fl(((gq$d)var1).z);
         }

         if(var1 instanceof gq$b) {
            gq$b var2 = (gq$b)var1;
            this.d = this.c;
            this.c = gg.a().a((byte[])var2.z, (gb)null);
            return;
         }

         if(var1 == gq.x) {
            this.c = this.d;
            return;
         }
      }

   }

   public int s() {
      this.a.a(gq.m);
      gq$p var1 = (gq$p)this.a.c();
      this.a.c(var1.B);
      return var1.z;
   }

   public final fn$f[] u() {
      return ((gq$e)this.a.a(gq.s)).z;
   }

   public final void v() {
      this.a.a();
   }
}
