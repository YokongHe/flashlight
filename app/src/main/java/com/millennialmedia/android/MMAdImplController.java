package com.millennialmedia.android;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.AdCache$AdCacheTaskListener;
import com.millennialmedia.android.CachedAd;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.HttpMMHeaders;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMAdImplController$RequestAdRunnable;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMInterstitial$MMInterstitialAdImpl;
import com.millennialmedia.android.MMLayout;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.MMSDK$Event;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.Utils$ThreadUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

class MMAdImplController implements AdCache$AdCacheTaskListener {
   static final long NO_ID_RETURNED = -4L;
   private static final String TAG = "MMAdImplController";
   private static final Map saveableControllers = new ConcurrentHashMap();
   private static final Map weakUnsaveableAdRef = new ConcurrentHashMap();
   volatile WeakReference adImplRef;
   volatile long linkedAdImplId;
   MMAdImplController$RequestAdRunnable requestAdRunnable;
   volatile MMWebView webView;

   private MMAdImplController(MMAdImpl var1) {
      MMLog.d("MMAdImplController", "**************** creating new controller.");
      this.adImplRef = new WeakReference(var1);
      if(var1.linkForExpansionId != 0L) {
         this.linkForExpansion(var1);
         this.webView = getWebViewFromExistingAdImpl(var1);
      } else if(!(var1 instanceof MMInterstitial$MMInterstitialAdImpl)) {
         if(var1.isBanner()) {
            this.webView = new MMWebView(var1.getContext().getApplicationContext(), var1.internalId);
            this.webView.requiresPreAdSizeFix = true;
            return;
         }

         this.webView = new MMWebView(var1.getContext(), var1.internalId);
         return;
      }

   }

   static void assignAdViewController(MMAdImpl param0) {
      // $FF: Couldn't be decompiled
   }

   static boolean attachWebViewFromOverlay(MMAdImpl param0) {
      // $FF: Couldn't be decompiled
   }

   static String controllersToString() {
      return weakUnsaveableAdRef.toString() + " SAVED:" + saveableControllers.toString();
   }

   static void destroyOtherInlineVideo(Context var0) {
      Iterator var2 = saveableControllers.entrySet().iterator();

      while(var2.hasNext()) {
         MMAdImplController var1 = (MMAdImplController)((Entry)var2.next()).getValue();
         if(var1 != null) {
            MMAdImpl var3 = (MMAdImpl)var1.adImplRef.get();
            if(var3 != null) {
               MMAd var4 = var3.getCallingAd();
               if(var4 != null && var4 instanceof MMLayout) {
                  ((MMLayout)var4).removeVideo();
               }
            }
         }
      }

   }

   static MMAdImpl getAdImplWithId(long param0) {
      // $FF: Couldn't be decompiled
   }

   static MMWebView getWebViewFromExistingAdImpl(MMAdImpl param0) {
      // $FF: Couldn't be decompiled
   }

   private boolean isDownloadingCachedAd(MMAdImpl param1) {
      // $FF: Couldn't be decompiled
   }

   static void removeAdViewController(MMAdImpl param0) {
      // $FF: Couldn't be decompiled
   }

   private void requestAdInternal(MMAdImpl var1) {
      if(var1.apid == null) {
         MMException var2 = new MMException("MMAdView found with a null apid. New ad requests on this MMAdView are disabled until an apid has been assigned.", 1);
         MMLog.e("MMAdImplController", var2.getMessage());
         MMSDK$Event.requestFailed(var1, var2);
      } else if(var1.isBanner() || !this.isDownloadingCachedAd(var1)) {
         synchronized(this) {
            if(this.requestAdRunnable != null) {
               MMLog.i("MMAdImplController", MMException.getErrorCodeMessage(12));
               MMSDK$Event.requestFailed(var1, new MMException(12));
               return;
            }

            this.requestAdRunnable = new MMAdImplController$RequestAdRunnable(this, null);
            Utils$ThreadUtils.execute(this.requestAdRunnable);
            return;
         }
      }

   }

   private static void setupWebView(MMAdImpl param0) {
      // $FF: Couldn't be decompiled
   }

   int checkReason(MMAdImpl var1, CachedAd var2) {
      if(var2.isExpired()) {
         MMLog.d("MMAdImplController", String.format("%s is expired.", new Object[]{var2.getId()}));
         return 21;
      } else if(!var2.isOnDisk(var1.getContext())) {
         MMLog.d("MMAdImplController", String.format("%s is not on disk.", new Object[]{var2.getId()}));
         return 22;
      } else if(!HandShake.sharedHandShake(var1.getContext()).canDisplayCachedAd(var1.adType, var2.deferredViewStart)) {
         MMLog.d("MMAdImplController", String.format("%s cannot be shown at this time.", new Object[]{var2.getId()}));
         return 24;
      } else {
         return 100;
      }
   }

