package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;

public final class ak extends com.tapjoy.internal.aj {
   private final AnimationSet b;

   public ak() {
      super(new AnimationSet(true));
      this.b = (AnimationSet)this.a;
   }

   public final com.tapjoy.internal.ak a(Animation var1) {
      this.b.addAnimation(var1);
      return this;
   }
}
