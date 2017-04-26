package com.flurry.sdk;

public enum hc {
   a("UTF-8", false),
   b("UTF-16BE", true),
   c("UTF-16LE", false),
   d("UTF-32BE", true),
   e("UTF-32LE", false);

   protected final String f;
   protected final boolean g;

   private hc(String var3, boolean var4) {
      this.f = var3;
      this.g = var4;
   }

   public final String a() {
      return this.f;
   }

   public final boolean b() {
      return this.g;
   }
}
