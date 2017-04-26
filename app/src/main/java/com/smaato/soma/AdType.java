package com.smaato.soma;

import com.smaato.soma.exception.UnknownAdTypeException;
import com.smaato.soma.exception.UnknownStringAdTypeValue;

public enum AdType {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$AdType;
   ALL;

   private static final String ALL_STRING = "ALL";
   IMAGE;

   private static final String IMG_STRING = "IMG";
   RICHMEDIA;

   private static final String RICHMEDIA_STRING = "RICHMEDIA";
   TEXT;

   private static final String TXT_STRING = "TXT";
   VIDEO;

   private static final String VIDEO_STRING = "VIDEO";

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$smaato$soma$AdType() {
      int[] var0 = $SWITCH_TABLE$com$smaato$soma$AdType;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[values().length];

         try {
            var0[ALL.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[IMAGE.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[RICHMEDIA.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[TEXT.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[VIDEO.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$AdType = var0;
         return var0;
      }
   }

   public static String getStringForValue(AdType var0) {
      try {
         switch($SWITCH_TABLE$com$smaato$soma$AdType()[var0.ordinal()]) {
         case 1:
            return "ALL";
         case 2:
            return "IMG";
         case 3:
            return "TXT";
         case 4:
            return "VIDEO";
         case 5:
            return "RICHMEDIA";
         default:
            return "";
         }
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnknownAdTypeException(var2);
      }
   }

   public static AdType getValueForString(String var0) {
      try {
         if(var0.equalsIgnoreCase("ALL")) {
            return ALL;
         } else if(var0.equalsIgnoreCase("IMG")) {
            return IMAGE;
         } else if(var0.equalsIgnoreCase("TXT")) {
            return TEXT;
         } else if(var0.equalsIgnoreCase("VIDEO")) {
            return VIDEO;
         } else if(var0.equalsIgnoreCase("RICHMEDIA")) {
            AdType var3 = RICHMEDIA;
            return var3;
         } else {
            return null;
         }
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnknownStringAdTypeValue(var2);
      }
   }
}
