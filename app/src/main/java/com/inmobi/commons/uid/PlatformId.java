package com.inmobi.commons.uid;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.inmobi.commons.internal.Log;

public class PlatformId {
   public static String getAndroidId(Context var0) {
      String var1 = null;

      String var2;
      label20: {
         try {
            var2 = Secure.getString(var0.getContentResolver(), "android_id");
         } catch (Exception var4) {
            Log.internal("commons", "Unable to retrieve android id.");
            break label20;
         }

         var1 = var2;
      }

      var2 = var1;
      if(var1 == null) {
         try {
            var2 = System.getString(var0.getContentResolver(), "android_id");
         } catch (Exception var3) {
            Log.internal("commons", "Unable to retrieve android id.");
            return var1;
         }
      }

      return var2;
   }
}
