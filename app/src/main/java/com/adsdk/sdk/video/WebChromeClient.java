package com.adsdk.sdk.video;

import android.app.Activity;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.RichMediaActivity;

public class WebChromeClient extends android.webkit.WebChromeClient {
   private RichMediaActivity mActivity;

   public WebChromeClient(Activity var1) {
      if(var1 instanceof RichMediaActivity) {
         this.mActivity = (RichMediaActivity)var1;
      }

   }

   public void onHideCustomView() {
      Log.d("WebChromeClient onHideCustomView");
      if(this.mActivity == null) {
         super.onHideCustomView();
      } else {
         this.mActivity.onHideCustomView();
      }
   }

   public void onShowCustomView(View var1, CustomViewCallback var2) {
      Log.d("WebChromeClient onShowCustomView");
      if(this.mActivity == null) {
         super.onShowCustomView(var1, var2);
      } else {
         this.mActivity.onShowCustomView(var1, var2);
      }
   }
}
