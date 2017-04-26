package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAdefines$IAintegratedSdksTrackingAction;

final class am extends com.inneractive.api.ads.sdk.p {
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private String f;
   private String g;

   final com.inneractive.api.ads.sdk.am a(boolean var1) {
      if(var1) {
         Boolean.toString(var1);
      }

      return this;
   }

   final String a(String var1) {
      return null;
   }

   final String a(String var1, IAdefines$IAintegratedSdksTrackingAction var2) {
      this.f(var1);
      this.a("aid", this.a);
      this.a("sessionId", this.b);
      if(var2.equals(IAdefines$IAintegratedSdksTrackingAction.a)) {
         this.a("action", IAdefines$IAintegratedSdksTrackingAction.a.c);
         this.a("sdk", this.e);
         this.a("type", this.d);
         this.a("failedSdks", this.c);
      } else if(var2.equals(IAdefines$IAintegratedSdksTrackingAction.b)) {
         this.a("action", IAdefines$IAintegratedSdksTrackingAction.b.c);
         this.a("sdk", this.f);
         this.a("type", this.g);
      }

      return this.a();
   }

   final com.inneractive.api.ads.sdk.am b() {
      if("IA".equals(this.e)) {
         this.d = "house";
      } else if("MM".equals(this.e)) {
         this.d = "paying";
         return this;
      }

      return this;
   }

   final com.inneractive.api.ads.sdk.am b(String var1) {
      this.a = var1;
      return this;
   }

   final com.inneractive.api.ads.sdk.am c(String var1) {
      this.b = var1;
      return this;
   }

   final com.inneractive.api.ads.sdk.am d(String var1) {
      this.e = var1;
      return this;
   }

   final com.inneractive.api.ads.sdk.am e(String var1) {
      this.g = var1;
      return this;
   }

   final com.inneractive.api.ads.sdk.am g(String var1) {
      this.c = var1;
      return this;
   }

   final com.inneractive.api.ads.sdk.am h(String var1) {
      this.f = var1;
      return this;
   }
}
