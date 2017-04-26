package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class bd extends AbstractSet implements Serializable, Set {
   transient WeakHashMap a;

   public bd() {
      this(new WeakHashMap());
   }

   private bd(WeakHashMap var1) {
      this.a = var1;
   }

   public final boolean add(Object var1) {
      return this.a.put(var1, this) == null;
   }

   public final void clear() {
      this.a.clear();
   }

   public final Object clone() {
      try {
         com.tapjoy.internal.bd var1 = (com.tapjoy.internal.bd)super.clone();
         return var1;
      } catch (CloneNotSupportedException var2) {
         throw new AssertionError(var2);
      }
   }

   public final boolean contains(Object var1) {
      return this.a.containsKey(var1);
   }

   public final boolean isEmpty() {
      return this.a.isEmpty();
   }

   public final Iterator iterator() {
      return this.a.keySet().iterator();
   }

   public final boolean remove(Object var1) {
      return this.a.remove(var1) != null;
   }

   public final int size() {
      return this.a.size();
   }
}
