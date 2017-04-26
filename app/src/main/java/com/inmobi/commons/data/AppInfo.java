package com.inmobi.commons.data;

public class AppInfo {
   private static String a;
   private static String b;
   private static String c;

   private static void a(String var0) {
      b = var0;
   }

   private static void b(String var0) {
      a = var0;
   }

   private static void c(String var0) {
      c = var0;
   }

   public static String getAppBId() {
      return a;
   }

   public static String getAppDisplayName() {
      return b;
   }

   public static String getAppVer() {
      return c;
   }

   public static void updateAppInfo() {
      // $FF: Couldn't be decompiled
   }
}
