package com.adsdk.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import com.adsdk.sdk.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;

public class Util {
   private static final float MINIMAL_ACCURACY = 1000.0F;
   private static final long MINIMAL_TIME_FROM_FIX = 1200000L;
   private static boolean adDoNotTrack = false;
   private static String androidAdId;

   @SuppressLint({"DefaultLocale"})
   public static String buildUserAgent() {
      String var2 = VERSION.RELEASE;
      String var3 = Build.MODEL;
      String var4 = Build.ID;
      Locale var5 = Locale.getDefault();
      String var1 = var5.getLanguage();
      String var0 = "en";
      if(var1 != null) {
         var1 = var1.toLowerCase();
         String var6 = var5.getCountry();
         var0 = var1;
         if(var6 != null) {
            var0 = var1 + "-" + var6.toLowerCase();
         }
      }

      return String.format("Mozilla/5.0 (Linux; U; Android %1$s; %2$s; %3$s Build/%4$s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", new Object[]{var2, var0, var3, var4});
   }

   public static String getAndroidAdId() {
      return androidAdId == null?"":androidAdId;
   }

   public static String getConnectionType(Context var0) {
      if(var0.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
         NetworkInfo var3 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
         if(var3 == null) {
            return "UNKNOWN";
         } else {
            int var1 = var3.getType();
            int var2 = var3.getSubtype();
            if(var1 == 1) {
               return "WIFI";
            } else if(var1 == 6) {
               return "WIMAX";
            } else if(var1 == 0) {
               switch(var2) {
               case 1:
                  return "GPRS";
               case 2:
                  return "EDGE";
               case 3:
                  return "UMTS";
               case 4:
                  return "CDMA";
               case 5:
                  return "EVDO_0";
               case 6:
                  return "EVDO_A";
               case 7:
                  return "1xRTT";
               case 8:
                  return "HSDPA";
               case 9:
                  return "HSUPA";
               case 10:
                  return "HSPA";
               case 11:
                  return "IDEN";
               case 12:
                  return "EVDO_B";
               case 13:
                  return "LTE";
               case 14:
                  return "EHRPD";
               case 15:
                  return "HSPAP";
               default:
                  return "MOBILE";
               }
            } else {
               return "UNKNOWN";
            }
         }
      } else {
         return "UNKNOWN";
      }
   }

   public static String getDefaultUserAgentString(Context var0) {
      return System.getProperty("http.agent");
   }

   public static String getLocalIpAddress() {
      try {
         Enumeration var0 = NetworkInterface.getNetworkInterfaces();

         while(var0.hasMoreElements()) {
            Enumeration var1 = ((NetworkInterface)var0.nextElement()).getInetAddresses();

            while(var1.hasMoreElements()) {
               InetAddress var2 = (InetAddress)var1.nextElement();
               if(!var2.isLoopbackAddress()) {
                  String var4 = var2.getHostAddress().toString();
                  return var4;
               }
            }
         }
      } catch (SocketException var3) {
         Log.e(var3.toString());
      }

      return null;
   }

   public static Location getLocation(Context var0) {
      boolean var1 = false;
      boolean var2;
      if(var0.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
         var1 = true;
         var2 = true;
      } else if(var0.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
         var2 = false;
         var1 = true;
      } else {
         var2 = false;
      }

      LocationManager var6 = (LocationManager)var0.getSystemService("location");
      long var3;
      Location var7;
      if(var6 != null && var2 && var6.isProviderEnabled("gps")) {
         Location var5 = var6.getLastKnownLocation("gps");
         if(var5 == null) {
            var7 = null;
            return var7;
         }

         var3 = Math.abs(System.currentTimeMillis() - var5.getTime());
         if(var5.hasAccuracy() && var5.getAccuracy() < 1000.0F && var3 < 1200000L) {
            return var5;
         }
      }

      if(var6 == null || !var1 || !var6.isProviderEnabled("network")) {
         return null;
      } else {
         var7 = var6.getLastKnownLocation("network");
         if(var7 == null) {
            return null;
         } else {
            var3 = Math.abs(System.currentTimeMillis() - var7.getTime());
            if(!var7.hasAccuracy() || var7.getAccuracy() >= 1000.0F || var3 >= 1200000L) {
               return null;
            } else {
               return var7;
            }
         }
      }
   }

   public static int getMemoryClass(Context var0) {
      try {
         int var1 = ((Integer)ActivityManager.class.getMethod("getMemoryClass", new Class[0]).invoke((ActivityManager)var0.getSystemService("activity"), new Object[0])).intValue();
         return var1;
      } catch (Exception var2) {
         return 16;
      }
   }

   public static boolean hasAdDoNotTrack() {
      return adDoNotTrack;
   }

   public static boolean isNetworkAvailable(Context var0) {
      if(var0.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
         NetworkInfo var2 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
         if(var2 == null) {
            return false;
         } else {
            int var1 = var2.getType();
            return var1 != 1 && var1 != 0?false:var2.isConnected();
         }
      } else {
         return true;
      }
   }

   public static Bitmap loadBitmap(String var0) {
      try {
         Bitmap var2 = BitmapFactory.decodeStream((new URL(var0)).openStream());
         return var2;
      } catch (Throwable var1) {
         Log.e("Decoding bitmap failed!");
         return null;
      }
   }

   public static void prepareAndroidAdId(final Context var0) {
      try {
         Class.forName("com.google.android.gms.common.g");
      } catch (ClassNotFoundException var1) {
         return;
      }

      if(androidAdId == null && com.google.android.gms.common.g.a(var0) == 0) {
         (new AsyncTask() {
            protected Void doInBackground(Void... var1) {
               try {
                  AdvertisingIdClient$Info var7 = AdvertisingIdClient.getAdvertisingIdInfo(var0);
                  Util.androidAdId = var7.getId();
                  var7.isLimitAdTrackingEnabled();
                  Util.adDoNotTrack = var7.isLimitAdTrackingEnabled();
               } catch (IOException var2) {
                  var2.printStackTrace();
               } catch (com.google.android.gms.common.e var3) {
                  var3.printStackTrace();
               } catch (IllegalStateException var4) {
                  var4.printStackTrace();
               } catch (com.google.android.gms.common.f var5) {
                  var5.printStackTrace();
               } catch (Exception var6) {
                  var6.printStackTrace();
               }

               return null;
            }
         }).execute(new Void[0]);
      }

   }
}
