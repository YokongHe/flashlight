package com.inneractive.api.ads.sdk;

final class X extends com.inneractive.api.ads.sdk.R {
   private final boolean a;

   private X(boolean var1) {
      this.a = var1;
   }

   static com.inneractive.api.ads.sdk.X a(boolean var0) {
      return new com.inneractive.api.ads.sdk.X(var0);
   }

   final String a() {
      StringBuilder var2 = new StringBuilder("viewable: ");
      String var1;
      if(this.a) {
         var1 = "true";
      } else {
         var1 = "false";
      }

      return var2.append(var1).toString();
   }
}
