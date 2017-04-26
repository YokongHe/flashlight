package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;

public final class eo {
   private static int a = 4000;
   private static boolean b = false;
   private static int c = 5;
   private static boolean d = false;

   public static void a() {
      b = true;
   }

   public static void a(int var0) {
      c = var0;
   }

   public static void a(int var0, String var1, String var2) {
      c(var0, var1, var2);
   }

   public static void a(int var0, String var1, String var2, Throwable var3) {
      c(var0, var1, var2, var3);
   }

   public static void a(String var0, String var1) {
      b(3, var0, var1);
   }

   public static void a(String var0, String var1, Throwable var2) {
      b(6, var0, var1, var2);
   }

   public static void a(boolean var0) {
      d = var0;
   }

   public static void b() {
      b = false;
   }

   private static void b(int var0, String var1, String var2) {
      if(!b && c <= var0) {
         d(var0, var1, var2);
      }

   }

   private static void b(int var0, String var1, String var2, Throwable var3) {
      b(var0, var1, var2 + '\n' + Log.getStackTraceString(var3));
   }

   public static void b(String var0, String var1) {
      b(6, var0, var1);
   }

   public static void b(String var0, String var1, Throwable var2) {
      b(5, var0, var1, var2);
   }

   public static int c() {
      return c;
   }

   private static void c(int var0, String var1, String var2) {
      if(d) {
         d(var0, var1, var2);
      }

   }

   private static void c(int var0, String var1, String var2, Throwable var3) {
      c(var0, var1, var2 + '\n' + Log.getStackTraceString(var3));
   }

   public static void c(String var0, String var1) {
      b(2, var0, var1);
   }

   private static void d(int var0, String var1, String var2) {
      if(!d) {
         var1 = "FlurryAgent";
      }

      int var3;
      if(TextUtils.isEmpty(var2)) {
         var3 = 0;
      } else {
         var3 = var2.length();
      }

      int var4;
      for(int var5 = 0; var5 < var3; var5 = var4) {
         if(a > var3 - var5) {
            var4 = var3;
         } else {
            var4 = a + var5;
         }

         if(Log.println(var0, var1, var2.substring(var5, var4)) <= 0) {
            break;
         }
      }

   }

   public static void d(String var0, String var1) {
      b(5, var0, var1);
   }

   public static boolean d() {
      return d;
   }
}
