package com.google.android.gms.analytics;

public final class d {
   private static com.google.android.gms.analytics.a a;

   private static com.google.android.gms.analytics.b a() {
      if(a == null) {
         a = com.google.android.gms.analytics.a.a();
      }

      return a != null?a.b():null;
   }

   public static void a(String var0) {
      a();
   }

   public static void b(String var0) {
      a();
   }
}
