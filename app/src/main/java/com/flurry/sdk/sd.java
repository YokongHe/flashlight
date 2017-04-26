package com.flurry.sdk;

import com.flurry.sdk.sc;

public final class sd extends sc {
   static final sd c = new sd("", 0, 0);
   final int d;

   sd(String var1, int var2, int var3) {
      super(var1, var2);
      this.d = var3;
   }

   static final sd b() {
      return c;
   }

   public final boolean a(int var1) {
      return var1 == this.d;
   }

   public final boolean a(int var1, int var2) {
      return var1 == this.d && var2 == 0;
   }

   public final boolean a(int[] var1, int var2) {
      return var2 == 1 && var1[0] == this.d;
   }
}
