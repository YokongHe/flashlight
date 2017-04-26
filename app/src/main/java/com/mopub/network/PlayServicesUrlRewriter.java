package com.mopub.network;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper$AdvertisingInfo;
import com.mopub.volley.toolbox.HurlStack$UrlRewriter;

public class PlayServicesUrlRewriter implements HurlStack$UrlRewriter {
   public static final String DO_NOT_TRACK_TEMPLATE = "mp_tmpl_do_not_track";
   private static final String IFA_PREFIX = "ifa:";
   public static final String UDID_TEMPLATE = "mp_tmpl_advertising_id";
   private final Context applicationContext;
   private final String deviceIdentifier;

   public PlayServicesUrlRewriter(String var1, Context var2) {
      this.deviceIdentifier = var1;
      this.applicationContext = var2.getApplicationContext();
   }

   public String rewriteUrl(String var1) {
      if(!var1.contains("mp_tmpl_advertising_id") && !var1.contains("mp_tmpl_do_not_track")) {
         return var1;
      } else {
         GpsHelper$AdvertisingInfo var2;
         String var4;
         label22: {
            GpsHelper$AdvertisingInfo var3 = new GpsHelper$AdvertisingInfo(this.deviceIdentifier, false);
            if(GpsHelper.isPlayServicesAvailable(this.applicationContext)) {
               var2 = GpsHelper.fetchAdvertisingInfoSync(this.applicationContext);
               if(var2 != null) {
                  var4 = "ifa:";
                  break label22;
               }
            }

            var2 = var3;
            var4 = "";
         }

         var4 = var1.replace("mp_tmpl_advertising_id", Uri.encode(var4 + var2.advertisingId));
         if(var2.limitAdTracking) {
            var1 = "1";
         } else {
            var1 = "0";
         }

         return var4.replace("mp_tmpl_do_not_track", var1);
      }
   }
}
