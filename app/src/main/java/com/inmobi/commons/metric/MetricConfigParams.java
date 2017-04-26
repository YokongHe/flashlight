package com.inmobi.commons.metric;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class MetricConfigParams {
   private int a = 432000;
   private int b = 1000;
   private int c = 1000;
   private int d = 10;
   private String e = "https://sdkm.w.inmobi.com/metrics/e.asm";

   public int getDumpThreshhold() {
      return this.d;
   }

   public int getMaxInQueue() {
      return this.b;
   }

   public int getNextRetryInterval() {
      return this.a;
   }

   public int getSamplingFactor() {
      return this.c;
   }

   public String getUrl() {
      return this.e;
   }

   public void setFromMap(Map var1) {
      this.c = InternalSDKUtil.getIntFromMap(var1, "sf", 1, 2147483647L);
      this.d = InternalSDKUtil.getIntFromMap(var1, "dt", 1, 2147483647L);
      this.b = InternalSDKUtil.getIntFromMap(var1, "max", 1, 2147483647L);
      this.a = InternalSDKUtil.getIntFromMap(var1, "nri", 1, 2147483647L);
      this.e = InternalSDKUtil.getStringFromMap(var1, "url");
   }
}
