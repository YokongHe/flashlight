package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import com.amazon.device.ads.AAXCreative;
import com.amazon.device.ads.AdContainer;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController$AdPosition;
import com.amazon.device.ads.AdController$DefaultAdControlCallback;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdError$ErrorCode;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.AdUtils;
import com.amazon.device.ads.AdWebViewClient$UrlExecutor;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.BridgeSelector;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEvent$SDKEventType;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.Size;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebViewFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

class AdController {
   private static final String LOGTAG = "AdController";
   protected static final String MSG_PREPARE_AD_LOADING = "An ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.";
   protected static final String MSG_PREPARE_AD_READY_TO_SHOW = "An ad is ready to show. Please call showAd() to show the ad before loading another ad.";
   protected static final String MSG_PREPARE_AD_SHOWING = "An ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.";
   protected static final String MSG_SHOW_AD_ANOTHER_SHOWING = "Another ad is currently showing. Please wait for the AdListener.onAdDismissed callback of the other ad.";
   protected static final String MSG_SHOW_AD_DESTROYED = "The ad cannot be shown because it has been destroyed. Create a new Ad object to load a new ad.";
   protected static final String MSG_SHOW_AD_DISMISSED = "The ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad.";
   protected static final String MSG_SHOW_AD_EXPIRED = "This ad has expired. Please load another ad.";
   protected static final String MSG_SHOW_AD_LOADING = "The ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.";
   protected static final String MSG_SHOW_AD_READY_TO_LOAD = "The ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.";
   protected static final String MSG_SHOW_AD_SHOWING = "The ad cannot be shown because it is already displayed on the screen. Please wait for the AdListener.onAdDismissed() callback and then load a new ad.";
   private Activity adActivity;
   private AdContainer adContainer;
   private AdControlAccessor adControlAccessor;
   private AdControlCallback adControlCallback;
   private AdData adData;
   private final AdSize adSize;
   private AdState adState;
   private int adWindowHeight = 0;
   private int adWindowWidth = 0;
   private boolean backButtonOverridden;
   private ConnectionInfo connectionInfo;
   private final Context context;
   private ViewGroup defaultParent;
   private boolean disableHardwareAccelerationRequest;
   private boolean forceDisableHardwareAcceleration;
   private final AtomicBoolean hasFinishedLoading;
   private boolean hasNativeCloseButton;
   private final AtomicBoolean isClosing;
   private boolean isPrepared;
   private final AtomicBoolean isRendering;
   private MetricsCollector metricsCollector;
   private int originalOrientation;
   private double scalingMultiplier;
   private final ArrayList sdkEventListeners = new ArrayList();
   private int timeout = 20000;
   private Timer timer;
   private boolean windowDimensionsSet = false;

   AdController(Context var1, AdSize var2) {
      this.adState = AdState.READY_TO_LOAD;
      this.scalingMultiplier = 1.0D;
      this.isPrepared = false;
      this.defaultParent = null;
      this.hasNativeCloseButton = false;
      this.isRendering = new AtomicBoolean(false);
      this.hasFinishedLoading = new AtomicBoolean(false);
      this.isClosing = new AtomicBoolean(false);
      this.disableHardwareAccelerationRequest = false;
      this.forceDisableHardwareAcceleration = false;
      this.backButtonOverridden = false;
      this.context = var1;
      this.adSize = var2;
   }

   private void adFailedAfterTimerCheck(AdError var1) {
      if(this.getMetricsCollector() != null && !this.getMetricsCollector().isMetricsCollectorEmpty()) {
         this.adFailedAfterAdMetricsStart(var1);
      } else {
         this.adFailedBeforeAdMetricsStart(var1);
      }
   }

   private void adLoaded() {
      if(this.canBeUsed()) {
         this.setAdState(AdState.LOADED);
         this.callOnAdLoaded(this.adData.getProperties());
      }
   }

   private int calculateAppChromeHeight(boolean var1, boolean var2) {
      Context var5 = this.getView().getContext();
      int var3;
      int var4;
      if(var5 instanceof Activity) {
         Window var7 = ((Activity)var5).getWindow();
         Rect var6 = new Rect();
         var7.getDecorView().getWindowVisibleDisplayFrame(var6);
         var4 = var6.top;
         var3 = this.getContentViewTop(var7) - var4;
      } else {
         var3 = 0;
         var4 = 0;
      }

      if(!var1) {
         var4 = 0;
      }

      if(!var2) {
         var3 = 0;
      }

      return var3 + var4;
   }

