package android.support.v4.util;

import android.support.v4.util.MapCollections;
import android.support.v4.util.MapCollections$ArrayIterator;
import java.util.Collection;
import java.util.Iterator;

final class MapCollections$ValuesCollection implements Collection {
   // $FF: synthetic field
   final MapCollections this$0;

   MapCollections$ValuesCollection(MapCollections var1) {
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
      return this.this$0.colIndexOfValue(var1) >= 0;
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

   public final boolean isEmpty() {
      return this.this$0.colGetSize() == 0;
   }

   public final Iterator iterator() {
      return new MapCollections$ArrayIterator(this.this$0, 1);
   }

   public final boolean remove(Object var1) {
      int var2 = this.this$0.colIndexOfValue(var1);
      if(var2 >= 0) {
         this.this$0.colRemoveAt(var2);
         return true;
      } else {
         return false;
      }
   }

   public final boolean removeAll(Collection var1) {
      int var2 = 0;
      int var3 = this.this$0.colGetSize();

      int var4;
      boolean var6;
      for(var6 = false; var2 < var3; var3 = var4) {
         int var5 = var2;
         var4 = var3;
         if(var1.contains(this.this$0.colGetEntry(var2, 1))) {
            this.this$0.colRemoveAt(var2);
            var5 = var2 - 1;
            var4 = var3 - 1;
            var6 = true;
         }

         var2 = var5 + 1;
      }

      return var6;
   }

   public final boolean retainAll(Collection var1) {
      int var2 = 0;
      int var3 = this.this$0.colGetSize();

      int var4;
      boolean var6;
      for(var6 = false; var2 < var3; var3 = var4) {
         int var5 = var2;
         var4 = var3;
         if(!var1.contains(this.this$0.colGetEntry(var2, 1))) {
            this.this$0.colRemoveAt(var2);
            var5 = var2 - 1;
            var4 = var3 - 1;
            var6 = true;
         }

         var2 = var5 + 1;
      }

      return var6;
   }

   public final int size() {
      return this.this$0.colGetSize();
   }

   public final Object[] toArray() {
      return this.this$0.toArrayHelper(1);
   }

   public final Object[] toArray(Object[] var1) {
      return this.this$0.toArrayHelper(var1, 1);
   }
}
