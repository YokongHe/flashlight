package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;
import com.flurry.sdk.o$a;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o implements com.flurry.sdk.k {
   static final String a = com.flurry.sdk.o.class.getSimpleName();
   private static final Map b = a();

   private static com.flurry.sdk.k a(String var0) {
      return (com.flurry.sdk.k)b.get(var0);
   }

   private static String a(AdUnit var0) {
      if(var0 == null) {
         return null;
      } else {
         List var2 = var0.d();
         if(var2 != null && !var2.isEmpty()) {
            AdFrame var3 = (AdFrame)var2.get(0);
            if(var3 == null) {
               return null;
            } else {
               int var1 = var3.b().intValue();
               return var0.e().intValue() != 1 && var1 != 2 && var1 != 1 && var1 != 3?(var1 == 4?"THIRD_PARTY":null):"FLURRY";
            }
         } else {
            return null;
         }
      }
   }

   private static Map a() {
      HashMap var0 = new HashMap();
      var0.put("FLURRY", new o$a(null));
      var0.put("THIRD_PARTY", new com.flurry.sdk.bk());
      return Collections.unmodifiableMap(var0);
   }

   public final com.flurry.sdk.i a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      if(var1 != null && var2 != null && var3 != null && var4 != null) {
         String var5 = a(var4);
         if(var5 != null) {
            com.flurry.sdk.k var6 = a(var5);
            if(var6 == null) {
               eo.d(a, "Cannot create ad banner for type: " + var5);
               return null;
            }

            eo.a(3, a, "Creating ad banner for type: " + var5);
            return var6.a(var1, var2, var3, var4);
         }
      }

      return null;
   }
}
