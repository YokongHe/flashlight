package com.smaato.soma.exception;

import com.smaato.soma.exception.AdReceiveFailed;

public final class AlertBannerFailedToRecieveAd extends AdReceiveFailed {
   private static final long serialVersionUID = 1L;

   public AlertBannerFailedToRecieveAd() {
   }

   public AlertBannerFailedToRecieveAd(String var1) {
      super(var1);
   }

   public AlertBannerFailedToRecieveAd(String var1, Throwable var2) {
      super(var1, var2);
   }

   public AlertBannerFailedToRecieveAd(Throwable var1) {
      super(var1);
   }
}
