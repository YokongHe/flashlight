package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.ea;

final class eb extends ea {
   public final Object createPlacement(Context var1, String var2, TJPlacementListener var3) {
      return new TJPlacement(var1, var2, var3);
   }
}
