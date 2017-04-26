package com.amazon.device.ads;

import android.annotation.SuppressLint;
import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AdRequest$JSONObjectBuilder;
import com.amazon.device.ads.AdRequest$LOISlot;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AdvertisingIdentifier$Info;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.Configuration$ConfigOption;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$HttpMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class AdRequest {
   private static final String AAX_ENDPOINT = "/e/msdk/ads";
   private static final String LOG_TAG = AdRequest.class.getSimpleName();
   private static final AAXParameter[] PARAMETERS;
   private AdvertisingIdentifier$Info advertisingIdentifierInfo;
   private final ConnectionInfo connectionInfo;
   private String instrPixelUrl;
   private final AdRequest$JSONObjectBuilder jsonObjectBuilder;
   private final AdTargetingOptions opt;
   private final String orientation;
   protected final Map slots;

   static {
      PARAMETERS = new AAXParameter[]{AAXParameter.APP_KEY, AAXParameter.CHANNEL, AAXParameter.PUBLISHER_KEYWORDS, AAXParameter.PUBLISHER_ASINS, AAXParameter.USER_AGENT, AAXParameter.SDK_VERSION, AAXParameter.GEOLOCATION, AAXParameter.DEVICE_INFO, AAXParameter.PACKAGE_INFO, AAXParameter.TEST, AAXParameter.SIS_DEVICE_IDENTIFIER, AAXParameter.SHA1_UDID, AAXParameter.MD5_UDID, AAXParameter.ADVERTISING_IDENTIFIER, AAXParameter.OPT_OUT};
   }

   @SuppressLint({"UseSparseArrays"})
   AdRequest(AdTargetingOptions var1) {
      this.opt = var1;
      this.slots = new HashMap();
      this.orientation = InternalAdRegistration.getInstance().getDeviceInfo().getOrientation();
      this.connectionInfo = new ConnectionInfo();
      HashMap var3 = this.opt.getCopyOfAdvancedOptions();
      AAXParameter$ParameterData var2 = (new AAXParameter$ParameterData()).setAdvancedOptions(var3).setAdRequest(this);
      this.jsonObjectBuilder = (new AdRequest$JSONObjectBuilder()).setAAXParameters(PARAMETERS).setAdvancedOptions(var3).setParameterData(var2);
   }

   // $FF: synthetic method
   static String access$000() {
      return LOG_TAG;
   }

   AdTargetingOptions getAdTargetingOptions() {
      return this.opt;
   }

   AdvertisingIdentifier$Info getAdvertisingIdentifierInfo() {
      return this.advertisingIdentifierInfo;
   }

   public String getInstrumentationPixelURL() {
      return this.instrPixelUrl;
   }

   String getOrientation() {
      return this.orientation;
   }

   protected JSONArray getSlots() {
      JSONArray var1 = new JSONArray();
      Iterator var2 = this.slots.values().iterator();

      while(var2.hasNext()) {
         var1.put(((AdRequest$LOISlot)var2.next()).getJSON());
      }

      return var1;
   }

   public WebRequest getWebRequest() {
      WebRequest var1 = WebRequest.createNewWebRequest();
      var1.setExternalLogTag(LOG_TAG);
      var1.setHttpMethod(WebRequest$HttpMethod.POST);
      var1.setHost(Configuration.getInstance().getString(Configuration$ConfigOption.AAX_HOSTNAME));
      var1.setPath("/e/msdk/ads");
      var1.enableLog(true);
      var1.setContentType("application/json");
      var1.setDisconnectEnabled(false);
      this.setParametersInWebRequest(var1);
      return var1;
   }

   public void putSlot(AdSlot var1) {
      if(this.getAdvertisingIdentifierInfo().hasSISDeviceIdentifier()) {
         var1.getMetricsCollector().incrementMetric(Metrics$MetricType.AD_COUNTER_IDENTIFIED_DEVICE);
      }

      var1.setConnectionInfo(this.connectionInfo);
      AdRequest$LOISlot var2 = new AdRequest$LOISlot(var1, this);
      this.slots.put(Integer.valueOf(var1.getSlotNumber()), var2);
   }

   AdRequest setAdvertisingIdentifierInfo(AdvertisingIdentifier$Info var1) {
      this.advertisingIdentifierInfo = var1;
      return this;
   }

   public void setInstrumentationPixelURL(String var1) {
      this.instrPixelUrl = var1;
   }

   protected void setParametersInWebRequest(WebRequest var1) {
      this.jsonObjectBuilder.build();
      Object var3 = AAXParameter.SLOTS.getValue(this.jsonObjectBuilder.getParameterData());
      Object var2 = var3;
      if(var3 == null) {
         var2 = this.getSlots();
      }

      this.jsonObjectBuilder.putIntoJSON(AAXParameter.SLOTS, var2);
      JSONObject var4 = this.jsonObjectBuilder.getJSON();
      String var5 = DebugProperties.getDebugPropertyAsString("debug.aaxAdParams", (String)null);
      if(!StringUtils.isNullOrEmpty(var5)) {
         var1.setAdditionalQueryParamsString(var5);
      }

      this.setRequestBodyString(var1, var4);
   }

   protected void setRequestBodyString(WebRequest var1, JSONObject var2) {
      var1.setRequestBodyString(var2.toString());
   }
}
