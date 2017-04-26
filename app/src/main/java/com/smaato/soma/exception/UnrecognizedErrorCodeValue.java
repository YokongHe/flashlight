package com.smaato.soma.exception;

public class UnrecognizedErrorCodeValue extends Exception {
   private static final long serialVersionUID = 1L;

   public UnrecognizedErrorCodeValue() {
   }

   public UnrecognizedErrorCodeValue(String var1) {
      super(var1);
   }

   public UnrecognizedErrorCodeValue(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnrecognizedErrorCodeValue(Throwable var1) {
      super(var1);
   }
}
