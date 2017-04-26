package com.smaato.soma.exception;

public class ModifyingGPSLocationFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public ModifyingGPSLocationFailed() {
   }

   public ModifyingGPSLocationFailed(String var1) {
      super(var1);
   }

   public ModifyingGPSLocationFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ModifyingGPSLocationFailed(Throwable var1) {
      super(var1);
   }
}
