package com.inmobi.commons;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.InMobi$LOG_LEVEL;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.Log$INTERNAL_LOG_LEVEL;
import com.inmobi.commons.uid.UID;
import java.util.Calendar;

public final class InMobi {
   public static final int EXCLUDE_FB_ID = 4;
   public static final int EXCLUDE_ODIN1 = 2;
   public static final int EXCLUDE_UM5_ID = 8;
   public static final int ID_DEVICE_NONE = 0;
   public static final int INCLUDE_DEFAULT = 1;
   private static String a = null;

   private static void a(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static void addIDType(IMIDType var0, String var1) {
      DemogInfo.addIDType(var0, var1);
   }

   public static String getAppId() {
      return a;
   }

   public static String getVersion() {
      return "4.5.2";
   }

   public static void initialize(Activity var0, String var1) {
      a(var0, var1);
   }

   public static void initialize(Context var0, String var1) {
      a(var0, var1);
   }

   public static void removeIDType(IMIDType var0) {
      DemogInfo.removeIDType(var0);
   }

   public static void setAge(int var0) {
      DemogInfo.setAge(Integer.valueOf(var0));
   }

   public static void setAreaCode(String var0) {
      if(var0 != null && !"".equals(var0.trim())) {
         DemogInfo.setAreaCode(var0);
      } else {
         Log.debug("[InMobi]-4.5.2", "Area code cannot be null");
      }
   }

   public static void setCurrentLocation(Location var0) {
      if(var0 != null) {
         DemogInfo.setCurrentLocation(var0);
      } else {
         Log.debug("[InMobi]-4.5.2", "Location cannot be null");
      }
   }

   public static void setDateOfBirth(Calendar var0) {
      if(var0 != null) {
         DemogInfo.setDateOfBirth(var0);
      } else {
         Log.debug("[InMobi]-4.5.2", "Date Of Birth cannot be null");
      }
   }

   public static void setDeviceIDMask(int var0) {
      DemogInfo.setDeviceIDMask(var0);
      UID.getInstance().setPublisherDeviceIdMaskMap(var0);
   }

   public static void setEducation(EducationType var0) {
      if(var0 != null) {
         DemogInfo.setEducation(var0);
      }

   }

   public static void setEthnicity(EthnicityType var0) {
      if(var0 != null) {
         DemogInfo.setEthnicity(var0);
      }

   }

   public static void setGender(GenderType var0) {
      if(var0 != null) {
         DemogInfo.setGender(var0);
      }

   }

   public static void setHasChildren(HasChildren var0) {
      if(var0 != null) {
         DemogInfo.setHasChildren(var0);
      }

   }

   public static void setIncome(int var0) {
      DemogInfo.setIncome(Integer.valueOf(var0));
   }

   public static void setInterests(String var0) {
      if(var0 != null && !"".equals(var0.trim())) {
         DemogInfo.setInterests(var0);
      } else {
         Log.debug("[InMobi]-4.5.2", "Interests cannot be null");
      }
   }

   public static void setLanguage(String var0) {
      if(var0 != null && !"".equals(var0.trim())) {
         DemogInfo.setLanguage(var0);
      } else {
         Log.debug("[InMobi]-4.5.2", "Language cannot be null");
      }
   }

   public static void setLocationWithCityStateCountry(String var0, String var1, String var2) {
      DemogInfo.setLocationWithCityStateCountry(var0, var1, var2);
   }

   public static void setLogLevel(InMobi$LOG_LEVEL var0) {
      if(var0 == InMobi$LOG_LEVEL.NONE) {
         Log.setInternalLogLevel(Log$INTERNAL_LOG_LEVEL.NONE);
      } else if(var0 == InMobi$LOG_LEVEL.DEBUG) {
         Log.setInternalLogLevel(Log$INTERNAL_LOG_LEVEL.DEBUG);
      } else if(var0 == InMobi$LOG_LEVEL.VERBOSE) {
         Log.setInternalLogLevel(Log$INTERNAL_LOG_LEVEL.VERBOSE);
      } else {
         Log.setInternalLogLevel(Log$INTERNAL_LOG_LEVEL.INTERNAL);
      }
   }

   public static void setMaritalStatus(MaritalStatus var0) {
      if(var0 != null) {
         DemogInfo.setMaritalStatus(var0);
      }

   }

   public static void setPostalCode(String var0) {
      if(var0 != null && !"".equals(var0.trim())) {
         DemogInfo.setPostalCode(var0);
      } else {
         Log.debug("[InMobi]-4.5.2", "Postal Code cannot be null");
      }
   }

   public static void setSexualOrientation(SexualOrientation var0) {
      if(var0 != null) {
         DemogInfo.setSexualOrientation(var0);
      }

   }
}
