package com.flurry.sdk;

import com.flurry.sdk.eo;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.RequestListener;
import java.util.Collections;

final class bz$a implements RequestListener {
   // $FF: synthetic field
   final com.flurry.sdk.bz a;

   private bz$a(com.flurry.sdk.bz var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   bz$a(com.flurry.sdk.bz var1, Object var2) {
      this(var1);
   }

   public final void MMAdOverlayClosed(MMAd var1) {
      this.a.c(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bz.f(), "Millennial MMAdView Interstitial overlay closed.");
   }

   public final void MMAdOverlayLaunched(MMAd var1) {
      this.a.a(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bz.f(), "Millennial MMAdView Interstitial overlay launched." + System.currentTimeMillis());
   }

   public final void MMAdRequestIsCaching(MMAd var1) {
      eo.a(3, com.flurry.sdk.bz.f(), "Millennial MMAdView Interstitial request is caching.");
   }

   public final void onSingleTap(MMAd var1) {
      this.a.b(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bz.f(), "Millennial MMAdView Interstitial tapped.");
   }

   public final void requestCompleted(MMAd var1) {
      eo.a(3, com.flurry.sdk.bz.f(), "Millennial MMAdView returned interstitial ad: " + System.currentTimeMillis());
      if(!com.flurry.sdk.bz.a(this.a)) {
         com.flurry.sdk.bz.b(this.a).display();
      }

   }

   public final void requestFailed(MMAd var1, MMException var2) {
      this.a.d(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bz.f(), "Millennial MMAdView Interstitial failed to load ad.");
   }
}
