package com.flurry.sdk;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public final class fj {
   static final Charset a = Charset.forName("US-ASCII");
   static final Charset b = Charset.forName("UTF-8");

   static void a(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (RuntimeException var1) {
            throw var1;
         } catch (Exception var2) {
            return;
         }
      }

   }

   static void a(File var0) {
      File[] var3 = var0.listFiles();
      if(var3 == null) {
         throw new IOException("not a readable directory: " + var0);
      } else {
         int var2 = var3.length;

         for(int var1 = 0; var1 < var2; ++var1) {
            var0 = var3[var1];
            if(var0.isDirectory()) {
               a(var0);
            }

            if(!var0.delete()) {
               throw new IOException("failed to delete file: " + var0);
            }
         }

      }
   }
}
