package com.amazon.device.ads;

import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector$MetricHit;

class MetricsCollector$MetricHitTotalTime extends MetricsCollector$MetricHit {
   public final long totalTime;

   public MetricsCollector$MetricHitTotalTime(Metrics$MetricType var1, long var2) {
      super(var1);
      this.totalTime = var2;
   }
}
