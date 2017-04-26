package com.smaato.soma;

import com.smaato.soma.exception.UnknownAdDimensionException;
import com.smaato.soma.exception.UnknownStringValueForAdDimension;

public enum AdDimension {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$AdDimension;
   DEFAULT;

   private static final String INT = "";
   INTERSTITIAL_LANDSCAPE,
   INTERSTITIAL_PORTRAIT;

   private static final String LEADER = "LEADER";
   LEADERBOARD,
   MEDIUMRECTANGLE;

   private static final String MEDRECT = "MEDRECT";
   private static final String MMA = "MMA";
   NOT_SET;

   private static final String SKY = "SKY";
   SKYSCRAPER;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$smaato$soma$AdDimension() {
      int[] var0 = $SWITCH_TABLE$com$smaato$soma$AdDimension;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[values().length];

         try {
            var0[DEFAULT.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            var0[INTERSTITIAL_LANDSCAPE.ordinal()] = 6;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            var0[INTERSTITIAL_PORTRAIT.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[LEADERBOARD.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[MEDIUMRECTANGLE.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[NOT_SET.ordinal()] = 7;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[SKYSCRAPER.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$AdDimension = var0;
         return var0;
      }
   }

   public static String getStringForValue(AdDimension var0) {
      try {
         switch($SWITCH_TABLE$com$smaato$soma$AdDimension()[var0.ordinal()]) {
         case 1:
            return "MMA";
         case 2:
            return "MEDRECT";
         case 3:
            return "LEADER";
         case 4:
            return "SKY";
         case 5:
            return "";
         default:
            return "";
         }
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnknownAdDimensionException(var2);
      }
   }

   public static AdDimension getValueForString(String var0) {
      try {
         if(var0.equalsIgnoreCase("MMA")) {
            return DEFAULT;
         } else if(var0.equalsIgnoreCase("MEDRECT")) {
            return MEDIUMRECTANGLE;
         } else if(var0.equalsIgnoreCase("LEADER")) {
            return LEADERBOARD;
         } else if(var0.equalsIgnoreCase("SKY")) {
            return SKYSCRAPER;
         } else if(var0.equalsIgnoreCase("")) {
            AdDimension var3 = INTERSTITIAL_PORTRAIT;
            return var3;
         } else {
            return null;
         }
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnknownStringValueForAdDimension(var2);
      }
   }
}
