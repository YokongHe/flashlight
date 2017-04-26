package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$JSONObjectParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.InternalAdRegistration;
import org.json.JSONObject;

class AAXParameter$PackageInfoParameter extends AAXParameter$JSONObjectParameter {
   AAXParameter$PackageInfoParameter() {
      super("pkg", "debug.pkg");
   }

   protected JSONObject getDerivedValue(AAXParameter$ParameterData var1) {
      return InternalAdRegistration.getInstance().getAppInfo().getPackageInfoJSON();
   }
}
