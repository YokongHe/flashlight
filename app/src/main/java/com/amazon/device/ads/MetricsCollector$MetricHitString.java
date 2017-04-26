package com.amazon.device.ads;

import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector$MetricHit;

class MetricsCollector$MetricHitString extends MetricsCollector$MetricHit {
   public final String text;

   public MetricsCollector$MetricHitString(Metrics$MetricType var1, String var2) {
      super(var1);
      this.text = var2;
   }
}
