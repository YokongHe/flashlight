package com.flurry.sdk;

import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;
import com.flurry.sdk.fc;
import java.util.List;

public final class cc {
   public static AdCreative a(AdSpaceLayout var0) {
      return var0 == null?null:new AdCreative(var0.c().intValue(), var0.b().intValue(), var0.e().toString(), var0.d().toString(), var0.f().toString());
   }

   public static AdCreative a(AdUnit var0) {
      if(var0 == null) {
         return null;
      } else {
         List var1 = var0.d();
         if(var1 != null && !var1.isEmpty()) {
            AdFrame var2 = (AdFrame)var1.get(0);
            if(var2 == null) {
               return null;
            } else {
               AdSpaceLayout var3 = var2.e();
               return var3 == null?null:a(var3);
            }
         } else {
            return null;
         }
      }
   }

   public static ScreenOrientationType a() {
      int var0 = fc.i();
      return var0 == 1?ScreenOrientationType.a:(var0 == 2?ScreenOrientationType.b:ScreenOrientationType.c);
   }
}
