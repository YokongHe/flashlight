package org.a.a;

public enum d {
   a(Character.valueOf('\"')),
   b(Character.valueOf('\'')),
   c(Character.valueOf('|')),
   d(Character.valueOf('>')),
   e((Character)null);

   private Character f;

   private d(Character var3) {
      this.f = var3;
   }

   public final Character a() {
      return this.f;
   }

   public final String toString() {
      return "Scalar style: \'" + this.f + "\'";
   }
}
