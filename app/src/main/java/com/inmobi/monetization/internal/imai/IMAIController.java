package com.inmobi.monetization.internal.imai;

import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.ApiStatCollector$ApiEventType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.monetization.internal.imai.IMAIController$InterstitialAdStateListener;
import com.inmobi.monetization.internal.imai.IMAICore;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class IMAIController {
   public static final String IMAI_BRIDGE = "imaiController";
   private transient WeakReference a;
   private IMAIController$InterstitialAdStateListener b;

   public IMAIController(IMWebView var1) {
      IMAICore.initialize();
      this.a = new WeakReference(var1);
   }

   @JavascriptInterface
   public void fireAdFailed() {
      if(this.b != null) {
         this.b.onAdFailed();
      }

   }

   @JavascriptInterface
   public void fireAdReady() {
      if(this.b != null) {
         this.b.onAdReady();
      }

   }

   @JavascriptInterface
   public String getPlatformVersion() {
      Log.debug("[InMobi]-[Monetization]", "get platform version");
      return Integer.toString(VERSION.SDK_INT);
   }

   @JavascriptInterface
   public String getSdkVersion() {
      Log.debug("[InMobi]-[Monetization]", "get sdk version");
      return InMobi.getVersion();
   }

   @JavascriptInterface
   public void log(String var1) {
      Log.debug("[InMobi]-[Monetization]", var1);
   }

   @JavascriptInterface
   public void openEmbedded(String var1) {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(1001), (JSONObject)null));

      try {
         Log.debug("[InMobi]-[Monetization]", "IMAI open Embedded");
         if(!IMAICore.validateURL(var1)) {
            IMAICore.fireErrorEvent(this.a, "Null url passed", "openEmbedded", var1);
         } else if(!var1.startsWith("http") && !var1.startsWith("https")) {
            this.openExternal(var1);
         } else {
            IMAICore.launchEmbeddedBrowser(this.a, var1);
            IMAICore.fireOpenEmbeddedSuccessful(this.a, var1);
         }
      } catch (Exception var3) {
         IMAICore.fireErrorEvent(this.a, var3.getMessage(), "openEmbedded", var1);
         Log.internal("[InMobi]-[Monetization]", "IMAI openEmbedded failed", var3);
      }
   }

   @JavascriptInterface
   public void openExternal(String var1) {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(1002), (JSONObject)null));

      try {
         Log.debug("[InMobi]-[Monetization]", "IMAI open external");
         if(!IMAICore.validateURL(var1)) {
            IMAICore.fireErrorEvent(this.a, "Null url passed", "openExternal", var1);
         } else {
            IMAICore.launchExternalApp(var1);
            IMAICore.fireOpenExternalSuccessful(this.a, var1);
         }
      } catch (Exception var3) {
         IMAICore.fireErrorEvent(this.a, var3.getMessage(), "openExternal", var1);
         Log.internal("[InMobi]-[Monetization]", "IMAI openExternal failed", var3);
      }
   }

   @JavascriptInterface
   public void ping(String var1, boolean var2) {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(1003), (JSONObject)null));

      try {
         Log.debug("[InMobi]-[Monetization]", "IMAI ping");
         if(!IMAICore.validateURL(var1)) {
            IMAICore.fireErrorEvent(this.a, "Null url passed", "ping", var1);
         } else if(!var1.contains("http") && !var1.contains("https")) {
            IMAICore.fireErrorEvent(this.a, "Invalid url passed", "ping", var1);
         } else {
            IMAICore.ping(this.a, var1, var2);
         }
      } catch (Exception var4) {
         IMAICore.fireErrorEvent(this.a, var4.getMessage(), "ping", var1);
         Log.internal("[InMobi]-[Monetization]", "IMAI ping failed", var4);
      }
   }

   @JavascriptInterface
   public void pingInWebView(String var1, boolean var2) {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(1004), (JSONObject)null));

      try {
         Log.debug("[InMobi]-[Monetization]", "IMAI ping in webview");
         if(!IMAICore.validateURL(var1)) {
            IMAICore.fireErrorEvent(this.a, "Null url passed", "pingInWebView", var1);
         } else if(!var1.contains("http") && !var1.contains("https")) {
            IMAICore.fireErrorEvent(this.a, "Invalid url passed", "pingInWebView", var1);
         } else {
            IMAICore.pingInWebview(this.a, var1, var2);
         }
      } catch (Exception var4) {
         IMAICore.fireErrorEvent(this.a, var4.getMessage(), "pingInWebView", var1);
         Log.internal("[InMobi]-[Monetization]", "IMAI pingInWebView failed", var4);
      }
   }

   public void setInterstitialAdStateListener(IMAIController$InterstitialAdStateListener var1) {
      this.b = var1;
   }
}
