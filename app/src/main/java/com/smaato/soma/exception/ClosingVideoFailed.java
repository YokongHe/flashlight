package com.smaato.soma.exception;

public class ClosingVideoFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public ClosingVideoFailed() {
   }

   public ClosingVideoFailed(String var1) {
      super(var1);
   }

   public ClosingVideoFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ClosingVideoFailed(Throwable var1) {
      super(var1);
   }
}
