package org.nexage.sourcekit.mraid.internal;

import android.util.Log;
import org.nexage.sourcekit.mraid.internal.MRAIDLog$LOG_LEVEL;

public class MRAIDLog {
   private static MRAIDLog$LOG_LEVEL LEVEL;
   private static final String TAG = "MRAID";

   static {
      LEVEL = MRAIDLog$LOG_LEVEL.error;
   }

   public static void d(String var0) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.debug.getValue()) {
         Log.d("MRAID", var0);
      }

   }

   public static void d(String var0, String var1) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.debug.getValue()) {
         Log.d("MRAID", "[" + var0 + "] " + var1);
      }

   }

   public static void e(String var0) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.error.getValue()) {
         Log.e("MRAID", var0);
      }

   }

   public static void e(String var0, String var1) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.error.getValue()) {
         Log.e("MRAID", "[" + var0 + "] " + var1);
      }

   }

   public static MRAIDLog$LOG_LEVEL getLoggingLevel() {
      return LEVEL;
   }

   public static void i(String var0) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.info.getValue()) {
         Log.i("MRAID", var0);
      }

   }

   public static void i(String var0, String var1) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.info.getValue()) {
         Log.i("MRAID", "[" + var0 + "] " + var1);
      }

   }

   public static void setLoggingLevel(MRAIDLog$LOG_LEVEL var0) {
      Log.i("MRAID", "Changing logging level from :" + LEVEL + ". To:" + var0);
      LEVEL = var0;
   }

   public static void v(String var0) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.verbose.getValue()) {
         Log.v("MRAID", var0);
      }

   }

   public static void v(String var0, String var1) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.verbose.getValue()) {
         Log.v("MRAID", "[" + var0 + "] " + var1);
      }

   }

   public static void w(String var0) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.warning.getValue()) {
         Log.w("MRAID", var0);
      }

   }

   public static void w(String var0, String var1) {
      if(LEVEL.getValue() <= MRAIDLog$LOG_LEVEL.warning.getValue()) {
         Log.w("MRAID", "[" + var0 + "] " + var1);
      }

   }
}
