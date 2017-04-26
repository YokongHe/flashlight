package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.LinearLayout.LayoutParams;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;

class SpinningProgressView extends ViewGroup {
   private final ProgressBar mProgressBar;
   private int mProgressIndicatorRadius;

   SpinningProgressView(Context var1) {
      super(var1);
      LayoutParams var2 = new LayoutParams(-1, -1);
      var2.gravity = 17;
      this.setLayoutParams(var2);
      this.setVisibility(8);
      this.setBackgroundColor(-16777216);
      this.getBackground().setAlpha(180);
      this.mProgressBar = new ProgressBar(var1);
      this.mProgressIndicatorRadius = Dips.asIntPixels(25.0F, this.getContext());
      this.mProgressBar.setIndeterminate(true);
      this.addView(this.mProgressBar);
   }

   boolean addToRoot(View var1) {
      Preconditions.checkNotNull(var1);
      var1 = var1.getRootView();
      if(var1 != null && var1 instanceof ViewGroup) {
         ViewGroup var2 = (ViewGroup)var1;
         this.setVisibility(0);
         this.setMeasuredDimension(var1.getWidth(), var1.getHeight());
         var2.addView(this);
         this.forceLayout();
         return true;
      } else {
         return false;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if(var1) {
         var2 = (var2 + var4) / 2;
         var3 = (var3 + var5) / 2;
         this.mProgressBar.layout(var2 - this.mProgressIndicatorRadius, var3 - this.mProgressIndicatorRadius, var2 + this.mProgressIndicatorRadius, var3 + this.mProgressIndicatorRadius);
      }

   }

   boolean removeFromRoot() {
      Views.removeFromParent(this);
      this.setVisibility(8);
      return true;
   }
}
