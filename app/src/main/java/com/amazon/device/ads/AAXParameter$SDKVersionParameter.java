package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;
import com.amazon.device.ads.Version;

class AAXParameter$SDKVersionParameter extends AAXParameter$StringParameter {
   AAXParameter$SDKVersionParameter() {
      super("adsdk", "debug.ver");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return Version.getSDKVersion();
   }
}
