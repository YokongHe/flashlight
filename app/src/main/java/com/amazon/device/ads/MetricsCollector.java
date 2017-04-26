package com.amazon.device.ads;

import com.amazon.device.ads.AdProperties$AdType;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector$MetricHitIncrement;
import com.amazon.device.ads.MetricsCollector$MetricHitStartTime;
import com.amazon.device.ads.MetricsCollector$MetricHitStopTime;
import com.amazon.device.ads.MetricsCollector$MetricHitString;
import com.amazon.device.ads.MetricsCollector$MetricHitTotalTime;
import com.amazon.device.ads.NumberUtils;
import java.util.Vector;

class MetricsCollector {
   private String adTypeMetricTag;
   protected Vector metricHits = new Vector(60);

   public String getAdTypeMetricTag() {
      return this.adTypeMetricTag;
   }

   public Vector getMetricHits() {
      return this.metricHits;
   }

   public void incrementMetric(Metrics$MetricType var1) {
      Log.d("MetricsCollector", "METRIC Increment " + var1.toString());
      this.metricHits.add(new MetricsCollector$MetricHitIncrement(var1, 1));
   }

   public boolean isMetricsCollectorEmpty() {
      return this.metricHits.isEmpty();
   }

   public void publishMetricInMilliseconds(Metrics$MetricType var1, long var2) {
      Log.d("MetricsCollector", "METRIC Publish " + var1.toString());
      this.metricHits.add(new MetricsCollector$MetricHitTotalTime(var1, var2));
   }

   public void publishMetricInMillisecondsFromNanoseconds(Metrics$MetricType var1, long var2) {
      this.publishMetricInMilliseconds(var1, NumberUtils.convertToMillisecondsFromNanoseconds(var2));
   }

   public void setAdType(AdProperties$AdType var1) {
      this.adTypeMetricTag = var1.getAdTypeMetricTag();
   }

   public void setMetricString(Metrics$MetricType var1, String var2) {
      Log.d("MetricsCollector", "METRIC Set " + var1.toString() + ": " + var2);
      this.metricHits.add(new MetricsCollector$MetricHitString(var1, var2));
   }

   public void startMetric(Metrics$MetricType var1) {
      this.startMetricInMillisecondsFromNanoseconds(var1, System.nanoTime());
   }

   public void startMetricInMillisecondsFromNanoseconds(Metrics$MetricType var1, long var2) {
      Log.d("MetricsCollector", "METRIC Start " + var1.toString());
      var2 = NumberUtils.convertToMillisecondsFromNanoseconds(var2);
      this.metricHits.add(new MetricsCollector$MetricHitStartTime(var1, var2));
   }

   public void stopMetric(Metrics$MetricType var1) {
      this.stopMetricInMillisecondsFromNanoseconds(var1, System.nanoTime());
   }

   public void stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType var1, long var2) {
      Log.d("MetricsCollector", "METRIC Stop " + var1.toString());
      var2 = NumberUtils.convertToMillisecondsFromNanoseconds(var2);
      this.metricHits.add(new MetricsCollector$MetricHitStopTime(var1, var2));
   }
}
