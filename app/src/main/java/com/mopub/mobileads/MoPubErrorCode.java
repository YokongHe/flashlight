package com.mopub.mobileads;

public enum MoPubErrorCode {
   ADAPTER_CONFIGURATION_ERROR("Native Network or Custom Event adapter was configured incorrectly."),
   ADAPTER_NOT_FOUND("Unable to find Native Network or Custom Event adapter."),
   CANCELLED("Ad request was cancelled."),
   INTERNAL_ERROR("Unable to serve ad due to invalid internal state."),
   MRAID_LOAD_ERROR("Error loading MRAID ad."),
   NETWORK_INVALID_STATE("Third-party network failed due to invalid internal state."),
   NETWORK_NO_FILL("Third-party network failed to provide an ad."),
   NETWORK_TIMEOUT("Third-party network failed to respond in a timely manner."),
   NO_FILL("No ads found."),
   SERVER_ERROR("Unable to connect to MoPub adserver."),
   UNSPECIFIED("Unspecified error."),
   VIDEO_CACHE_ERROR("Error creating a cache to store downloaded videos."),
   VIDEO_DOWNLOAD_ERROR("Error downloading video.");

   private final String message;

   private MoPubErrorCode(String var3) {
      this.message = var3;
   }

   public final String toString() {
      return this.message;
   }
}
