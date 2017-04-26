package com.amazon.device.ads;

import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.MetricsCollector;

class AdSlot {
   private final AdController adController;
   private AdError adError;
   private final AdTargetingOptions adOptions;
   private boolean deferredLoad = false;
   private int slotNumber;

   AdSlot(AdController var1, AdTargetingOptions var2) {
      this.adController = var1;
      if(var2 == null) {
         this.adOptions = new AdTargetingOptions();
      } else {
         this.adOptions = var2;
      }
   }

   void adFailed(AdError var1) {
      this.adController.adFailed(var1);
   }

   AdError getAdError() {
      return this.adError;
   }

   public AdTargetingOptions getAdTargetingOptions() {
      return this.adOptions;
   }

   String getMaxSize() {
      return this.adController.getMaxSize();
   }

   MetricsCollector getMetricsCollector() {
      return this.adController.getMetricsCollector();
   }

   public AdSize getRequestedAdSize() {
      return this.adController.getAdSize();
   }

   int getSlotNumber() {
      return this.slotNumber;
   }

   void initializeAd() {
      this.adController.initialize();
   }

   boolean isFetched() {
      return this.adController.getAdData() != null && this.adController.getAdData().getIsFetched();
   }

   boolean isValid() {
      return this.adController.isValid();
   }

   boolean prepareForAdLoad(long var1) {
      return this.adController.prepareForAdLoad(var1, this.deferredLoad);
   }

   void setAdData(AdData var1) {
      this.adController.setAdData(var1);
   }

   void setAdError(AdError var1) {
      this.adError = var1;
   }

   void setConnectionInfo(ConnectionInfo var1) {
      this.adController.setConnectionInfo(var1);
   }

   public AdSlot setDeferredLoad(boolean var1) {
      this.deferredLoad = var1;
      return this;
   }

   void setSlotNumber(int var1) {
      this.slotNumber = var1;
   }
}
