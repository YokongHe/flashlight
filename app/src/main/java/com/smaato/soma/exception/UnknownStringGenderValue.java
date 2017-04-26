package com.smaato.soma.exception;

public class UnknownStringGenderValue extends Exception {
   private static final long serialVersionUID = 1L;

   public UnknownStringGenderValue() {
   }

   public UnknownStringGenderValue(String var1) {
      super(var1);
   }

   public UnknownStringGenderValue(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnknownStringGenderValue(Throwable var1) {
      super(var1);
   }
}
