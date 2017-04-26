package com.millennialmedia.android;

import android.util.Log;
import com.millennialmedia.android.MMLog$LogHandler;

class MMLog$LoggingComponent {
   private static final String TAG_STARTER = "MMSDK-";
   private static int logLevel = 4;
   private MMLog$LogHandler registeredLogHandler;

   private void callLogHandler(String var1) {
      if(this.registeredLogHandler != null) {
         this.registeredLogHandler.handleLog(var1);
      }

   }

   private void dInternal(String var1, String var2) {
      Log.d("MMSDK-" + var1, var2);
      this.callLogHandler(var2);
   }

   private void eInternal(String var1, String var2) {
      Log.e("MMSDK-" + var1, var2);
      this.callLogHandler(var2);
   }

   private void iInternal(String var1, String var2) {
      Log.i("MMSDK-" + var1, var2);
      this.callLogHandler(var2);
   }

   private void vInternal(String var1, String var2) {
      Log.v("MMSDK-" + var1, var2);
      this.callLogHandler(var2);
   }

   private void wInternal(String var1, String var2) {
      Log.w("MMSDK-" + var1, var2);
      this.callLogHandler(var2);
   }

   void d(String var1, String var2) {
      if(logLevel <= 3) {
         this.dInternal(var1, var2);
      }

   }

   void d(String var1, String var2, Throwable var3) {
      if(logLevel <= 3) {
         this.dInternal(var1, var2 + ": " + Log.getStackTraceString(var3));
      }

   }

   void e(String var1, String var2) {
      if(logLevel <= 6) {
         this.eInternal(var1, var2);
      }

   }

   void e(String var1, String var2, Throwable var3) {
      if(logLevel <= 6) {
         this.eInternal(var1, var2 + ": " + Log.getStackTraceString(var3));
      }

   }

   public int getLogLevel() {
      return logLevel;
   }

   void i(String var1, String var2) {
      if(logLevel <= 4) {
         this.iInternal(var1, var2);
      }

   }

   void i(String var1, String var2, Throwable var3) {
      if(logLevel <= 4) {
         this.iInternal(var1, var2 + ": " + Log.getStackTraceString(var3));
      }

   }

   void registerLogHandler(MMLog$LogHandler var1) {
      this.registeredLogHandler = var1;
   }

   public void setLogLevel(int var1) {
      logLevel = var1;
   }

   void v(String var1, String var2) {
      if(logLevel <= 2) {
         this.vInternal(var1, var2);
      }

   }

   void v(String var1, String var2, Throwable var3) {
      if(logLevel <= 2) {
         this.vInternal(var1, var2 + ": " + Log.getStackTraceString(var3));
      }

   }

   void w(String var1, String var2) {
      if(logLevel <= 5) {
         this.wInternal(var1, var2);
      }

   }

   void w(String var1, String var2, Throwable var3) {
      if(logLevel <= 5) {
         this.wInternal(var1, var2 + ": " + Log.getStackTraceString(var3));
      }

   }
}