   int display(MMAdImpl var1) {
      CachedAd var2 = AdCache.loadNextCachedAd(var1.getContext(), var1.getCachedName());
      if(var2 != null) {
         if(var2.canShow(var1.getContext(), var1, true)) {
            MMSDK$Event.displayStarted(var1);
            AdCache.setNextCachedAd(var1.getContext(), var1.getCachedName(), (String)null);
            var2.show(var1.getContext(), var1.internalId);
            HandShake.sharedHandShake(var1.getContext()).updateLastVideoViewedTime(var1.getContext(), var1.adType);
            return 0;
         } else {
            return this.checkReason(var1, var2);
         }
      } else {
         return 20;
      }
   }

   public void downloadCompleted(CachedAd var1, boolean var2) {
      MMAdImpl var3 = (MMAdImpl)this.adImplRef.get();
      if(var3 == null) {
         MMLog.e("MMAdImplController", MMException.getErrorCodeMessage(25));
      } else {
         if(var2) {
            AdCache.setNextCachedAd(var3.getContext(), var3.getCachedName(), var1.getId());
         }

         if(var2) {
            MMSDK$Event.requestCompleted(var3);
         } else {
            MMSDK$Event.requestFailed(var3, new MMException(15));
         }
      }
   }

   public void downloadStart(CachedAd var1) {
   }

   public String getDefaultUserAgentString(Context var1) {
      return System.getProperty("http.agent");
   }

   HttpMMHeaders getLastHeaders() {
      return this.webView == null?null:this.webView.getLastHeaders();
   }

   String getUserAgent() {
      String var4;
      label16: {
         MMAdImpl var1 = (MMAdImpl)this.adImplRef.get();
         if(var1 != null) {
            Context var3 = var1.getContext();
            if(var3 != null) {
               var4 = this.getDefaultUserAgentString(var3);
               break label16;
            }
         }

         var4 = null;
      }

      String var2 = var4;
      if(TextUtils.isEmpty(var4)) {
         var2 = Build.MODEL;
      }

      return var2;
   }

   int isAdAvailable(MMAdImpl var1) {
      CachedAd var2 = AdCache.loadNextCachedAd(var1.getContext(), var1.getCachedName());
      if(var2 != null) {
         return var2.canShow(var1.getContext(), var1, true)?0:this.checkReason(var1, var2);
      } else {
         MMLog.i("MMAdImplController", "No next ad.");
         return 20;
      }
   }

   void linkForExpansion(MMAdImpl var1) {
      MMAdImpl var2 = getAdImplWithId(var1.linkForExpansionId);
      if(var2 != null) {
         this.linkedAdImplId = var1.linkForExpansionId;
         var2.controller.linkedAdImplId = var1.internalId;
         var2.linkForExpansionId = var1.internalId;
      }

   }

   void loadUrl(String var1) {
      if(!TextUtils.isEmpty(var1) && this.webView != null) {
         this.webView.loadUrl(var1);
      }

   }

   void loadWebContent(String var1, String var2) {
      MMAdImpl var3 = (MMAdImpl)this.adImplRef.get();
      if(var3 != null && this.webView != null) {
         this.webView.setWebViewContent(var1, var2, var3);
      }

   }

   void requestAd() {
      MMAdImpl var1 = (MMAdImpl)this.adImplRef.get();
      if(var1 == null) {
         MMLog.e("MMAdImplController", MMException.getErrorCodeMessage(25));
         MMSDK$Event.requestFailed(var1, new MMException(25));
      } else if(!var1.isRefreshable()) {
         MMSDK$Event.requestFailed(var1, new MMException(16));
      } else if(!MMSDK.isUiThread()) {
         MMLog.e("MMAdImplController", MMException.getErrorCodeMessage(3));
         MMSDK$Event.requestFailed(var1, new MMException(3));
      } else if(HandShake.sharedHandShake(var1.getContext()).kill) {
         MMLog.i("MMAdImplController", "The server is no longer allowing ads.");
         MMSDK$Event.requestFailed(var1, new MMException(16));
      } else {
         try {
            MMLog.d("MMAdImplController", "adLayout - requestAd");
            this.requestAdInternal(var1);
         } catch (Exception var2) {
            MMLog.e("MMAdImplController", "There was an exception with the ad request. ", var2);
            var2.printStackTrace();
         }
      }
   }

   void setLastHeaders(HttpMMHeaders var1) {
      if(this.webView != null) {
         this.webView.setLastHeaders(var1);
      }

   }

   void setWebViewContent(String var1, String var2) {
      if(this.webView != null) {
         this.webView.setWebViewContent(var1, var2, (MMAdImpl)this.adImplRef.get());
      }

   }

   public String toString() {
      MMAdImpl var1 = (MMAdImpl)this.adImplRef.get();
      StringBuilder var2 = new StringBuilder();
      if(var1 != null) {
         var2.append(var1 + "-LinkInC=" + this.linkedAdImplId);
      }

      return var2.toString() + " w/" + this.webView;
   }

   void unresizeToDefault() {
      if(this.webView != null) {
         this.webView.unresizeToDefault((MMAdImpl)this.adImplRef.get());
      }

   }
}
