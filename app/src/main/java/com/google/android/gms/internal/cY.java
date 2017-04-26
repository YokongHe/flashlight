package com.google.android.gms.internal;

public final class cY {
   private final byte[] a = new byte[256];
   private int b;
   private int c;

   public cY(byte[] var1) {
      int var3;
      for(var3 = 0; var3 < 256; ++var3) {
         this.a[var3] = (byte)var3;
      }

      int var4 = 0;

      for(var3 = 0; var3 < 256; ++var3) {
         var4 = var4 + this.a[var3] + var1[var3 % var1.length] & 255;
         byte var2 = this.a[var3];
         this.a[var3] = this.a[var4];
         this.a[var4] = var2;
      }

      this.b = 0;
      this.c = 0;
   }

   public final void a(byte[] var1) {
      int var5 = this.b;
      int var4 = this.c;

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var5 = var5 + 1 & 255;
         var4 = var4 + this.a[var5] & 255;
         byte var2 = this.a[var5];
         this.a[var5] = this.a[var4];
         this.a[var4] = var2;
         var1[var3] ^= this.a[this.a[var5] + this.a[var4] & 255];
      }

      this.b = var5;
      this.c = var4;
   }
}
