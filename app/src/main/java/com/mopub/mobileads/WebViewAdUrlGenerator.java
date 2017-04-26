package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.util.DateAndTime;

public class WebViewAdUrlGenerator extends AdUrlGenerator {
   private final boolean mIsStorePictureSupported;

   public WebViewAdUrlGenerator(Context var1, boolean var2) {
      super(var1);
      this.mIsStorePictureSupported = var2;
   }

   public String generateUrlString(String var1) {
      this.initUrlString(var1, "/m/ad");
      ClientMetadata var3 = ClientMetadata.getInstance(this.mContext);
      this.setApiVersion("6");
      this.setAdUnitId(this.mAdUnitId);
      this.setSdkVersion(var3.getSdkVersion());
      this.setDeviceInfo(new String[]{var3.getDeviceManufacturer(), var3.getDeviceModel(), var3.getDeviceProduct()});
      this.setKeywords(this.mKeywords);
      this.setLocation(this.mLocation);
      this.setTimezone(DateAndTime.getTimeZoneOffsetString());
      this.setOrientation(var3.getOrientationString());
      this.setDensity(var3.getDensity());
      this.setMraidFlag(true);
      String var2 = var3.getNetworkOperatorForUrl();
      this.setMccCode(var2);
      this.setMncCode(var2);
      this.setIsoCountryCode(var3.getIsoCountryCode());
      this.setCarrierName(var3.getNetworkOperatorName());
      this.setNetworkType(var3.getActiveNetworkType());
      this.setAppVersion(var3.getAppVersion());
      this.setExternalStoragePermission(this.mIsStorePictureSupported);
      this.setTwitterAppInstalledFlag();
      this.appendAdvertisingInfoTemplates();
      return this.getFinalUrlString();
   }
}
