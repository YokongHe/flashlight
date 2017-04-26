package com.millennialmedia.android;

import com.millennialmedia.android.AdViewOverlayView$AdViewOverlayViewMMAdImpl;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMAdImpl$MMAdImplRedirectionListenerImpl;

class AdViewOverlayView$OverlayRedirectionListenerImpl extends MMAdImpl$MMAdImplRedirectionListenerImpl {
   public AdViewOverlayView$OverlayRedirectionListenerImpl(MMAdImpl var1) {
      super(var1);
   }

   public boolean isExpandingToUrl() {
      MMAdImpl var1 = (MMAdImpl)this.adImplRef.get();
      return var1 != null && var1 instanceof AdViewOverlayView$AdViewOverlayViewMMAdImpl?var1.isExpandingToUrl():false;
   }
}
