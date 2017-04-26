package com.flurry.sdk;

import com.flurry.sdk.eo;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMInterstitial;
import com.inmobi.monetization.IMInterstitial$State;
import com.inmobi.monetization.IMInterstitialListener;
import java.util.Collections;
import java.util.Map;

final class bv$a implements IMInterstitialListener {
   // $FF: synthetic field
   final com.flurry.sdk.bv a;

   private bv$a(com.flurry.sdk.bv var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   bv$a(com.flurry.sdk.bv var1, Object var2) {
      this(var1);
   }

   public final void onDismissInterstitialScreen(IMInterstitial var1) {
      this.a.c(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bv.f(), "InMobi Interstitial ad dismissed.");
   }

   public final void onInterstitialFailed(IMInterstitial var1, IMErrorCode var2) {
      this.a.d(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bv.f(), "InMobi imAdView ad request failed. ErrorCode  = " + var2.toString());
   }

   public final void onInterstitialInteraction(IMInterstitial var1, Map var2) {
      this.a.b(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bv.f(), "InMobi onBannerInteraction");
   }

   public final void onInterstitialLoaded(IMInterstitial var1) {
      eo.a(3, com.flurry.sdk.bv.f(), "InMobi Interstitial ad request completed.");
      if(IMInterstitial$State.READY.equals(var1.getState())) {
         this.a.a(Collections.emptyMap());
         var1.show();
      }

   }

   public final void onLeaveApplication(IMInterstitial var1) {
      this.a.b(Collections.emptyMap());
      eo.a(3, com.flurry.sdk.bv.f(), "InMobi onLeaveApplication");
   }

   public final void onShowInterstitialScreen(IMInterstitial var1) {
      eo.a(3, com.flurry.sdk.bv.f(), "InMobi Interstitial ad shown.");
   }
}
