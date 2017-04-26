package com.mopub.common.event;

import com.mopub.common.ClientMetadata;
import com.mopub.common.ClientMetadata$MoPubNetworkType;
import com.mopub.common.event.BaseEvent$AppPlatform;
import com.mopub.common.event.BaseEvent$Builder;
import com.mopub.common.event.BaseEvent$SdkProduct;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class BaseEvent {
   private final String mAdCreativeId;
   private final Double mAdHeightPx;
   private final String mAdNetworkType;
   private final String mAdType;
   private final String mAdUnitId;
   private final Double mAdWidthPx;
   private final String mEventCategory;
   private final String mEventName;
   private final Double mGeoAccuracy;
   private final Double mGeoLat;
   private final Double mGeoLon;
   private final Double mPerformanceDurationMs;
   private final String mRequestId;
   private final Integer mRequestRetries;
   private final Integer mRequestStatusCode;
   private final String mRequestUri;
   private final BaseEvent$SdkProduct mSdkProduct;
   private final long mTimestampUtcMs;

   BaseEvent(BaseEvent$Builder var1) {
      this.mEventName = BaseEvent$Builder.access$0(var1);
      this.mEventCategory = BaseEvent$Builder.access$1(var1);
      this.mSdkProduct = BaseEvent$Builder.access$2(var1);
      this.mAdUnitId = BaseEvent$Builder.access$3(var1);
      this.mAdCreativeId = BaseEvent$Builder.access$4(var1);
      this.mAdType = BaseEvent$Builder.access$5(var1);
      this.mAdNetworkType = BaseEvent$Builder.access$6(var1);
      this.mAdWidthPx = BaseEvent$Builder.access$7(var1);
      this.mAdHeightPx = BaseEvent$Builder.access$8(var1);
      this.mGeoLat = BaseEvent$Builder.access$9(var1);
      this.mGeoLon = BaseEvent$Builder.access$10(var1);
      this.mGeoAccuracy = BaseEvent$Builder.access$11(var1);
      this.mPerformanceDurationMs = BaseEvent$Builder.access$12(var1);
      this.mRequestId = BaseEvent$Builder.access$13(var1);
      this.mRequestStatusCode = BaseEvent$Builder.access$14(var1);
      this.mRequestUri = BaseEvent$Builder.access$15(var1);
      this.mRequestRetries = BaseEvent$Builder.access$16(var1);
      this.mTimestampUtcMs = System.currentTimeMillis();
   }

   public String getAdCreativeId() {
      return this.mAdCreativeId;
   }

   public Double getAdHeightPx() {
      return this.mAdHeightPx;
   }

   public String getAdNetworkType() {
      return this.mAdNetworkType;
   }

   public String getAdType() {
      return this.mAdType;
   }

   public String getAdUnitId() {
      return this.mAdUnitId;
   }

   public Double getAdWidthPx() {
      return this.mAdWidthPx;
   }

   public String getAppName() {
      return ClientMetadata.getInstance().getAppName();
   }

   public String getAppPackageName() {
      return ClientMetadata.getInstance().getAppPackageName();
   }

   public BaseEvent$AppPlatform getAppPlatform() {
      return BaseEvent$AppPlatform.ANDROID;
   }

   public String getAppVersion() {
      return ClientMetadata.getInstance().getAppVersion();
   }

   public String getDeviceManufacturer() {
      return ClientMetadata.getInstance().getDeviceManufacturer();
   }

   public String getDeviceModel() {
      return ClientMetadata.getInstance().getDeviceModel();
   }

   public String getDeviceOsVersion() {
      return ClientMetadata.getInstance().getDeviceOsVersion();
   }

   public String getDeviceProduct() {
      return ClientMetadata.getInstance().getDeviceProduct();
   }

   public Integer getDeviceScreenHeightPx() {
      return Integer.valueOf(ClientMetadata.getInstance().getDeviceScreenHeightPx());
   }

   public Integer getDeviceScreenWidthPx() {
      return Integer.valueOf(ClientMetadata.getInstance().getDeviceScreenWidthPx());
   }

   public String getEventCategory() {
      return this.mEventCategory;
   }

   public String getEventName() {
      return this.mEventName;
   }

   public Double getGeoAccuracy() {
      return this.mGeoAccuracy;
   }

   public Double getGeoLat() {
      return this.mGeoLat;
   }

   public Double getGeoLon() {
      return this.mGeoLon;
   }

   public String getNetworkIsoCountryCode() {
      return ClientMetadata.getInstance().getIsoCountryCode();
   }

   public String getNetworkOperatorCode() {
      return ClientMetadata.getInstance().getNetworkOperator();
   }

   public String getNetworkOperatorName() {
      return ClientMetadata.getInstance().getNetworkOperatorName();
   }

   public String getNetworkSimCode() {
      return ClientMetadata.getInstance().getSimOperator();
   }

   public String getNetworkSimIsoCountryCode() {
      return ClientMetadata.getInstance().getSimIsoCountryCode();
   }

   public String getNetworkSimOperatorName() {
      return ClientMetadata.getInstance().getSimOperatorName();
   }

   public ClientMetadata$MoPubNetworkType getNetworkType() {
      return ClientMetadata.getInstance().getActiveNetworkType();
   }

   public Double getPerformanceDurationMs() {
      return this.mPerformanceDurationMs;
   }

   public String getRequestId() {
      return this.mRequestId;
   }

   public Integer getRequestRetries() {
      return this.mRequestRetries;
   }

   public Integer getRequestStatusCode() {
      return this.mRequestStatusCode;
   }

   public String getRequestUri() {
      return this.mRequestUri;
   }

   public BaseEvent$SdkProduct getSdkProduct() {
      return this.mSdkProduct;
   }

   public String getSdkVersion() {
      return ClientMetadata.getInstance().getSdkVersion();
   }

   public long getTimestampUtcMs() {
      return this.mTimestampUtcMs;
   }

   public String toString() {
      return "BaseEvent\nEventName: " + this.getEventName() + "\nEventCategory: " + this.getEventCategory() + "\nSdkProduct: " + this.getSdkProduct() + "\nSdkVersion: " + this.getSdkVersion() + "\nAdUnitId: " + this.getAdUnitId() + "\nAdCreativeId: " + this.getAdCreativeId() + "\nAdType: " + this.getAdType() + "\nAdNetworkType: " + this.getAdNetworkType() + "\nAdWidthPx: " + this.getAdWidthPx() + "\nAdHeightPx: " + this.getAdHeightPx() + "\nAppPlatform: " + this.getAppPlatform() + "\nAppName: " + this.getAppName() + "\nAppPackageName: " + this.getAppPackageName() + "\nAppVersion: " + this.getAppVersion() + "\nDeviceManufacturer: " + this.getDeviceManufacturer() + "\nDeviceModel: " + this.getDeviceModel() + "\nDeviceProduct: " + this.getDeviceProduct() + "\nDeviceOsVersion: " + this.getDeviceOsVersion() + "\nDeviceScreenWidth: " + this.getDeviceScreenWidthPx() + "\nDeviceScreenHeight: " + this.getDeviceScreenHeightPx() + "\nGeoLat: " + this.getGeoLat() + "\nGeoLon: " + this.getGeoLon() + "\nGeoAccuracy: " + this.getGeoAccuracy() + "\nPerformanceDurationMs: " + this.getPerformanceDurationMs() + "\nNetworkType: " + this.getNetworkType() + "\nNetworkOperatorCode: " + this.getNetworkOperatorCode() + "\nNetworkOperatorName: " + this.getNetworkOperatorName() + "\nNetworkIsoCountryCode: " + this.getNetworkIsoCountryCode() + "\nNetworkSimCode: " + this.getNetworkSimCode() + "\nNetworkSimOperatorName: " + this.getNetworkSimOperatorName() + "\nNetworkSimIsoCountryCode: " + this.getNetworkSimIsoCountryCode() + "\nRequestId: " + this.getRequestId() + "\nRequestStatusCode: " + this.getRequestStatusCode() + "\nRequestUri: " + this.getRequestUri() + "\nRequestRetries" + this.getRequestRetries() + "\nTimestampUtcMs: " + (new SimpleDateFormat()).format(new Date(this.getTimestampUtcMs())) + "\n";
   }
}
