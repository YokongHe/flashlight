package com.flurry.sdk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.SurfaceHolder.Callback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.sdk.eo;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class f extends SurfaceView implements OnKeyListener, com.flurry.sdk.af {
   private static final String A = com.flurry.sdk.f.class.getSimpleName();
   private OnCompletionListener B = new OnCompletionListener() {
      public void onCompletion(MediaPlayer var1) {
         f.this.n.d();
         f.this.f = 5;
         f.this.g = 5;
         if(f.this.n != null) {
            f.this.n.h();
         }

         if(f.this.o != null) {
            f.this.o.onCompletion(f.this.i);
         }

         if(f.this.w != null) {
            f.this.w.a("videoCompleted", Collections.emptyMap(), f.this.w.getAdUnit(), f.this.w.getAdLog(), f.this.w.getAdFrameIndex(), 0);
         }

      }
   };
   private OnErrorListener C = new OnErrorListener() {
      public boolean onError(MediaPlayer var1, int var2, int var3) {
         eo.a(6, com.flurry.sdk.f.A, "Video Playback Error: " + var2 + "," + var3);
         f.this.f = -1;
         f.this.g = -1;
         f.this.b();
         if(f.this.n != null) {
            f.this.n.h();
            f.this.n.d();
         }

         if(f.this.r == null || !f.this.r.onError(f.this.i, var2, var3)) {
            if(f.this.getWindowToken() != null) {
               f.this.getContext().getResources();
               String var4;
               if(var2 == 200) {
                  var4 = "Sorry, this video is not valid for streaming to this device.";
               } else {
                  var4 = "Sorry, this video cannot be played.";
               }

               eo.a(3, com.flurry.sdk.f.A, var4);
            }

            f.this.b();
            if(f.this.w != null) {
               HashMap var5 = new HashMap();
               var5.put("errorCode", Integer.toString(com.flurry.sdk.b.r.a()));
               var5.put("frameworkError", Integer.toString(var2));
               var5.put("implError", Integer.toString(var3));
               f.this.w.a("renderFailed", var5, f.this.w.getAdUnit(), f.this.w.getAdLog(), f.this.w.getAdFrameIndex(), 0);
            }

            if(f.this.x != null) {
               f.this.x.terminateVideoPlaybackDueToError();
               return true;
            }
         }

         return true;
      }
   };
   private OnBufferingUpdateListener D = new OnBufferingUpdateListener() {
      public void onBufferingUpdate(MediaPlayer var1, int var2) {
         f.this.q = var2;
      }
   };
   OnVideoSizeChangedListener a = new OnVideoSizeChangedListener() {
      public void onVideoSizeChanged(MediaPlayer var1, int var2, int var3) {
         f.this.j = var1.getVideoWidth();
         f.this.k = var1.getVideoHeight();
         if(f.this.j != 0 && f.this.k != 0) {
            f.this.getHolder().setFixedSize(f.this.j, f.this.k);
         }

      }
   };
   OnPreparedListener b = new OnPreparedListener() {
      public void onPrepared(MediaPlayer var1) {
         f.this.f = 2;
         f.this.t = true;
         if(f.this.p != null) {
            f.this.p.onPrepared(f.this.i);
         }

         if(f.this.n != null) {
            f.this.n.setEnabled(true);
         }

         f.this.j = var1.getVideoWidth();
         f.this.k = var1.getVideoHeight();
         int var2 = f.this.s;
         if(var2 != 0) {
            f.this.seekTo(var2);
         }

         if(!f.this.n.getAutoPlay() && f.this.getCurrentPosition() <= f.this.n.getOffsetStartTime()) {
            f.this.seekTo(3);
            f.this.n.setOffsetStartTime(3);
         }

         f.this.b();
         if(f.this.w != null) {
            String var3 = ((AdFrame)f.this.w.getAdUnit().d().get(f.this.w.getAdFrameIndex())).g().toString();
            com.flurry.sdk.am var4 = FlurryAdModule.getInstance().c(var3);
            if(!var4.g()) {
               f.this.w.a("rendered", Collections.emptyMap(), f.this.w.getAdUnit(), f.this.w.getAdLog(), f.this.w.getAdFrameIndex(), 0);
               var4.f(true);
            }
         }

         if(f.this.n != null) {
            f.this.n.a();
         }

         if(f.this.w == null || !f.this.w.d()) {
            f.this.j();
         }

      }
   };
   Callback c = new Callback() {
      public void surfaceChanged(SurfaceHolder var1, int var2, int var3, int var4) {
         boolean var5 = true;
         f.this.l = var3;
         f.this.m = var4;
         boolean var6;
         if(f.this.g == 3) {
            var6 = true;
         } else {
            var6 = false;
         }

         boolean var7;
         if(f.this.j == var3 && f.this.k == var4) {
            var7 = var5;
         } else {
            var7 = false;
         }

         if(f.this.i != null && var6 && var7) {
            if(f.this.s != 0) {
               f.this.seekTo(f.this.s);
            }

            if(f.this.w != null && !f.this.w.d()) {
               f.this.start();
            } else if(f.this.w == null) {
               f.this.start();
            }

            if(f.this.n != null) {
               if(f.this.n.g()) {
                  f.this.n.h();
               }

               f.this.n.e();
            }
         }

      }

      public void surfaceCreated(SurfaceHolder var1) {
         f.this.h = var1;
         eo.a(4, com.flurry.sdk.f.A, "mCurrentState is ....:" + f.this.f);
         eo.a(4, com.flurry.sdk.f.A, "mTargetState is ....:" + f.this.g);
         if(f.this.i == null && f.this.k()) {
            f.this.a(false);
         }

      }

      public void surfaceDestroyed(SurfaceHolder var1) {
         f.this.h = null;
         if(f.this.n != null) {
            f.this.n.d();
            f.this.n.k();
         }

         eo.a(4, com.flurry.sdk.f.A, "mCurrentState is :" + f.this.f);
         f.this.b(false);
      }
   };
   private Uri d;
   private int e;
   private int f = 0;
   private int g = 0;
   private SurfaceHolder h = null;
   private MediaPlayer i = null;
   private int j;
   private int k;
   private int l;
   private int m;
   private com.flurry.sdk.z n;
   private OnCompletionListener o;
   private OnPreparedListener p;
   private int q;
   private OnErrorListener r;
   private int s;
   private boolean t;
   private int u;
   private ViewGroup v;
   private com.flurry.sdk.g w;
   private FlurryFullscreenTakeoverActivity x;
   private ProgressDialog y;
   private AtomicBoolean z = new AtomicBoolean(false);

   public f(Context var1, com.flurry.sdk.g var2, FlurryFullscreenTakeoverActivity var3, com.flurry.sdk.z var4) {
      super(var1);
      this.a(var1, var2, var3, var4);
   }

   private void a(Context var1, com.flurry.sdk.g var2, FlurryFullscreenTakeoverActivity var3, com.flurry.sdk.z var4) {
      FrameLayout var6 = new FrameLayout(var1);
      LayoutParams var5 = new LayoutParams(-1, -2);
      var5.gravity = 16;
      var6.setLayoutParams(var5);
      this.v = var6;
      this.j = 0;
      this.k = 0;
      this.getHolder().addCallback(this.c);
      this.getHolder().setType(3);
      this.setFocusable(true);
      this.setFocusableInTouchMode(true);
      this.requestFocus();
      this.f = 0;
      this.g = 0;
      this.w = var2;
      this.x = var3;
      this.n = var4;
      this.n.setAdUnityView(var2);
   }

   private void a(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   private void b(boolean var1) {
      if(this.w != null) {
         String var2 = ((AdFrame)this.w.getAdUnit().d().get(this.w.getAdFrameIndex())).g().toString();
         FlurryAdModule.getInstance().c(var2).a(this.getCurrentPosition());
      }

      eo.a(4, A, "media player has been released");
      if(this.i != null) {
         this.n.setIsMediaPlayerReleased(true);
         this.n.setMediaPlayer((com.flurry.sdk.f)null);
         this.i.reset();
         this.i.release();
         this.i = null;
         this.f = 0;
         if(var1) {
            this.g = 0;
         }
      }

   }

   private boolean h() {
      return !this.d.getScheme().equalsIgnoreCase("file");
   }

   private void i() {
      if(this.i != null && this.n != null) {
         this.n.setMediaPlayer(this);
         this.n.setEnabled(this.m());
         this.n.setIsMediaPlayerReleased(false);
      }

   }

   private void j() {
      if(this.n.getAutoPlay() || this.getCurrentPosition() > this.n.getOffsetStartTime()) {
         this.start();
      }

      this.n.a(0);
   }

   private boolean k() {
      Context var3 = this.getContext();
      if(var3 != null) {
         boolean var1 = ((Activity)var3).isFinishing();
         boolean var2 = this.z.get();
         eo.a(4, A, "IsFinishing " + var1 + " IsAdClosed " + var2);
         return !var2 && !var1;
      } else {
         return false;
      }
   }

   private void l() {
      if(this.n.g()) {
         this.n.h();
      } else {
         this.n.e();
      }
   }

   private boolean m() {
      return this.i != null && this.f != -1 && this.f != 0 && this.f != 1;
   }

   public void a() {
      if(this.y == null) {
         if(this.getContext() == null) {
            eo.a(3, A, "Context is null, cannot create progress dialog.");
            return;
         }

         this.y = new ProgressDialog(this.getContext());
         this.y.setProgressStyle(0);
         this.y.setCancelable(true);
         this.y.setCanceledOnTouchOutside(false);
         this.y.setOnKeyListener(this);
         this.y.show();
      } else if(!this.y.isShowing()) {
         this.y.show();
         return;
      }

   }

   public void a(Uri var1, int var2) {
      this.d = var1;
      this.s = var2;
      this.requestLayout();
      this.invalidate();
   }

   public void b() {
      if(this.y != null && this.y.isShowing()) {
         this.y.dismiss();
         this.y = null;
      }

   }

   public void c() {
      if(this.w != null) {
         String var1 = ((AdFrame)this.w.getAdUnit().d().get(this.w.getAdFrameIndex())).g().toString();
         FlurryAdModule.getInstance().c(var1).a(this.getCurrentPosition());
      }

      if(this.i != null) {
         this.i.stop();
         this.i.release();
         this.i = null;
         this.f = 0;
         this.g = 0;
         this.n.d();
         this.n.setIsMediaPlayerReleased(true);
         this.n.setMediaPlayer((com.flurry.sdk.f)null);
      }

   }

   public boolean canPause() {
      return this.t;
   }

   public boolean canSeekBackward() {
      return false;
   }

   public boolean canSeekForward() {
      return false;
   }

   public void d() {
      eo.a(4, A, "HERE IN SUSPEND BEGIN");
      if(this.i != null) {
         eo.a(4, A, "video position suspend is :" + this.i.getCurrentPosition());
      }

      if(this.m()) {
         this.s = this.getCurrentPosition();
         this.u = this.f;
         this.f = 6;
         this.g = 6;
         eo.a(5, A, "able to suspend video.");
         if(this.i.isPlaying()) {
            this.i.pause();
         }
      }

   }

   public void e() {
      eo.a(4, A, "HERE IN resume BEGIN");
      if(this.i != null) {
         eo.a(3, A, "video position resume is :" + this.i.getCurrentPosition() + " mSeekWhenPrepared " + this.s);
      }

      if(this.h == null && this.f == 6) {
         this.g = 7;
      } else {
         if(this.i != null && this.f == 6) {
            try {
               this.j();
               this.f = this.u;
               this.g = this.u;
            } catch (IllegalStateException var2) {
               eo.a(3, A, "Exception: " + var2.getLocalizedMessage());
            }
         }

         if(this.f == 8 && this.k()) {
            this.a(true);
            return;
         }

         if(this.n != null && this.n.getMoreInfoClicked()) {
            this.n.i();
            return;
         }
      }

   }

   public void f() {
      this.z.set(true);
   }

   public int getAudioSessionId() {
      return 0;
   }

   public int getBufferPercentage() {
      return this.i != null?this.q:0;
   }

   public int getCurrentPosition() {
      return this.m()?this.i.getCurrentPosition():0;
   }

   public int getDuration() {
      if(this.m()) {
         if(this.e > 0) {
            return this.e;
         } else {
            this.e = this.i.getDuration();
            return this.e;
         }
      } else {
         this.e = -1;
         return this.e;
      }
   }

   public boolean isPlaying() {
      return this.m() && this.i.isPlaying();
   }

   public boolean onKey(DialogInterface var1, int var2, KeyEvent var3) {
      eo.a(3, "listeners", "onkey,keycode=" + var2 + ",event=" + var3.getAction());
      if(var1 == this.y && var2 == 4 && var3.getAction() == 1) {
         if(this.w != null) {
            this.w.a();
         }

         var1.dismiss();
         return true;
      } else {
         return false;
      }
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3;
      if(var1 != 4 && var1 != 82 && var1 != 5 && var1 != 6) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(this.m() && var3 && this.n != null) {
         if(var1 != 25 && var1 != 24) {
            this.l();
         } else {
            eo.a(4, A, "Volume controls hit");
         }
      }

      return super.onKeyDown(var1, var2);
   }

   protected void onMeasure(int var1, int var2) {
      eo.a(4, A, "onMeasure");
      int var3 = getDefaultSize(this.j, var1);
      int var4 = getDefaultSize(this.k, var2);
      var1 = var4;
      var2 = var3;
      if(this.j > 0) {
         var1 = var4;
         var2 = var3;
         if(this.k > 0) {
            if(this.j * var4 > this.k * var3) {
               eo.a(4, A, "image too tall, correcting");
               var1 = this.k * var3 / this.j;
               var2 = var3;
            } else if(this.j * var4 < this.k * var3) {
               eo.a(4, A, "image too wide, correcting");
               var2 = this.j * var4 / this.k;
               var1 = var4;
            } else {
               eo.a(4, A, "aspect ratio is correct: " + var3 + "/" + var4 + "=" + this.j + "/" + this.k);
               var1 = var4;
               var2 = var3;
            }
         }
      }

      eo.a(4, A, "setting size: " + var2 + 'x' + var1);
      this.setMeasuredDimension(var2, var1);
      this.n.b();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(this.m() && this.n != null) {
         this.l();
      }

      return false;
   }

   public boolean onTrackballEvent(MotionEvent var1) {
      if(this.m() && this.n != null) {
         this.l();
      }

      return false;
   }

   public void pause() {
      eo.a(4, A, "HERE IN PAUSE BEGIN");
      if(this.i != null) {
         eo.a(4, A, "video position pause is :" + this.i.getCurrentPosition());
      }

      if(this.m() && this.i.isPlaying()) {
         this.i.pause();
         this.f = 4;
      }

      this.g = 4;
   }

   public void seekTo(int var1) {
      if(this.m()) {
         this.i.seekTo(var1);
         this.s = 0;
      } else {
         this.s = var1;
      }
   }

   public void setCloseConfirmDialogClicked(boolean var1) {
      this.n.setmCloseConfirmDialogClicked(var1);
   }

   public void setMediaController(com.flurry.sdk.z var1) {
      if(this.n != null) {
         this.n.h();
      }

      this.n = var1;
      this.i();
   }

   public void setOnCompletionListener(OnCompletionListener var1) {
      this.o = var1;
   }

   public void setOnErrorListener(OnErrorListener var1) {
      this.r = var1;
   }

   public void setOnPreparedListener(OnPreparedListener var1) {
      this.p = var1;
   }

   public void setVideoState(com.flurry.sdk.am var1) {
      if(this.n != null) {
         this.n.setVideoState(var1);
      }

   }

   public void start() {
      eo.a(4, A, "HERE IN START BEGIN");
      if(this.i != null) {
         eo.a(4, A, "video position start is :" + this.i.getCurrentPosition());
      }

      if(this.m()) {
         this.i.start();
         this.f = 3;
      }

      if(this.n.c()) {
         this.n.a();
         this.n.e();
      }

      this.g = 3;
   }
}
