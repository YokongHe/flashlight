package com.mopub.common.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Streams {
   public static void closeStream(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
            ;
         }
      }
   }

   public static void copyContent(InputStream var0, OutputStream var1) {
      if(var0 != null && var1 != null) {
         byte[] var3 = new byte[16384];

         while(true) {
            int var2 = var0.read(var3);
            if(var2 == -1) {
               return;
            }

            var1.write(var3, 0, var2);
         }
      } else {
         throw new IOException("Unable to copy from or to a null stream.");
      }
   }

   public static void copyContent(InputStream var0, OutputStream var1, long var2) {
      if(var0 != null && var1 != null) {
         byte[] var7 = new byte[16384];
         long var5 = 0L;

         while(true) {
            int var4 = var0.read(var7);
            if(var4 == -1) {
               return;
            }

            var5 += (long)var4;
            if(var5 >= var2) {
               throw new IOException("Error copying content: attempted to copy " + var5 + " bytes, with " + var2 + " maximum.");
            }

            var1.write(var7, 0, var4);
         }
      } else {
         throw new IOException("Unable to copy from or to a null stream.");
      }
   }

   public static void readStream(InputStream var0, byte[] var1) {
      int var3 = 0;
      int var2 = var1.length;

      int var4;
      do {
         var4 = var0.read(var1, var3, var2);
         if(var4 == -1) {
            return;
         }

         var3 += var4;
         var4 = var2 - var4;
         var2 = var4;
      } while(var4 > 0);

   }
}
