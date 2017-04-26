package com.google.android.gms.internal;

import android.util.Log;

public final class bJ {
   public static void a(String var0) {
      if(a(3)) {
         Log.d("Ads", var0);
      }

   }

   public static void a(String var0, Throwable var1) {
      if(a(6)) {
         Log.e("Ads", var0, var1);
      }

   }

   public static boolean a(int var0) {
      return (var0 >= 5 || Log.isLoggable("Ads", var0)) && var0 != 2;
   }

   public static void b(String var0) {
      if(a(6)) {
         Log.e("Ads", var0);
      }

   }

   public static void b(String var0, Throwable var1) {
      if(a(5)) {
         Log.w("Ads", var0, var1);
      }

   }

   public static void c(String var0) {
      if(a(4)) {
         Log.i("Ads", var0);
      }

   }

   public static void d(String var0) {
      if(a(2)) {
         Log.v("Ads", var0);
      }

   }

   public static void e(String var0) {
      if(a(5)) {
         Log.w("Ads", var0);
      }

   }
}
