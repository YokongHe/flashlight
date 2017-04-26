package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jy;
import com.flurry.sdk.kb;
import com.flurry.sdk.mc;

@kb
public final class lz$j extends mc {
   public lz$j() {
      super(Number.class);
   }

   // $FF: synthetic method
   public final Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public final Object a(hj var1, iz var2, jy var3) {
      switch(null.a[var1.e().ordinal()]) {
      case 1:
      case 2:
      case 3:
         return this.b(var1, var2);
      default:
         return var3.c(var1, var2);
      }
   }

   public final Number b(hj param1, iz param2) {
      // $FF: Couldn't be decompiled
   }
}
