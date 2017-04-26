package com.flurry.sdk;

import com.flurry.sdk.gz$a;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class gz implements Map {
   private final ReferenceQueue a = new ReferenceQueue();
   private Map b = new HashMap();

   // $FF: synthetic method
   static ReferenceQueue a(gz var0) {
      return var0.a;
   }

   private void a() {
      // $FF: Couldn't be decompiled
   }

   public void clear() {
      this.b.clear();
      this.a();
   }

   public boolean containsKey(Object var1) {
      this.a();
      return this.b.containsKey(new gz$a(this, var1));
   }

   public boolean containsValue(Object var1) {
      this.a();
      return this.b.containsValue(var1);
   }

   public Set entrySet() {
      this.a();
      HashSet var1 = new HashSet();
      Iterator var2 = this.b.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.add(new Entry() {
            // $FF: synthetic field
            final Object a;
            // $FF: synthetic field
            final Object b;

            {
               this.a = var2;
               this.b = var3;
            }

            public Object getKey() {
               return this.a;
            }

            public Object getValue() {
               return this.b;
            }

            public Object setValue(Object var1) {
               throw new UnsupportedOperationException();
            }
         });
      }

      return Collections.unmodifiableSet(var1);
   }

   public boolean equals(Object var1) {
      return this.b.equals(((gz)var1).b);
   }

   public Object get(Object var1) {
      this.a();
      return this.b.get(new gz$a(this, var1));
   }

   public int hashCode() {
      this.a();
      return this.b.hashCode();
   }

   public boolean isEmpty() {
      this.a();
      return this.b.isEmpty();
   }

   public Set keySet() {
      this.a();
      HashSet var1 = new HashSet();
      Iterator var2 = this.b.keySet().iterator();

      while(var2.hasNext()) {
         var1.add(((gz$a)var2.next()).get());
      }

      return Collections.unmodifiableSet(var1);
   }

   public Object put(Object var1, Object var2) {
      this.a();
      return this.b.put(new gz$a(this, var1), var2);
   }

   public void putAll(Map var1) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object var1) {
      this.a();
      return this.b.remove(new gz$a(this, var1));
   }

   public int size() {
      this.a();
      return this.b.size();
   }

   public Collection values() {
      this.a();
      return this.b.values();
   }
}
