package com.tapjoy.internal;

import com.tapjoy.TJViewListener;
import com.tapjoy.internal.Keep;

public class TJViewListenerNative implements TJViewListener {
   private final long a;

   private TJViewListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJViewListenerNative(var0);
   }

   private static native void onViewDidCloseNative(long var0, int var2);

   private static native void onViewDidOpenNative(long var0, int var2);

   private static native void onViewWillCloseNative(long var0, int var2);

   private static native void onViewWillOpenNative(long var0, int var2);

   public void onViewDidClose(int var1) {
      onViewDidCloseNative(this.a, var1);
   }

   public void onViewDidOpen(int var1) {
      onViewDidOpenNative(this.a, var1);
   }

   public void onViewWillClose(int var1) {
      onViewWillCloseNative(this.a, var1);
   }

   public void onViewWillOpen(int var1) {
      onViewWillOpenNative(this.a, var1);
   }
}
