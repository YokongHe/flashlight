package com.inneractive.api.ads.sdk;

final class Q extends com.inneractive.api.ads.sdk.R {
   private final int a;
   private final int b;

   private Q(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   static com.inneractive.api.ads.sdk.Q a(int var0, int var1) {
      return new com.inneractive.api.ads.sdk.Q(var0, var1);
   }

   final String a() {
      return "adSize: { width: " + this.a + ", height: " + this.b + " }";
   }
}
