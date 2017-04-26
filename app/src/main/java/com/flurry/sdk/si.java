package com.flurry.sdk;

import com.flurry.sdk.si$a;
import com.flurry.sdk.si$b;

public class si {
   protected final byte[][] a = new byte[si$a.values().length][];
   protected final char[][] b = new char[si$b.values().length][];

   private final byte[] a(int var1) {
      return new byte[var1];
   }

   private final char[] b(int var1) {
      return new char[var1];
   }

   public final void a(si$a var1, byte[] var2) {
      this.a[var1.ordinal()] = var2;
   }

   public final void a(si$b var1, char[] var2) {
      this.b[var1.ordinal()] = var2;
   }

   public final byte[] a(si$a var1) {
      int var2 = var1.ordinal();
      byte[] var3 = this.a[var2];
      if(var3 == null) {
         return this.a(si$a.a(var1));
      } else {
         this.a[var2] = null;
         return var3;
      }
   }

   public final char[] a(si$b var1) {
      return this.a(var1, 0);
   }

   public final char[] a(si$b var1, int var2) {
      int var3 = var2;
      if(si$b.a(var1) > var2) {
         var3 = si$b.a(var1);
      }

      var2 = var1.ordinal();
      char[] var4 = this.b[var2];
      if(var4 != null && var4.length >= var3) {
         this.b[var2] = null;
         return var4;
      } else {
         return this.b(var3);
      }
   }
}
