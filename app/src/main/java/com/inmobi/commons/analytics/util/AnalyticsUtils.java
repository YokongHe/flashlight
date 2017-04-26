package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Base64OutputStream;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper$IMItemType;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper$IMSectionStatus;
import com.inmobi.commons.internal.Log;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.zip.GZIPOutputStream;

public class AnalyticsUtils {
   public static final String ANALYTICS_LOGGING_TAG = "[InMobi]-[Analytics]-4.5.2";
   public static final String INITIALIZE_NOT_CALLED = "Please call InMobi.initialize or startSession before calling any events API";
   private static String a;
   private static boolean b;

   public static void asyncPingInternal(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static String compressPayload(String var0) {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         Base64OutputStream var2 = new Base64OutputStream(var1, 0);
         GZIPOutputStream var3 = new GZIPOutputStream(var2);
         var3.write(var0.getBytes("UTF-8"));
         var3.close();
         var2.close();
         var0 = var1.toString();
         return var0;
      } catch (Exception var4) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Exception compress sdk payload.", var4);
         return null;
      }
   }

   public static String convertItemType(AnalyticsEventsWrapper$IMItemType var0) {
      String var1 = null;
      if(var0 == AnalyticsEventsWrapper$IMItemType.CONSUMABLE) {
         var1 = "1";
      } else {
         if(var0 == AnalyticsEventsWrapper$IMItemType.DURABLE) {
            return "2";
         }

         if(var0 == AnalyticsEventsWrapper$IMItemType.PERSONALIZATION) {
            return "3";
         }
      }

      return var1;
   }

   public static String convertLevelStatus(AnalyticsEventsWrapper$IMSectionStatus var0) {
      String var1 = null;
      if(var0 == AnalyticsEventsWrapper$IMSectionStatus.COMPLETED) {
         var1 = "1";
      } else {
         if(var0 == AnalyticsEventsWrapper$IMSectionStatus.FAILED) {
            return "2";
         }

         if(var0 == AnalyticsEventsWrapper$IMSectionStatus.CANCELED) {
            return "3";
         }
      }

      return var1;
   }

   public static String convertToJSON(Map param0) {
      // $FF: Couldn't be decompiled
   }

   public static String getAppVersion(Context var0) {
      try {
         String var2 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionName;
         return var2;
      } catch (Exception var1) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Error retrieving application version");
         return null;
      }
   }

   public static String getApplicationName(Context var0) {
      try {
         PackageManager var1 = var0.getPackageManager();
         String var3 = (String)var1.getApplicationLabel(var1.getApplicationInfo(var0.getPackageName(), 0));
         return var3;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Error retrieving application name");
         return null;
      }
   }

   public static Object getCountryISO(Context var0) {
      TelephonyManager var1 = (TelephonyManager)var0.getSystemService("phone");
      new Object();
      String var4;
      if(var1.getNetworkCountryIso().equals("")) {
         try {
            var4 = var0.getResources().getConfiguration().locale.getISO3Country();
         } catch (MissingResourceException var3) {
            var4 = null;
         }
      } else {
         try {
            var4 = var1.getNetworkCountryIso();
         } catch (MissingResourceException var2) {
            var4 = null;
         }
      }

      String var5;
      if(var4 != null) {
         var5 = var4;
         if(!var4.equals("")) {
            return var5;
         }
      }

      var5 = null;
      return var5;
   }

   public static float getDeviceDensity(Context var0) {
      return var0.getResources().getDisplayMetrics().density;
   }

   public static String getEventUrl() {
      return AnalyticsInitializer.getConfigParams().getEndPoints().getEventsUrl();
   }

   public static int getExtraParamsLimit() {
      synchronized(AnalyticsUtils.class){}

      int var0;
      try {
         var0 = AnalyticsInitializer.getConfigParams().getExtraParamsLimit();
      } finally {
         ;
      }

      return var0;
   }

   public static int getMaxRetryBeforeDiscard() {
      synchronized(AnalyticsUtils.class){}

      int var0;
      try {
         var0 = AnalyticsInitializer.getConfigParams().getMaxRetryBeforeCacheDiscard();
      } finally {
         ;
      }

      return var0;
   }

   public static long getMaxdbcount() {
      synchronized(AnalyticsUtils.class){}
      boolean var5 = false;

      int var0;
      try {
         var5 = true;
         var0 = AnalyticsInitializer.getConfigParams().getMaxDbEvents();
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      long var1 = (long)var0;
      return var1;
   }

   public static String getMaxevents() {
      synchronized(AnalyticsUtils.class){}

      String var0;
      try {
         var0 = "" + AnalyticsInitializer.getConfigParams().getGetParamsLimit();
      } finally {
         ;
      }

      return var0;
   }

   public static int getMaxparamskey() {
      synchronized(AnalyticsUtils.class){}

      int var0;
      try {
         var0 = AnalyticsInitializer.getConfigParams().getMaxKeyLength();
      } finally {
         ;
      }

      return var0;
   }

   public static int getMaxstring() {
      synchronized(AnalyticsUtils.class){}

      int var0;
      try {
         var0 = AnalyticsInitializer.getConfigParams().getMaxValLength();
      } finally {
         ;
      }

      return var0;
   }

   public static String getScreenHeight(Context var0) {
      int var1 = var0.getResources().getDisplayMetrics().heightPixels;
      return "" + var1;
   }

   public static String getScreenWidth(Context var0) {
      int var1 = var0.getResources().getDisplayMetrics().widthPixels;
      return "" + var1;
   }

   public static boolean getStartHandle() {
      synchronized(AnalyticsUtils.class){}

      boolean var0;
      try {
         var0 = b;
      } finally {
         ;
      }

      return var0;
   }

   public static long getTimeinterval() {
      synchronized(AnalyticsUtils.class){}
      boolean var5 = false;

      int var0;
      try {
         var5 = true;
         var0 = AnalyticsInitializer.getConfigParams().getPingInterval();
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      long var1 = (long)var0;
      return var1;
   }

   public static String getWebviewUserAgent() {
      return a;
   }

   public static void setStartHandle(boolean var0) {
      synchronized(AnalyticsUtils.class){}

      try {
         b = var0;
      } finally {
         ;
      }

   }

   public static void setWebviewUserAgent(String var0) {
      a = var0;
   }
}
