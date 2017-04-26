package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Prompt;
import com.nuance.nmdp.speechkit.SpeechError;

abstract class p {
   private final .cO a;
   private final boolean b;
   private final boolean c;
   private final String d;
   private final .d e;
   private final .b f;
   private .db g;
   private .J h;
   private boolean i;
   private Prompt j;
   private Prompt k;
   private Prompt l;
   private Prompt m;
   private String n;

   p(.cO var1, boolean var2, boolean var3, String var4, String var5, .d var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var6;
      this.f = new .b() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.p a = p.this;

         public final void a(.cI var1) {
            if(this.a.g == var1) {
               com.nuance.nmdp.speechkit.p.b(this.a);
            }

         }

         public final void a(.cI var1, int var2, String var3, String var4) {
            if(this.a.g == var1) {
               this.a.a((SpeechError)(new com.nuance.nmdp.speechkit.v(var2, var3, var4)));
            }

         }

         public final void b(.cI var1) {
            if(this.a.g == var1) {
               this.a.b();
            }

         }

         public final void c(.cI var1) {
            if(this.a.g == var1) {
               this.a.c();
            }

         }

         public final void d(.cI var1) {
            if(this.a.g == var1) {
               this.a.a(this.a.h.b());
            }

         }
      };
      this.i = false;
      this.n = var5;
   }

   // $FF: synthetic method
   static .db b(com.nuance.nmdp.speechkit.p var0) {
      var0.g = null;
      return null;
   }

   protected abstract .J a();

   protected abstract .db a(.cO var1, boolean var2, boolean var3, String var4, String var5, .d var6, .E var7, .E var8, .E var9, .E var10, .J var11, .b var12);

   public final void a(int var1, Prompt var2) {
      switch(var1) {
      case 0:
         this.j = var2;
         return;
      case 1:
         this.k = var2;
         return;
      case 2:
         this.l = var2;
         return;
      case 3:
         this.m = var2;
         return;
      default:
      }
   }

   protected abstract void a(SpeechError var1);

   protected abstract void a(Object var1);

   protected abstract void b();

   protected abstract void c();

   public final void d() {
      if(this.a.b()) {
         if(!this.i) {
            .E var1;
            if(this.j == null) {
               var1 = null;
            } else {
               var1 = this.j.a();
            }

            .E var2;
            if(this.k == null) {
               var2 = null;
            } else {
               var2 = this.k.a();
            }

            .E var3;
            if(this.l == null) {
               var3 = null;
            } else {
               var3 = this.l.a();
            }

            .E var4;
            if(this.m == null) {
               var4 = null;
            } else {
               var4 = this.m.a();
            }

            this.h = this.a();
            this.g = this.a(this.a, this.b, this.c, this.d, this.n, this.e, var1, var2, var3, var4, this.h, this.f);
            if(this.g == null) {
               com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create recognition transaction");
               this.a((SpeechError)(new com.nuance.nmdp.speechkit.v(0, (String)null, (String)null)));
            } else {
               this.i = true;
               this.g.a();
            }
         }
      } else {
         com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create recognition transaction. Transaction runner is invalid.");
         this.a((SpeechError)(new com.nuance.nmdp.speechkit.v(0, (String)null, (String)null)));
      }
   }

   public final void e() {
      if(this.g != null) {
         this.g.f();
      }

   }

   public final void f() {
      if(this.g != null) {
         this.g.p();
         this.g = null;
      }

   }
}
