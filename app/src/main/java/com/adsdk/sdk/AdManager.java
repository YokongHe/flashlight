package com.adsdk.sdk;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.AdRequest;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Gender;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.Util;
import com.adsdk.sdk.customevents.CustomEvent;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreen$CustomEventFullscreenListener;
import com.adsdk.sdk.customevents.CustomEventFullscreenFactory;
import com.adsdk.sdk.video.ResourceManager;
import com.adsdk.sdk.video.TrackerService;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.List;

public class AdManager {
   private static Context mContext;
   private static HashMap sRunningAds = new HashMap();
   private boolean adDoNotTrack;
   private boolean alreadyRequestedInterstitial;
   private boolean alreadyRequestedVideo;
   private String androidAdId;
   private CustomEventFullscreen customEventFullscreen;
   private CustomEventFullscreen$CustomEventFullscreenListener customFullscreenListener;
   private String interstitialRequestURL;
   private boolean isInterstitialAdsEnabled = true;
   private boolean isVideoAdsEnabled;
   private List keywords;
   private boolean mEnabled = true;
   private Handler mHandler;
   private boolean mIncludeLocation;
   private AdListener mListener;
   private String mPublisherId;
   private Thread mRequestThread;
   private AdResponse mResponse;
   private boolean prioritizeVideoAds;
   private AdRequest request = null;
   private boolean requestedHorizontalAd;
   private int userAge;
   private Gender userGender;
   private int videoMaxDuration;
   private int videoMinimalDuration;

   public AdManager(Context var1, String var2, String var3, boolean var4) {
      Util.prepareAndroidAdId(var1);
      setmContext(var1);
      this.interstitialRequestURL = var2;
      this.mPublisherId = var3;
      this.mIncludeLocation = var4;
      this.mRequestThread = null;
      this.mHandler = new Handler();
      this.initialize();
   }

   // $FF: synthetic method
   static boolean access$1(AdManager var0) {
      return var0.prioritizeVideoAds;
   }

   // $FF: synthetic method
   static AdRequest access$12(AdManager var0) {
      return var0.request;
   }

   // $FF: synthetic method
   static AdRequest access$3(AdManager var0) {
      return var0.getInterstitialRequest();
   }

   // $FF: synthetic method
   static void access$4(AdManager var0, AdRequest var1) {
      var0.request = var1;
   }

   // $FF: synthetic method
   static void access$5(AdManager var0, boolean var1) {
      var0.alreadyRequestedInterstitial = var1;
   }

   // $FF: synthetic method
   static AdRequest access$8(AdManager var0) {
      return var0.getVideoRequest();
   }

   // $FF: synthetic method
   static void access$9(AdManager var0, boolean var1) {
      var0.alreadyRequestedVideo = var1;
   }

   public static void closeRunningAd(AdResponse var0, boolean var1) {
      AdManager var2 = (AdManager)sRunningAds.remove(Long.valueOf(var0.getTimestamp()));
      if(var2 == null) {
         Log.d("Cannot find AdManager with running ad:" + var0.getTimestamp());
      } else {
         Log.d("Notify closing event to AdManager with running ad:" + var0.getTimestamp());
         var2.notifyAdClose(var0, var1);
      }
   }

   private CustomEventFullscreen$CustomEventFullscreenListener createCustomFullscreenListener() {
      return new CustomEventFullscreen$CustomEventFullscreenListener() {
         public void onFullscreenClosed() {
            AdManager.this.finishCustomEventFullscreen();
            AdManager.this.notifyAdClose(AdManager.this.mResponse, true);
         }

         public void onFullscreenFailed() {
            AdManager.this.finishCustomEventFullscreen();
            AdManager.this.loadCustomEventFullscreen();
            if(AdManager.this.customEventFullscreen == null) {
               if(AdManager.this.mResponse.getType() != 2 && AdManager.this.mResponse.getType() != -1) {
                  AdManager.this.notifyAdLoaded(AdManager.this.mResponse);
               } else if((!AdManager.this.isVideoAdsEnabled || AdManager.this.alreadyRequestedVideo) && (!AdManager.this.isInterstitialAdsEnabled || AdManager.this.alreadyRequestedInterstitial)) {
                  AdManager.this.notifyNoAdFound();
               } else {
                  AdManager.this.requestAdInternal(true);
               }
            }
         }

         public void onFullscreenLeftApplication() {
            AdManager.this.notifyAdClicked();
         }

         public void onFullscreenLoaded(CustomEventFullscreen var1) {
            AdManager.this.customEventFullscreen = var1;
            AdManager.this.notifyAdLoaded(AdManager.this.mResponse);
         }

         public void onFullscreenOpened() {
         }
      };
   }

