package com.mopub.volley;

import android.util.Log;
import java.util.Locale;

public class VolleyLog {
   public static boolean DEBUG = Log.isLoggable("Volley", 2);
   public static String TAG = "Volley";

   private static String buildMessage(String var0, Object... var1) {
      if(var1 != null) {
         var0 = String.format(Locale.US, var0, var1);
      }

      StackTraceElement[] var4 = (new Throwable()).fillInStackTrace().getStackTrace();
      int var2 = 2;

      String var5;
      while(true) {
         if(var2 >= var4.length) {
            var5 = "<unknown>";
            break;
         }

         if(!var4[var2].getClass().equals(VolleyLog.class)) {
            String var3 = var4[var2].getClassName();
            var3 = var3.substring(var3.lastIndexOf(46) + 1);
            var3 = var3.substring(var3.lastIndexOf(36) + 1);
            var5 = var3 + "." + var4[var2].getMethodName();
            break;
         }

         ++var2;
      }

      return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), var5, var0});
   }

   public static void d(String var0, Object... var1) {
      Log.d(TAG, buildMessage(var0, var1));
   }

   public static void e(String var0, Object... var1) {
      Log.e(TAG, buildMessage(var0, var1));
   }

   public static void e(Throwable var0, String var1, Object... var2) {
      Log.e(TAG, buildMessage(var1, var2), var0);
   }

   public static void setTag(String var0) {
      d("Changing log tag to %s", new Object[]{var0});
      TAG = var0;
      DEBUG = Log.isLoggable(var0, 2);
   }

   public static void v(String var0, Object... var1) {
      if(DEBUG) {
         Log.v(TAG, buildMessage(var0, var1));
      }

   }

   public static void wtf(String var0, Object... var1) {
      Log.wtf(TAG, buildMessage(var0, var1));
   }

   public static void wtf(Throwable var0, String var1, Object... var2) {
      Log.wtf(TAG, buildMessage(var1, var2), var0);
   }
}
