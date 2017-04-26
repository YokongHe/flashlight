package com.mopub.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.mopub.common.util.Dips;

class MraidScreenMetrics {
   private final Context mContext;
   private final Rect mCurrentAdRect;
   private final Rect mCurrentAdRectDips;
   private final Rect mDefaultAdRect;
   private final Rect mDefaultAdRectDips;
   private final float mDensity;
   private final Rect mRootViewRect;
   private final Rect mRootViewRectDips;
   private final Rect mScreenRect;
   private final Rect mScreenRectDips;

   MraidScreenMetrics(Context var1, float var2) {
      this.mContext = var1.getApplicationContext();
      this.mDensity = var2;
      this.mScreenRect = new Rect();
      this.mScreenRectDips = new Rect();
      this.mRootViewRect = new Rect();
      this.mRootViewRectDips = new Rect();
      this.mCurrentAdRect = new Rect();
      this.mCurrentAdRectDips = new Rect();
      this.mDefaultAdRect = new Rect();
      this.mDefaultAdRectDips = new Rect();
   }

   private void convertToDips(Rect var1, Rect var2) {
      var2.set(Dips.pixelsToIntDips((float)var1.left, this.mContext), Dips.pixelsToIntDips((float)var1.top, this.mContext), Dips.pixelsToIntDips((float)var1.right, this.mContext), Dips.pixelsToIntDips((float)var1.bottom, this.mContext));
   }

   Rect getCurrentAdRect() {
      return this.mCurrentAdRect;
   }

   Rect getCurrentAdRectDips() {
      return this.mCurrentAdRectDips;
   }

   Rect getDefaultAdRect() {
      return this.mDefaultAdRect;
   }

   Rect getDefaultAdRectDips() {
      return this.mDefaultAdRectDips;
   }

   public float getDensity() {
      return this.mDensity;
   }

   Rect getRootViewRect() {
      return this.mRootViewRect;
   }

   Rect getRootViewRectDips() {
      return this.mRootViewRectDips;
   }

   Rect getScreenRect() {
      return this.mScreenRect;
   }

   Rect getScreenRectDips() {
      return this.mScreenRectDips;
   }

   void setCurrentAdPosition(int var1, int var2, int var3, int var4) {
      this.mCurrentAdRect.set(var1, var2, var1 + var3, var2 + var4);
      this.convertToDips(this.mCurrentAdRect, this.mCurrentAdRectDips);
   }

   void setDefaultAdPosition(int var1, int var2, int var3, int var4) {
      this.mDefaultAdRect.set(var1, var2, var1 + var3, var2 + var4);
      this.convertToDips(this.mDefaultAdRect, this.mDefaultAdRectDips);
   }

   void setRootViewPosition(int var1, int var2, int var3, int var4) {
      this.mRootViewRect.set(var1, var2, var1 + var3, var2 + var4);
      this.convertToDips(this.mRootViewRect, this.mRootViewRectDips);
   }

   void setScreenSize(int var1, int var2) {
      this.mScreenRect.set(0, 0, var1, var2);
      this.convertToDips(this.mScreenRect, this.mScreenRectDips);
   }
}
