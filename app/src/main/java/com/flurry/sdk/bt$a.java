package com.flurry.sdk;

import com.flurry.sdk.eo;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import java.util.Collections;
import java.util.Map;

final class bt$a implements IMBannerListener {
   // $FF: synthetic field
   final com.flurry.sdk.bt a;

   private bt$a(com.flurry.sdk.bt var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   bt$a(com.flurry.sdk.bt var1, Object var2) {
      this(var1);
   }

   public final void onBannerInteraction(IMBanner var1, Map var2) {
      this.a.onAdClicked(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bt.a(), "InMobi onBannerInteraction");
   }

   public final void onBannerRequestFailed(IMBanner var1, IMErrorCode var2) {
      this.a.onRenderFailed(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bt.a(), "InMobi imAdView ad request failed. " + var2.toString());
   }

   public final void onBannerRequestSucceeded(IMBanner var1) {
      this.a.onAdShown(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bt.a(), "InMobi imAdView ad request completed.");
   }

   public final void onDismissBannerScreen(IMBanner var1) {
      this.a.onAdClosed(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bt.a(), "InMobi imAdView dismiss ad.");
   }

   public final void onLeaveApplication(IMBanner var1) {
      eo.a(3, com.flurry.sdk.bt.a(), "InMobi onLeaveApplication");
   }

   public final void onShowBannerScreen(IMBanner var1) {
      this.a.onAdClicked(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bt.a(), "InMobi imAdView ad shown.");
   }
}
