package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.Constants;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubClientPositioning;
import com.mopub.nativeads.PositioningRequest;
import com.mopub.nativeads.PositioningSource;
import com.mopub.nativeads.PositioningSource$PositioningListener;
import com.mopub.nativeads.PositioningUrlGenerator;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError$Reason;
import com.mopub.network.Networking;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.VolleyError;

class ServerPositioningSource implements PositioningSource {
   private static final double DEFAULT_RETRY_TIME_MILLISECONDS = 1000.0D;
   private static final double EXPONENTIAL_BACKOFF_FACTOR = 2.0D;
   @VisibleForTesting
   static int MAXIMUM_RETRY_TIME_MILLISECONDS = 300000;
   private final Context mContext;
   private final Response$ErrorListener mErrorListener;
   private PositioningSource$PositioningListener mListener;
   private final Response$Listener mPositioningListener;
   private PositioningRequest mRequest;
   private int mRetryCount;
   private final Handler mRetryHandler;
   private final Runnable mRetryRunnable;
   private String mRetryUrl;

   ServerPositioningSource(Context var1) {
      this.mContext = var1.getApplicationContext();
      this.mRetryHandler = new Handler();
      this.mRetryRunnable = new Runnable() {
         public void run() {
            ServerPositioningSource.this.requestPositioningInternal();
         }
      };
      this.mPositioningListener = new Response$Listener() {
         public void onResponse(MoPubNativeAdPositioning$MoPubClientPositioning var1) {
            ServerPositioningSource.this.handleSuccess(var1);
         }
      };
      this.mErrorListener = new Response$ErrorListener() {
         public void onErrorResponse(VolleyError var1) {
            if(!(var1 instanceof MoPubNetworkError) || ((MoPubNetworkError)var1).getReason().equals(MoPubNetworkError$Reason.WARMING_UP)) {
               MoPubLog.e("Failed to load positioning data", var1);
            }

            ServerPositioningSource.this.handleFailure();
         }
      };
   }

   private void handleFailure() {
      int var1 = (int)(Math.pow(2.0D, (double)(this.mRetryCount + 1)) * 1000.0D);
      if(var1 >= MAXIMUM_RETRY_TIME_MILLISECONDS) {
         MoPubLog.d("Error downloading positioning information");
         if(this.mListener != null) {
            this.mListener.onFailed();
         }

         this.mListener = null;
      } else {
         ++this.mRetryCount;
         this.mRetryHandler.postDelayed(this.mRetryRunnable, (long)var1);
      }
   }

   private void handleSuccess(MoPubNativeAdPositioning$MoPubClientPositioning var1) {
      if(this.mListener != null) {
         this.mListener.onLoad(var1);
      }

      this.mListener = null;
      this.mRetryCount = 0;
   }

   private void requestPositioningInternal() {
      MoPubLog.d("Loading positioning from: " + this.mRetryUrl);
      this.mRequest = new PositioningRequest(this.mRetryUrl, this.mPositioningListener, this.mErrorListener);
      Networking.getRequestQueue(this.mContext).add(this.mRequest);
   }

   public void loadPositions(String var1, PositioningSource$PositioningListener var2) {
      if(this.mRequest != null) {
         this.mRequest.cancel();
         this.mRequest = null;
      }

      if(this.mRetryCount > 0) {
         this.mRetryHandler.removeCallbacks(this.mRetryRunnable);
         this.mRetryCount = 0;
      }

      this.mListener = var2;
      this.mRetryUrl = (new PositioningUrlGenerator(this.mContext)).withAdUnitId(var1).generateUrlString(Constants.HOST);
      this.requestPositioningInternal();
   }
}
