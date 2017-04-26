package com.smaato.soma.twister.utilities;

import android.view.animation.Animation;

public abstract class AnimationProvider {
   protected int duration;

   public AnimationProvider(int var1) {
      this.duration = var1;
   }

   public abstract Animation getInAnimation();

   public abstract Animation getOutAnimation();
}
