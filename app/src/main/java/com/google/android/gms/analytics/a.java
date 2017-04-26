package com.google.android.gms.analytics;

public class a extends com.google.android.gms.analytics.c {
   private static com.google.android.gms.analytics.a b;
   private com.google.android.gms.analytics.b a;

   static com.google.android.gms.analytics.a a() {
      synchronized(com.google.android.gms.analytics.a.class) {
         com.google.android.gms.analytics.a var0 = b;
         return var0;
      }
   }

   public final com.google.android.gms.analytics.b b() {
      return this.a;
   }
}
