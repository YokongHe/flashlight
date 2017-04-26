package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;
import com.amazon.device.ads.InternalAdRegistration;

class AAXParameter$UserAgentParameter extends AAXParameter$StringParameter {
   AAXParameter$UserAgentParameter() {
      super("ua", "debug.ua");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return InternalAdRegistration.getInstance().getDeviceInfo().getUserAgentString();
   }
}
