package org.a.a.g;

public final class f {
   private d a;
   private d b;

   public f(d var1, d var2) {
      if(var1 != null && var2 != null) {
         this.a = var1;
         this.b = var2;
      } else {
         throw new NullPointerException("Nodes must be provided.");
      }
   }

   public final d a() {
      return this.a;
   }

   public final d b() {
      return this.b;
   }

   public final String toString() {
      return "<NodeTuple keyNode=" + this.a.toString() + "; valueNode=" + this.b.toString() + ">";
   }
}
