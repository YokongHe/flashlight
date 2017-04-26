package com.tapjoy.internal;

import com.tapjoy.internal.dh;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.du;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

final class du$b implements Iterator {
   private final Stack a;
   private dp b;

   private du$b(dh var1) {
      this.a = new Stack();
      this.b = this.a(var1);
   }

   // $FF: synthetic method
   du$b(dh var1, byte var2) {
      this(var1);
   }

   private dp a(dh var1) {
      while(var1 instanceof du) {
         du var2 = (du)var1;
         this.a.push(var2);
         var1 = du.a(var2);
      }

      return (dp)var1;
   }

   private dp b() {
      dp var1;
      do {
         if(this.a.isEmpty()) {
            return null;
         }

         var1 = this.a(du.b((du)this.a.pop()));
      } while(var1.d());

      return var1;
   }

   public final dp a() {
      if(this.b == null) {
         throw new NoSuchElementException();
      } else {
         dp var1 = this.b;
         this.b = this.b();
         return var1;
      }
   }

   public final boolean hasNext() {
      return this.b != null;
   }

   // $FF: synthetic method
   public final Object next() {
      return this.a();
   }

   public final void remove() {
      throw new UnsupportedOperationException();
   }
}
