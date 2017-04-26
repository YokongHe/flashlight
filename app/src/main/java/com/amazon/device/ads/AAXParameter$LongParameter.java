package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.DebugProperties;

class AAXParameter$LongParameter extends AAXParameter {
   AAXParameter$LongParameter(String var1, String var2) {
      super(var1, var2);
   }

   protected Long getFromDebugProperties() {
      return DebugProperties.getDebugPropertyAsLong(this.getDebugName(), (Long)null);
   }

   protected Long parseFromString(String var1) {
      return Long.valueOf(Long.parseLong(var1));
   }
}
