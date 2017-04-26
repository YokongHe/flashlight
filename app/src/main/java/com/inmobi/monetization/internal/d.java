package com.inmobi.monetization.internal;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Animation.AnimationListener;
import com.inmobi.commons.AnimationType;
import com.inmobi.monetization.internal.BannerAd;
import com.inmobi.monetization.internal.anim.Rotate3dAnimation;
import com.inmobi.monetization.internal.anim.Rotate3dAnimationVert;

class d {
   private BannerAd a;
   private AnimationListener b;

   public d(BannerAd var1, AnimationListener var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(AnimationType var1) {
      if(var1 == AnimationType.ANIMATION_ALPHA) {
         AlphaAnimation var3 = new AlphaAnimation(0.0F, 0.5F);
         AlphaAnimation var2 = new AlphaAnimation(0.5F, 1.0F);
         var3.setDuration(1000L);
         var3.setFillAfter(false);
         var3.setAnimationListener(this.b);
         var3.setInterpolator(new DecelerateInterpolator());
         var2.setDuration(500L);
         var2.setFillAfter(false);
         var2.setAnimationListener(this.b);
         var2.setInterpolator(new DecelerateInterpolator());
         this.a.a((Animation)var3);
         this.a.b((Animation)var2);
      } else if(var1 == AnimationType.ROTATE_HORIZONTAL_AXIS) {
         Rotate3dAnimation var4 = new Rotate3dAnimation(0.0F, 90.0F, (float)this.a.b() / 2.0F, (float)this.a.c() / 2.0F, 0.0F, true);
         Rotate3dAnimation var6 = new Rotate3dAnimation(270.0F, 360.0F, (float)this.a.b() / 2.0F, (float)this.a.c() / 2.0F, 0.0F, true);
         var4.setDuration(500L);
         var4.setFillAfter(false);
         var4.setAnimationListener(this.b);
         var4.setInterpolator(new AccelerateInterpolator());
         var6.setDuration(500L);
         var6.setFillAfter(false);
         var6.setAnimationListener(this.b);
         var6.setInterpolator(new DecelerateInterpolator());
         this.a.a((Animation)var4);
         this.a.b((Animation)var6);
      } else if(var1 == AnimationType.ROTATE_VERTICAL_AXIS) {
         Rotate3dAnimationVert var5 = new Rotate3dAnimationVert(0.0F, 90.0F, (float)this.a.b() / 2.0F, (float)this.a.c() / 2.0F, 0.0F, true);
         Rotate3dAnimationVert var7 = new Rotate3dAnimationVert(270.0F, 360.0F, (float)this.a.b() / 2.0F, (float)this.a.c() / 2.0F, 0.0F, true);
         var5.setDuration(500L);
         var5.setFillAfter(false);
         var5.setAnimationListener(this.b);
         var5.setInterpolator(new AccelerateInterpolator());
         var7.setDuration(500L);
         var7.setFillAfter(false);
         var7.setAnimationListener(this.b);
         var7.setInterpolator(new DecelerateInterpolator());
         this.a.a((Animation)var5);
         this.a.b((Animation)var7);
      }

      this.a.c(this.a.a());
   }
}
