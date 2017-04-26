package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.Display;

@TargetApi(8)
class AndroidTargetUtils$FroyoTargetUtils {
   protected static String getPackageCodePath(Context var0) {
      return var0.getPackageCodePath();
   }

   protected static int getRotation(Display var0) {
      return var0.getRotation();
   }
}
