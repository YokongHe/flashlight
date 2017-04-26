package com.tapjoy.internal;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class bi extends FilterInputStream {
   public bi(InputStream var1) {
      super(var1);
   }

   public final int read(byte[] var1) {
      int var2;
      int var3;
      for(var2 = 0; var2 < var1.length; var2 += var3) {
         var3 = super.read(var1, var2, var1.length - var2);
         if(var3 == -1) {
            if(var2 == 0) {
               return -1;
            }
            break;
         }
      }

      return var2;
   }

   public final int read(byte[] var1, int var2, int var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < var3; var4 += var5) {
         var5 = super.read(var1, var2 + var4, var3 - var4);
         if(var5 == -1) {
            if(var4 == 0) {
               return -1;
            }
            break;
         }
      }

      return var4;
   }

   public final long skip(long var1) {
      long var3;
      long var5;
      for(var3 = 0L; var3 < var1; var3 += var5) {
         long var7 = super.skip(var1 - var3);
         var5 = var7;
         if(var7 == 0L) {
            if(super.read() < 0) {
               break;
            }

            var5 = var7 + 1L;
         }
      }

      return var3;
   }
}
