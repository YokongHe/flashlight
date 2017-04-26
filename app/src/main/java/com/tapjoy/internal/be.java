package com.tapjoy.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class be extends AbstractMap {
   private final HashMap a = new HashMap();
   private final com.tapjoy.internal.cd b = new com.tapjoy.internal.cd();

   public static com.tapjoy.internal.be a() {
      return new com.tapjoy.internal.be();
   }

   private static Object a(com.tapjoy.internal.cc var0) {
      return var0 != null?var0.get():null;
   }

   private void b() {
      while(true) {
         com.tapjoy.internal.cc var1 = this.b.a();
         if(var1 == null) {
            return;
         }

         this.a.remove(var1.a());
      }
   }

   public final void clear() {
      this.a.clear();

      while(this.b.a() != null) {
         ;
      }

   }

   public final boolean containsKey(Object var1) {
      this.b();
      return this.a.containsKey(var1);
   }

   public final boolean containsValue(Object var1) {
      this.b();
      Iterator var2 = this.a.values().iterator();

      do {
         if(!var2.hasNext()) {
            return false;
         }
      } while(!var1.equals(((com.tapjoy.internal.cc)var2.next()).get()));

      return true;
   }

   public final Set entrySet() {
      this.b();
      throw new UnsupportedOperationException();
   }

   public final boolean equals(Object var1) {
      this.b();
      throw new UnsupportedOperationException();
   }

   public final Object get(Object var1) {
      this.b();
      return a((com.tapjoy.internal.cc)this.a.get(var1));
   }

   public final int hashCode() {
      this.b();
      throw new UnsupportedOperationException();
   }

   public final Set keySet() {
      this.b();
      return this.a.keySet();
   }

   public final Object put(Object var1, Object var2) {
      this.b();
      return a((com.tapjoy.internal.cc)this.a.put(var1, this.b.a(var1, var2)));
   }

   public final Object remove(Object var1) {
      this.b();
      return a((com.tapjoy.internal.cc)this.a.remove(var1));
   }

   public final int size() {
      this.b();
      return this.a.size();
   }

   public final String toString() {
      this.b();
      throw new UnsupportedOperationException();
   }

   public final Collection values() {
      this.b();
      throw new UnsupportedOperationException();
   }
}
