package com.flurry.sdk;

import com.flurry.sdk.oi;
import com.flurry.sdk.oo$a;
import com.flurry.sdk.oo$b;

public abstract class oo {
   public static oi a(oi var0, Class[] var1) {
      return (oi)(var1.length == 1?new oo$b(var0, var1[0]):new oo$a(var0, var1));
   }
}
