package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdControllerFactory;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdLoader;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdProperties$AdType;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.DefaultAdListener;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.InterstitialAd$InterstitialAdControlCallback;
import com.amazon.device.ads.InterstitialAdActivityAdapter;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector;
import java.util.concurrent.atomic.AtomicBoolean;

public class InterstitialAd implements Ad {
   protected static final String ACTION_INTERSTITIAL_DISMISSED = "dismissed";
   protected static final String ACTION_INTERSTITIAL_FINISHED_LOADING = "finished";
   protected static final String BROADCAST_ACTION = "action";
   protected static final String BROADCAST_CREATIVE = "creative";
   protected static final String BROADCAST_INTENT = "amazon.mobile.ads.interstitial";
   protected static final String BROADCAST_UNIQUE_IDENTIFIER_KEY = "uniqueIdentifier";
   private static final String LOG_TAG = "InterstitialAd";
   protected static final String MSG_PREPARE_AD_DESTROYED = "This interstitial ad has been destroyed and can no longer be used. Create a new InterstitialAd object to load a new ad.";
   protected static final String MSG_PREPARE_AD_LOADING = "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.";
   protected static final String MSG_PREPARE_AD_READY_TO_SHOW = "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.";
   protected static final String MSG_PREPARE_AD_SHOWING = "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.";
   protected static final String MSG_SHOW_AD_ANOTHER_SHOWING = "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad.";
   protected static final String MSG_SHOW_AD_DESTROYED = "The interstitial ad cannot be shown because it has been destroyed. Create a new InterstitialAd object to load a new ad.";
   protected static final String MSG_SHOW_AD_DISMISSED = "The interstitial ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad.";
   protected static final String MSG_SHOW_AD_EXPIRED = "This interstitial ad has expired. Please load another ad.";
   protected static final String MSG_SHOW_AD_LOADING = "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.";
   protected static final String MSG_SHOW_AD_READY_TO_LOAD = "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.";
   protected static final String MSG_SHOW_AD_SHOWING = "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad.";
   private static final AtomicBoolean isAdShowing = new AtomicBoolean(false);
   private final Activity activity;
   private AdController adController;
   private AdListener adListener = null;
   private boolean isInitialized = false;
   private boolean isThisAdShowing = false;
   private int timeout = 20000;

