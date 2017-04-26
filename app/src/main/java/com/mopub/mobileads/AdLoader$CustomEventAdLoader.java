package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.AdLoader;
import com.mopub.mobileads.AdViewController;
import java.util.Map;

class AdLoader$CustomEventAdLoader extends AdLoader {
   private String mCustomEventClassName;
   private Map mServerExtras;

   public AdLoader$CustomEventAdLoader(AdViewController var1, String var2, Map var3) {
      super(var1);
      this.mCustomEventClassName = var2;
      this.mServerExtras = var3;
   }

   @VisibleForTesting
   Map getServerExtras() {
      return this.mServerExtras;
   }

   void load() {
      AdViewController var1 = (AdViewController)this.mWeakAdViewController.get();
      if(var1 != null && !var1.isDestroyed() && !TextUtils.isEmpty(this.mCustomEventClassName)) {
         var1.setNotLoading();
         var1.getMoPubView().loadCustomEvent(this.mCustomEventClassName, this.mServerExtras);
      }
   }
}
