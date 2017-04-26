package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;

final class ds extends ViewSwitcher {
   private final com.google.android.gms.internal.bF a;

   public ds(Context var1) {
      super(var1);
      this.a = new com.google.android.gms.internal.bF(var1);
   }

   // $FF: synthetic method
   static com.google.android.gms.internal.bF a(ds var0) {
      return var0.a;
   }

   public final boolean onInterceptTouchEvent(MotionEvent var1) {
      this.a.a(var1);
      return false;
   }
}
