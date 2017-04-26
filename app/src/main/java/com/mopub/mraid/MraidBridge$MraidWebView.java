package com.mopub.mraid;

import android.content.Context;
import android.view.View;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mraid.MraidBridge$MraidWebView$OnVisibilityChangedListener;

public class MraidBridge$MraidWebView extends BaseWebView {
   private boolean mIsVisible;
   private MraidBridge$MraidWebView$OnVisibilityChangedListener mOnVisibilityChangedListener;

   public MraidBridge$MraidWebView(Context var1) {
      super(var1);
      boolean var2;
      if(this.getVisibility() == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mIsVisible = var2;
   }

   public boolean isVisible() {
      return this.mIsVisible;
   }

   protected void onVisibilityChanged(View var1, int var2) {
      super.onVisibilityChanged(var1, var2);
      boolean var3;
      if(var2 == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(var3 != this.mIsVisible) {
         this.mIsVisible = var3;
         if(this.mOnVisibilityChangedListener != null) {
            this.mOnVisibilityChangedListener.onVisibilityChanged(this.mIsVisible);
         }
      }

   }

   void setVisibilityChangedListener(MraidBridge$MraidWebView$OnVisibilityChangedListener var1) {
      this.mOnVisibilityChangedListener = var1;
   }
}
