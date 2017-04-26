package com.mopub.common.logging;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

final class MoPubLog$MoPubLogHandler extends Handler {
   private static final Map LEVEL_TO_LOG;

   static {
      HashMap var0 = new HashMap(7);
      LEVEL_TO_LOG = var0;
      var0.put(Level.FINEST, Integer.valueOf(2));
      LEVEL_TO_LOG.put(Level.FINER, Integer.valueOf(2));
      LEVEL_TO_LOG.put(Level.FINE, Integer.valueOf(2));
      LEVEL_TO_LOG.put(Level.CONFIG, Integer.valueOf(3));
      LEVEL_TO_LOG.put(Level.INFO, Integer.valueOf(4));
      LEVEL_TO_LOG.put(Level.WARNING, Integer.valueOf(5));
      LEVEL_TO_LOG.put(Level.SEVERE, Integer.valueOf(6));
   }

   private MoPubLog$MoPubLogHandler() {
   }

   // $FF: synthetic method
   MoPubLog$MoPubLogHandler(MoPubLog$MoPubLogHandler var1) {
      this();
   }

   public final void close() {
   }

   public final void flush() {
   }

   public final void publish(LogRecord var1) {
      if(this.isLoggable(var1)) {
         int var2;
         if(LEVEL_TO_LOG.containsKey(var1.getLevel())) {
            var2 = ((Integer)LEVEL_TO_LOG.get(var1.getLevel())).intValue();
         } else {
            var2 = 2;
         }

         String var3 = var1.getMessage() + "\n";
         Throwable var4 = var1.getThrown();
         String var5 = var3;
         if(var4 != null) {
            var5 = var3 + Log.getStackTraceString(var4);
         }

         Log.println(var2, "MoPub", var5);
      }

   }
}
