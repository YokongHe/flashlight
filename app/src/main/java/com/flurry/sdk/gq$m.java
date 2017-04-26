package com.flurry.sdk;

import com.flurry.sdk.gq;
import com.flurry.sdk.gq$f;
import com.flurry.sdk.gq$i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class gq$m extends gq implements Iterable {
   private gq$m(gq[] var1) {
      super(gq$i.c, var1);
   }

   // $FF: synthetic method
   gq$m(gq[] var1, Object var2) {
      this(var1);
   }

   public final int a() {
      return a(this.b, 0);
   }

   // $FF: synthetic method
   public gq a(Map var1, Map var2) {
      return this.b(var1, var2);
   }

   public gq$m b(Map var1, Map var2) {
      gq$m var4 = (gq$m)var1.get(this);
      gq$m var3 = var4;
      if(var4 == null) {
         var3 = new gq$m(new gq[this.a()]);
         var1.put(this, var3);
         ArrayList var6 = new ArrayList();
         var2.put(var3, var6);
         a(this.b, 0, var3.b, 0, var1, var2);
         Iterator var5 = var6.iterator();

         while(var5.hasNext()) {
            gq$f var7 = (gq$f)var5.next();
            System.arraycopy(var3.b, 0, var7.a, var7.b, var3.b.length);
         }

         var2.remove(var3);
      }

      return var3;
   }

   public Iterator iterator() {
      return new Iterator() {
         private int b;

         {
            this.b = gq$m.this.b.length;
         }

         public gq a() {
            if(this.b > 0) {
               gq[] var2 = gq$m.this.b;
               int var1 = this.b - 1;
               this.b = var1;
               return var2[var1];
            } else {
               throw new NoSuchElementException();
            }
         }

         public boolean hasNext() {
            return this.b > 0;
         }

         // $FF: synthetic method
         public Object next() {
            return this.a();
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }
}
