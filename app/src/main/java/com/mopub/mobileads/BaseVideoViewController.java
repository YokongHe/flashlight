package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseVideoViewController$BaseVideoViewControllerListener;
import com.mopub.mobileads.EventForwardingBroadcastReceiver;

public abstract class BaseVideoViewController {
   private final BaseVideoViewController$BaseVideoViewControllerListener mBaseVideoViewControllerListener;
   private Long mBroadcastIdentifier;
   private final Context mContext;
   private final RelativeLayout mLayout;

   protected BaseVideoViewController(Context var1, Long var2, BaseVideoViewController$BaseVideoViewControllerListener var3) {
      this.mContext = var1.getApplicationContext();
      this.mBroadcastIdentifier = var2;
      this.mBaseVideoViewControllerListener = var3;
      this.mLayout = new RelativeLayout(this.mContext);
   }

   public boolean backButtonEnabled() {
      return true;
   }

   void broadcastAction(String var1) {
      if(this.mBroadcastIdentifier != null) {
         EventForwardingBroadcastReceiver.broadcastAction(this.mContext, this.mBroadcastIdentifier.longValue(), var1);
      } else {
         MoPubLog.w("Tried to broadcast a video event without a braodcast identifier to send to.");
      }
   }

   protected BaseVideoViewController$BaseVideoViewControllerListener getBaseVideoViewControllerListener() {
      return this.mBaseVideoViewControllerListener;
   }

   protected Context getContext() {
      return this.mContext;
   }

   public ViewGroup getLayout() {
      return this.mLayout;
   }

   protected abstract VideoView getVideoView();

   void onActivityResult(int var1, int var2, Intent var3) {
   }

   protected void onCreate() {
      LayoutParams var1 = new LayoutParams(-1, -2);
      var1.addRule(13);
      this.mLayout.addView(this.getVideoView(), 0, var1);
      this.mBaseVideoViewControllerListener.onSetContentView(this.mLayout);
   }

   protected abstract void onDestroy();

   protected abstract void onPause();

   protected abstract void onResume();

   protected void videoCompleted(boolean var1) {
      if(var1) {
         this.mBaseVideoViewControllerListener.onFinish();
      }

   }

   protected void videoError(boolean var1) {
      MoPubLog.e("Video cannot be played.");
      this.broadcastAction("com.mopub.action.interstitial.fail");
      if(var1) {
         this.mBaseVideoViewControllerListener.onFinish();
      }

   }
}
