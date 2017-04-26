package com.tapjoy.internal;

import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.internal.Keep;

public class TJAwardCurrencyListenerNative implements TJAwardCurrencyListener {
   private final long a;

   private TJAwardCurrencyListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJAwardCurrencyListenerNative(var0);
   }

   private static native void onAwardCurrencyResponseFailureNative(long var0, String var2);

   private static native void onAwardCurrencyResponseNative(long var0, String var2, int var3);

   public void onAwardCurrencyResponse(String var1, int var2) {
      onAwardCurrencyResponseNative(this.a, var1, var2);
   }

   public void onAwardCurrencyResponseFailure(String var1) {
      onAwardCurrencyResponseFailureNative(this.a, var1);
   }
}
