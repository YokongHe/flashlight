package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;

class AAXParameter$VideoAdsEnabledChecker {
   private final AAXParameter$ParameterData parameterData;

   public AAXParameter$VideoAdsEnabledChecker(AAXParameter$ParameterData var1) {
      this.parameterData = var1;
   }

   public boolean isVideoAdsEnabled() {
      if(!AAXParameter$ParameterData.access$300(this.parameterData).getAdTargetingOptions().isVideoEnabledSettable()) {
         return false;
      } else if(AAXParameter$ParameterData.access$000(this.parameterData).containsKey("enableVideoAds")) {
         String var1 = (String)AAXParameter$ParameterData.access$000(this.parameterData).remove("enableVideoAds");
         AAXParameter$ParameterData.access$400(this.parameterData).put("enableVideoAds", var1);
         return Boolean.parseBoolean(var1);
      } else {
         return AAXParameter$ParameterData.access$400(this.parameterData).containsKey("enableVideoAds")?Boolean.parseBoolean((String)AAXParameter$ParameterData.access$400(this.parameterData).get("enableVideoAds")):AAXParameter$ParameterData.access$300(this.parameterData).getAdTargetingOptions().isVideoAdsEnabled();
      }
   }
}
