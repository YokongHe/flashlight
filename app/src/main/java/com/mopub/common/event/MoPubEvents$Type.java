package com.mopub.common.event;

public enum MoPubEvents$Type {
   AD_REQUEST("ad_request"),
   AD_REQUEST_ERROR("ad_request_error"),
   CLICK_ERROR("click_track_error"),
   CLICK_REQUEST("click_request"),
   CONVERSION_ERROR("conv_track_error"),
   DATA_ERROR("invalid_data"),
   IMPRESSION_ERROR("imp_track_error"),
   IMPRESSION_REQUEST("impression_request"),
   POSITIONING_REQUEST("positioning_request"),
   TRACKING_ERROR("track_error");

   public final String mName;

   private MoPubEvents$Type(String var3) {
      this.mName = var3;
   }
}
