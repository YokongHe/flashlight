package com.amazon.device.ads;

import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.SISDeviceRequest;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.WebRequest$QueryStringParameters;
import org.json.JSONObject;

class SISUpdateDeviceInfoRequest extends SISDeviceRequest {
   private static final Metrics$MetricType CALL_METRIC_TYPE;
   private static final String LOG_TAG = "SISUpdateDeviceInfoRequest";
   private static final String PATH = "/update_dev_info";

   static {
      CALL_METRIC_TYPE = Metrics$MetricType.SIS_LATENCY_UPDATE_DEVICE_INFO;
   }

   public SISUpdateDeviceInfoRequest() {
      this.setCallMetricType(CALL_METRIC_TYPE);
      this.setLogTag("SISUpdateDeviceInfoRequest");
      this.setPath("/update_dev_info");
   }

   public WebRequest$QueryStringParameters getQueryParameters() {
      String var1 = DebugProperties.getDebugPropertyAsString("debug.adid", this.getAdvertisingIdentifierInfo().getSISDeviceIdentifier());
      WebRequest$QueryStringParameters var2 = super.getQueryParameters();
      if(!StringUtils.isNullOrEmpty(var1)) {
         var2.putUrlEncoded("adId", var1);
      }

      return var2;
   }

   public void onResponseReceived(JSONObject var1) {
      String var2 = JSONUtils.getStringFromJSON(var1, "adId", "");
      if(JSONUtils.getBooleanFromJSON(var1, "idChanged", false)) {
         Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED);
      }

      if(var2.length() > 0) {
         InternalAdRegistration.getInstance().getRegistrationInfo().putAdId(var2, this.getAdvertisingIdentifierInfo());
      }

   }
}
