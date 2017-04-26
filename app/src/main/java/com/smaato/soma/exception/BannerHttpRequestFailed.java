package com.smaato.soma.exception;

public class BannerHttpRequestFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public BannerHttpRequestFailed() {
   }

   public BannerHttpRequestFailed(String var1) {
      super(var1);
   }

   public BannerHttpRequestFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public BannerHttpRequestFailed(Throwable var1) {
      super(var1);
   }
}
