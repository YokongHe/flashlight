package com.mopub.mobileads.dfp.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.dfp.adapters.MoPubAdapter$MBannerListener;
import com.mopub.mobileads.dfp.adapters.MoPubAdapter$mMediationInterstitialListener;
import com.mopub.mobileads.dfp.adapters.MoPubExtras;
import com.mopub.mobileads.dfp.adapters.MoPubServerParameters;

public final class MoPubAdapter implements com.google.a.a.c, com.google.a.a.e {
   private static final String MOPUB_NATIVE_CEVENT_VERSION = "tp=dfp_custom_1.0";
   private MoPubInterstitial mMoPubInterstitial;
   private MoPubView mMoPubView;

   private String getKeywords(com.google.a.a.a var1) {
      StringBuilder var3 = (new StringBuilder()).append("tp=dfp_custom_1.0");
      String var2;
      if(var1.a() != null) {
         var2 = ",m_birthday:" + var1.a();
      } else {
         var2 = "";
      }

      StringBuilder var5 = var3.append(var2);
      String var4;
      if(var1.b() != null) {
         var4 = ",m_gender:" + var1.b();
      } else {
         var4 = "";
      }

      return var5.append(var4).toString();
   }

   public final void destroy() {
      if(this.mMoPubView != null) {
         this.mMoPubView.destroy();
         this.mMoPubView = null;
      }

      if(this.mMoPubInterstitial != null) {
         this.mMoPubInterstitial.destroy();
         this.mMoPubInterstitial = null;
      }

   }

   public final Class getAdditionalParametersType() {
      return MoPubExtras.class;
   }

   public final View getBannerView() {
      return this.mMoPubView;
   }

   public final Class getServerParametersType() {
      return MoPubServerParameters.class;
   }

   public final void requestBannerAd(com.google.a.a.d var1, Activity var2, MoPubServerParameters var3, com.google.a.d var4, com.google.a.a.a var5, MoPubExtras var6) {
      this.mMoPubView = new MoPubView(var2);
      this.mMoPubView.setBannerAdListener(new MoPubAdapter$MBannerListener(this, var1));
      this.mMoPubView.setAdUnitId(var3.adUnitId);
      if(var5.d()) {
         this.mMoPubView.setTesting(true);
      }

      if(var5.c() != null) {
         this.mMoPubView.setLocation(var5.c());
      }

      this.mMoPubView.setKeywords(this.getKeywords(var5));
      this.mMoPubView.loadAd();
   }

   public final void requestInterstitialAd(com.google.a.a.f var1, Activity var2, MoPubServerParameters var3, com.google.a.a.a var4, MoPubExtras var5) {
      this.mMoPubInterstitial = new MoPubInterstitial(var2, var3.adUnitId);
      this.mMoPubInterstitial.setInterstitialAdListener(new MoPubAdapter$mMediationInterstitialListener(this, var1));
      if(var4.d()) {
         this.mMoPubInterstitial.setTesting(true);
      }

      this.mMoPubInterstitial.setKeywords(this.getKeywords(var4));
      this.mMoPubInterstitial.load();
   }

   public final void showInterstitial() {
      if(this.mMoPubInterstitial.isReady()) {
         this.mMoPubInterstitial.show();
      } else {
         Log.d("Mopub", "Interstitial was not ready. Unable to load the interstitial");
      }
   }
}
