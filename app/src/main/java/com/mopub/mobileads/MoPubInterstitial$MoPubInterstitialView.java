package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import java.util.Map;

public class MoPubInterstitial$MoPubInterstitialView extends MoPubView {
   // $FF: synthetic field
   final MoPubInterstitial this$0;

   public MoPubInterstitial$MoPubInterstitialView(MoPubInterstitial var1, Context var2) {
      super(var2);
      this.this$0 = var1;
      this.setAutorefreshEnabled(false);
   }

   protected void adFailed(MoPubErrorCode var1) {
      if(MoPubInterstitial.access$2(this.this$0) != null) {
         MoPubInterstitial.access$2(this.this$0).onInterstitialFailed(this.this$0, var1);
      }

   }

   public AdFormat getAdFormat() {
      return AdFormat.INTERSTITIAL;
   }

   protected void loadCustomEvent(String var1, Map var2) {
      if(this.mAdViewController != null) {
         if(TextUtils.isEmpty(var1)) {
            MoPubLog.d("Couldn\'t invoke custom event because the server did not specify one.");
            this.loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
         } else {
            if(MoPubInterstitial.access$0(this.this$0) != null) {
               MoPubInterstitial.access$0(this.this$0).invalidate();
            }

            MoPubLog.d("Loading custom event interstitial adapter.");
            MoPubInterstitial.access$1(this.this$0, CustomEventInterstitialAdapterFactory.create(this.this$0, var1, var2, this.mAdViewController.getBroadcastIdentifier(), this.mAdViewController.getAdReport()));
            MoPubInterstitial.access$0(this.this$0).setAdapterListener(this.this$0);
            MoPubInterstitial.access$0(this.this$0).loadInterstitial();
         }
      }
   }

   protected void trackImpression() {
      MoPubLog.d("Tracking impression for interstitial.");
      if(this.mAdViewController != null) {
         this.mAdViewController.trackImpression();
      }

   }
}
