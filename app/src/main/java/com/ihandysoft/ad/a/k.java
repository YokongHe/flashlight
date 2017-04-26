package com.ihandysoft.ad.a;

import com.adsdk.sdk.Ad;
import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.banner.AdView;
import java.util.Map;

public class k extends com.ihandysoft.ad.a.a implements AdListener {
   public final boolean a(Map var1) {
      return super.a(var1)?this.d.get("publisherID").equals(var1.get("publisherID")):false;
   }

   public void adClicked() {
      this.v();
   }

   public void adClosed(Ad var1, boolean var2) {
      this.x();
   }

   public void adLoadSucceeded(Ad var1) {
      this.u();
   }

   public void adShown(Ad var1, boolean var2) {
      this.w();
   }

   public void noAdFound() {
      this.a(new Exception("No Ad Found"));
   }

   protected final void p() {
      String var1 = (String)this.d.get("publisherID");
      AdView var2 = new AdView(this.a(), "http://my.mobfox.com/request.php", var1, true, false);
      var2.setAdspaceWidth(320);
      var2.setAdspaceHeight(50);
      var2.setAdspaceStrict(false);
      var2.setAdListener(this);
      var2.loadNextAd();
      this.b = var2;
   }

   protected final void t() {
      super.t();
   }
}
