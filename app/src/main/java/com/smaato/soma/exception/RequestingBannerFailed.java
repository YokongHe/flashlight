package com.smaato.soma.exception;

public class RequestingBannerFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public RequestingBannerFailed() {
   }

   public RequestingBannerFailed(String var1) {
      super(var1);
   }

   public RequestingBannerFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RequestingBannerFailed(Throwable var1) {
      super(var1);
   }
}
