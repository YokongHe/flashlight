package com.inmobi.monetization.internal.anim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TranslateAnimation extends Animation {
   private int a = 0;
   private int b = 0;
   private int c = 0;
   private int d = 0;
   private float e = 0.0F;
   private float f = 0.0F;
   private float g = 0.0F;
   private float h = 0.0F;
   private float i;
   private float j;
   private float k;
   private float l;

   public TranslateAnimation(float var1, float var2, float var3, float var4) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
      this.a = 0;
      this.b = 0;
      this.c = 0;
      this.d = 0;
   }

   public TranslateAnimation(int var1, float var2, int var3, float var4, int var5, float var6, int var7, float var8) {
      this.e = var2;
      this.f = var4;
      this.g = var6;
      this.h = var8;
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
   }

   protected void applyTransformation(float var1, Transformation var2) {
      float var3 = this.i;
      float var4 = this.k;
      if(this.i != this.j) {
         var3 = this.i + (this.j - this.i) * var1;
      }

      if(this.k != this.l) {
         var4 = this.k + (this.l - this.k) * var1;
      }

      var2.getMatrix().setTranslate(var3, var4);
   }

   public void initialize(int var1, int var2, int var3, int var4) {
      super.initialize(var1, var2, var3, var4);
      this.i = this.resolveSize(this.a, this.e, var1, var3);
      this.j = this.resolveSize(this.b, this.f, var1, var3);
      this.k = this.resolveSize(this.c, this.g, var2, var4);
      this.l = this.resolveSize(this.d, this.h, var2, var4);
   }
}
