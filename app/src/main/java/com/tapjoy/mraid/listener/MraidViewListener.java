package com.tapjoy.mraid.listener;

import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;

public interface MraidViewListener {
   boolean onClose();

   boolean onConsoleMessage(ConsoleMessage var1);

   boolean onEventFired();

   boolean onExpand();

   boolean onExpandClose();

   void onPageFinished(WebView var1, String var2);

   void onPageStarted(WebView var1, String var2, Bitmap var3);

   boolean onReady();

   void onReceivedError(WebView var1, int var2, String var3, String var4);

   boolean onResize();

   boolean onResizeClose();

   boolean shouldOverrideUrlLoading(WebView var1, String var2);
}
