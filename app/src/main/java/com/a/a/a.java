package com.a.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum a {
   a;

   private final com.a.a.b b = new com.a.a.b(this);
   private final String c = com.a.a.a.class.getName();

   public final String a(String var1) {
      return this.b.a?this.b.a(var1):null;
   }

   public final String a(String var1, String var2) {
      return this.b.a?this.b.a(var1, var2):null;
   }

   public final boolean a() {
      return this.b.a;
   }

   public final String[] a(String[] var1) {
      String var2 = this.c;
      StringBuilder var3 = new StringBuilder();
      if(this.b.a) {
         var2 = " available ";
      } else {
         var2 = "not available ";
      }

      var3.append(var2).append(" Found ").append(this.b.b).append(" out of ").append(this.b.d);
      if(this.b.a) {
         if(this.b.b == this.b.c) {
            var2 = this.c;
            (new StringBuilder("Finding more packages ")).append(this.b.b).append(" / ").append(this.b.d);
            com.a.a.b var4 = this.b;
            var4.d += this.b.a(this.b.c, this.b.e);
         }

         return this.b.a(var1);
      } else {
         return null;
      }
   }

   public final String b() {
      return this.b.a?this.b.a(32):null;
   }

   public final String b(String var1) {
      return this.b.a?this.b.c(var1):null;
   }

   public final String c(String var1) {
      return this.b.a?this.b.d(var1):null;
   }

   public final String d(String var1) {
      return this.b.a?this.b.e(var1):null;
   }

   public final List e(String var1) {
      if(this.b.a) {
         String[] var2 = this.b.b(var1);
         return (List)(var2 != null?Arrays.asList(var2):new ArrayList());
      } else {
         return null;
      }
   }
}
