package com.facebook.ads.a;

import android.content.Context;
import android.webkit.WebView;
import com.facebook.ads.a.f$a;
import java.util.Collections;
import java.util.Map;

public class z extends com.facebook.ads.a.f {
   private WebView c;
   private volatile boolean d;

   public z(WebView var1, f$a var2, long var3, Context var5) {
      super(var2, var3, var5);
      this.c = var1;
   }

   private void a(Map var1) {
      String var2 = ((com.facebook.ads.a.y)this.b).e();
      if(!com.facebook.ads.a.ag.a(var2)) {
         (new com.facebook.ads.a.ad(var1)).execute(new String[]{var2});
      }
   }

   public void a(com.facebook.ads.a.y var1) {
      super.a(var1);
      this.d = false;
   }

   protected void e() {
      synchronized(this){}

      try {
         com.facebook.ads.a.y var1 = (com.facebook.ads.a.y)this.b;
         if(this.c != null && !com.facebook.ads.a.ag.a(var1.f())) {
            this.c.loadUrl("javascript:" + var1.f());
         }

         this.a(Collections.singletonMap("evt", "native_imp"));
         if(this.a != null) {
            this.a.b();
         }
      } finally {
         ;
      }

   }

   public void f() {
      // $FF: Couldn't be decompiled
   }

   public void g() {
      synchronized(this){}

      try {
         this.c = null;
      } finally {
         ;
      }

   }

   public void h() {
      this.a(Collections.singletonMap("evt", "interstitial_displayed"));
   }
}
