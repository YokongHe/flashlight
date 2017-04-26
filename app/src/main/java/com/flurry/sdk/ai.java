package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;

public final class ai extends com.flurry.sdk.ah {
   private static final String a = com.flurry.sdk.ai.class.getSimpleName();
   private com.flurry.sdk.aj b;

   public ai(FlurryAdModule var1, AdUnit var2, com.flurry.sdk.e var3) {
      super(var1, var2, var3);
   }

   public final void a(Context var1, ViewGroup var2) {
      if(var1 == null) {
         eo.a(6, a, "failed to render takeover ad for adspace: " + this.e() + " context: " + var1 + " viewGroup: " + var2);
      } else {
         FlurryAdModule var3 = this.b();
         AdUnit var4 = this.c();
         com.flurry.sdk.e var5 = this.d();
         if(var4 == null) {
            eo.a(6, a, "failed to render takeover ad, adUnit is null for adspace: " + this.e() + " context: " + var1 + " viewGroup: " + var2);
            return;
         }

         this.b = this.b().c().a_(var1, var3, var5, var4);
         if(this.b != null) {
            var3.a(var4);
            var3.a(var5);
            this.b.a();
            return;
         }
      }

   }
}
