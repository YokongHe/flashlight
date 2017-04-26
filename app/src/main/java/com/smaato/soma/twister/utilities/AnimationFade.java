package com.smaato.soma.twister.utilities;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import com.smaato.soma.twister.utilities.AnimationProvider;

public class AnimationFade extends AnimationProvider {
   public AnimationFade(int var1) {
      super(var1);
   }

   public Animation getInAnimation() {
      AlphaAnimation var1 = new AlphaAnimation(0.0F, 1.0F);
      var1.setInterpolator(new DecelerateInterpolator());
      var1.setDuration((long)this.duration);
      return var1;
   }

   public Animation getOutAnimation() {
      AlphaAnimation var1 = new AlphaAnimation(1.0F, 0.0F);
      var1.setInterpolator(new AccelerateInterpolator());
      var1.setStartOffset((long)(this.duration + 100));
      var1.setDuration((long)this.duration);
      return var1;
   }
}
