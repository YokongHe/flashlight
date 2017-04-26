package com.smaato.soma.exception;

public class StartingVideoFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public StartingVideoFailedException() {
   }

   public StartingVideoFailedException(String var1) {
      super(var1);
   }

   public StartingVideoFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public StartingVideoFailedException(Throwable var1) {
      super(var1);
   }
}
