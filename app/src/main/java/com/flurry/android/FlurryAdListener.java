package com.flurry.android;

import com.flurry.android.FlurryAdType;

public interface FlurryAdListener {
   void onAdClicked(String var1);

   void onAdClosed(String var1);

   void onAdOpened(String var1);

   void onApplicationExit(String var1);

   void onRenderFailed(String var1);

   void onRendered(String var1);

   void onVideoCompleted(String var1);

   boolean shouldDisplayAd(String var1, FlurryAdType var2);

   void spaceDidFailToReceiveAd(String var1);

   void spaceDidReceiveAd(String var1);
}
