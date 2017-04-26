package com.inneractive.api.ads.sdk;

import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import com.inneractive.api.ads.sdk.IAadReportGestureListener$GestureState;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;

final class IAadReportGestureListener extends SimpleOnGestureListener {
   private IAadReportGestureListener$GestureState a;
   private View b;
   private com.inneractive.api.ads.sdk.a c;
   private com.inneractive.api.ads.sdk.d d;

   IAadReportGestureListener(View var1, com.inneractive.api.ads.sdk.a var2) {
      this.a = IAadReportGestureListener$GestureState.a;
      this.b = var1;
      this.c = var2;
   }

   final void a() {
      this.b();
   }

   final void b() {
      InneractiveAdView$Log.d("alert gesture reset");
      this.a = IAadReportGestureListener$GestureState.a;
   }

   final void c() {
      InneractiveAdView$Log.d("alert gesture long press");
      this.a = IAadReportGestureListener$GestureState.b;
      this.a = IAadReportGestureListener$GestureState.c;
      if(this.a == IAadReportGestureListener$GestureState.c) {
         InneractiveAdView$Log.d("sending ad report");
         this.d = new d(this.b.getContext(), this.b, this.c);
         this.d.a();
      }

   }
}
