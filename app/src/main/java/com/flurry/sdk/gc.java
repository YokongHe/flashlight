package com.flurry.sdk;

import com.flurry.sdk.gi;
import com.flurry.sdk.gy;
import java.nio.ByteBuffer;

public abstract class gc extends gi {
   public void a() {
   }

   public void a(int var1) {
      this.c(var1);
   }

   public void a(long var1) {
      if(var1 > 0L) {
         this.b(var1);
      }

   }

   public void a(gy var1) {
      this.a(var1.a(), 0, var1.b());
   }

   public void a(String var1) {
      if(var1.length() == 0) {
         this.g();
      } else {
         byte[] var2 = var1.getBytes("UTF-8");
         this.c(var2.length);
         this.b(var2, 0, var2.length);
      }
   }

   public void a(ByteBuffer var1) {
      int var2 = var1.position();
      int var3 = var1.arrayOffset();
      int var4 = var1.limit();
      this.a(var1.array(), var3 + var2, var4 - var2);
   }

   public void a(byte[] var1, int var2, int var3) {
      if(var3 == 0) {
         this.g();
      } else {
         this.c(var3);
         this.b(var1, var2, var3);
      }
   }

   public void b() {
   }

   public void b(int var1) {
      this.c(var1);
   }

   public void c() {
   }

   public void d() {
      this.g();
   }

   public void e() {
   }

   public void f() {
      this.g();
   }

   protected abstract void g();
}
