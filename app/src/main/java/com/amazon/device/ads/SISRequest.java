package com.amazon.device.ads;

import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.WebRequest$QueryStringParameters;
import java.util.HashMap;
import org.json.JSONObject;

interface SISRequest {
   Metrics$MetricType getCallMetricType();

   String getLogTag();

   String getPath();

   HashMap getPostParameters();

   WebRequest$QueryStringParameters getQueryParameters();

   void onResponseReceived(JSONObject var1);
}
