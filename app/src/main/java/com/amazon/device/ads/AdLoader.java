package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdError$ErrorCode;
import com.amazon.device.ads.AdLoader$AdFetchException;
import com.amazon.device.ads.AdLoader$AdLoaderFactory;
import com.amazon.device.ads.AdRequest;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.AdvertisingIdentifier$Info;
import com.amazon.device.ads.Assets;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MetricsCollector$CompositeMetricsCollector;
import com.amazon.device.ads.StartUpWaiter;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$WebRequestException;
import com.amazon.device.ads.WebRequest$WebRequestStatus;
import com.amazon.device.ads.WebRequest$WebResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
class AdLoader {
   public static final int AD_FAILED = -1;
   public static final int AD_LOAD_DEFERRED = 1;
   public static final int AD_READY_TO_LOAD = 0;
   private static final String DISABLED_APP_SERVER_MESSAGE = "DISABLED_APP";
   protected static final String LOG_TAG = AdLoader.class.getSimpleName();
   private static AdLoader$AdLoaderFactory adLoaderFactory = new AdLoader$AdLoaderFactory();
   protected final AdRequest adRequest;
   protected MetricsCollector$CompositeMetricsCollector compositeMetricsCollector = null;
   protected AdError error = null;
   protected final Map slots;
   protected int timeout = 20000;

   public AdLoader(AdRequest var1, Map var2) {
      this.adRequest = var1;
      this.slots = var2;
   }

