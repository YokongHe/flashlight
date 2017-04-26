package com.amazon.device.ads;

enum Metrics$MetricType {
   AAX_CONFIG_DOWNLOAD_FAILED("acf"),
   AAX_CONFIG_DOWNLOAD_LATENCY("acl"),
   AAX_LATENCY_GET_AD("al"),
   ADLAYOUT_HEIGHT_ZERO("ahz"),
   AD_COUNTER_AUTO_AD_SIZE("aas"),
   AD_COUNTER_FAILED_DUE_TO_NO_RETRY("nrtf"),
   AD_COUNTER_IDENTIFIED_DEVICE("id"),
   AD_COUNTER_PARENT_VIEW_MISSING("pvm"),
   AD_COUNTER_RENDERING_FATAL("rf", true),
   AD_FAILED_INVALID_AUTO_AD_SIZE("faas"),
   AD_FAILED_LAYOUT_NOT_RUN("flnr"),
   AD_FAILED_NULL_LAYOUT_PARAMS("fnlp"),
   AD_FAILED_UNKNOWN_WEBVIEW_ISSUE("fuwi"),
   AD_IS_INTERSTITIAL("i"),
   AD_LATENCY_RENDER("rl", true),
   AD_LATENCY_RENDER_FAILED("rlf", true),
   AD_LATENCY_TOTAL("tl", true),
   AD_LATENCY_TOTAL_FAILURE("tfl", true),
   AD_LATENCY_TOTAL_SUCCESS("tsl", true),
   AD_LAYOUT_INITIALIZATION("ali"),
   AD_LOADED_TO_AD_SHOW_TIME("alast"),
   AD_LOAD_FAILED("lf"),
   AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT("lfat"),
   AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT("lfpt"),
   AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END("laefel"),
   AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL("lcaul"),
   AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP("lfsul"),
   AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START("lfsasl"),
   AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP("lffsul"),
   AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE("lffsfl", true),
   AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START("lffsrsl", true),
   AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START("llfsl", true),
   AD_NO_RETRY_TTL_RECEIVED("nrtr"),
   AD_SHOW_DURATION("asd"),
   AD_SHOW_LATENCY("lsa"),
   ASSETS_CREATED_LATENCY("lacl"),
   ASSETS_ENSURED_LATENCY("lael"),
   ASSETS_FAILED("af"),
   CARRIER_NAME("car"),
   CONFIG_DOWNLOAD_ERROR("cde"),
   CONFIG_DOWNLOAD_LATENCY("cdt"),
   CONFIG_PARSE_ERROR("cpe"),
   CONNECTION_TYPE("ct"),
   CUSTOM_RENDER_HANDLED("crh"),
   INTERSTITIAL_AD_ACTIVITY_FAILED("iaaf"),
   SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED("sid"),
   SIS_LATENCY_REGISTER("srl"),
   SIS_LATENCY_REGISTER_EVENT("srel"),
   SIS_LATENCY_UPDATE_DEVICE_INFO("sul"),
   TLS_ENABLED("tls"),
   VIEWPORT_SCALE("vs"),
   WIFI_PRESENT("wifi");

   private final String aaxName;
   private final boolean isAdTypeSpecific;

   private Metrics$MetricType(String var3) {
      this(var3, false);
   }

   private Metrics$MetricType(String var3, boolean var4) {
      this.aaxName = var3;
      this.isAdTypeSpecific = var4;
   }

   public final String getAaxName() {
      return this.aaxName;
   }

   public final boolean isAdTypeSpecific() {
      return this.isAdTypeSpecific;
   }
}
