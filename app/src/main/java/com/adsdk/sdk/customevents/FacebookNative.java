package com.adsdk.sdk.customevents;

import android.content.Context;
import android.view.View;
import com.adsdk.sdk.customevents.CustomEventNative;
import com.adsdk.sdk.customevents.CustomEventNative$CustomEventNativeListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd$Rating;

public class FacebookNative extends CustomEventNative {
   private NativeAd facebookNative;

   private AdListener createListener() {
      return new AdListener() {
         public void onAdClicked(Ad var1) {
         }

         public void onAdLoaded(final Ad var1) {
            (new Thread(new Runnable() {
               public void run() {
                  if(FacebookNative.this.facebookNative.equals(var1) && FacebookNative.this.facebookNative.isAdLoaded()) {
                     FacebookNative.this.addTextAsset("headline", FacebookNative.this.facebookNative.getAdTitle());
                     FacebookNative.this.addTextAsset("description", FacebookNative.this.facebookNative.getAdBody());
                     FacebookNative.this.addTextAsset("cta", FacebookNative.this.facebookNative.getAdCallToAction());
                     FacebookNative.this.addTextAsset("rating", FacebookNative.this.readRating(FacebookNative.this.facebookNative.getAdStarRating()));
                     FacebookNative.this.addTextAsset("socialContextForAd", FacebookNative.this.facebookNative.getAdSocialContext());
                     FacebookNative.this.addImageAsset("icon", FacebookNative.this.facebookNative.getAdIcon().getUrl());
                     FacebookNative.this.addImageAsset("main", FacebookNative.this.facebookNative.getAdCoverImage().getUrl());
                     if(!FacebookNative.this.isNativeAdValid(FacebookNative.this)) {
                        FacebookNative.this.listener.onCustomEventNativeFailed();
                        return;
                     }

                     if(FacebookNative.this.listener != null) {
                        FacebookNative.this.listener.onCustomEventNativeLoaded(FacebookNative.this);
                        return;
                     }
                  } else if(FacebookNative.this.listener != null) {
                     FacebookNative.this.listener.onCustomEventNativeFailed();
                  }

               }
            })).start();
         }

         public void onError(Ad var1, AdError var2) {
            if(FacebookNative.this.listener != null) {
               FacebookNative.this.listener.onCustomEventNativeFailed();
            }

         }
      };
   }

   private String readRating(NativeAd$Rating var1) {
      return var1 != null?Integer.toString((int)Math.round(5.0D * var1.getValue() / var1.getScale())):null;
   }

   public void createNativeAd(Context var1, CustomEventNative$CustomEventNativeListener var2, String var3, String var4) {
      this.listener = var2;

      try {
         Class.forName("com.facebook.ads.Ad");
         Class.forName("com.facebook.ads.AdError");
         Class.forName("com.facebook.ads.AdListener");
         Class.forName("com.facebook.ads.NativeAd");
      } catch (ClassNotFoundException var5) {
         if(var2 == null) {
            return;
         }

         var2.onCustomEventNativeFailed();
         return;
      }

      this.addImpressionTracker(var4);
      this.facebookNative = new NativeAd(var1, var3);
      this.facebookNative.setAdListener(this.createListener());
      this.facebookNative.loadAd();
   }

   public void prepareImpression(View var1) {
      this.facebookNative.registerViewForInteraction(var1);
   }
}
