package com.nexage.android;

public enum c {
   a("African-American", "0"),
   b("Asian", "1"),
   c("Hispanic", "2"),
   d("White", "3"),
   e("Other", "4");

   private final String f;
   private final String g;

   private c(String var3, String var4) {
      this.f = var3;
      this.g = var4;
   }

   public final String a() {
      return this.g;
   }

   public final String toString() {
      return this.f;
   }
}
