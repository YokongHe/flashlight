package com.tapjoy;

import android.content.Context;
import com.tapjoy.TapjoyAdIdClient;
import com.tapjoy.TapjoyIntegrationException;
import com.tapjoy.TapjoyLog;

public class TapjoyGpsHelper {
   private Context a;
   private String b;
   private boolean c;
   private int d = 0;
   private int e = 0;
   private boolean f;
   private Boolean g;
   private Boolean h;

   public TapjoyGpsHelper(Context var1) {
      this.a = var1;
   }

   public void checkGooglePlayIntegration() {
      if(!this.isGooglePlayServicesAvailable()) {
         throw new TapjoyIntegrationException("Tapjoy SDK is disabled because Google Play Services was not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
      } else if(!this.isGooglePlayManifestConfigured()) {
         throw new TapjoyIntegrationException("Failed to load manifest.xml meta-data, \'com.google.android.gms.version\' not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
      }
   }

   public String getAdvertisingId() {
      return this.b;
   }

   public int getDeviceGooglePlayServicesVersion() {
      return this.d;
   }

   public int getPackagedGooglePlayServicesVersion() {
      return this.e;
   }

   public boolean isAdIdAvailable() {
      return this.f;
   }

   public boolean isAdTrackingEnabled() {
      return this.c;
   }

   public boolean isGooglePlayManifestConfigured() {
      if(this.h == null) {
         try {
            this.e = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.getInt("com.google.android.gms.version");
            this.h = Boolean.valueOf(true);
         } catch (Exception var2) {
            this.h = Boolean.valueOf(false);
         }
      }

      return this.h.booleanValue();
   }

   public boolean isGooglePlayServicesAvailable() {
      if(this.g == null) {
         try {
            this.a.getClassLoader().loadClass("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            this.g = Boolean.valueOf(true);
         } catch (Exception var2) {
            this.g = Boolean.valueOf(false);
         } catch (Error var3) {
            this.g = Boolean.valueOf(false);
         }
      }

      return this.g.booleanValue();
   }

   public void loadAdvertisingId() {
      TapjoyLog.i("TapjoyGpsHelper", "Looking for Google Play Services...");
      if(this.isGooglePlayServicesAvailable() && this.isGooglePlayManifestConfigured()) {
         TapjoyLog.i("TapjoyGpsHelper", "Packaged Google Play Services found, fetching advertisingID...");
         TapjoyLog.i("TapjoyGpsHelper", "Packaged Google Play Services version: " + this.e);
         TapjoyAdIdClient var1 = new TapjoyAdIdClient(this.a);
         this.f = var1.setupAdIdInfo();

         try {
            this.d = this.a.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            TapjoyLog.i("TapjoyGpsHelper", "Device\'s Google Play Services version: " + this.d);
         } catch (Exception var3) {
            TapjoyLog.i("TapjoyGpsHelper", "Error getting device\'s Google Play Services version");
         }

         if(this.f) {
            this.c = var1.isAdTrackingEnabled();
            this.b = var1.getAdvertisingId();
            TapjoyLog.i("TapjoyGpsHelper", "Found advertising ID: " + this.b);
            TapjoyLog.i("TapjoyGpsHelper", "Is ad tracking enabled: " + Boolean.toString(this.c));
         } else {
            TapjoyLog.i("TapjoyGpsHelper", "Error getting advertisingID from Google Play Services");
         }
      } else {
         TapjoyLog.i("TapjoyGpsHelper", "Google Play Services not found");
      }
   }
}
