package com.smaato.soma.bannerutilities;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.BannerAnimator;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.ExpandAnimationInstantiationFailed;

class BannerAnimator$ExpandAnimation extends Animation {
   private int mDeltaHeight;
   private View mExpandingView;
   private int mOldHeight;
   // $FF: synthetic field
   final BannerAnimator this$0;

   BannerAnimator$ExpandAnimation(BannerAnimator var1, View var2, int var3, int var4) {
      this.this$0 = var1;

      try {
         Debugger.showLog(new LogMessage("BannerAnimator", "oldHeight=" + var3 + " newHeight=" + var4, 1, DebugCategory.DEBUG));
         this.mExpandingView = var2;
         this.mOldHeight = var3;
         this.mDeltaHeight = var4 - var3;
      } catch (RuntimeException var5) {
         throw var5;
      } catch (Exception var6) {
         throw new ExpandAnimationInstantiationFailed(var6);
      }
   }

   protected void applyTransformation(final float var1, Transformation var2) {
      (new CrashReportTemplate() {
         public Void process() {
            if(BannerAnimator$ExpandAnimation.this.mExpandingView != null) {
               int var1x = BannerAnimator$ExpandAnimation.this.mOldHeight;
               int var2 = (int)((float)BannerAnimator$ExpandAnimation.this.mDeltaHeight * var1);
               BannerAnimator$ExpandAnimation.this.mExpandingView.getLayoutParams().height = var1x + var2;
               BannerAnimator$ExpandAnimation.this.mExpandingView.requestLayout();
            }

            return null;
         }
      }).execute();
   }

   public boolean willChangeBounds() {
      return true;
   }
}
