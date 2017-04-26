package com.adsdk.sdk.video;

import android.content.Context;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.widget.TextView;
import com.adsdk.sdk.video.AutoResizeTextView$OnTextResizeListener;

public class AutoResizeTextView extends TextView {
   public static final float MIN_TEXT_SIZE = 20.0F;
   private static final String mEllipsis = "...";
   private static final Canvas sTextResizeCanvas = new Canvas();
   private boolean mAddEllipsis;
   private float mMaxTextSize;
   private float mMinTextSize;
   private boolean mNeedsResize;
   private float mSpacingAdd;
   private float mSpacingMult;
   private AutoResizeTextView$OnTextResizeListener mTextResizeListener;
   private float mTextSize;

   public AutoResizeTextView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AutoResizeTextView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public AutoResizeTextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mNeedsResize = false;
      this.mMaxTextSize = 0.0F;
      this.mMinTextSize = 20.0F;
      this.mSpacingMult = 1.0F;
      this.mSpacingAdd = 0.0F;
      this.mAddEllipsis = true;
      this.mTextSize = this.getTextSize();
   }

   private int getTextHeight(CharSequence var1, TextPaint var2, int var3, float var4) {
      var2.setTextSize(var4);
      StaticLayout var5 = new StaticLayout(var1, var2, var3, Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, true);
      var5.draw(sTextResizeCanvas);
      return var5.getHeight();
   }

   public boolean getAddEllipsis() {
      return this.mAddEllipsis;
   }

   public float getMaxTextSize() {
      return this.mMaxTextSize;
   }

   public float getMinTextSize() {
      return this.mMinTextSize;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if(var1 || this.mNeedsResize) {
         this.resizeText(var4 - var2 - this.getCompoundPaddingLeft() - this.getCompoundPaddingRight(), var5 - var3 - this.getCompoundPaddingBottom() - this.getCompoundPaddingTop());
      }

      super.onLayout(var1, var2, var3, var4, var5);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      if(var1 != var3 || var2 != var4) {
         this.mNeedsResize = true;
      }

   }

   protected void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      this.mNeedsResize = true;
      this.resetTextSize();
   }

   public void resetTextSize() {
      super.setTextSize(0, this.mTextSize);
      this.mMaxTextSize = this.mTextSize;
   }

   public void resizeText() {
      int var1 = this.getHeight();
      int var2 = this.getPaddingBottom();
      int var3 = this.getPaddingTop();
      this.resizeText(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight(), var1 - var2 - var3);
   }

   public void resizeText(int var1, int var2) {
      CharSequence var9 = this.getText();
      if(var9 != null && var9.length() != 0 && var2 > 0 && var1 > 0 && this.mTextSize != 0.0F) {
         TextPaint var10 = this.getPaint();
         float var5 = var10.getTextSize();
         float var3;
         if(this.mMaxTextSize > 0.0F) {
            var3 = Math.min(this.mTextSize, this.mMaxTextSize);
         } else {
            var3 = this.mTextSize;
         }

         int var7;
         for(var7 = this.getTextHeight(var9, var10, var1, var3); var7 > var2 && var3 > this.mMinTextSize; var7 = this.getTextHeight(var9, var10, var1, var3)) {
            var3 = Math.max(var3 - 2.0F, this.mMinTextSize);
         }

         if(this.mAddEllipsis && var3 == this.mMinTextSize && var7 > var2) {
            StaticLayout var11 = new StaticLayout(var9, var10, var1, Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, false);
            var11.draw(sTextResizeCanvas);
            if(var11.getLineCount() > 0) {
               int var8 = var11.getLineForVertical(var2) - 1;
               if(var8 < 0) {
                  this.setText("");
               } else {
                  var7 = var11.getLineStart(var8);
                  var2 = var11.getLineEnd(var8);
                  float var4 = var11.getLineWidth(var8);

                  for(float var6 = var10.measureText("..."); (float)var1 < var4 + var6; var4 = var10.measureText(var9.subSequence(var7, var2 + 1).toString())) {
                     --var2;
                  }

                  this.setText(var9.subSequence(0, var2) + "...");
               }
            }
         }

         var10.setTextSize(var3);
         this.setLineSpacing(this.mSpacingAdd, this.mSpacingMult);
         if(this.mTextResizeListener != null) {
            this.mTextResizeListener.onTextResize(this, var5, var3);
         }

         this.mNeedsResize = false;
      }
   }

   public void setAddEllipsis(boolean var1) {
      this.mAddEllipsis = var1;
   }

   public void setLineSpacing(float var1, float var2) {
      super.setLineSpacing(var1, var2);
      this.mSpacingMult = var2;
      this.mSpacingAdd = var1;
   }

   public void setMaxTextSize(float var1) {
      this.mMaxTextSize = var1;
      this.requestLayout();
      this.invalidate();
   }

   public void setMinTextSize(float var1) {
      this.mMinTextSize = var1;
      this.requestLayout();
      this.invalidate();
   }

   public void setOnResizeListener(AutoResizeTextView$OnTextResizeListener var1) {
      this.mTextResizeListener = var1;
   }

   public void setTextSize(float var1) {
      super.setTextSize(var1);
      this.mTextSize = this.getTextSize();
   }

   public void setTextSize(int var1, float var2) {
      super.setTextSize(var1, var2);
      this.mTextSize = this.getTextSize();
   }
}
