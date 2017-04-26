package org.nexage.sourcekit.util;

import android.util.Log;
import org.nexage.sourcekit.util.VASTLog$LOG_LEVEL;

public class VASTLog {
   private static VASTLog$LOG_LEVEL LEVEL;
   private static String TAG = "VAST";

   static {
      LEVEL = VASTLog$LOG_LEVEL.error;
   }

   public static void d(String var0, String var1) {
      if(LEVEL.getValue() <= VASTLog$LOG_LEVEL.debug.getValue()) {
         Log.d(var0, var1);
      }

   }

   public static void e(String var0, String var1) {
      if(LEVEL.getValue() <= VASTLog$LOG_LEVEL.error.getValue()) {
         Log.e(var0, var1);
      }

   }

   public static void e(String var0, String var1, Throwable var2) {
      if(LEVEL.getValue() <= VASTLog$LOG_LEVEL.error.getValue()) {
         Log.e(var0, var1, var2);
      }

   }

   public static VASTLog$LOG_LEVEL getLoggingLevel() {
      return LEVEL;
   }

   public static void i(String var0, String var1) {
      if(LEVEL.getValue() <= VASTLog$LOG_LEVEL.info.getValue()) {
         Log.i(var0, var1);
      }

   }

   public static void setLoggingLevel(VASTLog$LOG_LEVEL var0) {
      Log.i(TAG, "Changing logging level from :" + LEVEL + ". To:" + var0);
      LEVEL = var0;
   }

   public static void v(String var0, String var1) {
      if(LEVEL.getValue() <= VASTLog$LOG_LEVEL.verbose.getValue()) {
         Log.v(var0, var1);
      }

   }

   public static void w(String var0, String var1) {
      if(LEVEL.getValue() <= VASTLog$LOG_LEVEL.warning.getValue()) {
         Log.w(var0, var1);
      }

   }
}
