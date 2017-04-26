package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.ea;

public class TapjoyNative {
   public static Object createPlacement(Context var0, String var1, TJPlacementListener var2) {
      return ea.a().createPlacement(var0, var1, var2);
   }
}