   private void finishCustomEventFullscreen() {
      if(this.customEventFullscreen != null) {
         this.customEventFullscreen.finish();
      }

   }

   public static AdManager getAdManager(AdResponse var0) {
      AdManager var1 = (AdManager)sRunningAds.remove(Long.valueOf(var0.getTimestamp()));
      if(var1 == null) {
         Log.d("Cannot find AdManager with running ad:" + var0.getTimestamp());
      }

      return var1;
   }

   private Context getContext() {
      return getmContext();
   }

   private AdRequest getInterstitialRequest() {
      if(this.request == null) {
         this.request = new AdRequest();
         this.request.setAndroidAdId(this.androidAdId);
         this.request.setAdDoNotTrack(this.adDoNotTrack);
         this.request.setPublisherId(this.mPublisherId);
         this.request.setUserAgent(Util.getDefaultUserAgentString(mContext));
         this.request.setUserAgent2(Util.buildUserAgent());
      }

      Location var1 = null;
      this.request.setVideoRequest(false);
      this.request.setGender(this.userGender);
      this.request.setUserAge(this.userAge);
      this.request.setKeywords(this.keywords);
      if(this.mIncludeLocation) {
         var1 = Util.getLocation(mContext);
      }

      if(var1 != null) {
         Log.d("location is longitude: " + var1.getLongitude() + ", latitude: " + var1.getLatitude());
         this.request.setLatitude(var1.getLatitude());
         this.request.setLongitude(var1.getLongitude());
      } else {
         this.request.setLatitude(0.0D);
         this.request.setLongitude(0.0D);
      }

      if(mContext.getResources().getConfiguration().orientation == 2) {
         this.requestedHorizontalAd = true;
         this.request.setAdspaceHeight(320);
         this.request.setAdspaceWidth(480);
      } else {
         this.requestedHorizontalAd = false;
         this.request.setAdspaceHeight(480);
         this.request.setAdspaceWidth(320);
      }

      this.request.setAdspaceStrict(false);
      this.request.setConnectionType(Util.getConnectionType(this.getContext()));
      this.request.setIpAddress(Util.getLocalIpAddress());
      this.request.setTimestamp(System.currentTimeMillis());
      this.request.setRequestURL(this.interstitialRequestURL);
      return this.request;
   }

   private AdRequest getVideoRequest() {
      if(this.request == null) {
         this.request = new AdRequest();
         this.request.setAndroidAdId(this.androidAdId);
         this.request.setAdDoNotTrack(this.adDoNotTrack);
         this.request.setPublisherId(this.mPublisherId);
         this.request.setUserAgent(Util.getDefaultUserAgentString(mContext));
         this.request.setUserAgent2(Util.buildUserAgent());
      }

      this.request.setGender(this.userGender);
      this.request.setUserAge(this.userAge);
      this.request.setKeywords(this.keywords);
      this.request.setVideoRequest(true);
      this.request.setVideoMaxDuration(this.videoMaxDuration);
      this.request.setVideoMinDuration(this.videoMinimalDuration);
      Location var1 = null;
      if(this.mIncludeLocation) {
         var1 = Util.getLocation(mContext);
      }

      if(var1 != null) {
         Log.d("location is longitude: " + var1.getLongitude() + ", latitude: " + var1.getLatitude());
         this.request.setLatitude(var1.getLatitude());
         this.request.setLongitude(var1.getLongitude());
      } else {
         this.request.setLatitude(0.0D);
         this.request.setLongitude(0.0D);
      }

      this.request.setAdspaceHeight(480);
      this.request.setAdspaceWidth(320);
      this.request.setAdspaceStrict(false);
      this.request.setConnectionType(Util.getConnectionType(this.getContext()));
      this.request.setIpAddress(Util.getLocalIpAddress());
      this.request.setTimestamp(System.currentTimeMillis());
      this.request.setRequestURL(this.interstitialRequestURL);
      return this.request;
   }

