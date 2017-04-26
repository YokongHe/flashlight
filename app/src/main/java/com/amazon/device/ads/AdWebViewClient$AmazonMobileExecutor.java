package com.amazon.device.ads;

import android.content.Context;
import android.net.Uri;
import com.amazon.device.ads.AdWebViewClient;
import com.amazon.device.ads.AdWebViewClient$UrlExecutor;
import com.amazon.device.ads.AmazonDeviceLauncher;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.WebUtils;
import java.util.Iterator;
import java.util.List;

class AdWebViewClient$AmazonMobileExecutor implements AdWebViewClient$UrlExecutor {
   private final Context context;

   AdWebViewClient$AmazonMobileExecutor(Context var1) {
      this.context = var1;
   }

   public boolean execute(String var1) {
      this.specialUrlClicked(var1);
      return true;
   }

   protected void handleApplicationDefinedSpecialURL(String var1) {
      Log.i(AdWebViewClient.access$100(), "Special url clicked, but was not handled by SDK. Url: %s", new Object[]{var1});
   }

   protected boolean launchExternalActivity(String var1) {
      return WebUtils.launchActivityForIntentLink(var1, this.context);
   }

   public void specialUrlClicked(String var1) {
      Log.d(AdWebViewClient.access$100(), "Executing AmazonMobile Intent");
      Uri var3 = Uri.parse(var1);

      List var2;
      try {
         var2 = var3.getQueryParameters("intent");
      } catch (UnsupportedOperationException var4) {
         var2 = null;
      }

      if(var2 != null && var2.size() > 0) {
         Iterator var6 = var2.iterator();

         do {
            if(!var6.hasNext()) {
               this.handleApplicationDefinedSpecialURL(var1);
               return;
            }
         } while(!this.launchExternalActivity((String)var6.next()));
      } else {
         if(!AmazonDeviceLauncher.isWindowshopPresent(this.context)) {
            this.handleApplicationDefinedSpecialURL(var1);
            return;
         }

         if(var3.getHost().equals("shopping")) {
            String var5 = var3.getQueryParameter("app-action");
            if(var5 != null && var5.length() != 0) {
               if(var5.equals("detail")) {
                  var1 = var3.getQueryParameter("asin");
                  if(var1 != null && var1.length() != 0) {
                     AmazonDeviceLauncher.launchWindowshopDetailPage(this.context, var1);
                     return;
                  }
               } else if(var5.equals("search")) {
                  var1 = var3.getQueryParameter("keyword");
                  if(var1 != null && var1.length() != 0) {
                     AmazonDeviceLauncher.launchWindowshopSearchPage(this.context, var1);
                     return;
                  }
               } else if(var5.equals("webview")) {
                  this.handleApplicationDefinedSpecialURL(var1);
                  return;
               }
            }
         }
      }

   }
}
