package com.flurry.sdk;

import android.view.ViewGroup.LayoutParams;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.sdk.fc;

abstract class j$c {
   private j$c() {
   }

   // $FF: synthetic method
   j$c(Object var1) {
      this();
   }

   private static boolean h(AdSpaceLayout var0) {
      return var0.b().intValue() != 0;
   }

   private static boolean i(AdSpaceLayout var0) {
      return var0.c().intValue() != 0;
   }

   public abstract LayoutParams a(AdSpaceLayout var1);

   public int b(AdSpaceLayout var1) {
      return h(var1)?this.d(var1):this.f(var1);
   }

   public int c(AdSpaceLayout var1) {
      return i(var1)?this.e(var1):this.g(var1);
   }

   public int d(AdSpaceLayout var1) {
      return fc.b(var1.b().intValue());
   }

   public int e(AdSpaceLayout var1) {
      return fc.b(var1.c().intValue());
   }

   public int f(AdSpaceLayout var1) {
      return -1;
   }

   public int g(AdSpaceLayout var1) {
      return -2;
   }
}
