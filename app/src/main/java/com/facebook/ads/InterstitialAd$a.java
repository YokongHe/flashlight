package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.ads.InterstitialAd;

class InterstitialAd$a extends BroadcastReceiver {
   // $FF: synthetic field
   final InterstitialAd a;

   private InterstitialAd$a(InterstitialAd var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   InterstitialAd$a(InterstitialAd var1, Object var2) {
      this(var1);
   }

   public void a() {
      IntentFilter var1 = new IntentFilter();
      var1.addAction("com.facebook.ads.interstitial.displayed:" + InterstitialAd.access$1000(this.a));
      var1.addAction("com.facebook.ads.interstitial.dismissed:" + InterstitialAd.access$1000(this.a));
      var1.addAction("com.facebook.ads.interstitial.clicked:" + InterstitialAd.access$1000(this.a));
      var1.addAction("com.facebook.ads.interstitial.impression.logged:" + InterstitialAd.access$1000(this.a));
      LocalBroadcastManager.getInstance(InterstitialAd.access$1100(this.a)).registerReceiver(this, var1);
   }

   public void b() {
      try {
         LocalBroadcastManager.getInstance(InterstitialAd.access$1100(this.a)).unregisterReceiver(this);
      } catch (Exception var2) {
         ;
      }
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction().split(":")[0];
      if(InterstitialAd.access$700(this.a) != null || var3.equals("com.facebook.ads.interstitial.impression.logged")) {
         if("com.facebook.ads.interstitial.clicked".equals(var3)) {
            InterstitialAd.access$700(this.a).onAdClicked(this.a);
            return;
         }

         if("com.facebook.ads.interstitial.dismissed".equals(var3)) {
            InterstitialAd.access$700(this.a).onInterstitialDismissed(this.a);
            return;
         }

         if("com.facebook.ads.interstitial.displayed".equals(var3)) {
            InterstitialAd.access$700(this.a).onInterstitialDisplayed(this.a);
            return;
         }

         if("com.facebook.ads.interstitial.impression.logged".equals(var3) && InterstitialAd.access$900(this.a) != null) {
            InterstitialAd.access$900(this.a).onLoggingImpression(this.a);
            return;
         }
      }

   }
}
