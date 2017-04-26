package com.flurry.sdk;

import com.flurry.sdk.gy;
import java.io.Flushable;
import java.nio.ByteBuffer;

public abstract class gi implements Flushable {
   public abstract void a();

   public abstract void a(double var1);

   public abstract void a(float var1);

   public abstract void a(int var1);

   public abstract void a(long var1);

   public abstract void a(gy var1);

   public void a(CharSequence var1) {
      if(var1 instanceof gy) {
         this.a((gy)var1);
      } else {
         this.a(var1.toString());
      }
   }

   public void a(String var1) {
      this.a(new gy(var1));
   }

   public abstract void a(ByteBuffer var1);

   public abstract void a(boolean var1);

   public void a(byte[] var1) {
      this.a(var1, 0, var1.length);
   }

   public abstract void a(byte[] var1, int var2, int var3);

   public abstract void b();

   public abstract void b(int var1);

   public abstract void b(long var1);

   public void b(byte[] var1) {
      this.b(var1, 0, var1.length);
   }

   public abstract void b(byte[] var1, int var2, int var3);

   public abstract void c();

   public abstract void c(int var1);

   public abstract void d();

   public abstract void e();

   public abstract void f();
}
