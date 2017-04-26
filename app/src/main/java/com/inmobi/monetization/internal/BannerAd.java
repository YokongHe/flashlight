package com.inmobi.monetization.internal;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Response;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.internal.Ad;
import com.inmobi.monetization.internal.Ad$AD_FORMAT;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.BannerAd$a;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView$IMWebViewListener;
import com.inmobi.re.container.IMWebView$ViewState;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class BannerAd extends Ad {
   protected static final String KEY_MANUAL_REFRESH = "u-rt";
   protected static final String KEY_TYPE_OF_ADREQ = "requestactivity";
   protected static final String VALUE_OF_ADREQ = "AdRequest";
   AnimationType b;
   private Activity c;
   private IMWebView d;
   private IMWebView e;
   private boolean f = true;
   private boolean g = false;
   private int h = 15;
   private long i = 0L;
   private boolean j;
   private int k;
   private com.inmobi.monetization.internal.d l;
   private Animation m;
   public IMWebView mCurrentWebView;
   private Animation n;
   private long o;
   private boolean p;
   private boolean q;
   private AtomicBoolean r;
   private Response s;
   private boolean t;
   private IMWebView$IMWebViewListener u;
   private BannerAd$a v;
   private AnimationListener w;

   public BannerAd(Activity var1, IMBanner var2, long var3, int var5) {
      super(var3);
      this.b = AnimationType.ROTATE_HORIZONTAL_AXIS;
      this.j = true;
      this.k = Initializer.getConfigParams().getDefaultRefreshRate();
      this.o = 0L;
      this.p = false;
      this.q = true;
      this.r = new AtomicBoolean(false);
      this.s = null;
      this.t = false;
      this.u = new IMWebView$IMWebViewListener() {
         public void onDismissAdScreen() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onDismissAdScreen();
            }

            BannerAd.this.r.set(false);
         }

         public void onDisplayFailed() {
         }

         public void onError() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            }

         }

         public void onExpand() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onShowAdScreen();
            }

         }

         public void onExpandClose() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onDismissAdScreen();
            }

         }

         public void onIncentCompleted(Map var1) {
         }

         public void onLeaveApplication() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onLeaveApplication();
            }

         }

         public void onResize(ResizeDimensions var1) {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onShowAdScreen();
            }

         }

         public void onResizeClose() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onDismissAdScreen();
            }

         }

         public void onShowAdScreen() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onShowAdScreen();
            }

            BannerAd.this.r.set(true);
         }

         public void onUserInteraction(Map var1) {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onAdInteraction(var1);
            }

         }
      };
      this.v = new BannerAd$a(this);
      this.w = new AnimationListener() {
         public void onAnimationEnd(Animation var1) {
            BannerAd.this.h();
         }

         public void onAnimationRepeat(Animation var1) {
         }

         public void onAnimationStart(Animation var1) {
         }
      };
      this.h = var5;
      this.o = var3;
      this.c = var1;
      this.t = this.initialize();
   }

   public BannerAd(Activity var1, IMBanner var2, String var3, int var4) {
      super(var3);
      this.b = AnimationType.ROTATE_HORIZONTAL_AXIS;
      this.j = true;
      this.k = Initializer.getConfigParams().getDefaultRefreshRate();
      this.o = 0L;
      this.p = false;
      this.q = true;
      this.r = new AtomicBoolean(false);
      this.s = null;
      this.t = false;
      this.u = new IMWebView$IMWebViewListener() {
         public void onDismissAdScreen() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onDismissAdScreen();
            }

            BannerAd.this.r.set(false);
         }

         public void onDisplayFailed() {
         }

         public void onError() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            }

         }

         public void onExpand() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onShowAdScreen();
            }

         }

         public void onExpandClose() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onDismissAdScreen();
            }

         }

         public void onIncentCompleted(Map var1) {
         }

         public void onLeaveApplication() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onLeaveApplication();
            }

         }

         public void onResize(ResizeDimensions var1) {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onShowAdScreen();
            }

         }

         public void onResizeClose() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onDismissAdScreen();
            }

         }

         public void onShowAdScreen() {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onShowAdScreen();
            }

            BannerAd.this.r.set(true);
         }

         public void onUserInteraction(Map var1) {
            if(BannerAd.this.mAdListener != null) {
               BannerAd.this.mAdListener.onAdInteraction(var1);
            }

         }
      };
      this.v = new BannerAd$a(this);
      this.w = new AnimationListener() {
         public void onAnimationEnd(Animation var1) {
            BannerAd.this.h();
         }

         public void onAnimationRepeat(Animation var1) {
         }

         public void onAnimationStart(Animation var1) {
         }
      };
      this.h = var4;
      this.c = var1;
      this.t = this.initialize();
   }

   // $FF: synthetic method
   static IMWebView a(BannerAd var0, IMWebView var1) {
      var0.d = var1;
      return var1;
   }

   // $FF: synthetic method
   static void a(BannerAd var0, boolean var1) {
      var0.a(var1);
   }

   private void a(boolean var1) {
      if(!this.t) {
         this.t = this.initialize();
      }

      if(!this.t) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         this.g = false;
         this.p = var1;
         if(!this.g()) {
            super.loadAd();
         } else if(this.mAdListener != null) {
            AdErrorCode var2 = AdErrorCode.INVALID_REQUEST;
            var2.setMessage("Ad click is in progress.Cannot load new ad");
            Log.debug("[InMobi]-[Monetization]", "Ad click is in progress.Cannot load new ad");
            this.mAdListener.onAdRequestFailed(var2);
         }

         this.v.removeMessages(101);
         if(this.k > 0) {
            this.v.sendEmptyMessageDelayed(101, (long)(this.k * 1000));
            return;
         }
      }

   }

   // $FF: synthetic method
   static IMWebView b(BannerAd var0, IMWebView var1) {
      var0.e = var1;
      return var1;
   }

   private void b(boolean var1) {
      this.f = var1;
      if(var1) {
         this.d.deinit();
         this.d = null;
      } else {
         this.e.deinit();
         this.e = null;
      }
   }

   // $FF: synthetic method
   static long c(BannerAd var0) {
      return var0.i;
   }

   private ViewGroup d() {
      ViewGroup var2 = (ViewGroup)this.d.getParent();
      ViewGroup var1 = var2;
      if(var2 == null) {
         var1 = (ViewGroup)this.e.getParent();
      }

      return var1;
   }

   // $FF: synthetic method
   static Response d(BannerAd var0) {
      return var0.s;
   }

   private boolean e() {
      return this.f;
   }

   // $FF: synthetic method
   static boolean e(BannerAd var0) {
      return var0.e();
   }

   // $FF: synthetic method
   static Activity f(BannerAd var0) {
      return var0.c;
   }

   private void f() {
      try {
         if(this.e != null) {
            this.e.setBackgroundColor(0);
         }

         if(this.d != null) {
            this.d.setBackgroundColor(0);
         }

      } catch (Exception var2) {
         Log.debug("[InMobi]-[Monetization]", "Error setNormalBGColor", var2);
      }
   }

   private boolean g() {
      IMWebView var1;
      if(this.e()) {
         var1 = this.e;
      } else {
         var1 = this.d;
      }

      String var2 = var1.getState();
      Log.debug("[InMobi]-[Monetization]", "Current Ad State: " + var2);
      if(!IMWebView$ViewState.EXPANDED.toString().equalsIgnoreCase(var2) && !IMWebView$ViewState.RESIZED.toString().equalsIgnoreCase(var2) && !IMWebView$ViewState.RESIZING.toString().equalsIgnoreCase(var2) && !IMWebView$ViewState.EXPANDING.toString().equalsIgnoreCase(var2)) {
         if(var1.isBusy()) {
            Log.debug("[InMobi]-[Monetization]", "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.");
            return true;
         } else {
            return this.r.get();
         }
      } else {
         Log.debug("[InMobi]-[Monetization]", "Current Ad State is neither default nor loading. New ad will not be shown.");
         return true;
      }
   }

   private void h() {
      // $FF: Couldn't be decompiled
   }

   private void i() {
      if(!this.g && this.s != null) {
         String var5 = this.s.getResponseBody();
         long var1 = System.currentTimeMillis();
         long var3 = this.mFetchStartTime;
         if(var5 != null) {
            var5 = var5.replace("@__imm_aft@", "" + (var1 - var3));
            if(VERSION.SDK_INT <= 8) {
               var5.replaceAll("%", "%25");
            }

            if(this.e()) {
               if(this.d == null) {
                  this.d = new IMWebView(this.c, this.u, false, false);
                  if(!this.q) {
                     this.d.disableHardwareAcceleration();
                  }
               }

               this.mCurrentWebView = this.d;
            } else {
               if(this.e == null) {
                  this.e = new IMWebView(this.c, this.u, false, false);
                  if(!this.q) {
                     this.e.disableHardwareAcceleration();
                  }
               }

               this.mCurrentWebView = this.e;
            }

            this.mCurrentWebView.addJavascriptInterface(new IMAIController(this.mCurrentWebView), "imaiController");
            this.i = System.currentTimeMillis();
            this.v.sendEmptyMessageDelayed(102, (long)Initializer.getConfigParams().getRenderTimeOut());
            this.mCurrentWebView.resetMraid();
            this.mCurrentWebView.loadDataWithBaseURL("", var5, "text/html", (String)null, (String)null);
            var1 = System.currentTimeMillis();
            var3 = this.mFetchStartTime;
            this.collectMetrics(this.s, var1 - var3, NetworkEventType.RENDER_COMPLETE);
            if(!this.j) {
               if(this.b == AnimationType.ANIMATION_OFF) {
                  this.h();
                  return;
               }

               this.l.a(this.b);
               return;
            }

            this.h();
            this.j = false;
         } else {
            Log.debug("[InMobi]-[Monetization]", "Cannot load Ad. Invalid Ad Response");
            if(this.mAdListener != null) {
               this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
               return;
            }
         }
      }

   }

   Animation a() {
      return this.m;
   }

   void a(Animation var1) {
      this.m = var1;
   }

   int b() {
      // $FF: Couldn't be decompiled
   }

   void b(Animation var1) {
      this.n = var1;
   }

   int c() {
      // $FF: Couldn't be decompiled
   }

   void c(Animation param1) {
      // $FF: Couldn't be decompiled
   }

   public void disableHardwareAcceleration() {
      if(!this.t) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         this.q = false;
         if(this.mCurrentWebView != null) {
            this.mCurrentWebView.disableHardwareAcceleration();
            return;
         }
      }

   }

   protected Map getAdFormatParams() {
      HashMap var1 = new HashMap();
      var1.put("format", Ad$AD_FORMAT.IMAI.toString().toLowerCase(Locale.getDefault()));
      var1.put("mk-ads", "1");
      var1.put("requestactivity", "AdRequest");
      if(this.p) {
         var1.put("u-rt", String.valueOf(1));
      } else {
         var1.put("u-rt", String.valueOf(0));
      }

      if(this.o > 0L) {
         var1.put("placement-size", this.b() + "x" + this.c());
      }

      var1.put("mk-ad-slot", String.valueOf(this.h));
      return var1;
   }

   public View getView() {
      return this.mCurrentWebView;
   }

   public void handleResponse(com.inmobi.monetization.internal.c var1, Response var2) {
      if(var2 != null) {
         try {
            if(this.c != null) {
               this.s = var2;
               this.c.runOnUiThread(new Runnable() {
                  public void run() {
                     BannerAd.this.i();
                  }
               });
            }
         } catch (Exception var3) {
            Log.debug("[InMobi]-[Monetization]", "Failed to render banner ad");
            if(this.mAdListener != null) {
               this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
               return;
            }
         }
      }

   }

   protected boolean initialize() {
      if(this.h < 0) {
         Log.debug("[InMobi]-[Monetization]", "Invalid Ad Size. Please provide a valid Ad Size. If Ad Size is declared in the layout XML, please provide a valid \'adSize\' attribute in the \'com.inmobi.monetization.IMBanner\' tag of layout XML. For example, adSize=\"yourAdSize\"");
         return false;
      } else if(this.c == null) {
         Log.debug("[InMobi]-[Monetization]", "Activity cannot be null");
         return false;
      } else {
         this.c = com.inmobi.monetization.internal.b.a(this.c);
         if(this.d == null) {
            this.d = new IMWebView(this.c, this.u, false, false);
            if(!this.q) {
               this.d.disableHardwareAcceleration();
            }

            this.d.addJavascriptInterface(new IMAIController(this.d), "imaiController");
         }

         if(this.e == null) {
            this.e = new IMWebView(this.c, this.u, false, false);
            this.mCurrentWebView = this.e;
            if(!this.q) {
               this.e.disableHardwareAcceleration();
            }

            this.e.addJavascriptInterface(new IMAIController(this.e), "imaiController");
         }

         this.l = new com.inmobi.monetization.internal.d(this, this.w);
         return super.initialize();
      }
   }

   public void loadAd() {
      this.a(false);
   }

   public void refreshAd() {
      this.p = true;
      this.v.removeMessages(101);
      if(this.k > 0) {
         this.v.sendEmptyMessageDelayed(101, (long)(this.k * 1000));
      }

   }

   public void setAdSize(int var1) {
      this.h = var1;
   }

   public void setAnimation(AnimationType var1) {
      this.b = var1;
   }

   public void setRefreshInterval(int var1) {
      if(!this.t) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         int var2 = Initializer.getConfigParams().getMinimumRefreshRate();
         this.v.removeMessages(101);
         if(var1 <= 0) {
            this.k = 0;
            return;
         }

         if(var1 < var2) {
            Log.debug("[InMobi]-[Monetization]", "Refresh Interval cannot be less than " + var2 + " seconds. Setting refresh rate to " + var2);
            this.k = var2;
         } else {
            this.k = var1;
         }

         if(this.k != 0) {
            this.v.sendEmptyMessageDelayed(101, (long)(this.k * 1000));
            return;
         }
      }

   }

   public void stopLoading() {
      if(!this.t) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         super.stopLoading();
         if(this.v != null && this.v.hasMessages(102)) {
            this.v.removeMessages(102);
         }

         this.g = true;
      }
   }

   public void stopRefresh() {
      if(!this.t) {
         Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
      } else {
         this.v.removeMessages(101);
      }
   }
}
