package com.flurry.sdk;

import com.flurry.sdk.sc;

public final class sf extends sc {
   final int c;
   final int d;
   final int e;

   sf(String var1, int var2, int var3, int var4, int var5) {
      super(var1, var2);
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public final boolean a(int var1) {
      return false;
   }

   public final boolean a(int var1, int var2) {
      return false;
   }

   public final boolean a(int[] var1, int var2) {
      return var2 == 3 && var1[0] == this.c && var1[1] == this.d && var1[2] == this.e;
   }
}
