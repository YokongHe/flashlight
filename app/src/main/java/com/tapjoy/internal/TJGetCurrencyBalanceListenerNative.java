package com.tapjoy.internal;

import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.internal.Keep;

public class TJGetCurrencyBalanceListenerNative implements TJGetCurrencyBalanceListener {
   private final long a;

   private TJGetCurrencyBalanceListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJGetCurrencyBalanceListenerNative(var0);
   }

   private static native void onGetCurrencyBalanceResponseFailureNative(long var0, String var2);

   private static native void onGetCurrencyBalanceResponseNative(long var0, String var2, int var3);

   public void onGetCurrencyBalanceResponse(String var1, int var2) {
      onGetCurrencyBalanceResponseNative(this.a, var1, var2);
   }

   public void onGetCurrencyBalanceResponseFailure(String var1) {
      onGetCurrencyBalanceResponseFailureNative(this.a, var1);
   }
}
