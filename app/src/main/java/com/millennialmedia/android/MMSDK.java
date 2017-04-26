package com.millennialmedia.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.AdCache$Iterator;
import com.millennialmedia.android.CachedAd;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMConversionTracker;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.Utils$HttpUtils;
import java.io.IOException;
import java.util.Map;

public final class MMSDK {
   private static final String BASE_URL_TRACK_EVENT = "http://ads.mp.mydas.mobi/pixel?id=";
   static final int CACHE_REQUEST_TIMEOUT = 30000;
   static final int CLOSE_ACTIVITY_DURATION = 400;
   static String COMMA = ",";
   public static final String DEFAULT_APID = "28911";
   public static final String DEFAULT_BANNER_APID = "28913";
   public static final String DEFAULT_RECT_APID = "28914";
   static final String EMPTY = "";
   static final int HANDSHAKE_REQUEST_TIMEOUT = 3000;
   static final String JSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss ZZZZ";
   public static final int LOG_LEVEL_DEBUG = 1;
   public static final int LOG_LEVEL_ERROR = 0;
   public static final int LOG_LEVEL_INFO = 2;
   @Deprecated
   public static final int LOG_LEVEL_INTERNAL = 4;
   @Deprecated
   public static final int LOG_LEVEL_PRIVATE_VERBOSE = 5;
   public static final int LOG_LEVEL_VERBOSE = 3;
   static final int OPEN_ACTIVITY_DURATION = 600;
   static final String PREFS_NAME = "MillennialMediaSettings";
   static final int REQUEST_TIMEOUT = 10000;
   public static final String SDKLOG = "MMSDK";
   public static final String VERSION = "5.4.0-HASH.a";
   @Deprecated
   static boolean disableAdMinRefresh = false;
   private static String getMMdidValue = null;
   private static boolean hasSpeechKit = false;
   private static boolean isBroadcastingEvents;
   static int logLevel;
   static String macId;
   static Handler mainHandler = new Handler(Looper.getMainLooper());
   private static int nextDefaultId = 1897808289;

   static {
      try {
         System.loadLibrary("nmsp_speex");
         hasSpeechKit = true;
      } catch (UnsatisfiedLinkError var1) {
         ;
      }
   }

   // $FF: synthetic method
   static boolean access$000() {
      return isBroadcastingEvents;
   }

   static String byteArrayToString(byte[] var0) {
      StringBuilder var2 = new StringBuilder(var0.length * 2);

      for(int var1 = 0; var1 < var0.length; ++var1) {
         var2.append(String.format("%02X", new Object[]{Byte.valueOf(var0[var1])}));
      }

      return var2.toString();
   }

   static void checkActivity(Context var0) {
      PackageManager var1 = var0.getPackageManager();

      try {
         var1.getActivityInfo(new ComponentName(var0, "com.millennialmedia.android.MMActivity"), 128);
      } catch (NameNotFoundException var2) {
         MMLog.e("MMSDK", "Activity MMActivity not declared in AndroidManifest.xml", var2);
         var2.printStackTrace();
         createMissingPermissionDialog(var0, "MMActivity class").show();
      }
   }

   static void checkPermissions(Context var0) {
      if(var0.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
         createMissingPermissionDialog(var0, "INTERNET permission").show();
      }

      if(var0.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
         createMissingPermissionDialog(var0, "ACCESS_NETWORK_STATE permission").show();
      }

   }

   private static AlertDialog createMissingPermissionDialog(Context var0, String var1) {
      AlertDialog var2 = (new Builder(var0)).create();
      var2.setTitle("Whoops!");
      var2.setMessage(String.format("The developer has forgot to declare the %s in the manifest file. Please reach out to the developer to remove this error.", new Object[]{var1}));
      var2.setButton(-3, "OK", new OnClickListener() {
         public final void onClick(DialogInterface var1, int var2) {
            var1.cancel();
         }
      });
      var2.show();
      return var2;
   }

