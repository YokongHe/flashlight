package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.GooglePlayServices$AdvertisingInfo;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import java.io.IOException;

class GooglePlayServicesAdapter {
   private static final String LOG_TAG = GooglePlayServicesAdapter.class.getSimpleName();

   protected AdvertisingIdClient createAdvertisingIdClient() {
      return new AdvertisingIdClient();
   }

   public GooglePlayServices$AdvertisingInfo getAdvertisingIdentifierInfo() {
      Context var2 = InternalAdRegistration.getInstance().getApplicationContext();

      AdvertisingIdClient$Info var8;
      try {
         var8 = AdvertisingIdClient.getAdvertisingIdInfo(var2);
      } catch (IllegalStateException var4) {
         Log.e(LOG_TAG, "The Google Play Services Advertising Id API was called from a non-background thread.");
         return new GooglePlayServices$AdvertisingInfo();
      } catch (IOException var5) {
         Log.e(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused an IOException.");
         return new GooglePlayServices$AdvertisingInfo();
      } catch (com.google.android.gms.common.e var6) {
         Log.v(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.");
         return GooglePlayServices$AdvertisingInfo.createNotAvailable();
      } catch (com.google.android.gms.common.f var7) {
         Log.v(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.");
         return new GooglePlayServices$AdvertisingInfo();
      }

      Log.v(LOG_TAG, "The Google Play Services Advertising Identifier was successfully retrieved.");
      String var3 = var8.getId();
      boolean var1 = var8.isLimitAdTrackingEnabled();
      return (new GooglePlayServices$AdvertisingInfo()).setAdvertisingIdentifier(var3).setLimitAdTrackingEnabled(var1);
   }
}
