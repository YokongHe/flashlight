package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.mopub.common.MoPub$LocationAwareness;
import com.mopub.common.logging.MoPubLog;
import java.math.BigDecimal;

public class LocationService {
   public static Location getLastKnownLocation(Context var0, int var1, MoPub$LocationAwareness var2) {
      if(var2 != MoPub$LocationAwareness.DISABLED) {
         LocationManager var9 = (LocationManager)var0.getSystemService("location");

         Location var3;
         try {
            var3 = var9.getLastKnownLocation("gps");
         } catch (SecurityException var7) {
            MoPubLog.d("Failed to retrieve GPS location: access appears to be disabled.");
            var3 = null;
         } catch (IllegalArgumentException var8) {
            MoPubLog.d("Failed to retrieve GPS location: device has no GPS provider.");
            var3 = null;
         }

         Location var10;
         try {
            var10 = var9.getLastKnownLocation("network");
         } catch (SecurityException var5) {
            MoPubLog.d("Failed to retrieve network location: access appears to be disabled.");
            var10 = null;
         } catch (IllegalArgumentException var6) {
            MoPubLog.d("Failed to retrieve network location: device has no network provider.");
            var10 = null;
         }

         if(var3 != null || var10 != null) {
            Location var4;
            if(var3 != null && var10 != null) {
               if(var3.getTime() > var10.getTime()) {
                  var4 = var3;
               } else {
                  var4 = var10;
               }
            } else {
               var4 = var3;
               if(var3 == null) {
                  var4 = var10;
               }
            }

            if(var2 == MoPub$LocationAwareness.TRUNCATED) {
               var4.setLatitude(BigDecimal.valueOf(var4.getLatitude()).setScale(var1, 5).doubleValue());
               var4.setLongitude(BigDecimal.valueOf(var4.getLongitude()).setScale(var1, 5).doubleValue());
            }

            return var4;
         }
      }

      return null;
   }
}
