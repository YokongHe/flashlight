package com.flurry.sdk;

import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import java.io.IOException;

public class dw {
   private static final String a = dw.class.getSimpleName();

   public static AdvertisingIdClient$Info a() {
      // $FF: Couldn't be decompiled
   }

   public static boolean b() {
      // $FF: Couldn't be decompiled
   }

   private static AdvertisingIdClient$Info c() {
      try {
         AdvertisingIdClient$Info var0 = AdvertisingIdClient.getAdvertisingIdInfo(do.a().b());
         return var0;
      } catch (IOException var1) {
         eo.a(6, a, "Exception in readAdvertisingInfo():" + var1);
         return null;
      } catch (com.google.android.gms.common.e var2) {
         eo.a(6, a, "Exception in readAdvertisingInfo():" + var2);
         return null;
      } catch (com.google.android.gms.common.f var3) {
         eo.a(6, a, "Exception in readAdvertisingInfo():" + var3);
         return null;
      }
   }
}
