package com.flurry.sdk;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.Window;

public final class ch {
   @TargetApi(11)
   public static void a(Window var0) {
      if(var0 != null && VERSION.SDK_INT >= 11) {
         var0.setFlags(16777216, 16777216);
      }
   }
}
