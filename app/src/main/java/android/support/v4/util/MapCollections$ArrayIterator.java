package android.support.v4.util;

import android.support.v4.util.MapCollections;
import java.util.Iterator;

final class MapCollections$ArrayIterator implements Iterator {
   boolean mCanRemove;
   int mIndex;
   final int mOffset;
   int mSize;
   // $FF: synthetic field
   final MapCollections this$0;

   MapCollections$ArrayIterator(MapCollections var1, int var2) {
      this.this$0 = var1;
      this.mCanRemove = false;
      this.mOffset = var2;
      this.mSize = var1.colGetSize();
   }

   public final boolean hasNext() {
      return this.mIndex < this.mSize;
   }

   public final Object next() {
      Object var1 = this.this$0.colGetEntry(this.mIndex, this.mOffset);
      ++this.mIndex;
      this.mCanRemove = true;
      return var1;
   }

   public final void remove() {
      if(!this.mCanRemove) {
         throw new IllegalStateException();
      } else {
         --this.mIndex;
         --this.mSize;
         this.mCanRemove = false;
         this.this$0.colRemoveAt(this.mIndex);
      }
   }
}
