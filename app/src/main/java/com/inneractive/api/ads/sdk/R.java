package com.inneractive.api.ads.sdk;

abstract class R {
   abstract String a();

   public String toString() {
      String var1 = this.a();
      return var1 != null?var1.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\\'\\\"]", ""):"";
   }
}
