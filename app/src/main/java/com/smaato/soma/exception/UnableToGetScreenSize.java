package com.smaato.soma.exception;

public class UnableToGetScreenSize extends Exception {
   private static final long serialVersionUID = 1L;

   public UnableToGetScreenSize() {
   }

   public UnableToGetScreenSize(String var1) {
      super(var1);
   }

   public UnableToGetScreenSize(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UnableToGetScreenSize(Throwable var1) {
      super(var1);
   }
}
