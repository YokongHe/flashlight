package com.millennialmedia.android;

import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMAdImpl$BasicWebViewClientListener;

class MMAdView$MMAdViewWebViewClientListener extends MMAdImpl$BasicWebViewClientListener {
   MMAdView$MMAdViewWebViewClientListener(MMAdImpl var1) {
      super(var1);
   }

   public void onPageFinished(String var1) {
      super.onPageFinished(var1);
      MMAdImpl var2 = (MMAdImpl)this.adImplRef.get();
      if(var2 != null && var2.isTransitionAnimated()) {
         var2.animateTransition();
      }

   }
}
