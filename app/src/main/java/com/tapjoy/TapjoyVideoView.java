package com.tapjoy;

import android.app.Activity;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.OldTapjoyVideoData;
import com.tapjoy.TJAdUnitView;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyDisplayMetricsUtil;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.TapjoyVideo;
import com.tapjoy.TapjoyVideoView$a;
import com.tapjoy.TapjoyVideoView$b;
import com.tapjoy.internal.fv;
import java.util.HashMap;
import java.util.Timer;

public class TapjoyVideoView extends Activity implements OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener {
   private static int F = 15;
   private static boolean u = false;
   private static boolean v = false;
   private static OldTapjoyVideoData w;
   private boolean A = true;
   private boolean B = false;
   private int C = 0;
   private int D = 0;
   private ImageView E;
   private int G = 50;
   private int H = -5;
   private boolean I = false;
   Dialog a;
   Timer b = null;
   final Handler c = new Handler();
   final Runnable d = new Runnable() {
      public final void run() {
         TapjoyVideoView.this.f.setText("" + TapjoyVideoView.b(TapjoyVideoView.this));
         float var1 = (float)TapjoyVideoView.this.e.getDuration();
         if(var1 > 0.0F) {
            if(!TapjoyVideoView.this.s) {
               TapjoyVideoView.this.a("start");
               TapjoyVideoView.f(TapjoyVideoView.this);
            }

            float var2 = (float)TapjoyVideoView.this.e.getCurrentPosition();
            if(var2 >= var1 / 4.0F && !TapjoyVideoView.this.p) {
               TapjoyLog.i("VideoView", "Video 1st quartile: " + var2);
               TapjoyVideoView.this.a("firstQuartile");
               TapjoyVideoView.h(TapjoyVideoView.this);
            }

            if(var2 >= var1 / 2.0F && !TapjoyVideoView.this.q) {
               TapjoyLog.i("VideoView", "Video midpoint: " + var2);
               TapjoyVideoView.this.a("midpoint");
               TapjoyVideoView.j(TapjoyVideoView.this);
            }

            if(var2 >= var1 * 3.0F / 4.0F && !TapjoyVideoView.this.r) {
               TapjoyLog.i("VideoView", "Video 3rd quartile: " + var2);
               TapjoyVideoView.this.a("thirdQuartile");
               TapjoyVideoView.l(TapjoyVideoView.this);
            }
         }

      }
   };
   private VideoView e = null;
   private TextView f = null;
   private TextView g = null;
   private String h = null;
   private String i = null;
   private String j = "";
   private String k = "Currency will not be awarded, are you sure you want to cancel the video?";
   private String l = "A network connection is necessary to view videos. You will be able to complete the offer and receive your reward on the next connect.";
   private RelativeLayout m;
   private TapjoyVideoView$b n;
   private HashMap o = null;
   private boolean p = false;
   private boolean q = false;
   private boolean r = false;
   private boolean s = false;
   private boolean t = false;
   private boolean x = false;
   private boolean y = false;
   private boolean z = false;

