package com.smaato.soma.exception;

public class UnblockingLoadingStateFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public UnblockingLoadingStateFailedException() {
   }

   public UnblockingLoadingStateFailedException(String var1) {
      super(var1);
   }

   public UnblockingLoadingStateFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnblockingLoadingStateFailedException(Throwable var1) {
      super(var1);
   }
}
