package com.ihandysoft.ad.a;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import java.util.Map;

public class f extends com.ihandysoft.ad.a.a implements AdListener {
   public final boolean a(Map var1) {
      return super.a(var1)?this.d.get("placementID").equals(var1.get("placementID")):false;
   }

   public void onAdClicked(Ad var1) {
      this.v();
   }

   public void onAdLoaded(Ad var1) {
      this.u();
   }

   public void onError(Ad var1, AdError var2) {
      this.a(new Exception(var2.getErrorMessage()));
   }

   public final void p() {
      String var1 = (String)this.d.get("placementID");
      AdView var2 = new AdView(this.a(), var1, AdSize.BANNER_320_50);
      var2.setAdListener(this);
      this.b = var2;
      var2.loadAd();
   }

   public final void t() {
      if(this.b != null) {
         try {
            ((AdView)this.b).destroy();
         } catch (Exception var2) {
            ;
         }
      }

      super.t();
   }
}
