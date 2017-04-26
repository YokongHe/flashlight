package com.smaato.soma.exception;

public class RetrievingDeviceBrandFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public RetrievingDeviceBrandFailed() {
   }

   public RetrievingDeviceBrandFailed(String var1) {
      super(var1);
   }

   public RetrievingDeviceBrandFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RetrievingDeviceBrandFailed(Throwable var1) {
      super(var1);
   }
}
