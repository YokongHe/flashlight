package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import com.inneractive.api.ads.sdk.IAdefines$IAresources;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.InneractiveInternalBrowserActivity$a;

public class InneractiveInternalBrowserActivity extends Activity {
   private static InneractiveInternalBrowserActivity$a g;
   private LinearLayout a;
   private WebView b;
   private ImageButton c;
   private ImageButton d;
   private ImageButton e;
   private ImageButton f;

   private ImageButton a(Drawable var1) {
      ImageButton var2 = new ImageButton(this);
      LayoutParams var3 = new LayoutParams(-2, -2, 1.0F);
      var3.gravity = 16;
      var2.setLayoutParams(var3);
      var2.setImageDrawable(var1);
      return var2;
   }

   static void a(InneractiveInternalBrowserActivity$a var0) {
      g = var0;
   }

   // $FF: synthetic method
   static boolean a(InneractiveInternalBrowserActivity var0, String var1) {
      return a(var1);
   }

   private static boolean a(String var0) {
      return var0.startsWith("tel:") || var0.startsWith("voicemail:") || var0.startsWith("sms:") || var0.startsWith("mailto:") || var0.startsWith("geo:") || var0.startsWith("google.streetview:");
   }

   private boolean b(String var1) {
      Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
      var2.addFlags(268435456);

      try {
         this.startActivity(var2);
      } catch (ActivityNotFoundException var3) {
         InneractiveAdView$Log.e("Failed to start activity for " + var1 + ". Please ensure that your phone can handle this intent.");
         return false;
      }

      if(g != null) {
         g.onApplicationInBackground();
      }

      return true;
   }

