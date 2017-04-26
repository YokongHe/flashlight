package com.amazon.device.ads;

import com.amazon.device.ads.AdController;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MetricsCollector$MetricHit;
import com.amazon.device.ads.MetricsCollector$MetricHitIncrement;
import com.amazon.device.ads.MetricsCollector$MetricHitStartTime;
import com.amazon.device.ads.MetricsCollector$MetricHitStopTime;
import com.amazon.device.ads.MetricsCollector$MetricHitString;
import com.amazon.device.ads.MetricsCollector$MetricHitTotalTime;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONObject;

class AdMetrics {
   public static final String LOG_TAG = "AdMetrics";
   private final AdController adController;
   private MetricsCollector globalMetrics;

   public AdMetrics(AdController var1) {
      this.adController = var1;
   }

   protected static void addMetricsToJSON(JSONObject var0, MetricsCollector var1) {
      if(var1 != null) {
         HashMap var6 = new HashMap();
         HashMap var7 = new HashMap();
         String var5 = var1.getAdTypeMetricTag();
         if(var5 != null) {
            var5 = var5 + "_";
         }

         MetricsCollector$MetricHit[] var8 = (MetricsCollector$MetricHit[])var1.getMetricHits().toArray(new MetricsCollector$MetricHit[var1.getMetricHits().size()]);
         int var4 = var8.length;

         String var11;
         for(int var2 = 0; var2 < var4; ++var2) {
            MetricsCollector$MetricHit var9 = var8[var2];
            var11 = var9.metric.getAaxName();
            if(var5 != null && var9.metric.isAdTypeSpecific()) {
               var11 = var5 + var11;
            }

            if(var9 instanceof MetricsCollector$MetricHitStartTime) {
               MetricsCollector$MetricHitStartTime var12 = (MetricsCollector$MetricHitStartTime)var9;
               var6.put(var9.metric, Long.valueOf(var12.startTime));
            } else if(var9 instanceof MetricsCollector$MetricHitStopTime) {
               MetricsCollector$MetricHitStopTime var10 = (MetricsCollector$MetricHitStopTime)var9;
               Long var17 = (Long)var6.get(var9.metric);
               if(var17 != null) {
                  JSONUtils.put(var0, var11, var10.stopTime - var17.longValue());
               }
            } else if(var9 instanceof MetricsCollector$MetricHitTotalTime) {
               JSONUtils.put(var0, var11, ((MetricsCollector$MetricHitTotalTime)var9).totalTime);
            } else if(var9 instanceof MetricsCollector$MetricHitIncrement) {
               MetricsCollector$MetricHitIncrement var13 = (MetricsCollector$MetricHitIncrement)var9;
               Integer var18 = (Integer)var7.get(var9.metric);
               int var3;
               if(var18 == null) {
                  var3 = var13.increment;
               } else {
                  var3 = var18.intValue();
                  var3 += var13.increment;
               }

               var7.put(var9.metric, Integer.valueOf(var3));
            } else if(var9 instanceof MetricsCollector$MetricHitString) {
               JSONUtils.put(var0, var11, ((MetricsCollector$MetricHitString)var9).text);
            }
         }

         Entry var16;
         for(Iterator var15 = var7.entrySet().iterator(); var15.hasNext(); JSONUtils.put(var0, var11, ((Integer)var16.getValue()).intValue())) {
            var16 = (Entry)var15.next();
            String var14 = ((Metrics$MetricType)var16.getKey()).getAaxName();
            var11 = var14;
            if(var5 != null) {
               var11 = var14;
               if(((Metrics$MetricType)var16.getKey()).isAdTypeSpecific()) {
                  var11 = var5 + var14;
               }
            }
         }
      }

   }

   private String getAaxUrlAndResetAdMetrics() {
      String var1 = WebUtils.getURLEncodedString(this.getAaxJson());
      var1 = this.adController.getAdData().getInstrumentationPixelUrl() + var1;
      this.adController.resetMetricsCollector();
      return var1;
   }

   public void addGlobalMetrics(MetricsCollector var1) {
      this.globalMetrics = var1;
   }

   public boolean canSubmit() {
      if(this.adController.getAdData() != null) {
         String var1 = this.adController.getAdData().getInstrumentationPixelUrl();
         if(var1 != null && !var1.equals("")) {
            var1 = InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
            if(var1 != null && !var1.equals("123")) {
               return true;
            }

            Log.d("AdMetrics", "Not submitting metrics because the AppKey is either not set or set to a test key.");
            return false;
         }
      }

      return false;
   }

   protected String getAaxJson() {
      JSONObject var1 = new JSONObject();
      JSONUtils.put(var1, "c", "msdk");
      JSONUtils.put(var1, "v", Version.getRawSDKVersion());
      addMetricsToJSON(var1, this.adController.getMetricsCollector());
      addMetricsToJSON(var1, this.globalMetrics);
      String var2 = var1.toString();
      return var2.substring(1, var2.length() - 1);
   }

   public WebRequest getAaxWebRequestAndResetAdMetrics() {
      WebRequest var1 = WebRequest.createNewWebRequest();
      var1.setUrlString(this.getAaxUrlAndResetAdMetrics());
      return var1;
   }
}
