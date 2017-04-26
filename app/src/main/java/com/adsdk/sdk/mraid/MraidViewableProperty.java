package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidProperty;

class MraidViewableProperty extends MraidProperty {
   private final boolean mViewable;

   MraidViewableProperty(boolean var1) {
      this.mViewable = var1;
   }

   public static MraidViewableProperty createWithViewable(boolean var0) {
      return new MraidViewableProperty(var0);
   }

   public String toJsonPair() {
      StringBuilder var2 = new StringBuilder("viewable: ");
      String var1;
      if(this.mViewable) {
         var1 = "true";
      } else {
         var1 = "false";
      }

      return var2.append(var1).toString();
   }
}
