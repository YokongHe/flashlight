package com.amazon.device.ads;

import com.amazon.device.ads.AdRequest;
import com.amazon.device.ads.AdRequest$LOISlot;
import java.util.HashMap;
import java.util.Map;

class AAXParameter$ParameterData {
   private AdRequest adRequest;
   private Map advancedOptions;
   private AdRequest$LOISlot loiSlot;
   private Map temporaryOptions = new HashMap();

   // $FF: synthetic method
   static Map access$000(AAXParameter$ParameterData var0) {
      return var0.advancedOptions;
   }

   // $FF: synthetic method
   static AdRequest access$200(AAXParameter$ParameterData var0) {
      return var0.adRequest;
   }

   // $FF: synthetic method
   static AdRequest$LOISlot access$300(AAXParameter$ParameterData var0) {
      return var0.loiSlot;
   }

   // $FF: synthetic method
   static Map access$400(AAXParameter$ParameterData var0) {
      return var0.temporaryOptions;
   }

   AAXParameter$ParameterData setAdRequest(AdRequest var1) {
      this.adRequest = var1;
      return this;
   }

   AAXParameter$ParameterData setAdvancedOptions(Map var1) {
      this.advancedOptions = var1;
      return this;
   }

   AAXParameter$ParameterData setLOISlot(AdRequest$LOISlot var1) {
      this.loiSlot = var1;
      return this;
   }
}
