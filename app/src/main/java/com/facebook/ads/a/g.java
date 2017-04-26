package com.facebook.ads.a;

import java.util.Locale;

public enum g {
   a,
   b,
   c;

   public static com.facebook.ads.a.g a(String var0) {
      if(com.facebook.ads.a.ag.a(var0)) {
         return a;
      } else {
         try {
            com.facebook.ads.a.g var2 = valueOf(var0.toUpperCase(Locale.US));
            return var2;
         } catch (IllegalArgumentException var1) {
            return a;
         }
      }
   }
}
