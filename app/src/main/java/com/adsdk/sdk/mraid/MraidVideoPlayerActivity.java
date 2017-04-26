package com.adsdk.sdk.mraid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.adsdk.sdk.mraid.BaseInterstitialActivity;
import com.adsdk.sdk.mraid.BaseVideoView;
import com.adsdk.sdk.mraid.BaseVideoView$BaseVideoViewListener;
import com.adsdk.sdk.mraid.MraidVideoView;
import java.util.ArrayList;

public class MraidVideoPlayerActivity extends BaseInterstitialActivity implements BaseVideoView$BaseVideoViewListener {
   private static final String VIDEO_CLASS_EXTRAS_KEY = "video_view_class_name";
   static final String VIDEO_URL = "video_url";
   private BaseVideoView mVideoView;

   private void broadcastVastInterstitialAction(String var1) {
   }

   static Intent createIntentMraid(Context var0, String var1) {
      Intent var2 = new Intent(var0, MraidVideoPlayerActivity.class);
      var2.setFlags(268435456);
      var2.putExtra("video_view_class_name", "mraid");
      var2.putExtra("video_url", var1);
      return var2;
   }

   static Intent createIntentVast(Context var0, String var1, ArrayList var2, ArrayList var3, ArrayList var4, ArrayList var5, ArrayList var6, ArrayList var7, String var8, ArrayList var9) {
      return new Intent(var0, MraidVideoPlayerActivity.class);
   }

   private BaseVideoView createVideoView() {
      String var1 = this.getIntent().getStringExtra("video_view_class_name");
      if("vast".equals(var1)) {
         return null;
      } else if("mraid".equals(var1)) {
         return new MraidVideoView(this, this.getIntent(), this);
      } else {
         this.broadcastInterstitialAction("com.mopub.action.interstitial.fail");
         this.finish();
         return new BaseVideoView(this) {
         };
      }
   }

   static void startMraid(Context var0, String var1) {
      Intent var3 = createIntentMraid(var0, var1);

      try {
         var0.startActivity(var3);
      } catch (ActivityNotFoundException var2) {
         Log.d("MraidVideoPlayerActivity", "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
      }
   }

   static void startVast(Context var0, String var1, ArrayList var2, ArrayList var3, ArrayList var4, ArrayList var5, ArrayList var6, ArrayList var7, String var8, ArrayList var9) {
      if(var1 != null) {
         Intent var11 = createIntentVast(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);

         try {
            var0.startActivity(var11);
         } catch (ActivityNotFoundException var10) {
            Log.d("MoPub", "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
         }
      }
   }

   public View getAdView() {
      this.mVideoView = this.createVideoView();
      return this.mVideoView;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.hideInterstitialCloseButton();
      this.mVideoView.start();
   }

   protected void onDestroy() {
      super.onDestroy();
   }

   protected void onPause() {
      this.mVideoView.onPause();
      super.onPause();
   }

   protected void onResume() {
      super.onResume();
      this.mVideoView.onResume();
   }

   public void showCloseButton() {
      this.showInterstitialCloseButton();
   }

   public void videoClicked() {
      this.broadcastInterstitialAction("com.mopub.action.interstitial.click");
   }

   public void videoCompleted(boolean var1) {
      this.showInterstitialCloseButton();
      if(var1) {
         this.finish();
      }

   }

   public void videoError(boolean var1) {
      Log.d("MoPub", "Error: video can not be played.");
      this.showInterstitialCloseButton();
      this.broadcastInterstitialAction("com.mopub.action.interstitial.fail");
      if(var1) {
         this.finish();
      }

   }
}
