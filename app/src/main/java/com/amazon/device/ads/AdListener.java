package com.amazon.device.ads;

import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;

public interface AdListener {
   void onAdCollapsed(Ad var1);

   void onAdDismissed(Ad var1);

   void onAdExpanded(Ad var1);

   void onAdFailedToLoad(Ad var1, AdError var2);

   void onAdLoaded(Ad var1, AdProperties var2);
}
