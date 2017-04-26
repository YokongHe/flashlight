package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter$AdvertisingIdentifierParameter;
import com.amazon.device.ads.AAXParameter$AppKeyParameter;
import com.amazon.device.ads.AAXParameter$DeviceInfoParameter;
import com.amazon.device.ads.AAXParameter$FloorPriceParameter;
import com.amazon.device.ads.AAXParameter$GeoLocationParameter;
import com.amazon.device.ads.AAXParameter$JSONArrayParameter;
import com.amazon.device.ads.AAXParameter$MD5UDIDParameter;
import com.amazon.device.ads.AAXParameter$MaxSizeParameter;
import com.amazon.device.ads.AAXParameter$OptOutParameter;
import com.amazon.device.ads.AAXParameter$PackageInfoParameter;
import com.amazon.device.ads.AAXParameter$ParameterData;
import com.amazon.device.ads.AAXParameter$SDKVersionParameter;
import com.amazon.device.ads.AAXParameter$SHA1UDIDParameter;
import com.amazon.device.ads.AAXParameter$SISDeviceIdentifierParameter;
import com.amazon.device.ads.AAXParameter$SizeParameter;
import com.amazon.device.ads.AAXParameter$SlotIdParameter;
import com.amazon.device.ads.AAXParameter$SlotParameter;
import com.amazon.device.ads.AAXParameter$StringParameter;
import com.amazon.device.ads.AAXParameter$SupportedMediaTypesParameter;
import com.amazon.device.ads.AAXParameter$TestParameter;
import com.amazon.device.ads.AAXParameter$UserAgentParameter;
import com.amazon.device.ads.AAXParameter$VideoOptionsParameter;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.StringUtils;

abstract class AAXParameter {
   static final AAXParameter ADVERTISING_IDENTIFIER = new AAXParameter$AdvertisingIdentifierParameter();
   static final AAXParameter APP_KEY = new AAXParameter$AppKeyParameter();
   static final AAXParameter CHANNEL = new AAXParameter$StringParameter("c", "debug.channel");
   static final AAXParameter DEVICE_INFO = new AAXParameter$DeviceInfoParameter();
   static final AAXParameter FLOOR_PRICE = new AAXParameter$FloorPriceParameter();
   static final AAXParameter GEOLOCATION = new AAXParameter$GeoLocationParameter();
   private static final String LOG_TAG = AAXParameter.class.getSimpleName();
   static final AAXParameter MAX_SIZE = new AAXParameter$MaxSizeParameter();
   static final AAXParameter MD5_UDID = new AAXParameter$MD5UDIDParameter();
   static final AAXParameter OPT_OUT = new AAXParameter$OptOutParameter();
   static final AAXParameter PACKAGE_INFO = new AAXParameter$PackageInfoParameter();
   static final AAXParameter PAGE_TYPE = new AAXParameter$StringParameter("pt", "debug.pt");
   static final AAXParameter PUBLISHER_ASINS = new AAXParameter$JSONArrayParameter("pa", "debug.pa");
   static final AAXParameter PUBLISHER_KEYWORDS = new AAXParameter$JSONArrayParameter("pk", "debug.pk");
   static final AAXParameter SDK_VERSION = new AAXParameter$SDKVersionParameter();
   static final AAXParameter SHA1_UDID = new AAXParameter$SHA1UDIDParameter();
   static final AAXParameter SIS_DEVICE_IDENTIFIER = new AAXParameter$SISDeviceIdentifierParameter();
   static final AAXParameter SIZE = new AAXParameter$SizeParameter();
   static final AAXParameter SLOT = new AAXParameter$SlotParameter();
   static final AAXParameter SLOTS = new AAXParameter$JSONArrayParameter("slots", "debug.slots");
   static final AAXParameter SLOT_ID = new AAXParameter$SlotIdParameter();
   static final AAXParameter SLOT_POSITION = new AAXParameter$StringParameter("sp", "debug.sp");
   static final AAXParameter SUPPORTED_MEDIA_TYPES = new AAXParameter$SupportedMediaTypesParameter();
   static final AAXParameter TEST = new AAXParameter$TestParameter();
   static final AAXParameter USER_AGENT = new AAXParameter$UserAgentParameter();
   static final AAXParameter VIDEO_OPTIONS = new AAXParameter$VideoOptionsParameter();
   private final String debugName;
   private final String name;

   AAXParameter(String var1, String var2) {
      this.name = var1;
      this.debugName = var2;
   }

   // $FF: synthetic method
   static String access$100() {
      return LOG_TAG;
   }

   protected String getDebugName() {
      return this.debugName;
   }

   protected Object getDerivedValue(AAXParameter$ParameterData var1) {
      return null;
   }

   protected abstract Object getFromDebugProperties();

   String getName() {
      return this.name;
   }

   Object getValue(AAXParameter$ParameterData var1) {
      Object var3;
      if(this.hasDebugPropertiesValue()) {
         var3 = this.getFromDebugProperties();
      } else if(AAXParameter$ParameterData.access$000(var1).containsKey(this.name)) {
         var3 = this.parseFromString((String)AAXParameter$ParameterData.access$000(var1).remove(this.name));
      } else {
         var3 = this.getDerivedValue(var1);
      }

      Object var2 = var3;
      if(var3 instanceof String) {
         var2 = var3;
         if(StringUtils.isNullOrWhiteSpace((String)var3)) {
            var2 = null;
         }
      }

      return var2;
   }

   protected boolean hasDebugPropertiesValue() {
      return DebugProperties.containsDebugProperty(this.debugName);
   }

   protected abstract Object parseFromString(String var1);
}
