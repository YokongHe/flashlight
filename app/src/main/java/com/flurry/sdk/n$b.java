package com.flurry.sdk;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.flurry.sdk.eo;

final class n$b extends WebViewClient {
   // $FF: synthetic field
   final com.flurry.sdk.n a;

   private n$b(com.flurry.sdk.n var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   n$b(com.flurry.sdk.n var1, Object var2) {
      this(var1);
   }

   public final void onPageFinished(WebView var1, String var2) {
      eo.a(3, com.flurry.sdk.n.a(this.a), "onPageFinished: url = " + var2);
      if(var2 != null && var1 != null && var1 == com.flurry.sdk.n.b(this.a)) {
         com.flurry.sdk.n.a(this.a, false);
      }
   }

   public final void onPageStarted(WebView var1, String var2, Bitmap var3) {
      eo.a(3, com.flurry.sdk.n.a(this.a), "onPageStarted: url = " + var2);
      if(var2 != null && var1 != null && var1 == com.flurry.sdk.n.b(this.a)) {
         this.a.e();
         if(com.flurry.sdk.n.d(this.a)) {
            boolean var4 = false;
            if(com.flurry.sdk.n.c(this.a) != null) {
               var4 = com.flurry.sdk.n.c(this.a).a(this.a, var2, com.flurry.sdk.n.d(this.a));
            }

            if(var4) {
               var1.stopLoading();
            }
         }

         com.flurry.sdk.n.a(this.a, true);
      }
   }

   public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
      eo.a(3, com.flurry.sdk.n.a(this.a), "shouldOverrideUrlLoading: url = " + var2);
      if(var2 != null && var1 != null && var1 == com.flurry.sdk.n.b(this.a)) {
         boolean var3;
         if(com.flurry.sdk.n.c(this.a) != null) {
            var3 = com.flurry.sdk.n.c(this.a).a(this.a, var2, com.flurry.sdk.n.d(this.a));
         } else {
            var3 = false;
         }

         com.flurry.sdk.n.a(this.a, false);
         return var3;
      } else {
         return false;
      }
   }
}
