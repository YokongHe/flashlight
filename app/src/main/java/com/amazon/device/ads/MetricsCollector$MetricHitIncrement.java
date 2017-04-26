package com.amazon.device.ads;

import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector$MetricHit;

class MetricsCollector$MetricHitIncrement extends MetricsCollector$MetricHit {
   public final int increment;

   public MetricsCollector$MetricHitIncrement(Metrics$MetricType var1, int var2) {
      super(var1);
      this.increment = var2;
   }
}
