package com.inmobi.commons.analytics.iat.impl.config;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AdTrackerGoalRetryParams {
   private int a = 1000;
   private int b = 900;

   public int getMaxRetry() {
      return this.a;
   }

   public int getMaxWaitTime() {
      return this.b * 1000;
   }

   public void setFromMap(Map var1) {
      this.a = InternalSDKUtil.getIntFromMap(var1, "mr", 0, 2147483647L);
      this.b = InternalSDKUtil.getIntFromMap(var1, "mw", 0, 2147483647L);
   }
}
