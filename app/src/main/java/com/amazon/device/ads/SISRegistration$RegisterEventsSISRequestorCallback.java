package com.amazon.device.ads;

import com.amazon.device.ads.SISRegistration;
import com.amazon.device.ads.SISRequestorCallback;

public class SISRegistration$RegisterEventsSISRequestorCallback implements SISRequestorCallback {
   private final SISRegistration sisRegistration;

   public SISRegistration$RegisterEventsSISRequestorCallback(SISRegistration var1) {
      this.sisRegistration = var1;
   }

   public void onSISCallComplete() {
      this.sisRegistration.registerEvents();
   }
}
