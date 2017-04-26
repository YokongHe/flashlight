package com.millennialmedia.android;

import com.millennialmedia.android.ComponentRegistry;
import com.millennialmedia.android.MMLog$LogHandler;
import com.millennialmedia.android.MMLog$LoggingComponent;

public class MMLog {
   static {
      ComponentRegistry.addLoggingComponent(new MMLog$LoggingComponent());
   }

   static void d(String var0, String var1) {
      ComponentRegistry.getLoggingComponent().d(var0, var1);
   }

   static void d(String var0, String var1, Throwable var2) {
      ComponentRegistry.getLoggingComponent().d(var0, var1, var2);
   }

   static void e(String var0, String var1) {
      ComponentRegistry.getLoggingComponent().e(var0, var1);
   }

   static void e(String var0, String var1, Throwable var2) {
      ComponentRegistry.getLoggingComponent().e(var0, var1, var2);
   }

   public static int getLogLevel() {
      return ComponentRegistry.getLoggingComponent().getLogLevel();
   }

   static void i(String var0, String var1) {
      ComponentRegistry.getLoggingComponent().i(var0, var1);
   }

   static void i(String var0, String var1, Throwable var2) {
      ComponentRegistry.getLoggingComponent().i(var0, var1, var2);
   }

   static void registerLogHandler(MMLog$LogHandler var0) {
      ComponentRegistry.getLoggingComponent().registerLogHandler(var0);
   }

   public static void setLogLevel(int var0) {
      ComponentRegistry.getLoggingComponent().setLogLevel(var0);
   }

   static void v(String var0, String var1) {
      ComponentRegistry.getLoggingComponent().v(var0, var1);
   }

   static void v(String var0, String var1, Throwable var2) {
      ComponentRegistry.getLoggingComponent().v(var0, var1, var2);
   }

   static void w(String var0, String var1) {
      ComponentRegistry.getLoggingComponent().w(var0, var1);
   }

   static void w(String var0, String var1, Throwable var2) {
      ComponentRegistry.getLoggingComponent().w(var0, var1, var2);
   }
}
