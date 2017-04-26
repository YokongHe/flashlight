package com.smaato.soma.exception;

public class UnknownBannerStatusException extends Exception {
   private static final long serialVersionUID = 1L;

   public UnknownBannerStatusException() {
   }

   public UnknownBannerStatusException(String var1) {
      super(var1);
   }

   public UnknownBannerStatusException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnknownBannerStatusException(Throwable var1) {
      super(var1);
   }
}
