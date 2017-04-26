package com.millennialmedia.android;

import android.content.Context;
import com.millennialmedia.android.AdViewOverlayView;
import com.millennialmedia.android.AdViewOverlayView$OverlayRedirectionListenerImpl;
import com.millennialmedia.android.AdViewOverlayView$OverlayWebViewClientListener;
import com.millennialmedia.android.BannerExpandedWebViewClient;
import com.millennialmedia.android.InterstitialWebViewClient;
import com.millennialmedia.android.MMLayout$MMLayoutMMAdImpl;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMWebViewClient;

class AdViewOverlayView$AdViewOverlayViewMMAdImpl extends MMLayout$MMLayoutMMAdImpl {
   // $FF: synthetic field
   final AdViewOverlayView this$0;

   public AdViewOverlayView$AdViewOverlayViewMMAdImpl(AdViewOverlayView var1, Context var2) {
      super(var1, var2);
      this.this$0 = var1;
      this.mmWebViewClientListener = new AdViewOverlayView$OverlayWebViewClientListener(this);
   }

   MMWebViewClient getMMWebViewClient() {
      MMLog.d("AdViewOverlayView", "Returning a client for user: OverlayWebViewClient, adimpl=" + this.this$0.adImpl);
      if(this.this$0.adImpl.linkForExpansionId == 0L && !this.this$0.settings.hasExpandUrl()) {
         InterstitialWebViewClient var2 = new InterstitialWebViewClient(this.mmWebViewClientListener, new AdViewOverlayView$OverlayRedirectionListenerImpl(this));
         this.mmWebViewClient = var2;
         return var2;
      } else {
         BannerExpandedWebViewClient var1 = new BannerExpandedWebViewClient(this.mmWebViewClientListener, new AdViewOverlayView$OverlayRedirectionListenerImpl(this));
         this.mmWebViewClient = var1;
         return var1;
      }
   }

   boolean isExpandingToUrl() {
      return this.this$0.settings.hasExpandUrl() && !this.this$0.settings.hasLoadedExpandUrl();
   }

   void removeProgressBar() {
      AdViewOverlayView.access$200(this.this$0);
   }
}
