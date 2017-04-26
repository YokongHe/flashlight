package com.adsdk.sdk.data;

public enum ClickType {
   BROWSER,
   INAPP;

   public static ClickType getValue(String var0) {
      ClickType[] var5 = values();
      int var2 = var5.length;
      int var1 = 0;

      ClickType var3;
      while(true) {
         if(var1 >= var2) {
            var3 = null;
            break;
         }

         ClickType var4 = var5[var1];
         var3 = var4;
         if(var4.name().equalsIgnoreCase(var0)) {
            break;
         }

         ++var1;
      }

      return var3;
   }
}
