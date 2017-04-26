package com.tapjoy.internal;

import com.tapjoy.internal.dh$a;
import com.tapjoy.internal.du;
import com.tapjoy.internal.du$b;

final class du$c implements dh$a {
   int a;
   // $FF: synthetic field
   final du b;
   private final du$b c;
   private dh$a d;

   private du$c(du var1) {
      this.b = var1;
      this.c = new du$b(var1, (byte)0);
      this.d = this.c.a().c();
      this.a = var1.a();
   }

   // $FF: synthetic method
   du$c(du var1, byte var2) {
      this(var1);
   }

   public final byte a() {
      if(!this.d.hasNext()) {
         this.d = this.c.a().c();
      }

      --this.a;
      return this.d.a();
   }

   public final boolean hasNext() {
      return this.a > 0;
   }

   // $FF: synthetic method
   public final Object next() {
      return Byte.valueOf(this.a());
   }

   public final void remove() {
      throw new UnsupportedOperationException();
   }
}
