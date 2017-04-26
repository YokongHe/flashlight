package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.AsyncTask;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.inneractive.api.ads.sdk.IAdefines$ApiLevel;
import com.inneractive.api.ads.sdk.IAplayer$IAplayerPosition;
import com.inneractive.api.ads.sdk.IAplayer$a;
import com.inneractive.api.ads.sdk.IAplayer$b;
import com.inneractive.api.ads.sdk.IAplayerState;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.v$a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class IAplayer extends MediaPlayer implements OnCompletionListener, OnErrorListener, OnPreparedListener, OnSeekCompleteListener, OnVideoSizeChangedListener, Runnable {
   boolean a;
   private Context b;
   private ScheduledThreadPoolExecutor c;
   private List d;
   private List e;
   private IAplayer$IAplayerPosition f;
   private IAplayerState g;
   private Exception h;
   private boolean i;
   private boolean j;
   private boolean k;
   private Object l;
   private com.inneractive.api.ads.sdk.v m;
   private Object n;
   private String o;
   private int p;

   IAplayer(Context var1, float var2) {
      this.f = IAplayer$IAplayerPosition.a;
      this.g = IAplayerState.c;
      this.h = null;
      this.j = false;
      this.k = false;
      this.a = true;
      this.p = 0;
      this.e = new ArrayList();
      this.d = new ArrayList();
      this.b = var1;
      this.setOnPreparedListener(this);
      this.setOnErrorListener(this);
      super.setOnCompletionListener(this);
      this.setOnSeekCompleteListener(this);
      this.setOnVideoSizeChangedListener(this);
   }

   // $FF: synthetic method
   static com.inneractive.api.ads.sdk.v a(IAplayer var0, com.inneractive.api.ads.sdk.v var1) {
      var0.m = null;
      return null;
   }

   private void a(IAplayer$IAplayerPosition var1) {
      InneractiveAdView$Log.a("mp: updatePlayerPosition - " + var1);
      if(this.f != var1) {
         InneractiveAdView$Log.a("mp: updatePlayerPosition - changing from " + this.f);
         this.f = var1;
         Iterator var2 = this.d.iterator();

         while(var2.hasNext()) {
            ((IAplayer$a)var2.next()).a(var1);
         }
      }

   }

   private void a(IAplayerState var1) {
      InneractiveAdView$Log.a("mp: updatePlayerState - " + var1);
      if(this.g != var1) {
         InneractiveAdView$Log.a("mp: updatePlayerState - changing from " + this.g);
         this.g = var1;
         Iterator var2 = this.d.iterator();

         while(var2.hasNext()) {
            ((IAplayer$a)var2.next()).a(var1);
         }
      }

   }

   private boolean e() {
      // $FF: Couldn't be decompiled
   }

   private void f() {
      if(this.j && this.k) {
         this.a(IAplayerState.g);
      }

   }

   private void g() {
      if(this.c != null) {
         this.c.shutdown();
      }

   }

   final void a() {
      InneractiveAdView$Log.a("mp: unmute");
      if(this.d()) {
         AudioManager var5 = (AudioManager)this.b.getSystemService("audio");
         int var3 = var5.getStreamVolume(3);
         int var4 = var5.getStreamMaxVolume(3);
         float var2 = (float)var3 / (float)var4;
         InneractiveAdView$Log.a("mp: unmute maxVolume = " + var4 + " currentVolume = " + var3 + " targetVolume = " + var2);
         float var1 = var2;
         if(var2 == 0.0F) {
            var1 = 0.1F;
         }

         this.setVolume(var1, var1);
         this.a = false;
      }

   }

   public final void a(int var1, boolean var2) {
      if(this.d()) {
         this.i = true;
         super.seekTo(var1);
      } else {
         InneractiveAdView$Log.a("mp: seek to called when player is not ready!");
      }

      InneractiveAdView$Log.a("mp: seek to called with = " + var1);
   }

   final void a(IAplayer$a var1) {
      if(!this.d.contains(var1)) {
         this.d.add(var1);
      }

   }

   final void a(IAplayer$b var1) {
      if(!this.e.contains(var1)) {
         this.e.add(var1);
      }

   }

   protected final void a(String var1) {
      InneractiveAdView$Log.a("mp: " + var1 + " cached succesfully");
      this.e();
   }

   final void a(String var1, boolean var2) {
      InneractiveAdView$Log.a("mp: loadUri called for " + var1 + " useCache = " + var2);
      if(IAdefines$ApiLevel.a().a(IAdefines$ApiLevel.c)) {
         var2 = false;
      }

      this.j = false;
      this.k = false;
      this.f = IAplayer$IAplayerPosition.a;
      this.o = var1;
      if(this.isPlaying()) {
         InneractiveAdView$Log.a("mp: loadUri stopping play before refresh");
         this.stop();
      }

      if(var2) {
         com.inneractive.api.ads.sdk.a.a(this.b);
         this.a(IAplayerState.e);
         if(com.inneractive.api.ads.sdk.a.j(var1)) {
            this.a(var1);
         } else {
            InneractiveAdView$Log.a("mp: cacheRemoteMediaToFile called");
            if(this.m != null) {
               InneractiveAdView$Log.a("mp: videoDownloader is not null! Already caching another video. reset wasn\'t called?");
            } else {
               this.m = new com.inneractive.api.ads.sdk.v(new v$a() {
                  // $FF: synthetic field
                  private IAplayer a = IAplayer.this;

                  public final void a(boolean var1, String var2) {
                     if(var1) {
                        if(this.a.g != IAplayerState.e) {
                           InneractiveAdView$Log.a("mp: onCacheComplete. State is not caching, do nothing");
                           return;
                        }

                        this.a.a(var2);
                     } else {
                        this.a.b(var2);
                     }

                     IAplayer.a(this.a, (com.inneractive.api.ads.sdk.v)null);
                  }
               }, this.o);

               try {
                  com.inneractive.api.ads.sdk.a.a((AsyncTask)this.m, (Object[])(new Void[0]));
               } catch (Exception var4) {
                  ;
               }
            }
         }
      } else {
         this.reset();
         InneractiveAdView$Log.c("mp: calling setDataSource with " + var1);

         try {
            this.setDataSource(var1);
         } catch (Exception var5) {
            InneractiveAdView$Log.c("mp: error setting data source " + var1);
            InneractiveAdView$Log.c("mp: exception message: " + var5.getMessage());
            this.h = var5;
            return;
         }

         InneractiveAdView$Log.c("mp: setDataSource succeeded, calling prepareAsync");
         this.a(IAplayerState.f);

         try {
            this.prepareAsync();
         } catch (IllegalStateException var6) {
            InneractiveAdView$Log.c("mp: prepareAsync failed with illegal state exception: " + var6.getMessage());
            ++this.p;
            if(this.p < 5) {
               this.a(var1, false);
            }

            if(this.p == 5) {
               this.h = var6;
            }

            this.p = 0;
         }
      }
   }

   final IAplayerState b() {
      return this.g;
   }

   protected final void b(String var1) {
      InneractiveAdView$Log.a("mp: " + var1 + " cache failed");
      this.a(var1, false);
   }

   final Exception c() {
      return this.h;
   }

   final boolean d() {
      return this.g != IAplayerState.a && this.g != IAplayerState.b && this.g != IAplayerState.c && this.g != IAplayerState.f && this.g != IAplayerState.e && this.g != IAplayerState.d;
   }

   public final int getCurrentPosition() {
      InneractiveAdView$Log.a("mp: getCurrentPosition");
      return this.d()?super.getCurrentPosition():0;
   }

   public final int getDuration() {
      InneractiveAdView$Log.a("mp: getDuration");
      return this.d()?super.getDuration():0;
   }

   public final int getVideoHeight() {
      return this.d()?super.getVideoHeight():0;
   }

   public final int getVideoWidth() {
      return this.d()?super.getVideoWidth():0;
   }

   public final boolean isPlaying() {
      return this.d() && super.isPlaying();
   }

   public final void onCompletion(MediaPlayer var1) {
      this.g();
      this.a(IAplayerState.j);
      this.a(IAplayer$IAplayerPosition.g);
   }

   public final boolean onError(MediaPlayer var1, int var2, int var3) {
      InneractiveAdView$Log.e("mp: onError code = " + var2 + " code2 = " + var3);
      this.reset();
      this.a(IAplayerState.b);
      return true;
   }

   public final void onPrepared(MediaPlayer var1) {
      InneractiveAdView$Log.a("mp: onPrepared");
      if(this.g == IAplayerState.b) {
         InneractiveAdView$Log.e("mp: previous error encountered. Aborting");
      } else {
         this.k = true;
         this.f();
      }
   }

   public final void onSeekComplete(MediaPlayer var1) {
      InneractiveAdView$Log.a("mp: onSeekComplete called current position = " + var1.getCurrentPosition());
      if(this.i) {
         this.start();
      }

   }

   public final void onVideoSizeChanged(MediaPlayer var1, int var2, int var3) {
      InneractiveAdView$Log.a("mp: onVideoSizeChanged " + var2 + ", " + var3);
      this.j = true;
      if(var2 != 0 && var3 != 0) {
         this.f();
      } else {
         InneractiveAdView$Log.e("mp: onVideoSizeChanged - Invalid video size!");
         this.onError(this, 0, 0);
      }
   }

   public final void pause() {
      if(this.d()) {
         super.pause();
      }

      InneractiveAdView$Log.a("mp: pause");
      this.a(IAplayerState.i);
      this.g();
   }

   public final void release() {
      super.release();
      this.g();
      InneractiveAdView$Log.a("mp: release called");
   }

   public final void reset() {
      InneractiveAdView$Log.a("mp: reset called");
      this.g();
      if(this.m != null) {
         this.m.cancel(true);
         this.m = null;
      }

      this.a(IAplayerState.d);
      super.reset();
   }

   public final void run() {
      InneractiveAdView$Log.a("mp: run started");
      if(!this.isPlaying()) {
         InneractiveAdView$Log.a("mp: player is not playing. Aborting progress monitor");
         this.g();
      } else {
         int var1 = this.getDuration();
         int var2 = this.getCurrentPosition();
         InneractiveAdView$Log.a("mp: run: updating progress " + var2);
         Iterator var3 = this.e.iterator();

         while(var3.hasNext()) {
            ((IAplayer$b)var3.next()).e();
         }

         switch(null.a[this.f.ordinal()]) {
         case 1:
            this.a(IAplayer$IAplayerPosition.b);
            return;
         case 2:
            if(var2 > var1 / 4) {
               this.a(IAplayer$IAplayerPosition.d);
               return;
            }
            break;
         case 3:
            if(var2 > var1 / 2) {
               this.a(IAplayer$IAplayerPosition.e);
               return;
            }
            break;
         case 4:
            if(var2 > var1 / 4 * 3) {
               this.a(IAplayer$IAplayerPosition.f);
               return;
            }
            break;
         default:
            return;
         }
      }

   }

   public final void setDisplay(SurfaceHolder var1) {
      InneractiveAdView$Log.a("mp: setDisplay called");
      if(!this.d()) {
         InneractiveAdView$Log.a("mp: setDisplay called when player is not ready!");
      } else if(this.n != null && this.n.equals(var1)) {
         InneractiveAdView$Log.a("mp: setDisplay called with existing surface. ignoring!");
      } else {
         this.n = var1;
         super.setDisplay(var1);
         Object var2 = this.n;
         this.setScreenOnWhilePlaying(true);
         if(this.n == null) {
            InneractiveAdView$Log.a("mp: setDisplay with null! current surface cleared");
         } else {
            InneractiveAdView$Log.a("mp: setDisplay - replacing surface!");
         }
      }
   }

   public final void setOnCompletionListener(OnCompletionListener var1) {
      throw new IllegalAccessError("Please use IAplayerCallbacks to receive completion events");
   }

   public final void setSurface(Surface var1) {
      InneractiveAdView$Log.a("mp: setSurface called");
      if(this.l != null && this.l.equals(var1)) {
         InneractiveAdView$Log.a("mp: setSurface called with existing surface. ignoring!");
      } else {
         this.l = var1;
         super.setSurface(var1);
         if(var1 == null) {
            InneractiveAdView$Log.a("mp: setSurface with null! current surface cleared");
         } else {
            InneractiveAdView$Log.a("mp: setSurface - replacing surface!");
         }
      }
   }

   public final void start() {
      InneractiveAdView$Log.a("mp: Start called");
      if(!this.d()) {
         InneractiveAdView$Log.a("mp: Start called when player is not ready!");
      } else {
         IAplayerState var1 = this.g;
         if(var1 == IAplayerState.i || var1 == IAplayerState.g || var1 == IAplayerState.j) {
            super.start();
            this.a(IAplayerState.h);
            if(var1 == IAplayerState.j) {
               this.a(IAplayer$IAplayerPosition.c);
            }

            this.g();
            this.c = new ScheduledThreadPoolExecutor(1);
            this.c.scheduleAtFixedRate(this, 0L, 1L, TimeUnit.SECONDS);
            return;
         }
      }

   }

   public final void stop() {
      if(this.d()) {
         super.stop();
      }

      InneractiveAdView$Log.a("mp: stop called");
   }
}
