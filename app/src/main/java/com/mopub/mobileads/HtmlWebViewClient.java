package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions$NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.HtmlWebViewListener;
import com.mopub.mobileads.MoPubErrorCode;

class HtmlWebViewClient extends WebViewClient {
   static final String MOPUB_FAIL_LOAD = "mopub://failLoad";
   static final String MOPUB_FINISH_LOAD = "mopub://finishLoad";
   private final String mClickthroughUrl;
   private final Context mContext;
   private BaseHtmlWebView mHtmlWebView;
   private HtmlWebViewListener mHtmlWebViewListener;
   private final String mRedirectUrl;

   HtmlWebViewClient(HtmlWebViewListener var1, BaseHtmlWebView var2, String var3, String var4) {
      this.mHtmlWebViewListener = var1;
      this.mHtmlWebView = var2;
      this.mClickthroughUrl = var3;
      this.mRedirectUrl = var4;
      this.mContext = var2.getContext();
   }

   private void handleCustomIntentFromUri(Uri var1) {
      String var2;
      String var3;
      try {
         var2 = var1.getQueryParameter("fnc");
         var3 = var1.getQueryParameter("data");
      } catch (UnsupportedOperationException var4) {
         MoPubLog.w("Could not handle custom intent with uri: " + var1);
         return;
      }

      Intent var5 = new Intent(var2);
      var5.addFlags(268435456);
      var5.putExtra("com.mopub.intent.extra.AD_CLICK_DATA", var3);
      var2 = "Could not handle custom intent: " + var2 + ". Is your intent spelled correctly?";
      this.launchIntentForUserClick(this.mContext, var5, var2);
   }

   private boolean handlePhoneScheme(String var1) {
      if(!this.isPhoneScheme(var1)) {
         return false;
      } else {
         Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         var2.addFlags(268435456);
         var1 = "Could not handle intent with URI: " + var1 + ". Is this intent supported on your phone?";
         this.launchIntentForUserClick(this.mContext, var2, var1);
         return true;
      }
   }

   private boolean handleSpecialMoPubScheme(String var1) {
      if(!this.isSpecialMoPubScheme(var1)) {
         return false;
      } else {
         Uri var3 = Uri.parse(var1);
         String var2 = var3.getHost();
         if("finishLoad".equals(var2)) {
            this.mHtmlWebViewListener.onLoaded(this.mHtmlWebView);
         } else if("close".equals(var2)) {
            this.mHtmlWebViewListener.onCollapsed();
         } else if("failLoad".equals(var2)) {
            this.mHtmlWebViewListener.onFailed(MoPubErrorCode.UNSPECIFIED);
         } else if("custom".equals(var2)) {
            this.handleCustomIntentFromUri(var3);
         }

         return true;
      }
   }

   private boolean isPhoneScheme(String var1) {
      return var1.startsWith("tel:") || var1.startsWith("voicemail:") || var1.startsWith("sms:") || var1.startsWith("mailto:") || var1.startsWith("geo:") || var1.startsWith("google.streetview:");
   }

   private boolean isSpecialMoPubScheme(String var1) {
      return var1.startsWith("mopub://");
   }

   private boolean launchApplicationUrl(String var1) {
      Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
      var2.addFlags(268435456);
      return this.launchIntentForUserClick(this.mContext, var2, "Unable to open intent.");
   }

   private void showMoPubBrowserForUrl(String var1) {
      String var2;
      label15: {
         if(var1 != null) {
            var2 = var1;
            if(!var1.equals("")) {
               break label15;
            }
         }

         var2 = "about:blank";
      }

      MoPubLog.d("Final URI to show in browser: " + var2);
      Bundle var3 = new Bundle();
      var3.putString("URL", var2);
      Intent var4 = Intents.getStartActivityIntent(this.mContext, MoPubBrowser.class, var3);
      if(!this.launchIntentForUserClick(this.mContext, var4, "Could not handle intent action. . Perhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.")) {
         var4 = new Intent("android.intent.action.VIEW", Uri.parse("about:blank"));
         var4.setFlags(268435456);
         this.launchIntentForUserClick(this.mContext, var4, (String)null);
      }

   }

   boolean launchIntentForUserClick(Context var1, Intent var2, String var3) {
      Preconditions$NoThrow.checkNotNull(var2);
      if(var1 == null) {
         MoPubLog.d(var3);
      } else if(this.mHtmlWebView.wasClicked()) {
         try {
            Intents.startActivity(var1, var2);
            this.mHtmlWebViewListener.onClicked();
            this.mHtmlWebView.onResetUserClick();
            return true;
         } catch (IntentNotResolvableException var4) {
            MoPubLog.d(var3);
            return false;
         }
      }

      return false;
   }

   public void onPageStarted(WebView var1, String var2, Bitmap var3) {
      if(this.mRedirectUrl != null && var2.startsWith(this.mRedirectUrl)) {
         var1.stopLoading();
         this.showMoPubBrowserForUrl(var2);
      }

   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      MoPubLog.d("Ad clicked. Click URL: " + var2);
      if(!this.handleSpecialMoPubScheme(var2) && !this.handlePhoneScheme(var2)) {
         if(Intents.isNativeBrowserScheme(var2)) {
            String var4 = "Unable to load mopub native browser url: " + var2;

            try {
               Intent var5 = Intents.intentForNativeBrowserScheme(var2);
               this.launchIntentForUserClick(this.mContext, var5, var4);
               return true;
            } catch (UrlParseException var3) {
               MoPubLog.d(var4 + ". " + var3.getMessage());
               return true;
            }
         } else if(!Intents.isHttpUrl(var2) && Intents.canHandleApplicationUrl(this.mContext, var2)) {
            this.launchApplicationUrl(var2);
            return true;
         } else {
            this.showMoPubBrowserForUrl(var2);
            return true;
         }
      } else {
         return true;
      }
   }
}
