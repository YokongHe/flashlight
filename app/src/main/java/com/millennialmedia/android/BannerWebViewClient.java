package com.millennialmedia.android;

import com.millennialmedia.android.HttpRedirection$RedirectionListenerImpl;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.MMWebViewClient;
import com.millennialmedia.android.MMWebViewClient$MMWebViewClientListener;

class BannerWebViewClient extends MMWebViewClient {
   BannerWebViewClient(MMWebViewClient$MMWebViewClientListener var1, HttpRedirection$RedirectionListenerImpl var2) {
      super(var1, var2);
   }

   void setMraidState(MMWebView var1) {
      var1.setMraidPlacementTypeInline();
      var1.setMraidDefault();
      var1.setMraidReady();
   }
}
