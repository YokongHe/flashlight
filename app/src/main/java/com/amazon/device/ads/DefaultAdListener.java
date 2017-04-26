package com.amazon.device.ads;

import android.graphics.Rect;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.ExtendedAdListener;
import com.amazon.device.ads.Log;

public class DefaultAdListener implements ExtendedAdListener {
   final String LOG_TAG;

   public DefaultAdListener() {
      this(DefaultAdListener.class.getSimpleName());
   }

   DefaultAdListener(String var1) {
      this.LOG_TAG = var1;
   }

   public void onAdCollapsed(Ad var1) {
      Log.d(this.LOG_TAG, "Default ad listener called - Ad Collapsed.");
   }

   public void onAdDismissed(Ad var1) {
      Log.d(this.LOG_TAG, "Default ad listener called - Ad Dismissed.");
   }

   public void onAdExpanded(Ad var1) {
      Log.d(this.LOG_TAG, "Default ad listener called - Ad Will Expand.");
   }

   public void onAdFailedToLoad(Ad var1, AdError var2) {
      Log.d(this.LOG_TAG, "Default ad listener called - Ad Failed to Load. Error code: %s, Error Message: %s", new Object[]{var2.getCode(), var2.getMessage()});
   }

   public void onAdLoaded(Ad var1, AdProperties var2) {
      Log.d(this.LOG_TAG, "Default ad listener called - AdLoaded.");
   }

   public void onAdResized(Rect var1) {
      Log.d(this.LOG_TAG, "Default ad listener called - Ad Resized.");
   }
}
