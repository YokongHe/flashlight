package com.flurry.sdk;

import com.flurry.sdk.eo;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.RequestListener;
import java.util.Collections;

final class bx$a implements RequestListener {
   // $FF: synthetic field
   final com.flurry.sdk.bx a;

   private bx$a(com.flurry.sdk.bx var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   bx$a(com.flurry.sdk.bx var1, Object var2) {
      this(var1);
   }

   public final void MMAdOverlayClosed(MMAd var1) {
      eo.a(3, com.flurry.sdk.bx.a(), "Millennial MMAdView banner overlay closed.");
   }

   public final void MMAdOverlayLaunched(MMAd var1) {
      eo.a(3, com.flurry.sdk.bx.a(), "Millennial MMAdView banner overlay launched.");
   }

   public final void MMAdRequestIsCaching(MMAd var1) {
      eo.a(3, com.flurry.sdk.bx.a(), "Millennial MMAdView banner request is caching.");
   }

   public final void onSingleTap(MMAd var1) {
      this.a.onAdClicked(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bx.a(), "Millennial MMAdView banner tapped.");
   }

   public final void requestCompleted(MMAd var1) {
      this.a.onAdShown(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bx.a(), "Millennial MMAdView returned ad." + System.currentTimeMillis());
   }

   public final void requestFailed(MMAd var1, MMException var2) {
      this.a.onRenderFailed(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bx.a(), "Millennial MMAdView failed to load ad with error: " + var2);
   }
}
