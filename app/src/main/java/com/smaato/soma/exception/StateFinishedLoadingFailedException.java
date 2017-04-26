package com.smaato.soma.exception;

public class StateFinishedLoadingFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public StateFinishedLoadingFailedException() {
   }

   public StateFinishedLoadingFailedException(String var1) {
      super(var1);
   }

   public StateFinishedLoadingFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public StateFinishedLoadingFailedException(Throwable var1) {
      super(var1);
   }
}
