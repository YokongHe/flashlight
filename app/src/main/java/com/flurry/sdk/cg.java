package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;

public final class cg {
   public static String a(Context var0) {
      String var1;
      if(var0 == null) {
         var1 = null;
      } else {
         String var2 = b(var0);
         var1 = var2;
         if(TextUtils.isEmpty(var2)) {
            return c(var0);
         }
      }

      return var1;
   }

   @TargetApi(17)
   static String b(Context var0) {
      return var0 != null && VERSION.SDK_INT >= 17?WebSettings.getDefaultUserAgent(var0):null;
   }

   static String c(Context var0) {
      return var0 == null?null:(new WebView(var0)).getSettings().getUserAgentString();
   }
}
