package com.amazon.device.ads;

import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector$MetricHit;

class MetricsCollector$MetricHitStartTime extends MetricsCollector$MetricHit {
   public final long startTime;

   public MetricsCollector$MetricHitStartTime(Metrics$MetricType var1, long var2) {
      super(var1);
      this.startTime = var2;
   }
}
