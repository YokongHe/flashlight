package com.google.android.gms.internal;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.dy;
import java.util.ArrayList;
import java.util.HashSet;

public final class dr extends com.google.android.gms.internal.q implements com.google.android.gms.internal.F, com.google.android.gms.internal.J, com.google.android.gms.internal.R, com.google.android.gms.internal.aC, com.google.android.gms.internal.aV, com.google.android.gms.internal.ay, com.google.android.gms.internal.by, dq {
   private final com.google.android.gms.internal.Y a;
   private final dt b;
   private final dv c;
   private final com.google.android.gms.internal.a d;
   private boolean e;
   private final ComponentCallbacks f = new ComponentCallbacks() {
      public final void onConfigurationChanged(Configuration var1) {
         if(dr.this.b != null && dr.this.b.i != null && dr.this.b.i.b != null) {
            dr.this.b.i.b.a();
         }

      }

      public final void onLowMemory() {
      }
   };

   public dr(Context var1, com.google.android.gms.internal.ak var2, String var3, com.google.android.gms.internal.Y var4, dx var5) {
      this.b = new dt(var1, var2, var3, var5);
      this.a = var4;
      this.c = new dv(this);
      this.d = new com.google.android.gms.internal.a();
      com.google.android.gms.internal.bJ.c("Use AdRequest.Builder.addTestDevice(\"" + com.google.android.gms.internal.bI.a(var1) + "\") to get test ads on this device.");
      com.google.android.gms.internal.bD.b(var1);
      if(VERSION.SDK_INT >= 14 && this.b != null && this.b.c != null) {
         this.b.c.registerComponentCallbacks(this.f);
      }

   }

   private void a(int var1) {
      com.google.android.gms.internal.bJ.e("Failed to load ad: " + var1);
      if(this.b.f != null) {
         try {
            this.b.f.a(var1);
         } catch (RemoteException var3) {
            com.google.android.gms.internal.bJ.b("Could not call AdListener.onAdFailedToLoad().", var3);
            return;
         }
      }

   }

   private void a(View var1) {
      LayoutParams var2 = new LayoutParams(-2, -2);
      this.b.a.addView(var1, var2);
   }

   private void a(boolean var1) {
      if(this.b.i == null) {
         com.google.android.gms.internal.bJ.e("Ad state was null when trying to ping impression URLs.");
      } else {
         com.google.android.gms.internal.bJ.a("Pinging Impression URLs.");
         this.b.j.a();
         if(this.b.i.e != null) {
            com.google.android.gms.internal.bD.a(this.b.c, this.b.e.b, this.b.i.e);
         }

         if(this.b.i.o != null && this.b.i.o.d != null) {
            com.google.android.gms.internal.W.a(this.b.c, this.b.e.b, this.b.i, this.b.b, var1, this.b.i.o.d);
         }

         if(this.b.i.l != null && this.b.i.l.e != null) {
            com.google.android.gms.internal.W.a(this.b.c, this.b.e.b, this.b.i, this.b.b, var1, this.b.i.l.e);
            return;
         }
      }

   }

   private boolean b(com.google.android.gms.internal.bt var1) {
      View var6;
      if(var1.k) {
         try {
            var6 = (View)com.google.android.gms.a.e.a(var1.m.a());
         } catch (RemoteException var5) {
            com.google.android.gms.internal.bJ.b("Could not get View from mediation adapter.", var5);
            return false;
         }

         View var2 = this.b.a.getNextView();
         if(var2 != null) {
            this.b.a.removeView(var2);
         }

         try {
            this.a(var6);
         } catch (Throwable var4) {
            com.google.android.gms.internal.bJ.b("Could not add mediation view to view hierarchy.", var4);
            return false;
         }
      } else if(var1.r != null) {
         var1.b.a(var1.r);
         this.b.a.removeAllViews();
         this.b.a.setMinimumWidth(var1.r.g);
         this.b.a.setMinimumHeight(var1.r.d);
         this.a((View)var1.b);
      }

      if(this.b.a.getChildCount() > 1) {
         this.b.a.showNext();
      }

      if(this.b.i != null) {
         var6 = this.b.a.getNextView();
         if(var6 instanceof com.google.android.gms.internal.bL) {
            ((com.google.android.gms.internal.bL)var6).a(this.b.c, this.b.h);
         } else if(var6 != null) {
            this.b.a.removeView(var6);
         }

         if(this.b.i.m != null) {
            try {
               this.b.i.m.c();
            } catch (RemoteException var3) {
               com.google.android.gms.internal.bJ.e("Could not destroy previous mediation adapter.");
            }
         }
      }

      this.b.a.setVisibility(0);
      return true;
   }

