package com.tapjoy.mraid.util;

public enum NavigationStringEnum {
   BACK("back"),
   CLOSE("close"),
   FORWARD("forward"),
   NONE("none"),
   REFRESH("refresh");

   private String text;

   private NavigationStringEnum(String var3) {
      this.text = var3;
   }

   public static NavigationStringEnum fromString(String var0) {
      if(var0 != null) {
         NavigationStringEnum[] var3 = values();
         int var2 = var3.length;

         for(int var1 = 0; var1 < var2; ++var1) {
            NavigationStringEnum var4 = var3[var1];
            if(var0.equalsIgnoreCase(var4.text)) {
               return var4;
            }
         }
      }

      return null;
   }

   public final String getText() {
      return this.text;
   }
}
