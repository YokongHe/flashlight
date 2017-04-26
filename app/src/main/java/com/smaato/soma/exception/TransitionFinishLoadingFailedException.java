package com.smaato.soma.exception;

public class TransitionFinishLoadingFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public TransitionFinishLoadingFailedException() {
   }

   public TransitionFinishLoadingFailedException(String var1) {
      super(var1);
   }

   public TransitionFinishLoadingFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public TransitionFinishLoadingFailedException(Throwable var1) {
      super(var1);
   }
}
