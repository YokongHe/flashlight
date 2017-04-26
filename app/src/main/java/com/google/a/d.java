package com.google.a;

@Deprecated
public final class d {
   public static final com.google.a.d a = new com.google.a.d(-1, -2);
   public static final com.google.a.d b = new com.google.a.d(320, 50);
   public static final com.google.a.d c = new com.google.a.d(300, 250);
   public static final com.google.a.d d = new com.google.a.d(468, 60);
   public static final com.google.a.d e = new com.google.a.d(728, 90);
   public static final com.google.a.d f = new com.google.a.d(160, 600);
   private final com.google.android.gms.ads.d g;

   private d(int var1, int var2) {
      this(new com.google.android.gms.ads.d(var1, var2));
   }

   public d(com.google.android.gms.ads.d var1) {
      this.g = var1;
   }

   public final int a() {
      return this.g.b();
   }

   public final int b() {
      return this.g.a();
   }

   public final boolean equals(Object var1) {
      if(!(var1 instanceof com.google.a.d)) {
         return false;
      } else {
         com.google.a.d var2 = (com.google.a.d)var1;
         return this.g.equals(var2.g);
      }
   }

   public final int hashCode() {
      return this.g.hashCode();
   }

   public final String toString() {
      return this.g.toString();
   }
}
