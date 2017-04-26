package com.mopub.nativeads;

import android.os.Handler;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubClientPositioning;
import com.mopub.nativeads.PositioningSource;
import com.mopub.nativeads.PositioningSource$PositioningListener;

class ClientPositioningSource implements PositioningSource {
   private final Handler mHandler = new Handler();
   private final MoPubNativeAdPositioning$MoPubClientPositioning mPositioning;

   ClientPositioningSource(MoPubNativeAdPositioning$MoPubClientPositioning var1) {
      this.mPositioning = MoPubNativeAdPositioning.clone(var1);
   }

   public void loadPositions(String var1, final PositioningSource$PositioningListener var2) {
      this.mHandler.post(new Runnable() {
         public void run() {
            var2.onLoad(ClientPositioningSource.this.mPositioning);
         }
      });
   }
}
