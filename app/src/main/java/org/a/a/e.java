package org.a.a;

public enum e {
   a(new Integer[]{Integer.valueOf(1), Integer.valueOf(0)}),
   b(new Integer[]{Integer.valueOf(1), Integer.valueOf(1)});

   private Integer[] c;

   private e(Integer[] var3) {
      this.c = var3;
   }

   public final String toString() {
      return "Version: " + this.c[0] + "." + this.c[1];
   }
}
