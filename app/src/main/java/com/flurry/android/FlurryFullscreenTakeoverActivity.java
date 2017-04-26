package com.flurry.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.FrameLayout.LayoutParams;
import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryFullscreenTakeoverActivity$a;
import com.flurry.android.FlurryFullscreenTakeoverActivity$b;
import com.flurry.android.FlurryFullscreenTakeoverActivity$c;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;
import com.flurry.sdk.n$e;
import java.util.Collections;

public final class FlurryFullscreenTakeoverActivity extends Activity {
   public static final String EXTRA_KEY_ADSPACENAME = "adSpaceName";
   public static final String EXTRA_KEY_FRAMEINDEX = "frameIndex";
   public static final String EXTRA_KEY_IS_MRAID_AD = "is_mraid_ad";
   public static final String EXTRA_KEY_SHOULD_CLOSE_AD = "should_close_ad";
   public static final String EXTRA_KEY_TARGETINTENT = "targetIntent";
   public static final String EXTRA_KEY_URL = "url";
   private static final String a = FlurryFullscreenTakeoverActivity.class.getSimpleName();
   public static boolean fBasicWebViewClosingHandlerFired;
   private String b;
   private com.flurry.sdk.g c;
   private AdUnit d;
   private ViewGroup e;
   private com.flurry.sdk.n f;
   private com.flurry.sdk.f g;
   private boolean h;
   private boolean i;
   private Intent j;
   private String k;
   private long l;
   private boolean m = false;
   private boolean n;
   private com.flurry.sdk.z o = null;
   private n$e p;

   public FlurryFullscreenTakeoverActivity() {
      this.p = n$e.a;
   }

   // $FF: synthetic method
   static n$e a(FlurryFullscreenTakeoverActivity var0, n$e var1) {
      var0.p = var1;
      return var1;
   }

   // $FF: synthetic method
   static String a(FlurryFullscreenTakeoverActivity var0) {
      return var0.k;
   }

   private void a() {
      long var1;
      boolean var3;
      if(this.d != null) {
         var1 = this.d.m().longValue();
         var3 = this.d.q().booleanValue();
      } else {
         var3 = false;
         var1 = 0L;
      }

      if(this.m) {
         this.o = new com.flurry.sdk.z(this, 0L, true, false, false);
      } else {
         this.o = new com.flurry.sdk.z(this, var1, var3, true, false);
      }
   }

   private void a(int var1) {
      FlurryAdModule var6 = FlurryAdModule.getInstance();
      AdUnit var4 = var6.Q();
      com.flurry.sdk.e var5 = var6.P();
      com.flurry.sdk.e var3 = var5;
      AdUnit var2 = var4;
      if(var4 == null) {
         var3 = var5;
         var2 = var4;
         if(this.m) {
            var2 = var6.S();
            var3 = var6.R();
         }
      }

      this.d = var2;
      this.c = new com.flurry.sdk.g(this, var6, var3, var2, var1);
   }

   // $FF: synthetic method
   static void a(FlurryFullscreenTakeoverActivity var0, String var1, int var2) {
      var0.a(var1, var2);
   }

   private void a(String var1, int var2) {
      if(!TextUtils.isEmpty(var1) && this.g != null && this.e != null) {
         if(this.o == null) {
            this.a();
         }

         FlurryAdModule var3 = FlurryAdModule.getInstance();
         this.a(var2);
         var2 = 0;
         if(this.d != null) {
            this.o.setAdUnityView(this.c);
            com.flurry.sdk.am var4 = var3.c(((AdFrame)this.d.d().get(this.c.getAdFrameIndex())).g().toString());
            this.o.setVideoState(var4);
            var2 = var4.a();
         }

         this.setVideoOrientation();
         this.g.setMediaController(this.o);
         this.g.a();
         this.g.a(Uri.parse(var1), var2);
         this.e.addView(this.g, new LayoutParams(-1, -1, 17));
         if(this.f != null) {
            this.f.setVisibility(8);
            return;
         }
      }

   }

   private void a(boolean var1) {
      this.a();
      if(var1) {
         this.g = new com.flurry.sdk.f(this, this.c, this, this.o);
      } else {
         this.g = new com.flurry.sdk.f(this, (com.flurry.sdk.g)null, this, this.o);
      }
   }

   // $FF: synthetic method
   static boolean a(FlurryFullscreenTakeoverActivity var0, String var1) {
      return var0.a(var1);
   }

