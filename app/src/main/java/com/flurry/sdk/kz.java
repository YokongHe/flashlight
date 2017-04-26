package com.flurry.sdk;

import com.flurry.sdk.kt;
import com.flurry.sdk.kz$a;
import com.flurry.sdk.kz$b;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class kz {
   private final kz$a[] a;
   private final int b;
   private final int c;

   public kz(Collection var1) {
      this.c = var1.size();
      int var2 = a(this.c);
      this.b = var2 - 1;
      kz$a[] var3 = new kz$a[var2];

      kt var4;
      String var5;
      for(Iterator var6 = var1.iterator(); var6.hasNext(); var3[var2] = new kz$a(var3[var2], var5, var4)) {
         var4 = (kt)var6.next();
         var5 = var4.c();
         var2 = var5.hashCode() & this.b;
      }

      this.a = var3;
   }

   private static final int a(int var0) {
      if(var0 <= 32) {
         var0 += var0;
      } else {
         var0 += var0 >> 2;
      }

      int var1;
      for(var1 = 2; var1 < var0; var1 += var1) {
         ;
      }

      return var1;
   }

   private kt a(String var1, int var2) {
      for(kz$a var3 = this.a[var2]; var3 != null; var3 = var3.a) {
         if(var1.equals(var3.b)) {
            return var3.c;
         }
      }

      return null;
   }

   public final kt a(String var1) {
      int var2 = var1.hashCode();
      var2 &= this.b;
      kz$a var4 = this.a[var2];
      if(var4 == null) {
         return null;
      } else {
         kz$a var3 = var4;
         if(var4.b == var1) {
            return var4.c;
         } else {
            do {
               var4 = var3.a;
               if(var4 == null) {
                  return this.a(var1, var2);
               }

               var3 = var4;
            } while(var4.b != var1);

            return var4.c;
         }
      }
   }

   public final void a() {
      kz$a[] var5 = this.a;
      int var3 = var5.length;
      int var1 = 0;

      for(int var2 = 0; var1 < var3; ++var1) {
         for(kz$a var4 = var5[var1]; var4 != null; ++var2) {
            var4.c.a(var2);
            var4 = var4.a;
         }
      }

   }

   public final void a(kt var1) {
      String var6 = var1.c();
      int var3 = var6.hashCode() & this.a.length - 1;
      kz$a var4 = this.a[var3];
      boolean var2 = false;

      kz$a var5;
      for(var5 = null; var4 != null; var4 = var4.a) {
         if(!var2 && var4.b.equals(var6)) {
            var2 = true;
         } else {
            var5 = new kz$a(var5, var4.b, var4.c);
         }
      }

      if(!var2) {
         throw new NoSuchElementException("No entry \'" + var1 + "\' found, can\'t replace");
      } else {
         this.a[var3] = new kz$a(var5, var6, var1);
      }
   }

   public final int b() {
      return this.c;
   }

   public final void b(kt var1) {
      String var6 = var1.c();
      int var3 = var6.hashCode() & this.a.length - 1;
      kz$a var4 = this.a[var3];
      boolean var2 = false;

      kz$a var5;
      for(var5 = null; var4 != null; var4 = var4.a) {
         if(!var2 && var4.b.equals(var6)) {
            var2 = true;
         } else {
            var5 = new kz$a(var5, var4.b, var4.c);
         }
      }

      if(!var2) {
         throw new NoSuchElementException("No entry \'" + var1 + "\' found, can\'t remove");
      } else {
         this.a[var3] = var5;
      }
   }

   public final Iterator c() {
      return new kz$b(this.a);
   }
}
