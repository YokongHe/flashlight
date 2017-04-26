package com.inmobi.commons.data;

import android.location.Location;
import android.location.LocationManager;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.List;

public class LocationInfo {
   public static int LOCATION_SET_BY_PUB = 0;
   public static int LOCATION_SET_BY_SDK = 1;
   private static LocationManager a;
   private static double b;
   private static double c;
   private static double d;
   private static boolean e;
   private static long f;
   private static int g;

   static {
      g = LOCATION_SET_BY_SDK;
   }

   private static LocationManager a() {
      synchronized(LocationInfo.class){}

      LocationManager var0;
      try {
         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   private static void a(double var0) {
      b = var0;
   }

   private static void a(long var0) {
      f = var0;
   }

   static void a(Location var0) {
      if(var0 != null) {
         e = true;
         b = var0.getLatitude();
         c = var0.getLongitude();
         d = (double)var0.getAccuracy();
         f = var0.getTime();
      } else {
         e = false;
      }
   }

   private static void a(LocationManager var0) {
      synchronized(LocationInfo.class){}

      try {
         a = var0;
      } finally {
         ;
      }

   }

   static void a(boolean var0) {
      e = var0;
   }

   private static void b(double var0) {
      c = var0;
   }

   private static boolean b() {
      // $FF: Couldn't be decompiled
   }

   private static Location c() {
      if(a() == null) {
         a((LocationManager)InternalSDKUtil.getContext().getSystemService("location"));
      }

      if(a() != null) {
         LocationManager var1 = a();
         List var2 = var1.getProviders(true);

         for(int var0 = var2.size() - 1; var0 >= 0; --var0) {
            String var3 = (String)var2.get(var0);
            if(var1.isProviderEnabled(var3)) {
               Location var4 = var1.getLastKnownLocation(var3);
               if(var4 != null) {
                  return var4;
               }
            }
         }
      }

      return null;
   }

   private static void c(double var0) {
      d = var0;
   }

   public static void collectLocationInfo() {
      synchronized(LocationInfo.class){}

      try {
         if(!isLocationPermissionsDenied() && b()) {
            g = LOCATION_SET_BY_SDK;
         }
      } catch (Exception var3) {
         Log.internal("[InMobi]-4.5.2", "Exception updating loc info", var3);
      } finally {
         ;
      }

   }

   public static String currentLocationStr() {
      StringBuilder var0 = new StringBuilder();
      if(!DemogInfo.isLocationInquiryAllowed()) {
         if(DemogInfo.getCurrentLocation() != null) {
            a(DemogInfo.getCurrentLocation());
         } else {
            a((Location)null);
         }

         setSDKLocation(LOCATION_SET_BY_PUB);
      } else if(!isValidGeoInfo() && DemogInfo.getCurrentLocation() != null) {
         a(DemogInfo.getCurrentLocation());
         setSDKLocation(LOCATION_SET_BY_PUB);
      }

      if(isValidGeoInfo()) {
         var0.append(getLat());
         var0.append(",");
         var0.append(getLon());
         var0.append(",");
         var0.append((int)getLocAccuracy());
         return var0.toString();
      } else {
         return "";
      }
   }

   public static long getGeoTS() {
      return f;
   }

   public static double getLat() {
      return b;
   }

   public static double getLocAccuracy() {
      return d;
   }

   public static double getLon() {
      return c;
   }

   public static boolean isLocationPermissionsDenied() {
      int var0 = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
      int var1 = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
      return var0 != 0 && var1 != 0;
   }

   public static int isSDKSetLocation() {
      return g;
   }

   public static boolean isValidGeoInfo() {
      return e;
   }

   public static void setSDKLocation(int var0) {
      g = var0;
   }
}
