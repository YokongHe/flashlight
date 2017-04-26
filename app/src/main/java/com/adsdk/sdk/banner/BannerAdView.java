package com.adsdk.sdk.banner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.banner.BannerAdView$BannerAdViewListener;
import com.adsdk.sdk.banner.InAppWebView;
import com.adsdk.sdk.data.ClickType;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressLint({"ViewConstructor", "SetJavaScriptEnabled"})
public class BannerAdView extends RelativeLayout {
   public static final int LIVE = 0;
   public static final int TEST = 1;
   private static Field mWebView_LAYER_TYPE_SOFTWARE;
   private static Method mWebView_SetLayerType;
   private BannerAdView$BannerAdViewListener adListener;
   private boolean animation;
   private Animation fadeInAnimation = null;
   private int height;
   private boolean isInternalBrowser = false;
   private Context mContext = null;
   protected boolean mIsInForeground;
   private AdResponse response;
   private boolean wasUserAction = false;
   private WebSettings webSettings;
   private WebView webView;
   private int width;

   static {
      initCompatibility();
   }

   public BannerAdView(Context var1, AdResponse var2, int var3, int var4, boolean var5, BannerAdView$BannerAdViewListener var6) {
      super(var1);
      this.mContext = var1;
      this.response = var2;
      this.width = var3;
      this.height = var4;
      this.animation = var5;
      this.adListener = var6;
      this.initialize(var1);
   }

   private void buildBannerView() {
      this.webView = this.createWebView(this.mContext);
      Log.d("ADSDK", "Create view flipper");
      float var1 = this.mContext.getResources().getDisplayMetrics().density;
      if(this.width != 0 && this.height != 0) {
         this.setLayoutParams(new LayoutParams((int)((float)this.width * var1 + 0.5F), (int)(var1 * (float)this.height + 0.5F)));
      } else {
         this.setLayoutParams(new LayoutParams((int)(300.0F * var1 + 0.5F), (int)(var1 * 50.0F + 0.5F)));
      }

      LayoutParams var2 = new LayoutParams(-1, -1);
      this.addView(this.webView, var2);
      Log.d("ADSDK", "animation: " + this.animation);
      if(this.animation) {
         this.fadeInAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
         this.fadeInAnimation.setDuration(1000L);
         this.webView.setAnimation(this.fadeInAnimation);
      }

   }

   private WebView createWebView(Context var1) {
      WebView var2 = new WebView(this.getContext()) {
         public void draw(Canvas var1) {
            if(this.getWidth() > 0 && this.getHeight() > 0) {
               super.draw(var1);
            }

         }

         public boolean onTouchEvent(MotionEvent var1) {
            BannerAdView.this.wasUserAction = true;
            return super.onTouchEvent(var1);
         }
      };
      this.webSettings = var2.getSettings();
      this.webSettings.setJavaScriptEnabled(true);
      var2.setBackgroundColor(0);
      setLayer(var2);
      var2.setWebViewClient(new WebViewClient() {
         public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            if(BannerAdView.this.wasUserAction) {
               if(BannerAdView.this.response.getSkipOverlay() == 1) {
                  BannerAdView.this.doOpenUrl(var2);
                  Log.i("TouchListener", "false");
                  return true;
               } else {
                  Log.i("TouchListener", "default");
                  BannerAdView.this.openLink();
                  return true;
               }
            } else {
               return false;
            }
         }
      });
      var2.setVerticalScrollBarEnabled(false);
      var2.setHorizontalScrollBarEnabled(false);
      return var2;
   }

   private void doOpenUrl(String var1) {
      this.adListener.onClick();
      if(this.response.getClickUrl() != null && this.response.getSkipOverlay() == 1) {
         this.makeTrackingRequest(this.response.getClickUrl());
      }

      if(this.response.getClickType() == null || !this.response.getClickType().equals(ClickType.INAPP) || !var1.startsWith("http://") && !var1.startsWith("https://")) {
         this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)));
      } else {
         Intent var2;
         if(var1.endsWith(".mp4")) {
            var2 = new Intent("android.intent.action.VIEW");
            var2.setDataAndType(Uri.parse(var1), "video/mp4");
            this.startActivity(var2);
         } else {
            var2 = new Intent(this.getContext(), InAppWebView.class);
            var2.putExtra("REDIRECT_URI", var1);
            this.startActivity(var2);
         }
      }
   }

   private static void initCompatibility() {
      // $FF: Couldn't be decompiled
   }

   private void initialize(Context var1) {
      initCompatibility();
      this.buildBannerView();
   }

   private void makeTrackingRequest(final String var1) {
      (new AsyncTask() {
         protected Void doInBackground(Void... var1x) {
            if(var1.startsWith("market")) {
               return null;
            } else {
               try {
                  DefaultHttpClient var6 = new DefaultHttpClient();
                  HttpGet var2 = new HttpGet();
                  var2.setHeader("User-Agent", System.getProperty("http.agent"));
                  var2.setURI(new URI(var1));
                  var6.execute(var2);
                  return null;
               } catch (URISyntaxException var3) {
                  var3.printStackTrace();
                  return null;
               } catch (ClientProtocolException var4) {
                  var4.printStackTrace();
                  return null;
               } catch (IOException var5) {
                  var5.printStackTrace();
                  return null;
               }
            }
         }
      }).execute(new Void[0]);
   }

   private void openLink() {
      if(this.response != null && this.response.getClickUrl() != null) {
         this.doOpenUrl(this.response.getClickUrl());
      }

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

   private void startActivity(Intent var1) {
      if(!(this.getContext() instanceof Activity)) {
         var1.addFlags(268435456);
      }

      this.getContext().startActivity(var1);
   }

   public boolean isInternalBrowser() {
      return this.isInternalBrowser;
   }

   public void setAdListener(BannerAdView$BannerAdViewListener var1) {
      this.adListener = var1;
   }

   public void setInternalBrowser(boolean var1) {
      this.isInternalBrowser = var1;
   }

   public void showContent() {
      // $FF: Couldn't be decompiled
   }
}
