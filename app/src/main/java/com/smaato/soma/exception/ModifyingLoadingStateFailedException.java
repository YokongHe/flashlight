package com.smaato.soma.exception;

public class ModifyingLoadingStateFailedException extends Exception {
   private static final long serialVersionUID = 1L;

   public ModifyingLoadingStateFailedException() {
   }

   public ModifyingLoadingStateFailedException(String var1) {
      super(var1);
   }

   public ModifyingLoadingStateFailedException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public ModifyingLoadingStateFailedException(Throwable var1) {
      super(var1);
   }
}
