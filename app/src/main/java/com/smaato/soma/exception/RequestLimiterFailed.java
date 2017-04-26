package com.smaato.soma.exception;

public class RequestLimiterFailed extends Exception {
   public RequestLimiterFailed() {
   }

   public RequestLimiterFailed(String var1) {
      super(var1);
   }

   public RequestLimiterFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RequestLimiterFailed(Throwable var1) {
      super(var1);
   }
}
