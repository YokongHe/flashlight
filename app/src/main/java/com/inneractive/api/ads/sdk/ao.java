package com.inneractive.api.ads.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ao implements com.inneractive.api.ads.sdk.ap {
   private int a;
   private int b;
   private String c;
   private String d;
   private String e;
   private String f;
   private List g = new ArrayList();

   final int a() {
      return this.a;
   }

   public final List a(int var1) {
      Iterator var2 = this.g.iterator();
      ArrayList var3 = new ArrayList();

      while(var2.hasNext()) {
         com.inneractive.api.ads.sdk.aq var4 = (com.inneractive.api.ads.sdk.aq)var2.next();
         if(var4.a() == var1) {
            var3.add(var4.b());
         }
      }

      return var3;
   }

   final void a(String var1) {
      this.c = var1;
   }

   public final void a(String var1, String var2) {
      this.g.add(new com.inneractive.api.ads.sdk.aq(var1, var2));
   }

   final int b() {
      return this.b;
   }

   final void b(int var1) {
      this.a = var1;
   }

   final void b(String var1) {
      this.d = var1;
   }

   final String c() {
      return this.c;
   }

   final void c(int var1) {
      this.b = var1;
   }

   final void c(String var1) {
      this.e = var1;
   }

   final String d() {
      return this.d;
   }

   final void d(String var1) {
      this.f = var1;
   }

   final String e() {
      return this.e;
   }

   final String f() {
      return this.f;
   }
}
