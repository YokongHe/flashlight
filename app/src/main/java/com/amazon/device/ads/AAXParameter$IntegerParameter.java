package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.DebugProperties;

class AAXParameter$IntegerParameter extends AAXParameter {
   AAXParameter$IntegerParameter(String var1, String var2) {
      super(var1, var2);
   }

   protected Integer getFromDebugProperties() {
      return DebugProperties.getDebugPropertyAsInteger(this.getDebugName(), (Integer)null);
   }

   protected Integer parseFromString(String var1) {
      return Integer.valueOf(Integer.parseInt(var1));
   }
}
