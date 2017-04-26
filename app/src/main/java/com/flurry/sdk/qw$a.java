package com.flurry.sdk;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class qw$a implements Iterable, Iterator {
   private final Object[] a;
   private int b;

   public qw$a(Object[] var1) {
      this.a = var1;
      this.b = 0;
   }

   public final boolean hasNext() {
      return this.b < this.a.length;
   }

   public final Iterator iterator() {
      return this;
   }

   public final Object next() {
      if(this.b >= this.a.length) {
         throw new NoSuchElementException();
      } else {
         Object[] var2 = this.a;
         int var1 = this.b;
         this.b = var1 + 1;
         return var2[var1];
      }
   }

   public final void remove() {
      throw new UnsupportedOperationException();
   }
}
