package com.amazon.device.ads;

import java.util.HashMap;

enum RelativePosition {
   BOTTOM_CENTER,
   BOTTOM_LEFT,
   BOTTOM_RIGHT,
   CENTER;

   private static final HashMap POSITIONS;
   TOP_CENTER,
   TOP_LEFT,
   TOP_RIGHT;

   static {
      HashMap var0 = new HashMap();
      POSITIONS = var0;
      var0.put("top-left", TOP_LEFT);
      POSITIONS.put("top-right", TOP_RIGHT);
      POSITIONS.put("top-center", TOP_CENTER);
      POSITIONS.put("bottom-left", BOTTOM_LEFT);
      POSITIONS.put("bottom-right", BOTTOM_RIGHT);
      POSITIONS.put("bottom-center", BOTTOM_CENTER);
      POSITIONS.put("center", CENTER);
   }

   public static RelativePosition fromString(String var0) {
      return (RelativePosition)POSITIONS.get(var0);
   }
}
