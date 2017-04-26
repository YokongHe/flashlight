package com.nexage.android;

public enum e {
   a("Single", "S"),
   b("Married", "M"),
   c("Divorced", "D"),
   d("Other", "O");

   private final String e;
   private final String f;

   private e(String var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

   public final String a() {
      return this.f;
   }

   public final String toString() {
      return this.e;
   }
}
