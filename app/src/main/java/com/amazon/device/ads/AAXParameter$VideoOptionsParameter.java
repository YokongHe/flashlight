package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameter$JSONObjectParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$VideoAdsEnabledChecker;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Parsers$IntegerParser;
import org.json.JSONObject;

class AAXParameter$VideoOptionsParameter extends AAXParameter$JSONObjectParameter {
   private static final int MAXIMUM_DURATION_DEFAULT = 30000;
   private static final int MINIMUM_DURATION_DEFAULT = 0;

   public AAXParameter$VideoOptionsParameter() {
      super("video", "debug.videoOptions");
   }

   protected JSONObject getDerivedValue(AAXParameter$ParameterData var1) {
      int var2 = 0;
      if((new AAXParameter$VideoAdsEnabledChecker(var1)).isVideoAdsEnabled()) {
         JSONObject var3 = new JSONObject();
         if(AAXParameter$ParameterData.access$000(var1).containsKey("minVideoAdDuration")) {
            var2 = (new Parsers$IntegerParser()).setDefaultValue(0).setParseErrorLogTag(AAXParameter.access$100()).setParseErrorLogMessage("The minVideoAdDuration advanced option could not be parsed properly.").parse((String)AAXParameter$ParameterData.access$000(var1).remove("minVideoAdDuration"));
         }

         JSONUtils.put(var3, "minAdDuration", var2);
         if(AAXParameter$ParameterData.access$000(var1).containsKey("maxVideoAdDuration")) {
            var2 = (new Parsers$IntegerParser()).setDefaultValue(30000).setParseErrorLogTag(AAXParameter.access$100()).setParseErrorLogMessage("The maxVideoAdDuration advanced option could not be parsed properly.").parse((String)AAXParameter$ParameterData.access$000(var1).remove("maxVideoAdDuration"));
         } else {
            var2 = 30000;
         }

         JSONUtils.put(var3, "maxAdDuration", var2);
         return var3;
      } else {
         return null;
      }
   }
}
