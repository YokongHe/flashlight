package com.adsdk.sdk.banner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.AdRequest;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Gender;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.RequestGeneralAd;
import com.adsdk.sdk.Util;
import com.adsdk.sdk.banner.BannerAdView;
import com.adsdk.sdk.banner.BannerAdView$BannerAdViewListener;
import com.adsdk.sdk.banner.ReloadTask;
import com.adsdk.sdk.customevents.CustomEvent;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBanner$CustomEventBannerListener;
import com.adsdk.sdk.customevents.CustomEventBannerFactory;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$MraidListener;
import com.adsdk.sdk.mraid.MraidView$ViewState;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.List;
import java.util.Timer;

public class AdView extends FrameLayout {
   private static final int CUSTOM_EVENT_RELOAD_INTERVAL = 30;
   public static final int LIVE = 0;
   public static final int TEST = 1;
   private FrameLayout MRAIDFrame;
   private AdListener adListener;
   private int adspaceHeight;
   private boolean adspaceStrict;
   private int adspaceWidth;
   private boolean animation;
   private CustomEventBanner$CustomEventBannerListener customAdListener;
   private CustomEventBanner customEventBanner;
   private View customEventBannerView;
   private final Handler handler;
   private boolean includeLocation;
   private boolean isInternalBrowser;
   private List keywords;
   private Thread loadContentThread;
   private BannerAdView mBannerView;
   private Context mContext;
   protected boolean mIsInForeground;
   private MraidView mMRAIDView;
   private BroadcastReceiver mScreenStateReceiver;
   private String publisherId;
   private Timer reloadTimer;
   private AdRequest request;
   private String requestURL;
   private AdResponse response;
   private boolean shouldNotifyClose;
   private final Runnable showContent;
   private int userAge;
   private Gender userGender;
   private InputStream xml;

   public AdView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.includeLocation = false;
      this.isInternalBrowser = false;
      this.requestURL = null;
      this.mContext = null;
      this.handler = new Handler();
      this.showContent = new Runnable() {
         public void run() {
            try {
               AdView.this.showContent();
            } catch (Exception var2) {
               AdView.this.notifyLoadAdFailed(var2);
            }
         }
      };
      this.mContext = var1;
      if(var2 != null) {
         int var4 = var2.getAttributeCount();

         for(int var3 = 0; var3 < var4; ++var3) {
            String var5 = var2.getAttributeName(var3);
            if(var5.equals("publisherId")) {
               this.publisherId = var2.getAttributeValue(var3);
            } else if(var5.equals("request_url")) {
               this.requestURL = var2.getAttributeValue(var3);
            } else if(var5.equals("animation")) {
               this.animation = var2.getAttributeBooleanValue(var3, false);
            } else if(var5.equals("location")) {
               this.includeLocation = var2.getAttributeBooleanValue(var3, false);
            } else if(var5.equals("adspaceStrict")) {
               this.adspaceStrict = var2.getAttributeBooleanValue(var3, false);
            } else if(var5.equals("adspaceWidth")) {
               this.adspaceWidth = var2.getAttributeIntValue(var3, 0);
            } else if(var5.equals("adspaceHeight")) {
               this.adspaceHeight = var2.getAttributeIntValue(var3, 0);
            }
         }
      }

