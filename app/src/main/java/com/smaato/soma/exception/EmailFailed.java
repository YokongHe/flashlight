package com.smaato.soma.exception;

public class EmailFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public EmailFailed() {
   }

   public EmailFailed(String var1) {
      super(var1);
   }

   public EmailFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public EmailFailed(Throwable var1) {
      super(var1);
   }
}
