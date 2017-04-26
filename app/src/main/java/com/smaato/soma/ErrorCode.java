package com.smaato.soma;

import com.smaato.soma.exception.UnrecognizedStringErrorCodeValue;

public enum ErrorCode {
   GENERAL_ERROR,
   NO_AD_AVAILABLE,
   NO_CONNECTION_ERROR,
   NO_ERROR,
   PARSING_ERROR,
   UNKNOWN_PUBLISHER_OR_ADSPACE_ID;

   public static String getStringForValue(ErrorCode param0) {
      // $FF: Couldn't be decompiled
   }

   public static ErrorCode getValueForString(String var0) {
      try {
         if(var0.equalsIgnoreCase("0")) {
            return NO_ERROR;
         } else if(var0.equalsIgnoreCase("106")) {
            return UNKNOWN_PUBLISHER_OR_ADSPACE_ID;
         } else if(var0.equalsIgnoreCase("NO_CONNECTION_ERROR")) {
            return NO_CONNECTION_ERROR;
         } else if(var0.equalsIgnoreCase("42")) {
            return NO_AD_AVAILABLE;
         } else if(var0.equalsIgnoreCase("107")) {
            return GENERAL_ERROR;
         } else if(var0.equalsIgnoreCase("PARSING_ERROR")) {
            ErrorCode var3 = PARSING_ERROR;
            return var3;
         } else {
            return null;
         }
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnrecognizedStringErrorCodeValue(var2);
      }
   }
}
