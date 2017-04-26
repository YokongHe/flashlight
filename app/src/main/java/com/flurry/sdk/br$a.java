package com.flurry.sdk;

import com.flurry.sdk.eo;
import java.util.Collections;

final class br$a extends com.google.android.gms.ads.a {
   // $FF: synthetic field
   final com.flurry.sdk.br a;

   private br$a(com.flurry.sdk.br var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   br$a(com.flurry.sdk.br var1, Object var2) {
      this(var1);
   }

   public final void onAdClosed() {
      this.a.c(Collections.emptyMap());
      eo.a(4, com.flurry.sdk.br.f(), "GMS AdView onAdClosed.");
   }

   public final void onAdFailedToLoad(int var1) {
      this.a.d(Collections.emptyMap());
      eo.a(5, com.flurry.sdk.br.f(), "GMS AdView onAdFailedToLoad: " + var1 + ".");
   }

   public final void onAdLeftApplication() {
      this.a.b(Collections.emptyMap());
      eo.a(4, com.flurry.sdk.br.f(), "GMS AdView onAdLeftApplication.");
   }

   public final void onAdLoaded() {
      this.a.a(Collections.emptyMap());
      eo.a(4, com.flurry.sdk.br.f(), "GMS AdView onAdLoaded.");
      com.flurry.sdk.br.a(this.a).b();
   }

   public final void onAdOpened() {
      eo.a(4, com.flurry.sdk.br.f(), "GMS AdView onAdOpened.");
   }
}
