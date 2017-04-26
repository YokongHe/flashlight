package com.mopub.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils$IP;
import com.mopub.common.util.Reflection$MethodBuilder;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

public class DeviceUtils {
   private static final int MAX_DISK_CACHE_SIZE = 104857600;
   private static final int MAX_MEMORY_CACHE_SIZE = 31457280;
   private static final int MIN_DISK_CACHE_SIZE = 31457280;

   public static long diskCacheSizeBytes(File var0) {
      return diskCacheSizeBytes(var0, 31457280L);
   }

   public static long diskCacheSizeBytes(File var0, long var1) {
      long var3;
      try {
         StatFs var6 = new StatFs(var0.getAbsolutePath());
         var3 = (long)var6.getBlockCount();
         var3 = (long)var6.getBlockSize() * var3 / 50L;
      } catch (IllegalArgumentException var5) {
         MoPubLog.d("Unable to calculate 2% of available disk space, defaulting to minimum");
         return Math.max(Math.min(var1, 104857600L), 31457280L);
      }

      var1 = var3;
      return Math.max(Math.min(var1, 104857600L), 31457280L);
   }

   public static String getHashedUdid(Context var0) {
      return var0 == null?null:Utils.sha1(Secure.getString(var0.getContentResolver(), "android_id"));
   }

   public static String getIpAddress(DeviceUtils$IP var0) {
      Iterator var1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();

      while(var1.hasNext()) {
         Iterator var2 = Collections.list(((NetworkInterface)var1.next()).getInetAddresses()).iterator();

         while(var2.hasNext()) {
            InetAddress var3 = (InetAddress)var2.next();
            if(!var3.isLoopbackAddress()) {
               String var4 = var3.getHostAddress().toUpperCase(Locale.US);
               if(DeviceUtils$IP.access$3(var0, var4)) {
                  return DeviceUtils$IP.access$4(var0, var4);
               }
            }
         }
      }

      return null;
   }

   public static int getScreenOrientation(Activity var0) {
      int var2 = var0.getWindowManager().getDefaultDisplay().getRotation();
      DisplayMetrics var4 = new DisplayMetrics();
      var0.getWindowManager().getDefaultDisplay().getMetrics(var4);
      int var1 = var4.widthPixels;
      int var3 = var4.heightPixels;
      boolean var5;
      if((var2 == 0 || var2 == 2) && var3 > var1 || (var2 == 1 || var2 == 3) && var1 > var3) {
         var5 = true;
      } else {
         var5 = false;
      }

      if(var5) {
         switch(var2) {
         case 0:
            break;
         case 1:
            return 0;
         case 2:
            return 9;
         case 3:
            return 8;
         default:
            MoPubLog.d("Unknown screen orientation. Defaulting to portrait.");
         }
      } else {
         switch(var2) {
         case 0:
            return 0;
         case 1:
            break;
         case 2:
            return 8;
         case 3:
            return 9;
         default:
            MoPubLog.d("Unknown screen orientation. Defaulting to landscape.");
            return 0;
         }
      }

      return 1;
   }

   public static boolean isNetworkAvailable(Context var0) {
      if(var0 == null) {
         return false;
      } else if(var0.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
         return false;
      } else if(var0.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
         return true;
      } else {
         try {
            boolean var1 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
            return var1;
         } catch (NullPointerException var2) {
            return false;
         }
      }
   }

   public static int memoryCacheSizeBytes(Context var0) {
      ActivityManager var4 = (ActivityManager)var0.getSystemService("activity");
      long var2 = (long)var4.getMemoryClass();
      if(VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {
         int var1;
         try {
            var1 = ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt((Object)null);
            if(!Utils.bitMaskContainsFlag(var0.getApplicationInfo().flags, var1)) {
               return (int)Math.min(31457280L, var2 / 8L * 1024L * 1024L);
            }

            var1 = ((Integer)(new Reflection$MethodBuilder(var4, "getLargeMemoryClass")).execute()).intValue();
         } catch (Exception var5) {
            MoPubLog.d("Unable to reflectively determine large heap size on Honeycomb and above.");
            return (int)Math.min(31457280L, var2 / 8L * 1024L * 1024L);
         }

         var2 = (long)var1;
      }

      return (int)Math.min(31457280L, var2 / 8L * 1024L * 1024L);
   }
}
