package com.mopub.mraid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.CloseableLayout$ClosePosition;
import com.mopub.common.CloseableLayout$OnCloseListener;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Utils;
import com.mopub.common.util.Views;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.util.WebViews;
import com.mopub.mraid.MraidBridge;
import com.mopub.mraid.MraidBridge$MraidBridgeListener;
import com.mopub.mraid.MraidBridge$MraidWebView;
import com.mopub.mraid.MraidCommandException;
import com.mopub.mraid.MraidController$MraidListener;
import com.mopub.mraid.MraidController$OrientationBroadcastReceiver;
import com.mopub.mraid.MraidController$ScreenMetricsWaiter;
import com.mopub.mraid.MraidController$UseCustomCloseListener;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.mraid.MraidOrientation;
import com.mopub.mraid.MraidScreenMetrics;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;
import com.mopub.mraid.ViewState;
import java.net.URI;

public class MraidController {
   private Activity mActivity;
   private final AdReport mAdReport;
   private boolean mAllowOrientationChange;
   private final CloseableLayout mCloseableAdContainer;
   private final Context mContext;
   private MraidWebViewDebugListener mDebugListener;
   private final FrameLayout mDefaultAdContainer;
   private MraidOrientation mForceOrientation;
   private boolean mIsPaused;
   private final MraidBridge mMraidBridge;
   private final MraidBridge$MraidBridgeListener mMraidBridgeListener;
   private MraidController$MraidListener mMraidListener;
   private final MraidNativeCommandHandler mMraidNativeCommandHandler;
   private MraidBridge$MraidWebView mMraidWebView;
   private MraidController$UseCustomCloseListener mOnCloseButtonListener;
   private MraidController$OrientationBroadcastReceiver mOrientationBroadcastReceiver;
   private Integer mOriginalActivityOrientation;
   private final PlacementType mPlacementType;
   private ViewGroup mRootView;
   private final MraidScreenMetrics mScreenMetrics;
   private final MraidController$ScreenMetricsWaiter mScreenMetricsWaiter;
   private final MraidBridge mTwoPartBridge;
   private final MraidBridge$MraidBridgeListener mTwoPartBridgeListener;
   private MraidBridge$MraidWebView mTwoPartWebView;
   private ViewState mViewState;

   public MraidController(Context var1, AdReport var2, PlacementType var3) {
      this(var1, var2, var3, new MraidBridge(var2, var3), new MraidBridge(var2, PlacementType.INTERSTITIAL), new MraidController$ScreenMetricsWaiter());
   }

