package com.ihandysoft.ad.a;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView$BannerAdListener;
import java.util.Map;

public class l extends com.ihandysoft.ad.a.a implements MoPubView$BannerAdListener {
   public final boolean a(Map var1) {
      return super.a(var1) && this.d.get("adUnitID").equals(var1.get("adUnitID"));
   }

   public void onBannerClicked(MoPubView var1) {
      this.v();
   }

   public void onBannerCollapsed(MoPubView var1) {
      this.x();
   }

   public void onBannerExpanded(MoPubView var1) {
      this.w();
   }

   public void onBannerFailed(MoPubView var1, MoPubErrorCode var2) {
      this.a(new Exception("Error Code:" + var2));
   }

   public void onBannerLoaded(MoPubView var1) {
      this.u();
   }

   public final void p() {
      MoPubView var1 = new MoPubView(this.a());
      this.b = var1;
      var1.setAdUnitId((String)this.d.get("adUnitID"));
      if(this.e != null) {
         var1.setKeywords(this.e);
      }

      if(this.f != null) {
         var1.setLocation(this.f);
      }

      var1.setAutorefreshEnabled(false);
      var1.setBannerAdListener(this);
      var1.loadAd();
   }

   public final void t() {
      MoPubView var1 = (MoPubView)this.b;
      if(var1 != null) {
         var1.setBannerAdListener((MoPubView$BannerAdListener)null);
         var1.destroy();
      }

      super.t();
   }
}
