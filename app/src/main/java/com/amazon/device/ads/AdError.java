package com.amazon.device.ads;

import com.amazon.device.ads.AdError$ErrorCode;

public final class AdError {
   private final AdError$ErrorCode code;
   private final String message;

   AdError(AdError$ErrorCode var1, String var2) {
      this.code = var1;
      this.message = var2;
   }

   public final AdError$ErrorCode getCode() {
      return this.code;
   }

   public final String getMessage() {
      return this.message;
   }
}
