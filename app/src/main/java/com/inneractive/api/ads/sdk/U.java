package com.inneractive.api.ads.sdk;

final class U extends com.inneractive.api.ads.sdk.R {
   private final int a;
   private final int b;

   private U(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   static com.inneractive.api.ads.sdk.U a(int var0, int var1) {
      return new com.inneractive.api.ads.sdk.U(var0, var1);
   }

   final String a() {
      return "screenSize: { width: " + this.a + ", height: " + this.b + " }";
   }
}
