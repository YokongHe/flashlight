package com.flurry.sdk;

import java.util.Map;

public class a {
   public final String a;
   public final Map b;
   public final com.flurry.sdk.q c;

   public a(String var1, Map var2, com.flurry.sdk.q var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("action=");
      var1.append(this.a);
      var1.append(",params=");
      var1.append(this.b);
      var1.append(",");
      var1.append(this.c);
      return var1.toString();
   }
}
