package com.smaato.soma.twister.external;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dYAxisAnimation extends Animation {
   private Camera mCamera;
   private final float mCenterX;
   private final float mCenterY;
   private final float mDepthZ;
   private final float mFromDegrees;
   private final boolean mReverse;
   private final float mToDegrees;

   public Rotate3dYAxisAnimation(float var1, float var2, float var3, float var4, float var5, boolean var6) {
      this.mFromDegrees = var1;
      this.mToDegrees = var2;
      this.mCenterX = var3;
      this.mCenterY = var4;
      this.mDepthZ = var5;
      this.mReverse = var6;
   }

   protected void applyTransformation(float var1, Transformation var2) {
      float var3 = this.mFromDegrees;
      float var4 = this.mToDegrees;
      float var5 = this.mCenterX;
      float var6 = this.mCenterY;
      Camera var7 = this.mCamera;
      Matrix var8 = var2.getMatrix();
      var7.save();
      if(this.mReverse) {
         var7.translate(0.0F, 0.0F, this.mDepthZ * var1);
      } else {
         var7.translate(0.0F, 0.0F, this.mDepthZ * (1.0F - var1));
      }

      var7.rotateY(var3 + (var4 - var3) * var1);
      var7.getMatrix(var8);
      var7.restore();
      var8.preTranslate(-var5, -var6);
      var8.postTranslate(var5, var6);
   }

   public void initialize(int var1, int var2, int var3, int var4) {
      super.initialize(var1, var2, var3, var4);
      this.mCamera = new Camera();
   }
}
