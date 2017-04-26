package com.flurry.sdk;

public abstract class sc {
   protected final String a;
   protected final int b;

   protected sc(String var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public String a() {
      return this.a;
   }

   public abstract boolean a(int var1);

   public abstract boolean a(int var1, int var2);

   public abstract boolean a(int[] var1, int var2);

   public boolean equals(Object var1) {
      return var1 == this;
   }

   public final int hashCode() {
      return this.b;
   }

   public String toString() {
      return this.a;
   }
}
