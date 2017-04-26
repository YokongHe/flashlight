package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$JSONArrayParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$VideoAdsEnabledChecker;
import org.json.JSONArray;

class AAXParameter$SupportedMediaTypesParameter extends AAXParameter$JSONArrayParameter {
   public AAXParameter$SupportedMediaTypesParameter() {
      super("supportedMediaTypes", "debug.supportedMediaTypes");
   }

   private void addDisplay(AAXParameter$ParameterData var1, JSONArray var2) {
      boolean var3 = AAXParameter$ParameterData.access$300(var1).getAdTargetingOptions().isDisplayAdsEnabled();
      if(AAXParameter$ParameterData.access$000(var1).containsKey("enableDisplayAds")) {
         var3 = Boolean.parseBoolean((String)AAXParameter$ParameterData.access$000(var1).remove("enableDisplayAds"));
      }

      if(var3) {
         var2.put("DISPLAY");
      }

   }

   private void addVideo(AAXParameter$ParameterData var1, JSONArray var2) {
      if((new AAXParameter$VideoAdsEnabledChecker(var1)).isVideoAdsEnabled()) {
         var2.put("VIDEO");
      }

   }

   protected JSONArray getDerivedValue(AAXParameter$ParameterData var1) {
      JSONArray var2 = new JSONArray();
      this.addDisplay(var1, var2);
      this.addVideo(var1, var2);
      return var2;
   }
}