   @VisibleForTesting
   MraidController(Context var1, AdReport var2, PlacementType var3, MraidBridge var4, MraidBridge var5, MraidController$ScreenMetricsWaiter var6) {
      this.mViewState = ViewState.LOADING;
      this.mOrientationBroadcastReceiver = new MraidController$OrientationBroadcastReceiver(this);
      this.mAllowOrientationChange = true;
      this.mForceOrientation = MraidOrientation.NONE;
      this.mMraidBridgeListener = new MraidBridge$MraidBridgeListener() {
         public void onClose() {
            MraidController.this.handleClose();
         }

         public boolean onConsoleMessage(ConsoleMessage var1) {
            return MraidController.this.handleConsoleMessage(var1);
         }

         public void onExpand(URI var1, boolean var2) {
            MraidController.this.handleExpand(var1, var2);
         }

         public boolean onJsAlert(String var1, JsResult var2) {
            return MraidController.this.handleJsAlert(var1, var2);
         }

         public void onOpen(URI var1) {
            MraidController.this.handleOpen(var1.toString());
         }

         public void onPageLoaded() {
            MraidController.this.handlePageLoad();
         }

         public void onPlayVideo(URI var1) {
            MraidController.this.handleShowVideo(var1.toString());
         }

         public void onResize(int var1, int var2, int var3, int var4, CloseableLayout$ClosePosition var5, boolean var6) {
            MraidController.this.handleResize(var1, var2, var3, var4, var5, var6);
         }

         public void onSetOrientationProperties(boolean var1, MraidOrientation var2) {
            MraidController.this.handleSetOrientationProperties(var1, var2);
         }

         public void onUseCustomClose(boolean var1) {
            MraidController.this.handleCustomClose(var1);
         }

         public void onVisibilityChanged(boolean var1) {
            if(!MraidController.this.mTwoPartBridge.isAttached()) {
               MraidController.this.mMraidBridge.notifyViewability(var1);
            }

         }
      };
      this.mTwoPartBridgeListener = new MraidBridge$MraidBridgeListener() {
         public void onClose() {
            MraidController.this.handleClose();
         }

         public boolean onConsoleMessage(ConsoleMessage var1) {
            return MraidController.this.handleConsoleMessage(var1);
         }

         public void onExpand(URI var1, boolean var2) {
         }

         public boolean onJsAlert(String var1, JsResult var2) {
            return MraidController.this.handleJsAlert(var1, var2);
         }

         public void onOpen(URI var1) {
            MraidController.this.handleOpen(var1.toString());
         }

         public void onPageLoaded() {
            MraidController.this.handleTwoPartPageLoad();
         }

         public void onPlayVideo(URI var1) {
            MraidController.this.handleShowVideo(var1.toString());
         }

         public void onResize(int var1, int var2, int var3, int var4, CloseableLayout$ClosePosition var5, boolean var6) {
            throw new MraidCommandException("Not allowed to resize from an expanded state");
         }

         public void onSetOrientationProperties(boolean var1, MraidOrientation var2) {
            MraidController.this.handleSetOrientationProperties(var1, var2);
         }

         public void onUseCustomClose(boolean var1) {
            MraidController.this.handleCustomClose(var1);
         }

         public void onVisibilityChanged(boolean var1) {
            MraidController.this.mMraidBridge.notifyViewability(var1);
            MraidController.this.mTwoPartBridge.notifyViewability(var1);
         }
      };
      this.mContext = var1;
      this.mAdReport = var2;
      if(this.mContext instanceof Activity) {
         this.mActivity = (Activity)this.mContext;
      }

      this.mPlacementType = var3;
      this.mMraidBridge = var4;
      this.mTwoPartBridge = var5;
      this.mScreenMetricsWaiter = var6;
      this.mViewState = ViewState.LOADING;
      DisplayMetrics var7 = this.mContext.getResources().getDisplayMetrics();
      this.mScreenMetrics = new MraidScreenMetrics(this.mContext, var7.density);
      this.mDefaultAdContainer = new FrameLayout(this.mContext);
      this.mCloseableAdContainer = new CloseableLayout(this.mContext);
      this.mCloseableAdContainer.setOnCloseListener(new CloseableLayout$OnCloseListener() {
         public void onClose() {
            MraidController.this.handleClose();
         }
      });
      View var8 = new View(this.mContext);
      var8.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            return true;
         }
      });
      this.mCloseableAdContainer.addView(var8, new LayoutParams(-1, -1));
      this.mOrientationBroadcastReceiver.register(this.mContext);
      this.mMraidBridge.setMraidBridgeListener(this.mMraidBridgeListener);
      this.mTwoPartBridge.setMraidBridgeListener(this.mTwoPartBridgeListener);
      this.mMraidNativeCommandHandler = new MraidNativeCommandHandler();
   }

   // $FF: synthetic method
   static int access$2(MraidController var0) {
      return var0.getDisplayRotation();
   }

   private View getCurrentWebView() {
      return this.mTwoPartBridge.isAttached()?this.mTwoPartWebView:this.mMraidWebView;
   }

   private int getDisplayRotation() {
      return ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
   }

   @TargetApi(19)
   private ViewGroup getRootView() {
      if(this.mRootView == null) {
         if(VERSION.SDK_INT >= 19) {
            Preconditions.checkState(this.mDefaultAdContainer.isAttachedToWindow());
         }

         this.mRootView = (ViewGroup)this.mDefaultAdContainer.getRootView().findViewById(16908290);
      }

      return this.mRootView;
   }

   private boolean isInlineVideoAvailable() {
      return this.mActivity != null && this.getCurrentWebView() != null?this.mMraidNativeCommandHandler.isInlineVideoAvailable(this.mActivity, this.getCurrentWebView()):false;
   }

   private void setViewState(ViewState var1) {
      this.setViewState(var1, (Runnable)null);
   }

   private void setViewState(ViewState var1, Runnable var2) {
      MoPubLog.d("MRAID state set to " + var1);
      this.mViewState = var1;
      this.mMraidBridge.notifyViewState(var1);
      if(this.mTwoPartBridge.isLoaded()) {
         this.mTwoPartBridge.notifyViewState(var1);
      }

      if(this.mMraidListener != null) {
         if(var1 == ViewState.EXPANDED) {
            this.mMraidListener.onExpand();
         } else if(var1 == ViewState.HIDDEN) {
            this.mMraidListener.onClose();
         }
      }

      this.updateScreenMetricsAsync(var2);
   }

   private void updateScreenMetricsAsync(final Runnable var1) {
      this.mScreenMetricsWaiter.cancelLastRequest();
      final View var2 = this.getCurrentWebView();
      if(var2 != null) {
         this.mScreenMetricsWaiter.waitFor(new View[]{this.mDefaultAdContainer, var2}).start(new Runnable() {
            public void run() {
               DisplayMetrics var1x = MraidController.this.mContext.getResources().getDisplayMetrics();
               MraidController.this.mScreenMetrics.setScreenSize(var1x.widthPixels, var1x.heightPixels);
               int[] var3 = new int[2];
               ViewGroup var2x = MraidController.this.getRootView();
               var2x.getLocationOnScreen(var3);
               MraidController.this.mScreenMetrics.setRootViewPosition(var3[0], var3[1], var2x.getWidth(), var2x.getHeight());
               MraidController.this.mDefaultAdContainer.getLocationOnScreen(var3);
               MraidController.this.mScreenMetrics.setDefaultAdPosition(var3[0], var3[1], MraidController.this.mDefaultAdContainer.getWidth(), MraidController.this.mDefaultAdContainer.getHeight());
               var2.getLocationOnScreen(var3);
               MraidController.this.mScreenMetrics.setCurrentAdPosition(var3[0], var3[1], var2.getWidth(), var2.getHeight());
               MraidController.this.mMraidBridge.notifyScreenMetrics(MraidController.this.mScreenMetrics);
               if(MraidController.this.mTwoPartBridge.isAttached()) {
                  MraidController.this.mTwoPartBridge.notifyScreenMetrics(MraidController.this.mScreenMetrics);
               }

               if(var1 != null) {
                  var1.run();
               }

            }
         });
      }
   }

   @VisibleForTesting
   void applyOrientation() {
      if(this.mForceOrientation == MraidOrientation.NONE) {
         if(this.mAllowOrientationChange) {
            this.unApplyOrientation();
         } else if(this.mActivity == null) {
            throw new MraidCommandException("Unable to set MRAID expand orientation to \'none\'; expected passed in Activity Context.");
         } else {
            this.lockOrientation(DeviceUtils.getScreenOrientation(this.mActivity));
         }
      } else {
         this.lockOrientation(this.mForceOrientation.getActivityInfoOrientation());
      }
   }

   int clampInt(int var1, int var2, int var3) {
      return Math.max(var1, Math.min(var2, var3));
   }

   public void destroy() {
      this.mScreenMetricsWaiter.cancelLastRequest();

      try {
         this.mOrientationBroadcastReceiver.unregister();
      } catch (IllegalArgumentException var2) {
         if(!var2.getMessage().contains("Receiver not registered")) {
            throw var2;
         }
      }

      if(!this.mIsPaused) {
         this.pause();
      }

      Views.removeFromParent(this.mCloseableAdContainer);
      this.mMraidBridge.detach();
      if(this.mMraidWebView != null) {
         this.mMraidWebView.destroy();
         this.mMraidWebView = null;
      }

      this.mTwoPartBridge.detach();
      if(this.mTwoPartWebView != null) {
         this.mTwoPartWebView.destroy();
         this.mTwoPartWebView = null;
      }

   }

   public FrameLayout getAdContainer() {
      return this.mDefaultAdContainer;
   }

   @Deprecated
   @VisibleForTesting
   boolean getAllowOrientationChange() {
      return this.mAllowOrientationChange;
   }

   public Context getContext() {
      return this.mContext;
   }

   @Deprecated
   @VisibleForTesting
   CloseableLayout getExpandedAdContainer() {
      return this.mCloseableAdContainer;
   }

   @Deprecated
   @VisibleForTesting
   MraidOrientation getForceOrientation() {
      return this.mForceOrientation;
   }

   @Deprecated
   @VisibleForTesting
   MraidBridge$MraidWebView getMraidWebView() {
      return this.mMraidWebView;
   }

   @Deprecated
   @VisibleForTesting
   Integer getOriginalActivityOrientation() {
      return this.mOriginalActivityOrientation;
   }

   @Deprecated
   @VisibleForTesting
   MraidBridge$MraidWebView getTwoPartWebView() {
      return this.mTwoPartWebView;
   }

   @Deprecated
   @VisibleForTesting
   ViewState getViewState() {
      return this.mViewState;
   }

   @VisibleForTesting
   void handleClose() {
      if(this.mMraidWebView != null && this.mViewState != ViewState.LOADING && this.mViewState != ViewState.HIDDEN) {
         if(this.mViewState == ViewState.EXPANDED || this.mPlacementType == PlacementType.INTERSTITIAL) {
            this.unApplyOrientation();
         }

         if(this.mViewState == ViewState.RESIZED || this.mViewState == ViewState.EXPANDED) {
            if(this.mTwoPartBridge.isAttached() && this.mTwoPartWebView != null) {
               this.mCloseableAdContainer.removeView(this.mTwoPartWebView);
               this.mTwoPartBridge.detach();
            } else {
               this.mCloseableAdContainer.removeView(this.mMraidWebView);
               this.mDefaultAdContainer.addView(this.mMraidWebView, new LayoutParams(-1, -1));
               this.mDefaultAdContainer.setVisibility(0);
            }

            this.getRootView().removeView(this.mCloseableAdContainer);
            this.setViewState(ViewState.DEFAULT);
            return;
         }

         if(this.mViewState == ViewState.DEFAULT) {
            this.mDefaultAdContainer.setVisibility(4);
            this.setViewState(ViewState.HIDDEN);
            return;
         }
      }

   }

   @VisibleForTesting
   boolean handleConsoleMessage(ConsoleMessage var1) {
      return this.mDebugListener != null?this.mDebugListener.onConsoleMessage(var1):true;
   }

   @VisibleForTesting
   void handleCustomClose(boolean var1) {
      boolean var3 = false;
      boolean var2;
      if(this.mCloseableAdContainer.isCloseVisible()) {
         var2 = false;
      } else {
         var2 = true;
      }

      if(var1 != var2) {
         CloseableLayout var4 = this.mCloseableAdContainer;
         if(var1) {
            var2 = var3;
         } else {
            var2 = true;
         }

         var4.setCloseVisible(var2);
         if(this.mOnCloseButtonListener != null) {
            this.mOnCloseButtonListener.useCustomCloseChanged(var1);
            return;
         }
      }

   }

   void handleExpand(URI var1, boolean var2) {
      if(this.mMraidWebView == null) {
         throw new MraidCommandException("Unable to expand after the WebView is destroyed");
      } else if(this.mPlacementType != PlacementType.INTERSTITIAL && (this.mViewState == ViewState.DEFAULT || this.mViewState == ViewState.RESIZED)) {
         this.applyOrientation();
         boolean var3;
         if(var1 != null) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3) {
            this.mTwoPartWebView = new MraidBridge$MraidWebView(this.mContext);
            this.mTwoPartBridge.attachView(this.mTwoPartWebView);
            this.mTwoPartBridge.setContentUrl(var1.toString());
         }

         LayoutParams var4 = new LayoutParams(-1, -1);
         if(this.mViewState == ViewState.DEFAULT) {
            if(var3) {
               this.mCloseableAdContainer.addView(this.mTwoPartWebView, var4);
            } else {
               this.mDefaultAdContainer.removeView(this.mMraidWebView);
               this.mDefaultAdContainer.setVisibility(4);
               this.mCloseableAdContainer.addView(this.mMraidWebView, var4);
            }

            this.getRootView().addView(this.mCloseableAdContainer, new LayoutParams(-1, -1));
         } else if(this.mViewState == ViewState.RESIZED && var3) {
            this.mCloseableAdContainer.removeView(this.mMraidWebView);
            this.mDefaultAdContainer.addView(this.mMraidWebView, var4);
            this.mDefaultAdContainer.setVisibility(4);
            this.mCloseableAdContainer.addView(this.mTwoPartWebView, var4);
         }

         this.mCloseableAdContainer.setLayoutParams(var4);
         this.handleCustomClose(var2);
         this.setViewState(ViewState.EXPANDED);
      }
   }

   @VisibleForTesting
   boolean handleJsAlert(String var1, JsResult var2) {
      if(this.mDebugListener != null) {
         return this.mDebugListener.onJsAlert(var1, var2);
      } else {
         var2.confirm();
         return true;
      }
   }

   @VisibleForTesting
   void handleOpen(String var1) {
      MoPubLog.d("Opening url: " + var1);
      if(this.mMraidListener != null) {
         this.mMraidListener.onOpen();
      }

      Intent var7;
      if(Intents.isNativeBrowserScheme(var1)) {
         try {
            var7 = Intents.intentForNativeBrowserScheme(var1);
            Intents.startActivity(this.mContext, var7);
         } catch (UrlParseException var3) {
            MoPubLog.d("Unable to load mopub native browser url: " + var1 + ". " + var3.getMessage());
         } catch (IntentNotResolvableException var4) {
            MoPubLog.d("Unable to load mopub native browser url: " + var1 + ". " + var4.getMessage());
         }
      } else if(!Intents.isHttpUrl(var1) && Intents.canHandleApplicationUrl(this.mContext, var1)) {
         var7 = new Intent("android.intent.action.VIEW", Uri.parse(var1));

         try {
            Intents.startActivity(this.mContext, var7);
         } catch (IntentNotResolvableException var5) {
            MoPubLog.d("Unable to resolve application url: " + var1);
         }
      } else {
         Bundle var2 = new Bundle();
         var2.putString("URL", var1);
         var7 = Intents.getStartActivityIntent(this.mContext, MoPubBrowser.class, var2);

         try {
            Intents.startActivity(this.mContext, var7);
         } catch (IntentNotResolvableException var6) {
            MoPubLog.d("Unable to launch intent for URL: " + var1 + ".");
         }
      }
   }

   void handleOrientationChange(int var1) {
      this.updateScreenMetricsAsync((Runnable)null);
   }

   @VisibleForTesting
   void handlePageLoad() {
      this.setViewState(ViewState.DEFAULT, new Runnable() {
         public void run() {
            MraidController.this.mMraidBridge.notifySupports(MraidController.this.mMraidNativeCommandHandler.isSmsAvailable(MraidController.this.mContext), MraidController.this.mMraidNativeCommandHandler.isTelAvailable(MraidController.this.mContext), MraidNativeCommandHandler.isCalendarAvailable(MraidController.this.mContext), MraidNativeCommandHandler.isStorePictureSupported(MraidController.this.mContext), MraidController.this.isInlineVideoAvailable());
            MraidController.this.mMraidBridge.notifyPlacementType(MraidController.this.mPlacementType);
            MraidController.this.mMraidBridge.notifyViewability(MraidController.this.mMraidBridge.isVisible());
            MraidController.this.mMraidBridge.notifyReady();
         }
      });
      if(this.mMraidListener != null) {
         this.mMraidListener.onLoaded(this.mDefaultAdContainer);
      }

   }

   @VisibleForTesting
   void handleResize(int var1, int var2, int var3, int var4, CloseableLayout$ClosePosition var5, boolean var6) {
      if(this.mMraidWebView == null) {
         throw new MraidCommandException("Unable to resize after the WebView is destroyed");
      } else if(this.mViewState != ViewState.LOADING && this.mViewState != ViewState.HIDDEN) {
         if(this.mViewState == ViewState.EXPANDED) {
            throw new MraidCommandException("Not allowed to resize from an already expanded ad");
         } else if(this.mPlacementType == PlacementType.INTERSTITIAL) {
            throw new MraidCommandException("Not allowed to resize from an interstitial ad");
         } else {
            int var7 = Dips.dipsToIntPixels((float)var1, this.mContext);
            int var8 = Dips.dipsToIntPixels((float)var2, this.mContext);
            int var10 = Dips.dipsToIntPixels((float)var3, this.mContext);
            int var9 = Dips.dipsToIntPixels((float)var4, this.mContext);
            var10 += this.mScreenMetrics.getDefaultAdRect().left;
            var9 += this.mScreenMetrics.getDefaultAdRect().top;
            Rect var11 = new Rect(var10, var9, var7 + var10, var9 + var8);
            Rect var12;
            if(!var6) {
               var12 = this.mScreenMetrics.getRootViewRect();
               if(var11.width() > var12.width() || var11.height() > var12.height()) {
                  throw new MraidCommandException("resizeProperties specified a size (" + var1 + ", " + var2 + ") and offset (" + var3 + ", " + var4 + ") that doesn\'t allow the ad to appear within the max allowed size (" + this.mScreenMetrics.getRootViewRectDips().width() + ", " + this.mScreenMetrics.getRootViewRectDips().height() + ")");
               }

               var11.offsetTo(this.clampInt(var12.left, var11.left, var12.right - var11.width()), this.clampInt(var12.top, var11.top, var12.bottom - var11.height()));
            }

            var12 = new Rect();
            this.mCloseableAdContainer.applyCloseRegionBounds(var5, var11, var12);
            if(!this.mScreenMetrics.getRootViewRect().contains(var12)) {
               throw new MraidCommandException("resizeProperties specified a size (" + var1 + ", " + var2 + ") and offset (" + var3 + ", " + var4 + ") that doesn\'t allow the close region to appear within the max allowed size (" + this.mScreenMetrics.getRootViewRectDips().width() + ", " + this.mScreenMetrics.getRootViewRectDips().height() + ")");
            } else if(!var11.contains(var12)) {
               throw new MraidCommandException("resizeProperties specified a size (" + var1 + ", " + var8 + ") and offset (" + var3 + ", " + var4 + ") that don\'t allow the close region to appear within the resized ad.");
            } else {
               this.mCloseableAdContainer.setCloseVisible(false);
               this.mCloseableAdContainer.setClosePosition(var5);
               LayoutParams var13 = new LayoutParams(var11.width(), var11.height());
               var13.leftMargin = var11.left - this.mScreenMetrics.getRootViewRect().left;
               var13.topMargin = var11.top - this.mScreenMetrics.getRootViewRect().top;
               if(this.mViewState == ViewState.DEFAULT) {
                  this.mDefaultAdContainer.removeView(this.mMraidWebView);
                  this.mDefaultAdContainer.setVisibility(4);
                  this.mCloseableAdContainer.addView(this.mMraidWebView, new LayoutParams(-1, -1));
                  this.getRootView().addView(this.mCloseableAdContainer, var13);
               } else if(this.mViewState == ViewState.RESIZED) {
                  this.mCloseableAdContainer.setLayoutParams(var13);
               }

               this.mCloseableAdContainer.setClosePosition(var5);
               this.setViewState(ViewState.RESIZED);
            }
         }
      }
   }

   @VisibleForTesting
   void handleSetOrientationProperties(boolean var1, MraidOrientation var2) {
      if(!this.shouldAllowForceOrientation(var2)) {
         throw new MraidCommandException("Unable to force orientation to " + var2);
      } else {
         this.mAllowOrientationChange = var1;
         this.mForceOrientation = var2;
         if(this.mViewState == ViewState.EXPANDED || this.mPlacementType == PlacementType.INTERSTITIAL) {
            this.applyOrientation();
         }

      }
   }

   @VisibleForTesting
   void handleShowVideo(String var1) {
      MraidVideoPlayerActivity.startMraid(this.mContext, var1);
   }

   @VisibleForTesting
   void handleTwoPartPageLoad() {
      this.updateScreenMetricsAsync(new Runnable() {
         public void run() {
            MraidController.this.mTwoPartBridge.notifySupports(MraidController.this.mMraidNativeCommandHandler.isSmsAvailable(MraidController.this.mContext), MraidController.this.mMraidNativeCommandHandler.isTelAvailable(MraidController.this.mContext), MraidNativeCommandHandler.isCalendarAvailable(MraidController.this.mContext), MraidNativeCommandHandler.isStorePictureSupported(MraidController.this.mContext), MraidController.this.isInlineVideoAvailable());
            MraidController.this.mTwoPartBridge.notifyViewState(MraidController.this.mViewState);
            MraidController.this.mTwoPartBridge.notifyPlacementType(MraidController.this.mPlacementType);
            MraidController.this.mTwoPartBridge.notifyViewability(MraidController.this.mTwoPartBridge.isVisible());
            MraidController.this.mTwoPartBridge.notifyReady();
         }
      });
   }

   public void loadContent(String var1) {
      boolean var2;
      if(this.mMraidWebView == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkState(var2, "loadContent should only be called once");
      this.mMraidWebView = new MraidBridge$MraidWebView(this.mContext);
      this.mMraidBridge.attachView(this.mMraidWebView);
      this.mDefaultAdContainer.addView(this.mMraidWebView, new LayoutParams(-1, -1));
      this.mMraidBridge.setContentHtml(var1);
   }

   public void loadJavascript(String var1) {
      this.mMraidBridge.injectJavaScript(var1);
   }

   @VisibleForTesting
   void lockOrientation(int var1) {
      if(this.mActivity != null && this.shouldAllowForceOrientation(this.mForceOrientation)) {
         if(this.mOriginalActivityOrientation == null) {
            this.mOriginalActivityOrientation = Integer.valueOf(this.mActivity.getRequestedOrientation());
         }

         this.mActivity.setRequestedOrientation(var1);
      } else {
         throw new MraidCommandException("Attempted to lock orientation to unsupported value: " + this.mForceOrientation.name());
      }
   }

   public void pause() {
      this.mIsPaused = true;
      if(this.mMraidWebView != null) {
         WebViews.onPause(this.mMraidWebView);
      }

      if(this.mTwoPartWebView != null) {
         WebViews.onPause(this.mTwoPartWebView);
      }

   }

   public void resume() {
      this.mIsPaused = false;
      if(this.mMraidWebView != null) {
         WebViews.onResume(this.mMraidWebView);
      }

      if(this.mTwoPartWebView != null) {
         WebViews.onResume(this.mTwoPartWebView);
      }

   }

   public void setDebugListener(MraidWebViewDebugListener var1) {
      this.mDebugListener = var1;
   }

   public void setMraidListener(MraidController$MraidListener var1) {
      this.mMraidListener = var1;
   }

   @Deprecated
   @VisibleForTesting
   void setOrientationBroadcastReceiver(MraidController$OrientationBroadcastReceiver var1) {
      this.mOrientationBroadcastReceiver = var1;
   }

   @Deprecated
   @VisibleForTesting
   void setRootView(FrameLayout var1) {
      this.mRootView = var1;
   }

   @Deprecated
   @VisibleForTesting
   void setRootViewSize(int var1, int var2) {
      this.mScreenMetrics.setRootViewPosition(0, 0, var1, var2);
   }

   public void setUseCustomCloseListener(MraidController$UseCustomCloseListener var1) {
      this.mOnCloseButtonListener = var1;
   }

   @Deprecated
   @VisibleForTesting
   void setViewStateForTesting(ViewState var1) {
      this.mViewState = var1;
   }

   @TargetApi(13)
   @VisibleForTesting
   boolean shouldAllowForceOrientation(MraidOrientation var1) {
      if(var1 != MraidOrientation.NONE) {
         if(this.mActivity == null) {
            return false;
         }

         ActivityInfo var4;
         try {
            var4 = this.mActivity.getPackageManager().getActivityInfo(new ComponentName(this.mActivity, this.mActivity.getClass()), 0);
         } catch (NameNotFoundException var5) {
            return false;
         }

         int var2 = var4.screenOrientation;
         if(var2 != -1) {
            if(var2 != var1.getActivityInfoOrientation()) {
               return false;
            }
         } else {
            boolean var3 = Utils.bitMaskContainsFlag(var4.configChanges, 128);
            if(VERSION.SDK_INT < 13) {
               return var3;
            }

            if(!var3 || !Utils.bitMaskContainsFlag(var4.configChanges, 1024)) {
               return false;
            }
         }
      }

      return true;
   }

   @VisibleForTesting
   void unApplyOrientation() {
      if(this.mActivity != null && this.mOriginalActivityOrientation != null) {
         this.mActivity.setRequestedOrientation(this.mOriginalActivityOrientation.intValue());
      }

      this.mOriginalActivityOrientation = null;
   }
}
