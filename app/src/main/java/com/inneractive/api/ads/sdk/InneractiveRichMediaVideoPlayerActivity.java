package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.InneractiveInterstitialAdActivity;
import com.inneractive.api.ads.sdk.ak$a;

public class InneractiveRichMediaVideoPlayerActivity extends InneractiveInterstitialAdActivity implements ak$a {
   private VideoView a;

   static void a(Context var0, String var1) {
      Intent var2 = new Intent(var0, InneractiveRichMediaVideoPlayerActivity.class);
      var2.setFlags(268435456);
      var2.putExtra("videoview_classname", "mraid");
      var2.putExtra("video_url", var1);

      try {
         var0.startActivity(var2);
      } catch (Exception var3) {
         InneractiveAdView$Log.a("Activity InneractiveRichMediaVideoPlayerActivity was not found. Did you declare it in your AndroidManifest.xml?");
      }
   }

   View getAdView() {
      Object var1;
      if("mraid".equals(this.getIntent().getStringExtra("videoview_classname"))) {
         var1 = new ak(this, this.getIntent(), this);
      } else {
         this.finish();
         var1 = new VideoView(this) {
         };
      }

      this.a = (VideoView)var1;
      return this.a;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.a.start();
   }

   protected void onDestroy() {
      super.onDestroy();
   }

   public void onDisplayCloseButton() {
      this.displayInterstitialCloseBtn();
   }

   protected void onPause() {
      super.onPause();
   }

   protected void onResume() {
      super.onResume();
   }

   public void onVideoClicked() {
   }

   public void onVideoCompleted(boolean var1) {
      this.displayInterstitialCloseBtn();
      if(var1) {
         this.finish();
      }

   }

   public void onVideoError(boolean var1) {
      InneractiveAdView$Log.a("Error: video can not be played.");
      this.displayInterstitialCloseBtn();
      if(var1) {
         this.finish();
      }

   }
}
