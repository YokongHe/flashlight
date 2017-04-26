package com.smaato.soma.exception;

public class RetrievingSDKVersionFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public RetrievingSDKVersionFailed() {
   }

   public RetrievingSDKVersionFailed(String var1) {
      super(var1);
   }

   public RetrievingSDKVersionFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RetrievingSDKVersionFailed(Throwable var1) {
      super(var1);
   }
}
