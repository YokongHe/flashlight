package com.millennialmedia.android;

import android.net.Uri;
import com.millennialmedia.android.HttpRedirection$Listener;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.OverlaySettings;
import java.lang.ref.WeakReference;

class HttpRedirection$RedirectionListenerImpl implements HttpRedirection$Listener {
   long creatorAdImplInternalId;
   Uri destinationUri;
   String orientation;
   String url;
   WeakReference weakContext;

   public boolean canOpenOverlay() {
      return false;
   }

   public OverlaySettings getOverlaySettings() {
      return null;
   }

   public boolean isActivityStartable(Uri var1) {
      return true;
   }

   public boolean isExpandingToUrl() {
      return false;
   }

   public boolean isHandlingMMVideo(Uri var1) {
      return false;
   }

   public void startingActivity(Uri var1) {
      MMLog.d("HttpRedirection", String.format("Starting activity for %s", new Object[]{var1}));
   }

   public void startingVideo() {
   }

   public void updateLastVideoViewedTime() {
   }
}
