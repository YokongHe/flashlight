package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.inneractive.api.ads.sdk.IAadViewController$BannerRequestState;
import com.inneractive.api.ads.sdk.IAdefines;
import com.inneractive.api.ads.sdk.IAdefines$IAintegratedSdksTrackingAction;
import com.inneractive.api.ads.sdk.IAnetworkFetcher;
import com.inneractive.api.ads.sdk.InneractiveAdView;
import com.inneractive.api.ads.sdk.InneractiveAdView$Gender;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$InternalAdType;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.InneractiveAdView$MediationName;
import com.inneractive.api.ads.sdk.aa$a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class IAadViewController implements aa$a {
   private final Context a;
   private InneractiveAdView b;
   private final com.inneractive.api.ads.sdk.i c;
   private final com.inneractive.api.ads.sdk.am d;
   private IAnetworkFetcher e;
   private com.inneractive.api.ads.sdk.a f;
   private final Runnable g;
   private IAadViewController$BannerRequestState h;
   private boolean i;
   private Handler j;
   private String k;
   private LocationListener l;
   private com.inneractive.api.ads.sdk.n m;
   private boolean n = true;

   IAadViewController(Context var1, InneractiveAdView var2) {
      this.a = var1;
      this.b = var2;
      this.c = new com.inneractive.api.ads.sdk.i(var1);
      this.d = new com.inneractive.api.ads.sdk.am();
      this.f = new com.inneractive.api.ads.sdk.a(this.a);
      this.e = com.inneractive.api.ads.sdk.Z.a(this.f, this);
      this.g = new Runnable() {
         // $FF: synthetic field
         private IAadViewController a = IAadViewController.this;

         public final void run() {
            this.a.a();
         }
      };
      this.j = new Handler();
      this.h = IAadViewController$BannerRequestState.a;
      this.l = new LocationListener() {
         // $FF: synthetic field
         private IAadViewController a = IAadViewController.this;

         public final void onLocationChanged(Location var1) {
            this.a.a(var1);
         }

         public final void onProviderDisabled(String var1) {
         }

         public final void onProviderEnabled(String var1) {
         }

         public final void onStatusChanged(String var1, int var2, Bundle var3) {
         }
      };
      var1 = this.a;
      LocationListener var6 = this.l;
      LocationManager var3 = (LocationManager)var1.getSystemService("location");

      try {
         var3.requestLocationUpdates("gps", 900000L, 200.0F, var6, var1.getMainLooper());
      } catch (SecurityException var4) {
         InneractiveAdView$Log.a("Error retrieved when trying to get the network location - access appears to be disabled.");
      } catch (IllegalArgumentException var5) {
         InneractiveAdView$Log.a("Error retrieved when trying to get the network location - device has no network provider.");
      }
   }

   private void b(InneractiveAdView$InneractiveErrorCode var1) {
      this.h = IAadViewController$BannerRequestState.d;
      this.b.b(var1);
   }

   static void f(String var0) {
      if(var0 != null) {
         com.inneractive.api.ads.sdk.a.a = var0;
      }

   }

   private Map p() {
      return this.f.v() != null?this.f.v().a():null;
   }

   final void a() {
      boolean var1;
      if(this.a == null) {
         InneractiveAdView$Log.c("Context is null! Please provide a valid Context and re-try.");
         var1 = false;
      } else if(com.inneractive.api.ads.sdk.an.a(this.f.b())) {
         InneractiveAdView$Log.c("appID is null or empty. Please provide a valid appID and re-try.");
         var1 = false;
      } else if(this.a.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
         InneractiveAdView$Log.c("INTERNET permission is missing. Please add it to the Manifest and re-try, otherwise ads will not be requested and displayed! ");
         var1 = false;
      } else {
         if(this.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            InneractiveAdView$Log.c("It is recommended to add ACCESS_NETWORK_STATE permission to the Manifest for better targetting");
         }

         if(this.a.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == -1) {
            InneractiveAdView$Log.e("It is recomended to add the READ_PHONE_STATE permission to the manifest for better targetting");
         }

         var1 = true;
      }

      if(var1) {
         NetworkInfo var2 = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
         if(var2 != null && var2.isConnected()) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(!var1) {
            InneractiveAdView$Log.e("Network is not connected");
            this.b(InneractiveAdView$InneractiveErrorCode.CONNECTION_ERROR);
            return;
         }

         String var3 = this.c.b(this.f.b()).d(this.f.c()).a(this.f.e()).a(this.f.d()).c(this.f.h()).e(this.f.l()).a(this.f.w()).a(this.f.f()).b(this.f.f()).a(this.f.A()).b(this.f.C()).c(this.f.D()).a(this.f.m() + IAdefines.e);
         if(var3 != null) {
            InneractiveAdView$Log.a("Ad request URL: " + var3);
            if(this.h == IAadViewController$BannerRequestState.b) {
               var1 = true;
            } else {
               var1 = false;
            }

            if(var1) {
               if(this.f.b() != null) {
                  InneractiveAdView$Log.b("Loading is already in progress for this ad spot.");
                  return;
               }
            } else {
               this.h = IAadViewController$BannerRequestState.b;
               this.k = var3;
               var3 = this.k;
               if(this.e != null) {
                  this.e.a(var3, this.a);
                  return;
               }
            }
         }
      }

   }

   final void a(int var1) {
      InneractiveAdView$Log.a("delayedRefreshAd called with " + var1);
      if(this.f.A() == null) {
         boolean var2;
         if(this.h == IAadViewController$BannerRequestState.a) {
            var2 = true;
         } else {
            var2 = false;
         }

         if(!var2) {
            this.c();
            if(var1 > 0) {
               InneractiveAdView$Log.d("schedule refresh timer If it\'s enabled. " + this.b);
               this.j.postDelayed(this.g, (long)var1);
            }

         } else {
            InneractiveAdView$Log.a("Ad is not ready and cannot be refreshed.");
         }
      } else {
         InneractiveAdView$Log.a("As you\'re using a mediation, the autoRefresh will be turned off and the refresh interval will be set to 0");
      }
   }

   final void a(Location var1) {
      com.inneractive.api.ads.sdk.a var2 = this.f;
      com.inneractive.api.ads.sdk.a.a(var1);
   }

   final void a(final View var1) {
      this.j.post(new Runnable() {
         // $FF: synthetic field
         private View a = var1;
         // $FF: synthetic field
         private IAadViewController b = IAadViewController.this;

         public final void run() {
            InneractiveAdView var1 = this.b.d();
            if(var1 != null) {
               var1.removeAllViews();
               var1.addView(this.a, this.b.f.a(this.a, this.b.a));
            }
         }
      });
   }

   final void a(IAdefines$IAintegratedSdksTrackingAction var1) {
      String var3;
      label24: {
         if(var1 != null) {
            String var2 = this.f.n() + IAdefines.c;
            InneractiveAdView$Log.d("integrated sdks tracking server host: " + var2);
            if(var2 != null) {
               if(IAdefines$IAintegratedSdksTrackingAction.a.equals(var1)) {
                  var3 = this.d.a(this.f.w()).b(this.f.b()).c(this.f.v().a).d(this.f.y()).b().g(this.f.x()).a(var2, var1);
                  break label24;
               }

               if(IAdefines$IAintegratedSdksTrackingAction.b.equals(var1)) {
                  var3 = this.d.a(this.f.w()).b(this.f.b()).c(this.f.v().a).h(this.f.z()).e("paying").a(var2, var1);
                  break label24;
               }
            } else {
               InneractiveAdView$Log.d("getTrackingServerHostname(" + var1 + ") = null!");
            }
         } else {
            InneractiveAdView$Log.a("generateIntegratedSdksTrackingUrl. trackingType is NULL");
         }

         var3 = null;
      }

      if(var3 != null) {
         ArrayList var4 = new ArrayList();
         var4.add(var3);
         (new com.inneractive.api.ads.sdk.al()).a((List)var4);
      }

   }

   final void a(InneractiveAdView$Gender var1) {
      this.f.a(var1);
   }

   public final void a(InneractiveAdView$InneractiveErrorCode var1) {
      this.b(var1);
   }

   final void a(InneractiveAdView$InternalAdType var1) {
      this.f.a(var1);
   }

   final void a(InneractiveAdView$MediationName var1) {
      this.f.a(var1);
   }

   public final void a(com.inneractive.api.ads.sdk.ag var1) {
      if(this.b != null) {
         String var3 = var1.f;

         try {
            this.f.a(var1);
         } catch (Exception var5) {
            InneractiveAdView$Log.a("Failed to set response params: " + var3);
         }

         if(this.f != null) {
            var3 = this.f.v().d;
            if(var3 != null) {
               if("OK".equals(var3)) {
                  this.h = IAadViewController$BannerRequestState.c;
                  if(this.b != null) {
                     InneractiveAdView var6 = this.b;
                     InneractiveAdView.f();
                  }

                  if(this.n) {
                     this.n();
                     return;
                  }

                  return;
               }

               if("House Ad".equals(var3)) {
                  this.h = IAadViewController$BannerRequestState.c;
                  if(this.b != null) {
                     InneractiveAdView var7 = this.b;
                     InneractiveAdView.g();
                  }

                  if(this.n) {
                     boolean var2 = false;
                     if(this.f.f() == InneractiveAdView$InternalAdType.c) {
                        var2 = true;
                     }

                     if(com.inneractive.api.ads.sdk.a.a(this.a, "MM", var2) && this.p() != null && this.p().get("MM") != null) {
                        var1.f = "millennial";
                     }

                     this.n();
                     return;
                  }

                  return;
               }

               if("Internal Error".equals(var3)) {
                  this.h = IAadViewController$BannerRequestState.a;
                  this.b(InneractiveAdView$InneractiveErrorCode.SERVER_INTERNAL_ERROR);
                  return;
               }

               if("Invalid Input".equals(var3)) {
                  this.h = IAadViewController$BannerRequestState.a;
                  this.b(InneractiveAdView$InneractiveErrorCode.INVALID_INPUT);
                  return;
               }

               if("Unknown AppID".equals(var3)) {
                  this.h = IAadViewController$BannerRequestState.a;
                  this.b(InneractiveAdView$InneractiveErrorCode.UNKNOWN_APP_ID);
                  return;
               }
            }
         }

         this.h = IAadViewController$BannerRequestState.a;
         this.b(InneractiveAdView$InneractiveErrorCode.UNSPECIFIED);
      }
   }

   final void a(String var1) {
      this.f.d(var1);
   }

   final void a(boolean var1) {
      this.f.c(var1);
   }

   final void b() {
      if(this.m != null) {
         this.m.k();
         this.m = null;
      }

      this.a();
   }

   final void b(int var1) {
      this.f.a(var1);
   }

   final void b(String var1) {
      this.f.c(var1);
   }

   final void b(boolean var1) {
      this.f.d(var1);
   }

   final void c() {
      InneractiveAdView$Log.a("cancelRefreshTimer called");
      this.j.removeCallbacks(this.g);
   }

   final void c(int var1) {
      this.f.b(var1);
   }

   final void c(String var1) {
      this.f.e(var1);
   }

   final void c(boolean var1) {
      this.f.e(var1);
   }

   protected final InneractiveAdView d() {
      return this.b;
   }

   final void d(String var1) {
      this.f.a(var1);
   }

   final String e() {
      return this.f.c();
   }

   final void e(String var1) {
      this.f.b(var1);
   }

   final InneractiveAdView$Gender f() {
      return this.f.d();
   }

   final int g() {
      return this.f.e();
   }

   final int h() {
      return this.f.g();
   }

   final String i() {
      return this.f.h();
   }

   final com.inneractive.api.ads.sdk.ag j() {
      return this.f.v();
   }

   final com.inneractive.api.ads.sdk.a k() {
      return this.f;
   }

   final void l() {
      // $FF: Couldn't be decompiled
   }

   final Integer m() {
      com.inneractive.api.ads.sdk.a var1 = this.f;
      return null;
   }

   final void n() {
      if(this.b != null) {
         if(this.f != null && this.f.v() != null) {
            if(this.m != null) {
               this.m.k();
            }

            this.m = com.inneractive.api.ads.sdk.o.a(this.b, this.f);
            this.m.i();
         } else {
            InneractiveAdView$Log.a("Couldn\'t load ad because the server did not specify one.");
            this.b(InneractiveAdView$InneractiveErrorCode.SDK_INTERNAL_ERROR);
         }
      }
   }

   final void o() {
      if(this.m != null) {
         this.m.j();
      }

   }
}
