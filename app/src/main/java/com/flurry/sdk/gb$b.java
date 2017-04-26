package com.flurry.sdk;

import com.flurry.sdk.gb;
import com.flurry.sdk.gb$a;
import com.flurry.sdk.gb$c;
import java.io.EOFException;

class gb$b extends gb$c {
   private byte[] b;
   private int c;
   private int d;
   private boolean e;

   private gb$b(byte[] var1, int var2, int var3) {
      this.e = false;
      if(var1.length >= 16 && var3 >= 16) {
         this.b = var1;
         this.c = var2;
         this.d = var2 + var3;
      } else {
         this.b = new byte[16];
         System.arraycopy(var1, var2, this.b, 0, var3);
         this.c = 0;
         this.d = var3;
      }
   }

   // $FF: synthetic method
   gb$b(byte[] var1, int var2, int var3, Object var4) {
      this(var1, var2, var3);
   }

   protected void a(int var1, gb var2) {
      gb.a(var2, this.b);
      gb.a(var2, this.c);
      gb.c(var2, this.c);
      gb.b(var2, this.d);
      this.a = new gb$a(var2, null);
   }

   protected void a(long var1) {
      if(this.b(var1) < var1) {
         throw new EOFException();
      }
   }

   protected void a(byte[] var1, int var2, int var3) {
      if(this.b(var1, var2, var3) < var3) {
         throw new EOFException();
      }
   }

   protected void a(byte[] var1, int var2, int var3, int var4) {
      if(!this.e) {
         byte[] var5 = new byte[var4 + 16];
         System.arraycopy(var1, var2, var5, 0, var4);
         this.a.a(var5, 0, var4);
         this.e = true;
      }

   }

   protected int b(byte[] var1, int var2, int var3) {
      return 0;
   }

   protected long b(long var1) {
      this.d = this.a.c();
      this.c = this.a.b();
      long var3 = (long)(this.d - this.c);
      if(var3 >= var1) {
         this.c = (int)((long)this.c + var1);
         this.a.a(this.c);
         return var1;
      } else {
         this.c = (int)((long)this.c + var3);
         this.a.a(this.c);
         return var3;
      }
   }

   public void close() {
      this.a.a(this.a.c());
   }

   public int read() {
      this.d = this.a.c();
      this.c = this.a.b();
      if(this.c >= this.d) {
         return -1;
      } else {
         byte[] var2 = this.a.d();
         int var1 = this.c;
         this.c = var1 + 1;
         byte var3 = var2[var1];
         this.a.a(this.c);
         return var3 & 255;
      }
   }
}
