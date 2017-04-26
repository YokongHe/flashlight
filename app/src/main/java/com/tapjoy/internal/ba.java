package com.tapjoy.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class ba implements com.tapjoy.internal.bc {
   private final List a;

   public ba(List var1) {
      this.a = var1;
   }

   public final Object a(int var1) {
      return this.a.get(var1);
   }

   public final boolean add(Object var1) {
      return this.a.add(var1);
   }

   public final boolean addAll(Collection var1) {
      return this.a.addAll(var1);
   }

   public final void b(int var1) {
      com.tapjoy.internal.bb.a(this.a, var1);
   }

   public final void clear() {
      this.a.clear();
   }

   public final boolean contains(Object var1) {
      return this.a.contains(var1);
   }

   public final boolean containsAll(Collection var1) {
      return this.a.containsAll(var1);
   }

   public final Object element() {
      Object var1 = this.peek();
      if(var1 != null) {
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }

   public final boolean equals(Object var1) {
      return this.a.equals(var1);
   }

   public final int hashCode() {
      return this.a.hashCode();
   }

   public final boolean isEmpty() {
      return this.a.isEmpty();
   }

   public final Iterator iterator() {
      return this.a.iterator();
   }

   public final boolean offer(Object var1) {
      return this.a.add(var1);
   }

   public final Object peek() {
      return this.a.isEmpty()?null:this.a.get(0);
   }

   public final Object poll() {
      return this.a.isEmpty()?null:this.a.remove(0);
   }

   public final Object remove() {
      Object var1 = this.poll();
      if(var1 != null) {
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }

   public final boolean remove(Object var1) {
      return this.a.remove(var1);
   }

   public final boolean removeAll(Collection var1) {
      return this.a.removeAll(var1);
   }

   public final boolean retainAll(Collection var1) {
      return this.a.retainAll(var1);
   }

   public final int size() {
      return this.a.size();
   }

   public final Object[] toArray() {
      return this.a.toArray();
   }

   public final Object[] toArray(Object[] var1) {
      return this.a.toArray(var1);
   }
}
