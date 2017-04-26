package com.adsdk.sdk.customevents;

import com.adsdk.sdk.customevents.CustomEventFullscreen;

public interface CustomEventFullscreen$CustomEventFullscreenListener {
   void onFullscreenClosed();

   void onFullscreenFailed();

   void onFullscreenLeftApplication();

   void onFullscreenLoaded(CustomEventFullscreen var1);

   void onFullscreenOpened();
}
