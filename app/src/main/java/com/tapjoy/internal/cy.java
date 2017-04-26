package com.tapjoy.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class cy {
   static final com.tapjoy.internal.db a = new com.tapjoy.internal.db() {
      public final boolean hasNext() {
         return false;
      }

      public final Object next() {
         throw new NoSuchElementException();
      }
   };
   private static final Iterator b = new Iterator() {
      public final boolean hasNext() {
         return false;
      }

      public final Object next() {
         throw new NoSuchElementException();
      }

      public final void remove() {
         throw new IllegalStateException();
      }
   };

   public static Object a(Iterator var0) {
      return var0.hasNext()?var0.next():null;
   }
}
