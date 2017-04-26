package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.is;
import com.flurry.sdk.iy;
import com.flurry.sdk.iz;
import com.flurry.sdk.jc;
import com.flurry.sdk.jf;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.mk;
import com.flurry.sdk.qw;
import com.flurry.sdk.re;
import com.flurry.sdk.sh;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class ku extends iz {
   protected hj c;
   protected final jc d;
   protected final jf e;
   protected qw f;
   protected re g;
   protected DateFormat h;

   public ku(iy var1, hj var2, jc var3, jf var4) {
      super(var1);
      this.c = var2;
      this.d = var3;
      this.e = var4;
   }

   public jh a(hj var1, hm var2, String var3) {
      return jh.a(var1, "Unexpected token (" + var1.e() + "), expected " + var2 + ": " + var3);
   }

   public jh a(sh var1, String var2) {
      return jh.a(this.c, "Could not resolve type id \'" + var2 + "\' into a subtype of " + var1);
   }

   public jh a(Class var1, hm var2) {
      String var3 = this.c(var1);
      return jh.a(this.c, "Can not deserialize instance of " + var3 + " out of " + var2 + " token");
   }

   public jh a(Class var1, String var2) {
      return jh.a(this.c, "Can not construct instance of " + var1.getName() + ", problem: " + var2);
   }

   public jh a(Class var1, String var2, String var3) {
      return jh.a(this.c, "Can not construct Map key of type " + var1.getName() + " from String \"" + this.c(var2) + "\": " + var3);
   }

   public jh a(Class var1, Throwable var2) {
      return jh.a(this.c, "Can not construct instance of " + var1.getName() + ", problem: " + var2.getMessage(), var2);
   }

   public jh a(Object var1, String var2) {
      return mk.a(this.c, var1, var2);
   }

   public Object a(Object var1, is var2, Object var3) {
      if(this.e == null) {
         throw new IllegalStateException("No \'injectableValues\' configured, can not inject value with id [" + var1 + "]");
      } else {
         return this.e.a(var1, this, var2, var3);
      }
   }

   public Calendar a(Date var1) {
      Calendar var2 = Calendar.getInstance();
      var2.setTime(var1);
      return var2;
   }

   public Date a(String var1) {
      try {
         Date var3 = this.i().parse(var1);
         return var3;
      } catch (ParseException var2) {
         throw new IllegalArgumentException(var2.getMessage());
      }
   }

   public final void a(re var1) {
      if(this.g == null || var1.b() >= this.g.b()) {
         this.g = var1;
      }

   }

   public boolean a(hj param1, jg param2, Object param3, String param4) {
      // $FF: Couldn't be decompiled
   }

   public jc b() {
      return this.d;
   }

   public jh b(Class var1) {
      return this.a(var1, this.c.e());
   }

   public jh b(Class var1, String var2) {
      return jh.a(this.c, "Can not construct instance of " + var1.getName() + " from String value \'" + this.j() + "\': " + var2);
   }

   public jh c(Class var1, String var2) {
      return jh.a(this.c, "Can not construct instance of " + var1.getName() + " from number value (" + this.j() + "): " + var2);
   }

   protected String c(Class var1) {
      return var1.isArray()?this.c(var1.getComponentType()) + "[]":var1.getName();
   }

   protected String c(String var1) {
      String var2 = var1;
      if(var1.length() > 500) {
         var2 = var1.substring(0, 500) + "]...[" + var1.substring(var1.length() - 500);
      }

      return var2;
   }

   public hj d() {
      return this.c;
   }

   public final re g() {
      re var1 = this.g;
      if(var1 == null) {
         return new re();
      } else {
         this.g = null;
         return var1;
      }
   }

   public final qw h() {
      if(this.f == null) {
         this.f = new qw();
      }

      return this.f;
   }

   protected DateFormat i() {
      if(this.h == null) {
         this.h = (DateFormat)this.a.n().clone();
      }

      return this.h;
   }

   protected String j() {
      try {
         String var1 = this.c(this.c.k());
         return var1;
      } catch (Exception var2) {
         return "[N/A]";
      }
   }
}
