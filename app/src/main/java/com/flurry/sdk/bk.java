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

public final class bk implements com.flurry.sdk.k {
   private static final String a = com.flurry.sdk.bk.class.getSimpleName();
   private static final Map b = a();

   private static com.flurry.sdk.k a(String var0) {
      return (com.flurry.sdk.k)b.get(var0);
   }

   private static Map a() {
      HashMap var0 = new HashMap();
      var0.put("AdMob".toUpperCase(Locale.US), new com.flurry.sdk.bq());
      var0.put("Millennial Media".toUpperCase(Locale.US), new com.flurry.sdk.bw());
      var0.put("InMobi".toUpperCase(Locale.US), new com.flurry.sdk.bs());
      var0.put("Facebook Audience Network".toUpperCase(Locale.US), new com.flurry.sdk.bn());
      return Collections.unmodifiableMap(var0);
   }

   public final com.flurry.sdk.i a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      com.flurry.sdk.i var7;
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

         com.flurry.sdk.k var6 = a(var10.toUpperCase(Locale.US));
         if(var6 == null) {
            return null;
         }

         eo.a(3, a, "Creating ad network view for type: " + var10);
         com.flurry.sdk.i var8 = var6.a(var1, var2, var3, var4);
         if(var8 == null) {
            eo.b(a, "Cannot create ad network view for type: " + var10);
            return null;
         }

         var7 = var8;
         if(var8 != null) {
            var8.setAdUnit(var4);
            return var8;
         }
      } else {
         var7 = null;
      }

      return var7;
   }
}
