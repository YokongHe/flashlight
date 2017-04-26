package com.inneractive.api.ads.sdk;

import android.content.Context;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveInterstitialAdActivity;
import com.inneractive.api.ads.sdk.b$a;

class IAelementaryInterstitial extends com.inneractive.api.ads.sdk.b {
   private Context a;
   private com.inneractive.api.ads.sdk.a b;

   protected final void a() {
      InneractiveInterstitialAdActivity.start(this.a, this.b);
   }

   protected final void a(Context var1, b$a var2, com.inneractive.api.ads.sdk.a var3) {
      this.a = var1;
      if(var3 == null) {
         var2.a(InneractiveAdView$InneractiveErrorCode.SERVER_INVALID_RESPONSE);
      } else {
         ag var5 = var3.v();
         boolean var4;
         if(var5 != null && !an.a(var5.b())) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(!var4) {
            var2.a(InneractiveAdView$InneractiveErrorCode.SERVER_INVALID_RESPONSE);
         } else {
            this.b = var3;
            com.inneractive.api.ads.sdk.a var6 = this.b;
            InneractiveInterstitialAdActivity.displayAhead(this.a, var2, var6);
         }
      }
   }

   protected final void b() {
      InneractiveInterstitialAdActivity.onInvalidate();
   }
}