   static String getAaid(AdvertisingIdClient$Info var0) {
      return var0 == null?null:var0.getId();
   }

   static AdvertisingIdClient$Info getAdvertisingInfo(Context var0) {
      try {
         AdvertisingIdClient$Info var5 = AdvertisingIdClient.getAdvertisingIdInfo(var0);
         return var5;
      } catch (IOException var1) {
         MMLog.e("MMSDK", "Unrecoverable error connecting to Google Play services (e.g.,the old version of the service doesnt support getting AdvertisingId", var1);
         return null;
      } catch (com.google.android.gms.common.e var2) {
         MMLog.e("MMSDK", "Google Play services is not available entirely.", var2);
         return null;
      } catch (IllegalStateException var3) {
         MMLog.e("MMSDK", "IllegalStateException: ", var3);
         return null;
      } catch (com.google.android.gms.common.f var4) {
         MMLog.e("MMSDK", "Google Play Services is not installed, up-to-date, or enabled", var4);
         return null;
      }
   }

   public static boolean getBroadcastEvents() {
      return isBroadcastingEvents;
   }

   static String getCn(Context var0) {
      return ((TelephonyManager)var0.getSystemService("phone")).getNetworkOperatorName();
   }

   static Configuration getConfiguration(Context var0) {
      return var0.getResources().getConfiguration();
   }

   static String getConnectionType(Context var0) {
      ConnectivityManager var3 = (ConnectivityManager)var0.getSystemService("connectivity");
      if(var3 == null) {
         return "unknown";
      } else if(var3.getActiveNetworkInfo() != null && var3.getActiveNetworkInfo().isConnected()) {
         int var1 = var3.getActiveNetworkInfo().getType();
         int var2 = var3.getActiveNetworkInfo().getSubtype();
         if(var1 == 1) {
            return "wifi";
         } else if(var1 == 0) {
            switch(var2) {
            case 1:
               return "gprs";
            case 2:
               return "edge";
            case 3:
               return "umts";
            case 4:
               return "cdma";
            case 5:
               return "evdo_0";
            case 6:
               return "evdo_a";
            case 7:
               return "1xrtt";
            case 8:
               return "hsdpa";
            case 9:
               return "hsupa";
            case 10:
               return "hspa";
            case 11:
               return "iden";
            case 12:
               return "evdo_b";
            case 13:
               return "lte";
            case 14:
               return "ehrpd";
            case 15:
               return "hspap";
            default:
               return "unknown";
            }
         } else {
            return "unknown";
         }
      } else {
         return "offline";
      }
   }

   public static int getDefaultAdId() {
      synchronized(MMSDK.class) {
         int var0 = nextDefaultId + 1;
         nextDefaultId = var0;
         return var0;
      }
   }

   static float getDensity(Context var0) {
      return var0.getResources().getDisplayMetrics().density;
   }

   private static String getDensityString(Context var0) {
      return Float.toString(getDensity(var0));
   }

   static String getDpiHeight(Context var0) {
      return Integer.toString(var0.getResources().getDisplayMetrics().heightPixels);
   }

   static String getDpiWidth(Context var0) {
      return Integer.toString(var0.getResources().getDisplayMetrics().widthPixels);
   }

