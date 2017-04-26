package com.inmobi.commons.analytics.iat.impl.net;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerWebViewLoader$AdTrackerWebViewClient;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerWebViewLoader$JSInterface;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerWebViewLoader$a;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

@SuppressLint({"SetJavaScriptEnabled"})
public class AdTrackerWebViewLoader {
   private WebView a;
   private Goal b;
   private String c;
   private long d = 0L;
   private long e = 0L;

   public AdTrackerWebViewLoader() {
      AdTrackerNetworkInterface.getUIHandler().post(new Runnable() {
         public void run() {
            AdTrackerWebViewLoader.this.a = new WebView(InternalSDKUtil.getContext());
            AdTrackerWebViewLoader.this.a.setWebViewClient(new AdTrackerWebViewLoader$AdTrackerWebViewClient(AdTrackerWebViewLoader.this));
            AdTrackerWebViewLoader.this.a.getSettings().setJavaScriptEnabled(true);
            AdTrackerWebViewLoader.this.a.getSettings().setCacheMode(2);
            AdTrackerWebViewLoader.this.a.addJavascriptInterface(new AdTrackerWebViewLoader$JSInterface(), "iatsdk");
         }
      });
   }

   // $FF: synthetic method
   static AdTrackerWebViewLoader$a a(AdTrackerWebViewLoader var0, String var1) {
      return var0.a(var1);
   }

   private AdTrackerWebViewLoader$a a(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static int b(AdTrackerWebViewLoader var0, String var1) {
      return var0.b(var1);
   }

   private int b(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static long b(AdTrackerWebViewLoader var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static long b(AdTrackerWebViewLoader var0, long var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static Goal c(AdTrackerWebViewLoader var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static String d(AdTrackerWebViewLoader var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static long e(AdTrackerWebViewLoader var0) {
      return var0.e;
   }

   public void deinit(int var1) {
      AdTrackerNetworkInterface.getUIHandler().postDelayed(new Runnable() {
         public void run() {
            if(AdTrackerWebViewLoader.this.a != null) {
               AdTrackerWebViewLoader.this.a.stopLoading();
               AdTrackerWebViewLoader.this.a.destroy();
            }

         }
      }, (long)var1);
   }

   public boolean loadWebview(String var1, Goal var2) {
      this.b = var2;
      this.c = var1;
      AdTrackerNetworkInterface.getUIHandler().post(new Runnable() {
         public void run() {
            AdTrackerWebViewLoader.this.d = System.currentTimeMillis();
            Log.internal("[InMobi]-[AdTracker]-4.5.2", "Load Webview: " + AdTrackerNetworkInterface.b());
            AdTrackerWebViewLoader.this.a.loadUrl(AdTrackerNetworkInterface.b());
         }
      });
      return true;
   }
}
