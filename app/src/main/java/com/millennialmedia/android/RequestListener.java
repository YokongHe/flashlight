package com.millennialmedia.android;

import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;

public interface RequestListener {
   void MMAdOverlayClosed(MMAd var1);

   void MMAdOverlayLaunched(MMAd var1);

   void MMAdRequestIsCaching(MMAd var1);

   void onSingleTap(MMAd var1);

   void requestCompleted(MMAd var1);

   void requestFailed(MMAd var1, MMException var2);
}
