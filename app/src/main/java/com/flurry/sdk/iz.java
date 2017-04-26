package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.is;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.jc;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.qs;
import com.flurry.sdk.qw;
import com.flurry.sdk.re;
import com.flurry.sdk.rs;
import com.flurry.sdk.sh;
import java.util.Calendar;
import java.util.Date;

public abstract class iz {
   protected final iy a;
   protected final int b;

   protected iz(iy var1) {
      this.a = var1;
      this.b = var1.i;
   }

   public iy a() {
      return this.a;
   }

   public abstract jh a(hj var1, hm var2, String var3);

   public abstract jh a(sh var1, String var2);

   public abstract jh a(Class var1, hm var2);

   public abstract jh a(Class var1, String var2);

   public abstract jh a(Class var1, String var2, String var3);

   public abstract jh a(Class var1, Throwable var2);

   public abstract jh a(Object var1, String var2);

   public sh a(Class var1) {
      return this.a.b((Class)var1);
   }

   public abstract Object a(Object var1, is var2, Object var3);

   public abstract Calendar a(Date var1);

   public abstract Date a(String var1);

   public abstract void a(re var1);

   public abstract boolean a(hj var1, jg var2, Object var3, String var4);

   public boolean a(iy$a var1) {
      return (this.b & var1.b()) != 0;
   }

   public jc b() {
      return null;
   }

   public abstract jh b(Class var1);

   public abstract jh b(Class var1, String var2);

   public jh b(String var1) {
      return jh.a(this.d(), var1);
   }

   public ha c() {
      return this.a.g();
   }

   public abstract jh c(Class var1, String var2);

   public abstract hj d();

   public final rs e() {
      return this.a.h();
   }

   public qs f() {
      return this.a.m();
   }

   public abstract re g();

   public abstract qw h();
}
