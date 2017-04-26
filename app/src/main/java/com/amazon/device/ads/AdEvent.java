package com.amazon.device.ads;

import com.amazon.device.ads.AdEvent$AdEventType;
import com.amazon.device.ads.ParameterMap;

class AdEvent {
   public static final String POSITION_ON_SCREEN = "positionOnScreen";
   private final AdEvent$AdEventType adEventType;
   private String customType;
   private final ParameterMap parameters = new ParameterMap();

   public AdEvent(AdEvent$AdEventType var1) {
      this.adEventType = var1;
   }

   public AdEvent$AdEventType getAdEventType() {
      return this.adEventType;
   }

   public String getCustomType() {
      return this.customType;
   }

   public ParameterMap getParameters() {
      return this.parameters;
   }

   public void setCustomType(String var1) {
      this.customType = var1;
   }

   public AdEvent setParameter(String var1, Object var2) {
      this.parameters.setParameter(var1, var2);
      return this;
   }
}
