package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AdRequest;
import com.amazon.device.ads.AdRequest$JSONObjectBuilder;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.AdTargetingOptions;
import java.util.HashMap;
import org.json.JSONObject;

class AdRequest$LOISlot {
   static final AAXParameter[] PARAMETERS;
   private final AdSlot adSlot;
   private final AdRequest$JSONObjectBuilder jsonObjectBuilder;
   private final AdTargetingOptions opt;

   static {
      PARAMETERS = new AAXParameter[]{AAXParameter.SIZE, AAXParameter.PAGE_TYPE, AAXParameter.SLOT, AAXParameter.SLOT_POSITION, AAXParameter.MAX_SIZE, AAXParameter.SLOT_ID, AAXParameter.FLOOR_PRICE, AAXParameter.SUPPORTED_MEDIA_TYPES, AAXParameter.VIDEO_OPTIONS};
   }

   AdRequest$LOISlot(AdSlot var1, AdRequest var2) {
      this.opt = var1.getAdTargetingOptions();
      this.adSlot = var1;
      HashMap var3 = this.opt.getCopyOfAdvancedOptions();
      AAXParameter$ParameterData var4 = (new AAXParameter$ParameterData()).setAdvancedOptions(var3).setLOISlot(this).setAdRequest(var2);
      this.jsonObjectBuilder = (new AdRequest$JSONObjectBuilder()).setAAXParameters(PARAMETERS).setAdvancedOptions(var3).setParameterData(var4);
   }

   AdSlot getAdSlot() {
      return this.adSlot;
   }

   AdTargetingOptions getAdTargetingOptions() {
      return this.opt;
   }

   JSONObject getJSON() {
      this.jsonObjectBuilder.build();
      return this.jsonObjectBuilder.getJSON();
   }
}
