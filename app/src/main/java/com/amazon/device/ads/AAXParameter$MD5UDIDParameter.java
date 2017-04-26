package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;
import com.amazon.device.ads.InternalAdRegistration;

class AAXParameter$MD5UDIDParameter extends AAXParameter$StringParameter {
   AAXParameter$MD5UDIDParameter() {
      super("md5_udid", "debug.md5udid");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      return !AAXParameter$ParameterData.access$200(var1).getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()?InternalAdRegistration.getInstance().getDeviceInfo().getUdidMd5():null;
   }
}
