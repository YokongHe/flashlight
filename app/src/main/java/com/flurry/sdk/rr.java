package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.ij;
import com.flurry.sdk.jw;
import com.flurry.sdk.rv;

public final class rr extends rv {
   private static final rr[] d = new rr[12];
   final int c;

   static {
      for(int var0 = 0; var0 < 12; ++var0) {
         d[var0] = new rr(var0 - 1);
      }

   }

   public rr(int var1) {
      this.c = var1;
   }

   public static rr a(int var0) {
      return var0 <= 10 && var0 >= -1?d[var0 + 1]:new rr(var0);
   }

   public final void a(hf var1, jw var2) {
      var1.b(this.c);
   }

   public final boolean e() {
      return true;
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         if(((rr)var1).c != this.c) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      return this.c;
   }

   public final int k() {
      return this.c;
   }

   public final long l() {
      return (long)this.c;
   }

   public final double m() {
      return (double)this.c;
   }

   public final String n() {
      return ij.a(this.c);
   }
}
