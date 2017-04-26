package com.smaato.soma.bannerutilities;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.internal.statemachine.LoadingState;

class AbstractBannerPackage$InternalWebViewClient extends WebViewClient {
   final LoadingState mLoadingStateMachine;
   // $FF: synthetic field
   final AbstractBannerPackage this$0;

   private AbstractBannerPackage$InternalWebViewClient(AbstractBannerPackage var1, LoadingState var2) {
      this.this$0 = var1;
      this.mLoadingStateMachine = var2;
   }

   // $FF: synthetic method
   AbstractBannerPackage$InternalWebViewClient(AbstractBannerPackage var1, LoadingState var2, AbstractBannerPackage$InternalWebViewClient var3) {
      this(var1, var2);
   }

   public void onPageFinished(final WebView var1, String var2) {
      (new CrashReportTemplate() {
         public Void process() {
            Debugger.showLog(new LogMessage("Banner_Package", "Page Finished Loading...", 1, DebugCategory.DEBUG));
            AbstractBannerPackage$InternalWebViewClient.this.mLoadingStateMachine.transitionFinishLoading();
            var1.loadUrl("javascript:(function() {  var metaTags = document.getElementsByTagName(\'meta\');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute(\'property\');    if (property && property.substring(0, \'al:\'.length) === \'al:\') {      var tag = { \"property\": metaTags[i].getAttribute(\'property\') };      if (metaTags[i].hasAttribute(\'content\')) {        tag[\'content\'] = metaTags[i].getAttribute(\'content\');      }      results.push(tag);    }  }  window.HTMLOUT.processJSON(JSON.stringify(results));})()");
            return null;
         }
      }).execute();
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            return Boolean.valueOf(false);
         }
      }).execute()).booleanValue();
   }
}
