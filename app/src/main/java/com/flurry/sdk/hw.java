package com.flurry.sdk;

import com.flurry.sdk.hg;
import com.flurry.sdk.hl;
import com.flurry.sdk.sk;

public final class hw extends hl {
   protected final hw c;
   protected int d;
   protected int e;
   protected String f;
   protected hw g = null;

   public hw(hw var1, int var2, int var3, int var4) {
      this.a = var2;
      this.c = var1;
      this.d = var3;
      this.e = var4;
      this.b = -1;
   }

   public static hw a(int var0, int var1) {
      return new hw((hw)null, 0, var0, var1);
   }

   public static hw g() {
      return new hw((hw)null, 0, 1, 0);
   }

   public final hg a(Object var1) {
      return new hg(var1, -1L, this.d, this.e);
   }

   protected final void a(int var1, int var2, int var3) {
      this.a = var1;
      this.b = -1;
      this.d = var2;
      this.e = var3;
      this.f = null;
   }

   public final void a(String var1) {
      this.f = var1;
   }

   public final hw b(int var1, int var2) {
      hw var3 = this.g;
      if(var3 == null) {
         var3 = new hw(this, 1, var1, var2);
         this.g = var3;
         return var3;
      } else {
         var3.a(1, var1, var2);
         return var3;
      }
   }

   public final hw c(int var1, int var2) {
      hw var3 = this.g;
      if(var3 == null) {
         var3 = new hw(this, 2, var1, var2);
         this.g = var3;
         return var3;
      } else {
         var3.a(2, var1, var2);
         return var3;
      }
   }

   public final String h() {
      return this.f;
   }

   public final hw i() {
      return this.c;
   }

   public final boolean j() {
      int var1 = this.b + 1;
      this.b = var1;
      return this.a != 0 && var1 > 0;
   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder(64);
      switch(this.a) {
      case 0:
         var1.append("/");
         break;
      case 1:
         var1.append('[');
         var1.append(this.f());
         var1.append(']');
         break;
      case 2:
         var1.append('{');
         if(this.f != null) {
            var1.append('\"');
            sk.a(var1, this.f);
            var1.append('\"');
         } else {
            var1.append('?');
         }

         var1.append('}');
      }

      return var1.toString();
   }
}
