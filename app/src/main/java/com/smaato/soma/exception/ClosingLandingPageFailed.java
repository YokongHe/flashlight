package com.smaato.soma.exception;

public abstract class ClosingLandingPageFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public ClosingLandingPageFailed() {
   }

   public ClosingLandingPageFailed(String var1) {
      super(var1);
   }

   public ClosingLandingPageFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ClosingLandingPageFailed(Throwable var1) {
      super(var1);
   }
}
