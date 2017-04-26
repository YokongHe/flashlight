package com.flurry.sdk;

import com.flurry.sdk.eo;
import java.util.Collections;

final class bp$a extends com.google.android.gms.ads.a {
   // $FF: synthetic field
   final com.flurry.sdk.bp a;

   private bp$a(com.flurry.sdk.bp var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   bp$a(com.flurry.sdk.bp var1, Object var2) {
      this(var1);
   }

   public final void onAdClosed() {
      this.a.onAdClosed(Collections.emptyMap());
      eo.a(4, com.flurry.sdk.bp.a(), "GMS AdView onAdClosed.");
   }

   public final void onAdFailedToLoad(int var1) {
      this.a.onRenderFailed(Collections.emptyMap());
      eo.a(5, com.flurry.sdk.bp.a(), "GMS AdView onAdFailedToLoad: " + var1 + ".");
   }

   public final void onAdLeftApplication() {
      this.a.onAdClicked(Collections.emptyMap());
      eo.a(4, com.flurry.sdk.bp.a(), "GMS AdView onAdLeftApplication.");
   }

   public final void onAdLoaded() {
      this.a.onAdShown(Collections.emptyMap());
      eo.a(4, com.flurry.sdk.bp.a(), "GMS AdView onAdLoaded.");
   }

   public final void onAdOpened() {
      eo.a(4, com.flurry.sdk.bp.a(), "GMS AdView onAdOpened.");
   }
}
