package com.amazon.device.ads;

import android.location.Location;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$StringParameter;
import com.amazon.device.ads.AdLocation;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.Configuration$ConfigOption;

class AAXParameter$GeoLocationParameter extends AAXParameter$StringParameter {
   AAXParameter$GeoLocationParameter() {
      super("geoloc", "debug.geoloc");
   }

   protected String getDerivedValue(AAXParameter$ParameterData var1) {
      if(Configuration.getInstance().getBoolean(Configuration$ConfigOption.SEND_GEO) && AAXParameter$ParameterData.access$200(var1).getAdTargetingOptions().isGeoLocationEnabled()) {
         Location var2 = (new AdLocation()).getLocation();
         if(var2 != null) {
            return var2.getLatitude() + "," + var2.getLongitude();
         }
      }

      return null;
   }
}
