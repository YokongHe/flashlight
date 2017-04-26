package com.flurry.sdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.flurry.sdk.dz;
import com.flurry.sdk.eo;

class dz$a implements LocationListener {
   // $FF: synthetic field
   final dz a;

   public dz$a(dz var1) {
      this.a = var1;
   }

   public void onLocationChanged(Location var1) {
      if(var1 != null) {
         dz.a(this.a, var1);
      }

      eo.a(4, dz.h(), "Location received");
      if(dz.a(this.a) >= 3) {
         eo.a(4, dz.h(), "Max location reports reached, stopping");
         dz.b(this.a);
      }

   }

   public void onProviderDisabled(String var1) {
   }

   public void onProviderEnabled(String var1) {
   }

   public void onStatusChanged(String var1, int var2, Bundle var3) {
   }
}
