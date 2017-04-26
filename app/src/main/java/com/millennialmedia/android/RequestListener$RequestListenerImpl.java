package com.millennialmedia.android;

import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.RequestListener;

public class RequestListener$RequestListenerImpl implements RequestListener {
   public void MMAdOverlayClosed(MMAd var1) {
      MMLog.i("MMSDK", "Millennial Media Ad View overlay closed");
   }

   public void MMAdOverlayLaunched(MMAd var1) {
      MMLog.i("MMSDK", "Millennial Media Ad View overlay launched");
   }

   public void MMAdRequestIsCaching(MMAd var1) {
      MMLog.i("MMSDK", "Millennial Media Ad View caching request");
   }

   public void onSingleTap(MMAd var1) {
      MMLog.i("MMSDK", "Ad tapped");
   }

   public void requestCompleted(MMAd var1) {
      MMLog.i("MMSDK", "Ad request succeeded");
   }

   public void requestFailed(MMAd var1, MMException var2) {
      MMLog.i("MMSDK", String.format("Ad request failed with error: %d %s.", new Object[]{Integer.valueOf(var2.getCode()), var2.getMessage()}));
   }
}
