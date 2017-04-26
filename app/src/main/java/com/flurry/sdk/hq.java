package com.flurry.sdk;

public class hq implements Comparable {
   private static final hq e = new hq(0, 0, 0, (String)null);
   protected final int a;
   protected final int b;
   protected final int c;
   protected final String d;

   public hq(int var1, int var2, int var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public int a(hq var1) {
      int var3 = this.a - var1.a;
      int var2 = var3;
      if(var3 == 0) {
         var3 = this.b - var1.b;
         var2 = var3;
         if(var3 == 0) {
            var2 = this.c - var1.c;
         }
      }

      return var2;
   }

   public boolean a() {
      return this.d != null && this.d.length() > 0;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((hq)var1);
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         hq var2 = (hq)var1;
         if(var2.a != this.a || var2.b != this.b || var2.c != this.c) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.a + this.b + this.c;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.a).append('.');
      var1.append(this.b).append('.');
      var1.append(this.c);
      if(this.a()) {
         var1.append('-').append(this.d);
      }

      return var1.toString();
   }
}