   private void determineShouldForceDisableHardwareAcceleration() {
      if((AndroidTargetUtils.isAndroidAPI(14) || AndroidTargetUtils.isAndroidAPI(15)) && this.adData.getCreativeTypes().contains(AAXCreative.REQUIRES_TRANSPARENCY)) {
         this.forceDisableHardwareAcceleration = true;
      } else {
         this.forceDisableHardwareAcceleration = false;
      }
   }

   private boolean isReadyToLoad(boolean var1) {
      return this.getAdControlCallback().isAdReady(var1);
   }

   private void reset() {
      if(this.canBeUsed()) {
         this.isPrepared = false;
         this.resetMetricsCollector();
         if(this.adContainer != null) {
            this.adContainer.destroy();
            this.adContainer = null;
         }

         this.adData = null;
      }
   }

   private boolean shouldDisableHardwareAcceleration() {
      return this.forceDisableHardwareAcceleration || this.disableHardwareAccelerationRequest;
   }

   void accumulateAdFailureMetrics(AdError var1) {
      long var2 = System.nanoTime();
      this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, var2);
      this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, var2);
      this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_FAILURE, var2);
      if(var1 != null && (AdError$ErrorCode.NO_FILL.equals(var1.getCode()) || AdError$ErrorCode.NETWORK_ERROR.equals(var1.getCode()) || AdError$ErrorCode.NETWORK_TIMEOUT.equals(var1.getCode()) || AdError$ErrorCode.INTERNAL_ERROR.equals(var1.getCode()))) {
         this.getMetricsCollector().incrementMetric(Metrics$MetricType.AD_LOAD_FAILED);
         if(var1.getCode() == AdError$ErrorCode.NETWORK_TIMEOUT) {
            if(this.isRendering.get()) {
               this.getMetricsCollector().incrementMetric(Metrics$MetricType.AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT);
            } else {
               this.getMetricsCollector().incrementMetric(Metrics$MetricType.AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT);
            }
         }
      }

      this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER_FAILED, var2);
      if(this.getAdState().equals(AdState.RENDERING)) {
         this.getMetricsCollector().incrementMetric(Metrics$MetricType.AD_COUNTER_RENDERING_FATAL);
      }

      this.setAdditionalMetrics();
   }

   void adFailed(AdError var1) {
      if(this.canBeUsed() && !this.getAndSetHasFinishedLoading(true)) {
         this.cancelTimer();
         this.adFailedAfterTimerCheck(var1);
         this.setAdState(AdState.READY_TO_LOAD);
      }
   }

   void adFailedAfterAdMetricsStart(AdError var1) {
      this.accumulateAdFailureMetrics(var1);
      this.callOnAdFailedToLoad(var1, true);
   }

   void adFailedBeforeAdMetricsStart(AdError var1) {
      this.callOnAdFailedToLoad(var1, false);
   }

   public void adRendered(String var1) {
      if(this.canBeUsed()) {
         Log.d("AdController", "Ad Rendered");
         if(this.getAdState().equals(AdState.RENDERING) && !this.getAndSetHasFinishedLoading(true)) {
            this.isRendering.set(false);
            this.cancelTimer();
            this.setAdState(AdState.RENDERED);
            this.callOnAdRendered();
            long var2 = System.nanoTime();
            if(this.getMetricsCollector() != null) {
               this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER, var2);
               this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, var2);
               this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_SUCCESS, var2);
               this.setAdditionalMetrics();
               this.submitAndResetMetricsIfNecessary(true);
            }

            this.callPostAdRendered();
         }

         this.fireSDKEvent((new SDKEvent(SDKEvent$SDKEventType.RENDERED)).setParameter("url", var1));
      }
   }

   public void adShown() {
      if(this.canBeUsed()) {
         this.setAdState(AdState.SHOWING);
         this.getMetricsCollector().stopMetric(Metrics$MetricType.AD_SHOW_LATENCY);
         WebRequest.executeWebRequestInThread(this.getAdData().getImpressionPixelUrl(), false);
         if(!this.areWindowDimensionsSet()) {
            this.setWindowDimensions(this.getView().getWidth(), this.getView().getHeight());
         }

         this.fireSDKEvent(new SDKEvent(SDKEvent$SDKEventType.VISIBLE));
      }
   }

   void addJavascriptInterface(Object var1, boolean var2, String var3) {
      this.getAdContainer().addJavascriptInterface(var1, var2, var3);
   }

   public void addSDKEventListener(SDKEventListener var1) {
      Log.d("AdController", "Add SDKEventListener " + var1);
      this.sdkEventListeners.add(var1);
   }

   public boolean areWindowDimensionsSet() {
      return this.windowDimensionsSet;
   }

   void callOnAdEvent(final AdEvent var1) {
      ThreadUtils.scheduleOnMainThread(new Runnable() {
         public void run() {
            if(AdController.this.canBeUsed()) {
               AdController.this.getAdControlCallback().onAdEvent(var1);
            }
         }
      });
   }

   void callOnAdFailedToLoad(final AdError var1, final boolean var2) {
      ThreadUtils.scheduleOnMainThread(new Runnable() {
         public void run() {
            AdController.this.getAdControlCallback().onAdFailed(var1);
            AdController.this.submitAndResetMetricsIfNecessary(var2);
         }
      });
   }

   void callOnAdLoaded(final AdProperties var1) {
      ThreadUtils.scheduleOnMainThread(new Runnable() {
         public void run() {
            if(AdController.this.canBeUsed()) {
               AdController.this.getAdControlCallback().onAdLoaded(var1);
            }
         }
      });
   }

   void callOnAdRendered() {
      ThreadUtils.scheduleOnMainThread(new Runnable() {
         public void run() {
            if(AdController.this.canBeUsed()) {
               AdController.this.getAdControlCallback().onAdRendered();
            }
         }
      });
   }

   void callPostAdRendered() {
      ThreadUtils.scheduleOnMainThread(new Runnable() {
         public void run() {
            if(AdController.this.canBeUsed()) {
               AdController.this.getAdControlCallback().postAdRendered();
            }
         }
      });
   }

   public boolean canBeUsed() {
      return !AdState.DESTROYED.equals(this.getAdState()) && !AdState.INVALID.equals(this.getAdState());
   }

   void cancelTimer() {
      if(this.timer != null) {
         this.timer.cancel();
      }

   }

   public void captureBackButton() {
      this.getAdContainer().listenForKey(new OnKeyListener() {
         public boolean onKey(View var1, int var2, KeyEvent var3) {
            if(var2 == 4 && var3.getRepeatCount() == 0) {
               AdController.this.onBackButtonPress();
               return true;
            } else {
               return false;
            }
         }
      });
   }

   boolean checkDefinedActivities() {
      return AdUtils.checkDefinedActivities(this.getContext().getApplicationContext());
   }

   public void clearSDKEventListeners() {
      this.sdkEventListeners.clear();
   }

   public boolean closeAd() {
      boolean var4 = false;
      Log.d("AdController", "Ad is attempting to close.");
      boolean var3 = var4;
      if(!this.getAdState().equals(AdState.READY_TO_LOAD)) {
         var3 = var4;
         if(!this.isClosing.getAndSet(true)) {
            boolean var1;
            boolean var2;
            label24: {
               switch(this.getAdControlCallback().adClosing()) {
               case 0:
                  var1 = false;
                  break;
               case 1:
                  var1 = true;
                  break;
               default:
                  var1 = false;
                  var2 = false;
                  break label24;
               }

               var2 = var1;
               var1 = true;
            }

            if(var1) {
               this.fireSDKEvent(new SDKEvent(SDKEvent$SDKEventType.CLOSED));
               var3 = true;
            } else {
               var3 = false;
            }

            if(var2) {
               this.resetToReady();
            }

            this.isClosing.set(false);
         }
      }

      return var3;
   }

   AdContainer createAdContainer() {
      return new AdContainer(this.context, this);
   }

   public void destroy() {
      if(!this.canBeUsed()) {
         Log.e("AdController", "The ad cannot be destroyed because it has already been destroyed.");
      } else {
         this.closeAd();
         this.adState = AdState.DESTROYED;
         if(this.adContainer != null) {
            this.getAdContainer().destroy();
            this.adContainer = null;
         }

         this.isPrepared = false;
         this.metricsCollector = null;
         this.adData = null;
      }
   }

   public void enableNativeCloseButton(boolean var1, RelativePosition var2) {
      this.hasNativeCloseButton = true;
      this.getAdContainer().enableNativeCloseButton(var1, var2);
   }

   public void fireAdEvent(AdEvent var1) {
      Log.d("AdController", "Firing AdEvent of type " + var1.getAdEventType().toString());
      this.callOnAdEvent(var1);
   }

   public void fireSDKEvent(SDKEvent var1) {
      Log.d("AdController", "Firing SDK Event of type %s", new Object[]{var1.getEventType().toString()});
      Iterator var2 = this.sdkEventListeners.iterator();

      while(var2.hasNext()) {
         ((SDKEventListener)var2.next()).onSDKEvent(var1, this.getAdControlAccessor());
      }

   }

   AdContainer getAdContainer() {
      if(this.adContainer == null) {
         this.adContainer = this.createAdContainer();
         this.adContainer.disableHardwareAcceleration(this.shouldDisableHardwareAcceleration());
      }

      return this.adContainer;
   }

   public AdControlAccessor getAdControlAccessor() {
      if(this.adControlAccessor == null) {
         this.adControlAccessor = new AdControlAccessor(this);
      }

      return this.adControlAccessor;
   }

   AdControlCallback getAdControlCallback() {
      if(this.adControlCallback == null) {
         this.adControlCallback = new AdController$DefaultAdControlCallback(this);
      }

      return this.adControlCallback;
   }

   public AdData getAdData() {
      return this.adData;
   }

   AdController$AdPosition getAdPosition() {
      int var3 = this.getViewWidth();
      int var4 = this.getViewHeight();
      int var1 = var4;
      int var2 = var3;
      if(var3 == 0) {
         var1 = var4;
         var2 = var3;
         if(var4 == 0) {
            var2 = this.getWindowWidth();
            var1 = this.getWindowHeight();
         }
      }

      var2 = AdUtils.pixelToDeviceIndependentPixel(var2);
      var1 = AdUtils.pixelToDeviceIndependentPixel(var1);
      int[] var5 = new int[2];
      this.getAdContainer().getLocationOnScreen(var5);
      var3 = AdUtils.pixelToDeviceIndependentPixel(var5[0]);
      var4 = AdUtils.pixelToDeviceIndependentPixel(var5[1] - this.calculateAppChromeHeight(true, true));
      return new AdController$AdPosition(this, new Size(var2, var1), var3, var4);
   }

   public AdSize getAdSize() {
      return this.adSize;
   }

   public AdState getAdState() {
      return this.adState;
   }

   public boolean getAndResetIsPrepared() {
      boolean var1 = this.isPrepared;
      this.isPrepared = false;
      return var1;
   }

   boolean getAndSetHasFinishedLoading(boolean var1) {
      return this.hasFinishedLoading.getAndSet(var1);
   }

   public ConnectionInfo getConnectionInfo() {
      return this.connectionInfo;
   }

   int getContentViewTop(Window var1) {
      return var1.findViewById(16908290).getTop();
   }

   protected Context getContext() {
      return (Context)(this.adActivity == null?this.context:this.adActivity);
   }

   Size getMaxExpandableSize(boolean var1) {
      boolean var6 = true;
      DisplayMetrics var7 = new DisplayMetrics();
      this.getMetrics(var7);
      int var2 = var7.widthPixels;
      int var3 = var7.heightPixels;
      boolean var5;
      if(!var1) {
         var5 = true;
      } else {
         var5 = false;
      }

      if(!var1) {
         var1 = var6;
      } else {
         var1 = false;
      }

      int var4 = this.calculateAppChromeHeight(var5, var1);
      return new Size(AdUtils.pixelToDeviceIndependentPixel(var2), AdUtils.pixelToDeviceIndependentPixel(var3 - var4));
   }

   public String getMaxSize() {
      return !this.getAdSize().isAuto()?null:AdSize.getAsSizeString(this.getWindowWidth(), this.getWindowHeight());
   }

   void getMetrics(DisplayMetrics var1) {
      ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getMetrics(var1);
   }

   public MetricsCollector getMetricsCollector() {
      if(this.metricsCollector == null) {
         this.resetMetricsCollector();
      }

      return this.metricsCollector;
   }

   public int getOriginalOrientation() {
      return this.originalOrientation;
   }

   public double getScalingMultiplier() {
      return this.scalingMultiplier;
   }

   public String getScalingMultiplierDescription() {
      return this.getScalingMultiplier() > 1.0D?"u":(this.getScalingMultiplier() < 1.0D && this.getScalingMultiplier() > 0.0D?"d":"n");
   }

   public int getTimeout() {
      return this.timeout;
   }

   public AdContainer getView() {
      return this.getAdContainer();
   }

   public int getViewHeight() {
      return this.getAdContainer().getHeight();
   }

   ViewGroup getViewParent() {
      return (ViewGroup)this.getView().getParent();
   }

   ViewGroup getViewParentIfExpanded() {
      return this.defaultParent != null && this.defaultParent != this.getView().getParent()?this.getViewParent():null;
   }

   public int getViewWidth() {
      return this.getAdContainer().getWidth();
   }

   public int getWindowHeight() {
      return this.adWindowHeight;
   }

   public int getWindowWidth() {
      return this.adWindowWidth;
   }

   public void initialize() {
      if(this.canBeUsed()) {
         this.determineShouldForceDisableHardwareAcceleration();
         if(this.initializeAdContainer()) {
            if(!this.getAdSize().equals(AdSize.SIZE_INTERSTITIAL)) {
               float var1 = InternalAdRegistration.getInstance().getDeviceInfo().getScalingFactorAsFloat();
               this.scalingMultiplier = AdUtils.calculateScalingMultiplier((int)((float)this.adData.getWidth() * var1), (int)(var1 * (float)this.adData.getHeight()), this.getWindowWidth(), this.getWindowHeight());
               this.setViewHeightToAdHeight();
            } else {
               this.scalingMultiplier = -1.0D;
            }

            Iterator var2 = this.adData.iterator();

            while(true) {
               Set var5;
               do {
                  if(!var2.hasNext()) {
                     this.adLoaded();
                     return;
                  }

                  AAXCreative var3 = (AAXCreative)var2.next();
                  var5 = BridgeSelector.getInstance().getBridgeFactories(var3);
               } while(var5 == null);

               Iterator var6 = var5.iterator();

               while(var6.hasNext()) {
                  AdSDKBridgeFactory var4 = (AdSDKBridgeFactory)var6.next();
                  this.getAdContainer().addAdSDKBridge(var4.createAdSDKBridge(this.getAdControlAccessor()));
               }
            }
         }
      }

   }

   boolean initializeAdContainer() {
      try {
         this.getAdContainer().initialize();
         return true;
      } catch (IllegalStateException var2) {
         this.adFailed(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "An unknown error occurred when attempting to create the web view."));
         this.setAdState(AdState.INVALID);
         Log.e("AdController", "An unknown error occurred when attempting to create the web view.");
         return false;
      }
   }

   public void injectJavascript(final String var1, final boolean var2) {
      ThreadUtils.executeOnMainThread(new Runnable() {
         public void run() {
            AdController.this.getAdContainer().injectJavascript(var1, var2);
         }
      });
   }

   public boolean isExpired() {
      return this.adData.isExpired();
   }

   boolean isInterstitial() {
      return AdSize.SIZE_INTERSTITIAL.equals(this.adSize);
   }

   public boolean isValid() {
      return !this.getAdState().equals(AdState.INVALID);
   }

   boolean isValidAppKey() {
      return InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey() != null;
   }

   public boolean isWebViewOk() {
      return WebViewFactory.isWebViewOk(this.getContext());
   }

   public void loadHtml(String var1, String var2) {
      this.getAdContainer().loadHtml(var1, var2);
   }

   public void loadUrl(String var1) {
      this.getAdContainer().loadUrl(var1);
   }

   public void moveViewBackToParent(LayoutParams var1) {
      ViewGroup var2 = (ViewGroup)this.getView().getParent();
      if(var2 != null) {
         var2.removeView(this.getView());
      }

      this.setViewHeightToAdHeight();
      if(this.defaultParent != null) {
         this.defaultParent.addView(this.getView(), var1);
      }

      this.getAdContainer().listenForKey((OnKeyListener)null);
      this.setExpanded(false);
   }

   public void moveViewToViewGroup(ViewGroup var1, LayoutParams var2, boolean var3) {
      ViewGroup var4 = this.getViewParent();
      if(this.defaultParent == null) {
         this.defaultParent = var4;
      }

      if(var4 != null) {
         var4.removeView(this.getView());
      }

      this.setViewHeightToMatchParent();
      var1.addView(this.getView(), var2);
      this.setExpanded(true);
      if(var3) {
         this.captureBackButton();
      }

   }

   void onAdTimedOut() {
      if(!this.getAndSetHasFinishedLoading(true)) {
         this.adFailedAfterTimerCheck(new AdError(AdError$ErrorCode.NETWORK_TIMEOUT, "Ad Load Timed Out"));
         this.setAdState(AdState.INVALID);
      }

   }

   boolean onBackButtonPress() {
      if(this.backButtonOverridden) {
         this.fireSDKEvent(new SDKEvent(SDKEvent$SDKEventType.BACK_BUTTON_PRESSED));
         return true;
      } else {
         this.closeAd();
         return false;
      }
   }

   public void onRequestError(String var1) {
      Log.e("AdController", var1);
      this.adFailed(new AdError(AdError$ErrorCode.REQUEST_ERROR, var1));
   }

   public void overrideBackButton(boolean var1) {
      this.backButtonOverridden = var1;
   }

   protected boolean passesInternetPermissionCheck(Context var1) {
      return PermissionChecker.hasInternetPermission(var1);
   }

   public boolean popView() {
      return this.getAdContainer().popView();
   }

   public void preloadHtml(String var1, String var2, PreloadCallback var3) {
      this.getAdContainer().preloadHtml(var1, var2, var3);
   }

   public void preloadUrl(String var1, PreloadCallback var2) {
      this.getAdContainer().preloadUrl(var1, var2);
   }

   public boolean prepareForAdLoad(long var1, boolean var3) {
      if(!this.canBeUsed()) {
         this.onRequestError("An ad could not be loaded because the view has been destroyed or was not created properly.");
         return false;
      } else if(!this.checkDefinedActivities()) {
         this.onRequestError("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
         return false;
      } else if(!this.passesInternetPermissionCheck(this.context)) {
         this.onRequestError("Ads cannot load because the INTERNET permission is missing from the app\'s manifest.");
         return false;
      } else if(!this.isValidAppKey()) {
         this.onRequestError("Can\'t load an ad because Application Key has not been set. Did you forget to call AdRegistration.setAppKey( ... )?");
         return false;
      } else if(!this.isWebViewOk()) {
         Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_FAILED_UNKNOWN_WEBVIEW_ISSUE);
         this.onRequestError("We will be unable to create a WebView for rendering an ad due to an unknown issue with the WebView.");
         return false;
      } else {
         if(!this.isReadyToLoad(var3)) {
            boolean var4;
            if(this.getAdState().equals(AdState.RENDERED)) {
               if(this.isExpired()) {
                  var4 = false;
               } else {
                  Log.e("AdController", "An ad is ready to show. Please call showAd() to show the ad before loading another ad.");
                  var4 = true;
               }
            } else if(this.getAdState().equals(AdState.EXPANDED)) {
               Log.e("AdController", "An ad could not be loaded because another ad is currently expanded.");
               var4 = true;
            } else {
               Log.e("AdController", "An ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.");
               var4 = true;
            }

            if(var4) {
               return false;
            }
         }

         this.reset();
         this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, var1);
         this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_FAILURE, var1);
         this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_SUCCESS, var1);
         this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, var1);
         this.setAdState(AdState.LOADING);
         this.isRendering.set(false);
         this.setHasFinishedLoading(false);
         if(this.timer != null) {
            this.timer.purge();
         }

         this.timer = new Timer();
         this.timer.schedule(new TimerTask() {
            public void run() {
               AdController.this.onAdTimedOut();
            }
         }, (long)this.getTimeout());
         InternalAdRegistration.getInstance().getDeviceInfo().populateUserAgentString(this.context);
         this.isPrepared = true;
         return true;
      }
   }

   void putUrlExecutorInAdWebViewClient(String var1, AdWebViewClient$UrlExecutor var2) {
      this.getAdContainer().putUrlExecutorInAdWebViewClient(var1, var2);
   }

   void reload() {
      this.getAdContainer().reload();
   }

   public void removeNativeCloseButton() {
      this.hasNativeCloseButton = false;
      this.getAdContainer().removeNativeCloseButton();
   }

   public void render() {
      if(this.canBeUsed()) {
         this.setAdState(AdState.RENDERING);
         long var1 = System.nanoTime();
         this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, var1);
         this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER, var1);
         this.isRendering.set(true);
         String var3 = this.adData.getCreative();
         this.getAdContainer().loadHtml("http://amazon-adsystem.amazon.com/", var3);
      }
   }

   public void requestDisableHardwareAcceleration(boolean var1) {
      this.disableHardwareAccelerationRequest = var1;
      if(this.adContainer != null) {
         this.adContainer.disableHardwareAcceleration(this.shouldDisableHardwareAcceleration());
      }

   }

   public void resetMetricsCollector() {
      this.metricsCollector = new MetricsCollector();
   }

   public void resetToReady() {
      if(this.canBeUsed()) {
         this.adActivity = null;
         this.isPrepared = false;
         this.resetMetricsCollector();
         this.getAdContainer().destroy();
         this.adData = null;
         this.setAdState(AdState.READY_TO_LOAD);
      }
   }

   void setAdActivity(Activity var1) {
      this.adActivity = var1;
   }

   protected void setAdData(AdData var1) {
      this.adData = var1;
   }

   void setAdState(AdState var1) {
      Log.d("AdController", "Changing AdState from " + this.adState.toString() + " to " + var1.toString());
      this.adState = var1;
   }

   protected void setAdditionalMetrics() {
      AdUtils.setConnectionMetrics(this.getConnectionInfo(), this.getMetricsCollector());
      if(this.getWindowHeight() == 0) {
         this.getMetricsCollector().incrementMetric(Metrics$MetricType.ADLAYOUT_HEIGHT_ZERO);
      }

      this.getMetricsCollector().setMetricString(Metrics$MetricType.VIEWPORT_SCALE, this.getScalingMultiplierDescription());
   }

   public void setCallback(AdControlCallback var1) {
      this.adControlCallback = var1;
   }

   public void setConnectionInfo(ConnectionInfo var1) {
      this.connectionInfo = var1;
   }

   public void setExpanded(boolean var1) {
      if(var1) {
         this.setAdState(AdState.EXPANDED);
      } else {
         this.setAdState(AdState.SHOWING);
      }
   }

   void setHasFinishedLoading(boolean var1) {
      this.hasFinishedLoading.set(var1);
   }

   public void setOriginalOrientation(Activity var1) {
      this.originalOrientation = var1.getRequestedOrientation();
   }

   public void setTimeout(int var1) {
      this.timeout = var1;
   }

   public void setViewHeightToAdHeight() {
      if(this.adData != null) {
         int var1 = (int)((double)this.adData.getHeight() * this.getScalingMultiplier() * (double)AdUtils.getScalingFactorAsFloat());
         if(var1 > 0) {
            this.getAdContainer().setViewHeight(var1);
         }
      }

   }

   public void setViewHeightToMatchParent() {
      this.getAdContainer().setViewHeight(-1);
   }

   public void setWindowDimensions(int var1, int var2) {
      this.adWindowWidth = var1;
      this.adWindowHeight = var2;
      this.windowDimensionsSet = true;
   }

   public void showNativeCloseButtonImage(boolean var1) {
      if(this.hasNativeCloseButton) {
         this.getAdContainer().showNativeCloseButtonImage(var1);
      }

   }

   public void stashView() {
      this.getAdContainer().stashView();
   }

   public void submitAndResetMetricsIfNecessary(boolean var1) {
      if(var1) {
         Metrics.getInstance().submitAndResetMetrics(this);
      }

   }
}
