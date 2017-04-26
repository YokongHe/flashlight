package org.a.a;

public enum c {
   a("\r\n"),
   b("\r"),
   c("\n");

   private String d;

   private c(String var3) {
      this.d = var3;
   }

   public final String toString() {
      return "Line break: " + this.name();
   }
}
