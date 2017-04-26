package com.tapjoy.internal;

import com.tapjoy.internal.dg;
import com.tapjoy.internal.dh$a;
import java.util.NoSuchElementException;

final class dg$a implements dh$a {
   // $FF: synthetic field
   final dg a;
   private int b;
   private final int c;

   private dg$a(dg var1) {
      this.a = var1;
      this.b = var1.b();
      this.c = this.b + var1.a();
   }

   // $FF: synthetic method
   dg$a(dg var1, byte var2) {
      this(var1);
   }

   public final byte a() {
      if(this.b >= this.c) {
         throw new NoSuchElementException();
      } else {
         byte[] var2 = this.a.c;
         int var1 = this.b;
         this.b = var1 + 1;
         return var2[var1];
      }
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
