package com.smaato.soma.exception;

public class RetrievingReleaseVersionFailed extends Exception {
   private static final long serialVersionUID = 1L;

   public RetrievingReleaseVersionFailed() {
   }

   public RetrievingReleaseVersionFailed(String var1) {
      super(var1);
   }

   public RetrievingReleaseVersionFailed(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RetrievingReleaseVersionFailed(Throwable var1) {
      super(var1);
   }
}
