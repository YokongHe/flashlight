package com.smaato.soma.exception;

public class BeaconLoadFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public BeaconLoadFailedException() {
   }

   public BeaconLoadFailedException(String var1) {
      super(var1);
   }

   public BeaconLoadFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public BeaconLoadFailedException(Throwable var1) {
      super(var1);
   }
}
