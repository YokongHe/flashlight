package com.amazon.device.ads;

import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.SISDeviceRequest;
import org.json.JSONObject;

class SISGenerateDIDRequest extends SISDeviceRequest {
   private static final Metrics$MetricType CALL_METRIC_TYPE;
   private static final String LOG_TAG = "SISGenerateDIDRequest";
   private static final String PATH = "/generate_did";

   static {
      CALL_METRIC_TYPE = Metrics$MetricType.SIS_LATENCY_REGISTER;
   }

   public SISGenerateDIDRequest() {
      this.setCallMetricType(CALL_METRIC_TYPE);
      this.setLogTag("SISGenerateDIDRequest");
      this.setPath("/generate_did");
   }

   public void onResponseReceived(JSONObject var1) {
      String var2 = JSONUtils.getStringFromJSON(var1, "adId", "");
      if(var2.length() > 0) {
         InternalAdRegistration.getInstance().getRegistrationInfo().putAdId(var2, this.getAdvertisingIdentifierInfo());
      }

   }
}
