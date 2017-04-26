package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.AdvertisingIdentifier$Info;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.Configuration$ConfigOption;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.SISRequest;
import com.amazon.device.ads.WebRequest$QueryStringParameters;
import com.amazon.device.ads.WebUtils;
import java.util.HashMap;

abstract class SISDeviceRequest implements SISRequest {
   private AdvertisingIdentifier$Info advertisingIdentifierInfo;
   private Metrics$MetricType callMetricType;
   private String logTag;
   private String path;

   private static String convertOptOutBooleanToStringInt(boolean var0) {
      return var0?"1":"0";
   }

   public static String getDInfoProperty() {
      DeviceInfo var0 = InternalAdRegistration.getInstance().getDeviceInfo();
      return String.format("{\"make\":\"%s\",\"model\":\"%s\",\"os\":\"%s\",\"osVersion\":\"%s\"}", new Object[]{var0.getMake(), var0.getModel(), DeviceInfo.getOS(), var0.getOSVersion()});
   }

   protected AdvertisingIdentifier$Info getAdvertisingIdentifierInfo() {
      return this.advertisingIdentifierInfo;
   }

   public Metrics$MetricType getCallMetricType() {
      return this.callMetricType;
   }

   public String getLogTag() {
      return this.logTag;
   }

   public String getPath() {
      return this.path;
   }

   public HashMap getPostParameters() {
      return null;
   }

   public WebRequest$QueryStringParameters getQueryParameters() {
      WebRequest$QueryStringParameters var2 = new WebRequest$QueryStringParameters();
      var2.putUrlEncoded("dt", DeviceInfo.getDeviceType());
      var2.putUrlEncoded("app", InternalAdRegistration.getInstance().getRegistrationInfo().getAppName());
      var2.putUrlEncoded("aud", Configuration.getInstance().getString(Configuration$ConfigOption.SIS_DOMAIN));
      var2.putUrlEncoded("ua", WebUtils.getURLEncodedString(InternalAdRegistration.getInstance().getDeviceInfo().getUserAgentString()));
      var2.putUrlEncoded("dinfo", WebUtils.getURLEncodedString(getDInfoProperty()));
      var2.putUrlEncoded("pkg", WebUtils.getURLEncodedString(InternalAdRegistration.getInstance().getAppInfo().getPackageInfoJSONString()));
      if(this.advertisingIdentifierInfo.hasAdvertisingIdentifier()) {
         var2.putUrlEncoded("idfa", this.advertisingIdentifierInfo.getAdvertisingIdentifier());
         var2.putUrlEncoded("oo", convertOptOutBooleanToStringInt(this.advertisingIdentifierInfo.isLimitAdTrackingEnabled()));
      } else {
         DeviceInfo var3 = InternalAdRegistration.getInstance().getDeviceInfo();
         var2.putUrlEncoded("sha1_mac", var3.getMacSha1());
         var2.putUrlEncoded("sha1_serial", var3.getSerialSha1());
         var2.putUrlEncoded("sha1_udid", var3.getUdidSha1());
         var2.putUrlEncodedIfTrue("badMac", "true", var3.isMacBad());
         var2.putUrlEncodedIfTrue("badSerial", "true", var3.isSerialBad());
         var2.putUrlEncodedIfTrue("badUdid", "true", var3.isUdidBad());
      }

      String var4 = AdvertisingIdentifier.getAndClearTransition();
      boolean var1;
      if(var4 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.putUrlEncodedIfTrue("aidts", var4, var1);
      return var2;
   }

   public SISDeviceRequest setAdvertisingIdentifierInfo(AdvertisingIdentifier$Info var1) {
      this.advertisingIdentifierInfo = var1;
      return this;
   }

   public SISDeviceRequest setCallMetricType(Metrics$MetricType var1) {
      this.callMetricType = var1;
      return this;
   }

   public SISDeviceRequest setLogTag(String var1) {
      this.logTag = var1;
      return this;
   }

   public SISDeviceRequest setPath(String var1) {
      this.path = var1;
      return this;
   }
}
