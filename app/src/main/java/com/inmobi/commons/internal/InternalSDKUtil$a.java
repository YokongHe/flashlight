package com.inmobi.commons.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebSettings;

@TargetApi(17)
class InternalSDKUtil$a {
   static String a(Context var0) {
      return WebSettings.getDefaultUserAgent(var0);
   }
}
