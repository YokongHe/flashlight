package com.nexage.android.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class r {
   private static int a = 1;
   private static long b = 0L;

   public static int a() {
      com.nexage.android.a.p.c("SessionDepthManager", "getSessionDepth");
      SharedPreferences var0 = com.nexage.android.a.m.b.getSharedPreferences("com.nexage.SessionDepth", 0);
      a = var0.getInt("SessionDepthKey", 1);
      b = var0.getLong("LastDisplayKey", 0L);
      if(System.currentTimeMillis() - b > 900000L) {
         a = 1;
         c();
      }

      com.nexage.android.a.p.c("SessionDepthManager", "returning sessionDepth " + a);
      return a;
   }

   public static void b() {
      com.nexage.android.a.p.c("SessionDepthManager", "incrementSessionDepth");
      ++a;
      c();
   }

   private static void c() {
      Editor var2 = com.nexage.android.a.m.b.getSharedPreferences("com.nexage.SessionDepth", 0).edit();
      long var0 = System.currentTimeMillis();
      var2.putInt("SessionDepthKey", a);
      var2.putLong("LastDisplayKey", var0);
      var2.commit();
   }
}
