package com.smaato.soma.exception;

public class BannerLoadingExitFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public BannerLoadingExitFailedException() {
   }

   public BannerLoadingExitFailedException(String var1) {
      super(var1);
   }

   public BannerLoadingExitFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public BannerLoadingExitFailedException(Throwable var1) {
      super(var1);
   }
}
