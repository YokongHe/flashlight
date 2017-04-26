package org.nexage.sourcekit.util;

import android.text.TextUtils;
import org.nexage.sourcekit.util.VASTLog;

public class HttpTools {
   private static final String TAG = HttpTools.class.getName();

   // $FF: synthetic method
   static String access$0() {
      return TAG;
   }

   public static void httpGetURL(final String var0) {
      if(!TextUtils.isEmpty(var0)) {
         (new Thread() {
            public void run() {
               // $FF: Couldn't be decompiled
            }
         }).start();
      } else {
         VASTLog.w(TAG, "url is null or empty");
      }
   }
}
