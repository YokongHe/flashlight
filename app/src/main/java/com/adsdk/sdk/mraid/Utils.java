package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;

public class Utils {
   public static boolean deviceCanHandleIntent(Context var0, Intent var1) {
      boolean var2 = false;
      if(var0.getPackageManager().queryIntentActivities(var1, 0).size() > 0) {
         var2 = true;
      }

      return var2;
   }

   public static String sha1(String param0) {
      // $FF: Couldn't be decompiled
   }
}
