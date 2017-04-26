package com.smaato.soma.exception;

public class LoadingStateLoggingFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public LoadingStateLoggingFailedException() {
   }

   public LoadingStateLoggingFailedException(String var1) {
      super(var1);
   }

   public LoadingStateLoggingFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public LoadingStateLoggingFailedException(Throwable var1) {
      super(var1);
   }
}
