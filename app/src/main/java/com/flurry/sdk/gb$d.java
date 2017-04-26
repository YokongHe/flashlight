package com.flurry.sdk;

import com.flurry.sdk.gb$c;
import java.io.EOFException;
import java.io.InputStream;

class gb$d extends gb$c {
   protected boolean b;
   private InputStream c;

   private gb$d(InputStream var1) {
      this.b = false;
      this.c = var1;
   }

   // $FF: synthetic method
   gb$d(InputStream var1, Object var2) {
      this(var1);
   }

   protected void a(long var1) {
      boolean var3 = false;

      while(var1 > 0L) {
         long var4 = this.c.skip(var1);
         if(var4 > 0L) {
            var1 -= var4;
         } else {
            if(var4 != 0L) {
               this.b = true;
               throw new EOFException();
            }

            if(var3) {
               this.b = true;
               throw new EOFException();
            }

            var3 = true;
         }
      }

   }

   protected void a(byte[] var1, int var2, int var3) {
      while(var3 > 0) {
         int var4 = this.c.read(var1, var2, var3);
         if(var4 < 0) {
            this.b = true;
            throw new EOFException();
         }

         var3 -= var4;
         var2 += var4;
      }

   }

   protected int b(byte[] param1, int param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   protected long b(long param1) {
      // $FF: Couldn't be decompiled
   }

   public void close() {
      this.c.close();
   }

   public int read() {
      if(this.a.c() - this.a.b() == 0) {
         return this.c.read();
      } else {
         int var1 = this.a.b();
         byte var2 = this.a.d()[var1];
         this.a.a(var1 + 1);
         return var2 & 255;
      }
   }
}
