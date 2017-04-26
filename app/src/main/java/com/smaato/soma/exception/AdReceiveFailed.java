package com.smaato.soma.exception;

public class AdReceiveFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public AdReceiveFailed() {
   }

   public AdReceiveFailed(String var1) {
      super(var1);
   }

   public AdReceiveFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public AdReceiveFailed(Throwable var1) {
      super(var1);
   }
}