   private static Context getmContext() {
      return mContext;
   }

   private void initialize() {
      Log.LOGGING_ENABLED = Log.isLoggingEnabled(getmContext());
      Log.d("Ad SDK Version:6.0.7");
      this.androidAdId = Util.getAndroidAdId();
      this.adDoNotTrack = Util.hasAdDoNotTrack();
      if(this.mPublisherId != null && this.mPublisherId.length() != 0) {
         Log.d("AdManager Publisher Id:" + this.mPublisherId + " Advertising Id:" + this.androidAdId);
         boolean var1;
         if(Util.getMemoryClass(this.getContext()) > 16) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.mEnabled = var1;
         this.customFullscreenListener = this.createCustomFullscreenListener();
      } else {
         Log.e("Publisher Id cannot be null or empty");
         throw new IllegalArgumentException("User Id cannot be null or empty");
      }
   }

   private void loadCustomEventFullscreen() {
      this.customEventFullscreen = null;
      if(this.mResponse != null && this.mResponse.getCustomEvents() != null) {
         while(!this.mResponse.getCustomEvents().isEmpty()) {
            if(this.customEventFullscreen != null) {
               return;
            }

            try {
               final CustomEvent var1 = (CustomEvent)this.mResponse.getCustomEvents().get(0);
               this.mResponse.getCustomEvents().remove(var1);
               this.customEventFullscreen = CustomEventFullscreenFactory.create(var1.getClassName());
               this.mHandler.post(new Runnable() {
                  public void run() {
                     try {
                        Activity var1x = (Activity)AdManager.this.getContext();
                        AdManager.this.customEventFullscreen.loadFullscreen(var1x, AdManager.this.customFullscreenListener, var1.getOptionalParameter(), var1.getPixelUrl());
                     } catch (Exception var2) {
                        AdManager.this.customEventFullscreen = null;
                        Log.d("Failed to create Custom Event Fullscreen.");
                     }
                  }
               });
            } catch (Exception var2) {
               this.customEventFullscreen = null;
               Log.d("Failed to create Custom Event Fullscreen.");
            }
         }
      }

   }

   public static void notifyAdClick(AdResponse var0) {
      AdManager var1 = (AdManager)sRunningAds.get(Long.valueOf(var0.getTimestamp()));
      if(var1 != null) {
         var1.notifyAdClicked();
      }

   }

   private void notifyAdClicked() {
      if(this.mListener != null) {
         this.mHandler.post(new Runnable() {
            public void run() {
               AdManager.this.mListener.adClicked();
            }
         });
      }

   }

   private void notifyAdClose(final AdResponse var1, final boolean var2) {
      if(this.mListener != null) {
         Log.d("Ad Close. Result:" + var2);
         this.mHandler.post(new Runnable() {
            public void run() {
               AdManager.this.mListener.adClosed(var1, var2);
            }
         });
      }

   }

   private void notifyAdLoaded(final AdResponse var1) {
      if(this.mListener != null) {
         this.mHandler.post(new Runnable() {
            public void run() {
               AdManager.this.mListener.adLoadSucceeded(var1);
            }
         });
      }

   }

   private void notifyAdShown(final AdResponse var1, final boolean var2) {
      if(this.mListener != null) {
         Log.d("Ad Shown. Result:" + var2);
         this.mHandler.post(new Runnable() {
            public void run() {
               AdManager.this.mListener.adShown(var1, var2);
            }
         });
      }

      this.mResponse = null;
   }

   private void notifyNoAdFound() {
      if(this.mListener != null) {
         Log.d("No ad found.");
         this.mHandler.post(new Runnable() {
            public void run() {
               AdManager.this.mListener.noAdFound();
            }
         });
      }

      this.mResponse = null;
   }

