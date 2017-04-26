package android.support.v4.util;

import android.support.v4.util.MapCollections;
import android.support.v4.util.MapCollections$ArrayIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class MapCollections$KeySet implements Set {
   // $FF: synthetic field
   final MapCollections this$0;

   MapCollections$KeySet(MapCollections var1) {
      this.this$0 = var1;
   }

   public final boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   public final boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public final void clear() {
      this.this$0.colClear();
   }

   public final boolean contains(Object var1) {
      return this.this$0.colIndexOfKey(var1) >= 0;
   }

   public final boolean containsAll(Collection var1) {
      return MapCollections.containsAllHelper(this.this$0.colGetMap(), var1);
   }

   public final boolean equals(Object var1) {
      return MapCollections.equalsSetHelper(this, var1);
   }

   public final int hashCode() {
      int var1 = this.this$0.colGetSize() - 1;

      int var2;
      for(var2 = 0; var1 >= 0; --var1) {
         Object var4 = this.this$0.colGetEntry(var1, 0);
         int var3;
         if(var4 == null) {
            var3 = 0;
         } else {
            var3 = var4.hashCode();
         }

         var2 += var3;
      }

      return var2;
   }

   public final boolean isEmpty() {
      return this.this$0.colGetSize() == 0;
   }

   public final Iterator iterator() {
      return new MapCollections$ArrayIterator(this.this$0, 0);
   }

   public final boolean remove(Object var1) {
      int var2 = this.this$0.colIndexOfKey(var1);
      if(var2 >= 0) {
         this.this$0.colRemoveAt(var2);
         return true;
      } else {
         return false;
      }
   }

   public final boolean removeAll(Collection var1) {
      return MapCollections.removeAllHelper(this.this$0.colGetMap(), var1);
   }

   public final boolean retainAll(Collection var1) {
      return MapCollections.retainAllHelper(this.this$0.colGetMap(), var1);
   }

   public final int size() {
      return this.this$0.colGetSize();
   }

   public final Object[] toArray() {
      return this.this$0.toArrayHelper(0);
   }

   public final Object[] toArray(Object[] var1) {
      return this.this$0.toArrayHelper(var1, 0);
   }
}
