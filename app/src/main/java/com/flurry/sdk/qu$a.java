package com.flurry.sdk;

import java.util.StringTokenizer;

final class qu$a extends StringTokenizer {
   protected final String a;
   protected int b;
   protected String c;

   public qu$a(String var1) {
      super(var1, "<,>", true);
      this.a = var1;
   }

   public final String a() {
      return this.a;
   }

   public final void a(String var1) {
      this.c = var1;
      this.b -= var1.length();
   }

   public final String b() {
      return this.a.substring(this.b);
   }

   public final boolean hasMoreTokens() {
      return this.c != null || super.hasMoreTokens();
   }

   public final String nextToken() {
      String var1;
      if(this.c != null) {
         var1 = this.c;
         this.c = null;
      } else {
         var1 = super.nextToken();
      }

      this.b += var1.length();
      return var1;
   }
}
