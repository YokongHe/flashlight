package com.millennialmedia.android;

import android.net.Uri;
import com.millennialmedia.android.OverlaySettings;

interface HttpRedirection$Listener {
   boolean canOpenOverlay();

   OverlaySettings getOverlaySettings();

   boolean isActivityStartable(Uri var1);

   boolean isExpandingToUrl();

   boolean isHandlingMMVideo(Uri var1);

   void startingActivity(Uri var1);

   void startingVideo();

   void updateLastVideoViewedTime();
}
