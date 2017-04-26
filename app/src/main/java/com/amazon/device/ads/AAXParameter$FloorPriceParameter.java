package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$LongParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;

class AAXParameter$FloorPriceParameter extends AAXParameter$LongParameter {
   AAXParameter$FloorPriceParameter() {
      super("ec", "debug.ec");
   }

   protected Long getDerivedValue(AAXParameter$ParameterData var1) {
      return AAXParameter$ParameterData.access$300(var1).getAdTargetingOptions().hasFloorPrice()?Long.valueOf(AAXParameter$ParameterData.access$300(var1).getAdTargetingOptions().getFloorPrice()):null;
   }
}
