package com.smaato.soma.bannerutilities;

import android.webkit.JavascriptInterface;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;

class AbstractBannerPackage$HtmlGetterJSInterface {
   private static final String AL_ANDROID_APP_NAME = "al:android:app_name";
   private static final String AL_ANDROID_CLASS = "al:android:class";
   private static final String AL_ANDROID_PACKAGE = "al:android:package";
   private static final String AL_ANDROID_URL = "al:android:url";
   private static final String CONTENT = "content";
   private static final String PROPERTY = "property";
   // $FF: synthetic field
   final AbstractBannerPackage this$0;

   private AbstractBannerPackage$HtmlGetterJSInterface(AbstractBannerPackage var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   AbstractBannerPackage$HtmlGetterJSInterface(AbstractBannerPackage var1, AbstractBannerPackage$HtmlGetterJSInterface var2) {
      this(var1);
   }

   // $FF: synthetic method
   static AbstractBannerPackage access$1(AbstractBannerPackage$HtmlGetterJSInterface var0) {
      return var0.this$0;
   }

   @JavascriptInterface
   public void processJSON(final String var1) {
      (new CrashReportTemplate() {
         // $FF: synthetic method
         static AbstractBannerPackage$HtmlGetterJSInterface access$1(Object var0) {
            return AbstractBannerPackage$HtmlGetterJSInterface.this;
         }

         public Void process() {
            // $FF: Couldn't be decompiled
         }
      }).execute();
   }
}
