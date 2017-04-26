package com.mopub.mobileads;

public enum AdTypeTranslator$CustomEventType {
   GOOGLE_PLAY_SERVICES_BANNER("admob_native_banner", "com.mopub.mobileads.GooglePlayServicesBanner"),
   GOOGLE_PLAY_SERVICES_INTERSTITIAL("admob_full_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial"),
   HTML_BANNER("html_banner", "com.mopub.mobileads.HtmlBanner"),
   HTML_INTERSTITIAL("html_interstitial", "com.mopub.mobileads.HtmlInterstitial"),
   MILLENNIAL_BANNER("millennial_native_banner", "com.mopub.mobileads.MillennialBanner"),
   MILLENNIAL_INTERSTITIAL("millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial"),
   MOPUB_NATIVE("mopub_native", "com.mopub.nativeads.MoPubCustomEventNative"),
   MRAID_BANNER("mraid_banner", "com.mopub.mraid.MraidBanner"),
   MRAID_INTERSTITIAL("mraid_interstitial", "com.mopub.mraid.MraidInterstitial"),
   UNSPECIFIED("", (String)null),
   VAST_VIDEO_INTERSTITIAL("vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial");

   private final String mClassName;
   private final String mKey;

   private AdTypeTranslator$CustomEventType(String var3, String var4) {
      this.mKey = var3;
      this.mClassName = var4;
   }

   // $FF: synthetic method
   static AdTypeTranslator$CustomEventType access$2(String var0) {
      return fromString(var0);
   }

   private static AdTypeTranslator$CustomEventType fromString(String var0) {
      AdTypeTranslator$CustomEventType[] var5 = values();
      int var2 = var5.length;
      int var1 = 0;

      AdTypeTranslator$CustomEventType var3;
      while(true) {
         if(var1 >= var2) {
            var3 = UNSPECIFIED;
            break;
         }

         AdTypeTranslator$CustomEventType var4 = var5[var1];
         var3 = var4;
         if(var4.mKey.equals(var0)) {
            break;
         }

         ++var1;
      }

      return var3;
   }

   public final String toString() {
      return this.mClassName;
   }
}
