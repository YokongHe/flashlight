package com.smaato.soma.exception;

public class StartingVideoFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public StartingVideoFailed() {
   }

   public StartingVideoFailed(String var1) {
      super(var1);
   }

   public StartingVideoFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public StartingVideoFailed(Throwable var1) {
      super(var1);
   }
}
