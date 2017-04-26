package com.ihs.a.c.a;

import android.text.TextUtils;
import java.util.Map;

public class j implements com.ihs.a.c.a.e {
   private com.ihs.a.c.a.s a;
   private int b;
   public com.ihs.a.c.a.q c;
   protected com.ihs.a.c.a.d d;
   protected com.ihs.a.c.b.e e;
   protected com.ihs.a.c.a.f f;
   protected String g;
   protected com.ihs.a.c.a.k h;
   protected com.ihs.a.c.a.l i;
   protected com.ihs.a.c.a.n j;
   protected com.ihs.a.c.a.m k;

   public j(String var1, com.ihs.a.c.b.g var2, String var3, com.ihs.a.c.a.l var4) {
      this.e = com.ihs.a.c.b.e.a;
      this.h = com.ihs.a.c.a.k.a;
      this.b = 0;
      if(!TextUtils.isEmpty(var1)) {
         this.g = var1;
         this.d = new com.ihs.a.c.a.d(var1, var2, this.e, var3, this);
         this.f = this.d.a();
      }

      this.i = null;
      this.h = com.ihs.a.c.a.k.a;
   }

   // $FF: synthetic method
   static void a(com.ihs.a.c.a.j var0) {
      if(var0.h == com.ihs.a.c.a.k.b) {
         var0.a(false, new Exception("Connection Timeout"));
      }

   }

   public final void a() {
      int var1 = this.c();
      this.f();
      if(this.c() < 400) {
         this.b();
      } else {
         this.a(var1, true, "Bad Request code");
      }
   }

   public final void a(int var1, String var2, Map var3) {
      if(this.j != null) {
         com.ihs.a.c.a.n var4 = this.j;
      }

   }

   protected void a(int var1, boolean var2, String var3) {
      this.h = com.ihs.a.c.a.k.d;
      if(this.i != null) {
         this.i.b();
      }

   }

   public final void a(com.ihs.a.c.a.l var1) {
      this.i = var1;
   }

   public final void a(boolean var1, Exception var2) {
      int var3 = this.c();
      this.f();
      this.a(var3, var1, var2.getMessage());
   }

   public void a(byte[] var1) {
      if(this.k != null) {
         com.ihs.a.c.a.m var2 = this.k;
      }

   }

   protected void b() {
      this.h = com.ihs.a.c.a.k.c;
      if(this.i != null) {
         this.i.a();
      }

   }

   protected final int c() {
      return this.d != null?this.d.a:-1;
   }

   public final void d() {
      if(this.h == com.ihs.a.c.a.k.a) {
         this.d.c();
         this.h = com.ihs.a.c.a.k.b;
         if(this.b > 0) {
            this.a = com.ihs.a.c.a.s.a(new Runnable() {
               public final void run() {
                  com.ihs.a.c.a.j.a(j.this);
               }
            }, this.b);
         }
      }

   }

   public final void e() {
      this.h = com.ihs.a.c.a.k.e;
      this.i = null;
      this.f();
   }

   protected void f() {
      if(this.a != null) {
         this.a.a();
         this.a = null;
      }

      if(this.c != null) {
         this.c.a(this);
         this.c = null;
      }

      if(this.d != null) {
         this.d.a((com.ihs.a.c.a.e)this);
         this.d = null;
      }

   }
}
