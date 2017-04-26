package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$IntegerParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;

class AAXParameter$SlotIdParameter extends AAXParameter$IntegerParameter {
   AAXParameter$SlotIdParameter() {
      super("slotId", "debug.slotId");
   }

   protected Integer getDerivedValue(AAXParameter$ParameterData var1) {
      return Integer.valueOf(AAXParameter$ParameterData.access$300(var1).getAdSlot().getSlotNumber());
   }
}
