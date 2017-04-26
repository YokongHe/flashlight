package com.facebook.ads;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.ImpressionListener;
import com.facebook.ads.InterstitialAd$a;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.a.j$b;
import java.util.Map;
import java.util.UUID;

public class InterstitialAd implements Ad {
   public static final String AD_HEIGHT_INTENT_EXTRA = "adHeight";
   public static final String AD_WIDTH_INTENT_EXTRA = "adWidth";
   public static final String DISPLAY_HEIGHT_INTENT_EXTRA = "displayHeight";
   public static final String DISPLAY_ROTATION_INTENT_EXTRA = "displayRotation";
   public static final String DISPLAY_WIDTH_INTENT_EXTRA = "displayWidth";
   public static final String IMPRESSION_WILL_LOG = "com.facebook.ads.interstitial.impression.logged";
   public static final String INTERSTITIAL_CLICKED = "com.facebook.ads.interstitial.clicked";
   public static final String INTERSTITIAL_DISMISSED = "com.facebook.ads.interstitial.dismissed";
   public static final String INTERSTITIAL_DISPLAYED = "com.facebook.ads.interstitial.displayed";
   public static final String INTERSTITIAL_UNIQUE_ID_EXTRA = "adInterstitialUniqueId";
   public static final String IS_TABLET_INTENT_EXTRA = "isTablet";
   public static final String SEPARATOR = ":";
   public static final String USE_NATIVE_CLOSE_BUTTON_EXTRA = "useNativeCloseButton";
   private int adHeight;
   private InterstitialAdListener adListener;
   private boolean adLoaded = false;
   private com.facebook.ads.a.k adRequestController;
   private com.facebook.ads.a.l adResponse;
   private WebView adWebView;
   private int adWidth;
   private final InterstitialAd$a broadcastReceiver;
   private final Context context;
   private ImpressionListener impListener;
   private boolean isTablet;
   private final String uniqueId = UUID.randomUUID().toString();
   private boolean useNativeCloseButton;

   public InterstitialAd(Context var1, String var2) {
      this.context = var1;
      this.adRequestController = new com.facebook.ads.a.k(this.context, var2, AdSize.INTERSTITIAL, com.facebook.ads.a.n.e, false, com.facebook.ads.a.o.a, 1, new j$b() {
         public void a(AdError var1) {
            InterstitialAd.this.adLoaded = false;
            if(InterstitialAd.this.adListener != null) {
               InterstitialAd.this.adListener.onError(InterstitialAd.this, var1);
            }

         }

         public void a(com.facebook.ads.a.l var1) {
            InterstitialAd.this.adResponse = var1;
            if(var1.d() != null && var1.d() instanceof com.facebook.ads.a.y) {
               InterstitialAd.this.adLoaded = true;
               com.facebook.ads.a.y var5 = (com.facebook.ads.a.y)var1.d();
               Map var6 = var5.h();
               if(var6.containsKey("is_tablet")) {
                  InterstitialAd.this.isTablet = Boolean.parseBoolean((String)var6.get("is_tablet"));
               }

               if(var6.containsKey("ad_height")) {
                  InterstitialAd.this.adHeight = Integer.parseInt((String)var6.get("ad_height"));
               }

               if(var6.containsKey("ad_width")) {
                  InterstitialAd.this.adWidth = Integer.parseInt((String)var6.get("ad_width"));
               }

               if(var6.containsKey("native_close")) {
                  InterstitialAd.this.useNativeCloseButton = Boolean.valueOf((String)var6.get("native_close")).booleanValue();
               }

               if(var5.g()) {
                  InterstitialAd.this.preloadMarkup(var5);
               } else if(InterstitialAd.this.adListener != null) {
                  InterstitialAd.this.adListener.onAdLoaded(InterstitialAd.this);
                  return;
               }
            } else if(var1.d() == null) {
               InterstitialAd.this.adLoaded = false;
               if(InterstitialAd.this.adListener != null) {
                  InterstitialAdListener var2 = InterstitialAd.this.adListener;
                  InterstitialAd var3 = InterstitialAd.this;
                  AdError var4;
                  if(var1.e() != null) {
                     var4 = var1.e();
                  } else {
                     var4 = AdError.INTERNAL_ERROR;
                  }

                  var2.onError(var3, var4);
                  return;
               }
            } else {
               InterstitialAd.this.adLoaded = false;
               if(InterstitialAd.this.adListener != null) {
                  InterstitialAd.this.adListener.onError(InterstitialAd.this, AdError.INTERNAL_ERROR);
                  return;
               }
            }

         }
      });
      this.broadcastReceiver = new InterstitialAd$a(this, null);
      this.broadcastReceiver.a();
   }

   // $FF: synthetic method
   static String access$1000(InterstitialAd var0) {
      return var0.uniqueId;
   }

   // $FF: synthetic method
   static Context access$1100(InterstitialAd var0) {
      return var0.context;
   }

   // $FF: synthetic method
   static ImpressionListener access$900(InterstitialAd var0) {
      return var0.impListener;
   }

   private void ensureAdRequestController() {
      if(this.adRequestController == null) {
         throw new RuntimeException("No request controller available, has the InterstitialAd been destroyed?");
      }
   }

   private void preloadMarkup(com.facebook.ads.a.y var1) {
      if(var1 != null) {
         this.adWebView = new WebView(this.context);
         this.adWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView var1, int var2) {
               if(var2 == 100 && InterstitialAd.this.adListener != null) {
                  InterstitialAd.this.adListener.onAdLoaded(InterstitialAd.this);
               }

            }
         });
         this.adWebView.loadDataWithBaseURL(com.facebook.ads.a.s.a(), var1.c(), "text/html", "utf-8", (String)null);
      }
   }

   public void destroy() {
      if(this.adRequestController != null) {
         this.adRequestController.c();
         this.adRequestController = null;
         this.broadcastReceiver.b();
      }

      if(this.adWebView != null) {
         com.facebook.ads.a.s.a(this.adWebView);
         this.adWebView.destroy();
         this.adWebView = null;
      }

   }

   public boolean isAdLoaded() {
      return this.adLoaded;
   }

   public void loadAd() {
      this.ensureAdRequestController();
      this.adLoaded = false;
      this.adRequestController.b();
   }

   public void setAdListener(InterstitialAdListener var1) {
      this.adListener = var1;
   }

   public void setImpressionListener(ImpressionListener var1) {
      this.impListener = var1;
   }

   public boolean show() {
      if(!this.adLoaded) {
         if(this.adListener != null) {
            this.adListener.onError(this, AdError.INTERNAL_ERROR);
         }

         return false;
      } else {
         Intent var1 = new Intent(this.context, InterstitialAdActivity.class);
         ((com.facebook.ads.a.y)this.adResponse.d()).a(var1);
         this.adLoaded = false;
         Display var2 = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay();
         DisplayMetrics var3 = new DisplayMetrics();
         var2.getMetrics(var3);
         var1.putExtra("displayRotation", var2.getRotation());
         var1.putExtra("displayWidth", var3.widthPixels);
         var1.putExtra("displayHeight", var3.heightPixels);
         var1.putExtra("isTablet", this.isTablet);
         var1.putExtra("adHeight", this.adHeight);
         var1.putExtra("adWidth", this.adWidth);
         var1.putExtra("adInterstitialUniqueId", this.uniqueId);
         var1.putExtra("useNativeCloseButton", this.useNativeCloseButton);
         this.context.startActivity(var1);
         return true;
      }
   }
}
