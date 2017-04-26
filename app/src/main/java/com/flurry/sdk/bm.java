package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.eo;
import java.util.Collections;

public class bm extends AdNetworkView implements AdListener {
   private static final String a = com.flurry.sdk.bm.class.getSimpleName();
   private final String b;
   private final String c;
   private final boolean d;
   private AdView e;

   public bm(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4, Bundle var5) {
      super(var1, var2, var3, var4);
      this.b = var5.getString("com.flurry.fan.MY_APP_ID");
      this.c = var5.getString("com.flurry.fan.MYTEST_AD_DEVICE_ID");
      this.d = var5.getBoolean("com.flurry.fan.test");
      this.setFocusable(true);
   }

   public void initLayout() {
      eo.a(4, a, "FAN banner initLayout.");
      this.e = new AdView(this.getContext(), this.b, AdSize.BANNER_320_50);
      this.e.setAdListener(this);
      this.addView(this.e);
      if(this.d) {
         AdSettings.addTestDevice(this.c);
      }

      this.e.loadAd();
   }

   public void onAdClicked(Ad var1) {
      eo.a(4, a, "FAN banner onAdClicked.");
      this.onAdClicked(Collections.emptyMap());
   }

   public void onAdLoaded(Ad var1) {
      this.onAdShown(Collections.emptyMap());
      eo.a(4, a, "FAN banner onAdLoaded.");
   }

   public void onDestroy() {
      eo.a(4, a, "FAN banner onDestroy.");
      if(this.e != null) {
         this.e.destroy();
         this.e = null;
      }

      super.onDestroy();
   }

   public void onError(Ad var1, AdError var2) {
      this.onRenderFailed(Collections.emptyMap());
      if(this.e != null) {
         this.e.destroy();
         this.e = null;
      }

      eo.a(6, a, "FAN banner onError.");
   }
}
