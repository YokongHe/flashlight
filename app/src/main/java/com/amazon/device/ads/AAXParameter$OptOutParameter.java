package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$BooleanParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;

class AAXParameter$OptOutParameter extends AAXParameter$BooleanParameter {
   AAXParameter$OptOutParameter() {
      super("oo", "debug.optOut");
   }

   protected Boolean getDerivedValue(AAXParameter$ParameterData var1) {
      return AAXParameter$ParameterData.access$200(var1).getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()?Boolean.valueOf(AAXParameter$ParameterData.access$200(var1).getAdvertisingIdentifierInfo().isLimitAdTrackingEnabled()):null;
   }
}
