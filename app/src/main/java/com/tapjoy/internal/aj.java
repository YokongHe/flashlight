package com.tapjoy.internal;

import android.view.animation.Animation;

public class aj {
   protected final Animation a;

   public aj(Animation var1) {
      this.a = var1;
      var1.setDuration(400L);
   }

   public Animation a() {
      return this.a;
   }

   public final com.tapjoy.internal.aj b() {
      this.a.setDuration(600L);
      return this;
   }
}
