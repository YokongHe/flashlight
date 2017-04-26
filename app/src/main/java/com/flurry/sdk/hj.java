package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.hg;
import com.flurry.sdk.hi;
import com.flurry.sdk.hj$a;
import com.flurry.sdk.hj$b;
import com.flurry.sdk.hm;
import com.flurry.sdk.hn;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class hj implements Closeable {
   protected int a;
   protected hm b;
   protected hm c;

   protected hj() {
   }

   protected hj(int var1) {
      this.a = var1;
   }

   protected hi a(String var1) {
      return new hi(var1, this.i());
   }

   public abstract hn a();

   public boolean a(hj$a var1) {
      return (this.a & var1.c()) != 0;
   }

   public abstract byte[] a(ha var1);

   public abstract hm b();

   public hm c() {
      hm var2 = this.b();
      hm var1 = var2;
      if(var2 == hm.f) {
         var1 = this.b();
      }

      return var1;
   }

   public abstract void close();

   public abstract hj d();

   public hm e() {
      return this.b;
   }

   public void f() {
      if(this.b != null) {
         this.c = this.b;
         this.b = null;
      }

   }

   public abstract String g();

   public abstract hg h();

   public abstract hg i();

   public boolean j() {
      return this.e() == hm.d;
   }

   public abstract String k();

   public abstract char[] l();

   public abstract int m();

   public abstract int n();

   public boolean o() {
      return false;
   }

   public abstract Number p();

   public abstract hj$b q();

   public byte r() {
      int var1 = this.t();
      if(var1 >= -128 && var1 <= 127) {
         return (byte)var1;
      } else {
         throw this.a("Numeric value (" + this.k() + ") out of range of Java byte");
      }
   }

   public short s() {
      int var1 = this.t();
      if(var1 >= -32768 && var1 <= 32767) {
         return (short)var1;
      } else {
         throw this.a("Numeric value (" + this.k() + ") out of range of Java short");
      }
   }

   public abstract int t();

   public abstract long u();

   public abstract BigInteger v();

   public abstract float w();

   public abstract double x();

   public abstract BigDecimal y();

   public Object z() {
      return null;
   }
}
