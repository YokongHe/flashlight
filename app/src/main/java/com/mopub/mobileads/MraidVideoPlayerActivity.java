package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.BaseVideoViewController$BaseVideoViewControllerListener;
import com.mopub.mobileads.EventForwardingBroadcastReceiver;
import com.mopub.mobileads.VastVideoViewController;
import com.mopub.mraid.MraidVideoViewController;

public class MraidVideoPlayerActivity extends BaseVideoPlayerActivity implements BaseVideoViewController$BaseVideoViewControllerListener {
   private BaseVideoViewController mBaseVideoController;
   private long mBroadcastIdentifier;

   private BaseVideoViewController createVideoViewController() {
      String var1 = this.getIntent().getStringExtra("video_view_class_name");
      if("vast".equals(var1)) {
         return new VastVideoViewController(this, this.getIntent().getExtras(), this.mBroadcastIdentifier, this);
      } else if("mraid".equals(var1)) {
         return new MraidVideoViewController(this, this.getIntent().getExtras(), this);
      } else {
         throw new IllegalStateException("Unsupported video type: " + var1);
      }
   }

   protected static long getBroadcastIdentifierFromIntent(Intent var0) {
      return var0.getLongExtra("broadcastIdentifier", -1L);
   }

   @Deprecated
   BaseVideoViewController getBaseVideoViewController() {
      return this.mBaseVideoController;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      if(this.mBaseVideoController != null) {
         this.mBaseVideoController.onActivityResult(var1, var2, var3);
      }

   }

   public void onBackPressed() {
      if(this.mBaseVideoController != null && this.mBaseVideoController.backButtonEnabled()) {
         super.onBackPressed();
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(1);
      this.getWindow().addFlags(1024);
      this.mBroadcastIdentifier = getBroadcastIdentifierFromIntent(this.getIntent());

      try {
         this.mBaseVideoController = this.createVideoViewController();
      } catch (IllegalStateException var2) {
         EventForwardingBroadcastReceiver.broadcastAction(this, this.mBroadcastIdentifier, "com.mopub.action.interstitial.fail");
         this.finish();
         return;
      }

      this.mBaseVideoController.onCreate();
   }

   protected void onDestroy() {
      if(this.mBaseVideoController != null) {
         this.mBaseVideoController.onDestroy();
      }

      super.onDestroy();
   }

   public void onFinish() {
      this.finish();
   }

   protected void onPause() {
      if(this.mBaseVideoController != null) {
         this.mBaseVideoController.onPause();
      }

      super.onPause();
   }

   protected void onResume() {
      super.onResume();
      if(this.mBaseVideoController != null) {
         this.mBaseVideoController.onResume();
      }

   }

   public void onSetContentView(View var1) {
      this.setContentView(var1);
   }

   public void onSetRequestedOrientation(int var1) {
      this.setRequestedOrientation(var1);
   }

   public void onStartActivityForResult(Class var1, int var2, Bundle var3) {
      if(var1 != null) {
         Intent var5 = Intents.getStartActivityIntent(this, var1, var3);

         try {
            this.startActivityForResult(var5, var2);
         } catch (ActivityNotFoundException var4) {
            MoPubLog.d("Activity " + var1.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
         }
      }
   }

   @Deprecated
   void setBaseVideoViewController(BaseVideoViewController var1) {
      this.mBaseVideoController = var1;
   }
}
