package com.amazon.device.ads;

import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdTargetingOptions;

public interface Ad {
   int getTimeout();

   boolean isLoading();

   boolean loadAd();

   boolean loadAd(AdTargetingOptions var1);

   void setListener(AdListener var1);

   void setTimeout(int var1);
}
