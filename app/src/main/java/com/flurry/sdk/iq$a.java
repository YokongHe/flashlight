package com.flurry.sdk;

import com.flurry.sdk.iq$a$a;

public class iq$a {
   private final iq$a$a a;
   private final String b;

   public iq$a(iq$a$a var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public static iq$a a(String var0) {
      return new iq$a(iq$a$a.a, var0);
   }

   public static iq$a b(String var0) {
      return new iq$a(iq$a$a.b, var0);
   }

   public String a() {
      return this.b;
   }

   public boolean b() {
      return this.a == iq$a$a.a;
   }

   public boolean c() {
      return this.a == iq$a$a.b;
   }
}