   // $FF: synthetic method
   static boolean a(FlurryFullscreenTakeoverActivity var0, String var1, String var2) {
      return var0.a(var1, var2);
   }

   // $FF: synthetic method
   static boolean a(FlurryFullscreenTakeoverActivity var0, boolean var1) {
      var0.h = var1;
      return var1;
   }

   private boolean a(String var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(!TextUtils.isEmpty(var1)) {
         var1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(var1));
         var2 = var3;
         if(var1 != null) {
            var2 = var3;
            if(var1.startsWith("video/")) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   private boolean a(String var1, String var2) {
      if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var2)) {
         var2 = Uri.parse(var2).getQueryParameter("link");
         if(!TextUtils.isEmpty(var2) && var2.equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }

   // $FF: synthetic method
   static n$e b(FlurryFullscreenTakeoverActivity var0) {
      return var0.p;
   }

   // $FF: synthetic method
   static void b(FlurryFullscreenTakeoverActivity var0, boolean var1) {
      var0.a(var1);
   }

   private boolean b() {
      return !com.flurry.sdk.cb.a((Context)this) && this.c != null && this.c.getVideoView() != null && (this.c.getCurrentBinding() == 3 || this.c.getCurrentBinding() == 2);
   }

   public final void finish() {
      synchronized(this) {
         if(this.n) {
            return;
         }

         this.n = true;
      }

      super.finish();
   }

   public final AdUnit getAdUnit() {
      return this.d;
   }

   public final com.flurry.sdk.g getAdUnityView() {
      return this.c;
   }

   public final n$e getResult() {
      return this.p;
   }

   public final boolean isMraidVideoActivity() {
      return this.m;
   }

   public final void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.setVideoOrientation();
   }

   public final void onCreate(Bundle var1) {
      int var3 = -1;
      eo.a(3, a, "onCreate");
      this.setTheme(16973831);
      super.onCreate(var1);
      com.flurry.sdk.ch.a(this.getWindow());
      this.setVolumeControlStream(3);
      this.b = FlurryAdModule.getInstance().j();
      Intent var5 = this.getIntent();
      this.j = (Intent)var5.getParcelableExtra("targetIntent");
      this.k = var5.getStringExtra("adSpaceName");
      this.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
      float var2 = this.getResources().getDisplayMetrics().density;
      fBasicWebViewClosingHandlerFired = false;
      if(var1 != null) {
         var3 = var1.getInt("frameIndex", -1);
      }

      int var4 = var3;
      if(var3 < 0) {
         var4 = var5.getIntExtra("frameIndex", 0);
      }

      this.m = var5.getBooleanExtra("is_mraid_ad", false);
      if(this.j != null) {
         try {
            this.startActivity(this.j);
            this.l = SystemClock.elapsedRealtime();
         } catch (ActivityNotFoundException var7) {
            eo.a(a, "Cannot launch Activity", var7);
            this.j = null;
            this.finish();
         }
      } else {
         String var6 = var5.getStringExtra("url");
         if(var6 == null) {
            this.e = new RelativeLayout(this);
            FlurryAdModule var8 = FlurryAdModule.getInstance();
            this.d = var8.Q();
            if(this.d != null) {
               this.c = new com.flurry.sdk.g(this, var8, var8.P(), this.d, var4);
               this.c.setFullScreenTakeover(this);
               this.c.initLayout();
               android.widget.RelativeLayout.LayoutParams var9 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
               var9.addRule(13);
               this.e.addView(this.c, var9);
               this.setContentView(this.e);
            } else {
               eo.a(3, a, "appSpotModule.getTakeoverAdUnit() IS null ");
            }
         } else {
            this.e = new FrameLayout(this);
            this.setContentView(this.e);
            if(this.a(var6)) {
               this.a(var4);
               if(this.d != null) {
                  this.a(true);
                  this.a(var6, var4);
               }
            } else {
               this.f = new com.flurry.sdk.n(this, var6, var5.getBooleanExtra("should_close_ad", false));
               this.f.setBasicWebViewUrlLoadingHandler(new FlurryFullscreenTakeoverActivity$c(this, var4));
               this.f.setBasicWebViewClosingHandler(new FlurryFullscreenTakeoverActivity$a(this, null));
               this.f.setBasicWebViewFullScreenTransitionHandler(new FlurryFullscreenTakeoverActivity$b(this, null));
               this.e.addView(this.f);
               this.f.a((Context)this);
            }
         }
      }

      FlurryAdModule.getInstance().a((Activity)this, (Bundle)var1);
   }

   protected final void onDestroy() {
      eo.a(3, a, "onDestroy");
      this.terminateVideoPlayback();
      if(this.f != null) {
         this.f.d();
      }

      if(this.c != null) {
         this.c.onDestroy();
      }

      FlurryAdModule.getInstance().b((Activity)this);
      super.onDestroy();
   }

   public final boolean onKeyUp(int var1, KeyEvent var2) {
      if(var1 == 4) {
         if(this.c != null) {
            this.c.a("adWillClose", Collections.emptyMap(), this.c.getAdUnit(), this.c.getAdLog(), this.c.getAdFrameIndex(), 0);
            return true;
         }

         if(this.g != null) {
            if(this.f != null) {
               if(!this.h) {
                  this.terminateVideoPlayback();
                  return true;
               }

               if(this.f.a()) {
                  this.f.c();
                  this.terminateVideoPlayback();
                  return true;
               }
            }
         } else if(this.f != null) {
            if(this.f.a()) {
               this.f.c();
            } else if(this.f.b()) {
               this.p = n$e.c;
               this.finish();
            } else {
               this.p = n$e.b;
               this.finish();
            }

            return true;
         }
      }

      return super.onKeyUp(var1, var2);
   }

   protected final void onPause() {
      eo.a(3, a, "onPause");
      this.i = false;
      if(this.g != null && this.g.isPlaying()) {
         this.g.pause();
         eo.a(3, a, "in onPause in FFTA, should call suspend in AdUnityVideoView");
         this.g.d();
      }

      if(this.c != null) {
         this.c.c();
      }

      super.onPause();
   }

   protected final void onRestart() {
      eo.a(3, a, "onRestart");
      super.onRestart();
   }

   protected final void onResume() {
      eo.a(3, a, "onResume");
      super.onResume();
      this.i = true;
      if(this.c != null) {
         this.c.b();
      }

   }

   public final void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if(this.c != null) {
         var1.putInt("frameIndex", this.c.getAdFrameIndex());
      }

   }

