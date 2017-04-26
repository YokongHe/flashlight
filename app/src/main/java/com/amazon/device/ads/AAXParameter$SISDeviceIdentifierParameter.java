package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;

class AAXParameter$SISDeviceIdentifierParameter extends AAXParameter$StringParameter {
   AAXParameter$SISDeviceIdentifierParameter() {
      super("ad-id", "debug.adid");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return AAXParameter$ParameterData.access$200(var1).getAdvertisingIdentifierInfo().getSISDeviceIdentifier();
   }
}
