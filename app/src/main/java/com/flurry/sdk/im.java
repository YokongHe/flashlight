package com.flurry.sdk;

import com.flurry.sdk.hp;
import com.flurry.sdk.ig;

public class im implements hp {
   protected final String a;
   protected byte[] b;
   protected byte[] c;
   protected char[] d;

   public im(String var1) {
      this.a = var1;
   }

   public final String a() {
      return this.a;
   }

   public final char[] b() {
      char[] var2 = this.d;
      char[] var1 = var2;
      if(var2 == null) {
         var1 = ig.a().a(this.a);
         this.d = var1;
      }

      return var1;
   }

   public final byte[] c() {
      byte[] var2 = this.c;
      byte[] var1 = var2;
      if(var2 == null) {
         var1 = ig.a().c(this.a);
         this.c = var1;
      }

      return var1;
   }

   public final byte[] d() {
      byte[] var2 = this.b;
      byte[] var1 = var2;
      if(var2 == null) {
         var1 = ig.a().b(this.a);
         this.b = var1;
      }

      return var1;
   }

   public final boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 != null && var1.getClass() == this.getClass()) {
         im var2 = (im)var1;
         return this.a.equals(var2.a);
      } else {
         return false;
      }
   }

   public final int hashCode() {
      return this.a.hashCode();
   }

   public final String toString() {
      return this.a;
   }
}
