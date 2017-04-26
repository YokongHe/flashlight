package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;
import com.amazon.device.ads.InternalAdRegistration;

class AAXParameter$AppKeyParameter extends AAXParameter$StringParameter {
   AAXParameter$AppKeyParameter() {
      super("appId", "debug.appid");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
   }
}
