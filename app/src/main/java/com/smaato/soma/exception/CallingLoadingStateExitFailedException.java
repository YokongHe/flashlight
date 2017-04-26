package com.smaato.soma.exception;

public class CallingLoadingStateExitFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public CallingLoadingStateExitFailedException() {
   }

   public CallingLoadingStateExitFailedException(String var1) {
      super(var1);
   }

   public CallingLoadingStateExitFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public CallingLoadingStateExitFailedException(Throwable var1) {
      super(var1);
   }
}
