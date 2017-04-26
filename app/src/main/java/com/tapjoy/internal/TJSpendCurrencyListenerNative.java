package com.tapjoy.internal;

import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.internal.Keep;

public class TJSpendCurrencyListenerNative implements TJSpendCurrencyListener {
   private final long a;

   private TJSpendCurrencyListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJSpendCurrencyListenerNative(var0);
   }

   private static native void onSpendCurrencyResponseFailureNative(long var0, String var2);

   private static native void onSpendCurrencyResponseNative(long var0, String var2, int var3);

   public void onSpendCurrencyResponse(String var1, int var2) {
      onSpendCurrencyResponseNative(this.a, var1, var2);
   }

   public void onSpendCurrencyResponseFailure(String var1) {
      onSpendCurrencyResponseFailureNative(this.a, var1);
   }
}