   public InterstitialAd(Activity var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("InterstitialAd requires a non-null Activity");
      } else {
         this.activity = var1;
      }
   }

   // $FF: synthetic method
   static void access$100(InterstitialAd var0) {
      var0.setAdditionalMetrics();
   }

   // $FF: synthetic method
   static AdController access$200(InterstitialAd var0) {
      return var0.getAdController();
   }

   // $FF: synthetic method
   static AdController access$302(InterstitialAd var0, AdController var1) {
      var0.adController = var1;
      return var1;
   }

   // $FF: synthetic method
   static MetricsCollector access$400(InterstitialAd var0) {
      return var0.getMetricsCollector();
   }

   private void callOnAdLoaded(AdProperties var1) {
      this.adListener.onAdLoaded(this, var1);
   }

   private void clearCachedAdController() {
      AdControllerFactory.removeCachedAdController();
   }

   private AdController getAdController() {
      this.initializeIfNecessary();
      if(this.adController == null) {
         this.initializeAdController();
      }

      return this.adController;
   }

   private MetricsCollector getMetricsCollector() {
      return this.getAdController().getMetricsCollector();
   }

   private void initializeAdController() {
      this.setAdController(this.createAdController(this.activity));
   }

   private void initializeIfNecessary() {
      if(!this.isInitialized()) {
         this.isInitialized = true;
         InternalAdRegistration.getInstance().contextReceived(this.activity.getApplicationContext());
         if(this.adListener == null) {
            this.adListener = new DefaultAdListener("InterstitialAd");
         }

         this.initializeAdController();
         this.setAdditionalMetrics();
      }
   }

   public static boolean isAdShowing() {
      return isAdShowing.get();
   }

   private boolean isInitialized() {
      return this.isInitialized;
   }

   static void resetIsAdShowing() {
      isAdShowing.set(false);
   }

   private void setAdController(AdController var1) {
      this.adController = var1;
      var1.setCallback(this.constructAdControlCallback());
   }

   private void setAdditionalMetrics() {
      this.getMetricsCollector().setAdType(AdProperties$AdType.INTERSTITIAL);
      this.getMetricsCollector().incrementMetric(Metrics$MetricType.AD_IS_INTERSTITIAL);
   }

   void callOnAdDismissed() {
      this.adListener.onAdDismissed(this);
   }

   void callOnAdDismissedOnMainThread() {
      (new Handler(this.activity.getApplicationContext().getMainLooper())).post(new Runnable() {
         public void run() {
            InterstitialAd.this.callOnAdDismissed();
            InterstitialAd.this.submitAndResetMetrics();
         }
      });
   }

   void callOnAdFailedOnMainThread(final AdError var1) {
      (new Handler(this.activity.getApplicationContext().getMainLooper())).post(new Runnable() {
         public void run() {
            InterstitialAd.this.callOnAdFailedToLoad(var1);
         }
      });
   }

   void callOnAdFailedToLoad(AdError var1) {
      this.adListener.onAdFailedToLoad(this, var1);
   }

   void callOnAdLoadedOnMainThread(final AdProperties var1) {
      (new Handler(this.activity.getApplicationContext().getMainLooper())).post(new Runnable() {
         public void run() {
            InterstitialAd.this.callOnAdLoaded(var1);
         }
      });
   }

   AdControlCallback constructAdControlCallback() {
      return new InterstitialAd$InterstitialAdControlCallback(this);
   }

   AdController createAdController(Activity var1) {
      return AdControllerFactory.buildAdController(var1, AdSize.SIZE_INTERSTITIAL);
   }

   boolean didAdActivityFail() {
      boolean var1;
      if(this.isThisAdShowing && !isAdShowing.get()) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(var1) {
         this.getMetricsCollector().incrementMetric(Metrics$MetricType.INTERSTITIAL_AD_ACTIVITY_FAILED);
         this.getAdController().closeAd();
      }

      return var1;
   }

   AdListener getAdListener() {
      return this.adListener;
   }

   public int getTimeout() {
      return this.timeout;
   }

   void handleDismissed() {
      this.getMetricsCollector().stopMetric(Metrics$MetricType.AD_SHOW_DURATION);
      AdControllerFactory.removeCachedAdController();
      isAdShowing.set(false);
      this.isThisAdShowing = false;
      this.callOnAdDismissedOnMainThread();
   }

   public boolean isLoading() {
      return this.getAdController().getAdState().equals(AdState.LOADING) || this.getAdController().getAdState().equals(AdState.LOADED) || this.getAdController().getAdState().equals(AdState.RENDERING);
   }

   boolean isReadyToLoad() {
      return this.getAdController().getAdState().equals(AdState.READY_TO_LOAD);
   }

   boolean isReadyToShow() {
      return this.getAdController().getAdState().equals(AdState.RENDERED);
   }

   public boolean isShowing() {
      return this.getAdController().getAdState().equals(AdState.SHOWING);
   }

   public boolean loadAd() {
      return this.loadAd((AdTargetingOptions)null);
   }

   public boolean loadAd(AdTargetingOptions var1) {
      this.didAdActivityFail();
      if(!this.isReadyToLoad()) {
         switch(null.$SwitchMap$com$amazon$device$ads$AdState[this.getAdController().getAdState().ordinal()]) {
         case 1:
            Log.d("InterstitialAd", "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.");
            return false;
         case 2:
            Log.d("InterstitialAd", "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.");
            return false;
         case 3:
            Log.e("InterstitialAd", "An interstitial ad could not be loaded because of an unknown issue with the web views.");
            return false;
         case 4:
            Log.e("InterstitialAd", "An interstitial ad could not be loaded because the view has been destroyed.");
            return false;
         default:
            Log.d("InterstitialAd", "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.");
            return false;
         }
      } else {
         AdLoader.loadAds(this.getTimeout(), var1, new AdSlot[]{new AdSlot(this.getAdController(), var1)});
         return this.getAdController().getAndResetIsPrepared();
      }
   }

   public void setListener(AdListener var1) {
      if(var1 == null) {
         this.adListener = new DefaultAdListener("InterstitialAd");
      } else {
         this.adListener = var1;
      }
   }

   public void setTimeout(int var1) {
      this.timeout = var1;
   }

   public boolean showAd() {
      if(this.didAdActivityFail()) {
         Log.e("InterstitialAd", "The ad could not be shown because it previously failed to show. Please load a new ad.");
         return false;
      } else {
         long var1 = System.nanoTime();
         if(this.isReadyToShow()) {
            if(this.getAdController().isExpired()) {
               Log.w("InterstitialAd", "This interstitial ad has expired. Please load another ad.");
               this.getAdController().resetToReady();
               return false;
            } else if(isAdShowing.getAndSet(true)) {
               Log.w("InterstitialAd", "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad.");
               return false;
            } else {
               this.isThisAdShowing = true;
               this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOADED_TO_AD_SHOW_TIME, var1);
               this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_SHOW_DURATION, var1);
               AdControllerFactory.cacheAdController(this.getAdController());
               this.getMetricsCollector().startMetric(Metrics$MetricType.AD_SHOW_LATENCY);
               boolean var3 = this.showAdInActivity();
               if(!var3) {
                  AdControllerFactory.removeCachedAdController();
                  this.getAdController().resetToReady();
                  isAdShowing.set(false);
                  this.isThisAdShowing = false;
                  this.getMetricsCollector().stopMetric(Metrics$MetricType.AD_LATENCY_RENDER_FAILED);
               }

               return var3;
            }
         } else if(this.isReadyToLoad()) {
            Log.w("InterstitialAd", "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.");
            return false;
         } else if(this.isLoading()) {
            Log.w("InterstitialAd", "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.");
            return false;
         } else if(this.isShowing()) {
            Log.w("InterstitialAd", "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad.");
            return false;
         } else {
            Log.w("InterstitialAd", "An interstitial ad is not ready to show.");
            return false;
         }
      }
   }

   boolean showAdInActivity() {
      try {
         Intent var1 = new Intent(this.activity.getApplicationContext(), AdActivity.class);
         var1.putExtra("adapter", InterstitialAdActivityAdapter.class.getName());
         this.activity.startActivity(var1);
         return true;
      } catch (ActivityNotFoundException var2) {
         Log.e("InterstitialAd", "Failed to show the interstitial ad because AdActivity could not be found.");
         return false;
      }
   }

   void submitAndResetMetrics() {
      if(this.getMetricsCollector() != null && !this.getMetricsCollector().isMetricsCollectorEmpty()) {
         this.setAdditionalMetrics();
         this.getAdController().submitAndResetMetricsIfNecessary(true);
      }

   }
}
