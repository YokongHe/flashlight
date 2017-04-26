package com.smaato.soma.exception;

public class RegisterClickFailed extends Exception {
   public RegisterClickFailed() {
   }

   public RegisterClickFailed(String var1) {
      super(var1);
   }

   public RegisterClickFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RegisterClickFailed(Throwable var1) {
      super(var1);
   }
}
