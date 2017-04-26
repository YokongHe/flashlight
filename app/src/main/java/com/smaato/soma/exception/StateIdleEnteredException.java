package com.smaato.soma.exception;

public class StateIdleEnteredException extends Exception {
   private static final long serialVersionUID = 1L;

   public StateIdleEnteredException() {
   }

   public StateIdleEnteredException(String var1) {
      super(var1);
   }

   public StateIdleEnteredException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public StateIdleEnteredException(Throwable var1) {
      super(var1);
   }
}
