package com.adsdk.sdk.customevents;

import android.content.Context;
import android.view.View;
import com.adsdk.sdk.customevents.CustomEventNative;
import com.adsdk.sdk.customevents.CustomEventNative$CustomEventNativeListener;
import com.mopub.nativeads.MoPubNative$MoPubNativeListener;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.NativeResponse;
import java.util.Iterator;
import java.util.Map.Entry;

public class MoPubNative extends CustomEventNative {
   private MoPubNative$MoPubNativeListener createMoPubNativeListener() {
      return new MoPubNative$MoPubNativeListener() {
         public void onNativeClick(View var1) {
         }

         public void onNativeFail(NativeErrorCode var1) {
            if(MoPubNative.this.listener != null) {
               MoPubNative.this.listener.onCustomEventNativeFailed();
            }

         }

         public void onNativeImpression(View var1) {
         }

         public void onNativeLoad(final NativeResponse var1) {
            (new Thread(new Runnable() {
               public void run() {
                  MoPubNative.this.setClickUrl(var1.getClickDestinationUrl());
                  Iterator var1x;
                  if(var1.getImpressionTrackers() != null) {
                     var1x = var1.getImpressionTrackers().iterator();

                     while(var1x.hasNext()) {
                        String var2 = (String)var1x.next();
                        MoPubNative.this.addImpressionTracker(var2);
                     }
                  }

                  MoPubNative.this.addImageAsset("main", var1.getMainImageUrl());
                  MoPubNative.this.addImageAsset("icon", var1.getIconImageUrl());
                  MoPubNative.this.addTextAsset("cta", var1.getCallToAction());
                  MoPubNative.this.addTextAsset("description", var1.getSubtitle());
                  MoPubNative.this.addTextAsset("headline", var1.getTitle());
                  var1x = var1.getExtras().entrySet().iterator();

                  while(var1x.hasNext()) {
                     Entry var3 = (Entry)var1x.next();
                     if(var3.getValue() != null && var3.getValue() instanceof String) {
                        MoPubNative.this.addExtraAsset((String)var3.getKey(), (String)var3.getValue());
                     }
                  }

                  if(MoPubNative.this.isNativeAdValid(MoPubNative.this)) {
                     if(MoPubNative.this.listener != null) {
                        MoPubNative.this.listener.onCustomEventNativeLoaded(MoPubNative.this);
                     }
                  } else if(MoPubNative.this.listener != null) {
                     MoPubNative.this.listener.onCustomEventNativeFailed();
                     return;
                  }

               }
            })).start();
         }
      };
   }

   public void createNativeAd(Context var1, CustomEventNative$CustomEventNativeListener var2, String var3, String var4) {
      this.listener = var2;

      try {
         Class.forName("com.mopub.nativeads.MoPubNative");
         Class.forName("com.mopub.nativeads.NativeErrorCode");
         Class.forName("com.mopub.nativeads.NativeResponse");
      } catch (ClassNotFoundException var5) {
         if(var2 == null) {
            return;
         }

         var2.onCustomEventNativeFailed();
         return;
      }

      this.addImpressionTracker(var4);
      (new com.mopub.nativeads.MoPubNative(var1, var3, this.createMoPubNativeListener())).makeRequest();
   }
}
