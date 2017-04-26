package com.tapjoy.internal;

import android.app.Activity;

public final class c {
   public static Activity a(Activity var0) {
      while(var0.getParent() != null) {
         var0 = var0.getParent();
      }

      return var0;
   }
}
