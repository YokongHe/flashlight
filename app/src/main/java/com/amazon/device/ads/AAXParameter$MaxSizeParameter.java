package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;

class AAXParameter$MaxSizeParameter extends AAXParameter$StringParameter {
   AAXParameter$MaxSizeParameter() {
      super("mxsz", "debug.mxsz");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return AAXParameter$ParameterData.access$300(var1).getAdSlot().getMaxSize();
   }
}
