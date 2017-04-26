package com.amazon.device.ads;

class Version {
   private static String buildVersion = "5.4.235";
   private static String devBuild = "(DEV)";
   private static String prefixVersion = "amznAdSDK-android-";
   private static String sdkVersion = null;
   private static String userAgentPrefixVersion = "AmazonAdSDK-Android/";
   private static String userAgentSDKVersion = null;

   public static String getRawSDKVersion() {
      String var1 = buildVersion;
      String var0;
      if(var1 != null && !var1.equals("")) {
         var0 = var1;
         if(var1.endsWith("x")) {
            return var1 + devBuild;
         }
      } else {
         var0 = devBuild;
      }

      return var0;
   }

   public static String getSDKVersion() {
      if(sdkVersion == null) {
         sdkVersion = prefixVersion + getRawSDKVersion();
      }

      return sdkVersion;
   }

   public static String getUserAgentSDKVersion() {
      if(userAgentSDKVersion == null) {
         userAgentSDKVersion = userAgentPrefixVersion + getRawSDKVersion();
      }

      return userAgentSDKVersion;
   }

   protected static void setSDKVersion(String var0) {
      sdkVersion = var0;
   }
}
