package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class AdSettings {
   private static final String DEVICE_ID_HASH_PREFS_KEY = "deviceIdHash";
   private static final String PREFS_NAME = "FBAdPrefs";
   public static final String TAG = AdSettings.class.getSimpleName();
   private static boolean childDirected = false;
   private static String deviceIdHash = null;
   private static final Collection emulatorProducts;
   static volatile boolean testDeviceNoticeDisplayed;
   private static final Collection testDevices = new HashSet();
   private static String urlPrefix = null;

   static {
      HashSet var0 = new HashSet();
      emulatorProducts = var0;
      var0.add("sdk");
      emulatorProducts.add("google_sdk");
      emulatorProducts.add("vbox86p");
      emulatorProducts.add("vbox86tp");
      testDeviceNoticeDisplayed = false;
   }

   public static void addTestDevice(String var0) {
      testDevices.add(var0);
   }

   public static void addTestDevices(Collection var0) {
      testDevices.addAll(var0);
   }

   public static void clearTestDevices() {
      testDevices.clear();
   }

   public static String getUrlPrefix() {
      return urlPrefix;
   }

   public static boolean isChildDirected() {
      return childDirected;
   }

   public static boolean isTestMode(Context var0) {
      if(!emulatorProducts.contains(Build.PRODUCT)) {
         if(deviceIdHash == null) {
            SharedPreferences var2 = var0.getSharedPreferences("FBAdPrefs", 0);
            String var1 = var2.getString("deviceIdHash", (String)null);
            deviceIdHash = var1;
            if(com.facebook.ads.a.ag.a(var1)) {
               deviceIdHash = com.facebook.ads.a.ag.b(UUID.randomUUID().toString());
               var2.edit().putString("deviceIdHash", deviceIdHash).apply();
            }
         }

         if(!testDevices.contains(deviceIdHash)) {
            printTestDeviceNotice(deviceIdHash);
            return false;
         }
      }

      return true;
   }

   private static void printTestDeviceNotice(String var0) {
      if(!testDeviceNoticeDisplayed) {
         testDeviceNoticeDisplayed = true;
         Log.d(TAG, "Test mode device hash: " + var0);
         Log.d(TAG, "When testing your app with Facebook\'s ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + var0 + "\");");
      }
   }

   public static void setIsChildDirected(boolean var0) {
      childDirected = var0;
   }

   public static void setUrlPrefix(String var0) {
      urlPrefix = var0;
   }
}
