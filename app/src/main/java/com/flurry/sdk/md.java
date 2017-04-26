package com.flurry.sdk;

import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.jh;
import com.flurry.sdk.kt;
import com.flurry.sdk.kx;
import com.flurry.sdk.lb;
import com.flurry.sdk.mu;
import com.flurry.sdk.sh;

public class md extends kx {
   protected final String a;
   protected final boolean b;
   protected mu c;
   protected lb[] d;
   protected mu e;
   protected sh f;
   protected mu g;
   protected mu h;
   protected mu i;
   protected mu j;
   protected mu k;
   protected mu l;

   public md(iy var1, sh var2) {
      boolean var3;
      if(var1 == null) {
         var3 = false;
      } else {
         var3 = var1.a(iy$a.q);
      }

      this.b = var3;
      String var4;
      if(var2 == null) {
         var4 = "UNKNOWN TYPE";
      } else {
         var4 = var2.toString();
      }

      this.a = var4;
   }

   protected jh a(Throwable var1) {
      while(var1.getCause() != null) {
         var1 = var1.getCause();
      }

      return new jh("Instantiation of " + this.a() + " value failed: " + var1.getMessage(), var1);
   }

   public Object a(double var1) {
      try {
         if(this.k != null) {
            Object var3 = this.k.a((Object)Double.valueOf(var1));
            return var3;
         }
      } catch (Exception var4) {
         throw this.a((Throwable)var4);
      }

      throw new jh("Can not instantiate value of type " + this.a() + " from JSON floating-point number; no one-double/Double-arg constructor/factory method");
   }

   public Object a(int var1) {
      try {
         if(this.i != null) {
            return this.i.a((Object)Integer.valueOf(var1));
         }

         if(this.j != null) {
            Object var2 = this.j.a((Object)Long.valueOf((long)var1));
            return var2;
         }
      } catch (Exception var3) {
         throw this.a((Throwable)var3);
      }

      throw new jh("Can not instantiate value of type " + this.a() + " from JSON integral number; no single-int-arg constructor/factory method");
   }

   public Object a(long var1) {
      try {
         if(this.j != null) {
            Object var3 = this.j.a((Object)Long.valueOf(var1));
            return var3;
         }
      } catch (Exception var4) {
         throw this.a((Throwable)var4);
      }

      throw new jh("Can not instantiate value of type " + this.a() + " from JSON long integral number; no single-long-arg constructor/factory method");
   }

   public Object a(Object var1) {
      if(this.g == null) {
         throw new IllegalStateException("No delegate constructor for " + this.a());
      } else {
         try {
            var1 = this.g.a(var1);
            return var1;
         } catch (ExceptionInInitializerError var2) {
            throw this.a((Throwable)var2);
         } catch (Exception var3) {
            throw this.a((Throwable)var3);
         }
      }
   }

   public Object a(String var1) {
      if(this.h != null) {
         try {
            Object var3 = this.h.a((Object)var1);
            return var3;
         } catch (Exception var2) {
            throw this.a((Throwable)var2);
         }
      } else {
         return this.b(var1);
      }
   }

   public Object a(boolean var1) {
      try {
         if(this.l != null) {
            Object var2 = this.l.a((Object)Boolean.valueOf(var1));
            return var2;
         }
      } catch (Exception var3) {
         throw this.a((Throwable)var3);
      }

      throw new jh("Can not instantiate value of type " + this.a() + " from JSON boolean value; no single-boolean/Boolean-arg constructor/factory method");
   }

   public Object a(Object[] var1) {
      if(this.e == null) {
         throw new IllegalStateException("No with-args constructor for " + this.a());
      } else {
         try {
            Object var4 = this.e.a(var1);
            return var4;
         } catch (ExceptionInInitializerError var2) {
            throw this.a((Throwable)var2);
         } catch (Exception var3) {
            throw this.a((Throwable)var3);
         }
      }
   }

   public String a() {
      return this.a;
   }

   public void a(mu var1) {
      this.h = var1;
   }

   public void a(mu var1, mu var2, sh var3, mu var4, lb[] var5) {
      this.c = var1;
      this.g = var2;
      this.f = var3;
      this.e = var4;
      this.d = var5;
   }

   protected Object b(String var1) {
      if(this.l != null) {
         String var2 = var1.trim();
         if("true".equals(var2)) {
            return this.a(true);
         }

         if("false".equals(var2)) {
            return this.a(false);
         }
      }

      if(this.b && var1.length() == 0) {
         return null;
      } else {
         throw new jh("Can not instantiate value of type " + this.a() + " from JSON String; no single-String constructor/factory method");
      }
   }

   public void b(mu var1) {
      this.i = var1;
   }

   public void c(mu var1) {
      this.j = var1;
   }

   public boolean c() {
      return this.h != null;
   }

   public void d(mu var1) {
      this.k = var1;
   }

   public boolean d() {
      return this.i != null;
   }

   public void e(mu var1) {
      this.l = var1;
   }

   public boolean e() {
      return this.j != null;
   }

   public boolean f() {
      return this.k != null;
   }

   public boolean g() {
      return this.l != null;
   }

   public boolean h() {
      return this.c != null;
   }

   public boolean j() {
      return this.e != null;
   }

   public kt[] k() {
      return this.d;
   }

   public sh l() {
      return this.f;
   }

   public Object m() {
      if(this.c == null) {
         throw new IllegalStateException("No default constructor for " + this.a());
      } else {
         try {
            Object var1 = this.c.g();
            return var1;
         } catch (ExceptionInInitializerError var2) {
            throw this.a((Throwable)var2);
         } catch (Exception var3) {
            throw this.a((Throwable)var3);
         }
      }
   }

   public mu n() {
      return this.c;
   }

   public mu o() {
      return this.g;
   }
}
