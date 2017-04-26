package org.a.a.m;

public final class t {
   private final String a;
   private final String b;

   public t(String var1, String var2) {
      if(var2 == null) {
         throw new NullPointerException("Suffix must be provided.");
      } else {
         this.a = var1;
         this.b = var2;
      }
   }

   public final String a() {
      return this.a;
   }

   public final String b() {
      return this.b;
   }
}
