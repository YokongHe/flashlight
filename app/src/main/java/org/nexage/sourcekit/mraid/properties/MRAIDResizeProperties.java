package org.nexage.sourcekit.mraid.properties;

import java.util.Arrays;

public final class MRAIDResizeProperties {
   public static final int CUSTOM_CLOSE_POSITION_BOTTOM_CENTER = 5;
   public static final int CUSTOM_CLOSE_POSITION_BOTTOM_LEFT = 4;
   public static final int CUSTOM_CLOSE_POSITION_BOTTOM_RIGHT = 6;
   public static final int CUSTOM_CLOSE_POSITION_CENTER = 3;
   public static final int CUSTOM_CLOSE_POSITION_TOP_CENTER = 1;
   public static final int CUSTOM_CLOSE_POSITION_TOP_LEFT = 0;
   public static final int CUSTOM_CLOSE_POSITION_TOP_RIGHT = 2;
   public boolean allowOffscreen;
   public int customClosePosition;
   public int height;
   public int offsetX;
   public int offsetY;
   public int width;

   public MRAIDResizeProperties() {
      this(0, 0, 0, 0, 2, true);
   }

   public MRAIDResizeProperties(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      this.width = var1;
      this.height = var2;
      this.offsetX = var3;
      this.offsetY = var4;
      this.customClosePosition = var5;
      this.allowOffscreen = var6;
   }

   public static int customClosePositionFromString(String var0) {
      int var1 = Arrays.asList(new String[]{"top-left", "top-center", "top-right", "center", "bottom-left", "bottom-center", "bottom-right"}).indexOf(var0);
      return var1 != -1?var1:2;
   }
}
