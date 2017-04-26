package com.flurry.sdk;

import com.flurry.sdk.sc;

final class sa$a {
   protected final sc a;
   protected final sa$a b;

   sa$a(sc var1, sa$a var2) {
      this.a = var1;
      this.b = var2;
   }

   public final int a() {
      int var1 = 1;

      for(sa$a var2 = this.b; var2 != null; var2 = var2.b) {
         ++var1;
      }

      return var1;
   }

   public final sc a(int var1, int var2, int var3) {
      sc var4;
      if(this.a.hashCode() == var1 && this.a.a(var2, var3)) {
         var4 = this.a;
      } else {
         sa$a var5 = this.b;

         while(true) {
            if(var5 == null) {
               return null;
            }

            sc var6 = var5.a;
            if(var6.hashCode() == var1) {
               var4 = var6;
               if(var6.a(var2, var3)) {
                  break;
               }
            }

            var5 = var5.b;
         }
      }

      return var4;
   }

   public final sc a(int var1, int[] var2, int var3) {
      sc var4;
      if(this.a.hashCode() == var1 && this.a.a(var2, var3)) {
         var4 = this.a;
      } else {
         sa$a var5 = this.b;

         while(true) {
            if(var5 == null) {
               return null;
            }

            sc var6 = var5.a;
            if(var6.hashCode() == var1) {
               var4 = var6;
               if(var6.a(var2, var3)) {
                  break;
               }
            }

            var5 = var5.b;
         }
      }

      return var4;
   }
}
