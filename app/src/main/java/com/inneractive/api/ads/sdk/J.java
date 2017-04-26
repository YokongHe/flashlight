package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.inneractive.api.ads.sdk.IAmraidActionFactory$MraidJavascriptCommand;
import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import java.util.Map;

final class J extends com.inneractive.api.ads.sdk.A {
   J(Map var1, IAmraidWebView var2) {
      super(var1, var2);
   }

   private static boolean a(Context var0, Intent var1, String var2) {
      try {
         var0.startActivity(var1);
         return true;
      } catch (Exception var3) {
         if(var2 == null) {
            var2 = "Failed to start intent!";
         }

         InneractiveAdView$Log.d(var2);
         return false;
      }
   }

   final void a() {
      if(this.b.getListener() != null) {
         this.b.getListener().onClicked();
      }

      String var1 = this.b("url");
      InneractiveAdView$Log.d("opening Internal Browser For Url: " + var1);

      try {
         Uri.parse(var1);
      } catch (Exception var3) {
         InneractiveAdView$Log.a("openUrl: Invalid url " + var1);
         this.b.fireErrorEvent(IAmraidActionFactory$MraidJavascriptCommand.d, "Url can not be null.");
         return;
      }

      InneractiveAdView$Log.a("Here is the final URI to show in browser: " + var1);
      Intent var4;
      if(this.b.getAdConfig().K()) {
         var4 = com.inneractive.api.ads.sdk.an.b(this.b.getContext(), var1);
      } else {
         this.b.getContext();
         var4 = com.inneractive.api.ads.sdk.an.k(var1);
      }

      if(!a(this.b.getContext(), var4, "Could not handle intent action. . Perhaps you forgot to declare com.inneractive.ads.api.sdk.InneractiveInternalBrowserActivity in your Android manifest file.")) {
         var4 = new Intent("android.intent.action.VIEW", Uri.parse("about:blank"));
         var4.setFlags(268435456);
         a(this.b.getContext(), var4, (String)null);
      }

   }

   protected final boolean a(IAmraidWebView$MraidPlacementType var1) {
      return false;
   }
}
