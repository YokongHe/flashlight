package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.hb;
import com.flurry.sdk.hh;
import com.flurry.sdk.ho;
import com.flurry.sdk.hp;
import com.flurry.sdk.id;
import com.flurry.sdk.im;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class hf implements Closeable {
   protected ho a;

   public abstract hf a();

   public hf a(int var1) {
      return this;
   }

   public hf a(ho var1) {
      this.a = var1;
      return this;
   }

   public hf a(id var1) {
      return this;
   }

   public abstract void a(char var1);

   public abstract void a(double var1);

   public abstract void a(float var1);

   public abstract void a(long var1);

   public abstract void a(ha var1, byte[] var2, int var3, int var4);

   public abstract void a(hh var1);

   public void a(hp var1) {
      this.a(var1.a());
   }

   public void a(im var1) {
      this.a(var1.a());
   }

   public abstract void a(Object var1);

   public abstract void a(String var1);

   public final void a(String var1, int var2) {
      this.a(var1);
      this.b(var2);
   }

   public void a(String var1, String var2) {
      this.a(var1);
      this.b(var2);
   }

   public final void a(String var1, boolean var2) {
      this.a(var1);
      this.a(var2);
   }

   public abstract void a(BigDecimal var1);

   public abstract void a(BigInteger var1);

   public abstract void a(boolean var1);

   public void a(byte[] var1) {
      this.a(hb.a(), var1, 0, var1.length);
   }

   public abstract void a(char[] var1, int var2, int var3);

   public abstract void b();

   public abstract void b(int var1);

   public void b(hp var1) {
      this.b(var1.a());
   }

   public abstract void b(String var1);

   public abstract void b(char[] var1, int var2, int var3);

   public abstract void c();

   public abstract void c(String var1);

   public abstract void close();

   public abstract void d();

   public abstract void d(String var1);

   public abstract void e();

   public abstract void e(String var1);

   public abstract void f();

   public final void f(String var1) {
      this.a(var1);
      this.b();
   }

   public abstract void g();

   public final void g(String var1) {
      this.a(var1);
      this.d();
   }
}
