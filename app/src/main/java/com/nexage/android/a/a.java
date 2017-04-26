package com.nexage.android.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import com.nexage.android.NexageAdView;

public abstract class a {
   protected final com.nexage.android.c.e a;
   public com.nexage.android.g.b b;
   public volatile boolean c = false;
   protected String d;
   protected int e;
   protected int f;
   protected NexageAdView g;
   protected com.nexage.android.j h;
   protected com.nexage.android.a.l i;
   protected com.nexage.android.a.b j;
   protected com.nexage.android.d.b k;
   protected final long l = com.nexage.android.c.f.b();
   protected com.nexage.android.a.m m;
   protected long n;
   private String o;
   private String p;

   protected a(com.nexage.android.a.m var1, com.nexage.android.c.e var2) {
      this.m = var1;
      this.a = var2;
      if(var2 != null && var1 != null) {
         var1.f();
      }

   }

   @SuppressLint({"DefaultLocale"})
   public static int b(String var0) {
      int var2 = 0;

      for(int var1 = 1; var1 < var0.length(); ++var1) {
         var2 = var2 << 4 | "0123456789ABCDEF".indexOf(var0.toUpperCase().charAt(var1));
      }

      return var2;
   }

   public int a(String var1) {
      return 0;
   }

   public abstract com.nexage.android.a.b a(Activity var1);

   public final String a() {
      return this.d;
   }

   public final void a(int var1, int var2) {
      this.e = var1;
      this.f = var2;
   }

   protected final void a(int var1, com.nexage.android.d.b var2) {
      if(this.a != null) {
         com.nexage.android.g.a var3 = new com.nexage.android.g.a(var1, this.l, var2);
         if(!TextUtils.isEmpty(this.o) && !TextUtils.isEmpty(this.p)) {
            this.a.a(this.o, this.p);
            var3.f = this.o;
            var3.e = this.p;
         }

         var3.g = this.n;
         this.a.a(var3);
      }

   }

   public final void a(long var1) {
      this.n = var1;
   }

   public final void a(NexageAdView var1) {
      this.g = var1;
   }

   public final void a(com.nexage.android.a.l var1) {
      this.i = var1;
   }

   public final void a(com.nexage.android.d.b var1) {
      this.k = var1;
   }

   public final void a(com.nexage.android.j var1) {
      this.h = var1;
   }

   public final void a(String var1, String var2) {
      this.o = var1;
      this.p = var2;
   }

   public final int b() {
      this.m.f();
      return this.e;
   }

   public final void b(NexageAdView var1) {
      if(this.a != null) {
         this.a.a(var1);
      }

   }

   public final int c() {
      this.m.f();
      return this.f;
   }

   public final NexageAdView d() {
      return this.g;
   }

   public final com.nexage.android.j e() {
      return this.h;
   }

   public final com.nexage.android.a.l f() {
      this.m.f();
      return this.k.i?null:this.i;
   }

   public final void g() {
      if(this.a != null) {
         this.a.b();
      }

   }

   protected final boolean h() {
      if(this.a != null) {
         if(this.b == null) {
            com.nexage.android.c.e var2 = this.a;
            String var3 = this.a.a;
            String var1;
            if(this.k == null) {
               var1 = null;
            } else {
               var1 = this.k.b;
            }

            return com.nexage.android.c.f.a(var2, new com.nexage.android.c.a(var3, var1, this.a.d()));
         }

         com.nexage.android.a.p.b("Ad.addDisplayToReport using Task");
         com.nexage.android.c.f.b(this.a, this.b);
      }

      return false;
   }

   public final com.nexage.android.c.b i() {
      // $FF: Couldn't be decompiled
   }

   public void j() {
   }

   public final boolean k() {
      this.m.f();
      return false;
   }
}
