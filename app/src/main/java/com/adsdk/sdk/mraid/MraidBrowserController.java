package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.adsdk.sdk.mraid.MraidAbstractController;
import com.adsdk.sdk.mraid.MraidBrowser;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.Utils;

class MraidBrowserController extends MraidAbstractController {
   private static final String LOGTAG = "MraidBrowserController";
   private Context mContext;

   MraidBrowserController(MraidView var1) {
      super(var1);
      this.mContext = var1.getContext();
   }

   private boolean canHandleApplicationUrl(String var1) {
      Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
      if(!Utils.deviceCanHandleIntent(this.mContext, var2)) {
         Log.w("MoPub", "Could not handle application specific action: " + var1 + ". You may be running in the emulator or another device which does not " + "have the required application.");
         return false;
      } else {
         return true;
      }
   }

   private boolean executeIntent(Context var1, Intent var2, String var3) {
      try {
         var1.startActivity(var2);
         return true;
      } catch (Exception var4) {
         if(var3 == null) {
            var3 = "Unable to start intent.";
         }

         Log.d("MoPub", var3);
         return false;
      }
   }

   private boolean isWebSiteUrl(String var1) {
      return var1.startsWith("http://") || var1.startsWith("https://");
   }

   private boolean launchApplicationUrl(String var1) {
      Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
      var2.addFlags(268435456);
      return this.executeIntent(this.getMraidView().getContext(), var2, "Unable to open intent.");
   }

   protected void open(String var1) {
      Log.d("MraidBrowserController", "Opening url: " + var1);
      MraidView var2 = this.getMraidView();
      if(var2.getOnOpenListener() != null) {
         var2.getOnOpenListener().onOpen(var2);
      }

      if(!this.isWebSiteUrl(var1) && this.canHandleApplicationUrl(var1)) {
         this.launchApplicationUrl(var1);
      } else {
         Intent var3 = new Intent(this.mContext, MraidBrowser.class);
         var3.putExtra("extra_url", var1);
         var3.addFlags(268435456);
         this.mContext.startActivity(var3);
      }
   }
}
