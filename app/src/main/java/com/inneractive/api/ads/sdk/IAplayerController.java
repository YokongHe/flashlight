package com.inneractive.api.ads.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import com.inneractive.api.ads.sdk.IAplayer;
import com.inneractive.api.ads.sdk.IAplayer$IAplayerPosition;
import com.inneractive.api.ads.sdk.IAplayer$a;
import com.inneractive.api.ads.sdk.IAplayerController$IAvideoAdStatus;
import com.inneractive.api.ads.sdk.IAplayerController$a;
import com.inneractive.api.ads.sdk.IAplayerState;
import com.inneractive.api.ads.sdk.IAvastMediaFile;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.StoryEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

final class IAplayerController implements IAplayer$a {
   private Context a = null;
   private com.inneractive.api.ads.sdk.a b;
   private ArrayList c = new ArrayList();
   private ArrayList d = new ArrayList();
   private com.inneractive.api.ads.sdk.ai e;
   private com.inneractive.api.ads.sdk.ai f;
   private int g;
   private int h;
   private IAplayer i;
   private IAplayerController$IAvideoAdStatus j;
   private Timer k;
   private boolean l;
   private boolean m = false;

   IAplayerController(Context var1, com.inneractive.api.ads.sdk.a var2) {
      this.b = var2;
      this.a = var1.getApplicationContext();
      DisplayMetrics var4 = var1.getResources().getDisplayMetrics();
      this.g = var4.widthPixels;
      this.h = var4.heightPixels;
      int var3 = this.g;
      var3 = this.h;
      com.inneractive.api.ads.sdk.a var5 = this.b;
      com.inneractive.api.ads.sdk.a.i();
      InneractiveAdView$Log.a("Library initializing started");
   }

   private void a(IAplayerController$IAvideoAdStatus var1) {
      if(this.j != var1) {
         this.j = var1;
      }
   }

   private void a(InneractiveAdView$InneractiveErrorCode param1, IAplayerController$IAvideoAdStatus param2) {
      // $FF: Couldn't be decompiled
   }

   private void a(StoryEvent param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(com.inneractive.api.ads.sdk.ap var1, int... var2) {
      if(var2.length == 0) {
         InneractiveAdView$Log.e("trackEvents: eventTypes array is empty");
      } else if(var1 == null) {
         InneractiveAdView$Log.e("trackEvents: parser is null");
      } else {
         ArrayList var6 = new ArrayList();
         int var4 = var2.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            int var5 = var2[var3];
            String var7 = com.inneractive.api.ads.sdk.aq.a(var5);
            InneractiveAdView$Log.a("Firing events for type: " + var7);
            if(var5 == 1) {
               this.a(StoryEvent.b);
            } else if(var5 == 14) {
               this.a(StoryEvent.c);
            }

            List var8 = var1.a(var5);
            if(var8.size() == 0) {
               InneractiveAdView$Log.a("no events for type: " + var7);
            } else {
               var6.addAll(var8);
               InneractiveAdView$Log.a("found " + var8.size() + " events for type: " + var7);
               Iterator var9 = var8.iterator();

               while(var9.hasNext()) {
                  String var10 = (String)var9.next();
                  InneractiveAdView$Log.a("   event url: " + var10);
               }
            }
         }

         (new com.inneractive.api.ads.sdk.al()).a((List)var6);
      }
   }

   private boolean a(String var1) {
      Uri var2;
      try {
         var2 = Uri.parse(var1);
      } catch (Exception var7) {
         InneractiveAdView$Log.a("MediaPlayerController: openUrl: Invalid url " + var1);
         return false;
      }

      PackageManager var3 = this.a.getPackageManager();
      Intent var8 = new Intent("android.intent.action.VIEW", var2);
      List var9 = var3.queryIntentActivities(var8, 32);
      if(var9 != null && !var9.isEmpty()) {
         Iterator var10 = var9.iterator();

         while(var10.hasNext()) {
            ResolveInfo var4 = (ResolveInfo)var10.next();
            if(var4.activityInfo.packageName.equalsIgnoreCase("com.android.vending")) {
               try {
                  var8.setClassName(var4.activityInfo.packageName, var4.activityInfo.name);
                  var8.setFlags(268435456);
                  this.a.startActivity(var8);
                  InneractiveAdView$Log.a("MediaPlayerController: onResume - opening click url");
                  return true;
               } catch (ActivityNotFoundException var5) {
                  var5.printStackTrace();
               } catch (Exception var6) {
                  var6.printStackTrace();
               }
            }
         }
      }

      return com.inneractive.api.ads.sdk.an.a(this.a, var1, this.b.K());
   }

   private void f() {
      if(this.k != null) {
         this.k.cancel();
         this.k = null;
      }

   }

   private void g() {
      this.a((com.inneractive.api.ads.sdk.ap)this.e, (int[])(new int[]{15}));
      if(this.e.c() > 0) {
         this.e.c(0);
         this.h();
      }

   }

