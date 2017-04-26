package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.inneractive.api.ads.sdk.IAadViewController;
import com.inneractive.api.ads.sdk.IAdefines$ApiLevel;
import com.inneractive.api.ads.sdk.IAdefines$IAintegratedSdksTrackingAction;
import com.inneractive.api.ads.sdk.InneractiveAdView$AdType;
import com.inneractive.api.ads.sdk.InneractiveAdView$Gender;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveBannerAdListener;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$InternalAdType;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.InneractiveAdView$MediationName;
import com.inneractive.api.ads.sdk.InneractiveInterstitialView;

public class InneractiveAdView extends FrameLayout {
   protected IAadViewController a;
   private Context b;
   private BroadcastReceiver c;
   private InneractiveAdView$InneractiveBannerAdListener d;
   private boolean e;
   private boolean f;
   private boolean g;
   private boolean h;

   public InneractiveAdView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.e = false;
      this.f = true;
      this.g = false;
      this.h = true;
      this.b = var1;
      this.a = com.inneractive.api.ads.sdk.j.a(var1, this);
      if(var2 != null) {
         String var4 = "http://schemas.android.com/apk/res/" + var1.getPackageName();
         this.a.b(var2.getAttributeValue(var4, "appId"));
         this.a.a(var2.getAttributeValue(var4, "keywords"));
         this.a.c(var2.getAttributeValue(var4, "zipCode"));
         this.a.b(var2.getAttributeIntValue(var4, "age", -1));
         this.a.c(var2.getAttributeIntValue(var4, "refreshInterval", -1));
         int var3 = var2.getAttributeIntValue(var4, "adType", -1);
         if(var3 >= 0 && var3 <= 1) {
            this.a.a(InneractiveAdView$InternalAdType.values()[var3]);
         }

         var3 = var2.getAttributeIntValue(var4, "mediationName", -1);
         if(var3 >= 0 && var3 <= 2) {
            this.a.a(InneractiveAdView$MediationName.values()[var3]);
         }

         var3 = var2.getAttributeIntValue(var4, "gender", -1);
         if(var3 >= 0 && var3 <= 1) {
            this.a.a(InneractiveAdView$Gender.values()[var3]);
         }
      }

      IAadViewController var5;
      if(this instanceof InneractiveInterstitialView) {
         var5 = this.a;
         IAadViewController.f(com.inneractive.api.ads.sdk.a.a(var1, false));
      } else {
         var5 = this.a;
         IAadViewController.f(com.inneractive.api.ads.sdk.a.a(var1, true));
      }

