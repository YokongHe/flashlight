package com.smaato.soma.debug;

import android.util.Log;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.LogMessage;

public class Debugger {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$debug$DebugCategory;
   public static int DEBUG_LEVEL = 1;
   public static final int Level_0 = 0;
   public static final int Level_1 = 1;
   public static final int Level_2 = 2;
   public static final int Level_3 = 3;
   private static String SDK_TAG = "SOMA_";

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$smaato$soma$debug$DebugCategory() {
      int[] var0 = $SWITCH_TABLE$com$smaato$soma$debug$DebugCategory;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[DebugCategory.values().length];

         try {
            var0[DebugCategory.DEBUG.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            var0[DebugCategory.ERROR.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[DebugCategory.EXCEPTION.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[DebugCategory.INFO.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[DebugCategory.VERVOSE.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[DebugCategory.WARNING.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$debug$DebugCategory = var0;
         return var0;
      }
   }

   public static void methodStart(final Object var0) {
      if(DEBUG_LEVEL == 3) {
         (new CrashReportTemplate() {
            public Void process() {
               Log.d(Debugger.SDK_TAG + var0.getClass(), var0.getClass().getEnclosingMethod().getName());
               return null;
            }
         }).execute();
      }

   }

   public static final void setDebugMode(int var0) {
      if(var0 <= 3 && var0 >= 0) {
         DEBUG_LEVEL = var0;
      } else {
         showLog(new LogMessage("DEBUGGER", "Value out of range, ignoring value", DEBUG_LEVEL, DebugCategory.WARNING));
      }
   }

   public static final void showLog(LogMessage var0) {
      if(var0.getLevel() <= DEBUG_LEVEL) {
         viewLog(var0);
      }

   }

   private static void viewLog(LogMessage var0) {
      switch($SWITCH_TABLE$com$smaato$soma$debug$DebugCategory()[var0.getCategory().ordinal()]) {
      case 1:
         Log.d(SDK_TAG + var0.getTag(), var0.getMsg());
         return;
      case 2:
         Log.e(SDK_TAG + var0.getTag(), var0.getMsg());
         return;
      case 3:
         Log.i(SDK_TAG + var0.getTag(), var0.getMsg());
         return;
      case 4:
         Log.v(SDK_TAG + var0.getTag(), var0.getMsg());
         return;
      case 5:
         Log.w(SDK_TAG + var0.getTag(), var0.getMsg());
         return;
      case 6:
         Log.e(SDK_TAG + var0.getTag(), "", var0.getException());
         return;
      default:
         Log.w(SDK_TAG + "DEBUG", "Should not happen !!");
      }
   }
}
