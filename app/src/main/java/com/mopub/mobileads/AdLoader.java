package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLoader$CustomEventAdLoader;
import com.mopub.mobileads.AdViewController;
import com.mopub.network.AdResponse;
import java.lang.ref.WeakReference;

abstract class AdLoader {
   WeakReference mWeakAdViewController;

   AdLoader(AdViewController var1) {
      this.mWeakAdViewController = new WeakReference(var1);
   }

   static AdLoader fromAdResponse(AdResponse var0, AdViewController var1) {
      MoPubLog.i("Performing custom event.");
      String var2 = var0.getCustomEventClassName();
      if(var2 != null) {
         return new AdLoader$CustomEventAdLoader(var1, var2, var0.getServerExtras());
      } else {
         MoPubLog.i("Failed to create custom event.");
         return null;
      }
   }

   abstract void load();
}
