package com.tapjoy.internal;

import com.tapjoy.internal.dh$a;
import com.tapjoy.internal.dp;
import java.util.NoSuchElementException;

final class dp$a implements dh$a {
   // $FF: synthetic field
   final dp a;
   private int b;
   private final int c;

   private dp$a(dp var1) {
      this.a = var1;
      this.b = 0;
      this.c = var1.a();
   }

   // $FF: synthetic method
   dp$a(dp var1, byte var2) {
      this(var1);
   }

   public final byte a() {
      int var2;
      byte[] var3;
      try {
         var3 = this.a.c;
         var2 = this.b;
         this.b = var2 + 1;
      } catch (ArrayIndexOutOfBoundsException var4) {
         throw new NoSuchElementException(var4.getMessage());
      }

      byte var1 = var3[var2];
      return var1;
   }

   public final boolean hasNext() {
      return this.b < this.c;
   }

   // $FF: synthetic method
   public final Object next() {
      return Byte.valueOf(this.a());
   }

   public final void remove() {
      throw new UnsupportedOperationException();
   }
}
