package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier$Info;
import com.amazon.device.ads.AppEventRegistrationHandler;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.Configuration$ConfigOption;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.SISRequest;
import com.amazon.device.ads.WebRequest$QueryStringParameters;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class SISRegisterEventRequest implements SISRequest {
   private static final Metrics$MetricType CALL_METRIC_TYPE;
   private static final String LOG_TAG = "SISRegisterEventRequest";
   private static final String PATH = "/register_event";
   private final AdvertisingIdentifier$Info advertisingIdentifierInfo;
   private final JSONArray appEvents;

   static {
      CALL_METRIC_TYPE = Metrics$MetricType.SIS_LATENCY_REGISTER_EVENT;
   }

   public SISRegisterEventRequest(AdvertisingIdentifier$Info var1, JSONArray var2) {
      this.advertisingIdentifierInfo = var1;
      this.appEvents = var2;
   }

   public Metrics$MetricType getCallMetricType() {
      return CALL_METRIC_TYPE;
   }

   public String getLogTag() {
      return "SISRegisterEventRequest";
   }

   public String getPath() {
      return "/register_event";
   }

   public HashMap getPostParameters() {
      HashMap var1 = new HashMap();
      var1.put("events", this.appEvents.toString());
      return var1;
   }

   public WebRequest$QueryStringParameters getQueryParameters() {
      WebRequest$QueryStringParameters var1 = new WebRequest$QueryStringParameters();
      var1.putUrlEncoded("adId", this.advertisingIdentifierInfo.getSISDeviceIdentifier());
      var1.putUrlEncoded("dt", DeviceInfo.getDeviceType());
      RegistrationInfo var2 = InternalAdRegistration.getInstance().getRegistrationInfo();
      var1.putUrlEncoded("app", var2.getAppName());
      var1.putUrlEncoded("appId", var2.getAppKey());
      var1.putUrlEncoded("aud", Configuration.getInstance().getString(Configuration$ConfigOption.SIS_DOMAIN));
      return var1;
   }

   public void onResponseReceived(JSONObject var1) {
      int var2 = JSONUtils.getIntegerFromJSON(var1, "rcode", 0);
      if(var2 == 1) {
         Log.d("SISRegisterEventRequest", "Application events registered successfully.");
         AppEventRegistrationHandler.getInstance().onAppEventsRegistered();
      } else {
         Log.d("SISRegisterEventRequest", "Application events not registered. rcode:" + var2);
      }
   }
}
