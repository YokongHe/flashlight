package com.flurry.android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.sdk.n$d;
import com.flurry.sdk.n$d$a;

final class FlurryFullscreenTakeoverActivity$b implements n$d {
   // $FF: synthetic field
   final FlurryFullscreenTakeoverActivity a;
   private View b;
   private int c;
   private n$d$a d;
   private FrameLayout e;

   private FlurryFullscreenTakeoverActivity$b(FlurryFullscreenTakeoverActivity var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   FlurryFullscreenTakeoverActivity$b(FlurryFullscreenTakeoverActivity var1, Object var2) {
      this(var1);
   }

   public final void a(com.flurry.sdk.n var1) {
      if(this.b != null) {
         ((ViewGroup)this.a.getWindow().getDecorView()).removeView(this.e);
         this.e.removeView(this.b);
         if(this.d != null) {
            this.d.a();
         }

         this.a.setRequestedOrientation(this.c);
         this.d = null;
         this.e = null;
         this.b = null;
      }
   }

   public final void a(com.flurry.sdk.n var1, View var2, int var3, n$d$a var4) {
      if(this.b != null) {
         this.a(var1);
      }

      this.b = var2;
      this.c = this.a.getRequestedOrientation();
      this.d = var4;
      this.e = new FrameLayout(this.a);
      this.e.setBackgroundColor(-16777216);
      this.e.addView(this.b, new LayoutParams(-1, -1, 17));
      ((ViewGroup)this.a.getWindow().getDecorView()).addView(this.e, -1, -1);
      this.a.setRequestedOrientation(var3);
   }

   public final void a(com.flurry.sdk.n var1, View var2, n$d$a var3) {
      this.a(var1, var2, this.a.getRequestedOrientation(), var3);
   }
}
