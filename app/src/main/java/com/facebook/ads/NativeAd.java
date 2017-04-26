package com.facebook.ads;

import android.content.Context;
import android.widget.ImageView;
import com.facebook.ads.AdSize;
import com.facebook.ads.NativeAd$Image;

public class NativeAd extends com.facebook.ads.a.ac {
   private volatile boolean loadRequested;

   public NativeAd(Context var1, String var2) {
      super(var1, var2, AdSize.INTERSTITIAL, com.facebook.ads.a.n.i, false);
   }

   public static void downloadAndDisplayImage(NativeAd$Image var0, ImageView var1) {
      (new com.facebook.ads.a.w(var1)).execute(new String[]{var0.getUrl()});
   }

   public void loadAd() {
      if(this.loadRequested) {
         IllegalStateException var1 = new IllegalStateException("Ad already loaded");
         com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(var1));
         throw var1;
      } else {
         this.loadRequested = true;
         super.loadAd();
      }
   }
}
