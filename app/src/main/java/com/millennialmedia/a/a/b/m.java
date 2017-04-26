package com.millennialmedia.a.a.b;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class m extends AbstractSet {
   // $FF: synthetic field
   final j a;

   m(j var1) {
      this.a = var1;
   }

   public final void clear() {
      this.a.clear();
   }

   public final boolean contains(Object var1) {
      return var1 instanceof Entry && this.a.a((Entry)var1) != null;
   }

   public final Iterator iterator() {
      return new com.millennialmedia.a.a.b.o(var1.a, (byte)0) {
         // $FF: synthetic method
         public final Object next() {
            return this.a();
         }
      };
   }

   public final boolean remove(Object var1) {
      if(var1 instanceof Entry) {
         com.millennialmedia.a.a.b.p var2 = this.a.a((Entry)var1);
         if(var2 != null) {
            this.a.a(var2, true);
            return true;
         }
      }

      return false;
   }

   public final int size() {
      return this.a.d;
   }
}
