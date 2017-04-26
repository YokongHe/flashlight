package com.smaato.soma.exception;

public class AdRequestConstructionFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public AdRequestConstructionFailed() {
   }

   public AdRequestConstructionFailed(String var1) {
      super(var1);
   }

   public AdRequestConstructionFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public AdRequestConstructionFailed(Throwable var1) {
      super(var1);
   }
}
