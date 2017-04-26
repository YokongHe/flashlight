package com.facebook.ads.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.AdSettings;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class s {
   private static String a = null;

   public static String a() {
      String var0 = AdSettings.getUrlPrefix();
      return com.facebook.ads.a.ag.a(var0)?"https://www.facebook.com/":String.format("https://www.%s.facebook.com", new Object[]{var0});
   }

   @TargetApi(17)
   private static String a(Context var0) {
      return WebSettings.getDefaultUserAgent(var0);
   }

   public static String a(Context var0, com.facebook.ads.a.o var1) {
      if(com.facebook.ads.a.o.b == var1) {
         return System.getProperty("http.agent");
      } else {
         if(a == null) {
            if(VERSION.SDK_INT >= 17) {
               a = a(var0);
            } else {
               try {
                  a = a(var0, "android.webkit.WebSettings", "android.webkit.WebView");
               } catch (Exception var3) {
                  try {
                     a = a(var0, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                  } catch (Exception var2) {
                     WebView var4 = new WebView(var0.getApplicationContext());
                     a = var4.getSettings().getUserAgentString();
                     var4.destroy();
                  }
               }
            }
         }

         return a;
      }
   }

   private static String a(Context var0, String var1, String var2) {
      Class var3 = Class.forName(var1);
      Constructor var7 = var3.getDeclaredConstructor(new Class[]{Context.class, Class.forName(var2)});
      var7.setAccessible(true);
      Method var8 = var3.getMethod("getUserAgentString", new Class[0]);

      String var6;
      try {
         var6 = (String)var8.invoke(var7.newInstance(new Object[]{var0, null}), new Object[0]);
      } finally {
         var7.setAccessible(false);
      }

      return var6;
   }

   public static void a(WebView var0) {
      if(VERSION.SDK_INT > 11) {
         var0.onPause();
      } else {
         try {
            WebView.class.getMethod("onPause", new Class[0]).invoke(var0, new Object[0]);
         } catch (Exception var1) {
            ;
         }
      }
   }

   public static void a(WebView var0, WebViewClient var1, com.facebook.ads.a.r var2) {
      var0.getSettings().setJavaScriptEnabled(true);
      var0.getSettings().setSupportZoom(false);
      var0.setHorizontalScrollBarEnabled(false);
      var0.setHorizontalScrollbarOverlay(false);
      var0.setVerticalScrollBarEnabled(false);
      var0.setVerticalScrollbarOverlay(false);
      var0.addJavascriptInterface(var2, "AdControl");
      var0.setWebViewClient(var1);
   }
}
