package com.inmobi.commons.thinICE.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class WifiUtil {
   private static final String[] a = new String[]{"android.permission.ACCESS_WIFI_STATE"};
   private static final String[] b = new String[]{"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"};
   private static final String[] c = new String[]{"android.permission.WAKE_LOCK"};

   private static long a(byte var0) {
      return (long)var0 & 255L;
   }

   private static long a(byte[] var0) {
      long var3 = 0L;
      long var1 = var3;
      if(var0 != null) {
         var1 = var3;
         if(var0.length == 6) {
            var1 = a(var0[5]) | a(var0[4]) << 8 | a(var0[3]) << 16 | a(var0[2]) << 24 | a(var0[1]) << 32 | a(var0[0]) << 40;
         }
      }

      return var1;
   }

   private static boolean a(boolean var0, String var1) {
      return var0 && var1 != null && var1.endsWith("_nomap");
   }

   public static WifiInfo getConnectedWifiInfo(Context var0) {
      int var1 = IceDataCollector.getConfig().getWifiFlags();
      boolean var2;
      if(!ThinICEConfigSettings.bitTest(var1, 2)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return getConnectedWifiInfo(var0, var2, ThinICEConfigSettings.bitTest(var1, 1));
   }

   public static WifiInfo getConnectedWifiInfo(Context var0, boolean var1, boolean var2) {
      android.net.wifi.WifiInfo var3 = ((WifiManager)var0.getSystemService("wifi")).getConnectionInfo();
      if(var3 != null) {
         WifiInfo var4 = new WifiInfo();
         String var5 = var3.getBSSID();
         String var6 = var3.getSSID();
         if(var5 != null && !a(var1, var6)) {
            var4.bssid = macToLong(var5);
            if(var2) {
               var6 = null;
            }

            var4.ssid = var6;
            var4.rssi = var3.getRssi();
            var4.ip = var3.getIpAddress();
            return var4;
         }
      }

      return null;
   }

   public static boolean hasGetConnectedWifiInfoPermission(Context var0) {
      String[] var3 = a;
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         if(var0.checkCallingOrSelfPermission(var3[var1]) != 0) {
            return false;
         }
      }

      return true;
   }

   public static boolean hasWifiScanPermission(Context var0, boolean var1) {
      String[] var4 = b;
      int var3 = var4.length;
      int var2 = 0;

      while(true) {
         if(var2 < var3) {
            if(var0.checkCallingOrSelfPermission(var4[var2]) == 0) {
               ++var2;
               continue;
            }

            return false;
         }

         if(var1) {
            var4 = c;
            var3 = var4.length;

            for(var2 = 0; var2 < var3; ++var2) {
               if(var0.checkCallingOrSelfPermission(var4[var2]) != 0) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public static long macToLong(String var0) {
      String[] var3 = var0.split("\\:");
      byte[] var2 = new byte[6];

      for(int var1 = 0; var1 < 6; ++var1) {
         var2[var1] = (byte)Integer.parseInt(var3[var1], 16);
      }

      return a(var2);
   }

   public static WifiInfo scanResultToWifiInfo(ScanResult var0, boolean var1) {
      String var2 = null;
      if(var0 == null) {
         return null;
      } else {
         WifiInfo var3 = new WifiInfo();
         var3.bssid = macToLong(var0.BSSID);
         if(!var1) {
            var2 = var0.SSID;
         }

         var3.ssid = var2;
         var3.rssi = var0.level;
         return var3;
      }
   }

   public static List scanResultsToWifiInfos(List var0, boolean var1, boolean var2) {
      if(var0 == null) {
         return null;
      } else {
         ArrayList var3 = new ArrayList();
         Iterator var5 = var0.iterator();

         while(var5.hasNext()) {
            ScanResult var4 = (ScanResult)var5.next();
            if(!a(var1, var4.SSID)) {
               var3.add(scanResultToWifiInfo(var4, var2));
            }
         }

         return var3;
      }
   }
}
