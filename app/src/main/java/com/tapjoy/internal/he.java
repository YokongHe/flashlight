package com.tapjoy.internal;

public final class he {
   final String a;
   final String b;

   he(String var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.a);
      var1.append(": ");
      var1.append(this.b);
      return var1.toString();
   }
}
