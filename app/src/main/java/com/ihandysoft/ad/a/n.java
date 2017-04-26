package com.ihandysoft.ad.a;

import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.BannerStateListener;
import com.smaato.soma.BannerView;
import com.smaato.soma.BaseView;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import java.util.Map;

public class n extends com.ihandysoft.ad.a.a {
   public final boolean a(Map var1) {
      return super.a(var1);
   }

   protected final void p() {
      String var1 = (String)this.d.get("publisherID");
      String var2 = (String)this.d.get("adSpaceID");
      BannerView var3 = new BannerView(this.a());
      var3.getAdSettings().setPublisherId(Integer.parseInt(var1));
      var3.getAdSettings().setAdspaceId(Integer.parseInt(var2));
      if(this.f != null) {
         var3.getUserSettings().setLatitude(this.f.getLatitude());
         var3.getUserSettings().setLongitude(this.f.getLongitude());
      }

      if(this.e != null) {
         var3.getUserSettings().setKeywordList(this.e);
      }

      this.b = var3;
      var3.addAdListener(new AdListenerInterface() {
         public final void onReceiveAd(AdDownloaderInterface var1, ReceivedBannerInterface var2) {
            if(var2.getStatus() == BannerStatus.ERROR) {
               n.this.a(new Exception(var2.getErrorCode() + ":" + var2.getErrorMessage()));
            } else {
               n.this.u();
            }
         }
      });
      var3.setBannerStateListener(new BannerStateListener() {
         public final void onWillCloseLandingPage(BaseView var1) {
            n.this.x();
         }

         public final void onWillOpenLandingPage(BaseView var1) {
            n.this.v();
            n.this.w();
         }
      });
      var3.setAutoReloadEnabled(false);
      var3.asyncLoadNewBanner();
   }

   protected final void t() {
      super.t();
   }
}
