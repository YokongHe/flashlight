package org.a.a.g;

public final class g extends org.a.a.g.d {
   private Character d;
   private String e;

   public g(org.a.a.g.i var1, boolean var2, String var3, org.a.a.c.a var4, org.a.a.c.a var5, Character var6) {
      super(var1, var4, var5);
      if(var3 == null) {
         throw new NullPointerException("value in a Node is required.");
      } else {
         this.e = var3;
         this.d = var6;
         this.b = var2;
      }
   }

   public final org.a.a.g.e a() {
      return org.a.a.g.e.a;
   }

   public final String b() {
      return this.e;
   }

   public final String toString() {
      return "<" + this.getClass().getName() + " (tag=" + this.d() + ", value=" + this.e + ")>";
   }
}
