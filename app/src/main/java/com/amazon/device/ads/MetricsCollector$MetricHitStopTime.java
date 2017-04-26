package com.amazon.device.ads;

import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector$MetricHit;

class MetricsCollector$MetricHitStopTime extends MetricsCollector$MetricHit {
   public final long stopTime;

   public MetricsCollector$MetricHitStopTime(Metrics$MetricType var1, long var2) {
      super(var1);
      this.stopTime = var2;
   }
}