   static String getIpAddress(Context param0) {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public static int getLogLevel() {
      return MMLog.getLogLevel();
   }

   static String getMMdid(Context param0) {
      // $FF: Couldn't be decompiled
   }

   static String getMcc(Context var0) {
      Configuration var1 = getConfiguration(var0);
      if(var1.mcc == 0) {
         String var2 = getNetworkOperator(var0);
         if(var2 != null && var2.length() >= 6) {
            return var2.substring(0, 3);
         }
      }

      return String.valueOf(var1.mcc);
   }

   static int getMediaVolume(Context var0) {
      return ((AudioManager)var0.getApplicationContext().getSystemService("audio")).getStreamVolume(3);
   }

   static String getMnc(Context var0) {
      Configuration var1 = getConfiguration(var0);
      if(var1.mnc == 0) {
         String var2 = getNetworkOperator(var0);
         if(var2 != null && var2.length() >= 6) {
            return var2.substring(3);
         }
      }

      return String.valueOf(var1.mnc);
   }

   static String getNetworkOperator(Context var0) {
      return ((TelephonyManager)var0.getSystemService("phone")).getNetworkOperator();
   }

   static String getOrientation(Context var0) {
      switch(var0.getResources().getConfiguration().orientation) {
      case 1:
         return "portrait";
      case 2:
         return "landscape";
      case 3:
         return "square";
      default:
         return "default";
      }
   }

   static final String getOrientationLocked(Context var0) {
      return android.provider.Settings.System.getString(var0.getContentResolver(), "accelerometer_rotation").equals("1")?"false":"true";
   }

   static boolean getSupportsCalendar() {
      return VERSION.SDK_INT >= 14;
   }

   static String getSupportsSms(Context var0) {
      return String.valueOf(var0.getPackageManager().hasSystemFeature("android.hardware.telephony"));
   }

   static String getSupportsTel(Context var0) {
      return String.valueOf(var0.getPackageManager().hasSystemFeature("android.hardware.telephony"));
   }

   static boolean hasMicrophone(Context var0) {
      return var0.getPackageManager().hasSystemFeature("android.hardware.microphone");
   }

   static boolean hasRecordAudioPermission(Context var0) {
      return var0.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0;
   }

   static boolean hasSetTranslationMethod() {
      return Integer.parseInt(VERSION.SDK) >= 11;
   }

   private static String hasSpeechKit(Context var0) {
      return hasSpeechKit && hasRecordAudioPermission(var0)?"true":"false";
   }

   public static void initialize(Context var0) {
      HandShake var1 = HandShake.sharedHandShake(var0);
      var1.sendInitRequest();
      var1.startSession();
   }

   static void insertUrlCommonValues(Context param0, Map param1) {
      // $FF: Couldn't be decompiled
   }

   static boolean isCachedVideoSupportedOnDevice(Context var0) {
      return var0.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1 && (!VERSION.SDK.equalsIgnoreCase("8") || Environment.getExternalStorageState().equals("mounted") && AdCache.isExternalEnabled);
   }

   static boolean isConnected(Context var0) {
      ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");
      return var1 == null?false:var1.getActiveNetworkInfo() != null && var1.getActiveNetworkInfo().isConnected();
   }

   static boolean isUiThread() {
      return mainHandler.getLooper() == Looper.myLooper();
   }

   static void printDiagnostics(MMAdImpl var0) {
      if(var0 != null) {
         final Context var1 = var0.getContext();
         MMLog.i("MMSDK", String.format("MMAd External ID: %d", new Object[]{Integer.valueOf(var0.getId())}));
         MMLog.i("MMSDK", String.format("MMAd Internal ID: %d", new Object[]{Long.valueOf(var0.internalId)}));
         MMLog.i("MMSDK", String.format("APID: %s", new Object[]{var0.apid}));
         String var2;
         if(AdCache.isExternalStorageAvailable(var1)) {
            var2 = "";
         } else {
            var2 = "not ";
         }

         MMLog.i("MMSDK", String.format("SD card is %savailable.", new Object[]{var2}));
         if(var1 != null) {
            MMLog.i("MMSDK", String.format("Package: %s", new Object[]{var1.getPackageName()}));
            MMLog.i("MMSDK", String.format("MMDID: %s", new Object[]{getMMdid(var1)}));
            MMLog.i("MMSDK", "Permissions:");
            if(var1.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
               var2 = "not ";
            } else {
               var2 = "";
            }

            MMLog.i("MMSDK", String.format("android.permission.ACCESS_NETWORK_STATE is %spresent", new Object[]{var2}));
            if(var1.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
               var2 = "not ";
            } else {
               var2 = "";
            }

            MMLog.i("MMSDK", String.format("android.permission.INTERNET is %spresent", new Object[]{var2}));
            if(var1.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
               var2 = "not ";
            } else {
               var2 = "";
            }

            MMLog.i("MMSDK", String.format("android.permission.WRITE_EXTERNAL_STORAGE is %spresent", new Object[]{var2}));
            if(var1.checkCallingOrSelfPermission("android.permission.VIBRATE") == -1) {
               var2 = "not ";
            } else {
               var2 = "";
            }

            MMLog.i("MMSDK", String.format("android.permission.VIBRATE is %spresent", new Object[]{var2}));
            if(var1.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == -1) {
               var2 = "not ";
            } else {
               var2 = "";
            }

            MMLog.i("MMSDK", String.format("android.permission.ACCESS_COARSE_LOCATION is %spresent", new Object[]{var2}));
            if(var1.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1) {
               var2 = "not ";
            } else {
               var2 = "";
            }

            MMLog.i("MMSDK", String.format("android.permission.ACCESS_FINE_LOCATION is %spresent", new Object[]{var2}));
            MMLog.i("MMSDK", "Cached Ads:");
            AdCache.iterateCachedAds(var1, 2, new AdCache$Iterator() {
               final boolean callback(CachedAd var1x) {
                  String var3 = var1x.getTypeString();
                  String var4 = var1x.getId();
                  String var2;
                  if(var1x.isOnDisk(var1)) {
                     var2 = "";
                  } else {
                     var2 = "not ";
                  }

                  String var5;
                  if(var1x.isExpired()) {
                     var5 = "";
                  } else {
                     var5 = "not ";
                  }

                  MMLog.i("MMSDK", String.format("%s %s is %son disk. Is %sexpired.", new Object[]{var3, var4, var2, var5}));
                  return true;
               }
            });
            return;
         }
      }

   }

   static boolean removeAccelForJira1164() {
      return Integer.parseInt(VERSION.SDK) >= 14;
   }

   public static void resetCache(Context var0) {
      AdCache.resetCache(var0);
   }

   static void runOnUiThread(Runnable var0) {
      if(isUiThread()) {
         var0.run();
      } else {
         mainHandler.post(var0);
      }
   }

   static void runOnUiThreadDelayed(Runnable var0, long var1) {
      mainHandler.postDelayed(var0, var1);
   }

   public static void setBroadcastEvents(boolean var0) {
      isBroadcastingEvents = var0;
   }

   @Deprecated
   public static void setLogLevel(int var0) {
      switch(var0) {
      case 0:
         MMLog.setLogLevel(6);
         return;
      case 1:
         MMLog.setLogLevel(3);
         return;
      case 2:
         MMLog.setLogLevel(4);
         return;
      case 3:
         MMLog.setLogLevel(2);
         return;
      default:
         MMLog.setLogLevel(4);
      }
   }

   static void setMMdid(String var0) {
      synchronized(MMSDK.class){}

      try {
         getMMdidValue = var0;
      } finally {
         ;
      }

   }

   static boolean supportsFullScreenInline() {
      return Integer.parseInt(VERSION.SDK) >= 11;
   }

   public static void trackConversion(Context var0, String var1) {
      MMConversionTracker.trackConversion(var0, var1, (MMRequest)null);
   }

   public static void trackConversion(Context var0, String var1, MMRequest var2) {
      MMConversionTracker.trackConversion(var0, var1, var2);
   }

   public static void trackEvent(Context var0, String var1) {
      if(!TextUtils.isEmpty(var1)) {
         String var2 = getMMdid(var0);
         if(!TextUtils.isEmpty(var2)) {
            Utils$HttpUtils.executeUrl("http://ads.mp.mydas.mobi/pixel?id=" + var1 + "&mmdid=" + var2);
         }
      }

   }
}
