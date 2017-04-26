package com.inmobi.commons.data;

import android.location.Location;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class DemogInfo {
   private static int a = 1;
   private static Location b;
   private static EducationType c;
   private static EthnicityType d;
   private static GenderType e;
   private static Calendar f;
   private static Integer g = Integer.valueOf(0);
   private static Integer h = Integer.valueOf(0);
   private static String i;
   private static String j;
   private static String k;
   private static String l;
   private static HasChildren m;
   private static MaritalStatus n;
   private static String o;
   private static SexualOrientation p;
   private static Map q = new HashMap();

   public static void addIDType(IMIDType var0, String var1) {
      if(q != null) {
         q.put(var0, var1);
      }

   }

   public static Integer getAge() {
      return h;
   }

   public static String getAreaCode() {
      return l;
   }

   public static Location getCurrentLocation() {
      return b;
   }

   public static Calendar getDateOfBirth() {
      return f;
   }

   public static int getDeviceIDMask() {
      return a;
   }

   public static EducationType getEducation() {
      return c;
   }

   public static EthnicityType getEthnicity() {
      return d;
   }

   public static GenderType getGender() {
      return e;
   }

   public static HasChildren getHasChildren() {
      return m;
   }

   public static String getIDType(IMIDType var0) {
      return q != null?(String)q.get(var0):null;
   }

   public static Integer getIncome() {
      return g;
   }

   public static String getInterests() {
      return i;
   }

   public static String getLanguage() {
      return o;
   }

   public static String getLocationWithCityStateCountry() {
      return j;
   }

   public static MaritalStatus getMaritalStatus() {
      return n;
   }

   public static String getPostalCode() {
      return k;
   }

   public static SexualOrientation getSexualOrientation() {
      return p;
   }

   public static boolean isLocationInquiryAllowed() {
      return AnalyticsInitializer.getConfigParams().getAutomaticCapture().isAutoLocationCaptureEnabled();
   }

   public static void removeIDType(IMIDType var0) {
      if(q != null) {
         q.remove(var0);
      }

   }

   public static void setAge(Integer var0) {
      h = var0;
   }

   public static void setAreaCode(String var0) {
      l = var0;
   }

   public static void setCurrentLocation(Location var0) {
      b = var0;
   }

   public static void setDateOfBirth(Calendar var0) {
      f = var0;
   }

   public static void setDeviceIDMask(int var0) {
      a = var0;
   }

   public static void setEducation(EducationType var0) {
      c = var0;
   }

   public static void setEthnicity(EthnicityType var0) {
      d = var0;
   }

   public static void setGender(GenderType var0) {
      e = var0;
   }

   public static void setHasChildren(HasChildren var0) {
      m = var0;
   }

   public static void setIncome(Integer var0) {
      g = var0;
   }

   public static void setInterests(String var0) {
      i = var0;
   }

   public static void setLanguage(String var0) {
      o = var0;
   }

   public static void setLocationWithCityStateCountry(String var0, String var1, String var2) {
      if(var0 != null && !"".equals(var0.trim())) {
         j = var0;
      }

      if(var1 != null && !"".equals(var1.trim())) {
         j = j + "-" + var1;
      }

      if(var2 != null && !"".equals(var2.trim())) {
         j = j + "-" + var2;
      }

   }

   public static void setMaritalStatus(MaritalStatus var0) {
      n = var0;
   }

   public static void setPostalCode(String var0) {
      k = var0;
   }

   public static void setSexualOrientation(SexualOrientation var0) {
      p = var0;
   }
}
