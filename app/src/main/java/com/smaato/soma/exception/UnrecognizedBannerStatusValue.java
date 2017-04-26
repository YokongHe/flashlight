package com.smaato.soma.exception;

public class UnrecognizedBannerStatusValue extends Exception {
   private static final long serialVersionUID = 1L;

   public UnrecognizedBannerStatusValue() {
   }

   public UnrecognizedBannerStatusValue(String var1) {
      super(var1);
   }

   public UnrecognizedBannerStatusValue(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnrecognizedBannerStatusValue(Throwable var1) {
      super(var1);
   }
}
