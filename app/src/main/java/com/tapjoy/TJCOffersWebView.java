package com.tapjoy;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.webkit.WebView;
import com.tapjoy.TJAdUnitView;
import com.tapjoy.TJCOffers;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;

@TargetApi(9)
public class TJCOffersWebView extends TJAdUnitView {
   private boolean j = true;

   public void handleWebViewOnPageFinished(WebView var1, String var2) {
      if(this.j) {
         this.j = false;
         TJCOffers.onOffersResponse();
         TapjoyLog.i("Offers", "onOffersResponse fired");
      } else {
         super.handleWebViewOnPageFinished(var1, var2);
      }
   }

   public void handleWebViewOnReceivedError(WebView var1, int var2, String var3, String var4) {
      if(this.j) {
         this.j = false;
         this.finish();
         TJCOffers.onOffersResponseFailed("Failed to load offers from server");
         TapjoyLog.i("Offers", "onOffersResponseFailed fired");
      } else {
         super.handleWebViewOnReceivedError(var1, var2, var3, var4);
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      TapjoyConnectCore.viewDidOpen(1);
   }

   protected void onDestroy() {
      super.onDestroy();
      if(!this.f && this.isFinishing()) {
         TapjoyConnectCore.viewWillClose(1);
         TapjoyConnectCore.viewDidClose(1);
      }

   }

   protected void onResume() {
      super.onResume();
      if(this.c != null && this.b != null && this.e && this.i) {
         TapjoyLog.i("Offers", "onResume reload offer wall: " + this.c);
         this.b.loadUrl(this.c);
         ++this.h;
      }

   }
}
