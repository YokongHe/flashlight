package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.ij;
import com.flurry.sdk.jw;
import com.flurry.sdk.rv;

public final class rt extends rv {
   final long c;

   public rt(long var1) {
      this.c = var1;
   }

   public static rt a(long var0) {
      return new rt(var0);
   }

   public final void a(hf var1, jw var2) {
      var1.a(this.c);
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         if(((rt)var1).c != this.c) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      return (int)this.c ^ (int)(this.c >> 32);
   }

   public final int k() {
      return (int)this.c;
   }

   public final long l() {
      return this.c;
   }

   public final double m() {
      return (double)this.c;
   }

   public final String n() {
      return ij.a(this.c);
   }
}
