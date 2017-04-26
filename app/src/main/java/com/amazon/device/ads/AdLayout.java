package com.amazon.device.ads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdContainer;
import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdControllerFactory;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout$AdLayoutAdControlCallback;
import com.amazon.device.ads.AdLayout$OnLayoutChangeListenerUtil;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdLoader;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.DefaultAdListener;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.NumberUtils;
import com.amazon.device.ads.ThreadUtils;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdLayout extends FrameLayout implements Ad {
   private static final String CONTENT_DESCRIPTION_AD_LAYOUT = "adLayoutObject";
   public static final int DEFAULT_TIMEOUT = 20000;
   static final String LAYOUT_NOT_RUN_ERR_MSG = "Can\'t load an ad because the view size cannot be determined.";
   static final String LAYOUT_PARAMS_NULL_ERR_MSG = "Can\'t load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.";
   static final String LOADING_IN_PROGRESS_LOG_MSG = "Can\'t load an ad because ad loading is already in progress";
   private static final String LOG_TAG = "AdLayout";
   private static ScheduledThreadPoolExecutor threadPool;
   private View activityRootView;
   private AdController adController;
   private AdListener adListener;
   private final AdSize adSize;
   private AdTargetingOptions adTargetingOptions;
   private boolean attached;
   private final Context context;
   private AdContainer currentView;
   private boolean hasRegisterBroadcastReciever;
   private boolean isDestroyed;
   private boolean isInForeground;
   private boolean isInitialized;
   private boolean isParentViewMissingAtLoadTime;
   private int lastVisibility;
   private AtomicBoolean needsToLoadAdOnLayout;
   private BroadcastReceiver screenStateReceiver;
   private boolean shouldDisableWebViewHardwareAcceleration;

   static {
      ScheduledThreadPoolExecutor var0 = new ScheduledThreadPoolExecutor(1);
      threadPool = var0;
      var0.setKeepAliveTime(60L, TimeUnit.SECONDS);
   }

   public AdLayout(Activity var1) {
      this(var1, AdSize.SIZE_AUTO);
   }

   public AdLayout(Activity var1, AdSize var2) {
      super(var1);
      this.hasRegisterBroadcastReciever = false;
      this.attached = false;
      this.lastVisibility = 8;
      this.needsToLoadAdOnLayout = new AtomicBoolean(false);
      this.isParentViewMissingAtLoadTime = false;
      this.activityRootView = null;
      this.adTargetingOptions = null;
      this.isDestroyed = false;
      this.isInitialized = false;
      this.context = var1;
      this.adSize = var2;
   }

   public AdLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.hasRegisterBroadcastReciever = false;
      this.attached = false;
      this.lastVisibility = 8;
      this.needsToLoadAdOnLayout = new AtomicBoolean(false);
      this.isParentViewMissingAtLoadTime = false;
      this.activityRootView = null;
      this.adTargetingOptions = null;
      this.isDestroyed = false;
      this.isInitialized = false;
      this.context = var1;
      this.adSize = this.determineAdSize(var2);
   }

   public AdLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.hasRegisterBroadcastReciever = false;
      this.attached = false;
      this.lastVisibility = 8;
      this.needsToLoadAdOnLayout = new AtomicBoolean(false);
      this.isParentViewMissingAtLoadTime = false;
      this.activityRootView = null;
      this.adTargetingOptions = null;
      this.isDestroyed = false;
      this.isInitialized = false;
      this.context = var1;
      this.adSize = this.determineAdSize(var2);
   }

   // $FF: synthetic method
   static void access$200(AdLayout var0) {
      var0.startAdLoadUponLayout();
   }

   // $FF: synthetic method
   static View access$300(AdLayout var0) {
      return var0.activityRootView;
   }

   // $FF: synthetic method
   static AdContainer access$400(AdLayout var0) {
      return var0.currentView;
   }

   // $FF: synthetic method
   static AdContainer access$402(AdLayout var0, AdContainer var1) {
      var0.currentView = var1;
      return var1;
   }

   // $FF: synthetic method
   static AdListener access$500(AdLayout var0) {
      return var0.adListener;
   }

   // $FF: synthetic method
   static AdController access$602(AdLayout var0, AdController var1) {
      var0.adController = var1;
      return var1;
   }

   private void collapseAd() {
      if(this.getAdController().getAdState().equals(AdState.EXPANDED)) {
         ThreadUtils.scheduleOnMainThread(new Runnable() {
            public void run() {
               if(AdLayout.this.getAdController().getAdState().equals(AdState.EXPANDED)) {
                  AdLayout.this.getAdController().closeAd();
               }

            }
         });
      }

   }

   private AdSize determineAdSize(AttributeSet var1) {
      String var3 = getAttributeValue(var1, "http://schemas.android.com/apk/lib/com.amazon.device.ads", "adSize");
      String var2 = var3;
      if(var3 == null) {
         String var4 = getAttributeValue(var1, "http://schemas.android.com/apk/res/" + this.context.getPackageName(), "adSize");
         var2 = var4;
         if(var4 != null) {
            Log.w(true, "AdLayout", "DEPRECATED - Please use the XML namespace \"http://schemas.android.com/apk/lib/com.amazon.device.ads\" for specifying AdLayout properties.");
            var2 = var4;
            if(var4.toLowerCase(Locale.US).equals("custom")) {
               Log.e(true, "AdLayout", "Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
               throw new IllegalArgumentException("Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
            }
         }
      }

      return parseAdSize(var2);
   }

   private AdController getAdController() {
      this.initializeIfNecessary();
      if(this.adController == null) {
         this.initializeAdController();
      }

      return this.adController;
   }

   private static String getAttributeValue(AttributeSet var0, String var1, String var2) {
      return var0.getAttributeValue(var1, var2);
   }

   private void initializeAdController() {
      if(this.adController == null) {
         AdSize var1;
         if(this.adSize == null) {
            var1 = AdSize.SIZE_AUTO;
         } else {
            var1 = this.adSize;
         }

         this.setAdController(this.createAdController(var1, this.context));
         this.adController.requestDisableHardwareAcceleration(this.shouldDisableWebViewHardwareAcceleration);
      }

   }

   private boolean isReadyToLoad() {
      return AdState.READY_TO_LOAD.equals(this.getAdController().getAdState()) || AdState.SHOWING.equals(this.getAdController().getAdState());
   }

   private boolean loadAdWhenParentViewMissing() {
      if(this.getLayoutParams() == null) {
         Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_FAILED_NULL_LAYOUT_PARAMS);
         this.onRequestError("Can\'t load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.");
         return false;
      } else if(AndroidTargetUtils.isAtLeastAndroidAPI(11)) {
         this.setActivityRootView();
         if(this.isActivityRootViewNull()) {
            this.onRequestError("Ad load failed because root view could not be obtained from the activity.");
            return false;
         } else if(this.isActivityRootViewLayoutRequested()) {
            Log.d("AdLayout", "Activity root view layout is requested.");
            this.deferAdLoadToLayoutEvent();
            this.setOnLayoutChangeListenerForRoot();
            return false;
         } else {
            this.setFloatingWindowDimensions();
            return true;
         }
      } else {
         this.setFloatingWindowDimensions();
         return true;
      }
   }

   private void onRequestError(String var1) {
      this.getAdController().onRequestError(var1);
   }

   private static AdSize parseAdSize(String var0) {
      int var1 = 0;
      AdSize var3 = AdSize.SIZE_AUTO;
      if(var0 != null) {
         var0 = var0.toLowerCase(Locale.US);
         if(!var0.equals("auto")) {
            String[] var4 = var0.split("x");
            int var2;
            if(var4.length == 2) {
               var2 = NumberUtils.parseInt(var4[0], 0);
               var1 = NumberUtils.parseInt(var4[1], 0);
            } else {
               var2 = 0;
            }

            return new AdSize(var2, var1);
         }
      }

      return var3;
   }

   private void registerScreenStateBroadcastReceiver() {
      if(!this.hasRegisterBroadcastReciever) {
         this.hasRegisterBroadcastReciever = true;
         this.screenStateReceiver = new BroadcastReceiver() {
            public void onReceive(Context var1, Intent var2) {
               if(var2.getAction().equals("android.intent.action.SCREEN_OFF") && AdLayout.this.isInForeground) {
                  AdLayout.this.getAdController().closeAd();
               }

            }
         };
         IntentFilter var1 = new IntentFilter("android.intent.action.SCREEN_OFF");
         var1.addAction("android.intent.action.USER_PRESENT");
         this.context.getApplicationContext().registerReceiver(this.screenStateReceiver, var1);
      }
   }

   private void setAdController(AdController var1) {
      this.adController = var1;
      this.adController.setCallback(this.createAdControlCallback());
   }

   private void startAdLoadUponLayout() {
      AdTargetingOptions var1 = this.adTargetingOptions;
      AdSlot var2 = (new AdSlot(this.getAdController(), var1)).setDeferredLoad(true);
      AdLoader.loadAds(this.getAdController().getTimeout(), var1, new AdSlot[]{var2});
      if(!this.getAndResetIsPrepared()) {
         this.onRequestError("Could not load ad on layout.");
      }

   }

   private void unregisterScreenStateBroadcastReceiver() {
      if(this.hasRegisterBroadcastReciever) {
         this.hasRegisterBroadcastReciever = false;
         this.context.getApplicationContext().unregisterReceiver(this.screenStateReceiver);
      }

   }

   void adFailed(AdError var1) {
      this.getAdController().adFailed(var1);
   }

   void adShown() {
      this.getAdController().adShown();
   }

   void bypassAdRenderingProcess() {
      this.getAdController().setAdState(AdState.RENDERING);
      this.getAdController().adRendered("custom-render");
   }

   AdControlCallback createAdControlCallback() {
      return new AdLayout$AdLayoutAdControlCallback(this);
   }

   AdController createAdController(AdSize var1, Context var2) {
      return AdControllerFactory.buildAdController(var2, var1);
   }

   void deferAdLoadToLayoutEvent() {
      this.setNeedsToLoadAdOnLayout(true);
      this.scheduleTaskForCheckingIfLayoutHasRun();
   }

   public void destroy() {
      if(this.isInitialized()) {
         Log.d("AdLayout", "Destroying the AdLayout");
         this.isDestroyed = true;
         this.unregisterScreenStateBroadcastReceiver();
         this.getAdController().destroy();
      }
   }

   void failLoadIfLayoutHasNotRun() {
      if(this.getAndSetNeedsToLoadAdOnLayout(false)) {
         Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_FAILED_LAYOUT_NOT_RUN);
         this.onRequestError("Can\'t load an ad because the view size cannot be determined.");
      }

   }

   View getActivityRootView() {
      return this.activityRootView;
   }

   int getActivityRootViewDimension(boolean var1) {
      return var1?this.activityRootView.getWidth():this.activityRootView.getHeight();
   }

   AdData getAdData() {
      return this.getAdController().getAdData();
   }

   AdListener getAdListener() {
      return this.adListener;
   }

   public AdSize getAdSize() {
      AdController var1 = this.getAdController();
      return var1 == null?null:var1.getAdSize();
   }

   boolean getAndResetIsPrepared() {
      return this.getAdController().getAndResetIsPrepared();
   }

   boolean getAndSetNeedsToLoadAdOnLayout(boolean var1) {
      return this.needsToLoadAdOnLayout.getAndSet(var1);
   }

   boolean getNeedsToLoadAdOnLayout() {
      return this.needsToLoadAdOnLayout.get();
   }

   int getRawScreenDimension(boolean var1) {
      WindowManager var2 = (WindowManager)this.context.getSystemService("window");
      DisplayMetrics var3 = new DisplayMetrics();
      var2.getDefaultDisplay().getMetrics(var3);
      return var1?var3.widthPixels:var3.heightPixels;
   }

   public int getTimeout() {
      return this.getAdController() == null?-1:this.getAdController().getTimeout();
   }

   void initializeIfNecessary() {
      if(!this.isInitialized()) {
         long var1 = System.nanoTime();
         Log.d("AdLayout", "Initializing AdLayout.");
         InternalAdRegistration.getInstance().contextReceived(this.context);
         this.setContentDescription("adLayoutObject");
         if(this.isInEditMode()) {
            TextView var4 = new TextView(this.context);
            var4.setText("AdLayout");
            var4.setLayoutParams(new LayoutParams(-1, -1));
            var4.setGravity(17);
            this.addView(var4);
            this.isInitialized = true;
         } else {
            boolean var3;
            if(this.getVisibility() == 0) {
               var3 = true;
            } else {
               var3 = false;
            }

            this.isInForeground = var3;
            this.setHorizontalScrollBarEnabled(false);
            this.setVerticalScrollBarEnabled(false);
            if(this.isWebViewDatabaseNull(this.context)) {
               Log.e(true, "AdLayout", "Disabling ads. Local cache file is inaccessible so ads will fail if we try to create a WebView. Details of this Android bug found at: http://code.google.com/p/android/issues/detail?id=10789");
            } else {
               this.isInitialized = true;
               if(this.adListener == null) {
                  this.adListener = new DefaultAdListener("AdLayout");
               }

               this.initializeAdController();
               this.adController.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LAYOUT_INITIALIZATION, var1);
               this.adController.getMetricsCollector().stopMetric(Metrics$MetricType.AD_LAYOUT_INITIALIZATION);
            }
         }
      }
   }

   boolean isActivityRootViewLayoutRequested() {
      return this.activityRootView.isLayoutRequested();
   }

   boolean isActivityRootViewNull() {
      return this.activityRootView == null;
   }

   public boolean isAdLoading() {
      return this.isLoading();
   }

   boolean isInitialized() {
      return this.isInitialized;
   }

   public boolean isLoading() {
      return this.getAdController() == null?false:this.getAdController().getAdState().equals(AdState.LOADING);
   }

   boolean isParentViewMissingAtLoadTime() {
      return this.isParentViewMissingAtLoadTime;
   }

   boolean isWebViewDatabaseNull(Context var1) {
      return WebViewDatabase.getInstance(var1) == null;
   }

   public boolean loadAd() {
      return this.loadAd(new AdTargetingOptions());
   }

   public boolean loadAd(AdTargetingOptions var1) {
      AdTargetingOptions var2 = var1;
      if(var1 == null) {
         var2 = new AdTargetingOptions();
      }

      this.adTargetingOptions = var2;
      if(this.getNeedsToLoadAdOnLayout()) {
         Log.e("AdLayout", "Can\'t load an ad because ad loading is already in progress");
         return false;
      } else {
         this.initializeIfNecessary();
         if(!this.isInitialized()) {
            Log.e("AdLayout", "The ad could not be initialized properly.");
            return false;
         } else if(!this.isReadyToLoad()) {
            switch(null.$SwitchMap$com$amazon$device$ads$AdState[this.getAdController().getAdState().ordinal()]) {
            case 1:
               Log.e("AdLayout", "An ad could not be loaded because of an unknown issue with web views.");
               return false;
            case 2:
               Log.e("AdLayout", "An ad could not be loaded because the AdLayout has been destroyed.");
               return false;
            case 3:
               Log.e("AdLayout", "An ad could not be loaded because another ad is currently expanded.");
               return false;
            default:
               Log.e("AdLayout", "Can\'t load an ad because ad loading is already in progress");
               return false;
            }
         } else {
            AdLoader.loadAds(this.getAdController().getTimeout(), var2, new AdSlot[]{new AdSlot(this.getAdController(), var2)});
            return this.getNeedsToLoadAdOnLayout()?true:this.getAndResetIsPrepared();
         }
      }
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(!this.isInEditMode()) {
         this.attached = true;
         this.registerScreenStateBroadcastReceiver();
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.attached = false;
      this.collapseAd();
      this.unregisterScreenStateBroadcastReceiver();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      if(!this.isDestroyed) {
         super.onLayout(var1, var2, var3, var4, var5);
         if(!this.isInEditMode()) {
            this.getAdController().setWindowDimensions(var4 - var2, var5 - var3);
            if(this.getAndSetNeedsToLoadAdOnLayout(false)) {
               this.startAdLoadUponLayout();
               return;
            }
         }
      }

   }

   protected void onWindowVisibilityChanged(int var1) {
      if(this.attached && this.lastVisibility != var1) {
         if(var1 != 0) {
            this.isInForeground = false;
            this.collapseAd();
            this.unregisterScreenStateBroadcastReceiver();
         } else if(var1 == 0) {
            this.isInForeground = true;
            return;
         }
      }

   }

   boolean prepareAd(boolean var1) {
      if(var1) {
         Log.d("AdLayout", "Skipping ad layout preparation steps because the layout is already prepared.");
      } else {
         if(!this.isReadyToLoad()) {
            return false;
         }

         if(this.getNeedsToLoadAdOnLayout()) {
            Log.e("AdLayout", "Can\'t load an ad because ad loading is already in progress");
            return false;
         }

         if(this.getAdSize().isAuto()) {
            Log.d("AdLayout", "Ad size to be determined automatically.");
         }

         this.setIsParentViewMissingAtLoadTime();
         if(!this.getAdSize().isAuto() || !this.getAdController().areWindowDimensionsSet()) {
            if(this.isLayoutRequested() && this.getAdSize().isAuto() && !this.isParentViewMissingAtLoadTime()) {
               this.deferAdLoadToLayoutEvent();
               return false;
            }

            if(this.isParentViewMissingAtLoadTime()) {
               Log.d("AdLayout", "The ad\'s parent view is missing at load time.");
               return this.loadAdWhenParentViewMissing();
            }
         }
      }

      return true;
   }

   int resolveLayoutParamForFloatingAd(boolean var1) {
      int var2;
      if(var1) {
         var2 = this.getLayoutParams().width;
      } else {
         var2 = this.getLayoutParams().height;
      }

      int var3;
      if(var2 == -1) {
         if(!this.isActivityRootViewNull()) {
            return this.getActivityRootViewDimension(var1);
         }

         var3 = this.getRawScreenDimension(var1);
      } else {
         var3 = var2;
         if(var2 == -2) {
            return 0;
         }
      }

      return var3;
   }

   void scheduleTaskForCheckingIfLayoutHasRun() {
      Runnable var1 = new Runnable() {
         public void run() {
            AdLayout.this.failLoadIfLayoutHasNotRun();
         }
      };
      threadPool.schedule(var1, (long)this.getTimeout(), TimeUnit.MILLISECONDS);
   }

   void setActivityRootView() {
      this.activityRootView = ((Activity)this.context).getWindow().getDecorView().findViewById(16908290).getRootView();
   }

   void setFloatingWindowDimensions() {
      if(this.getLayoutParams().width == -1 || this.getLayoutParams().height == -1) {
         Log.d("AdLayout", "The requested ad will scale based on the screen\'s dimensions because at least one AdLayout dimension is set to MATCH_PARENT but the AdLayout is currently missing a fixed-size parent view.");
      }

      int var1 = this.resolveLayoutParamForFloatingAd(true);
      int var2 = this.resolveLayoutParamForFloatingAd(false);
      this.getAdController().setWindowDimensions(var1, var2);
   }

   void setIsParentViewMissingAtLoadTime() {
      boolean var1;
      if(this.getParent() == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.isParentViewMissingAtLoadTime = var1;
   }

   void setIsParentViewMissingAtLoadTime(boolean var1) {
      this.isParentViewMissingAtLoadTime = var1;
   }

   public void setListener(AdListener var1) {
      if(var1 == null) {
         this.adListener = new DefaultAdListener("AdLayout");
      } else {
         this.adListener = var1;
      }
   }

   void setNeedsToLoadAdOnLayout(boolean var1) {
      this.needsToLoadAdOnLayout.set(var1);
   }

   void setOnLayoutChangeListenerForRoot() {
      AdLayout$OnLayoutChangeListenerUtil.setOnLayoutChangeListenerForRoot(this);
   }

   void setShouldDisableWebViewHardwareAcceleration(boolean var1) {
      this.shouldDisableWebViewHardwareAcceleration = var1;
      if(this.adController != null) {
         this.adController.requestDisableHardwareAcceleration(this.shouldDisableWebViewHardwareAcceleration);
      }

   }

   public void setTimeout(int var1) {
      AdController var2 = this.getAdController();
      if(var2 != null) {
         var2.setTimeout(var1);
      }

   }

   boolean shouldDisableWebViewHardwareAcceleration() {
      return this.shouldDisableWebViewHardwareAcceleration;
   }
}
