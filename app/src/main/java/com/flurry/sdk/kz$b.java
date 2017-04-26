package com.flurry.sdk;

import com.flurry.sdk.kt;
import com.flurry.sdk.kz$a;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class kz$b implements Iterator {
   private final kz$a[] a;
   private kz$a b;
   private int c;

   public kz$b(kz$a[] var1) {
      this.a = var1;
      int var2 = 0;
      int var4 = this.a.length;

      int var3;
      while(true) {
         if(var2 >= var4) {
            var3 = var2;
            break;
         }

         var1 = this.a;
         var3 = var2 + 1;
         kz$a var5 = var1[var2];
         if(var5 != null) {
            this.b = var5;
            break;
         }

         var2 = var3;
      }

      this.c = var3;
   }

   public final kt a() {
      kz$a var3 = this.b;
      if(var3 == null) {
         throw new NoSuchElementException();
      } else {
         int var1;
         kz$a var2;
         kz$a[] var4;
         for(var2 = var3.a; var2 == null && this.c < this.a.length; var2 = var4[var1]) {
            var4 = this.a;
            var1 = this.c;
            this.c = var1 + 1;
         }

         this.b = var2;
         return var3.c;
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
