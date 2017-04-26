package com.flurry.sdk;

import com.flurry.sdk.qw$a;
import com.flurry.sdk.qw$b;
import com.flurry.sdk.qw$c;
import com.flurry.sdk.qw$d;
import com.flurry.sdk.qw$e;
import com.flurry.sdk.qw$f;
import com.flurry.sdk.qw$g;
import com.flurry.sdk.qw$h;
import java.lang.reflect.Array;
import java.util.HashSet;

public final class qw {
   qw$b a = null;
   qw$c b = null;
   qw$h c = null;
   qw$f d = null;
   qw$g e = null;
   qw$e f = null;
   qw$d g = null;

   public static HashSet a(Object[] var0) {
      HashSet var3 = new HashSet();
      if(var0 != null) {
         int var2 = var0.length;

         for(int var1 = 0; var1 < var2; ++var1) {
            var3.add(var0[var1]);
         }
      }

      return var3;
   }

   public static Object[] a(Object[] var0, Object var1) {
      int var3 = var0.length;

      Object[] var4;
      for(int var2 = 0; var2 < var3; ++var2) {
         if(var0[var2] == var1) {
            if(var2 == 0) {
               return var0;
            }

            var4 = (Object[])Array.newInstance(var0.getClass().getComponentType(), var3);
            System.arraycopy(var0, 0, var4, 1, var2);
            var0[0] = var1;
            return var4;
         }
      }

      var4 = (Object[])Array.newInstance(var0.getClass().getComponentType(), var3 + 1);
      if(var3 > 0) {
         System.arraycopy(var0, 0, var4, 1, var3);
      }

      var4[0] = var1;
      return var4;
   }

   public static Iterable b(Object[] var0) {
      return new qw$a(var0);
   }

   public final qw$b a() {
      if(this.a == null) {
         this.a = new qw$b();
      }

      return this.a;
   }

   public final qw$c b() {
      if(this.b == null) {
         this.b = new qw$c();
      }

      return this.b;
   }

   public final qw$h c() {
      if(this.c == null) {
         this.c = new qw$h();
      }

      return this.c;
   }

   public final qw$f d() {
      if(this.d == null) {
         this.d = new qw$f();
      }

      return this.d;
   }

   public final qw$g e() {
      if(this.e == null) {
         this.e = new qw$g();
      }

      return this.e;
   }

   public final qw$e f() {
      if(this.f == null) {
         this.f = new qw$e();
      }

      return this.f;
   }

   public final qw$d g() {
      if(this.g == null) {
         this.g = new qw$d();
      }

      return this.g;
   }
}
