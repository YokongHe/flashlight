package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;
import com.amazon.device.ads.InternalAdRegistration;

class AAXParameter$SHA1UDIDParameter extends AAXParameter$StringParameter {
   AAXParameter$SHA1UDIDParameter() {
      super("sha1_udid", "debug.sha1udid");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return !AAXParameter$ParameterData.access$200(var1).getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()?InternalAdRegistration.getInstance().getDeviceInfo().getUdidSha1():null;
   }
}
