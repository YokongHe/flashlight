package com.inmobi.monetization.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Response;
import com.inmobi.monetization.internal.Ad;
import com.inmobi.monetization.internal.Ad$AD_FORMAT;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.InterstitialAd$a;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.monetization.internal.imai.IMAIController$InterstitialAdStateListener;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView$IMWebViewListener;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class InterstitialAd extends Ad implements IMAIController$InterstitialAdStateListener {
   long b = 0L;
   boolean c = true;
   private Activity d;
   private long e;
   private IMWebView f;
   private long g = 0L;
   private Object h = null;
   private Response i = null;
   private boolean j = false;
   private boolean k = false;
   private InterstitialAd$a l = new InterstitialAd$a(this);
   private IMWebView$IMWebViewListener m = new IMWebView$IMWebViewListener() {
      public void onDismissAdScreen() {
         if(InterstitialAd.this.mAdListener != null) {
            InterstitialAd.this.mAdListener.onDismissAdScreen();
         }

      }

      public void onDisplayFailed() {
         InterstitialAd.this.b();
      }

      public void onError() {
         Log.debug("[InMobi]-[Monetization]", "Error loading the interstitial ad ");
         InterstitialAd.this.l.removeMessages(301);
         InterstitialAd.this.f = null;
         if(InterstitialAd.this.mAdListener != null) {
            InterstitialAd.this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
         }

      }

      public void onExpand() {
      }

      public void onExpandClose() {
      }

      public void onIncentCompleted(Map var1) {
         if(InterstitialAd.this.mAdListener != null) {
            InterstitialAd.this.mAdListener.onIncentCompleted(var1);
         }

      }

      public void onLeaveApplication() {
         if(InterstitialAd.this.mAdListener != null) {
            InterstitialAd.this.mAdListener.onLeaveApplication();
         }

      }

      public void onResize(ResizeDimensions var1) {
      }

      public void onResizeClose() {
      }

      public void onShowAdScreen() {
         if(InterstitialAd.this.mAdListener != null) {
            InterstitialAd.this.mAdListener.onShowAdScreen();
         }

      }

      public void onUserInteraction(Map var1) {
         if(InterstitialAd.this.mAdListener != null) {
            InterstitialAd.this.mAdListener.onAdInteraction(var1);
         }

      }
   };

   public InterstitialAd(Activity var1, long var2) {
      super(var2);
      this.d = var1;
      this.j = this.initialize();
   }

   public InterstitialAd(Activity var1, String var2) {
      super(var2);
      this.d = var1;
      this.j = this.initialize();
   }

   private static int a() {
      byte var0 = 14;
      if(DeviceInfo.isTablet(InternalSDKUtil.getContext())) {
         var0 = 17;
      }

      return var0;
   }

   private boolean a(Object var1) {
      try {
         Field var3 = var1.getClass().getDeclaredField("mIsPlayableReady");
         var3.setAccessible(true);
         boolean var2 = ((Boolean)var3.get(var1)).booleanValue();
         return var2;
      } catch (Exception var4) {
         return false;
      }
   }

   // $FF: synthetic method
   static IMWebView b(InterstitialAd var0) {
      return var0.f;
   }

   private void b() {
      try {
         if(this.mAdListener != null) {
            this.mAdListener.onShowAdScreen();
         }

         Intent var1 = new Intent(this.d, IMBrowserActivity.class);
         var1.putExtra("extra_browser_type", 101);
         var1.putExtra("isAnimationEnabledOnDimiss", this.g);
         IMBrowserActivity.setWebview(this.f);
         IMBrowserActivity.setOriginalActivity(this.d);
         this.d.startActivity(var1);
      } catch (Exception var2) {
         Log.debug("[InMobi]-[Monetization]", "Error showing ad ", var2);
      }
   }

   private void b(Object var1) {
      try {
         Method var2 = var1.getClass().getDeclaredMethod("show", new Class[]{IMAdListener.class});
         var2.setAccessible(true);
         var2.invoke(var1, new Object[]{this.mAdListener});
      } catch (Exception var3) {
         Log.internal("[InMobi]-[Monetization]", "Failed to display playable ad");
         this.b();
      }
   }

   // $FF: synthetic method
   static long c(InterstitialAd var0) {
      return var0.e;
   }

   private void c() {
      if(!this.k) {
         long var1 = System.currentTimeMillis();
         long var3 = this.mFetchStartTime;
         String var5;
         if(this.i != null) {
            var5 = this.i.getResponseBody();
         } else {
            var5 = null;
         }

         if(var5 != null) {
            var5 = var5.replace("@__imm_aft@", "" + (var1 - var3));
            if(VERSION.SDK_INT <= 8) {
               var5.replaceAll("%", "%25");
            }

            this.e = System.currentTimeMillis();
            this.l.sendEmptyMessageDelayed(301, (long)Initializer.getConfigParams().getRenderTimeOut());
            this.f.loadDataWithBaseURL("", var5, "text/html", (String)null, (String)null);
         } else {
            Log.debug("[InMobi]-[Monetization]", "Cannot load Ad. Invalid Ad Response");
            if(this.mAdListener != null) {
               this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
               return;
            }
         }
      }

   }

   // $FF: synthetic method
   static Response d(InterstitialAd var0) {
      return var0.i;
   }

   private boolean d() {
      try {
         Class.forName("com.inmobi.monetization.internal.thirdparty.PlayableAdsManager");
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   private Object e() {
      try {
         Object var1 = Class.forName("com.inmobi.monetization.internal.thirdparty.PlayableAdsManager").getConstructor(new Class[]{Activity.class, IMWebView.class}).newInstance(new Object[]{this.d, this.f});
         return var1;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Monetization]", "Exception creating playable ads", var2);
         return null;
      }
   }

   private void f() {
      if(this.f == null) {
         this.f = new IMWebView(this.d, this.m, true, false);
         if(!this.c) {
            this.f.disableHardwareAcceleration();
         }

         IMAIController var1 = new IMAIController(this.f);
         var1.setInterstitialAdStateListener(this);
         this.f.addJavascriptInterface(var1, "imaiController");
      }

   }

   public void disableHardwareAcceleration() {
      if(!this.j) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         this.c = false;
         if(this.f != null) {
            this.f.disableHardwareAcceleration();
            return;
         }
      }

   }

   protected Map getAdFormatParams() {
      HashMap var1 = new HashMap();
      var1.put("format", Ad$AD_FORMAT.IMAI.toString().toLowerCase(Locale.getDefault()));
      var1.put("mk-ads", "1");
      var1.put("mk-ad-slot", String.valueOf(a()));
      var1.put("adtype", "int");
      if(this.d()) {
         var1.put("playable", String.valueOf(1));
      }

      return var1;
   }

   public void handleResponse(com.inmobi.monetization.internal.c var1, Response var2) {
      try {
         this.i = var2;
         this.d.runOnUiThread(new Runnable() {
            public void run() {
               InterstitialAd.this.c();
            }
         });
      } catch (Exception var3) {
         Log.debug("[InMobi]-[Monetization]", "Error retrieving ad ", var3);
         if(this.mAdListener != null) {
            this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            return;
         }
      }

   }

   protected boolean initialize() {
      if(this.d == null) {
         Log.debug("[InMobi]-[Monetization]", "Activity cannot be null");
         return false;
      } else {
         this.d = com.inmobi.monetization.internal.b.a(this.d);
         this.f();
         if(this.d()) {
            this.h = this.e();
         }

         return super.initialize();
      }
   }

   public void loadAd() {
      if(!this.j) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         this.k = false;
         this.f();
         super.loadAd();
      }
   }

   public void onAdFailed() {
      this.l.removeMessages(301);
      if(!this.k && this.mAdListener != null) {
         this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
      }

   }

   public void onAdReady() {
      long var1 = System.currentTimeMillis();
      long var3 = this.e;
      this.collectMetrics(this.i, var1 - var3, NetworkEventType.RENDER_COMPLETE);
      if(!this.k) {
         this.l.removeMessages(301);
         if(this.mAdListener != null) {
            this.mAdListener.onAdRequestSucceeded();
         }
      }

   }

   public void show() {
      try {
         if(!this.j) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
         } else {
            Log.debug("[InMobi]-[Monetization]", "Showing the Interstitial Ad. ");
            if(this.d() && this.h != null && this.a(this.h)) {
               this.b(this.h);
            } else {
               this.b();
            }
         }
      } catch (Exception var2) {
         Log.debug("[InMobi]-[Monetization]", "Error showing ad ", var2);
      }
   }

   public void show(long var1) {
      if(!this.j) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         this.g = var1;
         this.show();
      }
   }

   public void stopLoading() {
      if(!this.j) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         super.stopLoading();
         if(this.l != null && this.l.hasMessages(301)) {
            this.l.removeMessages(301);
         }

         this.k = true;
      }
   }
}
