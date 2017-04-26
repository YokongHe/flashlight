package com.smaato.soma.exception;

public class StateBlockedExitFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public StateBlockedExitFailedException() {
   }

   public StateBlockedExitFailedException(String var1) {
      super(var1);
   }

   public StateBlockedExitFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public StateBlockedExitFailedException(Throwable var1) {
      super(var1);
   }
}
