package com.millennialmedia.android;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.millennialmedia.android.HttpRedirection;
import com.millennialmedia.android.HttpRedirection$RedirectionListenerImpl;
import com.millennialmedia.android.MMCommand;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.MMWebViewClient$MMWebViewClientListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class MMWebViewClient extends WebViewClient {
   private static final String TAG = "MMWebViewClient";
   private ExecutorService cachedExecutor = Executors.newCachedThreadPool();
   boolean isLastMMCommandResize;
   MMWebViewClient$MMWebViewClientListener mmWebViewClientListener;
   HttpRedirection$RedirectionListenerImpl redirectListenerImpl;

   MMWebViewClient(MMWebViewClient$MMWebViewClientListener var1, HttpRedirection$RedirectionListenerImpl var2) {
      this.mmWebViewClientListener = var1;
      this.redirectListenerImpl = var2;
   }

   public void onPageFinished(WebView var1, String var2) {
      MMWebView var3 = (MMWebView)var1;
      if(!var3.isOriginalUrl(var2)) {
         this.mmWebViewClientListener.onPageFinished(var2);
         var3.setAdProperties();
         this.setMraidState(var3);
         MMLog.d("MMWebViewClient", "onPageFinished webview: " + var3.toString() + "url is " + var2);
      }

      super.onPageFinished(var1, var2);
   }

   public void onPageStarted(WebView var1, String var2, Bitmap var3) {
      MMLog.d("MMWebViewClient", String.format("onPageStarted: %s", new Object[]{var2}));
      this.mmWebViewClientListener.onPageStarted(var2);
      MMWebView var4 = (MMWebView)var1;
      var4.mraidState = "loading";
      var4.requiresPreAdSizeFix = false;
      super.onPageStarted(var1, var2, var3);
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      MMLog.e("MMWebViewClient", String.format("Error: %s %s %s", new Object[]{Integer.valueOf(var2), var3, var4}));
   }

   abstract void setMraidState(MMWebView var1);

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      MMWebView var3 = (MMWebView)var1;
      if(!var3.isOriginalUrl(var2)) {
         MMLog.v("MMWebViewClient", "@@@@@@@@@@SHOULDOVERRIDELOADING@@@@@@@@@@@@@ Url is " + var2 + " for " + var1);
         if(var2.substring(0, 6).equalsIgnoreCase("mmsdk:")) {
            MMLog.v("MMWebViewClient", "Running JS bridge command: " + var2);
            MMCommand var4 = new MMCommand((MMWebView)var1, var2);
            this.isLastMMCommandResize = var4.isResizeCommand();
            this.cachedExecutor.execute(var4);
            return true;
         }

         if(this.redirectListenerImpl.isExpandingToUrl()) {
            return false;
         }

         this.redirectListenerImpl.url = var2;
         this.redirectListenerImpl.weakContext = new WeakReference(var1.getContext());
         this.redirectListenerImpl.creatorAdImplInternalId = var3.creatorAdImplId;
         HttpRedirection.startActivityFromUri(this.redirectListenerImpl);
      }

      return true;
   }
}
