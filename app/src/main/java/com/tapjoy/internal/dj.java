package com.tapjoy.internal;

import com.tapjoy.internal.dh;
import com.tapjoy.internal.dj$a;
import com.tapjoy.internal.dq;
import com.tapjoy.internal.dx;
import java.io.OutputStream;

public final class dj {
   final int a;
   int b;
   final OutputStream c;
   private final byte[] d;
   private int e = 0;

   private dj(OutputStream var1, byte[] var2) {
      this.c = var1;
      this.d = var2;
      this.b = 0;
      this.a = var2.length;
   }

   dj(byte[] var1, int var2) {
      this.c = null;
      this.d = var1;
      this.b = 0;
      this.a = var2 + 0;
   }

   public static dj a(OutputStream var0, int var1) {
      return new dj(var0, new byte[var1]);
   }

   public static int b(int var0) {
      return d(1) + g(var0);
   }

   public static int b(int var0, int var1) {
      return d(var0) + g(var1);
   }

   public static int b(int var0, long var1) {
      int var3 = d(var0);
      byte var4;
      if((-128L & var1) == 0L) {
         var4 = 1;
      } else if((-16384L & var1) == 0L) {
         var4 = 2;
      } else if((-2097152L & var1) == 0L) {
         var4 = 3;
      } else if((-268435456L & var1) == 0L) {
         var4 = 4;
      } else if((-34359738368L & var1) == 0L) {
         var4 = 5;
      } else if((-4398046511104L & var1) == 0L) {
         var4 = 6;
      } else if((-562949953421312L & var1) == 0L) {
         var4 = 7;
      } else if((-72057594037927936L & var1) == 0L) {
         var4 = 8;
      } else if((Long.MIN_VALUE & var1) == 0L) {
         var4 = 9;
      } else {
         var4 = 10;
      }

      return var4 + var3;
   }

   public static int b(int var0, dh var1) {
      return d(var0) + h(var1.a()) + var1.a();
   }

   public static int b(int var0, dq var1) {
      var0 = d(var0);
      int var2 = var1.b();
      return var0 + var2 + h(var2);
   }

   private void b() {
      if(this.c == null) {
         throw new dj$a();
      } else {
         this.c.write(this.d, 0, this.b);
         this.b = 0;
      }
   }

   public static int d(int var0) {
      return h(dx.a(var0, 0));
   }

   private void f(int var1) {
      if(var1 >= 0) {
         this.e(var1);
      } else {
         this.a((long)var1);
      }
   }

   private static int g(int var0) {
      return var0 >= 0?h(var0):10;
   }

   private static int h(int var0) {
      return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((-2097152 & var0) == 0?3:((-268435456 & var0) == 0?4:5)));
   }

   public final void a() {
      if(this.c != null) {
         this.b();
      }

   }

   public final void a(int var1) {
      this.c(1, 0);
      this.f(var1);
   }

   public final void a(int var1, double var2) {
      this.c(var1, 1);
      this.b(Double.doubleToRawLongBits(var2));
   }

   public final void a(int var1, int var2) {
      this.c(var1, 0);
      this.f(var2);
   }

   public final void a(int var1, long var2) {
      this.c(var1, 0);
      this.a(var2);
   }

   public final void a(int var1, dh var2) {
      this.c(var1, 2);
      this.a(var2);
   }

   public final void a(int var1, dq var2) {
      this.c(var1, 2);
      this.e(var2.b());
      var2.a(this);
   }

   public final void a(long var1) {
      while((-128L & var1) != 0L) {
         this.c((int)var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.c((int)var1);
   }

   public final void a(dh var1) {
      this.e(var1.a());
      this.b(var1);
   }

   public final void b(long var1) {
      this.c((int)var1 & 255);
      this.c((int)(var1 >> 8) & 255);
      this.c((int)(var1 >> 16) & 255);
      this.c((int)(var1 >> 24) & 255);
      this.c((int)(var1 >> 32) & 255);
      this.c((int)(var1 >> 40) & 255);
      this.c((int)(var1 >> 48) & 255);
      this.c((int)(var1 >> 56) & 255);
   }

   public final void b(dh var1) {
      int var2 = var1.a();
      if(this.a - this.b >= var2) {
         var1.b(this.d, 0, this.b, var2);
         this.b += var2;
      } else {
         int var3 = this.a - this.b;
         var1.b(this.d, 0, this.b, var3);
         int var4 = var3 + 0;
         var2 -= var3;
         this.b = this.a;
         this.e += var3;
         this.b();
         if(var2 <= this.a) {
            var1.b(this.d, var4, 0, var2);
            this.b = var2;
         } else {
            var1.a(this.c, var4, var2);
         }
      }

      this.e += var2;
   }

   public final void c(int var1) {
      byte var2 = (byte)var1;
      if(this.b == this.a) {
         this.b();
      }

      byte[] var3 = this.d;
      var1 = this.b;
      this.b = var1 + 1;
      var3[var1] = var2;
      ++this.e;
   }

   public final void c(int var1, int var2) {
      this.e(dx.a(var1, var2));
   }

   public final void e(int var1) {
      while((var1 & -128) != 0) {
         this.c(var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.c(var1);
   }
}
