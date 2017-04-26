package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;
import com.tapjoy.internal.Keep;

public class TJConnectListenerNative implements TJConnectListener {
   private final long a;

   private TJConnectListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJConnectListenerNative(var0);
   }

   private static native void onConnectFailureNative(long var0);

   private static native void onConnectSuccessNative(long var0);

   public void onConnectFailure() {
      onConnectFailureNative(this.a);
   }

   public void onConnectSuccess() {
      onConnectSuccessNative(this.a);
   }
}
