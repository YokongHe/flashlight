package com.mopub.mraid;

import android.content.Context;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.factories.MraidControllerFactory;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidController$MraidListener;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;
import java.util.Map;

class MraidBanner extends CustomEventBanner {
   private CustomEventBanner$CustomEventBannerListener mBannerListener;
   private MraidWebViewDebugListener mDebugListener;
   private MraidController mMraidController;

   private boolean extrasAreValid(Map var1) {
      return var1.containsKey("Html-Response-Body");
   }

   protected void loadBanner(Context var1, CustomEventBanner$CustomEventBannerListener var2, Map var3, Map var4) {
      this.mBannerListener = var2;
      if(this.extrasAreValid(var4)) {
         String var6 = (String)var4.get("Html-Response-Body");

         try {
            this.mMraidController = MraidControllerFactory.create(var1, (AdReport)var3.get("mopub-intent-ad-report"), PlacementType.INLINE);
         } catch (ClassCastException var5) {
            MoPubLog.w("MRAID banner creating failed:", var5);
            this.mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
            return;
         }

         this.mMraidController.setDebugListener(this.mDebugListener);
         this.mMraidController.setMraidListener(new MraidController$MraidListener() {
            public void onClose() {
               MraidBanner.this.mBannerListener.onBannerCollapsed();
            }

            public void onExpand() {
               MraidBanner.this.mBannerListener.onBannerExpanded();
               MraidBanner.this.mBannerListener.onBannerClicked();
            }

            public void onFailedToLoad() {
               MraidBanner.this.mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
            }

            public void onLoaded(View var1) {
               AdViewController.setShouldHonorServerDimensions(var1);
               MraidBanner.this.mBannerListener.onBannerLoaded(var1);
            }

            public void onOpen() {
               MraidBanner.this.mBannerListener.onBannerClicked();
            }
         });
         this.mMraidController.loadContent(var6);
      } else {
         this.mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
      }
   }

   protected void onInvalidate() {
      if(this.mMraidController != null) {
         this.mMraidController.setMraidListener((MraidController$MraidListener)null);
         this.mMraidController.destroy();
      }

   }

   @VisibleForTesting
   public void setDebugListener(MraidWebViewDebugListener var1) {
      this.mDebugListener = var1;
      if(this.mMraidController != null) {
         this.mMraidController.setDebugListener(var1);
      }

   }
}
