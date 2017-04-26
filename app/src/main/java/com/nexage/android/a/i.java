package com.nexage.android.a;

import android.app.Activity;
import android.view.View;
import org.nexage.sourcekit.mraid.MRAIDView;

final class i extends com.nexage.android.a.b {
   // $FF: synthetic field
   final com.nexage.android.a.h a;

   private i(com.nexage.android.a.h var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   i(com.nexage.android.a.h var1, byte var2) {
      this(var1);
   }

   public final View b() {
      return this.a;
   }

   public final void c() {
      ((Activity)com.nexage.android.a.h.d(this.a).getContext()).runOnUiThread(new Runnable() {
         public final void run() {
            com.nexage.android.a.h.d(i.this.a).destroy();
            com.nexage.android.a.h.a(i.this.a, (MRAIDView)null);
         }
      });
   }
}
