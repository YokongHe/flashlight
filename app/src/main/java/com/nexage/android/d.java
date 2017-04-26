package com.nexage.android;

public enum d {
   a("Male", "M"),
   b("Female", "F"),
   c("Other", "O");

   private final String d;
   private final String e;

   private d(String var3, String var4) {
      this.d = var3;
      this.e = var4;
   }

   public final String a() {
      return this.e;
   }

   public final String toString() {
      return this.d;
   }
}
