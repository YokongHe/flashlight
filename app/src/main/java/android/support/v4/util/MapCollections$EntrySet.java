package android.support.v4.util;

import android.support.v4.util.ContainerHelpers;
import android.support.v4.util.MapCollections;
import android.support.v4.util.MapCollections$MapIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

final class MapCollections$EntrySet implements Set {
   // $FF: synthetic field
   final MapCollections this$0;

   MapCollections$EntrySet(MapCollections var1) {
      this.this$0 = var1;
   }

   public final boolean add(Entry var1) {
      throw new UnsupportedOperationException();
   }

   public final boolean addAll(Collection var1) {
      int var2 = this.this$0.colGetSize();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         this.this$0.colPut(var3.getKey(), var3.getValue());
      }

      return var2 != this.this$0.colGetSize();
   }

   public final void clear() {
      this.this$0.colClear();
   }

   public final boolean contains(Object var1) {
      if(var1 instanceof Entry) {
         Entry var3 = (Entry)var1;
         int var2 = this.this$0.colIndexOfKey(var3.getKey());
         if(var2 >= 0) {
            return ContainerHelpers.equal(this.this$0.colGetEntry(var2, 1), var3.getValue());
         }
      }

      return false;
   }

   public final boolean containsAll(Collection var1) {
      Iterator var2 = var1.iterator();

      do {
         if(!var2.hasNext()) {
            return true;
         }
      } while(this.contains(var2.next()));

      return false;
   }

   public final boolean equals(Object var1) {
      return MapCollections.equalsSetHelper(this, var1);
   }

   public final int hashCode() {
      int var2 = this.this$0.colGetSize() - 1;

      int var1;
      int var3;
      int var4;
      for(var1 = 0; var2 >= 0; var1 += var4 ^ var3) {
         Object var5 = this.this$0.colGetEntry(var2, 0);
         Object var6 = this.this$0.colGetEntry(var2, 1);
         if(var5 == null) {
            var3 = 0;
         } else {
            var3 = var5.hashCode();
         }

         if(var6 == null) {
            var4 = 0;
         } else {
            var4 = var6.hashCode();
         }

         --var2;
      }

      return var1;
   }

   public final boolean isEmpty() {
      return this.this$0.colGetSize() == 0;
   }

   public final Iterator iterator() {
      return new MapCollections$MapIterator(this.this$0);
   }

   public final boolean remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public final boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public final boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public final int size() {
      return this.this$0.colGetSize();
   }

   public final Object[] toArray() {
      throw new UnsupportedOperationException();
   }

   public final Object[] toArray(Object[] var1) {
      throw new UnsupportedOperationException();
   }
}
