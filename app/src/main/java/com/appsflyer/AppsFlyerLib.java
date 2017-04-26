package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.util.Log;
import com.appsflyer.AppsFlyerLib$DataCollector;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.AttributionIDNotReady;
import com.appsflyer.ConversionDataListener;
import com.appsflyer.DebugLogQueue;
import com.appsflyer.Installation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppsFlyerLib extends BroadcastReceiver {
   static final String AF_COUNTER_PREF = "appsFlyerCount";
   protected static final String AF_SHARED_PREF = "appsflyer-data";
   public static final String APPS_TRACKING_URL = "https://track.appsflyer.com/api/v2.3/androidevent?buildnumber=1.5.2&app_id=";
   public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
   public static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
   static final String ATTRIBUTION_ID_PREF = "attributionId";
   private static final String CACHED_CHANNEL_PREF = "CACHED_CHANNEL";
   private static final String CALL_SERVER_ACTION = "call server.";
   private static final String ERROR_PREFIX = "ERROR:";
   static final String FIRST_INSTALL_PREF = "appsFlyerFirstInstall";
   private static final String INSTALL_UPDATE_DATE_FORMAT = "yyyy-MM-dd_hhmmZ";
   public static final String LOG_TAG = "AppsFlyer_1.5.2";
   private static final String ON_RECIEVE_CALLED = "onRecieve called. refferer=";
   private static final String PREPARE_DATA_ACTION = "collect data for server";
   protected static final String REFERRER_PREF = "referrer";
   public static final String SDK_BUILD_NUMBER = "1.5.2";
   static final String SENT_SUCCESSFULLY_PREF = "sentSuccessfully";
   public static final String SERVER_BUILD_NUMBER = "2.3";
   private static final String SERVER_RESPONDED_ACTION = "response from server. status=";
   private static final String WARNING_PREFIX = "WARNING:";
   private static ConversionDataListener conversionDataListener = null;

   // $FF: synthetic method
   static void access$200(Context var0, String var1, String var2, String var3, String var4) {
      sendTrackingWithEvent(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static void access$300(String var0, String var1, Context var2) {
      debugAction(var0, var1, var2);
   }

   // $FF: synthetic method
   static String access$400(Context var0) {
      return getConfiguredChannel(var0);
   }

   // $FF: synthetic method
   static String access$500(Context var0, String var1) {
      return getCachedChannel(var0, var1);
   }

   // $FF: synthetic method
   static Map access$600(String var0) {
      return attributionStringToMap(var0);
   }

   // $FF: synthetic method
   static ConversionDataListener access$700() {
      return conversionDataListener;
   }

   private static void addAdvertiserIDData(Context param0, Map param1) {
      // $FF: Couldn't be decompiled
   }

   private static Map attributionStringToMap(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static void debugAction(String var0, String var1, Context var2) {
      if(var2 != null && "com.appsflyer".equals(var2.getPackageName())) {
         DebugLogQueue.getInstance().push(var0 + var1);
      }

   }

   public static String getAppId() {
      return getProperty("appid");
   }

   public static String getAppUserId() {
      return getProperty("AppUserId");
   }

   public static String getAppsFlyerUID(Context var0) {
      return Installation.id(var0);
   }

   public static String getAttributionId(ContentResolver var0) {
      Cursor var10 = var0.query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid"}, (String)null, (String[])null, (String)null);
      if(var10 != null && var10.moveToFirst()) {
         try {
            String var1 = var10.getString(var10.getColumnIndex("aid"));
            return var1;
         } catch (Exception var8) {
            Log.w("AppsFlyer_1.5.2", var8);
         } finally {
            try {
               var10.close();
            } catch (Exception var7) {
               ;
            }

         }

         return null;
      } else {
         return null;
      }
   }

   private static String getCachedChannel(Context var0, String var1) {
      SharedPreferences var2 = var0.getSharedPreferences("appsflyer-data", 0);
      if(var2.contains("CACHED_CHANNEL")) {
         return var2.getString("CACHED_CHANNEL", (String)null);
      } else {
         Editor var3 = var2.edit();
         var3.putString("CACHED_CHANNEL", var1);
         var3.commit();
         return var1;
      }
   }

   private static String getConfiguredChannel(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static Map getConversionData(Context var0) {
      SharedPreferences var1 = var0.getSharedPreferences("appsflyer-data", 0);
      String var2 = AppsFlyerProperties.getInstance().getReferrer(var0);
      if(var2 != null && var2.length() > 0 && var2.contains("af_tranid")) {
         return referrerStringToMap(var2);
      } else {
         var2 = var1.getString("attributionId", (String)null);
         if(var2 != null && var2.length() > 0) {
            return attributionStringToMap(var2);
         } else {
            throw new AttributionIDNotReady();
         }
      }
   }

   public static void getConversionData(Context var0, ConversionDataListener var1) {
      if(var1 != null) {
         try {
            var1.onConversionDataLoaded(getConversionData(var0));
         } catch (AttributionIDNotReady var2) {
            conversionDataListener = var1;
         } catch (Exception var3) {
            Log.e("AppsFlyer_1.5.2", "error in onConversionDataLoaded", var3);
         }
      }
   }

   private static String getFirstInstallDate(SimpleDateFormat var0, Context var1) {
      SharedPreferences var3 = var1.getSharedPreferences("appsflyer-data", 0);
      String var2 = var3.getString("appsFlyerFirstInstall", (String)null);
      String var5 = var2;
      if(var2 == null) {
         String var4;
         if(var3.getInt("appsFlyerCount", 1) < 2) {
            Log.d("AppsFlyer_1.5.2", "AppsFlyer: first launch detected");
            var4 = var0.format(new Date());
         } else {
            var4 = "";
         }

         Editor var6 = var3.edit();
         var6.putString("appsFlyerFirstInstall", var4);
         var6.commit();
         var5 = var4;
      }

      Log.i("AppsFlyer_1.5.2", "AppsFlyer: first launch date: " + var5);
      return var5;
   }

   private static String getNetwork(Context var0) {
      ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");
      return var1.getNetworkInfo(1).isConnectedOrConnecting()?"WIFI":(var1.getNetworkInfo(0).isConnectedOrConnecting()?"MOBILE":"unkown");
   }

   public static String getProperty(String var0) {
      return AppsFlyerProperties.getInstance().get(var0);
   }

   public static boolean isPreInstalledApp(Context var0) {
      boolean var2 = false;

      int var1;
      try {
         var1 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 0).flags;
      } catch (NameNotFoundException var3) {
         Log.e("AppsFlyer_1.5.2", "Could not check if app is pre installed", var3);
         return false;
      }

      if((var1 & 1) != 0) {
         var2 = true;
      }

      return var2;
   }

   private static Map referrerStringToMap(String var0) {
      HashMap var3 = new HashMap();
      int var1 = var0.indexOf(38);
      if(var1 >= 0 && var0.length() > var1 + 1) {
         String[] var4 = var0.split("\\&");
         int var2 = var4.length;

         for(var1 = 0; var1 < var2; ++var1) {
            String[] var6 = var4[var1].split("=");
            String var5 = var6[0];
            if(var6.length > 1) {
               var0 = var6[1];
            } else {
               var0 = "";
            }

            var3.put(var5, var0);
         }
      }

      return var3;
   }

   private static void runInBackground(Context var0, String var1, String var2, String var3, String var4) {
      Executors.newScheduledThreadPool(1).schedule(new AppsFlyerLib$DataCollector(var0, var1, var2, var3, var4, null), 5L, TimeUnit.MILLISECONDS);
   }

   public static void sendTracking(Context var0) {
      sendTrackingWithEvent(var0, (String)null, (String)null, (String)null);
      AppsFlyerProperties.getInstance().setLaunchCalled();
   }

   @Deprecated
   public static void sendTracking(Context var0, String var1) {
      sendTrackingWithEvent(var0, var1, (String)null, (String)null);
   }

   public static void sendTrackingWithEvent(Context var0, String var1, String var2) {
      sendTrackingWithEvent(var0, (String)null, var1, var2);
   }

   public static void sendTrackingWithEvent(Context var0, String var1, String var2, String var3) {
      String var5 = AppsFlyerProperties.getInstance().getReferrer(var0);
      String var4 = var5;
      if(var5 == null) {
         var4 = "";
      }

      runInBackground(var0, var1, var2, var3, var4);
   }

   private static void sendTrackingWithEvent(Context param0, String param1, String param2, String param3, String param4) {
      // $FF: Couldn't be decompiled
   }

   public static void setAppId(String var0) {
      setProperty("appid", var0);
   }

   public static void setAppUserId(String var0) {
      setProperty("AppUserId", var0);
   }

   public static void setAppsFlyerKey(String var0) {
      setProperty("AppsFlyerKey", var0);
   }

   public static void setCollectAndroidID(boolean var0) {
      setProperty("collectAndroidId", Boolean.toString(var0));
   }

   public static void setCollectIMEI(boolean var0) {
      setProperty("collectIMEI", Boolean.toString(var0));
   }

   public static void setCollectMACAddress(boolean var0) {
      setProperty("collectMAC", Boolean.toString(var0));
   }

   public static void setCurrencyCode(String var0) {
      AppsFlyerProperties.getInstance().set("currencyCode", var0);
   }

   public static void setDeviceTrackingDisabled(boolean var0) {
      AppsFlyerProperties.getInstance().set("deviceTrackingDisabled", var0);
   }

   public static void setIsUpdate(boolean var0) {
      AppsFlyerProperties.getInstance().set("IS_UPDATE", var0);
   }

   public static void setProperty(String var0, String var1) {
      AppsFlyerProperties.getInstance().set(var0, var1);
   }

   public static void setUseHTTPFalback(boolean var0) {
      setProperty("useHttpFallback", Boolean.toString(var0));
   }

   public void onReceive(Context var1, Intent var2) {
      Log.i("AppsFlyer_1.5.2", "****** onReceive called *******");
      debugAction("******* onReceive: ", "", var1);
      AppsFlyerProperties.getInstance().setOnReceiveCalled();
      String var4 = var2.getStringExtra("referrer");
      Log.i("AppsFlyer_1.5.2", "referrer=" + var4);
      if(var4 != null) {
         debugAction("BroadcastReceiver got referrer: ", var4, var1);
         debugAction("onRecieve called. refferer=", var4, var1);
         Editor var3 = var1.getSharedPreferences("appsflyer-data", 0).edit();
         var3.putString("referrer", var4);
         var3.commit();
         AppsFlyerProperties.getInstance().setReferrer(var4);
         if(AppsFlyerProperties.getInstance().isLaunchCalled()) {
            sendTrackingWithEvent(var1, (String)null, (String)null, (String)null, var4);
         }
      }

   }
}
