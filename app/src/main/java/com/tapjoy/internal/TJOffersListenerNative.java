package com.tapjoy.internal;

import com.tapjoy.TJOffersListener;
import com.tapjoy.internal.Keep;

public class TJOffersListenerNative implements TJOffersListener {
   private final long a;

   private TJOffersListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJOffersListenerNative(var0);
   }

   private static native void onOffersResponseFailureNative(long var0, String var2);

   private static native void onOffersResponseNative(long var0);

   public void onOffersResponse() {
      onOffersResponseNative(this.a);
   }

   public void onOffersResponseFailure(String var1) {
      onOffersResponseFailureNative(this.a, var1);
   }
}
