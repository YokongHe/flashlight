package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.ea;

public class TapjoyNativeAPITesting extends ea {
   public static void disable() {
      ea.b = ea.a;
   }

   public static void enable(TapjoyNativeAPITesting var0) {
      ea.b = var0;
   }

   public Object createPlacement(Context var1, String var2, TJPlacementListener var3) {
      return new TJPlacement(var1, var2, var3);
   }
}
