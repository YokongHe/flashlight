package com.adsdk.sdk.video;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.RichMediaActivity;
import com.adsdk.sdk.video.WebViewClient$OnPageLoadedListener;

public class WebViewClient extends android.webkit.WebViewClient {
   private Activity mActivity;
   private boolean mAllowNavigation = false;
   private String mAllowedUrl;
   private long mFinishedLoadingTime;
   private WebViewClient$OnPageLoadedListener mOnPageLoadedListener;

   public WebViewClient(Activity var1, boolean var2) {
      this.mActivity = var1;
      this.mAllowNavigation = var2;
      this.mFinishedLoadingTime = 0L;
   }

   public String getAllowedUrl() {
      return this.mAllowedUrl;
   }

   public long getFinishedLoadingTime() {
      return this.mFinishedLoadingTime;
   }

   public void onPageFinished(WebView var1, String var2) {
      super.onPageFinished(var1, var2);
      Log.d("onPageFinished:" + var2 + " mAllowedUrl:" + this.mAllowedUrl);
      if(this.mAllowedUrl == null || var2.equals(this.mAllowedUrl)) {
         if(this.mFinishedLoadingTime == 0L) {
            this.mFinishedLoadingTime = System.currentTimeMillis();
         }

         if(this.mOnPageLoadedListener != null) {
            this.mOnPageLoadedListener.onPageLoaded();
         }
      }

   }

   public void setAllowedUrl(String var1) {
      this.mFinishedLoadingTime = 0L;
      this.mAllowedUrl = var1;
      if(this.mAllowedUrl != null) {
         var1 = Uri.parse(this.mAllowedUrl).getPath();
         if(var1 == null || var1.length() == 0) {
            this.mAllowedUrl = this.mAllowedUrl + "/";
         }
      }

   }

   public void setOnPageLoadedListener(WebViewClient$OnPageLoadedListener var1) {
      this.mOnPageLoadedListener = var1;
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      Log.d("Loading url:" + var2);
      Intent var8;
      if(!var2.startsWith("market:") && !var2.startsWith("http://market.android.com") && !var2.startsWith("sms:") && !var2.startsWith("tel:") && !var2.startsWith("mailto:") && !var2.startsWith("voicemail:") && !var2.startsWith("geo:") && !var2.startsWith("google.streetview:")) {
         if(var2.startsWith("mfox:external:")) {
            var8 = new Intent("android.intent.action.VIEW", Uri.parse(var2.substring(14)));
            this.mActivity.startActivity(var8);
            return true;
         } else if(var2.startsWith("mfox:replayvideo")) {
            try {
               this.mActivity.getClass().getMethod("replayVideo", new Class[0]).invoke(this.mActivity, new Object[0]);
               return true;
            } catch (NoSuchMethodException var3) {
               Log.d("Your activity class has no replayVideo method");
               return true;
            } catch (Exception var4) {
               Log.d("Couldn\'t run replayVideo method in your Activity");
               return true;
            }
         } else if(var2.startsWith("mfox:playvideo")) {
            try {
               this.mActivity.getClass().getMethod("playVideo", new Class[0]).invoke(this.mActivity, new Object[0]);
               return true;
            } catch (NoSuchMethodException var5) {
               Log.d("Your activity class has no playVideo method");
               return true;
            } catch (Exception var6) {
               Log.d("Couldn\'t run replayVideo method in your Activity");
               return true;
            }
         } else if(var2.startsWith("mfox:skip")) {
            this.mActivity.finish();
            return true;
         } else if(!this.mAllowNavigation && !var2.equals(this.mAllowedUrl)) {
            var8 = new Intent(this.mActivity, RichMediaActivity.class);
            var8.setData(Uri.parse(var2));
            this.mActivity.startActivity(var8);
            return true;
         } else {
            var1.loadUrl(var2);
            return true;
         }
      } else {
         var8 = new Intent("android.intent.action.VIEW", Uri.parse(var2));

         try {
            this.mActivity.startActivity(var8);
            return true;
         } catch (ActivityNotFoundException var7) {
            Log.w("Could open URL: " + var2);
            return true;
         }
      }
   }
}
