package com.amazon.device.ads;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdProperties;

interface AdControlCallback {
   int CLOSE_EVENT_ONLY = 0;
   int CLOSE_FULL = 1;
   int NO_CLOSE = 2;

   int adClosing();

   boolean isAdReady(boolean var1);

   void onAdEvent(AdEvent var1);

   void onAdFailed(AdError var1);

   void onAdLoaded(AdProperties var1);

   void onAdRendered();

   void postAdRendered();
}
