package org.a.a.i;

public final class a extends org.a.a.c.c {
   private final String a;
   private final char b;
   private final int c;

   public a(String var1, int var2, char var3, String var4) {
      super(var4);
      this.a = var1;
      this.b = var3;
      this.c = var2;
   }

   public final String toString() {
      return "unacceptable character \'" + this.b + "\' (0x" + Integer.toHexString(this.b).toUpperCase() + ") " + this.getMessage() + "\nin \"" + this.a + "\", position " + this.c;
   }
}
