package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.ii;
import com.flurry.sdk.jw;
import com.flurry.sdk.rz;
import com.flurry.sdk.sk;

public final class ry extends rz {
   static final ry c = new ry("");
   final String d;

   public ry(String var1) {
      this.d = var1;
   }

   protected static void a(StringBuilder var0, String var1) {
      var0.append('\"');
      sk.a(var0, var1);
      var0.append('\"');
   }

   public static ry b(String var0) {
      return var0 == null?null:(var0.length() == 0?c:new ry(var0));
   }

   public final double a(double var1) {
      return ii.a(this.d, var1);
   }

   public final void a(hf var1, jw var2) {
      if(this.d == null) {
         var1.f();
      } else {
         var1.b(this.d);
      }
   }

   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if(var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if(var1 != null) {
            var2 = var3;
            if(var1.getClass() == this.getClass()) {
               return ((ry)var1).d.equals(this.d);
            }
         }
      }

      return var2;
   }

   public final boolean f() {
      return true;
   }

   public final int hashCode() {
      return this.d.hashCode();
   }

   public final String i() {
      return this.d;
   }

   public final String n() {
      return this.d;
   }

   public final String toString() {
      int var1 = this.d.length();
      StringBuilder var2 = new StringBuilder((var1 >> 4) + var1 + 2);
      a(var2, this.d);
      return var2.toString();
   }
}
