package com.tapjoy.internal;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class fa implements LocationListener {
   private static final String b = fa.class.getName();
   private Location a = null;

   public final Location a() {
      return this.a != null?new Location(this.a):null;
   }

   public void onLocationChanged(Location var1) {
      boolean var7 = true;
      String var11 = b;
      (new StringBuilder("onLocationChanged() : ")).append(var1.getProvider()).append(":").append(var1.getLatitude()).append(":").append(var1.getLongitude()).append(":").append(var1.getAccuracy());
      Location var12 = this.a;
      boolean var5;
      if(var12 == null) {
         var5 = var7;
      } else {
         long var8 = var1.getTime() - var12.getTime();
         boolean var3;
         if(var8 > 120000L) {
            var3 = true;
         } else {
            var3 = false;
         }

         boolean var4;
         if(var8 < -120000L) {
            var4 = true;
         } else {
            var4 = false;
         }

         boolean var2;
         if(var8 > 0L) {
            var2 = true;
         } else {
            var2 = false;
         }

         var5 = var7;
         if(!var3) {
            label67: {
               if(!var4) {
                  int var13 = (int)(var1.getAccuracy() - var12.getAccuracy());
                  if(var13 > 0) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  if(var13 < 0) {
                     var4 = true;
                  } else {
                     var4 = false;
                  }

                  boolean var6;
                  if(var13 > 200) {
                     var6 = true;
                  } else {
                     var6 = false;
                  }

                  var11 = var1.getProvider();
                  String var14 = var12.getProvider();
                  boolean var10;
                  if(var11 == null) {
                     if(var14 == null) {
                        var10 = true;
                     } else {
                        var10 = false;
                     }
                  } else {
                     var10 = var11.equals(var14);
                  }

                  var5 = var7;
                  if(var4) {
                     break label67;
                  }

                  if(var2) {
                     var5 = var7;
                     if(!var3) {
                        break label67;
                     }
                  }

                  if(var2 && !var6) {
                     var5 = var7;
                     if(var10) {
                        break label67;
                     }
                  }
               }

               var5 = false;
            }
         }
      }

      if(var5) {
         this.a = var1;
      }

   }

   public void onProviderDisabled(String var1) {
      String var2 = b;
      (new StringBuilder("onProviderDisabled: ")).append(var1);
   }

   public void onProviderEnabled(String var1) {
      String var2 = b;
      (new StringBuilder("onProviderEnabled: ")).append(var1);
   }

   public void onStatusChanged(String var1, int var2, Bundle var3) {
      String var4 = b;
      StringBuilder var5 = (new StringBuilder("onStatusChanged: ")).append(var1).append(" status: ");
      if(var2 == 2) {
         var1 = "available ";
      } else if(var2 == 1) {
         var1 = "temporarily unavailable";
      } else if(var2 == 0) {
         var1 = "Out of Service";
      } else {
         var1 = "unknown";
      }

      var5.append(var1);
   }
}
