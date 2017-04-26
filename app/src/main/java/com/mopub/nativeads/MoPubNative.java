package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.common.AdFormat;
import com.mopub.common.Constants;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper$GpsHelperListener;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;
import com.mopub.nativeads.CustomEventNative$CustomEventNativeListener;
import com.mopub.nativeads.CustomEventNativeAdapter;
import com.mopub.nativeads.MoPubNative$MoPubNativeEventListener;
import com.mopub.nativeads.MoPubNative$MoPubNativeListener;
import com.mopub.nativeads.MoPubNative$MoPubNativeNetworkListener;
import com.mopub.nativeads.NativeAdInterface;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.NativeUrlGenerator;
import com.mopub.nativeads.RequestParameters;
import com.mopub.network.AdRequest;
import com.mopub.network.AdRequest$Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError$Reason;
import com.mopub.network.Networking;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.TreeMap;

public class MoPubNative {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$mopub$network$MoPubNetworkError$Reason;
   static final MoPubNative$MoPubNativeEventListener EMPTY_EVENT_LISTENER = new MoPubNative$MoPubNativeEventListener() {
      public void onNativeClick(View var1) {
      }

      public void onNativeImpression(View var1) {
      }
   };
   static final MoPubNative$MoPubNativeNetworkListener EMPTY_NETWORK_LISTENER = new MoPubNative$MoPubNativeNetworkListener() {
      public void onNativeFail(NativeErrorCode var1) {
      }

      public void onNativeLoad(NativeResponse var1) {
         var1.destroy();
      }
   };
   private final String mAdUnitId;
   private final WeakReference mContext;
   private Map mLocalExtras;
   private MoPubNative$MoPubNativeEventListener mMoPubNativeEventListener;
   private MoPubNative$MoPubNativeNetworkListener mMoPubNativeNetworkListener;
   private AdRequest mNativeRequest;
   private final AdRequest$Listener mVolleyListener;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$mopub$network$MoPubNetworkError$Reason() {
      int[] var0 = $SWITCH_TABLE$com$mopub$network$MoPubNetworkError$Reason;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[MoPubNetworkError$Reason.values().length];

         try {
            var0[MoPubNetworkError$Reason.BAD_BODY.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            var0[MoPubNetworkError$Reason.BAD_HEADER_DATA.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[MoPubNetworkError$Reason.NO_FILL.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[MoPubNetworkError$Reason.TRACKING_FAILURE.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[MoPubNetworkError$Reason.UNSPECIFIED.ordinal()] = 6;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[MoPubNetworkError$Reason.WARMING_UP.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$mopub$network$MoPubNetworkError$Reason = var0;
         return var0;
      }
   }

   @Deprecated
   public MoPubNative(Context var1, String var2, MoPubNative$MoPubNativeListener var3) {
      this(var1, var2, (MoPubNative$MoPubNativeNetworkListener)var3);
      this.setNativeEventListener(var3);
   }

   public MoPubNative(Context var1, String var2, MoPubNative$MoPubNativeNetworkListener var3) {
      this.mLocalExtras = new TreeMap();
      Preconditions.checkNotNull(var1, "Context may not be null.");
      Preconditions.checkNotNull(var2, "AdUnitId may not be null.");
      Preconditions.checkNotNull(var3, "MoPubNativeNetworkListener may not be null.");
      ManifestUtils.checkNativeActivitiesDeclared(var1);
      this.mContext = new WeakReference(var1);
      this.mAdUnitId = var2;
      this.mMoPubNativeNetworkListener = var3;
      this.mMoPubNativeEventListener = EMPTY_EVENT_LISTENER;
      this.mVolleyListener = new AdRequest$Listener() {
         public void onErrorResponse(VolleyError var1) {
            MoPubNative.this.onAdError(var1);
         }

         public void onSuccess(AdResponse var1) {
            MoPubNative.this.onAdLoad(var1);
         }
      };
      GpsHelper.fetchAdvertisingInfoAsync(var1, (GpsHelper$GpsHelperListener)null);
   }

   private void loadNativeAd(RequestParameters var1, Integer var2) {
      Context var3 = this.getContextOrDestroy();
      if(var3 != null) {
         NativeUrlGenerator var4 = (new NativeUrlGenerator(var3)).withAdUnitId(this.mAdUnitId).withRequest(var1);
         if(var2 != null) {
            var4.withSequenceNumber(var2.intValue());
         }

         String var5 = var4.generateUrlString(Constants.HOST);
         if(var5 != null) {
            MoPubLog.d("Loading ad from: " + var5);
         }

         this.requestNativeAd(var5);
      }
   }

   private void onAdLoad(final AdResponse var1) {
      Context var2 = this.getContextOrDestroy();
      if(var2 != null) {
         CustomEventNative$CustomEventNativeListener var3 = new CustomEventNative$CustomEventNativeListener() {
            public void onNativeAdFailed(NativeErrorCode var1x) {
               MoPubNative.this.requestNativeAd(var1.getFailoverUrl());
            }

            public void onNativeAdLoaded(NativeAdInterface var1x) {
               Context var2 = MoPubNative.this.getContextOrDestroy();
               if(var2 != null) {
                  MoPubNative.this.mMoPubNativeNetworkListener.onNativeLoad(new NativeResponse(var2, var1.getImpressionTrackingUrl(), var1.getClickTrackingUrl(), MoPubNative.this.mAdUnitId, var1x, MoPubNative.this.mMoPubNativeEventListener));
               }
            }
         };
         CustomEventNativeAdapter.loadNativeAd(var2, this.mLocalExtras, var1, var3);
      }
   }

   public void destroy() {
      this.mContext.clear();
      if(this.mNativeRequest != null) {
         this.mNativeRequest.cancel();
         this.mNativeRequest = null;
      }

      this.mMoPubNativeNetworkListener = EMPTY_NETWORK_LISTENER;
      this.mMoPubNativeEventListener = EMPTY_EVENT_LISTENER;
   }

   Context getContextOrDestroy() {
      Context var1 = (Context)this.mContext.get();
      if(var1 == null) {
         this.destroy();
         MoPubLog.d("Weak reference to Activity Context in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed.");
      }

      return var1;
   }

   @Deprecated
   @VisibleForTesting
   MoPubNative$MoPubNativeEventListener getMoPubNativeEventListener() {
      return this.mMoPubNativeEventListener;
   }

   @Deprecated
   @VisibleForTesting
   MoPubNative$MoPubNativeNetworkListener getMoPubNativeNetworkListener() {
      return this.mMoPubNativeNetworkListener;
   }

   public void makeRequest() {
      this.makeRequest((RequestParameters)null);
   }

   public void makeRequest(RequestParameters var1) {
      this.makeRequest(var1, (Integer)null);
   }

   public void makeRequest(RequestParameters var1, Integer var2) {
      Context var3 = this.getContextOrDestroy();
      if(var3 != null) {
         if(!DeviceUtils.isNetworkAvailable(var3)) {
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
         } else {
            this.loadNativeAd(var1, var2);
         }
      }
   }

   @VisibleForTesting
   void onAdError(VolleyError var1) {
      MoPubLog.d("Native ad request failed.", var1);
      if(var1 instanceof MoPubNetworkError) {
         MoPubNetworkError var3 = (MoPubNetworkError)var1;
         switch($SWITCH_TABLE$com$mopub$network$MoPubNetworkError$Reason()[var3.getReason().ordinal()]) {
         case 1:
         case 2:
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
            return;
         case 3:
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.INVALID_JSON);
            return;
         case 4:
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.INVALID_JSON);
            return;
         default:
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.UNSPECIFIED);
         }
      } else {
         NetworkResponse var2 = var1.networkResponse;
         if(var2 != null && var2.statusCode >= 500 && var2.statusCode < 600) {
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
         } else {
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.UNSPECIFIED);
         }
      }
   }

   void requestNativeAd(String var1) {
      Context var2 = this.getContextOrDestroy();
      if(var2 != null) {
         if(var1 == null) {
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.INVALID_REQUEST_URL);
         } else {
            this.mNativeRequest = new AdRequest(var1, AdFormat.NATIVE, this.mVolleyListener);
            Networking.getRequestQueue(var2).add(this.mNativeRequest);
         }
      }
   }

   public void setLocalExtras(Map var1) {
      if(var1 == null) {
         this.mLocalExtras = new TreeMap();
      } else {
         this.mLocalExtras = new TreeMap(var1);
      }
   }

   public void setNativeEventListener(MoPubNative$MoPubNativeEventListener var1) {
      MoPubNative$MoPubNativeEventListener var2 = var1;
      if(var1 == null) {
         var2 = EMPTY_EVENT_LISTENER;
      }

      this.mMoPubNativeEventListener = var2;
   }
}