   private void requestAdInternal(boolean var1) {
      if(!this.mEnabled) {
         Log.w("Cannot request rich adds on low memory devices");
      } else {
         if(!var1) {
            this.alreadyRequestedInterstitial = false;
            this.alreadyRequestedVideo = false;
         }

         if(this.mRequestThread == null) {
            Log.d("Requesting Ad (v6.0.7-3.0)");
            this.mResponse = null;
            if(!this.isVideoAdsEnabled) {
               this.prioritizeVideoAds = false;
            }

            this.mRequestThread = new Thread(new Runnable() {
               public void run() {
                  // $FF: Couldn't be decompiled
               }
            });
            this.mRequestThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
               public void uncaughtException(Thread var1, Throwable var2) {
                  AdManager.this.mResponse = new AdResponse();
                  AdManager.this.mResponse.setType(-1);
                  Log.e("Handling exception in ad request thread", var2);
                  AdManager.this.mRequestThread = null;
               }
            });
            this.mRequestThread.start();
         } else {
            Log.w("Request thread already running");
         }
      }
   }

   private static void setmContext(Context var0) {
      mContext = var0;
   }

   public int getVideoMaxDuration() {
      return this.videoMaxDuration;
   }

   public int getVideoMinimalDuration() {
      return this.videoMinimalDuration;
   }

   public boolean isAdLoaded() {
      return this.mResponse != null;
   }

   public boolean isPrioritizeVideoAds() {
      return this.prioritizeVideoAds;
   }

   public void release() {
      TrackerService.release();
      this.finishCustomEventFullscreen();
      ResourceManager.cancel();
   }

   public void requestAd() {
      this.requestAdInternal(false);
   }

   public void requestAd(final InputStream var1) {
      if(!this.mEnabled) {
         Log.w("Cannot request rich adds on low memory devices");
      } else {
         this.alreadyRequestedInterstitial = false;
         this.alreadyRequestedVideo = false;
         if(this.mRequestThread == null) {
            Log.d("Requesting Ad (v6.0.7-3.0)");
            this.mResponse = null;
            this.mRequestThread = new Thread(new Runnable() {
               public void run() {
                  // $FF: Couldn't be decompiled
               }
            });
            this.mRequestThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
               public void uncaughtException(Thread var1, Throwable var2) {
                  AdManager.this.mResponse = new AdResponse();
                  AdManager.this.mResponse.setType(-1);
                  Log.e("Handling exception in ad request thread", var2);
                  AdManager.this.mRequestThread = null;
               }
            });
            this.mRequestThread.start();
         } else {
            Log.w("Request thread already running");
         }
      }
   }

   public void requestAdAndShow(long var1) {
      AdListener var7 = this.mListener;
      this.mListener = null;
      this.requestAd();
      long var5 = System.currentTimeMillis();

      for(long var3 = var5; !this.isAdLoaded() && var3 < var5 + var1; var3 = System.currentTimeMillis()) {
         try {
            Thread.sleep(200L);
         } catch (InterruptedException var9) {
            ;
         }
      }

      this.mListener = var7;
      this.showAd();
   }

   public void setInterstitialAdsEnabled(boolean var1) {
      this.isInterstitialAdsEnabled = var1;
   }

   public void setInterstitialRequestURL(String var1) {
      this.interstitialRequestURL = var1;
   }

   public void setKeywords(List var1) {
      this.keywords = var1;
   }

   public void setListener(AdListener var1) {
      this.mListener = var1;
   }

   public void setPrioritizeVideoAds(boolean var1) {
      this.prioritizeVideoAds = var1;
   }

   public void setUserAge(int var1) {
      this.userAge = var1;
   }

   public void setUserGender(Gender var1) {
      this.userGender = var1;
   }

   public void setVideoAdsEnabled(boolean var1) {
      this.isVideoAdsEnabled = var1;
   }

   public void setVideoMaxDuration(int var1) {
      this.videoMaxDuration = var1;
   }

   public void setVideoMinimalDuration(int var1) {
      this.videoMinimalDuration = var1;
   }

   public void showAd() {
      // $FF: Couldn't be decompiled
   }
}
