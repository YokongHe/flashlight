package com.smaato.soma.exception;

public class UnrecognizedStringErrorCodeValue extends Exception {
   private static final long serialVersionUID = 1L;

   public UnrecognizedStringErrorCodeValue() {
   }

   public UnrecognizedStringErrorCodeValue(String var1) {
      super(var1);
   }

   public UnrecognizedStringErrorCodeValue(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnrecognizedStringErrorCodeValue(Throwable var1) {
      super(var1);
   }
}
