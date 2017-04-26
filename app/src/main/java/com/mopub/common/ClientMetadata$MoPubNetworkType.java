package com.mopub.common;

public enum ClientMetadata$MoPubNetworkType {
   ETHERNET(1),
   MOBILE(3),
   UNKNOWN(0),
   WIFI(2);

   private final int mId;

   private ClientMetadata$MoPubNetworkType(int var3) {
      this.mId = var3;
   }

   // $FF: synthetic method
   static ClientMetadata$MoPubNetworkType access$2(int var0) {
      return fromAndroidNetworkType(var0);
   }

   private static ClientMetadata$MoPubNetworkType fromAndroidNetworkType(int var0) {
      switch(var0) {
      case 0:
      case 2:
      case 3:
      case 4:
      case 5:
         return MOBILE;
      case 1:
         return WIFI;
      case 6:
      case 7:
      case 8:
      default:
         return UNKNOWN;
      case 9:
         return ETHERNET;
      }
   }

   public final String toString() {
      return Integer.toString(this.mId);
   }
}
