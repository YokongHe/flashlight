package com.ihandysoft.ad.a;

import android.widget.FrameLayout;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAdType;
import com.flurry.android.FlurryAds;
import java.util.Timer;
import java.util.TimerTask;

public class g extends com.ihandysoft.ad.a.a implements FlurryAdListener {
   private FrameLayout n;
   private String o;

   public void onAdClicked(String var1) {
      this.v();
   }

   public void onAdClosed(String var1) {
      this.x();
   }

   public void onAdOpened(String var1) {
      this.w();
   }

   public void onApplicationExit(String var1) {
      this.y();
   }

   public void onRenderFailed(String var1) {
      this.a((Exception)null);
   }

   public void onRendered(String var1) {
      this.u();
   }

   public void onVideoCompleted(String var1) {
   }

   public final void p() {
      this.o = (String)this.d.get("adSpace");
      this.n = new FrameLayout(this.a());
      this.b = this.n;
      FlurryAds.setAdListener(this);
      FlurryAds.removeAd(this.a(), this.o, this.n);
      FlurryAds.fetchAd(this.a(), this.o, this.n, FlurryAdSize.BANNER_BOTTOM);
   }

   public boolean shouldDisplayAd(String var1, FlurryAdType var2) {
      if(var2 == FlurryAdType.WEB_BANNER) {
         return true;
      } else {
         (new Timer()).schedule(new TimerTask() {
            public final void run() {
               g.this.a(new Exception("TAKEOVER Ad Received"));
            }
         }, 100L);
         return false;
      }
   }

   public void spaceDidFailToReceiveAd(String var1) {
      this.a((Exception)null);
   }

   public void spaceDidReceiveAd(String var1) {
      FlurryAds.displayAd(this.a(), this.o, this.n);
   }

   public final void t() {
      FlurryAds.setAdListener((FlurryAdListener)null);
      super.t();
   }
}
