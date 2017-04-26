package com.millennialmedia.android;

import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMAdImpl$BasicWebViewClientListener;

class AdViewOverlayView$OverlayWebViewClientListener extends MMAdImpl$BasicWebViewClientListener {
   AdViewOverlayView$OverlayWebViewClientListener(MMAdImpl var1) {
      super(var1);
   }

   public void onPageFinished(String var1) {
      super.onPageFinished(var1);
      MMAdImpl var2 = (MMAdImpl)this.adImplRef.get();
      if(var2 != null) {
         var2.removeProgressBar();
      }

   }
}
