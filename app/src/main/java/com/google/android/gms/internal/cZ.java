package com.google.android.gms.internal;

import com.google.android.gms.internal.df;

public final class cZ {
   private final byte[] a;
   private final int b;
   private int c;

   private cZ(byte[] var1, int var2, int var3) {
      this.a = var1;
      this.c = var2;
      this.b = var2 + var3;
   }

   public static com.google.android.gms.internal.cZ a(byte[] var0) {
      return new com.google.android.gms.internal.cZ(var0, 0, var0.length);
   }

   private void b(int var1) {
      while((var1 & -128) != 0) {
         this.a(var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.a(var1);
   }

   public final int a() {
      return this.b - this.c;
   }

   public final void a(int var1) {
      byte var2 = (byte)var1;
      if(this.c == this.b) {
         throw new com.google.android.gms.internal.da(this.c, this.b);
      } else {
         byte[] var3 = this.a;
         var1 = this.c;
         this.c = var1 + 1;
         var3[var1] = var2;
      }
   }

   public final void a(int var1, int var2) {
      this.b(df.a(var1, var2));
   }

   public final void a(int var1, String var2) {
      this.a(var1, 2);
      byte[] var3 = var2.getBytes("UTF-8");
      this.b(var3.length);
      var1 = var3.length;
      if(this.b - this.c >= var1) {
         System.arraycopy(var3, 0, this.a, this.c, var1);
         this.c += var1;
      } else {
         throw new com.google.android.gms.internal.da(this.c, this.b);
      }
   }
}
