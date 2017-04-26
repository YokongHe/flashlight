package com.amazon.device.ads;

import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.ILog;
import com.amazon.device.ads.Log$LogcatLogger;
import com.amazon.device.ads.Version;
import java.util.ArrayList;

class Log {
   protected static final String LOGTAG = "AmazonMobileAds ";
   private static ILog logger = new Log$LogcatLogger(null);
   private static boolean loggingEnabled_ = false;

   public static boolean canLog() {
      return logger == null?false:DebugProperties.getDebugPropertyAsBoolean("debug.logging", loggingEnabled_);
   }

   public static void d(String var0, String var1) {
      d(false, var0, var1);
   }

   public static void d(String var0, String var1, Object... var2) {
      d(false, var0, var1, var2);
   }

   public static void d(boolean var0, String var1, String var2) {
      if(canLog() || var0) {
         logger.d("AmazonMobileAds " + var1, var2);
      }

   }

   public static void d(boolean var0, String var1, String var2, Object... var3) {
      if(canLog() || var0) {
         logger.d("AmazonMobileAds " + var1, var2, var3);
      }

   }

   public static void e(String var0, String var1) {
      e(false, var0, var1);
   }

   public static void e(String var0, String var1, Object... var2) {
      e(false, var0, var1, var2);
   }

   public static void e(boolean var0, String var1, String var2) {
      if(canLog() || var0) {
         logger.e("AmazonMobileAds " + var1, var2);
      }

   }

   public static void e(boolean var0, String var1, String var2, Object... var3) {
      if(canLog() || var0) {
         logger.e("AmazonMobileAds " + var1, var2, var3);
      }

   }

   public static void enableLogging(boolean var0) {
      loggingEnabled_ = var0;
   }

   public static final void enableLoggingWithSetterNotification(String var0, boolean var1) {
      if(!var1) {
         logSetterNotification(var0, "Debug logging", Boolean.valueOf(var1));
      }

      loggingEnabled_ = var1;
      if(var1) {
         logSetterNotification(var0, "Debug logging", Boolean.valueOf(var1));
         d(false, var0, "Amazon Mobile Ads API Version: %s", new Object[]{Version.getRawSDKVersion()});
      }

   }

   public static ILog getLogger() {
      return logger;
   }

   public static void i(String var0, String var1) {
      i(false, var0, var1);
   }

   public static void i(String var0, String var1, Object... var2) {
      i(false, var0, var1, var2);
   }

   public static void i(boolean var0, String var1, String var2) {
      if(canLog() || var0) {
         logger.i("AmazonMobileAds " + var1, var2);
      }

   }

   public static void i(boolean var0, String var1, String var2, Object... var3) {
      if(canLog() || var0) {
         logger.i("AmazonMobileAds " + var1, var2, var3);
      }

   }

   public static final void logSetterNotification(String var0, String var1, Object var2) {
      if(canLog()) {
         if(var2 instanceof Boolean) {
            String var3;
            if(((Boolean)var2).booleanValue()) {
               var3 = "enabled";
            } else {
               var3 = "disabled";
            }

            d(false, var0, "%s has been %s.", new Object[]{var1, var3});
         } else {
            d(false, var0, "%s has been set: %s", new Object[]{var1, String.valueOf(var2)});
         }
      }
   }

   public static void setLogger(ILog var0) {
      logger = var0;
   }

   static Iterable split(String var0, int var1) {
      ArrayList var3 = new ArrayList();
      if(var0 != null && var0.length() != 0) {
         for(int var2 = 0; var2 < var0.length(); var2 += var1) {
            var3.add(var0.substring(var2, Math.min(var0.length(), var2 + var1)));
         }

         return var3;
      } else {
         return var3;
      }
   }

   public static void v(String var0, String var1) {
      v(false, var0, var1);
   }

   public static void v(String var0, String var1, Object... var2) {
      v(false, var0, var1, var2);
   }

   public static void v(boolean var0, String var1, String var2) {
      if(canLog() || var0) {
         logger.v("AmazonMobileAds " + var1, var2);
      }

   }

   public static void v(boolean var0, String var1, String var2, Object... var3) {
      if(canLog() || var0) {
         logger.v("AmazonMobileAds " + var1, var2, var3);
      }

   }

   public static void w(String var0, String var1) {
      w(false, var0, var1);
   }

   public static void w(String var0, String var1, Object... var2) {
      w(false, var0, var1, var2);
   }

   public static void w(boolean var0, String var1, String var2) {
      if(canLog() || var0) {
         logger.w("AmazonMobileAds " + var1, var2);
      }

   }

   public static void w(boolean var0, String var1, String var2, Object... var3) {
      if(canLog() || var0) {
         logger.w("AmazonMobileAds " + var1, var2, var3);
      }

   }
}
