package com.adsdk.sdk.customevents;

import android.content.Context;
import com.adsdk.sdk.customevents.CustomEventNative$CustomEventNativeListener;
import com.adsdk.sdk.nativeads.NativeAd;
import com.adsdk.sdk.nativeads.NativeAd$ImageAsset;
import com.adsdk.sdk.nativeads.NativeAd$Tracker;
import java.util.Locale;

public abstract class CustomEventNative extends NativeAd {
   protected CustomEventNative$CustomEventNativeListener listener;

   protected void addExtraAsset(String var1, String var2) {
      if(var1.toLowerCase(Locale.US).contains("image")) {
         this.addImageAsset(var1, var2);
      } else {
         this.addTextAsset(var1, var2);
      }
   }

   protected void addImageAsset(String var1, String var2) {
      if(var1 != null && var2 != null) {
         this.addImageAsset(var1, new NativeAd$ImageAsset(var2, 0, 0));
      }

   }

   protected void addImpressionTracker(String var1) {
      if(var1 != null && var1.length() > 0) {
         NativeAd$Tracker var2 = new NativeAd$Tracker("impression", var1);
         this.getTrackers().add(var2);
      }

   }

   public abstract void createNativeAd(Context var1, CustomEventNative$CustomEventNativeListener var2, String var3, String var4);

   protected boolean isNativeAdValid(NativeAd var1) {
      NativeAd$ImageAsset var4 = var1.getImageAsset("icon");
      NativeAd$ImageAsset var5 = var1.getImageAsset("main");
      boolean var2;
      if(var4 != null && var5 != null && var4.getBitmap() != null && var5.getBitmap() != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if(var1.getTextAsset("headline") != null && var1.getTextAsset("headline").length() > 0 && var1.getTextAsset("description") != null && var1.getTextAsset("description").length() > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3 && var2;
   }

   public void unregisterListener() {
      this.listener = null;
      super.unregisterListener();
   }
}
