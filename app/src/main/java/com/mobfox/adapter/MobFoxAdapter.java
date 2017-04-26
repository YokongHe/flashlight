package com.mobfox.adapter;

import android.app.Activity;
import android.view.View;
import com.adsdk.sdk.Ad;
import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.AdManager;
import com.adsdk.sdk.banner.AdView;
import com.mobfox.adapter.MobFoxExtras;
import com.mobfox.adapter.MobFoxServerParameters;

public final class MobFoxAdapter implements com.google.a.a.c, com.google.a.a.e {
   private static final String REQUEST_URL = "http://my.mobfox.com/request.php";
   private AdView adView;
   private com.google.a.a.d bannerListener;
   private com.google.a.a.f interstitialListener;
   private AdManager mAdManager;

   public final void destroy() {
      if(this.adView != null) {
         this.adView.release();
      }

      if(this.mAdManager != null) {
         this.mAdManager.release();
      }

      this.bannerListener = null;
      this.interstitialListener = null;
   }

   public final Class getAdditionalParametersType() {
      return MobFoxExtras.class;
   }

   public final View getBannerView() {
      return this.adView;
   }

   public final Class getServerParametersType() {
      return MobFoxServerParameters.class;
   }

   public final void requestBannerAd(com.google.a.a.d var1, Activity var2, MobFoxServerParameters var3, com.google.a.d var4, com.google.a.a.a var5, MobFoxExtras var6) {
      this.bannerListener = var1;
      if(var6 != null) {
         this.adView = new AdView(var2, "http://my.mobfox.com/request.php", var3.pubIdNumber, var6.getLocation(), var6.getAnimation());
      } else {
         this.adView = new AdView(var2, "http://my.mobfox.com/request.php", var3.pubIdNumber, true, true);
      }

      this.adView.setAdspaceHeight(var4.b());
      this.adView.setAdspaceWidth(var4.a());
      this.adView.setAdListener(new AdListener() {
         public void adClicked() {
            if(MobFoxAdapter.this.bannerListener != null) {
               com.google.a.a.d var1 = MobFoxAdapter.this.bannerListener;
               MobFoxAdapter var2 = MobFoxAdapter.this;
               var1.d();
            }

         }

         public void adClosed(Ad var1, boolean var2) {
            if(MobFoxAdapter.this.bannerListener != null) {
               com.google.a.a.d var4 = MobFoxAdapter.this.bannerListener;
               MobFoxAdapter var3 = MobFoxAdapter.this;
               var4.c();
            }

         }

         public void adLoadSucceeded(Ad var1) {
            if(MobFoxAdapter.this.bannerListener != null) {
               com.google.a.a.d var3 = MobFoxAdapter.this.bannerListener;
               MobFoxAdapter var2 = MobFoxAdapter.this;
               var3.a();
            }

         }

         public void adShown(Ad var1, boolean var2) {
            if(MobFoxAdapter.this.bannerListener != null) {
               com.google.a.a.d var4 = MobFoxAdapter.this.bannerListener;
               MobFoxAdapter var3 = MobFoxAdapter.this;
               var4.b();
            }

         }

         public void noAdFound() {
            if(MobFoxAdapter.this.bannerListener != null) {
               com.google.a.a.d var1 = MobFoxAdapter.this.bannerListener;
               MobFoxAdapter var2 = MobFoxAdapter.this;
               var1.a(com.google.a.b.b);
            }

         }
      });
      this.adView.loadNextAd();
      this.adView.pause();
   }

   public final void requestInterstitialAd(com.google.a.a.f var1, Activity var2, MobFoxServerParameters var3, com.google.a.a.a var4, MobFoxExtras var5) {
      this.interstitialListener = var1;
      if(var5 != null) {
         this.mAdManager = new AdManager(var2, "http://my.mobfox.com/request.php", var3.pubIdNumber, var5.getLocation());
      } else {
         this.mAdManager = new AdManager(var2, "http://my.mobfox.com/request.php", var3.pubIdNumber, true);
      }

      this.mAdManager.setVideoAdsEnabled(true);
      this.mAdManager.setListener(new AdListener() {
         public void adClicked() {
         }

         public void adClosed(Ad var1, boolean var2) {
            if(MobFoxAdapter.this.interstitialListener != null) {
               com.google.a.a.f var4 = MobFoxAdapter.this.interstitialListener;
               MobFoxAdapter var3 = MobFoxAdapter.this;
               var4.g();
            }

         }

         public void adLoadSucceeded(Ad var1) {
            if(MobFoxAdapter.this.interstitialListener != null) {
               com.google.a.a.f var3 = MobFoxAdapter.this.interstitialListener;
               MobFoxAdapter var2 = MobFoxAdapter.this;
               var3.e();
            }

         }

         public void adShown(Ad var1, boolean var2) {
            if(MobFoxAdapter.this.interstitialListener != null) {
               com.google.a.a.f var4 = MobFoxAdapter.this.interstitialListener;
               MobFoxAdapter var3 = MobFoxAdapter.this;
               var4.f();
            }

         }

         public void noAdFound() {
            if(MobFoxAdapter.this.interstitialListener != null) {
               com.google.a.a.f var1 = MobFoxAdapter.this.interstitialListener;
               MobFoxAdapter var2 = MobFoxAdapter.this;
               var1.b(com.google.a.b.b);
            }

         }
      });
      this.mAdManager.requestAd();
   }

   public final void showInterstitial() {
      if(this.mAdManager != null) {
         this.mAdManager.showAd();
      }

   }
}