      this.setHorizontalScrollBarEnabled(false);
      this.setVerticalScrollBarEnabled(false);
      if(WebViewDatabase.getInstance(var1) == null) {
         InneractiveAdView$Log.d("Could not proceed :-(. http://code.google.com/p/android/issues/detail?id=10789");
      }

   }

   public InneractiveAdView(Context var1, String var2, InneractiveAdView$AdType var3) {
      this(var1, var2, InneractiveAdView$AdType.a(var3));
   }

   InneractiveAdView(Context var1, String var2, InneractiveAdView$InternalAdType var3) {
      this(var1, (AttributeSet)null);
      this.a.b(var2);
      this.a.a(var3);
      if(!IAdefines$ApiLevel.a().equals(IAdefines$ApiLevel.b) && !IAdefines$ApiLevel.a().equals(IAdefines$ApiLevel.c)) {
         Activity var4 = (Activity)var1;
         if(var4 != null) {
            com.inneractive.api.ads.sdk.a.b(com.inneractive.api.ads.sdk.a.a(var4));
            return;
         }
      } else {
         com.inneractive.api.ads.sdk.a.b(true);
      }

   }

   // $FF: synthetic method
   static Context a(InneractiveAdView var0) {
      return var0.b;
   }

   protected static void f() {
      InneractiveAdView$Log.d("adReceived");
   }

   protected static void g() {
      InneractiveAdView$Log.d("defaultAdReceived");
   }

   void a() {
      if(this.a != null) {
         this.a.a();
      }

   }

   protected void a(int var1) {
      if(this.a != null) {
         boolean var2 = ((PowerManager)this.b.getSystemService("power")).isScreenOn();
         InneractiveAdView$Log.d("refreshAdIfPossible screenOn = " + var2);
         InneractiveAdView$Log.d("refreshAdIfPossible mIsAExpandedState = " + this.e);
         InneractiveAdView$Log.d("refreshAdIfPossible mUsedAppIdIsValid = " + this.f);
         InneractiveAdView$Log.d("refreshAdIfPossible isShown = " + this.isShown());
         if(var2 && !this.e && this.f && this.isShown()) {
            this.a.a(var1);
            return;
         }
      }

   }

   final void a(View var1) {
      if(this.a != null) {
         this.a.a(var1);
      }

   }

   protected final void a(IAdefines$IAintegratedSdksTrackingAction var1) {
      InneractiveAdView$Log.d("Tracking native action. ");
      if(this.a != null) {
         this.a.a(var1);
      }

   }

   protected final void a(InneractiveAdView$InneractiveErrorCode var1) {
      InneractiveAdView$Log.d("Error Code: " + var1);
      if(InneractiveAdView$InneractiveErrorCode.NO_FILL.equals(var1)) {
         if(this.a != null) {
            this.a.j().f = "inneractive_mraid";
            this.a.n();
         }

      } else {
         this.b(var1);
      }
   }

   Integer b() {
      return this.a != null?this.a.m():null;
   }

   protected void b(InneractiveAdView$InneractiveErrorCode var1) {
      InneractiveAdView$Log.d("adFailed");
      if(this.a != null && this.a.k() != null) {
         if(!InneractiveAdView$InneractiveErrorCode.INVALID_INPUT.equals(var1) && !InneractiveAdView$InneractiveErrorCode.UNKNOWN_APP_ID.equals(var1)) {
            this.a.a(15000);
         } else {
            this.f = false;
         }
      }

      if(this.d != null) {
         this.d.inneractiveBannerFailed(this, var1);
      }

   }

   protected final void c() {
      // $FF: Couldn't be decompiled
   }

   protected void d() {
      InneractiveAdView$Log.d("adLoaded");
      if(this.a != null && this.a.k() != null) {
         String var1 = this.a.k().y();
         if(var1 != null && !"".equals(var1)) {
            this.a(IAdefines$IAintegratedSdksTrackingAction.a);
         }

         this.a(com.inneractive.api.ads.sdk.an.a(this.a.h()));
      }

      if(this.d != null) {
         this.d.inneractiveBannerLoaded(this);
      }

   }

   public void destroy() {
      try {
         this.b.unregisterReceiver(this.c);
      } catch (Exception var2) {
         InneractiveAdView$Log.d("Broadcast receiver was not registered and therfore won\'t be released.");
      }

      this.removeAllViews();
      if(this.a != null) {
         this.a.l();
         this.a = null;
      }

   }

   protected void e() {
      InneractiveAdView$Log.d("defaultAdLoaded");
      if(this.a != null && this.a.k() != null) {
         String var1 = this.a.k().y();
         if(var1 != null && !"".equals(var1)) {
            this.a(IAdefines$IAintegratedSdksTrackingAction.a);
         }

         this.a(com.inneractive.api.ads.sdk.an.a(this.a.h()));
      }

      if(this.d != null) {
         this.d.inneractiveDefaultBannerLoaded(this);
      }

   }

   public void forceRefresh() {
      if(this instanceof InneractiveInterstitialView) {
         InneractiveAdView$Log.b("The option to set the refresh interval for is available ONLY for banner/rectangle!");
      } else if(this.a != null) {
         this.a.b();
         return;
      }

   }

   public int getAge() {
      return this.a != null?this.a.g():-1;
   }

   public InneractiveAdView$InneractiveBannerAdListener getBannerAdListener() {
      return this.d;
   }

   public InneractiveAdView$Gender getGender() {
      return this.a != null?this.a.f():null;
   }

   public String getKeywords() {
      return this.a != null?this.a.e():null;
   }

   public int getRefreshInterval() {
      return this.a != null?this.a.h():-1;
   }

   public String getSDKversion() {
      return "5.0.4";
   }

   public String getZipCode() {
      return this.a != null?this.a.i():null;
   }

   protected final void h() {
      InneractiveAdView$Log.d("adExpanded");
      this.e = true;
      if(this.d != null) {
         this.d.inneractiveBannerExpanded(this);
      }

      this.a.c();
   }

   protected final void i() {
      InneractiveAdView$Log.d("adCollapsed");
      this.e = false;
      if(this.d != null) {
         this.d.inneractiveBannerCollapsed(this);
      }

      this.a(1000);
   }

   protected final void j() {
      InneractiveAdView$Log.d("adResized");
      if(this.d != null) {
         this.d.inneractiveBannerResized(this);
      }

   }

   protected void k() {
      InneractiveAdView$Log.d("adClicked");
      if(this.a != null && this.a.k() != null) {
         String var1 = this.a.k().z();
         if(var1 != null && !"".equals(var1) && !"IA".equals(var1)) {
            this.a(IAdefines$IAintegratedSdksTrackingAction.b);
         }
      }

      if(this.d != null) {
         this.d.inneractiveBannerClicked(this);
      }

   }

   protected void l() {
      InneractiveAdView$Log.d("applicationInTheBackground");
      if(this.d != null) {
         this.d.inneractiveAdWillOpenExternalApp(this);
      }

   }

   public void loadAd() {
      if(!(this instanceof InneractiveInterstitialView)) {
         InneractiveAdView$Log.d("register to screen state broadcast receiver");
         if(this.a != null && !(this instanceof InneractiveInterstitialView)) {
            this.c = new BroadcastReceiver() {
               // $FF: synthetic field
               private InneractiveAdView a = InneractiveAdView.this;

               public final void onReceive(Context param1, Intent param2) {
                  // $FF: Couldn't be decompiled
               }
            };
            IntentFilter var1 = new IntentFilter("android.intent.action.SCREEN_OFF");
            var1.addAction("android.intent.action.SCREEN_ON");
            var1.addAction("android.intent.action.USER_PRESENT");
            this.b.registerReceiver(this.c, var1);
         }
      }

      this.a();
   }

   protected void m() {
      InneractiveAdView$Log.d("intenalBrowserDissmissed");
      if(this.d != null) {
         this.d.inneractiveInternalBrowserDismissed(this);
      }

   }

   final IAadViewController n() {
      return this.a;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      InneractiveAdView$Log.d("onAttachedToWindow");
      this.a(com.inneractive.api.ads.sdk.an.a(this.a.h()));
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      InneractiveAdView$Log.d("onDetachedFromWindow");
      this.g = false;
      if(this.a != null) {
         this.a.c();
      }

   }

   protected void onVisibilityChanged(View var1, int var2) {
      super.onVisibilityChanged(var1, var2);
      InneractiveAdView$Log.d("onVisibilityChanged. this: " + this + " mCurrentIsShown: " + this.g + ". isShown: " + this.isShown());
      boolean var3 = this.isShown();
      if(!this.g && var3) {
         this.a(1000);
      } else if(this.g && !var3 && this.a != null) {
         this.a.c();
      }

      this.g = var3;
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      if(this.h) {
         this.g = this.isShown();
         this.h = false;
      }

   }

   public void setAge(int var1) {
      if(this.a != null) {
         this.a.b(var1);
      }

   }

   public void setAndroidIdEnabled(boolean var1) {
      if(this.a != null) {
         this.a.a(var1);
      }

   }

   public void setBannerAdListener(InneractiveAdView$InneractiveBannerAdListener var1) {
      this.d = var1;
   }

   public void setDeviceIdEnabled(boolean var1) {
      if(this.a != null) {
         this.a.b(var1);
      }

   }

   public void setGender(InneractiveAdView$Gender var1) {
      if(this.a != null) {
         this.a.a(var1);
      }

   }

   public void setKeywords(String var1) {
      if(this.a != null) {
         this.a.a(var1);
      }

   }

   public void setMediationName(InneractiveAdView$MediationName var1) {
      if(this.a != null && var1 != null) {
         this.a.a(var1);
         InneractiveAdView$Log.b("Setting the mediation Name to: " + var1 + " as the refresh interval should be turned off for mediation, the refresh interval will be set to 0 and autoRefresh will be turned off");
         this.a.c(0);
      }

   }

   public void setRefreshInterval(int var1) {
      if(this instanceof InneractiveInterstitialView) {
         InneractiveAdView$Log.b("The option to set the refresh interval for is available ONLY for banner/rectangle!");
      } else if(this.a != null) {
         this.a.c(var1);
         return;
      }

   }

   public void setZipCode(String var1) {
      if(this.a != null) {
         this.a.c(var1);
      }

   }

   public void testEnvironmentConfigurationName(String var1) {
      if(this.a != null) {
         this.a.d(var1);
      }

   }

   public void testEnvironmentConfigurationNumber(String var1) {
      if(this.a != null) {
         this.a.e(var1);
      }

   }
}
