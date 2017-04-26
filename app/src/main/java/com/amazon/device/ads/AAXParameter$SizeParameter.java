package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;

class AAXParameter$SizeParameter extends AAXParameter$StringParameter {
   AAXParameter$SizeParameter() {
      super("sz", "debug.size");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return AAXParameter$ParameterData.access$300(var1).getAdSlot().getRequestedAdSize().toString();
   }
}
