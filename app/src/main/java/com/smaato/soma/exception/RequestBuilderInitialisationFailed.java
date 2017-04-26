package com.smaato.soma.exception;

public class RequestBuilderInitialisationFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public RequestBuilderInitialisationFailed() {
   }

   public RequestBuilderInitialisationFailed(String var1) {
      super(var1);
   }

   public RequestBuilderInitialisationFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RequestBuilderInitialisationFailed(Throwable var1) {
      super(var1);
   }
}
