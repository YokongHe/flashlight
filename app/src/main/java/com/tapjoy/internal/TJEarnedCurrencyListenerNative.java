package com.tapjoy.internal;

import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.internal.Keep;

public class TJEarnedCurrencyListenerNative implements TJEarnedCurrencyListener {
   private final long a;

   private TJEarnedCurrencyListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJEarnedCurrencyListenerNative(var0);
   }

   private static native void onEarnedCurrencyNative(long var0, String var2, int var3);

   public void onEarnedCurrency(String var1, int var2) {
      onEarnedCurrencyNative(this.a, var1, var2);
   }
}
