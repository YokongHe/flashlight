package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.DebugProperties;

class AAXParameter$BooleanParameter extends AAXParameter {
   AAXParameter$BooleanParameter(String var1, String var2) {
      super(var1, var2);
   }

   protected Boolean getFromDebugProperties() {
      return DebugProperties.getDebugPropertyAsBoolean(this.getDebugName(), (Boolean)null);
   }

   protected Boolean parseFromString(String var1) {
      return Boolean.valueOf(Boolean.parseBoolean(var1));
   }
}
