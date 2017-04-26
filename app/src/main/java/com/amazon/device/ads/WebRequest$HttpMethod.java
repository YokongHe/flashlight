package com.amazon.device.ads;

public enum WebRequest$HttpMethod {
   GET("GET"),
   POST("POST");

   private final String methodString;

   private WebRequest$HttpMethod(String var3) {
      this.methodString = var3;
   }

   public final String toString() {
      return this.methodString;
   }
}
