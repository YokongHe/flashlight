package org.a.a.m;

public abstract class u {
   private final org.a.a.c.a a;
   private final org.a.a.c.a b;

   public u(org.a.a.c.a var1, org.a.a.c.a var2) {
      if(var1 != null && var2 != null) {
         this.a = var1;
         this.b = var2;
      } else {
         throw new org.a.a.c.c("Token requires marks.");
      }
   }

   protected String b() {
      return "";
   }

   public abstract org.a.a.m.v c();

   public boolean equals(Object var1) {
      return var1 instanceof u?this.toString().equals(var1.toString()):false;
   }

   public final org.a.a.c.a f() {
      return this.a;
   }

   public final org.a.a.c.a g() {
      return this.b;
   }

   public int hashCode() {
      return this.toString().hashCode();
   }

   public String toString() {
      return "<" + this.getClass().getName() + "(" + this.b() + ")>";
   }
}
