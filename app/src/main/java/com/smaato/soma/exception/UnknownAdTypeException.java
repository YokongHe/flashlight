package com.smaato.soma.exception;

public class UnknownAdTypeException extends Exception {
   private static final long serialVersionUID = 1L;

   public UnknownAdTypeException() {
   }

   public UnknownAdTypeException(String var1) {
      super(var1);
   }

   public UnknownAdTypeException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnknownAdTypeException(Throwable var1) {
      super(var1);
   }
}
