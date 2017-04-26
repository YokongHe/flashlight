package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.eb;

abstract class ea {
   static final ea a;
   static ea b;

   static {
      eb var0 = new eb();
      a = var0;
      b = var0;
   }

   static ea a() {
      return b;
   }

   public abstract Object createPlacement(Context var1, String var2, TJPlacementListener var3);
}
