package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$JSONObjectParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.InternalAdRegistration;
import org.json.JSONObject;

class AAXParameter$DeviceInfoParameter extends AAXParameter$JSONObjectParameter {
   AAXParameter$DeviceInfoParameter() {
      super("dinfo", "debug.dinfo");
   }

   protected JSONObject getDerivedValue(AAXParameter$ParameterData var1) {
      return InternalAdRegistration.getInstance().getDeviceInfo().toJsonObject(AAXParameter$ParameterData.access$200(var1).getOrientation());
   }
}
