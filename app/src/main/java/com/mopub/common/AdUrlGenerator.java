package com.mopub.common;

import android.content.Context;
import android.location.Location;
import com.mopub.common.AdUrlGenerator$TwitterAppInstalledStatus;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata$MoPubNetworkType;
import com.mopub.common.LocationService;
import com.mopub.common.MoPub;
import com.mopub.common.util.Intents;

public abstract class AdUrlGenerator extends BaseUrlGenerator {
   private static AdUrlGenerator$TwitterAppInstalledStatus sTwitterAppInstalledStatus;
   protected String mAdUnitId;
   protected Context mContext;
   protected String mKeywords;
   protected Location mLocation;

   static {
      sTwitterAppInstalledStatus = AdUrlGenerator$TwitterAppInstalledStatus.UNKNOWN;
   }

   public AdUrlGenerator(Context var1) {
      this.mContext = var1;
   }

   private void addParam(String var1, ClientMetadata$MoPubNetworkType var2) {
      this.addParam(var1, var2.toString());
   }

   private int mncPortionLength(String var1) {
      return Math.min(3, var1.length());
   }

   @Deprecated
   public static void setTwitterAppInstalledStatus(AdUrlGenerator$TwitterAppInstalledStatus var0) {
      sTwitterAppInstalledStatus = var0;
   }

   public AdUrlGenerator$TwitterAppInstalledStatus getTwitterAppInstallStatus() {
      return Intents.canHandleTwitterUrl(this.mContext)?AdUrlGenerator$TwitterAppInstalledStatus.INSTALLED:AdUrlGenerator$TwitterAppInstalledStatus.NOT_INSTALLED;
   }

   protected void setAdUnitId(String var1) {
      this.addParam("id", var1);
   }

   protected void setCarrierName(String var1) {
      this.addParam("cn", var1);
   }

   protected void setDensity(float var1) {
      this.addParam("sc_a", "" + var1);
   }

   protected void setIsoCountryCode(String var1) {
      this.addParam("iso", var1);
   }

   protected void setKeywords(String var1) {
      this.addParam("q", var1);
   }

   protected void setLocation(Location var1) {
      Location var3 = LocationService.getLastKnownLocation(this.mContext, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
      Location var2 = var1;
      if(var3 != null) {
         label18: {
            if(var1 != null) {
               var2 = var1;
               if(var3.getTime() < var1.getTime()) {
                  break label18;
               }
            }

            var2 = var3;
         }
      }

      if(var2 != null) {
         this.addParam("ll", var2.getLatitude() + "," + var2.getLongitude());
         this.addParam("lla", "" + (int)var2.getAccuracy());
         if(var2 == var3) {
            this.addParam("llsdk", "1");
         }
      }

   }

   protected void setMccCode(String var1) {
      if(var1 == null) {
         var1 = "";
      } else {
         var1 = var1.substring(0, this.mncPortionLength(var1));
      }

      this.addParam("mcc", var1);
   }

   protected void setMncCode(String var1) {
      if(var1 == null) {
         var1 = "";
      } else {
         var1 = var1.substring(this.mncPortionLength(var1));
      }

      this.addParam("mnc", var1);
   }

   protected void setMraidFlag(boolean var1) {
      if(var1) {
         this.addParam("mr", "1");
      }

   }

   protected void setNetworkType(ClientMetadata$MoPubNetworkType var1) {
      this.addParam("ct", var1);
   }

   protected void setOrientation(String var1) {
      this.addParam("o", var1);
   }

   protected void setSdkVersion(String var1) {
      this.addParam("nv", var1);
   }

   protected void setTimezone(String var1) {
      this.addParam("z", var1);
   }

   protected void setTwitterAppInstalledFlag() {
      if(sTwitterAppInstalledStatus == AdUrlGenerator$TwitterAppInstalledStatus.UNKNOWN) {
         sTwitterAppInstalledStatus = this.getTwitterAppInstallStatus();
      }

      if(sTwitterAppInstalledStatus == AdUrlGenerator$TwitterAppInstalledStatus.INSTALLED) {
         this.addParam("ts", "1");
      }

   }

   public AdUrlGenerator withAdUnitId(String var1) {
      this.mAdUnitId = var1;
      return this;
   }

   @Deprecated
   public AdUrlGenerator withFacebookSupported(boolean var1) {
      return this;
   }

   public AdUrlGenerator withKeywords(String var1) {
      this.mKeywords = var1;
      return this;
   }

   public AdUrlGenerator withLocation(Location var1) {
      this.mLocation = var1;
      return this;
   }
}
