package com.google.a;

public enum b {
   a("Invalid Ad request."),
   b("Ad request successful, but no ad returned due to lack of ad inventory."),
   c("A network error occurred."),
   d("There was an internal error.");

   private final String e;

   private b(String var3) {
      this.e = var3;
   }

   public final String toString() {
      return this.e;
   }
}
