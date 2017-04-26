package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.InterstitialAdActivity$a;
import com.facebook.ads.a.b$a;
import com.facebook.ads.a.f$a;

public class InterstitialAdActivity extends Activity {
   private static final int AD_WEBVIEW_ID = 100001;
   private static final int CLOSE_BUTTON_ID = 100002;
   private static final int CLOSE_BUTTON_SIZE_DP = 60;
   private static final String DATA_MODEL_KEY = "dataModel";
   private static final String LAST_REQUESTED_ORIENTATION_KEY = "lastRequestedOrientation";
   private static final int ORIENTATION_REVERSE_LANDSCAPE = 8;
   private static final int ORIENTATION_REVERSE_PORTRAIT = 9;
   private static final String TAG = InterstitialAdActivity.class.getSimpleName();
   private long actionTime;
   private b$a actionType;
   private com.facebook.ads.a.z adHandler;
   private WebView adWebView;
   private com.facebook.ads.a.v closeButton;
   private long createTime;
   private com.facebook.ads.a.y dataModel;
   private int displayHeight;
   private int displayWidth;
   private String interstitialID;
   private boolean isRestart = false;
   private int lastRequestedOrientation;

   // $FF: synthetic method
   static com.facebook.ads.a.z access$200(InterstitialAdActivity var0) {
      return var0.adHandler;
   }

   // $FF: synthetic method
   static b$a access$302(InterstitialAdActivity var0, b$a var1) {
      var0.actionType = var1;
      return var1;
   }

   // $FF: synthetic method
   static long access$402(InterstitialAdActivity var0, long var1) {
      var0.actionTime = var1;
      return var1;
   }

   // $FF: synthetic method
   static String access$500() {
      return TAG;
   }

   private void loadAdFromIntentOrSavedState(Intent var1, Bundle var2) {
      if(var2 != null && var2.containsKey("dataModel")) {
         this.dataModel = com.facebook.ads.a.y.a(var2.getBundle("dataModel"));
         if(this.dataModel != null) {
            this.adWebView.loadDataWithBaseURL(com.facebook.ads.a.s.a(), this.dataModel.c(), "text/html", "utf-8", (String)null);
         }

         this.lastRequestedOrientation = var2.getInt("lastRequestedOrientation", -1);
         this.interstitialID = var2.getString("adInterstitialUniqueId");
         this.isRestart = true;
      } else {
         this.displayWidth = var1.getIntExtra("displayWidth", 0);
         this.displayHeight = var1.getIntExtra("displayHeight", 0);
         this.interstitialID = var1.getStringExtra("adInterstitialUniqueId");
         this.dataModel = com.facebook.ads.a.y.b(var1);
         if(this.dataModel != null) {
            this.adHandler.a(this.dataModel);
            this.adWebView.loadDataWithBaseURL(com.facebook.ads.a.s.a(), this.dataModel.c(), "text/html", "utf-8", (String)null);
            return;
         }
      }

   }

   private void sendBroadcastForEvent(String var1) {
      Intent var2 = new Intent(var1 + ":" + this.interstitialID);
      LocalBroadcastManager.getInstance(this).sendBroadcast(var2);
   }

   private void setScreenOrientation(int var1, int var2) {
      boolean var3;
      if(var2 >= var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      var2 = ((WindowManager)this.getSystemService("window")).getDefaultDisplay().getRotation();
      if(var3) {
         switch(var2) {
         case 1:
         case 2:
            this.setRequestedOrientation(9);
            return;
         default:
            this.setRequestedOrientation(1);
         }
      } else {
         switch(var2) {
         case 2:
         case 3:
            this.setRequestedOrientation(8);
            return;
         default:
            this.setRequestedOrientation(0);
         }
      }
   }

   public void finish() {
      this.adHandler.c();
      this.adWebView.loadUrl("about:blank");
      this.adWebView.clearCache(true);
      this.sendBroadcastForEvent("com.facebook.ads.interstitial.dismissed");
      com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(this.createTime, b$a.c));
      super.finish();
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.createTime = System.currentTimeMillis();
      this.requestWindowFeature(1);
      this.getWindow().setFlags(1024, 1024);
      RelativeLayout var2 = new RelativeLayout(this);
      this.adWebView = new WebView(this);
      this.adWebView.setId(100001);
      this.adWebView.setLayoutParams(new LayoutParams(-1, -1));
      com.facebook.ads.a.s.a((WebView)this.adWebView, (WebViewClient)(new InterstitialAdActivity$a(this, null)), (com.facebook.ads.a.r)(new com.facebook.ads.a.r()));
      var2.addView(this.adWebView);
      Intent var3 = this.getIntent();
      if(var3.getBooleanExtra("useNativeCloseButton", false)) {
         this.closeButton = new com.facebook.ads.a.v(this);
         this.closeButton.setId(100002);
         DisplayMetrics var4 = this.getResources().getDisplayMetrics();
         LayoutParams var5 = new LayoutParams((int)(var4.density * 60.0F), (int)(var4.density * 60.0F));
         var5.addRule(10);
         var5.addRule(11);
         this.closeButton.setLayoutParams(var5);
         this.closeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               InterstitialAdActivity.this.finish();
            }
         });
         var2.addView(this.closeButton);
      }

      this.adHandler = new com.facebook.ads.a.z(this.adWebView, new f$a() {
         public boolean a() {
            return true;
         }

         public void b() {
         }

         public void c() {
            InterstitialAdActivity.this.sendBroadcastForEvent("com.facebook.ads.interstitial.impression.logged");
         }

         public boolean d() {
            return false;
         }
      }, 1000L, this);
      this.setContentView(var2, new LayoutParams(-1, -1));
      this.loadAdFromIntentOrSavedState(var3, var1);
      this.sendBroadcastForEvent("com.facebook.ads.interstitial.displayed");
      this.adHandler.h();
   }

   public void onRestart() {
      super.onRestart();
      this.isRestart = true;
   }

   public void onResume() {
      super.onResume();
      if(this.actionTime > 0L && this.actionType != null) {
         com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(this.actionTime, this.actionType));
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if(this.dataModel != null) {
         var1.putBundle("dataModel", this.dataModel.i());
      }

      var1.putInt("lastRequestedOrientation", this.lastRequestedOrientation);
      var1.putString("adInterstitialUniqueId", this.interstitialID);
   }

   public void onStart() {
      super.onStart();
      if(!this.isRestart) {
         this.setScreenOrientation(this.displayWidth, this.displayHeight);
      } else if(this.lastRequestedOrientation >= 0) {
         this.setRequestedOrientation(this.lastRequestedOrientation);
         this.lastRequestedOrientation = -1;
      }

      this.isRestart = false;
   }

   public void setRequestedOrientation(int var1) {
      this.lastRequestedOrientation = var1;
      super.setRequestedOrientation(var1);
   }
}
