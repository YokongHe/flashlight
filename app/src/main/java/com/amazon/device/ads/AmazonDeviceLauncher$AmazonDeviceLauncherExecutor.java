package com.amazon.device.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

class AmazonDeviceLauncher$AmazonDeviceLauncherExecutor {
   boolean isWindowshopPresent(Context var1) {
      return var1.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop") != null;
   }

   void launchWindowshopDetailPage(Context var1, String var2) {
      Intent var3 = var1.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop");
      if(var3 != null) {
         var3.putExtra("com.amazon.windowshop.refinement.asin", var2);
         var1.startActivity(var3);
      }

   }

   void launchWindowshopSearchPage(Context var1, String var2) {
      Intent var3 = new Intent("android.intent.action.SEARCH");
      var3.setComponent(new ComponentName("com.amazon.windowshop", "com.amazon.windowshop.search.SearchResultsGridActivity"));
      var3.putExtra("query", var2);

      try {
         var1.startActivity(var3);
      } catch (RuntimeException var4) {
         ;
      }
   }
}
