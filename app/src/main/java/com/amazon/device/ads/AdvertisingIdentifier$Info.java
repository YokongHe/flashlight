package com.amazon.device.ads;

import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.StringUtils;

class AdvertisingIdentifier$Info {
   private String advertisingIdentifier;
   private boolean canDo = true;
   private boolean limitAdTrackingEnabled;
   private String sisDeviceIdentifier;

   // $FF: synthetic method
   static AdvertisingIdentifier$Info access$000(AdvertisingIdentifier$Info var0, boolean var1) {
      return var0.setCanDo(var1);
   }

   // $FF: synthetic method
   static AdvertisingIdentifier$Info access$100(AdvertisingIdentifier$Info var0, String var1) {
      return var0.setAdvertisingIdentifier(var1);
   }

   // $FF: synthetic method
   static AdvertisingIdentifier$Info access$200(AdvertisingIdentifier$Info var0, boolean var1) {
      return var0.setLimitAdTrackingEnabled(var1);
   }

   // $FF: synthetic method
   static AdvertisingIdentifier$Info access$300(AdvertisingIdentifier$Info var0, String var1) {
      return var0.setSISDeviceIdentifier(var1);
   }

   private AdvertisingIdentifier$Info setAdvertisingIdentifier(String var1) {
      this.advertisingIdentifier = var1;
      return this;
   }

   private AdvertisingIdentifier$Info setCanDo(boolean var1) {
      this.canDo = var1;
      return this;
   }

   private AdvertisingIdentifier$Info setLimitAdTrackingEnabled(boolean var1) {
      this.limitAdTrackingEnabled = var1;
      return this;
   }

   private AdvertisingIdentifier$Info setSISDeviceIdentifier(String var1) {
      this.sisDeviceIdentifier = var1;
      return this;
   }

   boolean canDo() {
      return this.canDo;
   }

   String getAdvertisingIdentifier() {
      return DebugProperties.getDebugPropertyAsString("debug.idfa", this.advertisingIdentifier);
   }

   String getSISDeviceIdentifier() {
      return DebugProperties.getDebugPropertyAsString("debug.adid", this.sisDeviceIdentifier);
   }

   boolean hasAdvertisingIdentifier() {
      return !StringUtils.isNullOrEmpty(this.getAdvertisingIdentifier());
   }

   boolean hasSISDeviceIdentifier() {
      return this.getSISDeviceIdentifier() != null;
   }

   boolean isLimitAdTrackingEnabled() {
      return DebugProperties.getDebugPropertyAsBoolean("debug.optOut", this.limitAdTrackingEnabled);
   }
}
