package com.adsdk.sdk;

public class RequestException extends Exception {
   private static final long serialVersionUID = 1L;

   public RequestException() {
   }

   public RequestException(String var1) {
      super(var1);
   }

   public RequestException(String var1, Throwable var2) {
      super(var1, var2);
   }

   public RequestException(Throwable var1) {
      super(var1);
   }
}
