package com.flurry.sdk;

import com.flurry.sdk.sc;

public final class sg extends sc {
   final int[] c;
   final int d;

   sg(String var1, int var2, int[] var3, int var4) {
      super(var1, var2);
      if(var4 < 3) {
         throw new IllegalArgumentException("Qlen must >= 3");
      } else {
         this.c = var3;
         this.d = var4;
      }
   }

   public final boolean a(int var1) {
      return false;
   }

   public final boolean a(int var1, int var2) {
      return false;
   }

   public final boolean a(int[] var1, int var2) {
      if(var2 == this.d) {
         int var3 = 0;

         while(true) {
            if(var3 >= var2) {
               return true;
            }

            if(var1[var3] != this.c[var3]) {
               break;
            }

            ++var3;
         }
      }

      return false;
   }
}
