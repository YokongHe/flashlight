package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.PermissionChecker$PermissionCheckerExecutor;

class PermissionChecker {
   private static PermissionChecker$PermissionCheckerExecutor executor = new PermissionChecker$PermissionCheckerExecutor();

   public static final boolean hasInternetPermission(Context var0) {
      return hasPermission(var0, "android.permission.INTERNET");
   }

   public static final boolean hasPermission(Context var0, String var1) {
      return executor.hasPermission(var0, var1);
   }

   public static final boolean hasPhonePermission(Context var0) {
      return hasPermission(var0, "android.permission.CALL_PHONE");
   }

   public static final boolean hasReadCalendarPermission(Context var0) {
      return hasPermission(var0, "android.permission.READ_CALENDAR");
   }

   public static final boolean hasSmsPermission(Context var0) {
      return hasPermission(var0, "android.permission.SEND_SMS");
   }

   public static final boolean hasWriteCalendarPermission(Context var0) {
      return hasPermission(var0, "android.permission.WRITE_CALENDAR");
   }

   public static final boolean hasWriteExternalStoragePermission(Context var0) {
      return hasPermission(var0, "android.permission.WRITE_EXTERNAL_STORAGE");
   }
}
