package com.inmobi.monetization.internal.anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimationVert extends Animation {
   private final float a;
   private final float b;
   private final float c;
   private final float d;
   private final float e;
   private final boolean f;
   private Camera g;

   public Rotate3dAnimationVert(float var1, float var2, float var3, float var4, float var5, boolean var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   protected void applyTransformation(float var1, Transformation var2) {
      float var3 = this.a;
      float var4 = this.b;
      float var5 = this.c;
      float var6 = this.d;
      Camera var7 = this.g;
      Matrix var8 = var2.getMatrix();
      var7.save();
      if(this.f) {
         var7.translate(0.0F, 0.0F, this.e * var1);
      } else {
         var7.translate(0.0F, 0.0F, this.e * (1.0F - var1));
      }

      var7.rotateY(var3 + (var4 - var3) * var1);
      var7.getMatrix(var8);
      var7.restore();
      var8.preTranslate(-var5, -var6);
      var8.postTranslate(var5, var6);
   }

   public void initialize(int var1, int var2, int var3, int var4) {
      super.initialize(var1, var2, var3, var4);
      this.g = new Camera();
   }
}