   private static void beginFetchAds(int var0, AdTargetingOptions var1, List var2) {
      AdvertisingIdentifier$Info var5 = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
      if(!var5.canDo()) {
         failAds(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "An internal request was not made on a background thread."), var2);
      } else {
         AdTargetingOptions var4 = var1;
         if(var1 == null) {
            var4 = new AdTargetingOptions();
         }

         AdRequest var6 = (new AdRequest(var4)).setAdvertisingIdentifierInfo(var5);
         HashMap var9 = new HashMap();
         Iterator var8 = var2.iterator();
         int var3 = 1;

         while(var8.hasNext()) {
            AdSlot var10 = (AdSlot)var8.next();
            if(var10.isValid()) {
               var10.setSlotNumber(var3);
               var9.put(Integer.valueOf(var3), var10);
               var6.putSlot(var10);
               ++var3;
            }
         }

         if(var9.size() > 0) {
            AdLoader var7 = adLoaderFactory.createAdLoader(var6, var9);
            var7.setTimeout(var0);
            var7.beginFetchAd();
            return;
         }
      }

   }

   private void beginFinalizeFetchAd() {
      (new Handler(Looper.getMainLooper())).post(new Runnable() {
         public void run() {
            AdLoader.this.finalizeFetchAd();
         }
      });
   }

   private static void failAds(AdError var0, List var1) {
      Iterator var4 = var1.iterator();
      int var2 = 0;

      while(var4.hasNext()) {
         AdSlot var3 = (AdSlot)var4.next();
         if(var3.getSlotNumber() != -1) {
            var3.adFailed(var0);
            ++var2;
         }
      }

      if(var2 > 0) {
         Log.e(LOG_TAG, "%s; code: %s", new Object[]{var0.getMessage(), var0.getCode()});
      }

   }

   private WebRequest getAdRequest() {
      this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
      WebRequest var1 = this.adRequest.getWebRequest();
      this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
      return var1;
   }

   private MetricsCollector getCompositeMetricsCollector() {
      if(this.compositeMetricsCollector == null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.slots.entrySet().iterator();

         while(var2.hasNext()) {
            var1.add(((AdSlot)((Entry)var2.next()).getValue()).getMetricsCollector());
         }

         this.compositeMetricsCollector = new MetricsCollector$CompositeMetricsCollector(var1);
      }

      return this.compositeMetricsCollector;
   }

   private static boolean isNoRetry(AdSlot[] var0) {
      int var1 = InternalAdRegistration.getInstance().getNoRetryTtlRemainingMillis();
      if(var1 > 0) {
         var1 /= 1000;
         String var2;
         AdError$ErrorCode var3;
         if(InternalAdRegistration.getInstance().getIsAppDisabled()) {
            var2 = "SDK Message: " + "DISABLED_APP";
            var3 = AdError$ErrorCode.INTERNAL_ERROR;
         } else {
            var2 = "SDK Message: " + "no results. Try again in " + var1 + " seconds.";
            var3 = AdError$ErrorCode.NO_FILL;
         }

         failAds(new AdError(var3, var2), new ArrayList(Arrays.asList(var0)));
         return true;
      } else {
         return false;
      }
   }

   protected static void loadAds(final int var0, final AdTargetingOptions var1, AdSlot... var2) {
      if(!isNoRetry(var2)) {
         long var5 = System.nanoTime();
         final ArrayList var7 = new ArrayList();
         int var4 = var2.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            AdSlot var8 = var2[var3];
            if(var8.prepareForAdLoad(var5)) {
               var7.add(var8);
            }
         }

         (new StartUpWaiter() {
            protected final void startUpFailed() {
               ThreadUtils.executeOnMainThread(new Runnable() {
                  public void run() {
                     AdLoader.failAds(new AdError(AdError$ErrorCode.NETWORK_ERROR, "The configuration was unable to be loaded"), var7);
                  }
               });
            }

            protected final void startUpReady() {
               InternalAdRegistration.getInstance().register();
               AdLoader.beginFetchAds(var0, var1, var7);
            }
         }).start();
      }
   }

   private void parseResponse(JSONObject param1) {
      // $FF: Couldn't be decompiled
   }

   protected static void setAdLoaderFactory(AdLoader$AdLoaderFactory var0) {
      adLoaderFactory = var0;
   }

   private void setErrorForAllSlots(AdError var1) {
      Iterator var2 = this.slots.values().iterator();

      while(var2.hasNext()) {
         ((AdSlot)var2.next()).setAdError(var1);
      }

   }

   public void beginFetchAd() {
      this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START);
      this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
      this.startFetchAdThread();
   }

   protected void fetchAd() {
      this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
      this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
      if(!Assets.getInstance().ensureAssetsCreated()) {
         this.error = new AdError(AdError$ErrorCode.REQUEST_ERROR, "Unable to create the assets needed to display ads");
         Log.e(LOG_TAG, "Unable to create the assets needed to display ads");
         this.setErrorForAllSlots(this.error);
      } else {
         WebRequest$WebResponse var1;
         try {
            var1 = this.fetchResponseFromNetwork();
         } catch (AdLoader$AdFetchException var2) {
            this.error = var2.getAdError();
            Log.e(LOG_TAG, var2.getAdError().getMessage());
            this.setErrorForAllSlots(this.error);
            return;
         }

         if(!var1.isHttpStatusCodeOK()) {
            String var4 = var1.getHttpStatusCode() + " - " + var1.getHttpStatus();
            this.error = new AdError(AdError$ErrorCode.NETWORK_ERROR, var4);
            Log.e(LOG_TAG, var4);
            this.setErrorForAllSlots(this.error);
         } else {
            JSONObject var3 = var1.getResponseReader().readAsJSON();
            if(var3 == null) {
               this.error = new AdError(AdError$ErrorCode.INTERNAL_ERROR, "Unable to parse response");
               Log.e(LOG_TAG, "Unable to parse response");
               this.setErrorForAllSlots(this.error);
            } else {
               this.parseResponse(var3);
               this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
               this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
            }
         }
      }
   }

   protected WebRequest$WebResponse fetchResponseFromNetwork() {
      WebRequest var1 = this.getAdRequest();
      var1.setMetricsCollector(this.getCompositeMetricsCollector());
      var1.setServiceCallLatencyMetric(Metrics$MetricType.AAX_LATENCY_GET_AD);
      var1.setTimeout(this.timeout);
      var1.setDisconnectEnabled(false);
      this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
      this.getCompositeMetricsCollector().incrementMetric(Metrics$MetricType.TLS_ENABLED);

      WebRequest$WebResponse var4;
      try {
         var4 = var1.makeCall();
      } catch (WebRequest$WebRequestException var2) {
         AdError var3;
         if(var2.getStatus() == WebRequest$WebRequestStatus.NETWORK_FAILURE) {
            var3 = new AdError(AdError$ErrorCode.NETWORK_ERROR, "Could not contact Ad Server");
         } else if(var2.getStatus() == WebRequest$WebRequestStatus.NETWORK_TIMEOUT) {
            var3 = new AdError(AdError$ErrorCode.NETWORK_TIMEOUT, "Connection to Ad Server timed out");
         } else {
            var3 = new AdError(AdError$ErrorCode.INTERNAL_ERROR, var2.getMessage());
         }

         throw new AdLoader$AdFetchException(this, var3);
      }

      this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
      return var4;
   }

   protected void finalizeFetchAd() {
      Iterator var1 = this.slots.entrySet().iterator();

      while(var1.hasNext()) {
         AdSlot var2 = (AdSlot)((Entry)var1.next()).getValue();
         var2.getMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
         if(!var2.isFetched()) {
            var2.getMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE);
            if(var2.getAdError() != null) {
               var2.adFailed(var2.getAdError());
            } else {
               var2.adFailed(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "Unknown error occurred."));
            }
         } else {
            var2.getMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START);
            var2.initializeAd();
         }
      }

   }

   protected AdError getAdError(JSONObject var1) {
      int var2 = this.retrieveNoRetryTtlSeconds(var1);
      InternalAdRegistration.getInstance().setNoRetryTtl(var2);
      String var4 = JSONUtils.getStringFromJSON(var1, "errorMessage", "No Ad Received");
      InternalAdRegistration.getInstance().setIsAppDisabled(var4.equalsIgnoreCase("DISABLED_APP"));
      String var3 = "Server Message: " + var4;
      if(var2 > 0) {
         this.getCompositeMetricsCollector().publishMetricInMilliseconds(Metrics$MetricType.AD_NO_RETRY_TTL_RECEIVED, (long)(var2 * 1000));
      }

      if(var2 > 0 && !InternalAdRegistration.getInstance().getIsAppDisabled()) {
         var4 = var3 + ". Try again in " + var2 + " seconds";
         return new AdError(AdError$ErrorCode.NO_FILL, var4);
      } else {
         return var4.equals("no results")?new AdError(AdError$ErrorCode.NO_FILL, var3):new AdError(AdError$ErrorCode.INTERNAL_ERROR, var3);
      }
   }

   protected int retrieveNoRetryTtlSeconds(JSONObject var1) {
      return DebugProperties.getDebugPropertyAsInteger("debug.noRetryTTL", JSONUtils.getIntegerFromJSON(var1, "noretryTTL", 0));
   }

   public void setTimeout(int var1) {
      this.timeout = var1;
   }

   protected void startFetchAdThread() {
      ThreadUtils.executeRunnable(new Runnable() {
         public void run() {
            AdLoader.this.fetchAd();
            AdLoader.this.beginFinalizeFetchAd();
         }
      });
   }
}
