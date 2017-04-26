package com.mopub.common;

import android.os.Build.VERSION;
import com.mopub.common.ClientMetadata;
import com.mopub.network.AdResponse;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AdReport implements Serializable {
   private static final String DATE_FORMAT_PATTERN = "M/d/yy hh:mm:ss a z";
   private static final long serialVersionUID = 1L;
   private final AdResponse mAdResponse;
   private final String mAdUnitId;
   private final Locale mDeviceLocale;
   private final String mDeviceModel;
   private final String mSdkVersion;
   private final String mUdid;

   public AdReport(String var1, ClientMetadata var2, AdResponse var3) {
      this.mAdUnitId = var1;
      this.mSdkVersion = var2.getSdkVersion();
      this.mDeviceModel = var2.getDeviceModel();
      this.mDeviceLocale = var2.getDeviceLocale();
      this.mUdid = var2.getDeviceId();
      this.mAdResponse = var3;
   }

   private void appendKeyValue(StringBuilder var1, String var2, String var3) {
      var1.append(var2);
      var1.append(" : ");
      var1.append(var3);
      var1.append("\n");
   }

   private String getFormattedTimeStamp(long var1) {
      return var1 != -1L?(new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US)).format(new Date(var1)):null;
   }

   public String getResponseString() {
      return this.mAdResponse.getStringBody();
   }

   public String toString() {
      StringBuilder var4 = new StringBuilder();
      this.appendKeyValue(var4, "sdk_version", this.mSdkVersion);
      this.appendKeyValue(var4, "creative_id", this.mAdResponse.getDspCreativeId());
      this.appendKeyValue(var4, "platform_version", Integer.toString(VERSION.SDK_INT));
      this.appendKeyValue(var4, "device_model", this.mDeviceModel);
      this.appendKeyValue(var4, "ad_unit_id", this.mAdUnitId);
      String var1;
      if(this.mDeviceLocale == null) {
         var1 = null;
      } else {
         var1 = this.mDeviceLocale.toString();
      }

      this.appendKeyValue(var4, "device_locale", var1);
      this.appendKeyValue(var4, "device_id", this.mUdid);
      this.appendKeyValue(var4, "network_type", this.mAdResponse.getNetworkType());
      this.appendKeyValue(var4, "platform", "android");
      this.appendKeyValue(var4, "timestamp", this.getFormattedTimeStamp(this.mAdResponse.getTimestamp()));
      this.appendKeyValue(var4, "ad_type", this.mAdResponse.getAdType());
      Integer var3 = this.mAdResponse.getWidth();
      Integer var2 = this.mAdResponse.getHeight();
      StringBuilder var5 = new StringBuilder("{");
      Object var6 = var3;
      if(var3 == null) {
         var6 = "0";
      }

      StringBuilder var7 = var5.append(var6).append(", ");
      if(var2 == null) {
         var6 = "0";
      } else {
         var6 = var2;
      }

      this.appendKeyValue(var4, "ad_size", var7.append(var6).append("}").toString());
      return var4.toString();
   }
}
