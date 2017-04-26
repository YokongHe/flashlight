package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.fr;
import com.flurry.sdk.ft;
import com.flurry.sdk.ft$a;
import com.flurry.sdk.ft$b;
import com.flurry.sdk.fx;
import com.flurry.sdk.ge;
import com.flurry.sdk.gf;
import com.flurry.sdk.gg;
import com.flurry.sdk.gl;
import com.flurry.sdk.gy;
import com.flurry.sdk.gz;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class fu implements ge {
   private static final ThreadLocal f = new ThreadLocal() {
      protected final Map a() {
         return new gz();
      }

      // $FF: synthetic method
      protected final Object initialValue() {
         return this.a();
      }
   };
   private final ft a;
   private fn b;
   private fn c;
   private gl d;
   private final Thread e;

   public fu() {
      this((fn)null, (fn)null, ft.a());
   }

   protected fu(fn var1, fn var2, ft var3) {
      this.d = null;
      this.b = var1;
      this.c = var2;
      this.a = var3;
      this.e = Thread.currentThread();
   }

   public ft a() {
      return this.a;
   }

   protected final gl a(fn var1, fn var2) {
      Thread var6 = Thread.currentThread();
      gl var7;
      if(var6 == this.e && this.d != null) {
         var7 = this.d;
      } else {
         Object var4 = (Map)((Map)f.get()).get(var1);
         if(var4 == null) {
            var4 = new gz();
            ((Map)f.get()).put(var1, var4);
         }

         gl var5 = (gl)((Map)var4).get(var2);
         gl var3 = var5;
         if(var5 == null) {
            var3 = gg.a().a(fn.a(var1, var2), var2, (gf)null);
            ((Map)var4).put(var2, var3);
         }

         var7 = var3;
         if(var6 == this.e) {
            this.d = var3;
            return var3;
         }
      }

      return var7;
   }

   protected Object a(fn var1, gf var2) {
      return this.a((String)var1.c().get(var2.k()), var1);
   }

   protected Object a(Object var1) {
      return var1 instanceof fr?((fr)var1).b():null;
   }

   protected Object a(Object var1, int var2) {
      if(var1 instanceof Map) {
         ((Map)var1).clear();
         return var1;
      } else {
         return new HashMap(var2);
      }
   }

   protected Object a(Object var1, int var2, fn var3) {
      if(var1 instanceof Collection) {
         ((Collection)var1).clear();
         return var1;
      } else {
         return new ft$a(var2, var3);
      }
   }

   protected Object a(Object var1, fn var2, gf var3) {
      fx var4 = (fx)this.a.c(var1, var2);
      var3.b(var4.b(), 0, var2.l());
      return var4;
   }

   protected Object a(Object var1, fn var2, gl var3) {
      switch(null.a[var2.a().ordinal()]) {
      case 1:
         return this.b(var1, var2, var3);
      case 2:
         return this.a((fn)var2, (gf)var3);
      case 3:
         return this.c(var1, var2, var3);
      case 4:
         return this.d(var1, var2, var3);
      case 5:
         return this.a(var1, (fn)var2.k().get(var3.s()), var3);
      case 6:
         return this.a(var1, (fn)var2, (gf)var3);
      case 7:
         return this.b(var1, var2, (gf)var3);
      case 8:
         return this.c(var1, var3);
      case 9:
         return this.c(var1, var2, (gf)var3);
      case 10:
         return Long.valueOf(var3.e());
      case 11:
         return Float.valueOf(var3.f());
      case 12:
         return Double.valueOf(var3.g());
      case 13:
         return Boolean.valueOf(var3.c());
      case 14:
         var3.b();
         return null;
      default:
         throw new fk("Unknown type: " + var2);
      }
   }

   public Object a(Object var1, gf var2) {
      gl var3 = this.a(this.b, this.c);
      var3.a(var2);
      var1 = this.a(var1, this.c, var3);
      var3.v();
      return var1;
   }

   protected Object a(String var1, fn var2) {
      return new ft$b(var2, var1);
   }

   protected void a(Object var1, long var2, Object var4) {
      ((Collection)var1).add(var4);
   }

   protected void a(Object var1, Object var2, Object var3) {
      ((Map)var1).put(var2, var3);
   }

   protected Object b(Object var1, fn var2, gf var3) {
      ft var4 = this.a;
      var4 = this.a;
      return "String".equals(var2.a("avro.java.string"))?var3.h():this.b(var1, var3);
   }

   protected Object b(Object var1, fn var2, gl var3) {
      Object var7 = this.a.d(var1, var2);
      Object var8 = this.a.a(var7, var2);
      fn$f[] var9 = var3.u();
      int var5 = var9.length;

      for(int var4 = 0; var4 < var5; ++var4) {
         fn$f var10 = var9[var4];
         int var6 = var10.b();
         String var11 = var10.a();
         Object var12;
         if(var1 != null) {
            var12 = this.a.b(var7, var11, var6, var8);
         } else {
            var12 = null;
         }

         this.a.a(var7, var11, var6, this.a(var12, var10.c(), var3), var8);
      }

      return var7;
   }

   protected Object b(Object var1, gf var2) {
      gy var3;
      if(var1 instanceof gy) {
         var3 = (gy)var1;
      } else {
         var3 = null;
      }

      return var2.a(var3);
   }

   protected Object c(Object var1, fn var2, gf var3) {
      return Integer.valueOf(var3.d());
   }

   protected Object c(Object var1, fn var2, gl var3) {
      fn var10 = var2.i();
      long var4 = var3.m();
      long var6 = 0L;
      if(var4 <= 0L) {
         return this.a(var1, 0, var2);
      } else {
         var1 = this.a(var1, (int)var4, var2);

         long var8;
         do {
            for(var8 = 0L; var8 < var4; ++var8) {
               this.a(var1, var6 + var8, this.a(this.a(var1), var10, var3));
            }

            var6 += var4;
            var8 = var3.n();
            var4 = var8;
         } while(var8 > 0L);

         return var1;
      }
   }

   protected Object c(Object var1, gf var2) {
      ByteBuffer var3;
      if(var1 instanceof ByteBuffer) {
         var3 = (ByteBuffer)var1;
      } else {
         var3 = null;
      }

      return var2.a(var3);
   }

   protected Object d(Object var1, fn var2, gl var3) {
      fn var9 = var2.j();
      long var5 = var3.p();
      var1 = this.a(var1, (int)var5);
      long var7;
      if(var5 > 0L) {
         do {
            for(int var4 = 0; (long)var4 < var5; ++var4) {
               this.a(var1, this.b((Object)null, var2, (gf)var3), this.a((Object)null, (fn)var9, (gl)var3));
            }

            var7 = var3.q();
            var5 = var7;
         } while(var7 > 0L);
      }

      return var1;
   }
}
