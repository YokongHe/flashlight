package com.mopub.common.event;

import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.BaseEvent$SdkProduct;

abstract class BaseEvent$Builder {
   private String mAdCreativeId;
   private Double mAdHeightPx;
   private String mAdNetworkType;
   private String mAdType;
   private String mAdUnitId;
   private Double mAdWidthPx;
   private String mEventCategory;
   private String mEventName;
   private Double mGeoAccuracy;
   private Double mGeoLat;
   private Double mGeoLon;
   private Double mPerformanceDurationMs;
   private String mRequestId;
   private Integer mRequestRetries;
   private Integer mRequestStatusCode;
   private String mRequestUri;
   private BaseEvent$SdkProduct mSdkProduct;

   public BaseEvent$Builder(String var1, String var2) {
      this.mEventName = var1;
      this.mEventCategory = var2;
   }

   // $FF: synthetic method
   static String access$0(BaseEvent$Builder var0) {
      return var0.mEventName;
   }

   // $FF: synthetic method
   static String access$1(BaseEvent$Builder var0) {
      return var0.mEventCategory;
   }

   // $FF: synthetic method
   static Double access$10(BaseEvent$Builder var0) {
      return var0.mGeoLon;
   }

   // $FF: synthetic method
   static Double access$11(BaseEvent$Builder var0) {
      return var0.mGeoAccuracy;
   }

   // $FF: synthetic method
   static Double access$12(BaseEvent$Builder var0) {
      return var0.mPerformanceDurationMs;
   }

   // $FF: synthetic method
   static String access$13(BaseEvent$Builder var0) {
      return var0.mRequestId;
   }

   // $FF: synthetic method
   static Integer access$14(BaseEvent$Builder var0) {
      return var0.mRequestStatusCode;
   }

   // $FF: synthetic method
   static String access$15(BaseEvent$Builder var0) {
      return var0.mRequestUri;
   }

   // $FF: synthetic method
   static Integer access$16(BaseEvent$Builder var0) {
      return var0.mRequestRetries;
   }

   // $FF: synthetic method
   static BaseEvent$SdkProduct access$2(BaseEvent$Builder var0) {
      return var0.mSdkProduct;
   }

   // $FF: synthetic method
   static String access$3(BaseEvent$Builder var0) {
      return var0.mAdUnitId;
   }

   // $FF: synthetic method
   static String access$4(BaseEvent$Builder var0) {
      return var0.mAdCreativeId;
   }

   // $FF: synthetic method
   static String access$5(BaseEvent$Builder var0) {
      return var0.mAdType;
   }

   // $FF: synthetic method
   static String access$6(BaseEvent$Builder var0) {
      return var0.mAdNetworkType;
   }

   // $FF: synthetic method
   static Double access$7(BaseEvent$Builder var0) {
      return var0.mAdWidthPx;
   }

   // $FF: synthetic method
   static Double access$8(BaseEvent$Builder var0) {
      return var0.mAdHeightPx;
   }

   // $FF: synthetic method
   static Double access$9(BaseEvent$Builder var0) {
      return var0.mGeoLat;
   }

   public abstract BaseEvent build();

   public BaseEvent$Builder withAdCreativeId(String var1) {
      this.mAdCreativeId = var1;
      return this;
   }

   public BaseEvent$Builder withAdHeightPx(Double var1) {
      this.mAdHeightPx = var1;
      return this;
   }

   public BaseEvent$Builder withAdNetworkType(String var1) {
      this.mAdNetworkType = var1;
      return this;
   }

   public BaseEvent$Builder withAdType(String var1) {
      this.mAdType = var1;
      return this;
   }

   public BaseEvent$Builder withAdUnitId(String var1) {
      this.mAdUnitId = var1;
      return this;
   }

   public BaseEvent$Builder withAdWidthPx(Double var1) {
      this.mAdWidthPx = var1;
      return this;
   }

   public BaseEvent$Builder withGeoAccuracy(Double var1) {
      this.mGeoAccuracy = var1;
      return this;
   }

   public BaseEvent$Builder withGeoLat(Double var1) {
      this.mGeoLat = var1;
      return this;
   }

   public BaseEvent$Builder withGeoLon(Double var1) {
      this.mGeoLon = var1;
      return this;
   }

   public BaseEvent$Builder withPerformanceDurationMs(Double var1) {
      this.mPerformanceDurationMs = var1;
      return this;
   }

   public BaseEvent$Builder withRequestId(String var1) {
      this.mRequestId = var1;
      return this;
   }

   public BaseEvent$Builder withRequestRetries(Integer var1) {
      this.mRequestRetries = var1;
      return this;
   }

   public BaseEvent$Builder withRequestStatusCode(Integer var1) {
      this.mRequestStatusCode = var1;
      return this;
   }

   public BaseEvent$Builder withRequestUri(String var1) {
      this.mRequestUri = var1;
      return this;
   }

   public BaseEvent$Builder withSdkProduct(BaseEvent$SdkProduct var1) {
      this.mSdkProduct = var1;
      return this;
   }
}