   public void onBackPressed() {
      this.finish();
      if(g != null) {
         g.onInternalBrowserDismissed();
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.getWindow().requestFeature(2);
      this.getWindow().setFeatureInt(2, -1);
      this.a = new LinearLayout(this);
      LayoutParams var4 = new LayoutParams(-1, -1);
      this.a.setLayoutParams(var4);
      this.a.setOrientation(1);
      RelativeLayout var5 = new RelativeLayout(this);
      var5.setLayoutParams(new LayoutParams(-1, -2));
      this.a.addView(var5);
      LinearLayout var2 = new LinearLayout(this);
      var2.setId(1);
      RelativeLayout.LayoutParams var3 = new RelativeLayout.LayoutParams(-1, -2);
      var3.addRule(12);
      var2.setLayoutParams(var3);
      var2.setBackgroundDrawable(IAdefines$IAresources.a.a(this));
      var5.addView(var2);
      this.c = this.a((Drawable)IAdefines$IAresources.b.a(this));
      this.d = this.a((Drawable)IAdefines$IAresources.d.a(this));
      this.e = this.a((Drawable)IAdefines$IAresources.f.a(this));
      this.f = this.a((Drawable)IAdefines$IAresources.g.a(this));
      var2.addView(this.c);
      var2.addView(this.d);
      var2.addView(this.e);
      var2.addView(this.f);
      this.b = new WebView(this);
      RelativeLayout.LayoutParams var7 = new RelativeLayout.LayoutParams(-1, -1);
      var7.addRule(2, 1);
      this.b.setLayoutParams(var7);
      var5.addView(this.b);
      this.setContentView(this.a);
      Intent var6 = this.getIntent();
      WebSettings var9 = this.b.getSettings();
      var9.setJavaScriptEnabled(true);
      var9.setSupportZoom(true);
      var9.setBuiltInZoomControls(true);
      var9.setUseWideViewPort(true);
      this.b.setWebViewClient(new WebViewClient() {
         // $FF: synthetic field
         private InneractiveInternalBrowserActivity a = InneractiveInternalBrowserActivity.this;

         public final void onPageFinished(WebView var1, String var2) {
            super.onPageFinished(var1, var2);
            BitmapDrawable var4;
            if(var1.canGoBack()) {
               var4 = IAdefines$IAresources.b.a(this.a);
            } else {
               var4 = IAdefines$IAresources.c.a(this.a);
            }

            this.a.c.setImageDrawable(var4);
            BitmapDrawable var3;
            if(var1.canGoForward()) {
               var3 = IAdefines$IAresources.d.a(this.a);
            } else {
               var3 = IAdefines$IAresources.e.a(this.a);
            }

            this.a.d.setImageDrawable(var3);
         }

         public final void onPageStarted(WebView var1, String var2, Bitmap var3) {
            super.onPageStarted(var1, var2, var3);
            this.a.d.setImageDrawable(IAdefines$IAresources.e.a(this.a));
         }

         public final void onReceivedError(WebView var1, int var2, String var3, String var4) {
            Toast.makeText((Activity)var1.getContext(), "oops...MRAID error occurs: " + var3, 0).show();
         }

         public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            if(var2 != null) {
               String var4 = Uri.parse(var2).getHost();
               if(!var2.startsWith("http:") && !var2.startsWith("https:") || "play.google.com".equals(var4) || "market.android.com".equals(var4)) {
                  if(InneractiveInternalBrowserActivity.a(this.a, var2)) {
                     this.a.b(var2);
                  } else {
                     try {
                        if(InneractiveInternalBrowserActivity.g != null) {
                           InneractiveInternalBrowserActivity.g.onApplicationInBackground();
                        }

                        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var2)));
                     } catch (ActivityNotFoundException var3) {
                        InneractiveAdView$Log.e("Failed to start activity for " + var2 + ". Please ensure that your phone can handle this intent.");
                     }
                  }

                  this.a.finish();
                  return true;
               }
            }

            return false;
         }
      });
      this.b.setWebChromeClient(new WebChromeClient() {
         public final void onProgressChanged(WebView var1, int var2) {
            Activity var3 = (Activity)var1.getContext();
            var3.setTitle("Page is Loading...");
            var3.setProgress(var2 * 100);
            if(var2 == 100) {
               var3.setTitle(var1.getUrl());
            }

         }
      });
      String var8 = var6.getStringExtra("extra_url");
      if(a(var8)) {
         this.b(var8);
         this.finish();
      } else {
         this.b.loadUrl(var8);
      }

      this.c.setBackgroundColor(0);
      this.c.setOnClickListener(new OnClickListener() {
         // $FF: synthetic field
         private InneractiveInternalBrowserActivity a = InneractiveInternalBrowserActivity.this;

         public final void onClick(View var1) {
            if(this.a.b.canGoBack()) {
               this.a.b.goBack();
            }

         }
      });
      this.d.setBackgroundColor(0);
      this.d.setOnClickListener(new OnClickListener() {
         // $FF: synthetic field
         private InneractiveInternalBrowserActivity a = InneractiveInternalBrowserActivity.this;

         public final void onClick(View var1) {
            if(this.a.b.canGoForward()) {
               this.a.b.goForward();
            }

         }
      });
      this.e.setBackgroundColor(0);
      this.e.setOnClickListener(new OnClickListener() {
         // $FF: synthetic field
         private InneractiveInternalBrowserActivity a = InneractiveInternalBrowserActivity.this;

         public final void onClick(View var1) {
            this.a.b.reload();
         }
      });
      this.f.setBackgroundColor(0);
      this.f.setOnClickListener(new OnClickListener() {
         // $FF: synthetic field
         private InneractiveInternalBrowserActivity a = InneractiveInternalBrowserActivity.this;

         public final void onClick(View var1) {
            if(InneractiveInternalBrowserActivity.g != null) {
               InneractiveInternalBrowserActivity.g.onInternalBrowserDismissed();
            }

            this.a.finish();
         }
      });
      CookieSyncManager.createInstance(this);
      CookieSyncManager.getInstance().startSync();
   }

   protected void onDestroy() {
      if(this.a != null) {
         this.a.removeAllViews();
      }

      this.b.destroy();
      super.onDestroy();
   }

   protected void onPause() {
      super.onPause();
      CookieSyncManager.getInstance().stopSync();
   }

   protected void onResume() {
      super.onResume();
      CookieSyncManager.getInstance().startSync();
   }
}
