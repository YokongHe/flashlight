package com.flurry.sdk;

import com.flurry.sdk.ie;
import java.io.InputStream;

public final class ih extends InputStream {
   protected final ie a;
   final InputStream b;
   byte[] c;
   int d;
   final int e;

   public ih(ie var1, InputStream var2, byte[] var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   private void a() {
      byte[] var1 = this.c;
      if(var1 != null) {
         this.c = null;
         if(this.a != null) {
            this.a.a(var1);
         }
      }

   }

   public final int available() {
      return this.c != null?this.e - this.d:this.b.available();
   }

   public final void close() {
      this.a();
      this.b.close();
   }

   public final void mark(int var1) {
      if(this.c == null) {
         this.b.mark(var1);
      }

   }

   public final boolean markSupported() {
      return this.c == null && this.b.markSupported();
   }

   public final int read() {
      if(this.c != null) {
         byte[] var2 = this.c;
         int var1 = this.d;
         this.d = var1 + 1;
         byte var3 = var2[var1];
         if(this.d >= this.e) {
            this.a();
         }

         return var3 & 255;
      } else {
         return this.b.read();
      }
   }

   public final int read(byte[] var1) {
      return this.read(var1, 0, var1.length);
   }

   public final int read(byte[] var1, int var2, int var3) {
      if(this.c != null) {
         int var5 = this.e - this.d;
         int var4 = var3;
         if(var3 > var5) {
            var4 = var5;
         }

         System.arraycopy(this.c, this.d, var1, var2, var4);
         this.d += var4;
         if(this.d >= this.e) {
            this.a();
         }

         return var4;
      } else {
         return this.b.read(var1, var2, var3);
      }
   }

   public final void reset() {
      if(this.c == null) {
         this.b.reset();
      }

   }

   public final long skip(long var1) {
      long var4;
      if(this.c != null) {
         int var3 = this.e - this.d;
         if((long)var3 > var1) {
            this.d += (int)var1;
            return var1;
         }

         this.a();
         var4 = (long)var3 + 0L;
         var1 -= (long)var3;
      } else {
         var4 = 0L;
      }

      long var6 = var4;
      if(var1 > 0L) {
         var6 = var4 + this.b.skip(var1);
      }

      return var6;
   }
}
