package com.smaato.soma.exception;

public class UnableToExitEmptyState extends Exception {
   private static final long serialVersionUID = 1L;

   public UnableToExitEmptyState() {
   }

   public UnableToExitEmptyState(String var1) {
      super(var1);
   }

   public UnableToExitEmptyState(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnableToExitEmptyState(Throwable var1) {
      super(var1);
   }
}
