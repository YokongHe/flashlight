package com.mopub.common.util;

public enum ResponseHeader {
   AD_TIMEOUT("X-AdTimeout"),
   AD_TYPE("X-Adtype"),
   CLICK_TRACKING_URL("X-Clickthrough"),
   CUSTOM_EVENT_DATA("X-Custom-Event-Class-Data"),
   CUSTOM_EVENT_HTML_DATA("X-Custom-Event-Html-Data"),
   CUSTOM_EVENT_NAME("X-Custom-Event-Class-Name"),
   @Deprecated
   CUSTOM_SELECTOR("X-Customselector"),
   DSP_CREATIVE_ID("X-DspCreativeid"),
   FAIL_URL("X-Failurl"),
   FULL_AD_TYPE("X-Fulladtype"),
   HEIGHT("X-Height"),
   IMPRESSION_URL("X-Imptracker"),
   LOCATION("Location"),
   NATIVE_PARAMS("X-Nativeparams"),
   NETWORK_TYPE("X-Networktype"),
   REDIRECT_URL("X-Launchpage"),
   REFRESH_TIME("X-Refreshtime"),
   SCROLLABLE("X-Scrollable"),
   USER_AGENT("User-Agent"),
   WARMUP("X-Warmup"),
   WIDTH("X-Width");

   private final String key;

   private ResponseHeader(String var3) {
      this.key = var3;
   }

   public final String getKey() {
      return this.key;
   }
}
