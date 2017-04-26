package android.support.v4.util;

import android.support.v4.util.MapCollections$EntrySet;
import android.support.v4.util.MapCollections$KeySet;
import android.support.v4.util.MapCollections$ValuesCollection;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class MapCollections {
   MapCollections$EntrySet mEntrySet;
   MapCollections$KeySet mKeySet;
   MapCollections$ValuesCollection mValues;

   public static boolean containsAllHelper(Map var0, Collection var1) {
      Iterator var2 = var1.iterator();

      do {
         if(!var2.hasNext()) {
            return true;
         }
      } while(var0.containsKey(var2.next()));

      return false;
   }

   public static boolean equalsSetHelper(Set var0, Object var1) {
      if(var0 != var1) {
         if(var1 instanceof Set) {
            Set var5 = (Set)var1;

            boolean var2;
            try {
               if(var0.size() != var5.size()) {
                  return false;
               }

               var2 = var0.containsAll(var5);
            } catch (NullPointerException var3) {
               return false;
            } catch (ClassCastException var4) {
               return false;
            }

            if(var2) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public static boolean removeAllHelper(Map var0, Collection var1) {
      int var2 = var0.size();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var0.remove(var3.next());
      }

      return var2 != var0.size();
   }

   public static boolean retainAllHelper(Map var0, Collection var1) {
      int var2 = var0.size();
      Iterator var3 = var0.keySet().iterator();

      while(var3.hasNext()) {
         if(!var1.contains(var3.next())) {
            var3.remove();
         }
      }

      if(var2 != var0.size()) {
         return true;
      } else {
         return false;
      }
   }

   protected abstract void colClear();

   protected abstract Object colGetEntry(int var1, int var2);

   protected abstract Map colGetMap();

   protected abstract int colGetSize();

   protected abstract int colIndexOfKey(Object var1);

   protected abstract int colIndexOfValue(Object var1);

   protected abstract void colPut(Object var1, Object var2);

   protected abstract void colRemoveAt(int var1);

   protected abstract Object colSetValue(int var1, Object var2);

   public Set getEntrySet() {
      if(this.mEntrySet == null) {
         this.mEntrySet = new MapCollections$EntrySet(this);
      }

      return this.mEntrySet;
   }

   public Set getKeySet() {
      if(this.mKeySet == null) {
         this.mKeySet = new MapCollections$KeySet(this);
      }

      return this.mKeySet;
   }

   public Collection getValues() {
      if(this.mValues == null) {
         this.mValues = new MapCollections$ValuesCollection(this);
      }

      return this.mValues;
   }

   public Object[] toArrayHelper(int var1) {
      int var3 = this.colGetSize();
      Object[] var4 = new Object[var3];

      for(int var2 = 0; var2 < var3; ++var2) {
         var4[var2] = this.colGetEntry(var2, var1);
      }

      return var4;
   }

   public Object[] toArrayHelper(Object[] var1, int var2) {
      int var4 = this.colGetSize();
      if(var1.length < var4) {
         var1 = (Object[])Array.newInstance(var1.getClass().getComponentType(), var4);
      }

      for(int var3 = 0; var3 < var4; ++var3) {
         var1[var3] = this.colGetEntry(var3, var2);
      }

      if(var1.length > var4) {
         var1[var4] = null;
      }

      return var1;
   }
}
