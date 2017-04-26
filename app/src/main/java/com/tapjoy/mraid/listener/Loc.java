package com.tapjoy.mraid.listener;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.tapjoy.mraid.controller.MraidLocation;

public class Loc implements LocationListener {
   MraidLocation a;
   private LocationManager b;
   private String c;

   public Loc(Context var1, int var2, MraidLocation var3, String var4) {
      this.a = var3;
      this.b = (LocationManager)var1.getSystemService("location");
      this.c = var4;
   }

   public void onLocationChanged(Location var1) {
      this.a.success(var1);
   }

   public void onProviderDisabled(String var1) {
      this.a.fail();
   }

   public void onProviderEnabled(String var1) {
   }

   public void onStatusChanged(String var1, int var2, Bundle var3) {
      if(var2 == 0) {
         this.a.fail();
      }

   }

   public void start() {
      this.b.requestLocationUpdates(this.c, 0L, 0.0F, this);
   }

   public void stop() {
      this.b.removeUpdates(this);
   }
}
