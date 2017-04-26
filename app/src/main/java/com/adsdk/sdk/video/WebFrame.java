package com.adsdk.sdk.video;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebSettings.PluginState;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.FrameLayout.LayoutParams;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.ResourceManager;
import com.adsdk.sdk.video.WebFrame$LoadUrlTask;
import com.adsdk.sdk.video.WebViewClient;
import com.adsdk.sdk.video.WebViewClient$OnPageLoadedListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressLint({"ViewConstructor"})
public class WebFrame extends FrameLayout {
   private static Field mWebView_LAYER_TYPE_SOFTWARE;
   private static Method mWebView_SetLayerType;
   private boolean enableZoom = true;
   private Activity mActivity;
   private ImageView mExitButton;
   private WebView mWebView;
   private WebViewClient mWebViewClient;

   static {
      initCompatibility();
   }

   @SuppressLint({"SetJavaScriptEnabled"})
   public WebFrame(final Activity var1, boolean var2, boolean var3, boolean var4) {
      super(var1);
      initCompatibility();
      this.mActivity = var1;
      this.mWebView = new WebView(var1);
      this.mWebView.setVerticalScrollBarEnabled(var3);
      this.mWebView.setHorizontalScrollBarEnabled(var3);
      this.mWebView.setBackgroundColor(0);
      setLayer(this.mWebView);
      WebSettings var6 = this.mWebView.getSettings();
      var6.setSavePassword(false);
      var6.setSaveFormData(false);
      var6.setJavaScriptEnabled(true);
      var6.setPluginState(PluginState.ON);
      var6.setSupportZoom(this.enableZoom);
      var6.setBuiltInZoomControls(this.enableZoom);
      this.mWebViewClient = new WebViewClient(this.mActivity, var2);
      this.mWebView.setWebViewClient(this.mWebViewClient);
      if(var4) {
         ImageView var8 = new ImageView(var1);
         var8.setBackgroundColor(0);
         this.addView(var8, new LayoutParams(-1, -1, 17));
         this.addView(this.mWebView, new LayoutParams(-1, -1, 17));
         this.mExitButton = new ImageView(var1);
         this.mExitButton.setAdjustViewBounds(false);
         this.mExitButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1x) {
               var1.finish();
            }
         });
         int var5 = (int)TypedValue.applyDimension(1, 35.0F, this.getResources().getDisplayMetrics());
         this.mExitButton.setImageDrawable(ResourceManager.getStaticResource(var1, -18));
         LayoutParams var7 = new LayoutParams(var5, var5, 53);
         var5 = (int)TypedValue.applyDimension(1, 6.0F, this.getResources().getDisplayMetrics());
         var7.topMargin = var5;
         var7.rightMargin = var5;
         this.addView(this.mExitButton, var7);
      } else {
         this.addView(this.mWebView, new LayoutParams(-1, -1, 17));
      }
   }

   // $FF: synthetic method
   static String access$0(WebFrame var0) {
      return var0.getUserAgentString();
   }

   // $FF: synthetic method
   static WebViewClient access$1(WebFrame var0) {
      return var0.mWebViewClient;
   }

   // $FF: synthetic method
   static WebView access$2(WebFrame var0) {
      return var0.mWebView;
   }

   private String getUserAgentString() {
      return this.mWebView.getSettings().getUserAgentString();
   }

   private static void initCompatibility() {
      // $FF: Couldn't be decompiled
   }

   private static void setLayer(WebView var0) {
      if(mWebView_SetLayerType != null && mWebView_LAYER_TYPE_SOFTWARE != null) {
         try {
            Log.v("Set Layer is supported");
            mWebView_SetLayerType.invoke(var0, new Object[]{Integer.valueOf(mWebView_LAYER_TYPE_SOFTWARE.getInt(WebView.class)), null});
         } catch (InvocationTargetException var1) {
            Log.v("Set InvocationTargetException");
         } catch (IllegalArgumentException var2) {
            Log.v("Set IllegalArgumentException");
         } catch (IllegalAccessException var3) {
            Log.v("Set IllegalAccessException");
         }
      } else {
         Log.v("Set Layer is not supported");
      }
   }

   public WebView getWebView() {
      return this.mWebView;
   }

   public boolean isEnableZoom() {
      return this.enableZoom;
   }

   public void loadUrl(String var1) {
      (new WebFrame$LoadUrlTask(this)).execute(new String[]{var1});
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      this.onTouchEvent(var1);
      return false;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      super.onTouchEvent(var1);
      return true;
   }

   public void setBackgroundColor(int var1) {
      super.setBackgroundColor(var1);
      this.mWebView.setBackgroundColor(var1);
   }

   public void setEnableZoom(boolean var1) {
      this.enableZoom = var1;
      WebSettings var2 = this.mWebView.getSettings();
      var2.setSupportZoom(var1);
      var2.setBuiltInZoomControls(var1);
   }

   public void setMarkup(String var1) {
      var1 = Uri.encode(var1);
      this.mWebViewClient.setAllowedUrl((String)null);
      this.mWebView.loadData(var1, "text/html", "UTF-8");
   }

   public void setOnPageLoadedListener(WebViewClient$OnPageLoadedListener var1) {
      this.mWebViewClient.setOnPageLoadedListener(var1);
   }
}