   private com.google.android.gms.internal.bg c(com.google.android.gms.internal.ah var1) {
      ApplicationInfo var9 = this.b.c.getApplicationInfo();

      PackageInfo var7;
      try {
         var7 = this.b.c.getPackageManager().getPackageInfo(var9.packageName, 0);
      } catch (NameNotFoundException var12) {
         var7 = null;
      }

      Bundle var8;
      if(!this.b.h.e && this.b.a.getParent() != null) {
         int[] var13 = new int[2];
         this.b.a.getLocationOnScreen(var13);
         int var3 = var13[0];
         int var4 = var13[1];
         DisplayMetrics var14 = this.b.c.getResources().getDisplayMetrics();
         int var5 = this.b.a.getWidth();
         int var6 = this.b.a.getHeight();
         byte var2;
         if(this.b.a.isShown() && var3 + var5 > 0 && var4 + var6 > 0 && var3 <= var14.widthPixels && var4 <= var14.heightPixels) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         var8 = new Bundle(5);
         var8.putInt("x", var3);
         var8.putInt("y", var4);
         var8.putInt("width", var5);
         var8.putInt("height", var6);
         var8.putInt("visible", var2);
      } else {
         var8 = null;
      }

      String var10 = com.google.android.gms.internal.bw.b();
      this.b.j = new com.google.android.gms.internal.bu(var10, this.b.b);
      this.b.j.a(var1);
      Bundle var11 = com.google.android.gms.internal.bw.a((com.google.android.gms.internal.by)this, (String)var10);
      return new com.google.android.gms.internal.bg(var8, var1, this.b.h, this.b.b, var9, var7, var10, com.google.android.gms.internal.bw.a, this.b.e, var11);
   }

   private void s() {
      com.google.android.gms.internal.bJ.c("Ad finished loading.");
      if(this.b.f != null) {
         try {
            this.b.f.c();
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.b("Could not call AdListener.onAdLoaded().", var2);
            return;
         }
      }

   }

   private void t() {
      if(this.b.i != null) {
         this.b.i.b.destroy();
         this.b.i = null;
      }

   }

   public final com.google.android.gms.a.b a() {
      com.google.android.gms.internal.cM.a("getAdFrame must be called on the main UI thread.");
      return com.google.android.gms.a.e.a((Object)this.b.a);
   }

   public final void a(com.google.android.gms.internal.aP var1) {
      com.google.android.gms.internal.cM.a("setInAppPurchaseListener must be called on the main UI thread.");
      this.b.l = var1;
   }

   public final void a(com.google.android.gms.internal.ak var1) {
      com.google.android.gms.internal.cM.a("setAdSize must be called on the main UI thread.");
      this.b.h = var1;
      if(this.b.i != null) {
         this.b.i.b.a(var1);
      }

      if(this.b.a.getChildCount() > 1) {
         this.b.a.removeView(this.b.a.getNextView());
      }

      this.b.a.setMinimumWidth(var1.g);
      this.b.a.setMinimumHeight(var1.d);
      this.b.a.requestLayout();
   }

