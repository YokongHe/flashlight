package com.tapjoy.internal;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class al extends Animation {
   private final boolean a;
   private final float b;
   private final float c;
   private final int d;
   private final float e;
   private final int f;
   private final float g;
   private float h;
   private float i;
   private Camera j;

   public al(boolean var1, float var2, float var3, int var4, float var5, int var6, float var7) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
   }

   protected final void applyTransformation(float var1, Transformation var2) {
      float var3 = this.b;
      var1 = var3 + (this.c - var3) * var1;
      Matrix var5 = var2.getMatrix();
      Camera var4 = this.j;
      var4.save();
      if(this.a) {
         var4.rotateX(var1);
      } else {
         var4.rotateY(var1);
      }

      var4.getMatrix(var5);
      var4.restore();
      var1 = this.h;
      var3 = this.i;
      var5.preTranslate(-var1, -var3);
      var5.postTranslate(var1, var3);
   }

   public final void initialize(int var1, int var2, int var3, int var4) {
      super.initialize(var1, var2, var3, var4);
      this.h = this.resolveSize(this.d, this.e, var1, var3);
      this.i = this.resolveSize(this.f, this.g, var2, var4);
      this.j = new Camera();
   }
}
