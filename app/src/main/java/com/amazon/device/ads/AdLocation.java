package com.amazon.device.ads;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.amazon.device.ads.AdLocation$LocationAwareness;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;

class AdLocation {
   private static final String LOG_TAG = "AdLocation";
   private static final float MAX_DISTANCE_IN_KILOMETERS = 3.0F;
   private int arcminutePrecision;
   private AdLocation$LocationAwareness locationAwareness;

   public AdLocation() {
      this.locationAwareness = AdLocation$LocationAwareness.LOCATION_AWARENESS_TRUNCATED;
      this.arcminutePrecision = 6;
   }

   private static double roundToArcminutes(double var0) {
      return (double)Math.round(var0 * 60.0D) / 60.0D;
   }

   public Location getLocation() {
      float var2 = Float.MAX_VALUE;
      Context var3 = InternalAdRegistration.getInstance().getApplicationContext();
      if(this.locationAwareness != AdLocation$LocationAwareness.LOCATION_AWARENESS_DISABLED) {
         LocationManager var9 = (LocationManager)var3.getSystemService("location");

         Location var4;
         try {
            var4 = var9.getLastKnownLocation("gps");
         } catch (SecurityException var7) {
            Log.d("AdLocation", "Failed to retrieve GPS location: No permissions to access GPS");
            var4 = null;
         } catch (IllegalArgumentException var8) {
            Log.d("AdLocation", "Failed to retrieve GPS location: No GPS found");
            var4 = null;
         }

         Location var10;
         try {
            var10 = var9.getLastKnownLocation("network");
         } catch (SecurityException var5) {
            Log.d("AdLocation", "Failed to retrieve network location: No permissions to access network location");
            var10 = null;
         } catch (IllegalArgumentException var6) {
            Log.d("AdLocation", "Failed to retrieve network location: No network provider found");
            var10 = null;
         }

         if(var4 != null || var10 != null) {
            if(var4 != null && var10 != null) {
               if(var4.distanceTo(var10) / 1000.0F <= 3.0F) {
                  float var1;
                  if(var4.hasAccuracy()) {
                     var1 = var4.getAccuracy();
                  } else {
                     var1 = Float.MAX_VALUE;
                  }

                  if(var10.hasAccuracy()) {
                     var2 = var10.getAccuracy();
                  }

                  if(var1 < var2) {
                     Log.d("AdLocation", "Setting lat/long using GPS determined by distance");
                  } else {
                     Log.d("AdLocation", "Setting lat/long using network determined by distance");
                     var4 = var10;
                  }
               } else if(var4.getTime() > var10.getTime()) {
                  Log.d("AdLocation", "Setting lat/long using GPS");
               } else {
                  Log.d("AdLocation", "Setting lat/long using network");
                  var4 = var10;
               }
            } else if(var4 != null) {
               Log.d("AdLocation", "Setting lat/long using GPS, not network");
            } else {
               Log.d("AdLocation", "Setting lat/long using network location, not GPS");
               var4 = var10;
            }

            if(this.locationAwareness == AdLocation$LocationAwareness.LOCATION_AWARENESS_TRUNCATED) {
               var4.setLatitude((double)Math.round(roundToArcminutes(var4.getLatitude()) * Math.pow(10.0D, (double)this.arcminutePrecision)) / Math.pow(10.0D, (double)this.arcminutePrecision));
               var4.setLongitude((double)Math.round(roundToArcminutes(var4.getLongitude()) * Math.pow(10.0D, (double)this.arcminutePrecision)) / Math.pow(10.0D, (double)this.arcminutePrecision));
            }

            return var4;
         }
      }

      return null;
   }
}
