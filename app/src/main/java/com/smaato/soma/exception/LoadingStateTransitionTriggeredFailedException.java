package com.smaato.soma.exception;

public class LoadingStateTransitionTriggeredFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public LoadingStateTransitionTriggeredFailedException() {
   }

   public LoadingStateTransitionTriggeredFailedException(String var1) {
      super(var1);
   }

   public LoadingStateTransitionTriggeredFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public LoadingStateTransitionTriggeredFailedException(Throwable var1) {
      super(var1);
   }
}
