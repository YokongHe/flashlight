package com.amazon.device.ads;

import android.content.Context;
import android.os.Looper;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebViewFactory;

class UserAgentManager {
   private String userAgentStringWithSDKVersion;
   private String userAgentStringWithoutSDKVersion;

   public String getUserAgentString() {
      return this.userAgentStringWithSDKVersion;
   }

   public void populateUserAgentString(final Context var1) {
      if(this.userAgentStringWithSDKVersion == null) {
         if(!AndroidTargetUtils.isAtLeastAndroidAPI(7)) {
            if(Thread.currentThread() == Looper.getMainLooper().getThread()) {
               this.userAgentStringWithoutSDKVersion = WebViewFactory.getInstance().createWebView(var1).getSettings().getUserAgentString();
               this.userAgentStringWithSDKVersion = this.userAgentStringWithoutSDKVersion + " " + Version.getUserAgentSDKVersion();
               return;
            }

            ThreadUtils.executeOnMainThread(new Runnable() {
               public void run() {
                  UserAgentManager.this.userAgentStringWithoutSDKVersion = WebViewFactory.getInstance().createWebView(var1).getSettings().getUserAgentString();
                  UserAgentManager.this.userAgentStringWithSDKVersion = UserAgentManager.this.userAgentStringWithoutSDKVersion + " " + Version.getUserAgentSDKVersion();
               }
            });
            return;
         }

         this.userAgentStringWithoutSDKVersion = System.getProperty("http.agent");
         this.userAgentStringWithSDKVersion = this.userAgentStringWithoutSDKVersion + " " + Version.getUserAgentSDKVersion();
      }

   }

   public void setUserAgentString(String var1) {
      if(var1 != null && !var1.equals(this.userAgentStringWithoutSDKVersion)) {
         this.userAgentStringWithoutSDKVersion = var1;
         this.userAgentStringWithSDKVersion = var1 + " " + Version.getUserAgentSDKVersion();
      }

   }
}
