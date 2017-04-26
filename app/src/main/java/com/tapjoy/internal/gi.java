package com.tapjoy.internal;

import com.tapjoy.internal.fj;
import com.tapjoy.internal.fk;
import com.tapjoy.internal.fn;
import com.tapjoy.internal.fo;
import com.tapjoy.internal.go;
import com.tapjoy.internal.gq;
import java.util.Arrays;

abstract class gi implements fj {
   private static final String[] a;

   static {
      String[] var0 = new String[]{"reward", "purchase", "custom_action"};
      a = var0;
      Arrays.sort(var0);
   }

   public static gi a(String var0, com.tapjoy.internal.bt var1) {
      return "reward".equals(var0)?(gi)var1.b(gq.a):("purchase".equals(var0)?(gi)var1.b(go.a):null);
   }

   public static boolean a(String var0) {
      return Arrays.binarySearch(a, var0) >= 0;
   }

   public final void a(fk var1) {
      if(this instanceof fn) {
         fn var2 = (fn)this;
         var1.a(var2.a(), var2.b());
      } else if(this instanceof fo) {
         fo var3 = (fo)this;
         var1.a(var3.a(), var3.b(), var3.c(), var3.d());
         return;
      }

   }
}
