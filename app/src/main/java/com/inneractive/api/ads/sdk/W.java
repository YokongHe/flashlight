package com.inneractive.api.ads.sdk;

final class W extends com.inneractive.api.ads.sdk.R {
   private boolean a;
   private boolean b;
   private boolean c;
   private boolean d;
   private boolean e;

   final com.inneractive.api.ads.sdk.W a(boolean var1) {
      this.a = var1;
      return this;
   }

   final String a() {
      return "supports: {sms: " + String.valueOf(this.a) + ", tel: " + this.b + ", calendar: " + this.c + ", storePicture: " + this.d + ", inlineVideo: " + this.e + "}";
   }

   final com.inneractive.api.ads.sdk.W b(boolean var1) {
      this.b = var1;
      return this;
   }

   final com.inneractive.api.ads.sdk.W c(boolean var1) {
      this.c = var1;
      return this;
   }

   final com.inneractive.api.ads.sdk.W d(boolean var1) {
      this.d = var1;
      return this;
   }

   final com.inneractive.api.ads.sdk.W e(boolean var1) {
      this.e = var1;
      return this;
   }
}
