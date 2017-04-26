package com.ihs.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerLib;
import com.tapjoy.Tapjoy;

public final class a {
   private static String a(String var0) {
      return com.ihs.a.b.b.b(new String[]{"libCommons", "Analytics", var0});
   }

   public static void a() {
      com.ihs.a.a.a.b.a();
   }

   public static void a(Context var0) {
      String var1 = a("FlyerKey");
      if(!TextUtils.isEmpty(var1)) {
         AppsFlyerLib.setAppsFlyerKey(var1);
         AppsFlyerLib.sendTracking(var0);
      }
   }

   public static void b(Context var0) {
      String var1 = a("TapjoySDKKey");
      if(TextUtils.isEmpty(var1)) {
         (new StringBuilder("Tapjoy sdkKey empty: ")).append(TextUtils.isEmpty(var1)).toString();
      } else {
         Tapjoy.connect(var0, var1);
         Tapjoy.setDebugEnabled(com.ihs.a.e.f.a());
      }
   }
}
