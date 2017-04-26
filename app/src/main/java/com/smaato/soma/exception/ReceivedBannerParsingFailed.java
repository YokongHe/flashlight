package com.smaato.soma.exception;

public class ReceivedBannerParsingFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public ReceivedBannerParsingFailed() {
   }

   public ReceivedBannerParsingFailed(String var1) {
      super(var1);
   }

   public ReceivedBannerParsingFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ReceivedBannerParsingFailed(Throwable var1) {
      super(var1);
   }
}
