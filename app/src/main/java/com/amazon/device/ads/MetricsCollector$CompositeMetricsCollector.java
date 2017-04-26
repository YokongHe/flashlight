package com.amazon.device.ads;

import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector;
import java.util.ArrayList;
import java.util.Iterator;

class MetricsCollector$CompositeMetricsCollector extends MetricsCollector {
   private final ArrayList collectors;

   public MetricsCollector$CompositeMetricsCollector(ArrayList var1) {
      this.collectors = var1;
   }

   public void incrementMetric(Metrics$MetricType var1) {
      Iterator var2 = this.collectors.iterator();

      while(var2.hasNext()) {
         ((MetricsCollector)var2.next()).incrementMetric(var1);
      }

   }

   public void publishMetricInMilliseconds(Metrics$MetricType var1, long var2) {
      Iterator var4 = this.collectors.iterator();

      while(var4.hasNext()) {
         ((MetricsCollector)var4.next()).publishMetricInMilliseconds(var1, var2);
      }

   }

   public void publishMetricInMillisecondsFromNanoseconds(Metrics$MetricType var1, long var2) {
      Iterator var4 = this.collectors.iterator();

      while(var4.hasNext()) {
         ((MetricsCollector)var4.next()).publishMetricInMillisecondsFromNanoseconds(var1, var2);
      }

   }

   public void setMetricString(Metrics$MetricType var1, String var2) {
      Iterator var3 = this.collectors.iterator();

      while(var3.hasNext()) {
         ((MetricsCollector)var3.next()).setMetricString(var1, var2);
      }

   }

   public void startMetric(Metrics$MetricType var1) {
      Iterator var2 = this.collectors.iterator();

      while(var2.hasNext()) {
         ((MetricsCollector)var2.next()).startMetric(var1);
      }

   }

   public void startMetricInMillisecondsFromNanoseconds(Metrics$MetricType var1, long var2) {
      Iterator var4 = this.collectors.iterator();

      while(var4.hasNext()) {
         ((MetricsCollector)var4.next()).startMetricInMillisecondsFromNanoseconds(var1, var2);
      }

   }

   public void stopMetric(Metrics$MetricType var1) {
      Iterator var2 = this.collectors.iterator();

      while(var2.hasNext()) {
         ((MetricsCollector)var2.next()).stopMetric(var1);
      }

   }

   public void stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType var1, long var2) {
      Iterator var4 = this.collectors.iterator();

      while(var4.hasNext()) {
         ((MetricsCollector)var4.next()).stopMetricInMillisecondsFromNanoseconds(var1, var2);
      }

   }
}
