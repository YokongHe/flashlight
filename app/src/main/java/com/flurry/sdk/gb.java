package com.flurry.sdk;

import com.flurry.sdk.gb$a;
import com.flurry.sdk.gb$b;
import com.flurry.sdk.gb$c;
import com.flurry.sdk.gb$d;
import com.flurry.sdk.gf;
import com.flurry.sdk.gy;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class gb extends gf {
   private gb$c a = null;
   private byte[] b = null;
   private int c = 0;
   private int d = 0;
   private int e = 0;
   private final gy f = new gy();

   protected gb() {
   }

   gb(InputStream var1, int var2) {
      this.a(var1, var2);
   }

   gb(byte[] var1, int var2, int var3) {
      this.a(var1, var2, var3);
   }

   // $FF: synthetic method
   static int a(gb var0, int var1) {
      var0.d = var1;
      return var1;
   }

   private void a(int var1, gb$c var2) {
      if(this.a != null) {
         this.a.a();
      }

      var2.a(var1, this);
      this.a = var2;
   }

   // $FF: synthetic method
   static byte[] a(gb var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static byte[] a(gb var0, byte[] var1) {
      var0.b = var1;
      return var1;
   }

   // $FF: synthetic method
   static int b(gb var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static int b(gb var0, int var1) {
      var0.e = var1;
      return var1;
   }

   private long b(long var1) {
      byte var3 = 1;
      int var4 = this.b[this.d] & 255;
      long var5 = ((long)var4 & 127L) << 28 ^ var1;
      var1 = var5;
      if(var4 > 127) {
         byte[] var7 = this.b;
         var4 = this.d;
         var3 = 2;
         var4 = var7[var4 + 1] & 255;
         var5 ^= ((long)var4 & 127L) << 35;
         var1 = var5;
         if(var4 > 127) {
            var7 = this.b;
            var4 = this.d;
            var3 = 3;
            var4 = var7[var4 + 2] & 255;
            var5 ^= ((long)var4 & 127L) << 42;
            var1 = var5;
            if(var4 > 127) {
               var7 = this.b;
               var4 = this.d;
               var3 = 4;
               var4 = var7[var4 + 3] & 255;
               var5 ^= ((long)var4 & 127L) << 49;
               var1 = var5;
               if(var4 > 127) {
                  var7 = this.b;
                  var4 = this.d;
                  var3 = 5;
                  var4 = var7[var4 + 4] & 255;
                  var5 ^= ((long)var4 & 127L) << 56;
                  var1 = var5;
                  if(var4 > 127) {
                     var7 = this.b;
                     var4 = this.d;
                     var3 = 6;
                     var4 = var7[var4 + 5] & 255;
                     var1 = var5 ^ ((long)var4 & 127L) << 63;
                     if(var4 > 127) {
                        throw new IOException("Invalid long encoding");
                     }
                  }
               }
            }
         }
      }

      this.d += var3;
      return var1;
   }

   private void b(int var1) {
      int var2 = this.e - this.d;
      if(var2 < var1) {
         this.a.a(this.b, this.d, this.c, var2);
      }

   }

   // $FF: synthetic method
   static int c(gb var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static int c(gb var0, int var1) {
      var0.c = var1;
      return var1;
   }

   private long t() {
      long var1;
      for(var1 = (long)this.d(); var1 < 0L; var1 = (long)this.d()) {
         this.a(this.e());
      }

      return var1;
   }

   gb$a a() {
      return new gb$a(this, null);
   }

   gb a(InputStream var1, int var2) {
      this.a(var2, new gb$d(var1, null));
      return this;
   }

   gb a(byte[] var1, int var2, int var3) {
      this.a(8192, new gb$b(var1, var2, var3, null));
      return this;
   }

   public gy a(gy var1) {
      int var2 = this.d();
      if(var1 == null) {
         var1 = new gy();
      }

      var1.a(var2);
      if(var2 != 0) {
         this.c(var1.a(), 0, var2);
      }

      return var1;
   }

   public ByteBuffer a(ByteBuffer var1) {
      int var2 = this.d();
      if(var1 != null && var2 <= var1.capacity()) {
         var1.clear();
      } else {
         var1 = ByteBuffer.allocate(var2);
      }

      this.c(var1.array(), var1.position(), var2);
      var1.limit(var2);
      return var1;
   }

   public void a(int var1) {
      this.a((long)var1);
   }

   protected void a(long var1) {
      int var3 = this.e - this.d;
      if(var1 <= (long)var3) {
         this.d = (int)((long)this.d + var1);
      } else {
         this.d = 0;
         this.e = 0;
         long var4 = (long)var3;
         this.a.a(var1 - var4);
      }
   }

   public void b() {
   }

   public void b(byte[] var1, int var2, int var3) {
      this.c(var1, var2, var3);
   }

   protected void c(byte[] var1, int var2, int var3) {
      int var4 = this.e - this.d;
      if(var3 <= var4) {
         System.arraycopy(this.b, this.d, var1, var2, var3);
         this.d += var3;
      } else {
         System.arraycopy(this.b, this.d, var1, var2, var4);
         this.d = this.e;
         this.a.a(var1, var2 + var4, var3 - var4);
      }
   }

   public boolean c() {
      if(this.e == this.d) {
         this.e = this.a.b(this.b, 0, this.b.length);
         this.d = 0;
         if(this.e == 0) {
            throw new EOFException();
         }
      }

      byte[] var2 = this.b;
      int var1 = this.d;
      this.d = var1 + 1;
      return (var2[var1] & 255) == 1;
   }

   public int d() {
      byte var3 = 5;
      this.b(5);
      byte var2 = 1;
      int var5 = this.b[this.d] & 255;
      int var4 = var5 & 127;
      int var1 = var4;
      if(var5 > 127) {
         byte[] var6 = this.b;
         var1 = this.d;
         var2 = 2;
         var5 = var6[var1 + 1] & 255;
         var4 ^= (var5 & 127) << 7;
         var1 = var4;
         if(var5 > 127) {
            var6 = this.b;
            var1 = this.d;
            var2 = 3;
            var5 = var6[var1 + 2] & 255;
            var4 ^= (var5 & 127) << 14;
            var1 = var4;
            if(var5 > 127) {
               var6 = this.b;
               var1 = this.d;
               var2 = 4;
               var5 = var6[var1 + 3] & 255;
               var4 ^= (var5 & 127) << 21;
               var1 = var4;
               if(var5 > 127) {
                  var5 = this.b[this.d + 4] & 255;
                  var1 = var4 ^ (var5 & 127) << 28;
                  var2 = var3;
                  if(var5 > 127) {
                     throw new IOException("Invalid int encoding");
                  }
               }
            }
         }
      }

      this.d += var2;
      if(this.d > this.e) {
         throw new EOFException();
      } else {
         return -(var1 & 1) ^ var1 >>> 1;
      }
   }

   public long e() {
      this.b(10);
      byte[] var5 = this.b;
      int var1 = this.d;
      this.d = var1 + 1;
      int var2 = var5[var1] & 255;
      var1 = var2 & 127;
      long var3;
      if(var2 > 127) {
         var5 = this.b;
         var2 = this.d;
         this.d = var2 + 1;
         var2 = var5[var2] & 255;
         var1 ^= (var2 & 127) << 7;
         if(var2 > 127) {
            var5 = this.b;
            var2 = this.d;
            this.d = var2 + 1;
            var2 = var5[var2] & 255;
            var1 ^= (var2 & 127) << 14;
            if(var2 > 127) {
               var5 = this.b;
               var2 = this.d;
               this.d = var2 + 1;
               var2 = var5[var2] & 255;
               var1 ^= (var2 & 127) << 21;
               if(var2 > 127) {
                  var3 = this.b((long)var1);
               } else {
                  var3 = (long)var1;
               }
            } else {
               var3 = (long)var1;
            }
         } else {
            var3 = (long)var1;
         }
      } else {
         var3 = (long)var1;
      }

      if(this.d > this.e) {
         throw new EOFException();
      } else {
         return -(var3 & 1L) ^ var3 >>> 1;
      }
   }

   public float f() {
      this.b(4);
      byte var1 = this.b[this.d];
      byte var2 = this.b[this.d + 1];
      byte var3 = this.b[this.d + 2];
      byte var4 = this.b[this.d + 3];
      if(this.d + 4 > this.e) {
         throw new EOFException();
      } else {
         this.d += 4;
         return Float.intBitsToFloat(var1 & 255 | (var2 & 255) << 8 | (var3 & 255) << 16 | (var4 & 255) << 24);
      }
   }

   public double g() {
      this.b(8);
      byte var1 = this.b[this.d];
      byte var2 = this.b[this.d + 1];
      byte var3 = this.b[this.d + 2];
      byte var4 = this.b[this.d + 3];
      byte var5 = this.b[this.d + 4];
      byte var6 = this.b[this.d + 5];
      byte var7 = this.b[this.d + 6];
      byte var8 = this.b[this.d + 7];
      if(this.d + 8 > this.e) {
         throw new EOFException();
      } else {
         this.d += 8;
         long var9 = (long)(var1 & 255 | (var2 & 255) << 8 | (var3 & 255) << 16 | (var4 & 255) << 24);
         return Double.longBitsToDouble((long)(var5 & 255 | (var6 & 255) << 8 | (var7 & 255) << 16 | (var8 & 255) << 24) << 32 | var9 & 4294967295L);
      }
   }

   public String h() {
      return this.a(this.f).toString();
   }

   public void i() {
      this.a((long)this.d());
   }

   public void j() {
      this.a((long)this.d());
   }

   public int k() {
      return this.d();
   }

   protected long l() {
      long var3 = this.e();
      long var1 = var3;
      if(var3 < 0L) {
         this.e();
         var1 = -var3;
      }

      return var1;
   }

   public long m() {
      return this.l();
   }

   public long n() {
      return this.l();
   }

   public long o() {
      return this.t();
   }

   public long p() {
      return this.l();
   }

   public long q() {
      return this.l();
   }

   public long r() {
      return this.t();
   }

   public int s() {
      return this.d();
   }
}
