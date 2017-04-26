package com.inneractive.api.ads.sdk;

final class S extends com.inneractive.api.ads.sdk.R {
   private final int a;
   private final int b;

   private S(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   static com.inneractive.api.ads.sdk.S a(int var0, int var1) {
      return new com.inneractive.api.ads.sdk.S(var0, var1);
   }

   final String a() {
      return "maxSize: { width: " + this.a + ", height: " + this.b + " }";
   }
}
