package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;

class PositioningUrlGenerator extends BaseUrlGenerator {
   private static final String POSITIONING_API_VERSION = "1";
   private String mAdUnitId;
   private final Context mContext;

   public PositioningUrlGenerator(Context var1) {
      this.mContext = var1;
   }

   private void setAdUnitId(String var1) {
      this.addParam("id", var1);
   }

   private void setSdkVersion(String var1) {
      this.addParam("nsv", var1);
   }

   public String generateUrlString(String var1) {
      this.initUrlString(var1, "/m/pos");
      this.addParam("id", this.mAdUnitId);
      this.setApiVersion("1");
      ClientMetadata var2 = ClientMetadata.getInstance(this.mContext);
      this.addParam("nsv", var2.getSdkVersion());
      this.setDeviceInfo(new String[]{var2.getDeviceManufacturer(), var2.getDeviceModel(), var2.getDeviceProduct()});
      this.setAppVersion(var2.getAppVersion());
      this.appendAdvertisingInfoTemplates();
      return this.getFinalUrlString();
   }

   public PositioningUrlGenerator withAdUnitId(String var1) {
      this.mAdUnitId = var1;
      return this;
   }
}
