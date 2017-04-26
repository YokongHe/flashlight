package com.inmobi.monetization.internal.imai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebSettings.PluginState;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.RequestResponseManager;
import com.inmobi.monetization.internal.imai.WebviewLoader$MyWebViewClient;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebviewLoader {
   static boolean a = false;
   static AtomicBoolean b = null;
   private WebView c = null;

   @SuppressLint({"SetJavaScriptEnabled"})
   public WebviewLoader(final Context var1) {
      RequestResponseManager.b.post(new Runnable() {
         public void run() {
            try {
               WebviewLoader.this.c = new WebView(var1);
               WebviewLoader.b = new AtomicBoolean(false);
               WebviewLoader.this.c.setWebViewClient(new WebviewLoader$MyWebViewClient());
               WebviewLoader.this.c.getSettings().setJavaScriptEnabled(true);
               WebviewLoader.this.c.getSettings().setPluginState(PluginState.ON);
               WebviewLoader.this.c.getSettings().setCacheMode(2);
            } catch (Exception var2) {
               Log.internal("[InMobi]-[Monetization]", "Exception init webview", var2);
            }
         }
      });
   }

   public void deinit(int var1) {
      RequestResponseManager.b.postDelayed(new Runnable() {
         public void run() {
            try {
               if(WebviewLoader.this.c != null) {
                  WebviewLoader.this.c.stopLoading();
                  WebviewLoader.this.c.destroy();
                  WebviewLoader.this.c = null;
                  WebviewLoader.b.set(false);
               }

            } catch (Exception var2) {
               Log.internal("[InMobi]-[Monetization]", "Exception deinit webview ", var2);
            }
         }
      }, (long)var1);
   }

   public void loadInWebview(final String var1, final HashMap var2) {
      RequestResponseManager.b.post(new Runnable() {
         public void run() {
            try {
               WebviewLoader.b.set(true);
               WebviewLoader.this.c.loadUrl(var1, var2);
            } catch (Exception var2x) {
               Log.internal("[InMobi]-[Monetization]", "Exception load in webview", var2x);
            }
         }
      });
   }

   public void stopLoading() {
      RequestResponseManager.b.post(new Runnable() {
         public void run() {
            try {
               if(WebviewLoader.this.c != null) {
                  WebviewLoader.b.set(false);
               }

               WebviewLoader.this.c.stopLoading();
            } catch (Exception var2) {
               Log.internal("[InMobi]-[Monetization]", "Exception stop loading", var2);
            }
         }
      });
   }
}
