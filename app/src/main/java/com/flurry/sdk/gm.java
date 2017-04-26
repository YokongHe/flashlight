package com.flurry.sdk;

import com.flurry.sdk.fl;
import com.flurry.sdk.gf;
import com.flurry.sdk.gk;
import com.flurry.sdk.gn$a;
import com.flurry.sdk.gq;
import com.flurry.sdk.gq$a;
import com.flurry.sdk.gq$h;
import com.flurry.sdk.gy;
import java.nio.ByteBuffer;

public class gm extends gk implements gn$a {
   protected gf c;

   gm(gq var1, gf var2) {
      super(var1);
      this.a(var2);
   }

   private void b(int var1) {
      this.a.a(gq.k);
      gq$h var2 = (gq$h)this.a.c();
      if(var1 != var2.A) {
         throw new fl("Incorrect length for fixed binary: expected " + var2.A + " but received " + var1 + " bytes.");
      }
   }

   public gm a(gf var1) {
      this.a.e();
      this.c = var1;
      return this;
   }

   public gq a(gq var1, gq var2) {
      return null;
   }

   public gy a(gy var1) {
      this.a.a(gq.i);
      return this.c.a(var1);
   }

   public ByteBuffer a(ByteBuffer var1) {
      this.a.a(gq.j);
      return this.c.a(var1);
   }

   protected void a() {
      this.a.a(gq.k);
      gq$h var1 = (gq$h)this.a.c();
      this.c.a(var1.A);
   }

   public void a(int var1) {
      this.b(var1);
      this.c.a(var1);
   }

   public void b() {
      this.a.a(gq.c);
      this.c.b();
   }

   public void b(byte[] var1, int var2, int var3) {
      this.b(var3);
      this.c.b(var1, var2, var3);
   }

   public boolean c() {
      this.a.a(gq.d);
      return this.c.c();
   }

   public int d() {
      this.a.a(gq.e);
      return this.c.d();
   }

   public long e() {
      this.a.a(gq.f);
      return this.c.e();
   }

   public float f() {
      this.a.a(gq.g);
      return this.c.f();
   }

   public double g() {
      this.a.a(gq.h);
      return this.c.g();
   }

   public String h() {
      this.a.a(gq.i);
      return this.c.h();
   }

   public void i() {
      this.a.a(gq.i);
      this.c.i();
   }

   public void j() {
      this.a.a(gq.j);
      this.c.j();
   }

   public int k() {
      this.a.a(gq.l);
      gq$h var2 = (gq$h)this.a.c();
      int var1 = this.c.k();
      if(var1 >= 0 && var1 < var2.A) {
         return var1;
      } else {
         throw new fl("Enumeration out of range: max is " + var2.A + " but received " + var1);
      }
   }

   public long m() {
      this.a.a(gq.n);
      long var1 = this.c.m();
      if(var1 == 0L) {
         this.a.a(gq.o);
      }

      return var1;
   }

   public long n() {
      this.a.b();
      long var1 = this.c.n();
      if(var1 == 0L) {
         this.a.a(gq.o);
      }

      return var1;
   }

   public long o() {
      this.a.a(gq.n);

      for(long var1 = this.c.o(); var1 != 0L; var1 = this.c.o()) {
         while(var1 > 0L) {
            this.a.f();
            --var1;
         }
      }

      this.a.a(gq.o);
      return 0L;
   }

   public long p() {
      this.a.a(gq.p);
      long var1 = this.c.p();
      if(var1 == 0L) {
         this.a.a(gq.q);
      }

      return var1;
   }

   public long q() {
      this.a.b();
      long var1 = this.c.q();
      if(var1 == 0L) {
         this.a.a(gq.q);
      }

      return var1;
   }

   public long r() {
      this.a.a(gq.p);

      for(long var1 = this.c.r(); var1 != 0L; var1 = this.c.r()) {
         while(var1 > 0L) {
            this.a.f();
            --var1;
         }
      }

      this.a.a(gq.q);
      return 0L;
   }

   public int s() {
      this.a.a(gq.m);
      gq$a var2 = (gq$a)this.a.c();
      int var1 = this.c.s();
      this.a.c(var2.a(var1));
      return var1;
   }
}
