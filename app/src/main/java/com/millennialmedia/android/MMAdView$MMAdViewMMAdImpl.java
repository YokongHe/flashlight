package com.millennialmedia.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMAdView$MMAdViewWebViewClientListener;
import com.millennialmedia.android.MMLayout$MMLayoutMMAdImpl;
import com.millennialmedia.android.MMSDK;
import java.util.Map;
import java.util.Random;

class MMAdView$MMAdViewMMAdImpl extends MMLayout$MMLayoutMMAdImpl {
   // $FF: synthetic field
   final MMAdView this$0;

   public MMAdView$MMAdViewMMAdImpl(MMAdView var1, Context var2) {
      super(var1, var2);
      this.this$0 = var1;
      this.mmWebViewClientListener = new MMAdView$MMAdViewWebViewClientListener(this);
   }

   void animateTransition() {
      if(this.this$0.refreshAnimationimageView.getDrawable() != null) {
         int var2 = this.this$0.transitionType;
         int var1 = var2;
         if(var2 == 4) {
            var1 = (new Random()).nextInt(4);
         }

         final Object var3;
         switch(var1) {
         case 2:
            var3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -((float)this.this$0.getHeight()));
            break;
         case 3:
            var3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, (float)this.this$0.getHeight());
            break;
         default:
            var3 = new AlphaAnimation(1.0F, 0.0F);
         }

         ((Animation)var3).setDuration(1000L);
         ((Animation)var3).setAnimationListener(this.this$0);
         ((Animation)var3).setFillEnabled(true);
         ((Animation)var3).setFillBefore(true);
         ((Animation)var3).setFillAfter(true);
         MMSDK.runOnUiThread(new Runnable() {
            public void run() {
               MMAdView$MMAdViewMMAdImpl.this.this$0.refreshAnimationimageView.startAnimation((Animation)var3);
            }
         });
      }

   }

   String getReqType() {
      return "getad";
   }

   String getRequestCompletedAction() {
      return "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
   }

   String getRequestFailedAction() {
      return "millennialmedia.action.ACTION_GETAD_FAILED";
   }

   public boolean hasCachedVideoSupport() {
      return false;
   }

   void insertUrlAdMetaValues(Map var1) {
      if(this.this$0.height > 0) {
         var1.put("hsht", String.valueOf(this.this$0.height));
      }

      if(this.this$0.width > 0) {
         var1.put("hswd", String.valueOf(this.this$0.width));
      }

      super.insertUrlAdMetaValues(var1);
   }

   public boolean isBanner() {
      return true;
   }

   boolean isLifecycleObservable() {
      return this.this$0.getWindowToken() != null;
   }

   boolean isTransitionAnimated() {
      return this.this$0.transitionType != 0;
   }

   void prepareTransition(Bitmap var1) {
      this.this$0.refreshAnimationimageView.setImageBitmap(var1);
      this.this$0.refreshAnimationimageView.setVisibility(0);
      this.this$0.refreshAnimationimageView.bringToFront();
   }
}
