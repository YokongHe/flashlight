package com.tapjoy;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import com.tapjoy.TJAdUnitView;
import com.tapjoy.TJCOffers;
import com.tapjoy.TJOffersListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.mraid.listener.MraidViewListener;
import com.tapjoy.mraid.view.MraidView;
import java.net.MalformedURLException;
import java.net.URL;

final class TJAdUnitView$a implements MraidViewListener {
   // $FF: synthetic field
   final TJAdUnitView a;

   private TJAdUnitView$a(TJAdUnitView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   TJAdUnitView$a(TJAdUnitView var1, byte var2) {
      this(var1);
   }

   public final boolean onClose() {
      this.a.finish();
      return false;
   }

   @TargetApi(8)
   public final boolean onConsoleMessage(ConsoleMessage var1) {
      int var2 = 0;
      if(this.a.g.shouldClose) {
         String[] var4 = new String[]{"Uncaught", "uncaught", "Error", "error", "not defined"};
         TapjoyLog.i("TJAdUnitView", "shouldClose...");

         for(int var3 = var4.length; var2 < var3; ++var2) {
            String var5 = var4[var2];
            if(var1.message().contains(var5)) {
               this.a.handleClose();
            }
         }
      }

      return true;
   }

   public final boolean onEventFired() {
      return false;
   }

   public final boolean onExpand() {
      return false;
   }

   public final boolean onExpandClose() {
      return false;
   }

   public final void onPageFinished(WebView var1, String var2) {
      this.a.handleWebViewOnPageFinished(var1, var2);
      if(TJAdUnitView.b(this.a)) {
         TJAdUnitView.c(this.a).setVisibility(8);
      }

      this.a.g.display();
      if(this.a.b != null && this.a.b.isMraid()) {
         this.a.g.allowRedirect = false;
      }

   }

   public final void onPageStarted(WebView var1, String var2, Bitmap var3) {
      TapjoyLog.i("TJAdUnitView", "onPageStarted: " + var2);
      if(TJAdUnitView.b(this.a)) {
         TJAdUnitView.c(this.a).setVisibility(0);
         TJAdUnitView.c(this.a).bringToFront();
      }

      if(this.a.g != null) {
         this.a.g.allowRedirect = true;
         this.a.g.customClose = false;
         this.a.g.shouldClose = false;
      }

   }

   public final boolean onReady() {
      return false;
   }

   public final void onReceivedError(WebView var1, int var2, String var3, String var4) {
      this.a.handleWebViewOnReceivedError(var1, var2, var3, var4);
   }

   public final boolean onResize() {
      return false;
   }

   public final boolean onResizeClose() {
      return false;
   }

   @TargetApi(9)
   public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      if(!this.a.a()) {
         this.a.handleWebViewOnReceivedError(var1, 0, "Connection not properly established", var2);
         return true;
      } else {
         this.a.i = false;

         String var3;
         try {
            var3 = (new URL("https://ws.tapjoyads.com/")).getHost();
         } catch (MalformedURLException var4) {
            var3 = null;
         }

         TapjoyLog.i("TJAdUnitView", "interceptURL: " + var2 + " with host " + var3);
         if(this.a.b != null && this.a.b.isMraid() && var2.contains("mraid")) {
            return false;
         } else if(TJAdUnitView.d(this.a) == 4 && var2.contains("offer_wall")) {
            TJAdUnitView.a(this.a, "offer_wall");
            return true;
         } else if(TJAdUnitView.d(this.a) == 4 && var2.contains("tjvideo")) {
            TJAdUnitView.a(this.a, "tjvideo");
            return true;
         } else if(var2.startsWith("tjvideo://")) {
            TJAdUnitView.b(this.a, var2);
            return true;
         } else if(var2.contains("showOffers")) {
            TapjoyLog.i("TJAdUnitView", "showOffers");
            (new TJCOffers(this.a)).showOffers((TJOffersListener)null);
            return true;
         } else if(var2.contains("dismiss")) {
            TapjoyLog.i("TJAdUnitView", "dismiss");
            this.a.finish();
            return true;
         } else if((var3 == null || !var2.contains(var3)) && !var2.contains("tjyoutubevideo=true") && !var2.contains(TapjoyConnectCore.getRedirectDomain()) && !var2.contains(TapjoyUtil.getRedirectDomain(TapjoyConnectCore.getPlacementURL()))) {
            if(this.a.g.allowRedirect) {
               this.a.i = true;
               return false;
            } else {
               var1.loadUrl(var2);
               return true;
            }
         } else {
            TapjoyLog.i("TJAdUnitView", "Open redirecting URL:" + var2);
            ((MraidView)var1).loadUrlStandard(var2);
            return true;
         }
      }
   }
}
