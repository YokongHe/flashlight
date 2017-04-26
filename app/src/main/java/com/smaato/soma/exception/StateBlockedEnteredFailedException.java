package com.smaato.soma.exception;

public class StateBlockedEnteredFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public StateBlockedEnteredFailedException() {
   }

   public StateBlockedEnteredFailedException(String var1) {
      super(var1);
   }

   public StateBlockedEnteredFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public StateBlockedEnteredFailedException(Throwable var1) {
      super(var1);
   }
}
