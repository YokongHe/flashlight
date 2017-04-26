package com.smaato.soma.exception;

public class CheckEmailPermissionFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public CheckEmailPermissionFailed() {
   }

   public CheckEmailPermissionFailed(String var1) {
      super(var1);
   }

   public CheckEmailPermissionFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public CheckEmailPermissionFailed(Throwable var1) {
      super(var1);
   }
}
