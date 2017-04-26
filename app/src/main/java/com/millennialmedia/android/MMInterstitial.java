package com.millennialmedia.android;

import android.content.Context;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMInterstitial$MMInterstitialAdImpl;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.MMSDK$Event;
import com.millennialmedia.android.RequestListener;

public final class MMInterstitial implements MMAd {
   private static final String TAG = "MMInterstitial";
   MMAdImpl adImpl;
   int externalId;

   public MMInterstitial(Context var1) {
      this.adImpl = new MMInterstitial$MMInterstitialAdImpl(this, var1.getApplicationContext());
      this.adImpl.adType = "i";
   }

   private void fetchInternal() {
      if(this.isAdAvailable()) {
         MMLog.d("MMInterstitial", "Ad already fetched and ready for display...");
         MMSDK$Event.requestFailed(this.adImpl, new MMException(17));
      } else {
         MMLog.d("MMInterstitial", "Fetching new ad...");
         this.adImpl.requestAd();
      }
   }

   public final boolean display() {
      return this.display(false);
   }

   public final boolean display(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   final int displayInternal() {
      try {
         MMAdImplController.assignAdViewController(this.adImpl);
         if(this.adImpl.controller != null) {
            int var1 = this.adImpl.controller.display(this.adImpl);
            return var1;
         }
      } catch (Exception var3) {
         MMLog.e("MMInterstitial", "There was an exception displaying a cached ad. ", var3);
         var3.printStackTrace();
      }

      return 100;
   }

   public final void fetch() {
      if(this.adImpl != null && this.adImpl.requestListener != null) {
         this.fetch(this.adImpl.mmRequest, this.adImpl.requestListener);
      } else {
         this.fetchInternal();
      }
   }

   public final void fetch(MMRequest var1) {
      if(this.adImpl != null && this.adImpl.requestListener != null) {
         this.fetch(var1, this.adImpl.requestListener);
      } else {
         this.fetchInternal();
      }
   }

   public final void fetch(MMRequest var1, RequestListener var2) {
      if(this.adImpl != null) {
         this.adImpl.mmRequest = var1;
         this.adImpl.requestListener = var2;
      }

      this.fetchInternal();
   }

   public final String getApid() {
      return this.adImpl.getApid();
   }

   public final boolean getIgnoresDensityScaling() {
      return this.adImpl.getIgnoresDensityScaling();
   }

   public final RequestListener getListener() {
      return this.adImpl.getListener();
   }

   public final MMRequest getMMRequest() {
      return this.adImpl.getMMRequest();
   }

   public final boolean isAdAvailable() {
      if(!MMSDK.isUiThread()) {
         MMLog.e("MMInterstitial", MMException.getErrorCodeMessage(3));
      } else {
         int var1;
         try {
            MMAdImplController.assignAdViewController(this.adImpl);
            if(this.adImpl.controller == null) {
               return false;
            }

            var1 = this.adImpl.controller.isAdAvailable(this.adImpl);
         } catch (Exception var3) {
            MMLog.e("MMInterstitial", "There was an exception checking for a cached ad. ", var3);
            var3.printStackTrace();
            return false;
         }

         if(var1 == 0) {
            return true;
         }
      }

      return false;
   }

   public final void setApid(String var1) {
      this.adImpl.setApid(var1);
   }

   public final void setIgnoresDensityScaling(boolean var1) {
      this.adImpl.setIgnoresDensityScaling(var1);
   }

   public final void setListener(RequestListener var1) {
      this.adImpl.setListener(var1);
   }

   public final void setMMRequest(MMRequest var1) {
      this.adImpl.setMMRequest(var1);
   }
}
