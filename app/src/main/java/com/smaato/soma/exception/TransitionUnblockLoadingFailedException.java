package com.smaato.soma.exception;

public class TransitionUnblockLoadingFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public TransitionUnblockLoadingFailedException() {
   }

   public TransitionUnblockLoadingFailedException(String var1) {
      super(var1);
   }

   public TransitionUnblockLoadingFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public TransitionUnblockLoadingFailedException(Throwable var1) {
      super(var1);
   }
}
