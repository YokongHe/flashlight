package com.flurry.sdk;

import com.flurry.sdk.gb;
import com.flurry.sdk.gb$a;
import java.io.InputStream;

abstract class gb$c extends InputStream {
   protected gb$a a;

   protected void a() {
      this.a.a();
   }

   protected void a(int var1, gb var2) {
      gb.a(var2, new byte[var1]);
      gb.a((gb)var2, 0);
      gb.c(var2, 0);
      gb.b(var2, 0);
      this.a = new gb$a(var2, null);
   }

   protected abstract void a(long var1);

   protected abstract void a(byte[] var1, int var2, int var3);

   protected void a(byte[] var1, int var2, int var3, int var4) {
      System.arraycopy(var1, var2, var1, var3, var4);
      this.a.a(var3);
      var2 = this.b(var1, var3 + var4, var1.length - var4);
      this.a.b(var2 + var4);
   }

   public int available() {
      return this.a.c() - this.a.b();
   }

   protected abstract int b(byte[] var1, int var2, int var3);

   protected abstract long b(long var1);

   public int read(byte[] var1, int var2, int var3) {
      int var5 = this.a.c();
      int var4 = this.a.b();
      byte[] var6 = this.a.d();
      var5 -= var4;
      if(var5 >= var3) {
         System.arraycopy(var6, var4, var1, var2, var3);
         this.a.a(var4 + var3);
      } else {
         System.arraycopy(var6, var4, var1, var2, var5);
         this.a.a(var4 + var5);
         var2 = var5 + this.b(var1, var2 + var5, var3 - var5);
         var3 = var2;
         if(var2 == 0) {
            return -1;
         }
      }

      return var3;
   }

   public long skip(long var1) {
      int var3 = this.a.c();
      int var4 = this.a.b();
      int var5 = var3 - var4;
      if((long)var5 > var1) {
         var3 = (int)((long)var4 + var1);
         this.a.a(var3);
         return var1;
      } else {
         this.a.a(var3);
         return this.b(var1 - (long)var5) + (long)var5;
      }
   }
}
