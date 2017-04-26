package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;

class AAXParameter$SlotParameter extends AAXParameter$StringParameter {
   AAXParameter$SlotParameter() {
      super("slot", "debug.slot");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return AAXParameter$ParameterData.access$200(var1).getOrientation();
   }
}
