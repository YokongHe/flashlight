package org.nexage.sourcekit.mraid.properties;

import java.util.Arrays;

public final class MRAIDOrientationProperties {
   public static final int FORCE_ORIENTATION_LANDSCAPE = 1;
   public static final int FORCE_ORIENTATION_NONE = 2;
   public static final int FORCE_ORIENTATION_PORTRAIT = 0;
   public boolean allowOrientationChange;
   public int forceOrientation;

   public MRAIDOrientationProperties() {
      this(true, 2);
   }

   public MRAIDOrientationProperties(boolean var1, int var2) {
      this.allowOrientationChange = var1;
      this.forceOrientation = var2;
   }

   public static int forceOrientationFromString(String var0) {
      int var1 = Arrays.asList(new String[]{"portrait", "landscape", "none"}).indexOf(var0);
      return var1 != -1?var1:2;
   }

   public final String forceOrientationString() {
      switch(this.forceOrientation) {
      case 0:
         return "portrait";
      case 1:
         return "landscape";
      case 2:
         return "none";
      default:
         return "error";
      }
   }
}
