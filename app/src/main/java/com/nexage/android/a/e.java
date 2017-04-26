package com.nexage.android.a;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;

public final class e {
   private static String a = "GooglePlayService";
   private static AdvertisingIdClient$Info b;

   public static String a(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static boolean b(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private static boolean c(Context var0) {
      int var1 = com.google.android.gms.common.g.a(var0);
      String var2;
      switch(var1) {
      case 0:
         var2 = "SUCCESS";
         break;
      case 1:
         var2 = "SERVICE_MISSING";
         break;
      case 2:
         var2 = "SERVICE_VERSION_UPDATE_REQUIRED";
         break;
      case 3:
         var2 = "SERVICE_DISABLED";
         break;
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      default:
         var2 = "WTF";
         break;
      case 9:
         var2 = "SERVICE_INVALID";
      }

      com.nexage.android.a.p.b(a, "isGooglePlayServicesAvailable " + var2);
      return var1 == 0;
   }
}
