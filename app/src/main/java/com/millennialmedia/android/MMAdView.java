package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.millennialmedia.android.DTOResizeParameters;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMAdView$MMAdViewMMAdImpl;
import com.millennialmedia.android.MMAdView$ResizeView;
import com.millennialmedia.android.MMLayout;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.RequestListener;
import com.millennialmedia.android.Utils$ThreadUtils;

public final class MMAdView extends MMLayout implements OnClickListener, AnimationListener {
   static final int DEFAULT_RESIZE_PARAM_VALUES = -50;
   private static final String TAG = "MMAdView";
   public static final int TRANSITION_DOWN = 3;
   public static final int TRANSITION_FADE = 1;
   public static final int TRANSITION_NONE = 0;
   public static final int TRANSITION_RANDOM = 4;
   public static final int TRANSITION_UP = 2;
   int height;
   int oldHeight;
   int oldWidth;
   ImageView refreshAnimationimageView;
   int transitionType;
   MMAdView$ResizeView view;
   int width;

   public MMAdView(Context var1) {
      super(var1);
      this.transitionType = 4;
      this.height = 0;
      this.width = 0;
      this.oldHeight = -50;
      this.oldWidth = -50;
      this.adImpl = new MMAdView$MMAdViewMMAdImpl(this, var1);
      this.init(var1);
   }

