package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class bl implements com.flurry.sdk.ak {
   private static final String a = com.flurry.sdk.bl.class.getSimpleName();
   private static final Map b = a();

   private static com.flurry.sdk.ak a(String var0) {
      return (com.flurry.sdk.ak)b.get(var0);
   }

   private static Map a() {
      HashMap var0 = new HashMap();
      var0.put("AdMob".toUpperCase(Locale.US), new com.flurry.sdk.bq());
      var0.put("Millennial Media".toUpperCase(Locale.US), new com.flurry.sdk.bw());
      var0.put("InMobi".toUpperCase(Locale.US), new com.flurry.sdk.bs());
      var0.put("Facebook Audience Network".toUpperCase(Locale.US), new com.flurry.sdk.bn());
      return Collections.unmodifiableMap(var0);
   }

   public final com.flurry.sdk.aj a_(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      com.flurry.sdk.aj var7;
      if(var1 != null && var2 != null && var3 != null && var4 != null) {
         List var5 = var4.d();
         if(var5 == null || var5.isEmpty()) {
            return null;
         }

         AdFrame var9 = (AdFrame)var5.get(0);
         if(var9 == null) {
            return null;
         }

         String var10 = var9.d().toString();
         if(TextUtils.isEmpty(var10)) {
            return null;
         }

         com.flurry.sdk.ak var6 = a(var10.toUpperCase(Locale.US));
         if(var6 == null) {
            return null;
         }

         eo.a(3, a, "Creating ad network takeover launcher: " + var6.getClass().getSimpleName() + " for type: " + var10);
         com.flurry.sdk.aj var8 = var6.a_(var1, var2, var3, var4);
         var7 = var8;
         if(var8 == null) {
            eo.b(a, "Cannot create ad network takeover launcher for type: " + var10);
            return var8;
         }
      } else {
         var7 = null;
      }

      return var7;
   }
}
