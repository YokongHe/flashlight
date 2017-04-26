package com.smaato.soma.exception;

public class UserSettingsNotFoundException extends Exception {
   private static final long serialVersionUID = 1L;

   public UserSettingsNotFoundException() {
   }

   public UserSettingsNotFoundException(String var1) {
      super(var1);
   }

   public UserSettingsNotFoundException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public UserSettingsNotFoundException(Throwable var1) {
      super(var1);
   }
}
