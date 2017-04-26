package com.smaato.soma.exception;

public class RetrievingDeviceModelFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public RetrievingDeviceModelFailed() {
   }

   public RetrievingDeviceModelFailed(String var1) {
      super(var1);
   }

   public RetrievingDeviceModelFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RetrievingDeviceModelFailed(Throwable var1) {
      super(var1);
   }
}
