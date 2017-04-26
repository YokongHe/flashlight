package com.smaato.soma.exception;

public class LoadingBeaconFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public LoadingBeaconFailed() {
   }

   public LoadingBeaconFailed(String var1) {
      super(var1);
   }

   public LoadingBeaconFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public LoadingBeaconFailed(Throwable var1) {
      super(var1);
   }
}
