package com.millennialmedia.android;

import com.millennialmedia.android.CachedVideoPlayerActivity;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMWebViewClient$MMWebViewClientListener;
import java.lang.ref.WeakReference;

class CachedVideoPlayerActivity$CachedVideoWebViewClientListener extends MMWebViewClient$MMWebViewClientListener {
   WeakReference activityRef;

   CachedVideoPlayerActivity$CachedVideoWebViewClientListener(CachedVideoPlayerActivity var1) {
      this.activityRef = new WeakReference(var1);
   }

   public void onPageFinished(String var1) {
      MMLog.d("CachedVideoPlayerActivity", "@@ ON PAGE FINISHED" + var1);
      CachedVideoPlayerActivity var2 = (CachedVideoPlayerActivity)this.activityRef.get();
      if(var2 != null) {
         CachedVideoPlayerActivity.access$000(var2, var1);
      }

   }
}
