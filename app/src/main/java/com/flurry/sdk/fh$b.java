package com.flurry.sdk;

import com.flurry.sdk.fh;
import com.flurry.sdk.fh$a;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class fh$b {
   // $FF: synthetic field
   final fh a;
   private final String b;
   private final long[] c;
   private boolean d;
   private fh$a e;
   private long f;

   private fh$b(fh var1, String var2) {
      this.a = var1;
      this.b = var2;
      this.c = new long[fh.e(var1)];
   }

   // $FF: synthetic method
   fh$b(fh var1, String var2, Object var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static long a(fh$b var0, long var1) {
      var0.f = var1;
      return var1;
   }

   // $FF: synthetic method
   static fh$a a(fh$b var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static fh$a a(fh$b var0, fh$a var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static void a(fh$b var0, String[] var1) {
      var0.a(var1);
   }

   private void a(String[] var1) {
      if(var1.length != fh.e(this.a)) {
         throw this.b(var1);
      } else {
         int var2 = 0;

         while(true) {
            try {
               if(var2 >= var1.length) {
                  return;
               }

               this.c[var2] = Long.parseLong(var1[var2]);
            } catch (NumberFormatException var4) {
               throw this.b(var1);
            }

            ++var2;
         }
      }
   }

   // $FF: synthetic method
   static boolean a(fh$b var0, boolean var1) {
      var0.d = var1;
      return var1;
   }

   private IOException b(String[] var1) {
      throw new IOException("unexpected journal line: " + Arrays.toString(var1));
   }

   // $FF: synthetic method
   static long[] b(fh$b var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static String c(fh$b var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static boolean d(fh$b var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static long e(fh$b var0) {
      return var0.f;
   }

   public final File a(int var1) {
      return new File(fh.f(this.a), this.b + "." + var1);
   }

   public final String a() {
      StringBuilder var5 = new StringBuilder();
      long[] var6 = this.c;
      int var2 = var6.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         long var3 = var6[var1];
         var5.append(' ').append(var3);
      }

      return var5.toString();
   }

   public final File b(int var1) {
      return new File(fh.f(this.a), this.b + "." + var1 + ".tmp");
   }
}
