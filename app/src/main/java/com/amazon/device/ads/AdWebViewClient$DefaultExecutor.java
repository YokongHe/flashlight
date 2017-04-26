package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AdWebViewClient$UrlExecutor;
import com.amazon.device.ads.WebUtils;

class AdWebViewClient$DefaultExecutor implements AdWebViewClient$UrlExecutor {
   private final Context context;

   public AdWebViewClient$DefaultExecutor(Context var1) {
      this.context = var1;
   }

   public boolean execute(String var1) {
      WebUtils.launchActivityForIntentLink(var1, this.context);
      return true;
   }
}
