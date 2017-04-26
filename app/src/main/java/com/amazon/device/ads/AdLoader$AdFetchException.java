package com.amazon.device.ads;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLoader;

public class AdLoader$AdFetchException extends Exception {
   private static final long serialVersionUID = 1L;
   private final AdError adError;
   // $FF: synthetic field
   final AdLoader this$0;

   public AdLoader$AdFetchException(AdLoader var1, AdError var2) {
      this.this$0 = var1;
      this.adError = var2;
   }

   public AdLoader$AdFetchException(AdLoader var1, AdError var2, Throwable var3) {
      super(var3);
      this.this$0 = var1;
      this.adError = var2;
   }

   public AdError getAdError() {
      return this.adError;
   }
}
