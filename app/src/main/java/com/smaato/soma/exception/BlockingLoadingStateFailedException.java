package com.smaato.soma.exception;

public class BlockingLoadingStateFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public BlockingLoadingStateFailedException() {
   }

   public BlockingLoadingStateFailedException(String var1) {
      super(var1);
   }

   public BlockingLoadingStateFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public BlockingLoadingStateFailedException(Throwable var1) {
      super(var1);
   }
}
