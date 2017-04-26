package com.google.android.gms.ads;

import android.content.Context;

public final class d {
   public static final com.google.android.gms.ads.d a = new com.google.android.gms.ads.d(320, 50, "320x50_mb");
   public static final com.google.android.gms.ads.d b = new com.google.android.gms.ads.d(468, 60, "468x60_as");
   public static final com.google.android.gms.ads.d c = new com.google.android.gms.ads.d(320, 100, "320x100_as");
   public static final com.google.android.gms.ads.d d = new com.google.android.gms.ads.d(728, 90, "728x90_as");
   public static final com.google.android.gms.ads.d e = new com.google.android.gms.ads.d(300, 250, "300x250_as");
   public static final com.google.android.gms.ads.d f = new com.google.android.gms.ads.d(160, 600, "160x600_as");
   public static final com.google.android.gms.ads.d g = new com.google.android.gms.ads.d(-1, -2, "smart_banner");
   private final int h;
   private final int i;
   private final String j;

   public d(int var1, int var2) {
      StringBuilder var4 = new StringBuilder();
      String var3;
      if(var1 == -1) {
         var3 = "FULL";
      } else {
         var3 = String.valueOf(var1);
      }

      var4 = var4.append(var3).append("x");
      if(var2 == -2) {
         var3 = "AUTO";
      } else {
         var3 = String.valueOf(var2);
      }

      this(var1, var2, var4.append(var3).append("_as").toString());
   }

   d(int var1, int var2, String var3) {
      if(var1 < 0 && var1 != -1) {
         throw new IllegalArgumentException("Invalid width for AdSize: " + var1);
      } else if(var2 < 0 && var2 != -2) {
         throw new IllegalArgumentException("Invalid height for AdSize: " + var2);
      } else {
         this.h = var1;
         this.i = var2;
         this.j = var3;
      }
   }

   public final int a() {
      return this.i;
   }

   public final int a(Context var1) {
      return this.i == -2?com.google.android.gms.internal.ak.b(var1.getResources().getDisplayMetrics()):com.google.android.gms.internal.bI.a(var1, this.i);
   }

   public final int b() {
      return this.h;
   }

   public final int b(Context var1) {
      return this.h == -1?com.google.android.gms.internal.ak.a(var1.getResources().getDisplayMetrics()):com.google.android.gms.internal.bI.a(var1, this.h);
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof com.google.android.gms.ads.d)) {
            return false;
         }

         com.google.android.gms.ads.d var2 = (com.google.android.gms.ads.d)var1;
         if(this.h != var2.h || this.i != var2.i || !this.j.equals(var2.j)) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      return this.j.hashCode();
   }

   public final String toString() {
      return this.j;
   }
}
