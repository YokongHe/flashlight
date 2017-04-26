package com.google.android.gms.internal;

import com.google.android.gms.internal.dj;
import java.io.IOException;

final class dm implements dj {
   private com.google.android.gms.internal.cZ a;
   private byte[] b;
   private final int c = 239;

   public dm(int var1) {
      this.a();
   }

   public final void a() {
      this.b = new byte[this.c];
      this.a = com.google.android.gms.internal.cZ.a(this.b);
   }

   public final void a(int var1, long var2) {
      com.google.android.gms.internal.cZ var4 = this.a;
      var4.a(var1, 0);

      while((-128L & var2) != 0L) {
         var4.a((int)var2 & 127 | 128);
         var2 >>>= 7;
      }

      var4.a((int)var2);
   }

   public final void a(int var1, String var2) {
      this.a.a(var1, var2);
   }

   public final byte[] b() {
      int var1 = this.a.a();
      if(var1 < 0) {
         throw new IOException();
      } else if(var1 == 0) {
         return this.b;
      } else {
         byte[] var2 = new byte[this.b.length - var1];
         System.arraycopy(this.b, 0, var2, 0, var2.length);
         return var2;
      }
   }
}
