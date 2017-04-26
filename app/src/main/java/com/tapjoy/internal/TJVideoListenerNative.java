package com.tapjoy.internal;

import com.tapjoy.TJVideoListener;
import com.tapjoy.internal.Keep;

public class TJVideoListenerNative implements TJVideoListener {
   private final long a;

   private TJVideoListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJVideoListenerNative(var0);
   }

   private static native void onVideoCompleteNative(long var0);

   private static native void onVideoErrorNative(long var0, int var2);

   private static native void onVideoStartNative(long var0);

   public void onVideoComplete() {
      onVideoCompleteNative(this.a);
   }

   public void onVideoError(int var1) {
      onVideoErrorNative(this.a, var1);
   }

   public void onVideoStart() {
      onVideoStartNative(this.a);
   }
}
