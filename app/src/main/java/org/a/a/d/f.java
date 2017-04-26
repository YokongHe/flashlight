package org.a.a.d;

public abstract class f {
   private final org.a.a.c.a a;
   private final org.a.a.c.a b;

   public f(org.a.a.c.a var1, org.a.a.c.a var2) {
      this.a = var1;
      this.b = var2;
   }

   public abstract boolean a(org.a.a.d.g var1);

   protected String d() {
      return "";
   }

   public final org.a.a.c.a e() {
      return this.a;
   }

   public boolean equals(Object var1) {
      return var1 instanceof f?this.toString().equals(var1.toString()):false;
   }

   public final org.a.a.c.a f() {
      return this.b;
   }

   public int hashCode() {
      return this.toString().hashCode();
   }

   public String toString() {
      return "<" + this.getClass().getName() + "(" + this.d() + ")>";
   }
}