   private void h() {
      InneractiveAdView$Log.a("IAplayerController: playNextMediaFile");
      if(this.e.c() == 0) {
         InneractiveAdView$Log.a("IAplayerController: No next compitable media file. Sending error and re-fetching");
         this.a(InneractiveAdView$InneractiveErrorCode.SDK_INTERNAL_ERROR, IAplayerController$IAvideoAdStatus.e);
         this.a((com.inneractive.api.ads.sdk.ap)this.e, (int[])(new int[]{15}));
      } else {
         IAvastMediaFile var1 = this.e.b(0);
         String var2 = var1.b();
         InneractiveAdView$Log.a("IAplayerController: Start playing video for url: " + var2);
         if(this.i == null) {
            InneractiveAdView$Log.a("IAplayerController: creating media player");
            this.i = new IAplayer(this.a, this.b.I());
            this.i.a((IAplayer$a)this);
         }

         this.i.a(var2, this.b.M());
         if(this.i.c() != null) {
            InneractiveAdView$Log.a("IAplayerController: error initializing video. trying next media file");
            this.e.c(0);
            this.h();
         }

         InneractiveAdView$Log.a("IAplayerController: trying to play media file - type = " + var1.f() + " bitrate = " + var1.a());
      }
   }

   final IAplayer a() {
      return this.i;
   }

   public final void a(IAplayer$IAplayerPosition var1) {
      if(var1 == IAplayer$IAplayerPosition.b) {
         this.m = false;
         this.a(new int[]{1, 2, 13});
      } else {
         if(var1 == IAplayer$IAplayerPosition.d) {
            this.a(new int[]{3});
            return;
         }

         if(var1 == IAplayer$IAplayerPosition.e) {
            this.a(new int[]{4});
            return;
         }

         if(var1 == IAplayer$IAplayerPosition.f) {
            this.a(new int[]{5});
            return;
         }

         if(var1 == IAplayer$IAplayerPosition.g && !this.m) {
            this.m = true;
            this.a(new int[]{6});
            return;
         }

         if(var1 == IAplayer$IAplayerPosition.c) {
            this.a(new int[]{16});
            return;
         }
      }

   }

   public final void a(IAplayerController$a var1) {
      if(this.c != null) {
         this.c.add(var1);
      }

   }

   public final void a(IAplayerState var1) {
      if(!this.l) {
         if(var1 == IAplayerState.f) {
            this.a(IAplayerController$IAvideoAdStatus.c);
            return;
         }

         if(var1 == IAplayerState.g) {
            this.f = this.e;
            InneractiveAdView$Log.a("IAplayerController: onPlayerPrepared called");
            this.a(IAplayerController$IAvideoAdStatus.f);
            this.a(StoryEvent.a);
            this.f();
            return;
         }

         if(var1 == IAplayerState.h) {
            this.a(IAplayerController$IAvideoAdStatus.g);
            return;
         }

         if(var1 == IAplayerState.b) {
            this.a(IAplayerController$IAvideoAdStatus.d);
            this.g();
            return;
         }

         if(var1 == IAplayerState.i) {
            this.a(IAplayerController$IAvideoAdStatus.h);
            return;
         }

         if(var1 == IAplayerState.j) {
            this.a(IAplayerController$IAvideoAdStatus.i);
            return;
         }
      }

   }

   final void a(int... var1) {
      this.a((com.inneractive.api.ads.sdk.ap)this.f, (int[])var1);
   }

   public final boolean a(com.inneractive.api.ads.sdk.ai var1) {
      if(var1 != null) {
         InneractiveAdView$Log.a("IAplayerController: Got Vast Response");
         this.a(IAplayerController$IAvideoAdStatus.a);
         if(var1.c() == 0) {
            this.a((com.inneractive.api.ads.sdk.ap)var1, (int[])(new int[]{15}));
            InneractiveAdView$Log.c("No media files found");
            this.a(InneractiveAdView$InneractiveErrorCode.SERVER_INVALID_RESPONSE, IAplayerController$IAvideoAdStatus.j);
            return false;
         }

         this.e = var1;
         InneractiveAdView$Log.a("IAplayerController: Found " + this.e.c() + " media files");
         this.f();
         int var2;
         if(com.inneractive.api.ads.sdk.a.o(this.a)) {
            var2 = this.b.G();
         } else {
            var2 = this.b.H();
         }

         this.k = new Timer();
         this.k.schedule(new TimerTask() {
            // $FF: synthetic field
            private IAplayerController a = IAplayerController.this;

            public final void run() {
               this.a.e();
            }
         }, (long)(var2 * 1000));
         this.h();
      }

      return true;
   }

   final void b() {
      if(this.i.b() != IAplayerState.j) {
         this.i.pause();
      }

      this.i.setDisplay((SurfaceHolder)null);
   }

   final void c() {
      if(this.i.b() != IAplayerState.j) {
         this.i.pause();
      }

      this.a(new int[]{14});
      if(this.f != null) {
         String var1 = this.f.e();
         if(!TextUtils.isEmpty(var1)) {
            InneractiveAdView$Log.a("MediaPlayerController: opening click through URL");
            this.a(var1);
         }
      }

   }

   final void d() {
      InneractiveAdView$Log.a("StoryImpl: destroy started");
      this.l = true;
      if(this.i != null) {
         this.i.reset();
         this.i.release();
         this.i = null;
      }

      this.f();
      this.e = null;
      this.f = null;
      if(this.d != null) {
         this.d.clear();
      }

      this.d = null;
      if(this.c != null) {
         this.c.clear();
      }

      this.c = null;
      InneractiveAdView$Log.a("IAplayerController: destroy finished");
   }

   protected final void e() {
      this.a(IAplayerController$IAvideoAdStatus.b);
      this.g();
   }
}
