package com.tapjoy;

import com.tapjoy.TJPlacement;
import com.tapjoy.TapjoyLog;

public class TJPlacementManager {
   private static int a = 0;
   private static int b = 3;
   private static final com.tapjoy.internal.be c = com.tapjoy.internal.be.a();

   public static boolean canCachePlacement() {
      return getPlacementCacheCount() < getPlacementCacheLimit();
   }

   public static void decrementPlacementCacheCount() {
      int var0 = a - 1;
      a = var0;
      if(var0 < 0) {
         a = 0;
      }

      printPlacementCacheInformation();
   }

   public static TJPlacement get(String var0) {
      com.tapjoy.internal.be var1 = c;
      synchronized(var1) {
         TJPlacement var3 = (TJPlacement)c.get(var0);
         return var3;
      }
   }

   public static int getPlacementCacheCount() {
      return a;
   }

   public static int getPlacementCacheLimit() {
      return b;
   }

   public static void incrementPlacementCacheCount() {
      int var0 = a + 1;
      a = var0;
      if(var0 > b) {
         a = b;
      }

      printPlacementCacheInformation();
   }

   public static void printPlacementCacheInformation() {
      TapjoyLog.i("TJPlacementManager", "Space available in placement cache: " + a + " out of " + b);
   }

   public static void put(String var0, TJPlacement var1) {
      com.tapjoy.internal.be var2 = c;
      synchronized(var2) {
         c.put(var0, var1);
      }
   }

   public static void setPlacementCacheLimit(int var0) {
      b = var0;
   }
}
