package com.flurry.sdk;

import com.flurry.sdk.sc;

public final class se extends sc {
   final int c;
   final int d;

   se(String var1, int var2, int var3, int var4) {
      super(var1, var2);
      this.c = var3;
      this.d = var4;
   }

   public final boolean a(int var1) {
      return false;
   }

   public final boolean a(int var1, int var2) {
      return var1 == this.c && var2 == this.d;
   }

   public final boolean a(int[] var1, int var2) {
      return var2 == 2 && var1[0] == this.c && var1[1] == this.d;
   }
}
