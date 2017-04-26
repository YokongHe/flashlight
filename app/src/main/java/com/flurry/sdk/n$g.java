package com.flurry.sdk;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.flurry.sdk.n$d$a;

final class n$g implements n$d$a {
   // $FF: synthetic field
   final com.flurry.sdk.n a;
   private CustomViewCallback b;

   public n$g(com.flurry.sdk.n var1, CustomViewCallback var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void a() {
      if(this.b != null) {
         this.b.onCustomViewHidden();
      }

   }
}
