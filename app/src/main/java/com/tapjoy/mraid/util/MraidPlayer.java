package com.tapjoy.mraid.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract$PlayerProperties;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.Utils;

public class MraidPlayer extends VideoView implements OnCompletionListener, OnErrorListener, OnPreparedListener {
   private static String h = "Loading. Please Wait..";
   private static String i = "MRAID Player";
   private Abstract$PlayerProperties a;
   private AudioManager b = (AudioManager)this.getContext().getSystemService("audio");
   private Player c;
   private int d;
   private String e;
   private RelativeLayout f;
   private ImageButton g;
   private boolean j;

   public MraidPlayer(Context var1) {
      super(var1);
   }

   private void a() {
      this.e = this.e.trim();
      this.e = Utils.convert(this.e);
      if(this.e == null && this.c != null) {
         this.b();
         this.c.onError();
      } else {
         this.setVideoURI(Uri.parse(this.e));
         TapjoyLog.d("player", Uri.parse(this.e).toString());
         if(this.a.showControl()) {
            MediaController var1 = new MediaController(this.getContext());
            this.setMediaController(var1);
            var1.setAnchorView(this);
         }

         this.setOnCompletionListener(this);
         this.setOnErrorListener(this);
         this.setOnPreparedListener(this);
         if(!this.a.inline && !this.a.inline) {
            this.f = new RelativeLayout(this.getContext());
            this.f.setLayoutParams(this.getLayoutParams());
            TextView var3 = new TextView(this.getContext());
            var3.setText(h);
            var3.setTextColor(-1);
            LayoutParams var2 = new LayoutParams(-2, -2);
            var2.addRule(13);
            this.f.addView(var3, var2);
            ((ViewGroup)this.getParent()).addView(this.f);
         }

         if(this.a.isAutoPlay()) {
            this.start();
            return;
         }
      }

   }

   private void b() {
      ViewGroup var1 = (ViewGroup)this.getParent();
      if(var1 != null) {
         var1.removeAllViews();
      }

   }

   private void c() {
      if(this.f != null) {
         ((ViewGroup)this.getParent()).removeView(this.f);
      }

   }

   public ImageButton getCloseImageButton() {
      return this.g;
   }

   public void onCompletion(MediaPlayer var1) {
      if(this.a.doLoop()) {
         this.start();
      } else if(this.a.exitOnComplete() || this.a.inline) {
         this.releasePlayer();
         return;
      }

   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      TapjoyLog.i(i, "Player error : " + var2);
      this.c();
      this.b();
      if(this.c != null) {
         this.c.onError();
      }

      return false;
   }

   public void onPrepared(MediaPlayer var1) {
      this.c();
      if(this.c != null) {
         this.c.onPrepared();
      }

   }

   public void playAudio() {
      this.a();
   }

   public void playVideo() {
      if(this.a.doMute()) {
         this.d = this.b.getStreamVolume(3);
         this.b.setStreamVolume(3, 0, 4);
      }

      this.a();
   }

   public void releasePlayer() {
      if(!this.j) {
         this.j = true;
         this.stopPlayback();
         this.b();
         if(this.a != null && this.a.doMute()) {
            this.b.setStreamVolume(3, this.d, 4);
         }

         if(this.c != null) {
            this.c.onComplete();
            return;
         }
      }

   }

   public void setListener(Player var1) {
      this.c = var1;
   }

   public void setPlayData(Abstract$PlayerProperties var1, String var2) {
      this.j = false;
      this.a = var1;
      this.e = var2;
   }
}
