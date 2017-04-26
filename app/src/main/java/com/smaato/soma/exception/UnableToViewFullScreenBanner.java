package com.smaato.soma.exception;

import com.smaato.soma.exception.UnableToNotifyBannerIdle;

public class UnableToViewFullScreenBanner extends UnableToNotifyBannerIdle {
   private static final long serialVersionUID = 1L;

   public UnableToViewFullScreenBanner() {
   }

   public UnableToViewFullScreenBanner(String var1) {
      super(var1);
   }

   public UnableToViewFullScreenBanner(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnableToViewFullScreenBanner(Throwable var1) {
      super(var1);
   }
}
