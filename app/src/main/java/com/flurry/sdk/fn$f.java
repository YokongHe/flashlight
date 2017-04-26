package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f$a;
import com.flurry.sdk.fn$r;
import com.flurry.sdk.hh;
import java.util.Set;

public class fn$f {
   private final String a;
   private transient int b;
   private final fn c;
   private final String d;
   private final hh e;
   private final fn$f$a f;
   private Set g;
   private final fn$r h;

   public fn$f(String var1, fn var2, String var3, hh var4) {
      this(var1, var2, var3, var4, fn$f$a.a);
   }

   public fn$f(String var1, fn var2, String var3, hh var4, fn$f$a var5) {
      this.b = -1;
      this.h = new fn$r(fn.n());
      this.a = fn.g(var1);
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
   }

   // $FF: synthetic method
   static int a(fn$f var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static int a(fn$f var0, int var1) {
      var0.b = var1;
      return var1;
   }

   // $FF: synthetic method
   static Set a(fn$f var0, Set var1) {
      var0.g = var1;
      return var1;
   }

   private boolean a(hh var1) {
      return this.e == null?var1 == null:(Double.isNaN(this.e.o())?Double.isNaN(var1.o()):this.e.equals(var1));
   }

   // $FF: synthetic method
   static Set b(fn$f var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static fn$r c(fn$f var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static fn d(fn$f var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static String e(fn$f var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static String f(fn$f var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static hh g(fn$f var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static fn$f$a h(fn$f var0) {
      return var0.f;
   }

   public String a() {
      return this.a;
   }

   public void a(String var1, String var2) {
      synchronized(this){}

      try {
         this.h.a(var1, var2);
      } finally {
         ;
      }

   }

   public int b() {
      return this.b;
   }

   public fn c() {
      return this.c;
   }

   public String d() {
      return this.d;
   }

   public hh e() {
      return this.e;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fn$f)) {
            return false;
         }

         fn$f var2 = (fn$f)var1;
         if(!this.a.equals(var2.a) || !this.c.equals(var2.c) || !this.a(var2.e) || !this.h.equals(var2.h)) {
            return false;
         }
      }

      return true;
   }

   public fn$f$a f() {
      return this.f;
   }

   public int hashCode() {
      return this.a.hashCode() + this.c.m();
   }

   public String toString() {
      return this.a + " type:" + fn.d(this.c) + " pos:" + this.b;
   }
}
