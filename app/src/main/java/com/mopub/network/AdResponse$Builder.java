package com.mopub.network;

import com.mopub.network.AdResponse;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class AdResponse$Builder {
   private Integer adTimeoutDelayMillis;
   private String adType;
   private String clickTrackingUrl;
   private String customEventClassName;
   private String dspCreativeId;
   private String failoverUrl;
   private String fullAdType;
   private Integer height;
   private String impressionTrackingUrl;
   private JSONObject jsonBody;
   private String networkType;
   private String redirectUrl;
   private Integer refreshTimeMillis;
   private String responseBody;
   private boolean scrollable = false;
   private Map serverExtras;
   private Integer width;

   // $FF: synthetic method
   static String access$0(AdResponse$Builder var0) {
      return var0.adType;
   }

   // $FF: synthetic method
   static String access$1(AdResponse$Builder var0) {
      return var0.fullAdType;
   }

   // $FF: synthetic method
   static Integer access$10(AdResponse$Builder var0) {
      return var0.refreshTimeMillis;
   }

   // $FF: synthetic method
   static String access$11(AdResponse$Builder var0) {
      return var0.dspCreativeId;
   }

   // $FF: synthetic method
   static boolean access$12(AdResponse$Builder var0) {
      return var0.scrollable;
   }

   // $FF: synthetic method
   static String access$13(AdResponse$Builder var0) {
      return var0.responseBody;
   }

   // $FF: synthetic method
   static JSONObject access$14(AdResponse$Builder var0) {
      return var0.jsonBody;
   }

   // $FF: synthetic method
   static String access$15(AdResponse$Builder var0) {
      return var0.customEventClassName;
   }

   // $FF: synthetic method
   static Map access$16(AdResponse$Builder var0) {
      return var0.serverExtras;
   }

   // $FF: synthetic method
   static String access$2(AdResponse$Builder var0) {
      return var0.networkType;
   }

   // $FF: synthetic method
   static String access$3(AdResponse$Builder var0) {
      return var0.redirectUrl;
   }

   // $FF: synthetic method
   static String access$4(AdResponse$Builder var0) {
      return var0.clickTrackingUrl;
   }

   // $FF: synthetic method
   static String access$5(AdResponse$Builder var0) {
      return var0.impressionTrackingUrl;
   }

   // $FF: synthetic method
   static String access$6(AdResponse$Builder var0) {
      return var0.failoverUrl;
   }

   // $FF: synthetic method
   static Integer access$7(AdResponse$Builder var0) {
      return var0.width;
   }

   // $FF: synthetic method
   static Integer access$8(AdResponse$Builder var0) {
      return var0.height;
   }

   // $FF: synthetic method
   static Integer access$9(AdResponse$Builder var0) {
      return var0.adTimeoutDelayMillis;
   }

   public AdResponse build() {
      return new AdResponse(this, (AdResponse)null);
   }

   public AdResponse$Builder setAdTimeoutDelayMilliseconds(Integer var1) {
      this.adTimeoutDelayMillis = var1;
      return this;
   }

   public AdResponse$Builder setAdType(String var1) {
      this.adType = var1;
      return this;
   }

   public AdResponse$Builder setClickTrackingUrl(String var1) {
      this.clickTrackingUrl = var1;
      return this;
   }

   public AdResponse$Builder setCustomEventClassName(String var1) {
      this.customEventClassName = var1;
      return this;
   }

   public AdResponse$Builder setDimensions(Integer var1, Integer var2) {
      this.width = var1;
      this.height = var2;
      return this;
   }

   public AdResponse$Builder setDspCreativeId(String var1) {
      this.dspCreativeId = var1;
      return this;
   }

   public AdResponse$Builder setFailoverUrl(String var1) {
      this.failoverUrl = var1;
      return this;
   }

   public AdResponse$Builder setFullAdType(String var1) {
      this.fullAdType = var1;
      return this;
   }

   public AdResponse$Builder setImpressionTrackingUrl(String var1) {
      this.impressionTrackingUrl = var1;
      return this;
   }

   public AdResponse$Builder setJsonBody(JSONObject var1) {
      this.jsonBody = var1;
      return this;
   }

   public AdResponse$Builder setNetworkType(String var1) {
      this.networkType = var1;
      return this;
   }

   public AdResponse$Builder setRedirectUrl(String var1) {
      this.redirectUrl = var1;
      return this;
   }

   public AdResponse$Builder setRefreshTimeMilliseconds(Integer var1) {
      this.refreshTimeMillis = var1;
      return this;
   }

   public AdResponse$Builder setResponseBody(String var1) {
      this.responseBody = var1;
      return this;
   }

   public AdResponse$Builder setScrollable(Boolean var1) {
      boolean var2;
      if(var1 == null) {
         var2 = this.scrollable;
      } else {
         var2 = var1.booleanValue();
      }

      this.scrollable = var2;
      return this;
   }

   public AdResponse$Builder setServerExtras(Map var1) {
      if(var1 == null) {
         this.serverExtras = new TreeMap();
         return this;
      } else {
         this.serverExtras = new TreeMap(var1);
         return this;
      }
   }
}
