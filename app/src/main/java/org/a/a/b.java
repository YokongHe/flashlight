package org.a.a;

public enum b {
   a,
   b,
   c;

   private Boolean d;

   static {
      a = new b("FLOW", 0, Boolean.TRUE);
      b = new b("BLOCK", 1, Boolean.FALSE);
      c = new b("AUTO", 2, (Boolean)null);
   }

   private b(Boolean var3) {
      this.d = var3;
   }

   public final String toString() {
      return "Flow style: \'" + this.d + "\'";
   }
}
