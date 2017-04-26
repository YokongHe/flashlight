package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public final class an {
   protected int a = 0;
   protected float b = 0.0F;
   protected int c = 0;
   protected float d = 0.0F;
   protected int e = 0;
   protected float f = 0.0F;
   protected int g = 0;
   protected float h = 0.0F;

   public final Animation a() {
      return new TranslateAnimation(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
   }

   public final com.tapjoy.internal.an a(float var1) {
      this.a = 1;
      this.b = var1;
      return this;
   }

   public final com.tapjoy.internal.an b(float var1) {
      this.e = 1;
      this.f = var1;
      return this;
   }
}
