package com.flurry.android;

import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.sdk.n$c;
import com.flurry.sdk.n$e;

final class FlurryFullscreenTakeoverActivity$a implements n$c {
   // $FF: synthetic field
   final FlurryFullscreenTakeoverActivity a;

   private FlurryFullscreenTakeoverActivity$a(FlurryFullscreenTakeoverActivity var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   FlurryFullscreenTakeoverActivity$a(FlurryFullscreenTakeoverActivity var1, Object var2) {
      this(var1);
   }

   public final void a(com.flurry.sdk.n var1, n$e var2) {
      FlurryFullscreenTakeoverActivity.a(this.a, var2);
      if(FlurryFullscreenTakeoverActivity.b(this.a) == n$e.c) {
         FlurryFullscreenTakeoverActivity.fBasicWebViewClosingHandlerFired = true;
      }

      this.a.finish();
   }
}
