package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$BooleanParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.Settings;

class AAXParameter$TestParameter extends AAXParameter$BooleanParameter {
   AAXParameter$TestParameter() {
      super("isTest", "debug.test");
   }

   protected Boolean getDerivedValue(AAXParameter$ParameterData var1) {
      return Settings.getInstance().getBoolean("testingEnabled", (Boolean)null);
   }
}
