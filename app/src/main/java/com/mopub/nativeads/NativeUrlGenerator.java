package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.util.DateAndTime;
import com.mopub.nativeads.RequestParameters;

class NativeUrlGenerator extends AdUrlGenerator {
   private String mDesiredAssets;
   private String mSequenceNumber;

   NativeUrlGenerator(Context var1) {
      super(var1);
   }

   private void setDesiredAssets() {
      if(!TextUtils.isEmpty(this.mDesiredAssets)) {
         this.addParam("assets", this.mDesiredAssets);
      }

   }

   private void setSequenceNumber() {
      if(!TextUtils.isEmpty(this.mSequenceNumber)) {
         this.addParam("MAGIC_NO", this.mSequenceNumber);
      }

   }

   public String generateUrlString(String var1) {
      this.initUrlString(var1, "/m/ad");
      this.setAdUnitId(this.mAdUnitId);
      this.setKeywords(this.mKeywords);
      this.setLocation(this.mLocation);
      ClientMetadata var3 = ClientMetadata.getInstance(this.mContext);
      this.setSdkVersion(var3.getSdkVersion());
      this.setDeviceInfo(new String[]{var3.getDeviceManufacturer(), var3.getDeviceModel(), var3.getDeviceProduct()});
      this.setTimezone(DateAndTime.getTimeZoneOffsetString());
      this.setOrientation(var3.getOrientationString());
      this.setDensity(var3.getDensity());
      String var2 = var3.getNetworkOperatorForUrl();
      this.setMccCode(var2);
      this.setMncCode(var2);
      this.setIsoCountryCode(var3.getIsoCountryCode());
      this.setCarrierName(var3.getNetworkOperatorName());
      this.setNetworkType(var3.getActiveNetworkType());
      this.setAppVersion(var3.getAppVersion());
      this.setTwitterAppInstalledFlag();
      this.setDesiredAssets();
      this.setSequenceNumber();
      this.appendAdvertisingInfoTemplates();
      return this.getFinalUrlString();
   }

   protected void setSdkVersion(String var1) {
      this.addParam("nsv", var1);
   }

   public NativeUrlGenerator withAdUnitId(String var1) {
      this.mAdUnitId = var1;
      return this;
   }

   NativeUrlGenerator withRequest(RequestParameters var1) {
      if(var1 != null) {
         this.mKeywords = var1.getKeywords();
         this.mLocation = var1.getLocation();
         this.mDesiredAssets = var1.getDesiredAssets();
      }

      return this;
   }

   NativeUrlGenerator withSequenceNumber(int var1) {
      this.mSequenceNumber = String.valueOf(var1);
      return this;
   }
}
