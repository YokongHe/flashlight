package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$As;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.hn;
import com.flurry.sdk.is;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.nh;
import com.flurry.sdk.nj;
import com.flurry.sdk.sh;
import com.flurry.sdk.so;
import com.flurry.sdk.sq;

public class nn extends nj {
   protected final String a;

   public nn(sh var1, nh var2, is var3, Class var4, String var5) {
      super(var1, var2, var3, var4);
      this.a = var5;
   }

   public JsonTypeInfo$As a() {
      return JsonTypeInfo$As.PROPERTY;
   }

   public Object a(hj var1, iz var2) {
      hm var4 = var1.e();
      hm var3;
      if(var4 == hm.b) {
         var3 = var1.b();
      } else {
         if(var4 == hm.d) {
            return this.a(var1, var2, (sq)null);
         }

         var3 = var4;
         if(var4 != hm.f) {
            return this.a(var1, var2, (sq)null);
         }
      }

      String var5 = null;
      var4 = var3;

      sq var6;
      hm var8;
      for(var6 = var5; var4 == hm.f; var4 = var8) {
         var5 = var1.g();
         var1.b();
         if(this.a.equals(var5)) {
            jg var9 = this.a(var2, var1.k());
            Object var10 = var1;
            if(var6 != null) {
               var10 = so.a(var6.a(var1), var1);
            }

            ((hj)var10).b();
            return var9.a((hj)var10, var2);
         }

         sq var7 = var6;
         if(var6 == null) {
            var7 = new sq((hn)null);
         }

         var7.a(var5);
         var7.c(var1);
         var8 = var1.b();
         var6 = var7;
      }

      return this.a(var1, var2, var6);
   }

   protected Object a(hj var1, iz var2, sq var3) {
      Object var7;
      if(this.e != null) {
         jg var5 = this.a(var2);
         hj var4 = var1;
         if(var3 != null) {
            var3.e();
            var4 = var3.a(var1);
            var4.b();
         }

         var7 = var5.a(var4, var2);
      } else {
         Object var6 = this.f(var1, var2);
         var7 = var6;
         if(var6 == null) {
            if(var1.e() == hm.d) {
               return super.d(var1, var2);
            }

            throw var2.a(var1, hm.f, "missing property \'" + this.a + "\' that is to contain type id  (for class " + this.c() + ")");
         }
      }

      return var7;
   }

   public String b() {
      return this.a;
   }

   public Object d(hj var1, iz var2) {
      return var1.e() == hm.d?super.b(var1, var2):this.a(var1, var2);
   }

   protected Object f(hj var1, iz var2) {
      switch(null.a[var1.e().ordinal()]) {
      case 1:
         if(this.c.p().isAssignableFrom(String.class)) {
            return var1.k();
         }
         break;
      case 2:
         if(this.c.p().isAssignableFrom(Integer.class)) {
            return Integer.valueOf(var1.t());
         }
         break;
      case 3:
         if(this.c.p().isAssignableFrom(Double.class)) {
            return Double.valueOf(var1.x());
         }
         break;
      case 4:
         if(this.c.p().isAssignableFrom(Boolean.class)) {
            return Boolean.TRUE;
         }
         break;
      case 5:
         if(this.c.p().isAssignableFrom(Boolean.class)) {
            return Boolean.FALSE;
         }
      }

      return null;
   }
}
