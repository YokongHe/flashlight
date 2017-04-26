package com.smaato.soma.exception;

public class ExpandingBannerFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public ExpandingBannerFailed() {
   }

   public ExpandingBannerFailed(String var1) {
      super(var1);
   }

   public ExpandingBannerFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ExpandingBannerFailed(Throwable var1) {
      super(var1);
   }
}
