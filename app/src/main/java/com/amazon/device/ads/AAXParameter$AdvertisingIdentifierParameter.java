package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;

class AAXParameter$AdvertisingIdentifierParameter extends AAXParameter$StringParameter {
   AAXParameter$AdvertisingIdentifierParameter() {
      super("idfa", "debug.idfa");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return AAXParameter$ParameterData.access$200(var1).getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()?AAXParameter$ParameterData.access$200(var1).getAdvertisingIdentifierInfo().getAdvertisingIdentifier():null;
   }
}
