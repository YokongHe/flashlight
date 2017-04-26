package com.mopub.nativeads;

public enum NativeErrorCode {
   CONNECTION_ERROR("Network is unavailable."),
   EMPTY_AD_RESPONSE("Server returned empty response."),
   IMAGE_DOWNLOAD_FAILURE("Unable to download images associated with ad."),
   INVALID_JSON("Unable to parse JSON response from server."),
   INVALID_REQUEST_URL("Invalid request url."),
   NATIVE_ADAPTER_CONFIGURATION_ERROR("Custom Event Native was configured incorrectly."),
   NATIVE_ADAPTER_NOT_FOUND("Unable to find Custom Event Native."),
   NETWORK_INVALID_REQUEST("Third-party network received invalid request."),
   NETWORK_INVALID_STATE("Third-party network failed due to invalid internal state."),
   NETWORK_NO_FILL("Third-party network failed to provide an ad."),
   NETWORK_TIMEOUT("Third-party network failed to respond in a timely manner."),
   SERVER_ERROR_RESPONSE_CODE("Server returned erroneous response code."),
   UNEXPECTED_RESPONSE_CODE("Received unexpected response code from server."),
   UNSPECIFIED("Unspecified error occurred.");

   private final String message;

   private NativeErrorCode(String var3) {
      this.message = var3;
   }

   public final String toString() {
      return this.message;
   }
}
