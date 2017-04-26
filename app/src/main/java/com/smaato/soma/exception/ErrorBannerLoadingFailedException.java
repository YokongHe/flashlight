package com.smaato.soma.exception;

public class ErrorBannerLoadingFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public ErrorBannerLoadingFailedException() {
   }

   public ErrorBannerLoadingFailedException(String var1) {
      super(var1);
   }

   public ErrorBannerLoadingFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ErrorBannerLoadingFailedException(Throwable var1) {
      super(var1);
   }
}
