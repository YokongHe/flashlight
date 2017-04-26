package com.tapjoy.mraid.controller;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.listener.Loc;
import com.tapjoy.mraid.view.MraidView;
import java.util.Iterator;

public class MraidLocation extends Abstract {
   final int c = 1000;
   private LocationManager d;
   private boolean e = false;
   private Loc f;
   private Loc g;
   private int h;
   private boolean i = false;

   public MraidLocation(MraidView var1, Context var2) {
      super(var1, var2);

      try {
         this.d = (LocationManager)var2.getSystemService("location");
         if(this.d.getProvider("gps") != null) {
            this.f = new Loc(var2, 1000, this, "gps");
         }

         if(this.d.getProvider("network") != null) {
            this.g = new Loc(var2, 1000, this, "network");
         }

         this.e = true;
      } catch (SecurityException var3) {
         ;
      }
   }

   private static String a(Location var0) {
      return "{ lat: " + var0.getLatitude() + ", lon: " + var0.getLongitude() + ", acc: " + var0.getAccuracy() + "}";
   }

   public void allowLocationServices(boolean var1) {
      this.i = var1;
   }

   public boolean allowLocationServices() {
      return this.i;
   }

   public void fail() {
      TapjoyLog.e("MRAID Location", "Location can\'t be determined");
      this.a.injectMraidJavaScript("window.mraidview.fireErrorEvent(\"Location cannot be identified\", \"OrmmaLocationController\")");
   }

   public String getLocation() {
      TapjoyLog.d("MRAID Location", "getLocation: hasPermission: " + this.e);
      if(this.e) {
         Iterator var3 = this.d.getProviders(true).iterator();
         Location var1 = null;

         while(var3.hasNext()) {
            Location var2 = this.d.getLastKnownLocation((String)var3.next());
            var1 = var2;
            if(var2 != null) {
               var1 = var2;
               break;
            }
         }

         TapjoyLog.d("MRAID Location", "getLocation: " + var1);
         if(var1 != null) {
            return a(var1);
         }
      }

      return null;
   }

   public void startLocationListener() {
      if(this.h == 0) {
         if(this.g != null) {
            this.g.start();
         }

         if(this.f != null) {
            this.f.start();
         }
      }

      ++this.h;
   }

   public void stopAllListeners() {
      this.h = 0;

      try {
         this.f.stop();
      } catch (Exception var3) {
         ;
      }

      try {
         this.g.stop();
      } catch (Exception var2) {
         ;
      }
   }

   public void stopLocationListener() {
      --this.h;
      if(this.h == 0) {
         if(this.g != null) {
            this.g.stop();
         }

         if(this.f != null) {
            this.f.stop();
         }
      }

   }

   public void success(Location var1) {
      String var2 = "window.mraidview.fireChangeEvent({ location: " + a(var1) + "})";
      TapjoyLog.d("MRAID Location", var2);
      this.a.injectMraidJavaScript(var2);
   }
}
