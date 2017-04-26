package com.inmobi.commons.metric;

import com.inmobi.commons.metric.EventLog;

public interface Logger$MetricsCallback {
   void dataCollected(EventLog var1);

   void movedMetricDataToFileMemory(String var1);

   void reportingFailure();

   void reportingStartedWithRequest(String var1);

   void reportingSuccess();
}
