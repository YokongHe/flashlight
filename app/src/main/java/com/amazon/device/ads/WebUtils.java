package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.WebUtils$WebUtilsExecutor;

class WebUtils {
   private static final String LOGTAG = WebUtils.class.getSimpleName();
   private static WebUtils$WebUtilsExecutor executor = new WebUtils$WebUtilsExecutor();

   // $FF: synthetic method
   static String access$000() {
      return LOGTAG;
   }

   public static String encloseHtml(String var0, boolean var1) {
      return executor.encloseHtml(var0, var1);
   }

   public static String getScheme(String var0) {
      return executor.getScheme(var0);
   }

   public static final String getURLDecodedString(String var0) {
      return executor.getURLDecodedString(var0);
   }

   public static final String getURLEncodedString(String var0) {
      return executor.getURLEncodedString(var0);
   }

   public static boolean launchActivityForIntentLink(String var0, Context var1) {
      return executor.launchActivityForIntentLink(var0, var1);
   }
}
