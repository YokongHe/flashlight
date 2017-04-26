package com.inneractive.api.ads.sdk;

import android.content.Context;
import com.inneractive.api.ads.sdk.IAdefines$IAintegratedSdksTrackingAction;
import com.inneractive.api.ads.sdk.InneractiveAdView;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveBannerAdListener;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$InternalAdType;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.InneractiveInterstitialView$InneractiveInterstitialAdListener;
import com.inneractive.api.ads.sdk.InneractiveInterstitialView$InterstitialState;

public class InneractiveInterstitialView extends InneractiveAdView {
   private InneractiveInterstitialView$InneractiveInterstitialAdListener b;
   private InneractiveInterstitialView$InterstitialState c;
   private boolean d;

   public InneractiveInterstitialView(Context var1, String var2) {
      super(var1, var2, InneractiveAdView$InternalAdType.c);
      this.c = InneractiveInterstitialView$InterstitialState.b;
   }

   final void a() {
      this.c = InneractiveInterstitialView$InterstitialState.b;
      this.d = false;
      super.a();
   }

   protected final void a(int var1) {
   }

   final Integer b() {
      return super.b();
   }

   protected final void b(InneractiveAdView$InneractiveErrorCode var1) {
      if(!this.d) {
         this.c = InneractiveInterstitialView$InterstitialState.b;
         InneractiveAdView$Log.d("inneractive Interstitial Ad Faild");
         if(this.b != null) {
            this.b.inneractiveInterstitialFailed(this, var1);
            return;
         }
      }

   }

   protected final void d() {
      if(!this.d) {
         this.c = InneractiveInterstitialView$InterstitialState.a;
         InneractiveAdView$Log.d("inneractive Interstitial Ad Loaded");
         if(this.b != null) {
            this.b.inneractiveInterstitialLoaded(this);
            return;
         }
      }

   }

   public void destroy() {
      this.d = true;
      InneractiveAdView$Log.d("inneractive Interstitial Ad destroy");
      super.setBannerAdListener((InneractiveAdView$InneractiveBannerAdListener)null);
      super.destroy();
   }

   protected final void e() {
      if(!this.d) {
         this.c = InneractiveInterstitialView$InterstitialState.a;
         InneractiveAdView$Log.d("inneractive Default Interstitial Ad Loaded");
         if(this.b != null) {
            this.b.inneractiveDefaultInterstitialLoaded(this);
            return;
         }
      }

   }

   public InneractiveInterstitialView$InneractiveInterstitialAdListener getInterstitialAdListener() {
      return this.b;
   }

   public boolean isReady() {
      return this.c != InneractiveInterstitialView$InterstitialState.b;
   }

   protected final void k() {
      if(!this.d) {
         InneractiveAdView$Log.d("inneractive Interstitial Ad Clicked");
         if(this.n() != null && this.n().k() != null) {
            String var1 = this.n().k().z();
            if(var1 != null && !"".equals(var1) && !"IA".equals(var1)) {
               this.a(IAdefines$IAintegratedSdksTrackingAction.b);
            }
         }

         if(this.b != null) {
            this.b.inneractiveInterstitialClicked(this);
            return;
         }
      }

   }

   protected final void l() {
      InneractiveAdView$Log.d("app is in the background");
      if(this.b != null) {
         this.b.inneractiveAdWillOpenExternalApp(this);
      }

   }

   protected final void m() {
      InneractiveAdView$Log.d("intenal Browser Dissmissed");
      if(this.b != null) {
         this.b.inneractiveInternalBrowserDismissed(this);
      }

   }

   final void o() {
      if(!this.d) {
         InneractiveAdView$Log.d("inneractive Interstitial Ad Shown");
         this.c();
         if(this.n() != null && this.n().k() != null) {
            String var1 = this.n().k().y();
            if(var1 != null && !"".equals(var1)) {
               this.a(IAdefines$IAintegratedSdksTrackingAction.a);
            }
         }

         if(this.b != null) {
            this.b.inneractiveInterstitialShown(this);
         }

         this.c = InneractiveInterstitialView$InterstitialState.b;
      }
   }

   final void p() {
      if(!this.d) {
         this.c = InneractiveInterstitialView$InterstitialState.b;
         InneractiveAdView$Log.d("inneractive Interstitial Ad Dismissed");
         if(this.b != null) {
            this.b.inneractiveInterstitialDismissed(this);
            return;
         }
      }

   }

   public void setCacheVideosAdsBeforeDisplay(boolean var1) {
      this.a.c(var1);
   }

   public void setInterstitialAdListener(InneractiveInterstitialView$InneractiveInterstitialAdListener var1) {
      this.b = var1;
   }

   public boolean showAd() {
      switch(null.a[this.c.ordinal()]) {
      case 1:
         if(this.n() != null) {
            this.n().o();
         }

         return true;
      default:
         return false;
      }
   }
}
