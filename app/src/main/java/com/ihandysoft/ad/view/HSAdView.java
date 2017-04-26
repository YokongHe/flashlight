package com.ihandysoft.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class HSAdView extends RelativeLayout {
   private FrameLayout a;
   private com.ihandysoft.ad.view.a b;
   private AnimationListener c;

   public HSAdView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public HSAdView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.c = new AnimationListener() {
         public final void onAnimationEnd(Animation var1) {
            HSAdView.a(HSAdView.this);
         }

         public final void onAnimationRepeat(Animation var1) {
         }

         public final void onAnimationStart(Animation var1) {
         }
      };
      byte var6 = 50;
      if(com.ihandysoft.ad.b.a.a(var1)) {
         var6 = 90;
      }

      float var4 = var1.getResources().getDisplayMetrics().density;
      var3 = (int)((float)var6 * var4 + 0.5F);
      this.a = new FrameLayout(var1);
      LayoutParams var5 = new LayoutParams(-1, var3);
      this.a.setLayoutParams(var5);
      this.addView(this.a);
   }

   // $FF: synthetic method
   static void a(final HSAdView var0) {
      var0.post(new Runnable() {
         public final void run() {
            HSAdView.b(var0);
            if(var0.b != null) {
               var0.b;
            }

         }
      });
   }

   // $FF: synthetic method
   static void b(HSAdView var0) {
      while(var0.a.getChildCount() > 1) {
         var0.a.removeViewAt(0);
      }

   }
}
