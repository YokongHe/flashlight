package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;

class WebViewFactory {
   private static WebViewFactory instance = new WebViewFactory();
   private static boolean isWebViewCheckedAndOk = false;
   private boolean cookieSyncManagerCreated = false;

   protected WebViewFactory() {
      this.shouldDebugWebViews();
   }

   protected static boolean doesExceptionContainLockedDatabaseMessage(Exception var0) {
      return var0 != null && var0.getMessage() != null?var0.getMessage().contains("database is locked"):false;
   }

   public static final WebViewFactory getInstance() {
      return instance;
   }

   protected static boolean isDatabaseLocked(SQLiteException var0) {
      return AndroidTargetUtils.isAtLeastAndroidAPI(11)?AndroidTargetUtils.isInstanceOfSQLiteDatabaseLockedException(var0):doesExceptionContainLockedDatabaseMessage(var0);
   }

   public static boolean isWebViewOk(Context var0) {
      if(AndroidTargetUtils.isAtOrBelowAndroidAPI(8) && !isWebViewCheckedAndOk) {
         if(WebViewDatabase.getInstance(var0) == null) {
            return false;
         }

         SQLiteDatabase var6;
         try {
            var6 = var0.openOrCreateDatabase("webviewCache.db", 0, (CursorFactory)null);
         } catch (SQLiteException var4) {
            boolean var1 = isDatabaseLocked(var4);
            return var1;
         } finally {
            ;
         }

         if(var6 != null) {
            var6.close();
         }

         isWebViewCheckedAndOk = true;
      }

      return true;
   }

   @SuppressLint({"SetJavaScriptEnabled"})
   public static final boolean setJavaScriptEnabledForWebView(boolean var0, WebView var1, String var2) {
      try {
         var1.getSettings().setJavaScriptEnabled(var0);
         return true;
      } catch (NullPointerException var3) {
         Log.w(var2, "Could not set JavaScriptEnabled because a NullPointerException was encountered.");
         return false;
      }
   }

   public static void setVideoPlaybackProperties(WebView var0, ConnectionInfo var1) {
      if(var1 != null && var1.isWiFi()) {
         AndroidTargetUtils.webSettingsSetMediaPlaybackRequiresUserGesture(var0.getSettings(), false);
      }

   }

   private void shouldDebugWebViews() {
      if(DebugProperties.getDebugPropertyAsBoolean("debug.webViews", false)) {
         AndroidTargetUtils.enableWebViewDebugging(true);
      }

   }

   private void updateAdIdCookie() {
      if(this.cookieSyncManagerCreated) {
         String var2 = InternalAdRegistration.getInstance().getRegistrationInfo().getAdId();
         String var1 = var2;
         if(var2 == null) {
            var1 = "";
         }

         this.setCookie("http://amazon-adsystem.com", "ad-id=" + var1 + "; Domain=.amazon-adsystem.com");
      }

   }

   public WebView createWebView(Context var1) {
      synchronized(this){}

      WebView var2;
      try {
         var2 = new WebView(var1);
         InternalAdRegistration.getInstance().getDeviceInfo().setUserAgentString(var2.getSettings().getUserAgentString());
         var2.getSettings().setUserAgentString(InternalAdRegistration.getInstance().getDeviceInfo().getUserAgentString());
         if(!this.cookieSyncManagerCreated) {
            CookieSyncManager.createInstance(var1);
            this.cookieSyncManagerCreated = true;
         }

         this.updateAdIdCookie();
      } finally {
         ;
      }

      return var2;
   }

   protected void setCookie(String var1, String var2) {
      CookieManager.getInstance().setCookie(var1, var2);
   }
}
