package com.ihandysoft.ad.a;

import com.inneractive.api.ads.sdk.InneractiveAdView;
import com.inneractive.api.ads.sdk.InneractiveAdView$AdType;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveBannerAdListener;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$MediationName;
import java.util.Map;

public class i extends com.ihandysoft.ad.a.a implements InneractiveAdView$InneractiveBannerAdListener {
   public final boolean a(Map var1) {
      return super.a(var1)?this.d.get("appID").equals(var1.get("appID")):false;
   }

   public void inneractiveAdWillOpenExternalApp(InneractiveAdView var1) {
      this.y();
   }

   public void inneractiveBannerClicked(InneractiveAdView var1) {
      this.v();
   }

   public void inneractiveBannerCollapsed(InneractiveAdView var1) {
      this.x();
   }

   public void inneractiveBannerExpanded(InneractiveAdView var1) {
      this.w();
   }

   public void inneractiveBannerFailed(InneractiveAdView var1, InneractiveAdView$InneractiveErrorCode var2) {
      this.a(new Exception("InneractiveErrorCode:" + var2));
   }

   public void inneractiveBannerLoaded(InneractiveAdView var1) {
      this.u();
   }

   public void inneractiveBannerResized(InneractiveAdView var1) {
   }

   public void inneractiveDefaultBannerLoaded(InneractiveAdView var1) {
      this.a(new Exception("Default Ad Received"));
   }

   public void inneractiveInternalBrowserDismissed(InneractiveAdView var1) {
      this.x();
   }

   public final void p() {
      InneractiveAdView var1 = new InneractiveAdView(this.a(), (String)this.d.get("appID"), InneractiveAdView$AdType.Banner);
      var1.setBannerAdListener(this);
      var1.setMediationName(InneractiveAdView$MediationName.OTHER);
      var1.setRefreshInterval(0);
      this.b = var1;
      var1.loadAd();
      if(this.e != null) {
         var1.setKeywords(this.e);
      }

   }

   public final void t() {
      if(this.b != null) {
         InneractiveAdView var1 = (InneractiveAdView)this.b;
         var1.setBannerAdListener((InneractiveAdView$InneractiveBannerAdListener)null);
         var1.destroy();
      }

      super.t();
   }
}
