package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.DebugProperties;

class AAXParameter$StringParameter extends AAXParameter {
   AAXParameter$StringParameter(String var1, String var2) {
      super(var1, var2);
   }

   protected String getFromDebugProperties() {
      return DebugProperties.getDebugPropertyAsString(this.getDebugName(), (String)null);
   }

   protected String parseFromString(String var1) {
      return var1;
   }
}
