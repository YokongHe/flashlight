package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AmazonDeviceLauncher$AmazonDeviceLauncherExecutor;

class AmazonDeviceLauncher {
   private static AmazonDeviceLauncher$AmazonDeviceLauncherExecutor executor = new AmazonDeviceLauncher$AmazonDeviceLauncherExecutor();

   public static boolean isWindowshopPresent(Context var0) {
      return executor.isWindowshopPresent(var0);
   }

   public static void launchWindowshopDetailPage(Context var0, String var1) {
      executor.launchWindowshopDetailPage(var0, var1);
   }

   static void launchWindowshopSearchPage(Context var0, String var1) {
      executor.launchWindowshopSearchPage(var0, var1);
   }
}
