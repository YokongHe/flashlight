package com.flurry.sdk;

import com.flurry.sdk.gb;

class gb$a {
   boolean a;
   private final gb b;
   private byte[] c;
   private int d;
   private int e;

   private gb$a(gb var1) {
      this.a = false;
      this.b = var1;
   }

   // $FF: synthetic method
   gb$a(gb var1, Object var2) {
      this(var1);
   }

   void a() {
      this.c = gb.a(this.b);
      this.d = gb.b(this.b);
      this.e = gb.c(this.b);
      this.a = true;
   }

   void a(int var1) {
      if(this.a) {
         this.d = var1;
      } else {
         gb.a(this.b, var1);
      }
   }

   void a(byte[] var1, int var2, int var3) {
      if(this.a) {
         this.c = var1;
         this.e = var2 + var3;
         this.d = var2;
      } else {
         gb.a(this.b, var1);
         gb.b(this.b, var2 + var3);
         gb.a(this.b, var2);
         gb.c(this.b, var2);
      }
   }

   int b() {
      return this.a?this.d:gb.b(this.b);
   }

   void b(int var1) {
      if(this.a) {
         this.e = var1;
      } else {
         gb.b(this.b, var1);
      }
   }

   int c() {
      return this.a?this.e:gb.c(this.b);
   }

   byte[] d() {
      return this.a?this.c:gb.a(this.b);
   }
}
