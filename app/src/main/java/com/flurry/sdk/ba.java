package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;
import java.util.Map;

public abstract class ba extends com.flurry.sdk.aj {
   private static final String b = com.flurry.sdk.ba.class.getSimpleName();

   public ba(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      super(var1, var2, var3, var4);
   }

   private void a(String var1, Map var2) {
      eo.a(3, b, "onEvent: " + var1);
      if(this.e() != null) {
         this.c().a((com.flurry.sdk.q)(new com.flurry.sdk.q(var1, var2, this.b(), this.e(), this.d(), 0)), (com.flurry.sdk.ad)this.c().a(), 0);
      } else {
         eo.a(3, b, "adUnit == null");
      }
   }

   public void a(Map var1) {
      this.a("rendered", var1);
   }

   public void b(Map var1) {
      this.a("clicked", var1);
   }

   public void c(Map var1) {
      this.a("adClosed", var1);
   }

   public void d(Map var1) {
      this.a("renderFailed", var1);
   }
}
