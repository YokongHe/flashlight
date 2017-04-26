package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;
import java.util.Collections;

public class bo extends com.flurry.sdk.ba implements InterstitialAdListener {
   private static final String b = com.flurry.sdk.bo.class.getSimpleName();
   private final String c;
   private final String d;
   private final boolean e;
   private InterstitialAd f;

   public bo(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, Bundle var5) {
      super(var1, var2, var3, var4);
      this.c = var5.getString("com.flurry.fan.MY_APP_ID");
      this.d = var5.getString("com.flurry.fan.MYTEST_AD_DEVICE_ID");
      this.e = var5.getBoolean("com.flurry.fan.test");
   }

   public void a() {
      Context var1 = this.b();
      if(this.e) {
         AdSettings.addTestDevice(this.d);
      }

      this.f = new InterstitialAd(var1, this.c);
      this.f.setAdListener(this);
      this.f.loadAd();
   }

   public void onAdClicked(Ad var1) {
      eo.a(4, b, "FAN interstitial onAdClicked.");
      this.b(Collections.emptyMap());
   }

   public void onAdLoaded(Ad var1) {
      eo.a(4, b, "FAN interstitial onAdLoaded.");
      if(this.f != null && this.f.isAdLoaded()) {
         this.f.show();
      }

   }

   public void onError(Ad var1, AdError var2) {
      eo.a(4, b, "FAN interstitial onError.");
      this.d(Collections.emptyMap());
      this.f.destroy();
      this.f = null;
   }

   public void onInterstitialDismissed(Ad var1) {
      eo.a(4, b, "FAN interstitial onInterstitialDismissed.");
      this.c(Collections.emptyMap());
   }

   public void onInterstitialDisplayed(Ad var1) {
      eo.a(4, b, "FAN interstitial onInterstitialDisplayed.");
      this.a(Collections.emptyMap());
   }
}
