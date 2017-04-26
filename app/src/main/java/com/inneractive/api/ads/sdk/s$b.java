package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.s$a;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class s$b {
   private final String a;
   private final long[] b;
   private boolean c;
   private s$a d;
   private long e;
   // $FF: synthetic field
   private com.inneractive.api.ads.sdk.s f;

   private s$b(com.inneractive.api.ads.sdk.s var1, String var2) {
      this.f = var1;
      super();
      this.a = var2;
      this.b = new long[com.inneractive.api.ads.sdk.s.e(var1)];
   }

   // $FF: synthetic method
   s$b(com.inneractive.api.ads.sdk.s var1, String var2, byte var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static long a(s$b var0, long var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static s$a a(s$b var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static s$a a(s$b var0, s$a var1) {
      var0.d = var1;
      return var1;
   }

   private static IOException a(String[] var0) {
      throw new IOException("unexpected journal line: " + Arrays.toString(var0));
   }

   // $FF: synthetic method
   static void a(s$b var0, String[] var1) {
      if(var1.length != com.inneractive.api.ads.sdk.s.e(var0.f)) {
         throw a(var1);
      } else {
         int var2 = 0;

         while(true) {
            try {
               if(var2 >= var1.length) {
                  return;
               }

               var0.b[var2] = Long.parseLong(var1[var2]);
            } catch (NumberFormatException var3) {
               throw a(var1);
            }

            ++var2;
         }
      }
   }

   // $FF: synthetic method
   static boolean a(s$b var0, boolean var1) {
      var0.c = true;
      return true;
   }

   // $FF: synthetic method
   static long[] b(s$b var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static String c(s$b var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static boolean d(s$b var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static long e(s$b var0) {
      return var0.e;
   }

   final File a(int var1) {
      return new File(com.inneractive.api.ads.sdk.s.f(this.f), this.a + "." + var1);
   }

   final String a() {
      StringBuilder var5 = new StringBuilder();
      long[] var6 = this.b;
      int var2 = var6.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         long var3 = var6[var1];
         var5.append(' ').append(var3);
      }

      return var5.toString();
   }

   final File b(int var1) {
      return new File(com.inneractive.api.ads.sdk.s.f(this.f), this.a + "." + var1 + ".tmp");
   }
}
