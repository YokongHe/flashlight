package com.flurry.sdk;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.flurry.sdk.eo;
import com.flurry.sdk.n$g;

final class n$a extends WebChromeClient {
   // $FF: synthetic field
   final com.flurry.sdk.n a;

   private n$a(com.flurry.sdk.n var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   n$a(com.flurry.sdk.n var1, Object var2) {
      this(var1);
   }

   public final void onHideCustomView() {
      eo.a(3, com.flurry.sdk.n.a(this.a), "onHideCustomView()");
      if(com.flurry.sdk.n.e(this.a) != null) {
         com.flurry.sdk.n.e(this.a).a(this.a);
      }

      com.flurry.sdk.n.b(this.a, false);
   }

   public final void onShowCustomView(View var1, int var2, CustomViewCallback var3) {
      eo.a(3, com.flurry.sdk.n.a(this.a), "onShowCustomView(14)");
      com.flurry.sdk.n.b(this.a, true);
      if(com.flurry.sdk.n.e(this.a) != null) {
         com.flurry.sdk.n.e(this.a).a(this.a, var1, var2, new n$g(this.a, var3));
      }

   }

   public final void onShowCustomView(View var1, CustomViewCallback var2) {
      eo.a(3, com.flurry.sdk.n.a(this.a), "onShowCustomView(7)");
      com.flurry.sdk.n.b(this.a, true);
      if(com.flurry.sdk.n.e(this.a) != null) {
         com.flurry.sdk.n.e(this.a).a(this.a, var1, new n$g(this.a, var2));
      }

   }
}
