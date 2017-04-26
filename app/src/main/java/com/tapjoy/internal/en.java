package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.PluginState;
import com.tapjoy.internal.eo;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.fd;
import com.tapjoy.internal.fg;
import com.tapjoy.internal.fh;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class en extends fh {
   private static final Method d;
   private static final Method e;
   private static final Method f;
   private static final Method g;
   private static final Method h;
   private static final String i = en.class.getName();
   private static final TreeMap m;
   private WebView a = null;
   private boolean b = false;
   private eo c = null;
   private boolean j = false;
   private WebSettings k;
   private final boolean l;

   static {
      Method var0 = a(WebView.class, "evaluateJavascript", new Class[]{String.class, ValueCallback.class});
      d = var0;
      if(var0 == null && VERSION.SDK_INT >= 19) {
         Log.e(i, "Failed to find expected function: evaluateJavascript");
      }

      var0 = a(WebSettings.class, "getDefaultUserAgent", new Class[]{Context.class});
      e = var0;
      if(var0 == null && VERSION.SDK_INT >= 17) {
         Log.e(i, "Failed to find expected function: getDefaultUserAgent");
      }

      var0 = a(WebSettings.class, "setPluginState", new Class[]{PluginState.class});
      f = var0;
      if(var0 == null && (VERSION.SDK_INT >= 8 || VERSION.SDK_INT <= 18)) {
         Log.e(i, "Failed to find expected function: setPluginState");
      }

      var0 = a(WebView.class, "removeJavascriptInterface", new Class[]{String.class});
      g = var0;
      if(var0 == null && VERSION.SDK_INT >= 11) {
         Log.e(i, "Failed to find expected function: removeJavascriptInterface");
      }

      var0 = a(WebView.class, "addJavascriptInterface", new Class[]{Object.class, String.class});
      h = var0;
      if(var0 == null && VERSION.SDK_INT >= 17) {
         Log.e(i, "Failed to find expected function: addJavascriptInterface");
      }

      TreeMap var1 = new TreeMap();
      m = var1;
      var1.put(Integer.valueOf(9), "533.1");
      m.put(Integer.valueOf(10), "533.1");
      m.put(Integer.valueOf(11), "533.1");
      m.put(Integer.valueOf(12), "533.1");
      m.put(Integer.valueOf(13), "534.13");
      m.put(Integer.valueOf(14), "534.30");
      m.put(Integer.valueOf(15), "534.30");
      m.put(Integer.valueOf(16), "534.30");
      m.put(Integer.valueOf(17), "534.30");
      m.put(Integer.valueOf(18), "534.30");
   }

   @SuppressLint({"SetJavaScriptEnabled"})
   public en(Context var1, eo var2, boolean var3) {
      this.j = b();
      String var4 = i;
      StringBuilder var5 = (new StringBuilder("JSExecutor() Build: ")).append(VERSION.RELEASE);
      if(this.j) {
         var4 = " busted js interface ";
      } else {
         var4 = " normal js interface ";
      }

      var5 = var5.append(var4);
      if(a()) {
         var4 = " has async interface ";
      } else {
         var4 = " has no async interface ";
      }

      var5.append(var4);
      this.c = var2;
      this.l = var3;
      if(var3) {
         var3 = ev.a();
         this.b = false;
         this.a = ev.a(var1);
         if(this.a != null) {
            if(var3 && !this.b) {
               Log.w(i, "WebView re-used from previous instance. Using a short-lived TrustDefenderMobile object is not recommended. Better profiling performance will be achieved by re-using a long-lived TrustDefenderMobile instance");
            }

            String var6 = i;
            StringBuilder var7 = new StringBuilder("Webview ");
            if(this.b) {
               var6 = "init\'d";
            } else {
               var6 = "un-init\'d";
            }

            var7.append(var6);
            if(this.c == null) {
               this.c = new eo((CountDownLatch)null);
            }

            WebViewClient var8 = new WebViewClient();
            this.k = this.a.getSettings();
            this.k.setJavaScriptEnabled(true);
            a(this.k, f, new Object[]{PluginState.ON});
            this.a.setVisibility(4);
            if(!this.j) {
               a(this.a, g, new Object[]{"androidJSInterface"});
            }

            this.a.setWebViewClient(var8);
            if(a()) {
               if(this.c.a == null) {
                  Log.e(i, "alternate JS interface but no global latch");
               }

               var6 = i;
               return;
            }

            if(!this.j) {
               a(this.a, h, new Object[]{this.c, "androidJSInterface"});
               return;
            }

            if(this.c.a == null) {
               Log.e(i, "broken JS interface but no global latch");
            }

            var6 = i;
            this.a.setWebChromeClient(new fg(this.c));
            return;
         }
      }

   }

   public static boolean a() {
      return d != null;
   }

   public static boolean b() {
      try {
         boolean var0 = VERSION.RELEASE.startsWith("2.3");
         return var0;
      } catch (Exception var2) {
         return false;
      }
   }

   public static String c() {
      String var0 = i;
      if(m.containsKey(Integer.valueOf(VERSION.SDK_INT))) {
         var0 = (String)m.get(Integer.valueOf(VERSION.SDK_INT));
      } else {
         var0 = (String)m.lastEntry().getValue() + "+";
      }

      String var2 = Locale.getDefault().getLanguage();
      String var3 = Locale.getDefault().getCountry();
      String var1 = var2;
      if(!var3.isEmpty()) {
         var1 = var2 + "-" + var3;
      }

      return "Mozilla/5.0 (Linux; U; Android " + VERSION.RELEASE + "; " + var1.toLowerCase(Locale.US) + "; " + Build.MODEL + " Build/" + Build.DISPLAY + ") AppleWebKit/" + var0 + " (KHTML, like Gecko) Version/4.0 Mobile Safari/" + var0 + " " + fd.a;
   }

   public final String a(Context var1) {
      String var2 = (String)a((Object)null, e, new Object[]{var1});
      if(var2 == null || var2.isEmpty()) {
         String var3 = var2;
         if(this.l) {
            var3 = var2;
            if(this.k != null) {
               var3 = this.k.getUserAgentString();
            }
         }

         if(var3 != null) {
            var2 = var3;
            if(!var3.isEmpty()) {
               return var2;
            }
         }

         return c();
      } else {
         return var2;
      }
   }

   public final String a(String var1) {
      if(this.b) {
         if(Thread.currentThread().isInterrupted()) {
            return "";
         }

         CountDownLatch var3;
         if(!this.j && !a()) {
            var3 = new CountDownLatch(1);
            this.c.a(var3);
         } else {
            var3 = null;
         }

         if(a()) {
            var1 = "javascript:(function(){try{return " + var1 + " + \"\";}catch(js_eval_err){return \'\';}})();";
         } else if(!this.j) {
            var1 = "javascript:window.androidJSInterface.getString((function(){try{return " + var1 + " + \"\";}catch(js_eval_err){return \'\';}})());";
         } else {
            var1 = "javascript:alert((function(){try{return " + var1 + " + \"\";}catch(js_eval_err){return \'\';}})());";
         }

         String var4 = i;
         (new StringBuilder("getJSResult() attempting to execute: ")).append(var1);
         this.c.b = null;
         if(a()) {
            boolean var2;
            label56: {
               try {
                  d.invoke(this.a, new Object[]{var1, this.c});
               } catch (IllegalAccessException var5) {
                  Log.e(i, "getJSResult() invoke failed: ", var5);
                  var2 = true;
                  break label56;
               } catch (IllegalArgumentException var6) {
                  Log.e(i, "getJSResult() invoke failed: ", var6);
                  var2 = true;
                  break label56;
               } catch (InvocationTargetException var7) {
                  Log.e(i, "getJSResult() invoke failed: ", var7);
                  var2 = true;
                  break label56;
               }

               var2 = false;
            }

            if(var2 && this.c.a != null) {
               var1 = i;
               (new StringBuilder("getJSResult countdown for latch: ")).append(this.c.a.hashCode()).append(" with count: ").append(this.c.a.getCount());
               this.c.a.countDown();
            }
         } else {
            this.a.loadUrl(var1);
         }

         if(!this.j && !a()) {
            if(var3 != null) {
               var1 = i;
               (new StringBuilder("getJSResult waiting for latch: ")).append(var3.hashCode()).append(" with count: ").append(var3.getCount());
               if(!var3.await(5L, TimeUnit.SECONDS)) {
                  var1 = i;
                  (new StringBuilder("getJSResult timeout waiting for latch: ")).append(var3.hashCode()).append(" with count: ").append(var3.getCount());
               }
            } else {
               Log.e(i, "latch == null");
            }

            if(this.c.b == null) {
               var1 = i;
            } else {
               var1 = i;
               (new StringBuilder("getJSResult() After latch: got ")).append(this.c.b);
            }

            return this.c.b;
         }
      }

      return null;
   }

   public final boolean a(boolean var1) {
      return var1 != this.l || !this.b;
   }

   public final void d() {
      String var1 = i;
      (new StringBuilder("init() - init\'d = ")).append(this.b);
      if(!this.b) {
         if(this.a == null) {
            var1 = i;
            this.b = true;
         } else {
            var1 = i;
            String var2;
            CountDownLatch var3;
            if(!this.j && !a()) {
               var3 = new CountDownLatch(1);
               var2 = i;
               (new StringBuilder("Creating latch: ")).append(var3.hashCode()).append(" with count: ").append(var3.getCount());
               var2 = "<html><head></head><body onLoad=\'javascript:window.androidJSInterface.getString(1)\'></body></html>";
               this.c.a(var3);
               this.c.b = null;
            } else {
               var2 = "<html><head></head><body></body></html>";
               var3 = null;
            }

            if(!Thread.currentThread().isInterrupted()) {
               this.a.loadData(var2, "text/html", (String)null);
               if(!this.j && var3 != null && !a()) {
                  var2 = i;
                  (new StringBuilder("waiting for latch: ")).append(var3.hashCode()).append(" with count: ").append(var3.getCount());
                  if(!var3.await(5L, TimeUnit.SECONDS)) {
                     Log.e(i, "timed out waiting for javascript");
                     return;
                  }

                  this.b = true;
                  var2 = i;
                  (new StringBuilder("in init() count = ")).append(var3.getCount());
                  if(this.c.b == null) {
                     var1 = i;
                     return;
                  }

                  var1 = i;
                  (new StringBuilder("init() After latch: got ")).append(this.c.b);
                  return;
               }

               this.b = true;
               return;
            }
         }
      }

   }
}
