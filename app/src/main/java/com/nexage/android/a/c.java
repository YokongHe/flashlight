package com.nexage.android.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ViewFlipper;
import com.nexage.android.NexageAdView;

public final class c extends ViewFlipper implements com.nexage.android.a.l {
   private View a;
   private final Context b;

   public c(Context var1) {
      super(var1, (AttributeSet)null);
      this.b = var1;
      Animation var2 = AnimationUtils.loadAnimation(var1, 17432576);
      var2.setDuration(1000L);
      Animation var3 = AnimationUtils.loadAnimation(var1, 17432577);
      var3.setDuration(1000L);
      this.setInAnimation(var2);
      this.setOutAnimation(var3);
      this.setAnimateFirstView(true);
   }

   public final View a() {
      if(this.a != null) {
         this.removeView(this.a);
      }

      View var1 = this.a;
      this.a = null;
      return var1;
   }

   public final void a(View var1) {
      if(this.a != var1) {
         if(this.a != null) {
            this.removeView(this.a);
         }

         this.a = var1;
         this.addView(var1);
         NexageAdView var2 = (NexageAdView)this.getParent();
         if(var2 != null) {
            var2.d();
         }

         this.showNext();
      }
   }

   public final void a(String var1) {
      Animation var2;
      Animation var3;
      if(var1.equalsIgnoreCase("slide_in_out")) {
         var3 = AnimationUtils.loadAnimation(this.b, 17432578);
         var3.setDuration(1000L);
         var2 = AnimationUtils.loadAnimation(this.b, 17432579);
         var2.setDuration(1000L);
         this.setInAnimation(var3);
         this.setOutAnimation(var2);
      } else {
         if(var1.equalsIgnoreCase("fade_in_out")) {
            var3 = AnimationUtils.loadAnimation(this.b, 17432576);
            var3.setDuration(1000L);
            var2 = AnimationUtils.loadAnimation(this.b, 17432577);
            var2.setDuration(1000L);
            this.setInAnimation(var3);
            this.setOutAnimation(var2);
            return;
         }

         TranslateAnimation var4;
         TranslateAnimation var5;
         if(var1.equalsIgnoreCase("left_in_right_out")) {
            var4 = new TranslateAnimation(2, -1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
            var4.setDuration(500L);
            var4.setInterpolator(new AccelerateInterpolator());
            var4.setDuration(1000L);
            var5 = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
            var5.setDuration(500L);
            var5.setInterpolator(new AccelerateInterpolator());
            var5.setDuration(1000L);
            this.setInAnimation(var4);
            this.setOutAnimation(var5);
            return;
         }

         if(var1.equalsIgnoreCase("right_in_left_out")) {
            var4 = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
            var4.setDuration(500L);
            var4.setInterpolator(new AccelerateInterpolator());
            var4.setDuration(1000L);
            var5 = new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.0F);
            var5.setDuration(500L);
            var5.setInterpolator(new AccelerateInterpolator());
            var5.setDuration(1000L);
            this.setInAnimation(var4);
            this.setOutAnimation(var5);
            return;
         }
      }

   }

   public final boolean b() {
      return true;
   }

   public final View getCurrentView() {
      return this.a;
   }

   protected final void onDetachedFromWindow() {
      try {
         super.onDetachedFromWindow();
         return;
      } catch (IllegalArgumentException var5) {
         return;
      } catch (Exception var6) {
         com.nexage.android.a.p.c("", "onDetachedFromWindow exception caught");
      } finally {
         super.stopFlipping();
      }

   }

   public final void setVisibility(int var1) {
      super.setVisibility(var1);
      if(this.a != null) {
         if(var1 != 4) {
            this.a.setVisibility(var1);
            return;
         }

         this.a.setVisibility(8);
      }

   }
}
