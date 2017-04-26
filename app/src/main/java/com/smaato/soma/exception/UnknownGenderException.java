package com.smaato.soma.exception;

public class UnknownGenderException extends Exception {
   private static final long serialVersionUID = 1L;

   public UnknownGenderException() {
   }

   public UnknownGenderException(String var1) {
      super(var1);
   }

   public UnknownGenderException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnknownGenderException(Throwable var1) {
      super(var1);
   }
}
