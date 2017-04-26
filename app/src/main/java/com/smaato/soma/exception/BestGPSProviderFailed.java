package com.smaato.soma.exception;

public class BestGPSProviderFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public BestGPSProviderFailed() {
   }

   public BestGPSProviderFailed(String var1) {
      super(var1);
   }

   public BestGPSProviderFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public BestGPSProviderFailed(Throwable var1) {
      super(var1);
   }
}
