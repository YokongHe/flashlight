package com.flurry.sdk;

public enum cn {
   a("unknown"),
   b("streaming"),
   c("progressive");

   private String d;

   private cn(String var3) {
      this.d = var3;
   }

   public static com.flurry.sdk.cn a(String var0) {
      return b.a().equals(var0)?b:(c.a().equals(var0)?c:a);
   }

   public final String a() {
      return this.d;
   }
}
