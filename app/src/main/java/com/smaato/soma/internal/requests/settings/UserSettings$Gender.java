package com.smaato.soma.internal.requests.settings;

import com.smaato.soma.exception.UnknownGenderException;
import com.smaato.soma.exception.UnknownStringGenderValue;

public enum UserSettings$Gender {
   FEMALE,
   MALE,
   UNSET;

   private String value;

   static {
      UNSET.value = "";
      MALE.value = "MALE";
      FEMALE.value = "FEMALE";
   }

   public static String getStringForValue(UserSettings$Gender var0) {
      try {
         return var0 == UNSET?"":(var0 == MALE?"m":(var0 == FEMALE?"f":null));
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnknownGenderException(var2);
      }
   }

   public static UserSettings$Gender getValueForString(String var0) {
      try {
         if(var0.equalsIgnoreCase("")) {
            return UNSET;
         } else if(var0.equalsIgnoreCase("m")) {
            return MALE;
         } else if(var0.equalsIgnoreCase("f")) {
            UserSettings$Gender var3 = FEMALE;
            return var3;
         } else {
            return null;
         }
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnknownStringGenderValue(var2);
      }
   }

   public final String getValue() {
      return this.value;
   }
}
