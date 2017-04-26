package com.smaato.soma.exception;

public class PageRedirectionFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public PageRedirectionFailed() {
   }

   public PageRedirectionFailed(String var1) {
      super(var1);
   }

   public PageRedirectionFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public PageRedirectionFailed(Throwable var1) {
      super(var1);
   }
}
