package com.smaato.soma.exception;

public class CallingLoadingStateEnteredFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public CallingLoadingStateEnteredFailedException() {
   }

   public CallingLoadingStateEnteredFailedException(String var1) {
      super(var1);
   }

   public CallingLoadingStateEnteredFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public CallingLoadingStateEnteredFailedException(Throwable var1) {
      super(var1);
   }
}
