package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.flurry.sdk.eo;
import com.flurry.sdk.n$a;
import com.flurry.sdk.n$b;
import com.flurry.sdk.n$c;
import com.flurry.sdk.n$d;
import com.flurry.sdk.n$e;
import com.flurry.sdk.n$f;

@SuppressLint({"SetJavaScriptEnabled"})
public final class n extends RelativeLayout implements OnClickListener {
   private final String a = this.getClass().getSimpleName();
   private WebView b;
   private WebViewClient c;
   private WebChromeClient d;
   private boolean e;
   private boolean f = true;
   private ProgressDialog g;
   private ImageView h;
   private ImageView i;
   private ImageView j;
   private final int k = 0;
   private final int l = 1;
   private final int m = 2;
   private n$f n;
   private n$c o;
   private n$d p;
   private boolean q;

   @TargetApi(11)
   public n(Context var1, String var2, boolean var3) {
      super(var1);
      this.b = new WebView(var1);
      this.c = new n$b(this, null);
      this.d = new n$a(this, null);
      this.f = var3;
      this.b.getSettings().setJavaScriptEnabled(true);
      this.b.getSettings().setUseWideViewPort(true);
      this.b.getSettings().setLoadWithOverviewMode(true);
      this.b.getSettings().setBuiltInZoomControls(true);
      if(VERSION.SDK_INT >= 11) {
         this.b.getSettings().setDisplayZoomControls(false);
      }

      this.b.setWebViewClient(this.c);
      this.b.setWebChromeClient(this.d);
      this.b.loadUrl(var2);
      this.h = new ImageView(var1);
      this.h.setId(0);
      this.h.setImageDrawable(this.getResources().getDrawable(17301560));
      this.h.setOnClickListener(this);
      this.i = new ImageView(var1);
      this.i.setId(1);
      this.i.setImageDrawable(this.getResources().getDrawable(17301580));
      this.i.setOnClickListener(this);
      this.j = new ImageView(var1);
      this.j.setId(2);
      this.j.setImageDrawable(this.getResources().getDrawable(17301565));
      this.j.setOnClickListener(this);
      this.setLayoutParams(new LayoutParams(-1, -1));
      this.addView(this.b);
      android.widget.RelativeLayout.LayoutParams var4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
      var4.addRule(14);
      this.addView(this.h, var4);
      var4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
      var4.addRule(9);
      this.addView(this.i, var4);
      var4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
      var4.addRule(11);
      this.addView(this.j, var4);
   }

   // $FF: synthetic method
   static String a(com.flurry.sdk.n var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static boolean a(com.flurry.sdk.n var0, boolean var1) {
      var0.q = var1;
      return var1;
   }

   // $FF: synthetic method
   static WebView b(com.flurry.sdk.n var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static boolean b(com.flurry.sdk.n var0, boolean var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static n$f c(com.flurry.sdk.n var0) {
      return var0.n;
   }

   // $FF: synthetic method
   static boolean d(com.flurry.sdk.n var0) {
      return var0.q;
   }

   // $FF: synthetic method
   static n$d e(com.flurry.sdk.n var0) {
      return var0.p;
   }

   public final void a(Context var1) {
      if(this.g == null) {
         if(var1 == null) {
            eo.a(3, this.a, "Context is null, cannot create progress dialog.");
            return;
         }

         this.g = new ProgressDialog(var1);
         this.g.setProgressStyle(0);
         this.g.setMessage("Loading...");
         this.g.setCancelable(true);
         this.g.setCanceledOnTouchOutside(false);
         this.g.show();
      } else if(!this.g.isShowing()) {
         this.g.show();
         return;
      }

   }

   public final boolean a() {
      return this.e || this.b != null && this.b.canGoBack();
   }

   public final boolean b() {
      return this.f;
   }

   public final void c() {
      if(this.e) {
         this.d.onHideCustomView();
      } else if(this.b != null) {
         this.b.goBack();
         return;
      }

   }

   @TargetApi(11)
   public final void d() {
      if(this.b != null) {
         this.e();
         this.removeView(this.b);
         this.b.stopLoading();
         if(VERSION.SDK_INT >= 11) {
            this.b.onPause();
         }

         this.b.destroy();
         this.b = null;
      }

   }

   public final void e() {
      if(this.g != null && this.g.isShowing()) {
         this.g.dismiss();
         this.g = null;
      }

   }

   public final n$c getBasicWebViewClosingHandler() {
      return this.o;
   }

   public final n$d getBasicWebViewFullScreenTransitionHandler() {
      return this.p;
   }

   public final n$f getBasicWebViewUrlLoadingHandler() {
      return this.n;
   }

   public final String getUrl() {
      String var1 = null;
      if(this.b != null) {
         var1 = this.b.getUrl();
      }

      return var1;
   }

   public final void onClick(View var1) {
      switch(var1.getId()) {
      case 0:
         if(this.o != null) {
            this.o.a(this, n$e.c);
            return;
         }
         break;
      case 1:
         if(this.b != null && this.b.canGoBack()) {
            this.b.goBack();
            return;
         }

         if(this.o != null) {
            if(this.b()) {
               this.o.a(this, n$e.c);
               return;
            }

            this.o.a(this, n$e.b);
            return;
         }
         break;
      case 2:
         if(this.b != null && this.b.canGoForward()) {
            this.b.goForward();
            return;
         }
      }

   }

   public final void setBasicWebViewClosingHandler(n$c var1) {
      this.o = var1;
   }

   public final void setBasicWebViewFullScreenTransitionHandler(n$d var1) {
      this.p = var1;
   }

   public final void setBasicWebViewUrlLoadingHandler(n$f var1) {
      this.n = var1;
   }
}
