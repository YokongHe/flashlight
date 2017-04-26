package com.amazon.device.ads;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.amazon.device.ads.AdActivity$IAdActivityAdapter;
import com.amazon.device.ads.AdVideoPlayer;
import com.amazon.device.ads.AdVideoPlayer$AdVideoPlayerListener;

class VideoActionHandler implements AdActivity$IAdActivityAdapter {
   private Activity activity;
   private RelativeLayout layout;
   private AdVideoPlayer player;

   private void initPlayer(Bundle var1) {
      this.player = new AdVideoPlayer(this.activity);
      this.player.setPlayData(var1.getString("url"));
      LayoutParams var2 = new LayoutParams(-1, -1);
      var2.addRule(13);
      this.player.setLayoutParams(var2);
      this.player.setViewGroup(this.layout);
      this.setPlayerListener(this.player);
   }

   private void setPlayerListener(AdVideoPlayer var1) {
      var1.setListener(new AdVideoPlayer$AdVideoPlayerListener() {
         public void onComplete() {
            VideoActionHandler.this.activity.finish();
         }

         public void onError() {
            VideoActionHandler.this.activity.finish();
         }
      });
   }

   public boolean onBackPressed() {
      return false;
   }

   public void onConfigurationChanged(android.content.res.Configuration var1) {
   }

   public void onCreate() {
      Bundle var1 = this.activity.getIntent().getExtras();
      this.layout = new RelativeLayout(this.activity);
      this.layout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
      this.activity.setContentView(this.layout);
      this.initPlayer(var1);
      this.player.playVideo();
   }

   public void onPause() {
   }

   public void onResume() {
   }

   public void onStop() {
      this.player.releasePlayer();
      this.player = null;
      this.activity.finish();
   }

   public void preOnCreate() {
      this.activity.requestWindowFeature(1);
   }

   public void setActivity(Activity var1) {
      this.activity = var1;
   }
}
