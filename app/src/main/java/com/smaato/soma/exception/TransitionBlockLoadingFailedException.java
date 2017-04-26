package com.smaato.soma.exception;

public class TransitionBlockLoadingFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public TransitionBlockLoadingFailedException() {
   }

   public TransitionBlockLoadingFailedException(String var1) {
      super(var1);
   }

   public TransitionBlockLoadingFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public TransitionBlockLoadingFailedException(Throwable var1) {
      super(var1);
   }
}