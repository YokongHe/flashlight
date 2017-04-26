package com.smaato.soma.bannerutilities.constant;

import com.smaato.soma.exception.UnknownBannerStatusException;
import com.smaato.soma.exception.UnrecognizedBannerStatusValue;

public enum BannerStatus {
   ERROR;

   private static String ERROR_STRING;
   SUCCESS;

   private static String SUCCESS_STRING;

   static {
      SUCCESS_STRING = "SUCCESS";
      ERROR_STRING = "ERROR";
   }

   public static String getStringForValue(BannerStatus var0) {
      try {
         if(var0 == SUCCESS) {
            return SUCCESS_STRING;
         } else if(var0 == ERROR) {
            String var3 = ERROR_STRING;
            return var3;
         } else {
            return "";
         }
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnknownBannerStatusException(var2);
      }
   }

   public static BannerStatus getValueForString(String var0) {
      try {
         if(var0.equalsIgnoreCase(SUCCESS_STRING)) {
            return SUCCESS;
         } else if(var0.equalsIgnoreCase(ERROR_STRING)) {
            BannerStatus var3 = ERROR;
            return var3;
         } else {
            return null;
         }
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnrecognizedBannerStatusValue(var2);
      }
   }
}
