package com.inmobi.commons.internal;

import com.inmobi.commons.internal.CommonsConfig;
import com.inmobi.commons.internal.Log$INTERNAL_LOG_LEVEL;
import com.inmobi.commons.thinICE.icedatacollector.BuildSettings;

public class Log {
   private static Log$INTERNAL_LOG_LEVEL a;

   static {
      a = Log$INTERNAL_LOG_LEVEL.NOT_SET;
   }

   public static void debug(String var0, String var1) {
      if(a.getValue() >= Log$INTERNAL_LOG_LEVEL.DEBUG.getValue() || a == Log$INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= Log$INTERNAL_LOG_LEVEL.DEBUG.getValue()) {
         android.util.Log.d(var0, var1);
      }

   }

   public static void debug(String var0, String var1, Throwable var2) {
      switch(null.a[a.ordinal()]) {
      case 1:
         debug(var0, var1);
         return;
      case 2:
         internal(var0, var1, var2);
         return;
      default:
      }
   }

   public static Log$INTERNAL_LOG_LEVEL getLogLevel() {
      return a;
   }

   public static Log$INTERNAL_LOG_LEVEL getLogLevelValue(long var0) {
      return var0 == 2L?Log$INTERNAL_LOG_LEVEL.INTERNAL:(var0 == 1L?Log$INTERNAL_LOG_LEVEL.DEBUG:Log$INTERNAL_LOG_LEVEL.NONE);
   }

   public static void internal(String var0, String var1) {
      if(a.getValue() >= Log$INTERNAL_LOG_LEVEL.INTERNAL.getValue() || a == Log$INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= Log$INTERNAL_LOG_LEVEL.INTERNAL.getValue()) {
         StackTraceElement var2 = (new Throwable()).getStackTrace()[1];
         android.util.Log.v(var0, var2.getFileName() + ": " + var2.getMethodName() + " " + var1);
      }

   }

   public static void internal(String var0, String var1, Throwable var2) {
      if(a.getValue() >= Log$INTERNAL_LOG_LEVEL.INTERNAL.getValue() || a == Log$INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= Log$INTERNAL_LOG_LEVEL.INTERNAL.getValue()) {
         StackTraceElement var3 = (new Throwable()).getStackTrace()[1];
         android.util.Log.e(var0, var3.getFileName() + ": " + var3.getMethodName() + " " + var1, var2);
      }

   }

   public static void setInternalLogLevel(Log$INTERNAL_LOG_LEVEL var0) {
      a = var0;
      if(var0 == Log$INTERNAL_LOG_LEVEL.INTERNAL) {
         BuildSettings.DEBUG = true;
      }

   }

   public static void verbose(String var0, String var1) {
      if(a.getValue() >= Log$INTERNAL_LOG_LEVEL.VERBOSE.getValue() || a == Log$INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= Log$INTERNAL_LOG_LEVEL.VERBOSE.getValue()) {
         android.util.Log.i(var0, var1);
      }

   }

   public static void verbose(String var0, String var1, Throwable var2) {
      switch(null.a[a.ordinal()]) {
      case 1:
      case 3:
         verbose(var0, var1);
         return;
      case 2:
         internal(var0, var1, var2);
         return;
      default:
      }
   }
}
