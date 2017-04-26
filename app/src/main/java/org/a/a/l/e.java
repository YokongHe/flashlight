package org.a.a.l;

final class e {
   private final Boolean a;
   private final int b;

   public e(Boolean var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final boolean a() {
      return this.a == null || this.a.booleanValue();
   }

   public final boolean b() {
      return this.a != null && this.a.booleanValue();
   }

   public final int c() {
      return this.b;
   }
}
