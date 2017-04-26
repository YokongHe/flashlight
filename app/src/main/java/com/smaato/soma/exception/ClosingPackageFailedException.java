package com.smaato.soma.exception;

public class ClosingPackageFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public ClosingPackageFailedException() {
   }

   public ClosingPackageFailedException(String var1) {
      super(var1);
   }

   public ClosingPackageFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ClosingPackageFailedException(Throwable var1) {
      super(var1);
   }
}
