package com.facebook.ads;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;

public interface AdListener {
   void onAdClicked(Ad var1);

   void onAdLoaded(Ad var1);

   void onError(Ad var1, AdError var2);
}
