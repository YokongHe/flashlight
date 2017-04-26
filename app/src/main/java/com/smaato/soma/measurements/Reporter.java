package com.smaato.soma.measurements;

import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.measurements.FraudesType;

public class Reporter {
   private static String TAG = "Reporter";
   private static Reporter instance;

   public static Reporter getInstance() {
      if(instance == null) {
         instance = new Reporter();
      }

      return instance;
   }

   public void report(final FraudesType var1) {
      (new CrashReportTemplate() {
         // $FF: synthetic field
         private static int[] $SWITCH_TABLE$com$smaato$soma$measurements$FraudesType;

         // $FF: synthetic method
         static int[] $SWITCH_TABLE$com$smaato$soma$measurements$FraudesType() {
            int[] var0 = $SWITCH_TABLE$com$smaato$soma$measurements$FraudesType;
            if(var0 != null) {
               return var0;
            } else {
               var0 = new int[FraudesType.values().length];

               try {
                  var0[FraudesType.AUTO_CLICK.ordinal()] = 2;
               } catch (NoSuchFieldError var6) {
                  ;
               }

               try {
                  var0[FraudesType.BANNER_DIMENSION.ordinal()] = 4;
               } catch (NoSuchFieldError var5) {
                  ;
               }

               try {
                  var0[FraudesType.BANNER_OFF_SCREEN.ordinal()] = 3;
               } catch (NoSuchFieldError var4) {
                  ;
               }

               try {
                  var0[FraudesType.BANNER_OVERLAP.ordinal()] = 5;
               } catch (NoSuchFieldError var3) {
                  ;
               }

               try {
                  var0[FraudesType.UBER_FREQUENT_REQUEST.ordinal()] = 1;
               } catch (NoSuchFieldError var2) {
                  ;
               }

               $SWITCH_TABLE$com$smaato$soma$measurements$FraudesType = var0;
               return var0;
            }
         }

         public Void process() {
            switch($SWITCH_TABLE$com$smaato$soma$measurements$FraudesType()[var1.ordinal()]) {
            case 1:
               Debugger.showLog(new LogMessage(Reporter.TAG, "Uber Frequent Request Detected", 2, DebugCategory.WARNING));
               break;
            case 2:
               Debugger.showLog(new LogMessage(Reporter.TAG, "Auto Click Detected", 2, DebugCategory.WARNING));
               break;
            case 3:
               Debugger.showLog(new LogMessage(Reporter.TAG, "Banner is off screen", 2, DebugCategory.WARNING));
               break;
            case 4:
               Debugger.showLog(new LogMessage(Reporter.TAG, "Bad banner dimension", 2, DebugCategory.WARNING));
               break;
            case 5:
               Debugger.showLog(new LogMessage(Reporter.TAG, "Banner View is overlapped by another one", 2, DebugCategory.WARNING));
            }

            return null;
         }
      }).execute();
   }
}
