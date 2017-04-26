package com.smaato.soma.exception;

public class LocationManagerFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public LocationManagerFailed() {
   }

   public LocationManagerFailed(String var1) {
      super(var1);
   }

   public LocationManagerFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public LocationManagerFailed(Throwable var1) {
      super(var1);
   }
}
