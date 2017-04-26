package com.smaato.soma.exception;

public class StateIdleExitFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public StateIdleExitFailedException() {
   }

   public StateIdleExitFailedException(String var1) {
      super(var1);
   }

   public StateIdleExitFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public StateIdleExitFailedException(Throwable var1) {
      super(var1);
   }
}
