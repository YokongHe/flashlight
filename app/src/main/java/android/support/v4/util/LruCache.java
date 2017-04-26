package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LruCache {
   private int createCount;
   private int evictionCount;
   private int hitCount;
   private final LinkedHashMap map;
   private int maxSize;
   private int missCount;
   private int putCount;
   private int size;

   public LruCache(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         this.maxSize = var1;
         this.map = new LinkedHashMap(0, 0.75F, true);
      }
   }

   private int safeSizeOf(Object var1, Object var2) {
      int var3 = this.sizeOf(var1, var2);
      if(var3 < 0) {
         throw new IllegalStateException("Negative size: " + var1 + "=" + var2);
      } else {
         return var3;
      }
   }

   protected Object create(Object var1) {
      return null;
   }

   public final int createCount() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.createCount;
      } finally {
         ;
      }

      return var1;
   }

   protected void entryRemoved(boolean var1, Object var2, Object var3, Object var4) {
   }

   public final void evictAll() {
      this.trimToSize(-1);
   }

   public final int evictionCount() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.evictionCount;
      } finally {
         ;
      }

      return var1;
   }

   public final Object get(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public final int hitCount() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.hitCount;
      } finally {
         ;
      }

      return var1;
   }

   public final int maxSize() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.maxSize;
      } finally {
         ;
      }

      return var1;
   }

   public final int missCount() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.missCount;
      } finally {
         ;
      }

      return var1;
   }

   public final Object put(Object param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public final int putCount() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.putCount;
      } finally {
         ;
      }

      return var1;
   }

   public final Object remove(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public final int size() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.size;
      } finally {
         ;
      }

      return var1;
   }

   protected int sizeOf(Object var1, Object var2) {
      return 1;
   }

   public final Map snapshot() {
      synchronized(this){}

      LinkedHashMap var1;
      try {
         var1 = new LinkedHashMap(this.map);
      } finally {
         ;
      }

      return var1;
   }

   public final String toString() {
      // $FF: Couldn't be decompiled
   }

   public void trimToSize(int var1) {
      while(true) {
         Object var2;
         Object var5;
         synchronized(this) {
            if(this.size < 0 || this.map.isEmpty() && this.size != 0) {
               throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
            }

            if(this.size <= var1 || this.map.isEmpty()) {
               return;
            }

            Entry var3 = (Entry)this.map.entrySet().iterator().next();
            var2 = var3.getKey();
            var5 = var3.getValue();
            this.map.remove(var2);
            this.size -= this.safeSizeOf(var2, var5);
            ++this.evictionCount;
         }

         this.entryRemoved(true, var2, var5, (Object)null);
      }
   }
}
