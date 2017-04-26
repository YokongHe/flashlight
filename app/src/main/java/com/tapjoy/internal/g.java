package com.tapjoy.internal;

public final class g {
   public String a;
   public String b;
   public String c;
   public String d;
   public String e;
   public String f;
   public long g;

   public g(String var1) {
      com.tapjoy.internal.bt var3 = com.tapjoy.internal.bt.b(var1);
      var3.i();

      while(var3.k()) {
         String var2 = var3.m();
         if("productId".equals(var2)) {
            this.a = var3.n();
         } else if("type".equals(var2)) {
            this.b = var3.n();
         } else if("price".equals(var2)) {
            this.c = var3.n();
         } else if("title".equals(var2)) {
            this.d = var3.n();
         } else if("description".equals(var2)) {
            this.e = var3.n();
         } else if("price_currency_code".equals(var2)) {
            this.f = var3.n();
         } else if("price_amount_micros".equals(var2)) {
            this.g = var3.r();
         } else {
            var3.t();
         }
      }

      var3.j();
   }
}
