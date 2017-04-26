package com.ihandysoft.ad.a;

import android.app.Activity;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import java.util.Map;

public class h extends com.ihandysoft.ad.a.a implements IMBannerListener {
   private static boolean n = true;

   public final boolean a(Map var1) {
      return super.a(var1)?this.d.get("siteID").equals(var1.get("siteID")):false;
   }

   public void onBannerInteraction(IMBanner var1, Map var2) {
      this.v();
   }

   public void onBannerRequestFailed(IMBanner var1, IMErrorCode var2) {
      this.a(new Exception(var2.toString()));
   }

   public void onBannerRequestSucceeded(IMBanner var1) {
      this.u();
   }

   public void onDismissBannerScreen(IMBanner var1) {
      this.x();
   }

   public void onLeaveApplication(IMBanner var1) {
      this.y();
   }

   public void onShowBannerScreen(IMBanner var1) {
      this.w();
   }

   public final void p() {
      String var2 = (String)this.d.get("siteID");
      if(n) {
         n = false;
         InMobi.initialize((Activity)this.a(), var2);
      }

      byte var1;
      if(this.c == com.ihandysoft.ad.a.a) {
         var1 = 15;
      } else if(this.c == com.ihandysoft.ad.a.b) {
         var1 = 12;
      } else {
         var1 = 11;
      }

      IMBanner var3 = new IMBanner((Activity)this.a(), var2, var1);
      var3.setRefreshInterval(-1);
      var3.setIMBannerListener(this);
      this.b = var3;
      if(this.e != null) {
         var3.setKeywords(this.e);
      }

      var3.loadBanner();
   }

   public final void t() {
      if(this.b != null) {
         ((IMBanner)this.b).setIMBannerListener((IMBannerListener)null);
         ((IMBanner)this.b).destroy();
      }

      super.t();
   }
}
