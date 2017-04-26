package com.facebook.ads.a;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class r {
   private static final String a = com.facebook.ads.a.r.class.getSimpleName();

   @JavascriptInterface
   public void alert(String var1) {
      Log.e(a, var1);
   }

   @JavascriptInterface
   public String getAnalogInfo() {
      return com.facebook.ads.a.p.a(com.facebook.ads.a.a.a());
   }
}
