package com.smaato.soma.exception;

public class BeaconHttpConnectionFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public BeaconHttpConnectionFailed() {
   }

   public BeaconHttpConnectionFailed(String var1) {
      super(var1);
   }

   public BeaconHttpConnectionFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public BeaconHttpConnectionFailed(Throwable var1) {
      super(var1);
   }
}
