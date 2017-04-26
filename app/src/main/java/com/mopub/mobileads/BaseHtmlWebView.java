package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.common.AdReport;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.mobileads.ViewGestureDetector$UserClickListener;

public class BaseHtmlWebView extends BaseWebView implements ViewGestureDetector$UserClickListener {
   private boolean mClicked;
   private final ViewGestureDetector mViewGestureDetector;

   public BaseHtmlWebView(Context var1, AdReport var2) {
      super(var1);
      this.disableScrollingAndZoom();
      this.getSettings().setJavaScriptEnabled(true);
      this.mViewGestureDetector = new ViewGestureDetector(var1, this, var2);
      this.mViewGestureDetector.setUserClickListener(this);
      if(VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
         this.enablePlugins(true);
      }

      this.setBackgroundColor(0);
   }

   private void disableScrollingAndZoom() {
      this.setHorizontalScrollBarEnabled(false);
      this.setHorizontalScrollbarOverlay(false);
      this.setVerticalScrollBarEnabled(false);
      this.setVerticalScrollbarOverlay(false);
      this.getSettings().setSupportZoom(false);
   }

   public void init(boolean var1) {
      this.initializeOnTouchListener(var1);
   }

   void initializeOnTouchListener(final boolean var1) {
      this.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1x, MotionEvent var2) {
            BaseHtmlWebView.this.mViewGestureDetector.sendTouchEvent(var2);
            return var2.getAction() == 2 && !var1;
         }
      });
   }

   void loadHtmlResponse(String var1) {
      this.loadDataWithBaseURL("http://" + Constants.HOST + "/", var1, "text/html", "utf-8", (String)null);
   }

   public void loadUrl(String var1) {
      if(var1 != null) {
         MoPubLog.d("Loading url: " + var1);
         if(var1.startsWith("javascript:")) {
            super.loadUrl(var1);
            return;
         }
      }

   }

   public void onResetUserClick() {
      this.mClicked = false;
   }

   public void onUserClick() {
      this.mClicked = true;
   }

   public boolean wasClicked() {
      return this.mClicked;
   }
}
