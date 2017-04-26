package com.adsdk.sdk.mraid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adsdk.sdk.mraid.MraidPlacementTypeProperty;
import com.adsdk.sdk.mraid.MraidView;
import java.net.URI;

class MraidView$MraidWebViewClient extends WebViewClient {
   // $FF: synthetic field
   final MraidView this$0;

   private MraidView$MraidWebViewClient(MraidView var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   MraidView$MraidWebViewClient(MraidView var1, MraidView$MraidWebViewClient var2) {
      this(var1);
   }

   public void onLoadResource(WebView var1, String var2) {
      Log.d("MraidView", "Loaded resource: " + var2);
   }

   public void onPageFinished(WebView var1, String var2) {
      if(!MraidView.access$1(this.this$0)) {
         MraidView.access$2(this.this$0).initializeJavaScriptState();
         this.this$0.fireChangeEventForProperty(MraidPlacementTypeProperty.createWithType(MraidView.access$3(this.this$0)));
         this.this$0.fireReadyEvent();
         if(this.this$0.getMraidListener() != null) {
            this.this$0.getMraidListener().onReady(this.this$0);
         }

         MraidView.access$4(this.this$0, true);
      }

   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      Log.d("MraidView", "Error: " + var3);
      super.onReceivedError(var1, var2, var3, var4);
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      String var4 = Uri.parse(var2).getScheme();
      if(var4 != null) {
         if(var4.equals("mopub")) {
            return true;
         }

         if(var4.equals("mraid")) {
            MraidView.access$0(this.this$0, URI.create(var2));
            return true;
         }
      }

      if(this.this$0.wasClicked()) {
         Intent var5 = new Intent();
         var5.setAction("android.intent.action.VIEW");
         var5.setData(Uri.parse(var2));
         var5.addFlags(268435456);

         try {
            this.this$0.getContext().startActivity(var5);
            return true;
         } catch (ActivityNotFoundException var3) {
            return false;
         }
      } else {
         return false;
      }
   }
}
