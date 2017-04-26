package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdSize;

class AdControllerFactory {
   private static AdController cachedAdController = null;

   public static AdController buildAdController(Context var0, AdSize var1) {
      try {
         AdController var3 = new AdController(var0, var1);
         return var3;
      } catch (IllegalStateException var2) {
         return null;
      }
   }

   public static void cacheAdController(AdController var0) {
      cachedAdController = var0;
   }

   public static AdController getCachedAdController() {
      return cachedAdController;
   }

   public static AdController removeCachedAdController() {
      AdController var0 = cachedAdController;
      cachedAdController = null;
      return var0;
   }
}
