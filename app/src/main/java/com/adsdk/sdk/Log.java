package com.adsdk.sdk;

import android.content.Context;

public final class Log {
   public static boolean LOGGING_ENABLED = false;

   public static void d(String var0) {
      d("ADSDK", var0);
   }

   public static void d(String var0, String var1) {
      if(isLoggingEnabled()) {
         android.util.Log.d(var0, var1, (Throwable)null);
      }

   }

   public static void d(String var0, String var1, Throwable var2) {
      if(isLoggingEnabled()) {
         android.util.Log.d(var0, var1, var2);
      }

   }

   public static void d(String var0, Throwable var1) {
      if(isLoggingEnabled()) {
         android.util.Log.d("ADSDK", var0, var1);
      }

   }

   public static void e(String var0) {
      e("ADSDK", var0);
   }

   public static void e(String var0, String var1) {
      if(isLoggingEnabled()) {
         android.util.Log.w(var0, var1, (Throwable)null);
      }

   }

   public static void e(String var0, String var1, Throwable var2) {
      if(isLoggingEnabled()) {
         android.util.Log.w(var0, var1, var2);
      }

   }

   public static void e(String var0, Throwable var1) {
      if(isLoggingEnabled()) {
         android.util.Log.w("ADSDK", var0, var1);
      }

   }

   public static void i(String var0) {
      i("ADSDK", var0);
   }

   public static void i(String var0, String var1) {
      if(isLoggingEnabled()) {
         android.util.Log.i(var0, var1, (Throwable)null);
      }

   }

   public static void i(String var0, String var1, Throwable var2) {
      if(isLoggingEnabled()) {
         android.util.Log.i(var0, var1, var2);
      }

   }

   public static void i(String var0, Throwable var1) {
      if(isLoggingEnabled()) {
         android.util.Log.i("ADSDK", var0, var1);
      }

   }

   private static boolean isLoggingEnabled() {
      return LOGGING_ENABLED;
   }

   public static boolean isLoggingEnabled(Context var0) {
      int var1 = var0.getResources().getIdentifier("adsdk_debug_enabled", "string", var0.getPackageName());
      return var1 != 0 && var0.getResources().getString(var1).equalsIgnoreCase("true");
   }

   public static void v(String var0) {
      v("ADSDK", var0);
   }

   public static void v(String var0, String var1) {
      if(isLoggingEnabled()) {
         android.util.Log.v(var0, var1, (Throwable)null);
      }

   }

   public static void v(String var0, String var1, Throwable var2) {
      if(isLoggingEnabled()) {
         android.util.Log.v(var0, var1, var2);
      }

   }

   public static void v(String var0, Throwable var1) {
      if(isLoggingEnabled()) {
         android.util.Log.v("ADSDK", var0, var1);
      }

   }

   public static void w(String var0) {
      w("ADSDK", var0);
   }

   public static void w(String var0, String var1) {
      if(isLoggingEnabled()) {
         android.util.Log.w(var0, var1, (Throwable)null);
      }

   }

   public static void w(String var0, String var1, Throwable var2) {
      if(isLoggingEnabled()) {
         android.util.Log.w(var0, var1, var2);
      }

   }

   public static void w(String var0, Throwable var1) {
      if(isLoggingEnabled()) {
         android.util.Log.w("ADSDK", var0, var1);
      }

   }
}
