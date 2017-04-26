package com.amazon.device.ads;

import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.Configuration$ConfigOption;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.SISRequest;
import com.amazon.device.ads.SISRequestorCallback;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$HttpMethod;
import com.amazon.device.ads.WebRequest$QueryStringParameters;
import com.amazon.device.ads.WebRequest$WebRequestException;
import com.amazon.device.ads.WebRequest$WebResponse;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONObject;

class SISRequestor {
   protected static final String API_LEVEL_ENDPOINT = "/api3";
   private final SISRequestorCallback sisRequestorCallback;
   private final SISRequest[] sisRequests;

   public SISRequestor(SISRequestorCallback var1, SISRequest... var2) {
      this.sisRequestorCallback = var1;
      this.sisRequests = var2;
   }

   public SISRequestor(SISRequest... var1) {
      this((SISRequestorCallback)null, var1);
   }

   protected static String getEndpoint(SISRequest var0) {
      String var3 = Configuration.getInstance().getString(Configuration$ConfigOption.SIS_URL);
      String var2 = var3;
      if(var3 != null) {
         int var1 = var3.indexOf("/");
         if(var1 >= 0) {
            var2 = var3.substring(var1);
         } else {
            var2 = "";
         }
      }

      return var2 + "/api3" + var0.getPath();
   }

   protected static String getHostname() {
      String var2 = Configuration.getInstance().getString(Configuration$ConfigOption.SIS_URL);
      String var1 = var2;
      if(var2 != null) {
         int var0 = var2.indexOf("/");
         var1 = var2;
         if(var0 >= 0) {
            var1 = var2.substring(0, var0);
         }
      }

      return var1;
   }

   protected void callSIS() {
      SISRequest[] var3 = this.sisRequests;
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         this.callSIS(var3[var1]);
      }

   }

   protected void callSIS(SISRequest var1) {
      WebRequest var3 = this.getWebRequest(var1);

      WebRequest$WebResponse var6;
      try {
         var6 = var3.makeCall();
      } catch (WebRequest$WebRequestException var5) {
         return;
      }

      JSONObject var7 = var6.getResponseReader().readAsJSON();
      if(var7 != null) {
         int var2 = JSONUtils.getIntegerFromJSON(var7, "rcode", 0);
         String var4 = JSONUtils.getStringFromJSON(var7, "msg", "");
         if(var2 == 1) {
            Log.i(var1.getLogTag(), "Result - code: %d, msg: %s", new Object[]{Integer.valueOf(var2), var4});
            var1.onResponseReceived(var7);
         } else {
            Log.w(var1.getLogTag(), "Result - code: %d, msg: %s", new Object[]{Integer.valueOf(var2), var4});
         }
      }
   }

   protected SISRequestorCallback getSisRequestorCallback() {
      return this.sisRequestorCallback;
   }

   protected WebRequest getWebRequest(SISRequest var1) {
      WebRequest var2 = WebRequest.createNewWebRequest();
      var2.setExternalLogTag(var1.getLogTag());
      var2.setHttpMethod(WebRequest$HttpMethod.POST);
      var2.setHost(getHostname());
      var2.setPath(getEndpoint(var1));
      var2.enableLog(true);
      if(var1.getPostParameters() != null) {
         Iterator var3 = var1.getPostParameters().entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            var2.putPostParameter((String)var4.getKey(), (String)var4.getValue());
         }
      }

      WebRequest$QueryStringParameters var5 = var1.getQueryParameters();
      var5.putUrlEncoded("appId", InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey());
      var5.putUrlEncoded("sdkVer", Version.getSDKVersion());
      var2.setQueryStringParameters(var5);
      var2.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
      var2.setServiceCallLatencyMetric(var1.getCallMetricType());
      return var2;
   }

   public void startCallSIS() {
      this.callSIS();
      SISRequestorCallback var1 = this.getSisRequestorCallback();
      if(var1 != null) {
         var1.onSISCallComplete();
      }

   }
}
