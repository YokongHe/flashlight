package com.mopub.nativeads;

import com.mopub.common.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

enum NativeResponse$Parameter {
   CALL_TO_ACTION,
   CLICK_DESTINATION,
   CLICK_TRACKER,
   FALLBACK,
   ICON_IMAGE,
   IMPRESSION_TRACKER,
   MAIN_IMAGE,
   STAR_RATING,
   TEXT,
   TITLE;

   @VisibleForTesting
   static final Set requiredKeys;
   final String name;
   final boolean required;

   static {
      int var0 = 0;
      IMPRESSION_TRACKER = new NativeResponse$Parameter("IMPRESSION_TRACKER", 0, "imptracker", true);
      CLICK_TRACKER = new NativeResponse$Parameter("CLICK_TRACKER", 1, "clktracker", true);
      TITLE = new NativeResponse$Parameter("TITLE", 2, "title", false);
      TEXT = new NativeResponse$Parameter("TEXT", 3, "text", false);
      MAIN_IMAGE = new NativeResponse$Parameter("MAIN_IMAGE", 4, "mainimage", false);
      ICON_IMAGE = new NativeResponse$Parameter("ICON_IMAGE", 5, "iconimage", false);
      CLICK_DESTINATION = new NativeResponse$Parameter("CLICK_DESTINATION", 6, "clk", false);
      FALLBACK = new NativeResponse$Parameter("FALLBACK", 7, "fallback", false);
      CALL_TO_ACTION = new NativeResponse$Parameter("CALL_TO_ACTION", 8, "ctatext", false);
      STAR_RATING = new NativeResponse$Parameter("STAR_RATING", 9, "starrating", false);
      requiredKeys = new HashSet();
      NativeResponse$Parameter[] var2 = values();

      for(int var1 = var2.length; var0 < var1; ++var0) {
         NativeResponse$Parameter var3 = var2[var0];
         if(var3.required) {
            requiredKeys.add(var3.name);
         }
      }

   }

   private NativeResponse$Parameter(String var3, boolean var4) {
      this.name = var3;
      this.required = var4;
   }

   static NativeResponse$Parameter from(String var0) {
      NativeResponse$Parameter[] var5 = values();
      int var2 = var5.length;
      int var1 = 0;

      NativeResponse$Parameter var3;
      while(true) {
         if(var1 >= var2) {
            var3 = null;
            break;
         }

         NativeResponse$Parameter var4 = var5[var1];
         var3 = var4;
         if(var4.name.equals(var0)) {
            break;
         }

         ++var1;
      }

      return var3;
   }
}