   @Deprecated
   public MMAdView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   @Deprecated
   public MMAdView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.transitionType = 4;
      this.height = 0;
      this.width = 0;
      this.oldHeight = -50;
      this.oldWidth = -50;
      if(!this.isInEditMode()) {
         MMLog.d("MMAdView", "Creating MMAdView from XML layout.");
         this.adImpl = new MMAdView$MMAdViewMMAdImpl(this, var1);
         if(var2 != null) {
            super.setApid(var2.getAttributeValue("http://millennialmedia.com/android/schema", "apid"));
            this.adImpl.ignoreDensityScaling = var2.getAttributeBooleanValue("http://millennialmedia.com/android/schema", "ignoreDensityScaling", false);
            String var4 = var2.getAttributeValue("http://millennialmedia.com/android/schema", "height");
            String var5 = var2.getAttributeValue("http://millennialmedia.com/android/schema", "width");

            try {
               if(!TextUtils.isEmpty(var4)) {
                  this.height = Integer.parseInt(var4);
               }

               if(!TextUtils.isEmpty(var5)) {
                  this.width = Integer.parseInt(var5);
               }
            } catch (NumberFormatException var6) {
               MMLog.e("MMAdView", "Error reading attrs file from xml", var6);
            }

            if(this.adImpl.mmRequest != null) {
               this.adImpl.mmRequest.age = var2.getAttributeValue("http://millennialmedia.com/android/schema", "age");
               this.adImpl.mmRequest.children = var2.getAttributeValue("http://millennialmedia.com/android/schema", "children");
               this.adImpl.mmRequest.education = var2.getAttributeValue("http://millennialmedia.com/android/schema", "education");
               this.adImpl.mmRequest.ethnicity = var2.getAttributeValue("http://millennialmedia.com/android/schema", "ethnicity");
               this.adImpl.mmRequest.gender = var2.getAttributeValue("http://millennialmedia.com/android/schema", "gender");
               this.adImpl.mmRequest.income = var2.getAttributeValue("http://millennialmedia.com/android/schema", "income");
               this.adImpl.mmRequest.keywords = var2.getAttributeValue("http://millennialmedia.com/android/schema", "keywords");
               this.adImpl.mmRequest.marital = var2.getAttributeValue("http://millennialmedia.com/android/schema", "marital");
               this.adImpl.mmRequest.politics = var2.getAttributeValue("http://millennialmedia.com/android/schema", "politics");
               this.adImpl.mmRequest.vendor = var2.getAttributeValue("http://millennialmedia.com/android/schema", "vendor");
               this.adImpl.mmRequest.zip = var2.getAttributeValue("http://millennialmedia.com/android/schema", "zip");
            }

            this.goalId = var2.getAttributeValue("http://millennialmedia.com/android/schema", "goalId");
         }

         this.init(var1);
      } else {
         this.initEclipseAd(var1);
      }
   }

   // $FF: synthetic method
   static void access$000(MMAdView var0, View var1) {
      var0.attachToWindow(var1);
   }

   // $FF: synthetic method
   static void access$100(MMAdView var0, View var1) {
      var0.detachFromParent(var1);
   }

   private void attachToWindow(View param1) {
      // $FF: Couldn't be decompiled
   }

   private void callSetTranslationX(int var1) {
      try {
         View.class.getMethod("setTranslationX", new Class[]{Float.TYPE}).invoke(this, new Object[]{Integer.valueOf(var1)});
      } catch (Exception var3) {
         MMLog.e("MMAdView", "Unable to call setTranslationX", var3);
      }
   }

   private void callSetTranslationY(int var1) {
      try {
         View.class.getMethod("setTranslationY", new Class[]{Float.TYPE}).invoke(this, new Object[]{Integer.valueOf(var1)});
      } catch (Exception var3) {
         MMLog.e("MMAdView", "Unable to call setTranslationY", var3);
      }
   }

   private void detachFromParent(View param1) {
      // $FF: Couldn't be decompiled
   }

   private void getAdInternal() {
      if(this.adImpl != null) {
         this.adImpl.requestAd();
      }

   }

   private boolean hasDefaultResizeParams() {
      return this.oldWidth == -50 && this.oldHeight == -50;
   }

   private void init(Context var1) {
      this.setBackgroundColor(0);
      this.adImpl.adType = "b";
      this.setOnClickListener(this);
      this.setFocusable(true);
      this.refreshAnimationimageView = new ImageView(var1);
      this.refreshAnimationimageView.setScaleType(ScaleType.FIT_XY);
      this.refreshAnimationimageView.setVisibility(8);
      this.addView(this.refreshAnimationimageView, new LayoutParams(-2, -2));
      this.setLayoutParams(new LayoutParams(-2, -2));
   }

   private void initEclipseAd(Context param1) {
      // $FF: Couldn't be decompiled
   }

   private void setUnresizeParameters() {
      if(this.hasDefaultResizeParams()) {
         android.view.ViewGroup.LayoutParams var1 = this.getLayoutParams();
         this.oldWidth = var1.width;
         this.oldHeight = var1.height;
         if(this.oldWidth <= 0) {
            this.oldWidth = this.getWidth();
         }

         if(this.oldHeight <= 0) {
            this.oldHeight = this.getHeight();
         }
      }

   }

   final void closeAreaTouched() {
      this.adImpl.unresizeToDefault();
   }

   public final void getAd() {
      if(this.adImpl != null && this.adImpl.requestListener != null) {
         this.getAd(this.adImpl.requestListener);
      } else {
         this.getAdInternal();
      }
   }

   public final void getAd(RequestListener var1) {
      if(this.adImpl != null) {
         this.adImpl.requestListener = var1;
      }

      this.getAdInternal();
   }

   final void handleMraidResize(DTOResizeParameters param1) {
      // $FF: Couldn't be decompiled
   }

   final void handleUnresize() {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public final void onAnimationEnd(Animation var1) {
      this.refreshAnimationimageView.setVisibility(8);
   }

   @Deprecated
   public final void onAnimationRepeat(Animation var1) {
   }

   @Deprecated
   public final void onAnimationStart(Animation var1) {
   }

   @Deprecated
   public final void onClick(View var1) {
      MMLog.d("MMAdView", "On click for " + var1.getId() + " view, " + var1 + " adimpl" + this.adImpl);
      this.onTouchEvent(MotionEvent.obtain(0L, System.currentTimeMillis(), 1, 0.0F, 0.0F, 0));
   }

   protected final void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      Utils$ThreadUtils.execute(new Runnable() {
         public void run() {
            float var1 = MMAdView.this.getContext().getResources().getDisplayMetrics().density;
            if(MMAdView.this.width <= 0) {
               MMAdView.this.width = (int)((float)MMAdView.this.getWidth() / var1);
            }

            if(MMAdView.this.height <= 0) {
               MMAdView.this.height = (int)((float)MMAdView.this.getHeight() / var1);
            }

         }
      });
   }

   public final void onWindowFocusChanged(boolean var1) {
      super.onWindowFocusChanged(var1);
      if(var1 && this.adImpl != null && this.adImpl.controller != null) {
         if(this.adImpl.controller.webView == null) {
            this.adImpl.controller.webView = MMAdImplController.getWebViewFromExistingAdImpl(this.adImpl);
         }

         MMWebView var2 = this.adImpl.controller.webView;
         if(var2 != null && !var2.isCurrentParent(this.adImpl.internalId) && !var2.mraidState.equals("expanded")) {
            var2.removeFromParent();
            this.addView(var2);
            return;
         }
      }

   }

   public final void setBackgroundColor(int var1) {
      super.setBackgroundColor(var1);
      if(this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
         this.adImpl.controller.webView.setBackgroundColor(var1);
      }

   }

   public final void setHeight(int var1) {
      this.height = var1;
   }

   public final void setTransitionType(int var1) {
      this.transitionType = var1;
   }

   public final void setWidth(int var1) {
      this.width = var1;
   }
}
