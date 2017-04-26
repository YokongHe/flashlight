package com.flurry.sdk;

import com.flurry.sdk.si;
import com.flurry.sdk.si$a;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class sj extends OutputStream {
   private static final byte[] a = new byte[0];
   private final si b;
   private final LinkedList c;
   private int d;
   private byte[] e;
   private int f;

   public sj() {
      this((si)null);
   }

   public sj(int var1) {
      this((si)null, var1);
   }

   public sj(si var1) {
      this(var1, 500);
   }

   public sj(si var1, int var2) {
      this.c = new LinkedList();
      this.b = var1;
      if(var1 == null) {
         this.e = new byte[var2];
      } else {
         this.e = var1.a(si$a.c);
      }
   }

   private void g() {
      int var1 = 262144;
      this.d += this.e.length;
      int var2 = Math.max(this.d >> 1, 1000);
      if(var2 <= 262144) {
         var1 = var2;
      }

      this.c.add(this.e);
      this.e = new byte[var1];
      this.f = 0;
   }

   public final void a() {
      this.d = 0;
      this.f = 0;
      if(!this.c.isEmpty()) {
         this.c.clear();
      }

   }

   public final void a(int var1) {
      if(this.f >= this.e.length) {
         this.g();
      }

      byte[] var3 = this.e;
      int var2 = this.f;
      this.f = var2 + 1;
      var3[var2] = (byte)var1;
   }

   public final void b(int var1) {
      if(this.f + 1 < this.e.length) {
         byte[] var3 = this.e;
         int var2 = this.f;
         this.f = var2 + 1;
         var3[var2] = (byte)(var1 >> 8);
         var3 = this.e;
         var2 = this.f;
         this.f = var2 + 1;
         var3[var2] = (byte)var1;
      } else {
         this.a(var1 >> 8);
         this.a(var1);
      }
   }

   public final byte[] b() {
      int var2 = this.d + this.f;
      if(var2 == 0) {
         return a;
      } else {
         byte[] var4 = new byte[var2];
         Iterator var5 = this.c.iterator();

         int var1;
         int var3;
         for(var1 = 0; var5.hasNext(); var1 += var3) {
            byte[] var6 = (byte[])var5.next();
            var3 = var6.length;
            System.arraycopy(var6, 0, var4, var1, var3);
         }

         System.arraycopy(this.e, 0, var4, var1, this.f);
         var1 += this.f;
         if(var1 != var2) {
            throw new RuntimeException("Internal error: total len assumed to be " + var2 + ", copied " + var1 + " bytes");
         } else {
            if(!this.c.isEmpty()) {
               this.a();
            }

            return var4;
         }
      }
   }

   public final void c(int var1) {
      if(this.f + 2 < this.e.length) {
         byte[] var3 = this.e;
         int var2 = this.f;
         this.f = var2 + 1;
         var3[var2] = (byte)(var1 >> 16);
         var3 = this.e;
         var2 = this.f;
         this.f = var2 + 1;
         var3[var2] = (byte)(var1 >> 8);
         var3 = this.e;
         var2 = this.f;
         this.f = var2 + 1;
         var3[var2] = (byte)var1;
      } else {
         this.a(var1 >> 16);
         this.a(var1 >> 8);
         this.a(var1);
      }
   }

   public final byte[] c() {
      this.a();
      return this.e;
   }

   public final void close() {
   }

   public final byte[] d() {
      this.g();
      return this.e;
   }

   public final byte[] d(int var1) {
      this.f = var1;
      return this.b();
   }

   public final void e(int var1) {
      this.f = var1;
   }

   public final byte[] e() {
      return this.e;
   }

   public final int f() {
      return this.f;
   }

   public final void flush() {
   }

   public final void write(int var1) {
      this.a(var1);
   }

   public final void write(byte[] var1) {
      this.write(var1, 0, var1.length);
   }

   public final void write(byte[] var1, int var2, int var3) {
      int var4 = var2;

      while(true) {
         int var6 = Math.min(this.e.length - this.f, var3);
         int var5 = var4;
         var2 = var3;
         if(var6 > 0) {
            System.arraycopy(var1, var4, this.e, this.f, var6);
            var5 = var4 + var6;
            this.f += var6;
            var2 = var3 - var6;
         }

         if(var2 <= 0) {
            return;
         }

         this.g();
         var4 = var5;
         var3 = var2;
      }
   }
}
