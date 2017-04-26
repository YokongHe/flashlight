package com.facebook.ads;

import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;

public interface InterstitialAdListener extends AdListener {
   void onInterstitialDismissed(Ad var1);

   void onInterstitialDisplayed(Ad var1);
}
