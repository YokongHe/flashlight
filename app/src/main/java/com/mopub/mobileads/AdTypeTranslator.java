package com.mopub.mobileads;

import com.mopub.common.AdFormat;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.AdTypeTranslator$CustomEventType;
import com.mopub.network.HeaderUtils;
import java.util.Map;

public class AdTypeTranslator {
   public static final String BANNER_SUFFIX = "_banner";
   public static final String INTERSTITIAL_SUFFIX = "_interstitial";

   static String getAdNetworkType(String var0, String var1) {
      if(!"interstitial".equals(var0)) {
         var1 = var0;
      }

      return var1 != null?var1:"unknown";
   }

   public static String getCustomEventName(AdFormat var0, String var1, String var2, Map var3) {
      if("custom".equalsIgnoreCase(var1)) {
         return HeaderUtils.extractHeader(var3, ResponseHeader.CUSTOM_EVENT_NAME);
      } else if("json".equalsIgnoreCase(var1)) {
         return AdTypeTranslator$CustomEventType.MOPUB_NATIVE.toString();
      } else if(!"html".equalsIgnoreCase(var1) && !"mraid".equalsIgnoreCase(var1)) {
         return "interstitial".equalsIgnoreCase(var1)?AdTypeTranslator$CustomEventType.access$2(var2 + "_interstitial").toString():AdTypeTranslator$CustomEventType.access$2(var1 + "_banner").toString();
      } else {
         AdTypeTranslator$CustomEventType var4;
         if(AdFormat.INTERSTITIAL.equals(var0)) {
            var4 = AdTypeTranslator$CustomEventType.access$2(var1 + "_interstitial");
         } else {
            var4 = AdTypeTranslator$CustomEventType.access$2(var1 + "_banner");
         }

         return var4.toString();
      }
   }
}