   public final void onStart() {
      eo.a(3, a, "onStart");
      super.onStart();
      if(this.b != null) {
         FlurryAgent.onStartSession(this, this.b);
      } else {
         this.finish();
      }
   }

   public final void onStop() {
      eo.a(3, a, "onStop");
      if(this.b != null) {
         FlurryAgent.onEndSession(this);
      }

      super.onStop();
   }

   public final void onWindowFocusChanged(boolean var1) {
      eo.a(3, a, "onWindowFocusChanged hasFocus = " + var1);
      if(this.i && var1 && this.j != null && SystemClock.elapsedRealtime() - this.l > 250L) {
         eo.a(3, a, "terminate this launcher activity because launched activity was terminated or wasn\'t launched");
         this.finish();
      }

      super.onWindowFocusChanged(var1);
   }

   public final void setVideoMoreInfoInProgress(com.flurry.sdk.am var1) {
      if(this.c != null && var1 != null) {
         this.c.setVideoState(var1);
      }

   }

   public final void setVideoOrientation() {
      if(com.flurry.sdk.cb.a((Context)this)) {
         eo.b(a, "setVideoOrientation SCREEN_ORIENTATION_SENSOR");
         this.setRequestedOrientation(4);
      } else if(this.b()) {
         eo.b(a, "setVideoOrientation SCREEN_ORIENTATION_SENSOR_LANDSCAPE");
         this.setRequestedOrientation(6);
         return;
      }

   }

   public final void terminateVideoPlayback() {
      if(this.f != null) {
         this.f.setVisibility(0);
      }

      if(this.g != null) {
         this.g.c();
         if(this.e != null) {
            this.e.removeView(this.g);
         }

         this.g = null;
      }

      this.h = false;
   }

   public final void terminateVideoPlaybackDueToError() {
      eo.a(3, a, "onError");
      eo.b(a, "Error occurs during video playback");
      if(this.f != null) {
         if(this.h) {
            if(this.f.a()) {
               this.f.c();
               this.terminateVideoPlayback();
            } else {
               this.finish();
            }
         } else {
            this.terminateVideoPlayback();
         }
      } else {
         this.finish();
      }
   }
}
