package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.view.View;
import com.inneractive.api.ads.sdk.IAbaseWebView;
import com.inneractive.api.ads.sdk.IAbaseWebView$IAviewState;
import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.b$a;

class IAelementaryBanner extends com.inneractive.api.ads.sdk.b {
   IAmraidWebView a;
   b$a b;
   String c = "OK";

   final void a() {
   }

   final void a(Context var1, b$a var2, com.inneractive.api.ads.sdk.a var3) {
      this.b = var2;
      if(var3 == null) {
         this.b.a(InneractiveAdView$InneractiveErrorCode.SERVER_INVALID_RESPONSE);
      } else {
         com.inneractive.api.ads.sdk.ag var8 = var3.v();
         boolean var4;
         if(var8 != null && !com.inneractive.api.ads.sdk.an.a(var8.b())) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(var4) {
            this.c = var8.d;
            String var9 = var8.b();
            this.a = com.inneractive.api.ads.sdk.Y.createInstance(var1, var3);
            com.inneractive.api.ads.sdk.at var6 = new com.inneractive.api.ads.sdk.at() {
               // $FF: synthetic field
               private IAelementaryBanner a = IAelementaryBanner.this;

               public final void onAdWillOpenExternalApp() {
                  this.a.b.c();
               }

               public final void onClicked() {
                  this.a.b.b();
               }

               public final void onClose(IAbaseWebView var1, IAbaseWebView$IAviewState var2) {
                  this.a.b.g();
               }

               public final void onExpand(IAbaseWebView var1) {
                  this.a.b.f();
               }

               public final void onFailure(IAbaseWebView var1, InneractiveAdView$InneractiveErrorCode var2) {
                  this.a.b.a(var2);
               }

               public final void onInternalBrowserDismissed() {
                  this.a.b.d();
               }

               public final void onReady(IAbaseWebView var1) {
                  if("House Ad".equals(this.a.c)) {
                     this.a.b.b(this.a.a);
                  } else {
                     this.a.b.a((View)this.a.a);
                  }
               }

               public final void onResize(IAbaseWebView var1) {
                  this.a.b.h();
               }
            };
            this.a.setListener(var6);
            com.inneractive.api.ads.sdk.a.a((View)this.a);
            IAmraidWebView var5 = this.a;
            String var7;
            if(var3 != null) {
               var7 = var3.m();
            } else {
               var7 = null;
            }

            var5.loadHtmlData(var7, "<script>\n\t(function() {\n\t    if (window.iaPreCachedAd) {\n\t        var wasIaLoadFinishedNotified = false;\n\t        var IA_AD_FINISHED_LOADING_EVENT = \'iaadfinishedloading\';\n   \t    var NOTIFY_LOADING_FINISHED_TIMEOUT_IN_MS = 5000;\n   \t    var SUCCESS_STATE = \'success\';\n   \t    var FAILURE_STATE = \'failure\';\n\t        var iaNotifyLoadFinished = function(state) {\n\t            if (!wasIaLoadFinishedNotified) {\n\t                wasIaLoadFinishedNotified = true;\n\t                window.location.href = IA_AD_FINISHED_LOADING_EVENT + \'://\' + state;\n\t            }\n\t        }\n           var prevOnload = window.onload;\n           window.onload = function() {\n               if (typeof prevOnload === \'function\') {\n                   prevOnload.apply();\n               }\n               iaNotifyLoadFinished.apply(null, [SUCCESS_STATE]);\n           };\n           setTimeout(function() {iaNotifyLoadFinished.apply(null, [FAILURE_STATE]);}, NOTIFY_LOADING_FINISHED_TIMEOUT_IN_MS);\n\t        window.prevStartProjekktorVideoAutoplay = window.startProjekktorVideoAutoplay;\n\t        startProjekktorVideoAutoplay = function() {};\n           window.previaStartSkipButtonVisibleCountdown = window.iaStartSkipButtonVisibleCountdown;\n           window.iaStartSkipButtonVisibleCountdown = function() {};\n\t        window.showInterstitial = function() {\n               if (window.iaPreCachedAd) {\n                   iaAddImpressionTrackingPixels()\n\t                if (typeof prevStartProjekktorVideoAutoplay === \'function\' && typeof iaAutoplaySupported !== \'undefined\' && iaAutoplaySupported) {\n                       window.prevStartProjekktorVideoAutoplay.apply();\n\t                }\n\t                if (typeof window.previaStartSkipButtonVisibleCountdown === \'function\') {\n                       window.previaStartSkipButtonVisibleCountdown.apply(null, [iaVideoSettings.iaSkipButtonHiddenTimeInMillisecondsErrorOverride]);\n                   }\n               }\n           };\n       }\n   })();\n</script>\n" + var9);
         } else {
            this.b.a(InneractiveAdView$InneractiveErrorCode.SERVER_INVALID_RESPONSE);
         }
      }
   }

   final void b() {
      if(this.a != null) {
         this.a.setListener((com.inneractive.api.ads.sdk.at)null);
         this.a.destroy();
      }

   }
}