   private void a(String param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(boolean var1) {
      Intent var2 = new Intent();
      var2.putExtra("result", var1);
      if(this.e != null) {
         var2.putExtra("result_string1", Float.toString((float)this.e.getCurrentPosition() / 1000.0F));
         var2.putExtra("result_string2", Float.toString((float)this.e.getDuration() / 1000.0F));
      }

      var2.putExtra("callback_id", this.getIntent().getStringExtra("callback_id"));
      this.setResult(-1, var2);
      this.finish();
   }

   // $FF: synthetic method
   static boolean a(TapjoyVideoView var0) {
      var0.z = true;
      return true;
   }

   // $FF: synthetic method
   static int b(TapjoyVideoView var0) {
      int var2 = (var0.e.getDuration() - var0.e.getCurrentPosition()) / 1000;
      int var1 = var2;
      if(var2 < 0) {
         var1 = 0;
      }

      return var1;
   }

   private void b() {
      this.m.removeAllViews();
      this.m.setBackgroundColor(-16777216);
      if(this.e == null && this.f == null) {
         this.e = new VideoView(this);
         this.e.setOnCompletionListener(this);
         this.e.setOnErrorListener(this);
         this.e.setOnPreparedListener(this);
         if(v) {
            TapjoyLog.i("VideoView", "streaming video: " + this.h);
            this.e.setVideoURI(Uri.parse(this.h));
         } else {
            TapjoyLog.i("VideoView", "cached video: " + this.h);
            this.e.setVideoPath(this.h);
         }

         LayoutParams var1 = new LayoutParams(-1, -1);
         var1.addRule(13);
         this.e.setLayoutParams(var1);
         this.C = this.e.getDuration() / 1000;
         TapjoyLog.i("VideoView", "videoView.getDuration(): " + this.e.getDuration());
         TapjoyLog.i("VideoView", "timeRemaining: " + this.C);
         this.f = new TextView(this);
         this.f.setGravity(17);
         this.f.setTextSize((float)F);
         this.f.setTextColor(Color.parseColor("#535256"));
         this.f.setTypeface(Typeface.create("default", 1), 1);
         this.E = new ImageView(this);
         this.E.setId(1);
         Bitmap var2 = TapjoyUtil.loadBitmapFromJar("countdown_image.png", this);
         if(var2 != null) {
            this.E.setImageBitmap(var2);
            var1 = new LayoutParams(-2, -2);
            var1.addRule(12);
            var1.addRule(9);
            var1.setMargins(this.H, 0, 0, this.H);
            this.E.setLayoutParams(var1);
         }

         var1 = new LayoutParams(this.G, this.G);
         var1.addRule(12);
         var1.addRule(9);
         var1.setMargins(this.H, 0, 0, this.H);
         this.f.setLayoutParams(var1);
         this.g = new TextView(this);
         this.g.setGravity(17);
         this.g.setTextSize((float)F);
         this.g.setTextColor(-1);
         this.g.setTypeface(Typeface.create("default", 0), 0);
         this.g.setText(this.j);
         var1 = new LayoutParams(-2, this.G);
         var1.addRule(1, this.E.getId());
         var1.addRule(12);
         var1.setMargins(0, 0, 0, this.H);
         this.g.setLayoutParams(var1);
      }

      this.e.requestFocus();
      if(this.x) {
         this.e.seekTo(this.D);
         TapjoyLog.i("VideoView", "dialog is showing -- don\'t start");
      } else {
         TapjoyLog.i("VideoView", "start");
         this.e.seekTo(0);
         this.e.start();
         TapjoyVideo.videoStart();
      }

      this.d();
      this.b = new Timer();
      this.b.schedule(new TapjoyVideoView$a(this, (byte)0), 500L, 100L);
      this.z = false;
      if(this.y) {
         (new Thread(new Runnable() {
            public final void run() {
               TapjoyLog.i("VideoView", "SENDING CLICK...");
               TapjoyHttpURLResponse var1 = (new TapjoyURLConnection()).getResponseFromURL(TapjoyVideoView.w.getClickURL());
               if(var1.response != null && var1.response.contains("OK")) {
                  TapjoyLog.i("VideoView", "CLICK REQUEST SUCCESS!");
                  TapjoyVideoView.a(TapjoyVideoView.this);
               }

            }
         })).start();
         this.y = false;
      }

      this.m.addView(this.e);
      this.m.addView(this.E);
      this.m.addView(this.f);
      this.m.addView(this.g);
   }

   private void c() {
      if(this.B) {
         this.a(true);
      } else {
         Intent var1 = new Intent(this, TJAdUnitView.class);
         var1.putExtra("view_type", 4);
         var1.putExtra("url", this.i);
         var1.putExtra("legacy_view", true);
         this.startActivityForResult(var1, 0);
      }
   }

   private void d() {
      if(this.b != null) {
         this.b.cancel();
      }

   }

   // $FF: synthetic method
   static boolean f(TapjoyVideoView var0) {
      var0.s = true;
      return true;
   }

   // $FF: synthetic method
   static boolean h(TapjoyVideoView var0) {
      var0.p = true;
      return true;
   }

   // $FF: synthetic method
   static boolean j(TapjoyVideoView var0) {
      var0.q = true;
      return true;
   }

   // $FF: synthetic method
   static boolean l(TapjoyVideoView var0) {
      var0.r = true;
      return true;
   }

   // $FF: synthetic method
   static void o(TapjoyVideoView var0) {
      var0.a(false);
   }

   public int convertToDp(int var1) {
      return (int)Math.ceil((double)((float)var1 * this.getResources().getDisplayMetrics().density));
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      String var4 = null;
      super.onActivityResult(var1, var2, var3);
      TapjoyLog.i("VideoView", "onActivityResult requestCode:" + var1 + ", resultCode: " + var2);
      Bundle var5;
      if(var3 != null) {
         var5 = var3.getExtras();
      } else {
         var5 = null;
      }

      if(var5 != null) {
         var4 = var5.getString("result");
      }

      if(var4 != null && var4.length() != 0 && !var4.equals("offer_wall")) {
         if(var4.equals("tjvideo")) {
            this.b();
            return;
         }
      } else {
         this.a(true);
      }

   }

   public void onCompletion(MediaPlayer var1) {
      TapjoyLog.i("VideoView", "onCompletion");
      this.d();
      this.c();
      if(!u) {
         TapjoyVideo.videoComplete();
         this.a("complete");
         (new Thread(new Runnable() {
            public final void run() {
               if(TapjoyVideoView.this.z) {
                  TapjoyConnectCore.getInstance().actionComplete(TapjoyVideoView.w.getOfferId());
               }

            }
         })).start();
      }

      u = false;
      this.t = true;
   }

   protected void onCreate(Bundle var1) {
      TapjoyLog.i("VideoView", "onCreate");
      super.onCreate(var1);
      TapjoyConnectCore.viewWillOpen(2);
      if(var1 != null) {
         TapjoyLog.i("VideoView", "*** Loading saved data from bundle ***");
         this.D = var1.getInt("seek_time");
         this.x = var1.getBoolean("dialog_showing");
      }

      var1 = this.getIntent().getExtras();
      if(var1 != null) {
         this.h = var1.getString("VIDEO_URL");
         OldTapjoyVideoData var3 = new OldTapjoyVideoData();
         w = var3;
         var3.setVideoURL(this.h);
         if(var1.containsKey("VIDEO_MESSAGE")) {
            this.j = var1.getString("VIDEO_MESSAGE");
         }

         if(var1.containsKey("VIDEO_DATA")) {
            w = (OldTapjoyVideoData)var1.getSerializable("VIDEO_DATA");
         }

         if(var1.containsKey("CACHED_VIDEO_LOCATION")) {
            w.setLocalFilePath(var1.getString("CACHED_VIDEO_LOCATION"));
         }

         if(var1.containsKey("VIDEO_ALLOW_BACK_BUTTON")) {
            this.A = var1.getBoolean("VIDEO_ALLOW_BACK_BUTTON");
         }

         if(var1.containsKey("VIDEO_CANCEL_MESSAGE")) {
            this.k = var1.getString("VIDEO_CANCEL_MESSAGE");
         }

         if(var1.containsKey("VIDEO_SHOULD_DISMISS")) {
            this.B = var1.getBoolean("VIDEO_SHOULD_DISMISS");
         }

         if(var1.containsKey("VIDEO_TRACKING_URLS")) {
            this.o = (HashMap)var1.getSerializable("VIDEO_TRACKING_URLS");
         }
      }

      TapjoyLog.i("VideoView", "dialogShowing: " + this.x + ", seekTime: " + this.D);
      if(w != null) {
         if(w.getClickURL() != null) {
            this.y = true;
         }

         v = false;
         if(TapjoyVideo.getInstance() == null) {
            TapjoyLog.i("VideoView", "null video");
            this.a(false);
            return;
         }

         this.h = w.getLocalFilePath();
         this.i = w.getWebviewURL();
         if(this.h == null || this.h.length() == 0) {
            TapjoyLog.i("VideoView", "Playing video at location:: " + w.getVideoURL());
            this.h = w.getVideoURL();
            v = true;
         }

         TapjoyLog.i("VideoView", "videoPath: " + this.h);
      } else if(this.h != null) {
         v = true;
         this.y = false;
         TapjoyLog.i("VideoView", "playing video only: " + this.h);
      }

      this.requestWindowFeature(1);
      this.m = new RelativeLayout(this);
      LayoutParams var4 = new LayoutParams(-1, -1);
      this.m.setLayoutParams(var4);
      this.setContentView(this.m);
      if(VERSION.SDK_INT > 3) {
         int var2 = (new TapjoyDisplayMetricsUtil(this)).getScreenLayoutSize();
         TapjoyLog.i("VideoView", "deviceScreenLayoutSize: " + var2);
         if(var2 == 4) {
            F = 32;
         }
      }

      this.G = this.convertToDp(this.G);
      this.H = this.convertToDp(this.H);
      this.n = new TapjoyVideoView$b(this, (byte)0);
      this.registerReceiver(this.n, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      this.b();
      TapjoyLog.i("VideoView", "onCreate DONE");
      TapjoyConnectCore.viewDidOpen(2);
   }

   protected Dialog onCreateDialog(int var1) {
      TapjoyLog.i("VideoView", "dialog onCreateDialog");
      if(!this.x) {
         return this.a;
      } else {
         switch(var1) {
         case 0:
            this.a = (new Builder(this)).setTitle("Cancel Video?").setMessage(this.k).setNegativeButton("End", new OnClickListener() {
               public final void onClick(DialogInterface var1, int var2) {
                  TapjoyVideoView.o(TapjoyVideoView.this);
               }
            }).setPositiveButton("Resume", new OnClickListener() {
               public final void onClick(DialogInterface var1, int var2) {
                  var1.dismiss();
                  TapjoyVideoView.this.e.seekTo(TapjoyVideoView.this.D);
                  TapjoyVideoView.this.e.start();
                  TapjoyVideoView.this.x = false;
                  TapjoyLog.i("VideoView", "RESUME VIDEO time: " + TapjoyVideoView.this.D);
                  TapjoyLog.i("VideoView", "currentPosition: " + TapjoyVideoView.this.e.getCurrentPosition());
                  TapjoyLog.i("VideoView", "duration: " + TapjoyVideoView.this.e.getDuration() + ", elapsed: " + (TapjoyVideoView.this.e.getDuration() - TapjoyVideoView.this.e.getCurrentPosition()));
               }
            }).create();
            this.a.setOnCancelListener(new OnCancelListener() {
               public final void onCancel(DialogInterface var1) {
                  TapjoyLog.i("VideoView", "dialog onCancel");
                  var1.dismiss();
                  TapjoyVideoView.this.e.seekTo(TapjoyVideoView.this.D);
                  TapjoyVideoView.this.e.start();
                  TapjoyVideoView.this.x = false;
               }
            });
            this.a.show();
            this.x = true;
            break;
         case 1:
            this.a = (new Builder(this)).setTitle("Network Connection Lost").setMessage(this.l).setPositiveButton("Okay", new OnClickListener() {
               public final void onClick(DialogInterface var1, int var2) {
                  var1.dismiss();
                  TapjoyVideoView.this.x = false;
                  TapjoyVideoView.o(TapjoyVideoView.this);
               }
            }).create();
            this.a.setOnCancelListener(new OnCancelListener() {
               public final void onCancel(DialogInterface var1) {
                  TapjoyLog.i("VideoView", "dialog onCancel");
                  var1.dismiss();
                  TapjoyVideoView.this.x = false;
                  TapjoyVideoView.o(TapjoyVideoView.this);
               }
            });
            this.a.show();
            this.x = true;
            break;
         default:
            this.a = null;
         }

         return this.a;
      }
   }

   protected void onDestroy() {
      super.onDestroy();
      if(this.isFinishing()) {
         if(this.n != null) {
            this.unregisterReceiver(this.n);
            this.n = null;
         }

         TapjoyConnectCore.viewWillClose(2);
         TapjoyConnectCore.viewDidClose(2);
      }

   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      TapjoyLog.i("VideoView", "onError, what: " + var2 + "extra: " + var3);
      u = true;
      TapjoyVideo.videoError(3);
      this.d();
      return var2 == 1 && var3 == -1004;
   }

   public boolean onInfo(MediaPlayer var1, int var2, int var3) {
      if(this.s) {
         if(var2 == 701) {
            this.a("stall");
         } else if(var2 == 702) {
            this.a("resume");
         }
      }

      return false;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4) {
         if(!this.t && !u) {
            if(!u) {
               if(!this.A) {
                  return true;
               }

               if(this.k != null && this.k.length() > 0) {
                  this.D = this.e.getCurrentPosition();
                  this.e.pause();
                  this.x = true;
                  this.showDialog(0);
                  TapjoyLog.i("VideoView", "PAUSE VIDEO time: " + this.D);
                  TapjoyLog.i("VideoView", "currentPosition: " + this.e.getCurrentPosition());
                  TapjoyLog.i("VideoView", "duration: " + this.e.getDuration() + ", elapsed: " + (this.e.getDuration() - this.e.getCurrentPosition()));
                  return true;
               }
            }
         } else if(this.e.isPlaying()) {
            this.e.stopPlayback();
            this.d();
            this.c();
            return true;
         }
      }

      return super.onKeyDown(var1, var2);
   }

   protected void onPause() {
      super.onPause();
      if(this.e.isPlaying()) {
         TapjoyLog.i("VideoView", "onPause");
         this.e.pause();
         this.D = this.e.getCurrentPosition();
         TapjoyLog.i("VideoView", "seekTime: " + this.D);
      }

   }

   public void onPrepared(MediaPlayer var1) {
      var1.setOnInfoListener(this);
      TapjoyLog.i("VideoView", "onPrepared");
   }

   protected void onResume() {
      TapjoyLog.i("VideoView", "onResume");
      super.onResume();
      this.setRequestedOrientation(0);
      if(this.D > 0) {
         TapjoyLog.i("VideoView", "seekTime: " + this.D);
         this.e.seekTo(this.D);
         if(!this.x || this.a == null || !this.a.isShowing()) {
            this.e.start();
         }
      }

   }

   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      TapjoyLog.i("VideoView", "*** onSaveInstanceState ***");
      TapjoyLog.i("VideoView", "dialogShowing: " + this.x + ", seekTime: " + this.D);
      var1.putBoolean("dialog_showing", this.x);
      var1.putInt("seek_time", this.D);
   }

   protected void onStart() {
      super.onStart();
      if(TapjoyConnectCore.isAutoSessionTrackingStarted()) {
         this.I = true;
         fv.a().a((Activity)this);
      }

   }

   protected void onStop() {
      if(this.I) {
         this.I = false;
         fv.a().b((Activity)this);
      }

      super.onStop();
   }

   public void onWindowFocusChanged(boolean var1) {
      TapjoyLog.i("VideoView", "onWindowFocusChanged");
      super.onWindowFocusChanged(var1);
   }
}
