package com.flurry.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;
import com.flurry.sdk.fe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class g$b extends WebViewClient {
   // $FF: synthetic field
   final com.flurry.sdk.g a;

   private g$b(com.flurry.sdk.g var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   g$b(com.flurry.sdk.g var1, Object var2) {
      this(var1);
   }

   public void onLoadResource(WebView var1, String var2) {
      eo.a(3, com.flurry.sdk.g.a(this.a), "onLoadResource: url = " + var2);
      super.onLoadResource(var1, var2);
      if(var2 != null && var1 != null && var1 == com.flurry.sdk.g.b(this.a)) {
         if(!var2.equalsIgnoreCase(com.flurry.sdk.g.b(this.a).getUrl())) {
            com.flurry.sdk.g.c(this.a);
         }

         if(!com.flurry.sdk.g.d(this.a)) {
            String var3 = Uri.parse(var2).getLastPathSegment();
            if(var3 != null && var3.equalsIgnoreCase("mraid.js")) {
               com.flurry.sdk.g.a(this.a, true);
               if(com.flurry.sdk.g.e(this.a)) {
                  com.flurry.sdk.g.f(this.a);
                  if(com.flurry.sdk.g.g(this.a)) {
                     com.flurry.sdk.g.h(this.a);
                     com.flurry.sdk.g.i(this.a);
                     com.flurry.sdk.g.j(this.a);
                     com.flurry.sdk.g.k(this.a);
                     return;
                  }
               } else if(com.flurry.sdk.g.g(this.a)) {
                  com.flurry.sdk.g.l(this.a);
                  if(this.a.e() && this.a.getCurrentBinding() == 2) {
                     com.flurry.sdk.g.m(this.a);
                     return;
                  }
               }
            }
         }
      }

   }

   public void onPageFinished(WebView var1, String var2) {
      eo.a(3, com.flurry.sdk.g.a(this.a), "onPageFinished: url = " + var2);
      if(var2 != null && var1 != null && var1 == com.flurry.sdk.g.b(this.a)) {
         com.flurry.sdk.g.c(this.a);
         com.flurry.sdk.g.p(this.a);
         com.flurry.sdk.g.q(this.a);
         if(!this.a.a((View)com.flurry.sdk.g.b(this.a)) && (this.a.getCurrentBinding() == 2 || this.a.getCurrentBinding() == 1)) {
            eo.a(3, com.flurry.sdk.g.a(this.a), "adding WebView to AdUnityView");
            this.a.addView(com.flurry.sdk.g.b(this.a));
         }

         com.flurry.sdk.g.b(this.a, true);
         if(com.flurry.sdk.g.e(this.a)) {
            if(com.flurry.sdk.g.d(this.a)) {
               com.flurry.sdk.g.h(this.a);
               com.flurry.sdk.g.i(this.a);
               com.flurry.sdk.g.j(this.a);
               com.flurry.sdk.g.k(this.a);
               return;
            }
         } else if(com.flurry.sdk.g.d(this.a)) {
            com.flurry.sdk.g.l(this.a);
            if(this.a.e() && this.a.getCurrentBinding() == 2) {
               com.flurry.sdk.g.m(this.a);
               return;
            }
         }
      }

   }

   public void onPageStarted(WebView var1, String var2, Bitmap var3) {
      eo.a(3, com.flurry.sdk.g.a(this.a), "onPageStarted: url = " + var2);
      if(var2 != null && var1 != null && var1 == com.flurry.sdk.g.b(this.a)) {
         com.flurry.sdk.g.n(this.a);
         com.flurry.sdk.g.o(this.a);
         com.flurry.sdk.g.b(this.a, false);
         com.flurry.sdk.g.a(this.a, false);
      }
   }

   public void onReceivedError(WebView var1, int var2, String var3, String var4) {
      eo.a(3, com.flurry.sdk.g.a(this.a), "onReceivedError: url = " + var4);
      com.flurry.sdk.g.q(this.a);
      Uri var5 = Uri.parse(var4);
      if("market".equals(var5.getScheme())) {
         Intent var7 = new Intent("android.intent.action.VIEW");
         var7.setData(var5);
         this.a.getContext().startActivity(var7);
         com.flurry.sdk.g.t(this.a);
      } else {
         HashMap var6 = new HashMap();
         var6.put("errorCode", Integer.toString(com.flurry.sdk.b.q.a()));
         var6.put("webViewErrorCode", Integer.toString(var2));
         var6.put("failingUrl", var4);
         this.a.a("renderFailed", var6, this.a.getAdUnit(), this.a.getAdLog(), this.a.getAdFrameIndex(), 0);
      }
   }

   public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      eo.a(3, com.flurry.sdk.g.a(this.a), "shouldOverrideUrlLoading: url = " + var2);
      if(var2 != null && var1 != null && var1 == com.flurry.sdk.g.b(this.a)) {
         String var4 = com.flurry.sdk.cf.c(com.flurry.sdk.g.b(this.a).getUrl());
         String var6 = var2;
         if(!TextUtils.isEmpty(var4)) {
            var6 = var2;
            if(var2.startsWith(var4)) {
               var4 = var2.substring(var4.length());
               Uri var5 = Uri.parse(var4);
               var6 = var2;
               if(var5.isHierarchical()) {
                  var6 = var2;
                  if(!TextUtils.isEmpty(var5.getScheme())) {
                     var6 = var2;
                     if(!TextUtils.isEmpty(var5.getAuthority())) {
                        eo.a(3, com.flurry.sdk.g.a(this.a), "shouldOverrideUrlLoading: target url = " + var4);
                        var6 = var4;
                     }
                  }
               }
            }
         }

         Uri var7 = Uri.parse(var6);
         if("flurry".equals(var7.getScheme())) {
            var6 = var7.getQueryParameter("event");
            if(var6 != null) {
               com.flurry.sdk.g.r(this.a).add(var6);
               Map var8 = fe.f(var7.getEncodedQuery());
               if(var8.containsKey("guid")) {
                  AdUnit var9 = com.flurry.sdk.g.a(this.a, (String)var8.get("guid"));
                  com.flurry.sdk.e var10 = com.flurry.sdk.g.b(this.a, (String)var8.get("guid"));
                  if(var9 != null && var10 != null) {
                     this.a.a(var6, var8, var9, var10, 0, 0);
                  }
               } else {
                  this.a.a(var6, var8, this.a.getAdUnit(), this.a.getAdLog(), this.a.getAdFrameIndex(), 0);
               }
            }

            return true;
         } else {
            if(com.flurry.sdk.g.s(this.a)) {
               com.flurry.sdk.g.c(this.a, false);
               this.a.a("clicked", Collections.emptyMap(), this.a.getAdUnit(), this.a.getAdLog(), this.a.getAdFrameIndex(), 0);
            }

            if(this.a.e()) {
               var6 = com.flurry.sdk.cf.a(var6);
               if(var6 != null) {
                  boolean var3 = false;
                  if(com.flurry.sdk.cf.e(var6)) {
                     var3 = this.a.getPlatformModule().a().b(this.a.getContext(), var6, this.a.getAdUnit().b().toString());
                  }

                  if(!var3) {
                     com.flurry.sdk.g.b(this.a).loadUrl(var6);
                  }
               }
            } else {
               this.a.getPlatformModule().a().a(this.a.getContext(), var6, true, this.a.getAdUnit(), true);
            }

            return true;
         }
      } else {
         return false;
      }
   }
}
