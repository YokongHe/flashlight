package com.smaato.soma.exception;

import com.smaato.soma.exception.AdReceiveFailed;

public final class FullScreenBannerFailedToReceiveAd extends AdReceiveFailed {
   private static final long serialVersionUID = 1L;

   public FullScreenBannerFailedToReceiveAd() {
   }

   public FullScreenBannerFailedToReceiveAd(String var1) {
      super(var1);
   }

   public FullScreenBannerFailedToReceiveAd(String var1, Throwable var2) {
      super(var1, var2);
   }

   public FullScreenBannerFailedToReceiveAd(Throwable var1) {
      super(var1);
   }
}
