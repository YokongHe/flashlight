package com.inmobi.commons.network;

import com.inmobi.commons.InMobi;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.uid.UID;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

public class RequestBuilderUtils {
   public static final String KEY_MK_SITE_ID = "mk-siteid";
   public static final String KEY_MK_SITE_SLOT_ID = "mk-site-slotid";
   public static final String RULE_ID = "rule-id";

   private static String a(Calendar var0) {
      String var1 = null;
      if(var0 != null) {
         var1 = var0.get(1) + "-" + (var0.get(2) + 1) + "-" + var0.get(5);
      }

      return var1;
   }

   public static void fillAppInfoMap(Map var0) {
      if(AppInfo.getAppBId() != null) {
         var0.put("u-appbid", AppInfo.getAppBId());
      }

      if(AppInfo.getAppDisplayName() != null) {
         var0.put("u-appDNM", AppInfo.getAppDisplayName());
      }

      if(AppInfo.getAppVer() != null) {
         var0.put("u-appver", AppInfo.getAppVer());
      }

   }

   public static void fillDemogMap(Map var0) {
      if(var0 != null) {
         if(DemogInfo.getAge().intValue() > 0) {
            var0.put("u-age", DemogInfo.getAge());
         }

         if(DemogInfo.getPostalCode() != null) {
            var0.put("u-postalCode", DemogInfo.getPostalCode());
         }

         if(DemogInfo.getAreaCode() != null) {
            var0.put("u-areaCode", DemogInfo.getAreaCode());
         }

         if(DemogInfo.getDateOfBirth() != null) {
            var0.put("u-dateOfBirth", a(DemogInfo.getDateOfBirth()));
         }

         if(DemogInfo.getEducation() != null) {
            var0.put("u-education", DemogInfo.getEducation().toString().toLowerCase(Locale.getDefault()));
         }

         if(DemogInfo.getEthnicity() != null) {
            var0.put("u-ethnicity", DemogInfo.getEthnicity().toString().toLowerCase(Locale.getDefault()));
         }

         if(DemogInfo.getGender() != null) {
            var0.put("u-gender", DemogInfo.getGender().toString().toLowerCase(Locale.getDefault()));
         }

         if(DemogInfo.getHasChildren() != null) {
            var0.put("u-haschildren", DemogInfo.getHasChildren().toString().toLowerCase(Locale.getDefault()));
         }

         if(DemogInfo.getIncome().intValue() > 0) {
            var0.put("u-income", DemogInfo.getIncome());
         }

         if(DemogInfo.getInterests() != null) {
            var0.put("u-interests", DemogInfo.getInterests());
         }

         if(DemogInfo.getLanguage() != null) {
            var0.put("u-language", DemogInfo.getLanguage());
         }

         if(DemogInfo.getLocationWithCityStateCountry() != null) {
            var0.put("u-location", DemogInfo.getLocationWithCityStateCountry());
         }

         if(DemogInfo.getMaritalStatus() != null) {
            var0.put("u-marital", DemogInfo.getMaritalStatus().toString().toLowerCase(Locale.getDefault()));
         }

         if(DemogInfo.getSexualOrientation() != null) {
            var0.put("u-sexualorientation", DemogInfo.getSexualOrientation().toString().toLowerCase(Locale.getDefault()));
         }
      }

   }

   public static void fillDeviceMap(Map var0) {
      if(var0 != null) {
         if(DeviceInfo.getScreenDensity() != null) {
            var0.put("d-device-screen-density", DeviceInfo.getScreenDensity());
         }

         if(DeviceInfo.getScreenSize() != null) {
            var0.put("d-device-screen-size", DeviceInfo.getScreenSize());
         }

         var0.put("d-orientation", Integer.valueOf(DeviceInfo.getOrientation()));
         if(DeviceInfo.getNetworkType() != null) {
            var0.put("d-netType", DeviceInfo.getNetworkType());
         }

         if(DeviceInfo.getLocalization() != null) {
            var0.put("d-localization", DeviceInfo.getLocalization());
         }
      }

   }

   public static void fillIdentityMap(Map var0, Map var1, boolean var2) {
      if(var0 != null) {
         var0.put("mk-siteid", InMobi.getAppId());
         String var4 = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.2") + "-20141120";
         var0.put("mk-version", var4);
         var0.put("mk-rel-version", var4);
         if(DeviceInfo.getPhoneDefaultUserAgent() != null && !"".equals(DeviceInfo.getPhoneDefaultUserAgent())) {
            var0.put("h-user-agent", DeviceInfo.getPhoneDefaultUserAgent());
         }

         if(UID.getInstance().isLimitAdTrackingEnabled()) {
            var0.put("u-id-adt", Integer.valueOf(1));
         } else {
            var0.put("u-id-adt", Integer.valueOf(0));
         }

         if(var2) {
            var1 = UID.getInstance().getMapForEncryption(var1);
            if(var1 != null) {
               var0.putAll(var1);
            }
         } else {
            var0.remove("u-id-key");
            var0.remove("u-key-ver");
            var0.put("u-id-map", UID.getInstance().getJSON(var1));
         }

         Calendar var5 = Calendar.getInstance();
         System.currentTimeMillis();
         var0.put("ts", Long.valueOf(var5.getTimeInMillis()));
         int var3 = var5.get(15);
         var0.put("tz", Integer.valueOf(var5.get(16) + var3));
         if(InternalSDKUtil.getLtvpSessionId() != null && !InternalSDKUtil.getLtvpSessionId().equals("")) {
            var0.put("u-s-id", InternalSDKUtil.getLtvpSessionId());
         }
      }

   }

   public static void fillLocationMap(Map param0) {
      // $FF: Couldn't be decompiled
   }
}
