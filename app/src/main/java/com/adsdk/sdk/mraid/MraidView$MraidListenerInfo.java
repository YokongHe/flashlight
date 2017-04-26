package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidView$MraidListener;
import com.adsdk.sdk.mraid.MraidView$OnCloseButtonStateChangeListener;
import com.adsdk.sdk.mraid.MraidView$OnOpenListener;

class MraidView$MraidListenerInfo {
   private MraidView$MraidListener mMraidListener;
   private MraidView$OnCloseButtonStateChangeListener mOnCloseButtonListener;
   private MraidView$OnOpenListener mOnOpenListener;

   // $FF: synthetic method
   static MraidView$MraidListener access$0(MraidView$MraidListenerInfo var0) {
      return var0.mMraidListener;
   }

   // $FF: synthetic method
   static void access$1(MraidView$MraidListenerInfo var0, MraidView$MraidListener var1) {
      var0.mMraidListener = var1;
   }

   // $FF: synthetic method
   static void access$2(MraidView$MraidListenerInfo var0, MraidView$OnCloseButtonStateChangeListener var1) {
      var0.mOnCloseButtonListener = var1;
   }

   // $FF: synthetic method
   static MraidView$OnCloseButtonStateChangeListener access$3(MraidView$MraidListenerInfo var0) {
      return var0.mOnCloseButtonListener;
   }

   // $FF: synthetic method
   static void access$4(MraidView$MraidListenerInfo var0, MraidView$OnOpenListener var1) {
      var0.mOnOpenListener = var1;
   }

   // $FF: synthetic method
   static MraidView$OnOpenListener access$5(MraidView$MraidListenerInfo var0) {
      return var0.mOnOpenListener;
   }
}
