package com.millennialmedia.android;

import android.content.Context;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMInterstitial;

class MMInterstitial$MMInterstitialAdImpl extends MMAdImpl {
   // $FF: synthetic field
   final MMInterstitial this$0;

   public MMInterstitial$MMInterstitialAdImpl(MMInterstitial var1, Context var2) {
      super(var2);
      this.this$0 = var1;
   }

   MMInterstitial getCallingAd() {
      return this.this$0;
   }
}