      this.initialize(var1);
   }

   public AdView(Context var1, InputStream var2, String var3, String var4, boolean var5, boolean var6) {
      super(var1);
      this.includeLocation = false;
      this.isInternalBrowser = false;
      this.requestURL = null;
      this.mContext = null;
      this.handler = new Handler();
      this.showContent = new Runnable() {
         public void run() {
            try {
               AdView.this.showContent();
            } catch (Exception var2) {
               AdView.this.notifyLoadAdFailed(var2);
            }
         }
      };
      this.xml = var2;
      this.requestURL = var3;
      this.mContext = var1;
      this.publisherId = var4;
      this.includeLocation = var5;
      this.animation = var6;
      this.initialize(var1);
   }

   public AdView(Context var1, String var2, InputStream var3, String var4, boolean var5, boolean var6) {
      this(var1, var3, var2, var4, var5, var6);
   }

   public AdView(Context var1, String var2, String var3) {
      this(var1, var2, var3, false, false);
   }

   public AdView(Context var1, String var2, String var3, boolean var4, boolean var5) {
      this(var1, var2, var3, var4, var5, (AdListener)null);
   }

   public AdView(Context var1, String var2, String var3, boolean var4, boolean var5, AdListener var6) {
      boolean var7 = false;
      super(var1);
      this.includeLocation = false;
      this.isInternalBrowser = false;
      this.requestURL = null;
      this.mContext = null;
      this.handler = new Handler();
      this.showContent = new Runnable() {
         public void run() {
            try {
               AdView.this.showContent();
            } catch (Exception var2) {
               AdView.this.notifyLoadAdFailed(var2);
            }
         }
      };
      this.requestURL = var2;
      this.mContext = var1;
      this.publisherId = var3;
      this.includeLocation = var4;
      this.animation = var5;
      this.adListener = var6;
      StringBuilder var8 = new StringBuilder("AdListener: ");
      var4 = var7;
      if(this.adListener == null) {
         var4 = true;
      }

      Log.d(var8.append(var4).toString());
      this.initialize(var1);
   }

   private void addMRAIDBannerView() {
      float var1 = this.mContext.getResources().getDisplayMetrics().density;
      if(this.adspaceHeight != 0 && this.adspaceWidth != 0) {
         this.addView(this.MRAIDFrame, new LayoutParams((int)((float)this.adspaceWidth * var1 + 0.5F), (int)(var1 * (float)this.adspaceHeight + 0.5F)));
      } else {
         this.addView(this.MRAIDFrame, new LayoutParams(-2, (int)(var1 * 50.0F + 0.5F)));
      }
   }

   private BannerAdView$BannerAdViewListener createBannerAdViewListener() {
      return new BannerAdView$BannerAdViewListener() {
         public void onClick() {
            AdView.this.shouldNotifyClose = true;
            AdView.this.notifyAdClicked();
            AdView.this.notifyAdShown();
         }

         public void onLoad() {
            AdView.this.notifyLoadAdSucceeded();
         }
      };
   }

   private CustomEventBanner$CustomEventBannerListener createCustomAdListener() {
      return new CustomEventBanner$CustomEventBannerListener() {
         public void onBannerClosed() {
            if(AdView.this.shouldNotifyClose) {
               AdView.this.shouldNotifyClose = false;
               AdView.this.notifyAdClosed();
            }

         }

         public void onBannerExpanded() {
            AdView.this.shouldNotifyClose = true;
            AdView.this.notifyAdClicked();
            AdView.this.notifyAdShown();
         }

         public void onBannerFailed() {
            AdView.this.destroyCustomEventBanner();
            AdView.this.loadCustomEventBanner();
            if(AdView.this.customEventBanner == null) {
               if(AdView.this.mBannerView != null) {
                  AdView.this.mBannerView.showContent();
                  AdView.this.addView(AdView.this.mBannerView);
               } else if(AdView.this.mMRAIDView != null) {
                  AdView.this.addMRAIDBannerView();
               } else {
                  AdView.this.notifyNoAd();
               }
            }
         }

         public void onBannerLoaded(View var1) {
            if(AdView.this.customEventBannerView != null) {
               AdView.this.removeView(AdView.this.customEventBannerView);
            }

            AdView.this.customEventBannerView = var1;
            AdView.this.addView(var1);
            AdView.this.notifyLoadAdSucceeded();
         }
      };
   }

   private MraidView$MraidListener createMraidListener() {
      return new MraidView$MraidListener() {
         public void onClose(MraidView var1, MraidView$ViewState var2) {
            AdView.this.notifyAdClosed();
         }

         public void onExpand(MraidView var1) {
            AdView.this.notifyAdClicked();
            AdView.this.notifyAdShown();
         }

         public void onFailure(MraidView var1) {
            AdView.this.notifyNoAd();
         }

         public void onReady(MraidView var1) {
            AdView.this.notifyLoadAdSucceeded();
         }
      };
   }

   private void destroyCustomEventBanner() {
      if(this.customEventBanner != null) {
         this.customEventBanner.destroy();
      }

   }

   private AdRequest getRequest() {
      if(this.request == null) {
         this.request = new AdRequest();
         this.request.setAndroidAdId(Util.getAndroidAdId());
         this.request.setAdDoNotTrack(Util.hasAdDoNotTrack());
         this.request.setPublisherId(this.publisherId);
         this.request.setUserAgent(Util.getDefaultUserAgentString(this.mContext));
         this.request.setUserAgent2(Util.buildUserAgent());
         Log.d("ADSDK", "WebKit UserAgent:" + this.request.getUserAgent());
         Log.d("ADSDK", "SDK built UserAgent:" + this.request.getUserAgent2());
      }

      this.request.setGender(this.userGender);
      this.request.setUserAge(this.userAge);
      this.request.setKeywords(this.keywords);
      Location var1 = null;
      if(this.includeLocation) {
         var1 = Util.getLocation(this.mContext);
      }

      if(var1 != null) {
         Log.d("ADSDK", "location is longitude: " + var1.getLongitude() + ", latitude: " + var1.getLatitude());
         this.request.setLatitude(var1.getLatitude());
         this.request.setLongitude(var1.getLongitude());
      } else {
         this.request.setLatitude(0.0D);
         this.request.setLongitude(0.0D);
      }

      this.request.setAdspaceHeight(this.adspaceHeight);
      this.request.setAdspaceWidth(this.adspaceWidth);
      this.request.setAdspaceStrict(this.adspaceStrict);
      this.request.setRequestURL(this.requestURL);
      return this.request;
   }

   private void initialize(Context var1) {
      Log.LOGGING_ENABLED = Log.isLoggingEnabled(this.mContext);
      Log.d("ADSDK", "SDK Version:6.0.7");
      this.registerScreenStateBroadcastReceiver();
      Util.prepareAndroidAdId(var1);
      this.customAdListener = this.createCustomAdListener();
   }

   private void loadContent() {
      Log.d("ADSDK", "load content");
      if(this.loadContentThread == null) {
         this.loadContentThread = new Thread(new Runnable() {
            public void run() {
               Log.d("ADSDK", "starting request thread");
               RequestGeneralAd var1;
               if(AdView.this.xml == null) {
                  var1 = new RequestGeneralAd();
               } else {
                  var1 = new RequestGeneralAd(AdView.this.xml);
               }

               try {
                  AdView.this.response = (AdResponse)var1.sendRequest(AdView.this.getRequest());
                  if(AdView.this.response != null) {
                     Log.d("ADSDK", "response received");
                     Log.d("ADSDK", "getVisibility: " + AdView.this.getVisibility());
                     AdView.this.handler.post(AdView.this.showContent);
                  }
               } catch (Throwable var2) {
                  AdView.this.notifyLoadAdFailed(var2);
               }

               AdView.this.loadContentThread = null;
               Log.d("ADSDK", "finishing request thread");
            }
         });
         this.loadContentThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread var1, Throwable var2) {
               Log.e("ADSDK", "Exception in request thread", var2);
               AdView.this.loadContentThread = null;
            }
         });
         this.loadContentThread.start();
      }

   }

   private void loadCustomEventBanner() {
      this.customEventBanner = null;

      while(!this.response.getCustomEvents().isEmpty() && this.customEventBanner == null) {
         try {
            final CustomEvent var1 = (CustomEvent)this.response.getCustomEvents().get(0);
            this.response.getCustomEvents().remove(var1);
            this.customEventBanner = CustomEventBannerFactory.create(var1.getClassName());
            this.handler.post(new Runnable() {
               public void run() {
                  if(AdView.this.adspaceHeight != 0 && AdView.this.adspaceWidth != 0) {
                     AdView.this.customEventBanner.loadBanner(AdView.this.mContext, AdView.this.customAdListener, var1.getOptionalParameter(), var1.getPixelUrl(), AdView.this.adspaceWidth, AdView.this.adspaceHeight);
                  } else {
                     AdView.this.customEventBanner.loadBanner(AdView.this.mContext, AdView.this.customAdListener, var1.getOptionalParameter(), var1.getPixelUrl(), 300, 50);
                  }
               }
            });
         } catch (Exception var2) {
            this.customEventBanner = null;
            Log.d("Failed to create Custom Event Banner.");
         }
      }

   }

   private void notifyAdClicked() {
      this.handler.post(new Runnable() {
         public void run() {
            if(AdView.this.adListener != null) {
               AdView.this.adListener.adClicked();
            }

         }
      });
   }

   private void notifyAdClosed() {
      this.handler.post(new Runnable() {
         public void run() {
            if(AdView.this.adListener != null) {
               AdView.this.adListener.adClosed(AdView.this.response, true);
            }

         }
      });
   }

   private void notifyAdShown() {
      this.handler.post(new Runnable() {
         public void run() {
            if(AdView.this.adListener != null) {
               AdView.this.adListener.adShown(AdView.this.response, true);
            }

         }
      });
   }

   private void notifyLoadAdFailed(final Throwable var1) {
      this.handler.post(new Runnable() {
         public void run() {
            Log.e("ADSDK", "Exception when building ad:", var1);
            if(AdView.this.adListener != null) {
               Log.d("ADSDK", "notify bannerListener: " + AdView.this.adListener.getClass().getName());
               AdView.this.adListener.noAdFound();
            }

         }
      });
   }

   private void notifyLoadAdSucceeded() {
      this.handler.post(new Runnable() {
         public void run() {
            if(AdView.this.adListener != null) {
               AdView.this.adListener.adLoadSucceeded(AdView.this.response);
            }

         }
      });
   }

   private void notifyNoAd() {
      this.handler.post(new Runnable() {
         public void run() {
            Log.d("ADSDK", "No Ad");
            if(AdView.this.adListener != null) {
               AdView.this.adListener.noAdFound();
            }

         }
      });
   }

   private void registerScreenStateBroadcastReceiver() {
      this.mScreenStateReceiver = new BroadcastReceiver() {
         public void onReceive(Context var1, Intent var2) {
            if(var2.getAction().equals("android.intent.action.SCREEN_OFF")) {
               if(!AdView.this.mIsInForeground) {
                  Log.d("ADSDK", "Screen sleep but ad in background; refresh should already be disabled");
                  return;
               }

               Log.d("ADSDK", "Screen sleep with ad in foreground, disable refresh");
               AdView.this.pause();
            } else if(var2.getAction().equals("android.intent.action.USER_PRESENT")) {
               if(AdView.this.mIsInForeground) {
                  AdView.this.resume();
                  Log.d("ADSDK", "Screen wake / ad in foreground, reset refresh");
                  return;
               }

               Log.d("ADSDK", "Screen wake but ad in background; don\'t enable refresh");
               return;
            }

         }
      };
      IntentFilter var1 = new IntentFilter("android.intent.action.SCREEN_OFF");
      var1.addAction("android.intent.action.USER_PRESENT");
      this.mContext.registerReceiver(this.mScreenStateReceiver, var1);
   }

   private void showContent() {
      this.shouldNotifyClose = false;
      if(this.mBannerView != null) {
         this.removeView(this.mBannerView);
         this.mBannerView = null;
      }

      if(this.mMRAIDView != null) {
         this.mMRAIDView.destroy();
         this.removeView(this.mMRAIDView);
         this.mMRAIDView = null;
      }

      if(this.MRAIDFrame != null) {
         this.removeView(this.MRAIDFrame);
         this.MRAIDFrame = null;
      }

      if(this.customEventBannerView != null) {
         this.removeView(this.customEventBannerView);
         this.customEventBannerView = null;
      }

      this.destroyCustomEventBanner();
      if(this.response.getType() == 1 || this.response.getType() == 0) {
         this.mBannerView = new BannerAdView(this.mContext, this.response, this.adspaceWidth, this.adspaceHeight, this.animation, this.createBannerAdViewListener());
         if(this.response.getCustomEvents().isEmpty()) {
            this.mBannerView.showContent();
            this.addView(this.mBannerView);
         }
      }

      if(this.response.getType() == 4) {
         this.mMRAIDView = new MraidView(this.mContext);
         this.MRAIDFrame = new FrameLayout(this.mContext);
         this.MRAIDFrame.addView(this.mMRAIDView);
         if(this.response.getCustomEvents().isEmpty()) {
            this.addMRAIDBannerView();
         }

         this.mMRAIDView.setMraidListener(this.createMraidListener());
         this.mMRAIDView.loadHtmlData(this.response.getText());
      }

      if(this.response.getType() == 2 && this.response.getCustomEvents().isEmpty()) {
         this.notifyNoAd();
      }

      if(!this.response.getCustomEvents().isEmpty()) {
         this.loadCustomEventBanner();
         if(this.customEventBanner == null) {
            this.response.getCustomEvents().clear();
            this.customAdListener.onBannerFailed();
         } else {
            this.response.setRefresh(30);
         }
      }

      this.startReloadTimer();
   }

   private void startReloadTimer() {
      Log.d("ADSDK", "start reload timer");
      if(this.reloadTimer != null && this.response.getRefresh() > 0) {
         int var1 = this.response.getRefresh() * 1000;
         Log.d("ADSDK", "set timer: " + var1);
         ReloadTask var2 = new ReloadTask(this);
         this.reloadTimer.schedule(var2, (long)var1);
      }
   }

   private void unregisterScreenStateBroadcastReceiver() {
      try {
         this.mContext.unregisterReceiver(this.mScreenStateReceiver);
      } catch (Exception var2) {
         Log.d("Failed to unregister screen state broadcast receiver (never registered).");
      }
   }

   protected void finalize() {
      this.unregisterScreenStateBroadcastReceiver();
      this.destroyCustomEventBanner();
      super.finalize();
   }

   public int getRefreshRate() {
      return this.response != null?this.response.getRefresh():-1;
   }

   public boolean isInternalBrowser() {
      return this.isInternalBrowser;
   }

   public void loadNextAd() {
      Log.d("ADSDK", "load next ad");
      this.loadContent();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      IntentFilter var1 = new IntentFilter("android.intent.action.SCREEN_OFF");
      var1.addAction("android.intent.action.USER_PRESENT");
      this.mContext.registerReceiver(this.mScreenStateReceiver, var1);
      Log.v("ADSDK", "onAttachedToWindow");
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.unregisterScreenStateBroadcastReceiver();
      Log.v("ADSDK", "onDetachedFromWindow");
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      if(var1 == 0) {
         this.mIsInForeground = true;
         this.resume();
      } else {
         this.mIsInForeground = false;
         this.pause();
      }

      Log.d("ADSDK", "onWindowVisibilityChanged: " + var1);
   }

   public void pause() {
      if(this.reloadTimer != null) {
         try {
            Log.d("ADSDK", "cancel reload timer");
            this.reloadTimer.cancel();
            this.reloadTimer = null;
         } catch (Exception var2) {
            Log.e("ADSDK", "unable to cancel reloadTimer", var2);
            return;
         }
      }

   }

   public void release() {
      this.unregisterScreenStateBroadcastReceiver();
      this.destroyCustomEventBanner();
      if(this.mMRAIDView != null) {
         this.mMRAIDView.destroy();
      }

   }

   public void resume() {
      if(this.reloadTimer != null) {
         this.reloadTimer.cancel();
         this.reloadTimer = null;
      }

      this.reloadTimer = new Timer();
      if(this.shouldNotifyClose) {
         this.shouldNotifyClose = false;
         this.notifyAdClosed();
      }

      Log.d("ADSDK", "response: " + this.response);
      if(this.response != null && this.response.getRefresh() > 0) {
         this.startReloadTimer();
      } else if(this.response == null || this.mMRAIDView == null && this.mBannerView == null) {
         this.loadContent();
         return;
      }

   }

   public void setAdListener(AdListener var1) {
      this.adListener = var1;
      if(this.mMRAIDView != null) {
         this.mMRAIDView.setMraidListener(this.createMraidListener());
      }

      if(this.mBannerView != null) {
         this.mBannerView.setAdListener(this.createBannerAdViewListener());
      }

   }

   public void setAdspaceHeight(int var1) {
      this.adspaceHeight = var1;
   }

   public void setAdspaceStrict(boolean var1) {
      this.adspaceStrict = var1;
   }

   public void setAdspaceWidth(int var1) {
      this.adspaceWidth = var1;
   }

   public void setInternalBrowser(boolean var1) {
      this.isInternalBrowser = var1;
   }

   public void setKeywords(List var1) {
      this.keywords = var1;
   }

   public void setUserAge(int var1) {
      this.userAge = var1;
   }

   public void setUserGender(Gender var1) {
      this.userGender = var1;
   }
}
