package com.mopub.common.logging;

import com.mopub.common.logging.MoPubLog$MoPubLogHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MoPubLog {
   private static final Logger LOGGER = Logger.getLogger("com.mopub");
   private static final String LOGTAG = "MoPub";
   private static final MoPubLog$MoPubLogHandler LOG_HANDLER = new MoPubLog$MoPubLogHandler((MoPubLog$MoPubLogHandler)null);

   static {
      LogManager.getLogManager().addLogger(LOGGER);
      LOGGER.addHandler(LOG_HANDLER);
      LOGGER.setLevel(Level.FINE);
   }

   public static void c(String var0) {
      c(var0, (Throwable)null);
   }

   public static void c(String var0, Throwable var1) {
      LOGGER.log(Level.FINEST, var0, var1);
   }

   public static void d(String var0) {
      d(var0, (Throwable)null);
   }

   public static void d(String var0, Throwable var1) {
      LOGGER.log(Level.CONFIG, var0, var1);
   }

   public static void e(String var0) {
      e(var0, (Throwable)null);
   }

   public static void e(String var0, Throwable var1) {
      LOGGER.log(Level.SEVERE, var0, var1);
   }

   public static void i(String var0) {
      i(var0, (Throwable)null);
   }

   public static void i(String var0, Throwable var1) {
      LOGGER.log(Level.INFO, var0, var1);
   }

   public static void v(String var0) {
      v(var0, (Throwable)null);
   }

   public static void v(String var0, Throwable var1) {
      LOGGER.log(Level.FINE, var0, var1);
   }

   public static void w(String var0) {
      w(var0, (Throwable)null);
   }

   public static void w(String var0, Throwable var1) {
      LOGGER.log(Level.WARNING, var0, var1);
   }
}
