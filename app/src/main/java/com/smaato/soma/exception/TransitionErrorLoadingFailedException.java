package com.smaato.soma.exception;

public class TransitionErrorLoadingFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public TransitionErrorLoadingFailedException() {
   }

   public TransitionErrorLoadingFailedException(String var1) {
      super(var1);
   }

   public TransitionErrorLoadingFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public TransitionErrorLoadingFailedException(Throwable var1) {
      super(var1);
   }
}
