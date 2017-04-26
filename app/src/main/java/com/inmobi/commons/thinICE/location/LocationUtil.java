package com.inmobi.commons.thinICE.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.inmobi.commons.thinICE.location.LocationInfo;
import java.util.HashMap;

public final class LocationUtil {
   private static LocationInfo a(Context var0, String var1) {
      Location var2 = ((LocationManager)var0.getSystemService("location")).getLastKnownLocation(var1);
      if(var2 == null) {
         return null;
      } else {
         LocationInfo var3 = new LocationInfo();
         var3.time = var2.getTime();
         var3.provider = var2.getProvider();
         var3.latitude = var2.getLatitude();
         var3.longitude = var2.getLongitude();
         var3.accuracy = var2.getAccuracy();
         return var3;
      }
   }

   public static HashMap getLastKnownLocations(Context var0) {
      HashMap var1 = new HashMap();
      if(hasFineLocationPermission(var0)) {
         var1.put("gps", a(var0, "gps"));
      }

      if(hasCoarseLocationPermission(var0)) {
         var1.put("network", a(var0, "network"));
      }

      return var1;
   }

   public static boolean hasCoarseLocationPermission(Context var0) {
      return var0.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
   }

   public static boolean hasFineLocationPermission(Context var0) {
      return var0.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
   }

   public static boolean hasLocationPermission(Context var0) {
      return hasFineLocationPermission(var0) || hasCoarseLocationPermission(var0);
   }
}
