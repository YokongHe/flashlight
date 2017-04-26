package com.tapjoy.internal;

import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.internal.Keep;

public class TJPlacementListenerNative implements TJPlacementListener {
   private final long a;

   private TJPlacementListenerNative(long var1) {
      if(var1 == 0L) {
         throw new IllegalArgumentException();
      } else {
         this.a = var1;
      }
   }

   @Keep
   static Object create(long var0) {
      return new TJPlacementListenerNative(var0);
   }

   private static native void onContentDismissNative(long var0, TJPlacement var2, String var3);

   private static native void onContentReadyNative(long var0, TJPlacement var2, String var3);

   private static native void onContentShowNative(long var0, TJPlacement var2, String var3);

   private static native void onPurchaseRequestNative(long var0, TJPlacement var2, String var3, TJActionRequest var4, String var5, String var6, String var7);

   private static native void onRequestFailureNative(long var0, TJPlacement var2, String var3, int var4, String var5);

   private static native void onRequestSuccessNative(long var0, TJPlacement var2, String var3);

   private static native void onRewardRequestNative(long var0, TJPlacement var2, String var3, TJActionRequest var4, String var5, String var6, String var7, int var8);

   public void onContentDismiss(TJPlacement var1) {
      onContentDismissNative(this.a, var1, var1.getName());
   }

   public void onContentReady(TJPlacement var1) {
      onContentReadyNative(this.a, var1, var1.getName());
   }

   public void onContentShow(TJPlacement var1) {
      onContentShowNative(this.a, var1, var1.getName());
   }

   public void onPurchaseRequest(TJPlacement var1, TJActionRequest var2, String var3) {
      onPurchaseRequestNative(this.a, var1, var1.getName(), var2, var2.getRequestId(), var2.getToken(), var3);
   }

   public void onRequestFailure(TJPlacement var1, TJError var2) {
      onRequestFailureNative(this.a, var1, var1.getName(), var2.code, var2.message);
   }

   public void onRequestSuccess(TJPlacement var1) {
      onRequestSuccessNative(this.a, var1, var1.getName());
   }

   public void onRewardRequest(TJPlacement var1, TJActionRequest var2, String var3, int var4) {
      onRewardRequestNative(this.a, var1, var1.getName(), var2, var2.getRequestId(), var2.getToken(), var3, var4);
   }
}
