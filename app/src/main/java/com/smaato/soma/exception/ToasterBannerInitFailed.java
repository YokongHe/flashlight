package com.smaato.soma.exception;

public class ToasterBannerInitFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public ToasterBannerInitFailed() {
   }

   public ToasterBannerInitFailed(String var1) {
      super(var1);
   }

   public ToasterBannerInitFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ToasterBannerInitFailed(Throwable var1) {
      super(var1);
   }
}
