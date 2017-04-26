package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.fr;
import com.flurry.sdk.ft;
import java.util.AbstractList;
import java.util.Iterator;

public class ft$a extends AbstractList implements fr, Comparable {
   private static final Object[] a = new Object[0];
   private final fn b;
   private int c;
   private Object[] d;

   public ft$a(int var1, fn var2) {
      this.d = a;
      if(var2 != null && fn$v.c.equals(var2.a())) {
         this.b = var2;
         if(var1 != 0) {
            this.d = new Object[var1];
         }

      } else {
         throw new fk("Not an array schema: " + var2);
      }
   }

   public int a(fr var1) {
      return ft.a().a(this, (Object)var1, this.a());
   }

   public fn a() {
      return this.b;
   }

   public void add(int var1, Object var2) {
      if(var1 <= this.c && var1 >= 0) {
         if(this.c == this.d.length) {
            Object[] var3 = new Object[this.c * 3 / 2 + 1];
            System.arraycopy(this.d, 0, var3, 0, this.c);
            this.d = var3;
         }

         System.arraycopy(this.d, var1, this.d, var1 + 1, this.c - var1);
         this.d[var1] = var2;
         ++this.c;
      } else {
         throw new IndexOutOfBoundsException("Index " + var1 + " out of bounds.");
      }
   }

   public boolean add(Object var1) {
      Object[] var3;
      if(this.c == this.d.length) {
         var3 = new Object[this.c * 3 / 2 + 1];
         System.arraycopy(this.d, 0, var3, 0, this.c);
         this.d = var3;
      }

      var3 = this.d;
      int var2 = this.c;
      this.c = var2 + 1;
      var3[var2] = var1;
      return true;
   }

   public Object b() {
      return this.c < this.d.length?this.d[this.c]:null;
   }

   public void clear() {
      this.c = 0;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((fr)var1);
   }

   public Object get(int var1) {
      if(var1 >= this.c) {
         throw new IndexOutOfBoundsException("Index " + var1 + " out of bounds.");
      } else {
         return this.d[var1];
      }
   }

   public Iterator iterator() {
      return new Iterator() {
         private int b = 0;

         public boolean hasNext() {
            return this.b < ft$a.this.c;
         }

         public Object next() {
            Object[] var2 = ft$a.this.d;
            int var1 = this.b;
            this.b = var1 + 1;
            return var2[var1];
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }

   public Object remove(int var1) {
      if(var1 >= this.c) {
         throw new IndexOutOfBoundsException("Index " + var1 + " out of bounds.");
      } else {
         Object var2 = this.d[var1];
         --this.c;
         System.arraycopy(this.d, var1 + 1, this.d, var1, this.c - var1);
         this.d[this.c] = null;
         return var2;
      }
   }

   public Object set(int var1, Object var2) {
      if(var1 >= this.c) {
         throw new IndexOutOfBoundsException("Index " + var1 + " out of bounds.");
      } else {
         Object var3 = this.d[var1];
         this.d[var1] = var2;
         return var3;
      }
   }

   public int size() {
      return this.c;
   }

   public String toString() {
      StringBuffer var4 = new StringBuffer();
      var4.append("[");
      int var1 = 0;
      Iterator var5 = this.iterator();

      while(var5.hasNext()) {
         Object var3 = var5.next();
         String var6;
         if(var3 == null) {
            var6 = "null";
         } else {
            var6 = var3.toString();
         }

         var4.append(var6);
         int var2 = var1 + 1;
         var1 = var2;
         if(var2 < this.size()) {
            var4.append(", ");
            var1 = var2;
         }
      }

      var4.append("]");
      return var4.toString();
   }
}
