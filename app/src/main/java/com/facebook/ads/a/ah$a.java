package com.facebook.ads.a;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;

class ah$a implements AnimationListener {
   // $FF: synthetic field
   final com.facebook.ads.a.ah a;
   private final View b;
   private boolean c;
   private Animation d;
   private Animation e;

   public ah$a(com.facebook.ads.a.ah var1, View var2) {
      this.a = var1;
      this.c = false;
      this.b = var2;
   }

   private void a(Animation var1) {
      if(var1 == this.d) {
         this.b.startAnimation(this.e);
      } else if(var1 == this.e) {
         this.b.startAnimation(this.d);
         return;
      }

   }

   public ah$a a(boolean var1) {
      this.c = var1;
      return this;
   }

   public void a() {
      this.d = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, (float)(0 - com.facebook.ads.a.ah.a(this.a)));
      this.d.setDuration((long)com.facebook.ads.a.ah.b(this.a));
      this.d.setStartOffset((long)com.facebook.ads.a.ah.c(this.a));
      this.d.setFillAfter(true);
      this.d.setAnimationListener(this);
      this.e = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, (float)com.facebook.ads.a.ah.a(this.a), 0, 0.0F);
      this.e.setDuration((long)com.facebook.ads.a.ah.b(this.a));
      this.e.setStartOffset((long)com.facebook.ads.a.ah.c(this.a));
      this.e.setFillAfter(true);
      this.e.setAnimationListener(this);
      View var2 = this.b;
      Animation var1;
      if(this.c) {
         var1 = this.e;
      } else {
         var1 = this.d;
      }

      var2.startAnimation(var1);
   }

   public void onAnimationEnd(Animation var1) {
      if(!com.facebook.ads.a.ah.d(this.a)) {
         this.a(var1);
      }

   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(final Animation var1) {
      if(com.facebook.ads.a.ah.d(this.a)) {
         (new Handler()).postDelayed(new Runnable() {
            public void run() {
               ah$a.this.a(var1);
            }
         }, (long)com.facebook.ads.a.ah.c(this.a));
      }

   }
}
