package com.millennialmedia.a.a.b;

import java.util.AbstractSet;
import java.util.Iterator;

final class n extends AbstractSet {
   // $FF: synthetic field
   final j a;

   n(j var1) {
      this.a = var1;
   }

   public final void clear() {
      this.a.clear();
   }

   public final boolean contains(Object var1) {
      return this.a.containsKey(var1);
   }

   public final Iterator iterator() {
      return new com.millennialmedia.a.a.b.o(var1.a, (byte)0) {
         public final Object next() {
            return this.a().f;
         }
      };
   }

   public final boolean remove(Object var1) {
      return this.a.a(var1) != null;
   }

   public final int size() {
      return this.a.d;
   }
}
