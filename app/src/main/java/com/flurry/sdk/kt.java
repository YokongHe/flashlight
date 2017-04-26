package com.flurry.sdk;

import com.flurry.sdk.hg;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.is;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.jy;
import com.flurry.sdk.kt$e;
import com.flurry.sdk.mq;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;
import com.flurry.sdk.sm;
import java.io.IOException;

public abstract class kt implements is {
   protected final String a;
   protected final sh b;
   protected final qv c;
   protected jg d;
   protected jy e;
   protected kt$e f;
   protected String g;
   protected int h;

   protected kt(kt var1) {
      this.h = -1;
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
   }

   protected kt(kt var1, jg var2) {
      Object var3 = null;
      super();
      this.h = -1;
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.e = var1.e;
      this.g = var1.g;
      this.h = var1.h;
      this.d = var2;
      kt$e var4;
      if(var2 == null) {
         var4 = (kt$e)var3;
      } else {
         Object var5 = var2.b();
         var4 = (kt$e)var3;
         if(var5 != null) {
            var4 = new kt$e(this.b, var5);
         }
      }

      this.f = var4;
   }

   protected kt(String var1, sh var2, jy var3, qv var4) {
      this.h = -1;
      if(var1 != null && var1.length() != 0) {
         this.a = sm.a.a(var1);
      } else {
         this.a = "";
      }

      this.b = var2;
      this.c = var4;
      this.e = var3;
   }

   public abstract kt a(jg var1);

   public sh a() {
      return this.b;
   }

   protected IOException a(Exception var1) {
      if(var1 instanceof IOException) {
         throw (IOException)var1;
      } else {
         Object var2 = var1;
         if(var1 instanceof RuntimeException) {
            throw (RuntimeException)var1;
         } else {
            while(((Throwable)var2).getCause() != null) {
               var2 = ((Throwable)var2).getCause();
            }

            throw new jh(((Throwable)var2).getMessage(), (hg)null, (Throwable)var2);
         }
      }
   }

   public final Object a(hj var1, iz var2) {
      return var1.e() == hm.m?(this.f == null?null:this.f.a(var2)):(this.e != null?this.d.a(var1, var2, this.e):this.d.a(var1, var2));
   }

   public void a(int var1) {
      if(this.h != -1) {
         throw new IllegalStateException("Property \'" + this.c() + "\' already had index (" + this.h + "), trying to assign " + var1);
      } else {
         this.h = var1;
      }
   }

   public abstract void a(hj var1, iz var2, Object var3);

   protected void a(Exception var1, Object var2) {
      if(var1 instanceof IllegalArgumentException) {
         String var4;
         if(var2 == null) {
            var4 = "[NULL]";
         } else {
            var4 = var2.getClass().getName();
         }

         StringBuilder var3 = (new StringBuilder("Problem deserializing property \'")).append(this.d());
         var3.append("\' (expected type: ").append(this.a());
         var3.append("; actual type: ").append(var4).append(")");
         var4 = var1.getMessage();
         if(var4 != null) {
            var3.append(", problem: ").append(var4);
         } else {
            var3.append(" (no error message provided)");
         }

         throw new jh(var3.toString(), (hg)null, var1);
      } else {
         this.a(var1);
      }
   }

   public abstract void a(Object var1, Object var2);

   public void a(String var1) {
      this.g = var1;
   }

   public abstract mq b();

   public final String c() {
      return this.a;
   }

   @Deprecated
   public String d() {
      return this.a;
   }

   public String e() {
      return this.g;
   }

   public boolean f() {
      return this.d != null;
   }

   public boolean g() {
      return this.e != null;
   }

   public jg h() {
      return this.d;
   }

   public jy i() {
      return this.e;
   }

   public int j() {
      return this.h;
   }

   public Object k() {
      return null;
   }

   public String toString() {
      return "[property \'" + this.c() + "\']";
   }
}