   public final void a(com.google.android.gms.internal.bt var1) {
      int var3 = 0;
      this.b.g = null;
      if(var1.d != -2 && var1.d != 3) {
         com.google.android.gms.internal.bw.a(this.b.a());
      }

      if(var1.d != -1) {
         boolean var4;
         if(var1.a.c != null) {
            var4 = var1.a.c.getBoolean("_noRefresh", false);
         } else {
            var4 = false;
         }

         if(this.b.h.e) {
            com.google.android.gms.internal.bD.a((WebView)var1.b);
         } else if(!var4) {
            if(var1.h > 0L) {
               this.c.a(var1.a, var1.h);
            } else if(var1.o != null && var1.o.g > 0L) {
               this.c.a(var1.a, var1.o.g);
            } else if(!var1.k && var1.d == 2) {
               this.c.a(var1.a);
            }
         }

         if(var1.d == 3 && var1.o != null && var1.o.e != null) {
            com.google.android.gms.internal.bJ.a("Pinging no fill URLs.");
            com.google.android.gms.internal.W.a(this.b.c, this.b.e.b, var1, this.b.b, false, var1.o.e);
         }

         if(var1.d != -2) {
            this.a(var1.d);
         } else {
            if(!this.b.h.e) {
               if(!this.b(var1)) {
                  this.a(0);
                  return;
               }

               if(this.b.a != null) {
                  ds.a(this.b.a).a(var1.v);
               }
            }

            if(this.b.i != null && this.b.i.p != null) {
               this.b.i.p.a((com.google.android.gms.internal.R)null);
            }

            if(var1.p != null) {
               var1.p.a((com.google.android.gms.internal.R)this);
            }

            this.d.a(this.b.i);
            this.b.i = var1;
            if(var1.r != null) {
               this.b.h = var1.r;
            }

            this.b.j.a(var1.t);
            this.b.j.b(var1.u);
            this.b.j.a(this.b.h.e);
            this.b.j.b(var1.k);
            if(!this.b.h.e) {
               this.a(false);
            }

            if(this.b.m == null) {
               this.b.m = new com.google.android.gms.internal.bz(this.b.b);
            }

            int var2;
            if(var1.o != null) {
               var2 = var1.o.h;
               var3 = var1.o.i;
            } else {
               var2 = 0;
            }

            this.b.m.a(var2, var3);
            if(!this.b.h.e && var1.b != null && (var1.b.f().a() || var1.j != null)) {
               com.google.android.gms.internal.b var5 = this.d.a(this.b.h, this.b.i);
               if(var1.b.f().a() && var5 != null) {
                  var5.a((dy)(new du(var1.b)));
               }
            }

            this.b.i.b.a();
            this.s();
         }
      }
   }

   public final void a(com.google.android.gms.internal.m var1) {
      com.google.android.gms.internal.cM.a("setAdListener must be called on the main UI thread.");
      this.b.f = var1;
   }

   public final void a(com.google.android.gms.internal.v var1) {
      com.google.android.gms.internal.cM.a("setAppEventListener must be called on the main UI thread.");
      this.b.k = var1;
   }

   public final void a(String var1, String var2) {
      if(this.b.k != null) {
         try {
            this.b.k.a(var1, var2);
         } catch (RemoteException var3) {
            com.google.android.gms.internal.bJ.b("Could not call the AppEventListener.", var3);
            return;
         }
      }

   }

   public final void a(String var1, ArrayList var2) {
      if(this.b.l == null) {
         com.google.android.gms.internal.bJ.e("InAppPurchaseListener is not set");
      } else {
         try {
            this.b.l.a(new com.google.android.gms.internal.aL(var1, var2, this.b.c, this.b.e.b));
         } catch (RemoteException var3) {
            com.google.android.gms.internal.bJ.e("Could not start In-App purchase.");
         }
      }
   }

   public final void a(HashSet var1) {
      this.b.a(var1);
   }

