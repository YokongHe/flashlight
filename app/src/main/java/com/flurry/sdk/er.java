package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.sdk.eo;
import com.flurry.sdk.et;

public final class er {
   private static final String a = er.class.getSimpleName();

   public static et a(String var0) {
      if(TextUtils.isEmpty(var0)) {
         return null;
      } else {
         et var1;
         et var3;
         try {
            var1 = (et)Class.forName(var0).getDeclaredMethod("getInstance", new Class[0]).invoke((Object)null, new Object[0]);
         } catch (Exception var2) {
            eo.a(5, a, "FlurryModule " + var0 + " is not available:", var2);
            var3 = null;
            return var3;
         }

         var3 = var1;
         return var3;
      }
   }
}
