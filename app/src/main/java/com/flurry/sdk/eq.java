package com.flurry.sdk;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.flurry.sdk.er;
import com.flurry.sdk.es;
import com.flurry.sdk.et;

public final class eq extends es {
   private final int a;

   public eq(String var1, int var2) {
      super(a(var1, var2));
      this.a = var2;
   }

   private static et a(String var0, int var1) {
      et var2 = null;
      if(b(var0, var1)) {
         var2 = er.a(var0);
      }

      return var2;
   }

   private static boolean b(String var0, int var1) {
      return !TextUtils.isEmpty(var0) && VERSION.SDK_INT >= var1;
   }
}