   public final boolean a(com.google.android.gms.internal.ah var1) {
      com.google.android.gms.internal.cM.a("loadAd must be called on the main UI thread.");
      if(this.b.g != null) {
         com.google.android.gms.internal.bJ.e("An ad request is already in progress. Aborting.");
      } else {
         if(this.b.h.e && this.b.i != null) {
            com.google.android.gms.internal.bJ.e("An interstitial is already loading. Aborting.");
            return false;
         }

         boolean var2;
         if(!com.google.android.gms.internal.bD.a(this.b.c.getPackageManager(), this.b.c.getPackageName(), "android.permission.INTERNET")) {
            if(!this.b.h.e) {
               com.google.android.gms.internal.bI.a(this.b.a, this.b.h, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }

            var2 = false;
         } else {
            var2 = true;
         }

         if(!com.google.android.gms.internal.bD.a(this.b.c)) {
            if(!this.b.h.e) {
               com.google.android.gms.internal.bI.a(this.b.a, this.b.h, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }

            var2 = false;
         }

         if(!var2 && !this.b.h.e) {
            this.b.a.setVisibility(0);
         }

         if(var2) {
            com.google.android.gms.internal.bJ.c("Starting ad request.");
            this.c.a();
            com.google.android.gms.internal.bg var4 = this.c(var1);
            com.google.android.gms.internal.bL var5;
            if(this.b.h.e) {
               var5 = com.google.android.gms.internal.bL.a(this.b.c, this.b.h, false, false, this.b.d, this.b.e);
               var5.f().a(this, (com.google.android.gms.internal.ay)null, this, this, true, this);
            } else {
               View var6 = this.b.a.getNextView();
               if(var6 instanceof com.google.android.gms.internal.bL) {
                  var5 = (com.google.android.gms.internal.bL)var6;
                  var5.a(this.b.c, this.b.h);
               } else {
                  if(var6 != null) {
                     this.b.a.removeView(var6);
                  }

                  com.google.android.gms.internal.bL var3 = com.google.android.gms.internal.bL.a(this.b.c, this.b.h, false, false, this.b.d, this.b.e);
                  var5 = var3;
                  if(this.b.h.h == null) {
                     this.a((View)var3);
                     var5 = var3;
                  }
               }

               var5.f().a(this, this, this, this, false, this);
            }

            dt var7 = this.b;
            com.google.android.gms.internal.aW var8 = new com.google.android.gms.internal.aW(this.b.c, var4, this.b.d, var5, this.a, this);
            var8.e();
            var7.g = var8;
            return true;
         }
      }

      return false;
   }

   public final void b() {
      com.google.android.gms.internal.cM.a("destroy must be called on the main UI thread.");
      if(VERSION.SDK_INT >= 14 && this.b != null && this.b.c != null) {
         this.b.c.unregisterComponentCallbacks(this.f);
      }

      this.b.f = null;
      this.b.k = null;
      this.c.a();
      this.g();
      if(this.b.a != null) {
         this.b.a.removeAllViews();
      }

      if(this.b.i != null && this.b.i.b != null) {
         this.b.i.b.destroy();
      }

      if(this.b.i != null && this.b.i.m != null) {
         try {
            this.b.i.m.c();
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.e("Could not destroy mediation adapter.");
            return;
         }
      }

   }

   public final void b(com.google.android.gms.internal.ah var1) {
      ViewParent var2 = this.b.a.getParent();
      if(var2 instanceof View && ((View)var2).isShown() && com.google.android.gms.internal.bD.a() && !this.e) {
         this.a(var1);
      } else {
         com.google.android.gms.internal.bJ.c("Ad is not visible. Not refreshing ad.");
         this.c.a(var1);
      }
   }

   public final boolean c() {
      com.google.android.gms.internal.cM.a("isLoaded must be called on the main UI thread.");
      return this.b.g == null && this.b.i != null;
   }

   public final void d() {
      com.google.android.gms.internal.cM.a("pause must be called on the main UI thread.");
      if(this.b.i != null) {
         com.google.android.gms.internal.bD.a((WebView)this.b.i.b);
      }

      if(this.b.i != null && this.b.i.m != null) {
         try {
            this.b.i.m.d();
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.e("Could not pause mediation adapter.");
         }
      }

      this.c.b();
   }

   public final void e() {
      com.google.android.gms.internal.cM.a("resume must be called on the main UI thread.");
      if(this.b.i != null) {
         com.google.android.gms.internal.bD.b((WebView)this.b.i.b);
      }

      if(this.b.i != null && this.b.i.m != null) {
         try {
            this.b.i.m.e();
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.e("Could not resume mediation adapter.");
         }
      }

      this.c.c();
   }

   public final void f() {
      com.google.android.gms.internal.cM.a("showInterstitial must be called on the main UI thread.");
      if(!this.b.h.e) {
         com.google.android.gms.internal.bJ.e("Cannot call showInterstitial on a banner ad.");
      } else if(this.b.i == null) {
         com.google.android.gms.internal.bJ.e("The interstitial has not loaded.");
      } else if(this.b.i.b.i()) {
         com.google.android.gms.internal.bJ.e("The interstitial is already showing.");
      } else {
         this.b.i.b.a(true);
         if(this.b.i.b.f().a() || this.b.i.j != null) {
            com.google.android.gms.internal.b var1 = this.d.a(this.b.h, this.b.i);
            if(this.b.i.b.f().a() && var1 != null) {
               var1.a((dy)(new du(this.b.i.b)));
            }
         }

         if(this.b.i.k) {
            try {
               this.b.i.m.b();
            } catch (RemoteException var2) {
               com.google.android.gms.internal.bJ.b("Could not show interstitial.", var2);
               this.t();
            }
         } else {
            com.google.android.gms.internal.ce var3 = new com.google.android.gms.internal.ce(this, this, this, this.b.i.b, this.b.i.g, this.b.e, this.b.i.v);
            com.google.android.gms.internal.as.a(this.b.c, var3);
         }
      }
   }

   public final void g() {
      com.google.android.gms.internal.cM.a("stopLoading must be called on the main UI thread.");
      if(this.b.i != null) {
         this.b.i.b.stopLoading();
         this.b.i = null;
      }

      if(this.b.g != null) {
         this.b.g.f();
      }

   }

   public final void h() {
      com.google.android.gms.internal.cM.a("recordManualImpression must be called on the main UI thread.");
      if(this.b.i == null) {
         com.google.android.gms.internal.bJ.e("Ad state was null when trying to ping manual tracking URLs.");
      } else {
         com.google.android.gms.internal.bJ.a("Pinging manual tracking URLs.");
         if(this.b.i.f != null) {
            com.google.android.gms.internal.bD.a(this.b.c, this.b.e.b, this.b.i.f);
            return;
         }
      }

   }

   public final com.google.android.gms.internal.ak i() {
      com.google.android.gms.internal.cM.a("getAdSize must be called on the main UI thread.");
      return this.b.h;
   }

   public final void j() {
      this.r();
   }

   public final void k() {
      this.o();
   }

   public final void l() {
      this.q();
   }

   public final void m() {
      this.p();
   }

   public final void n() {
      if(this.b.i != null) {
         com.google.android.gms.internal.bJ.e("Mediation adapter " + this.b.i.n + " refreshed, but mediation adapters should never refresh.");
      }

      this.a(true);
      this.s();
   }

   public final void o() {
      this.d.a(this.b.i);
      if(this.b.h.e) {
         this.t();
      }

      this.e = false;
      com.google.android.gms.internal.bJ.c("Ad closing.");
      if(this.b.f != null) {
         try {
            this.b.f.a();
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.b("Could not call AdListener.onAdClosed().", var2);
         }
      }

      this.b.j.c();
   }

   public final void p() {
      if(this.b.h.e) {
         this.a(false);
      }

      this.e = true;
      com.google.android.gms.internal.bJ.c("Ad opening.");
      if(this.b.f != null) {
         try {
            this.b.f.d();
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.b("Could not call AdListener.onAdOpened().", var2);
            return;
         }
      }

   }

   public final void q() {
      com.google.android.gms.internal.bJ.c("Ad leaving application.");
      if(this.b.f != null) {
         try {
            this.b.f.b();
         } catch (RemoteException var2) {
            com.google.android.gms.internal.bJ.b("Could not call AdListener.onAdLeftApplication().", var2);
            return;
         }
      }

   }

   public final void r() {
      if(this.b.i == null) {
         com.google.android.gms.internal.bJ.e("Ad state was null when trying to ping click URLs.");
      } else {
         com.google.android.gms.internal.bJ.a("Pinging click URLs.");
         this.b.j.b();
         if(this.b.i.c != null) {
            com.google.android.gms.internal.bD.a(this.b.c, this.b.e.b, this.b.i.c);
         }

         if(this.b.i.o != null && this.b.i.o.c != null) {
            com.google.android.gms.internal.W.a(this.b.c, this.b.e.b, this.b.i, this.b.b, false, this.b.i.o.c);
            return;
         }
      }

   }
}
