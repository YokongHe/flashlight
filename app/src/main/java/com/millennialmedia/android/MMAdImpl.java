package com.millennialmedia.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RelativeLayout.LayoutParams;
import com.millennialmedia.android.BannerWebViewClient;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdImpl$BasicWebViewClientListener;
import com.millennialmedia.android.MMAdImpl$MMAdImplRedirectionListenerImpl;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.MMWebViewClient;
import com.millennialmedia.android.MMWebViewClient$MMWebViewClientListener;
import com.millennialmedia.android.RequestListener;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class MMAdImpl implements MMAd {
   static final String BANNER = "b";
   static final String INTERSTITIAL = "i";
   private static final String TAG = "MMAdImpl";
   private static long nextAdViewId = 1L;
   String adType;
   String apid = "28911";
   WeakReference contextRef;
   MMAdImplController controller;
   boolean ignoreDensityScaling = false;
   long internalId;
   boolean isFinishing;
   long lastAdRequest;
   long linkForExpansionId;
   protected MMRequest mmRequest;
   MMWebViewClient mmWebViewClient;
   MMWebViewClient$MMWebViewClientListener mmWebViewClientListener;
   JSONObject obj;
   RequestListener requestListener;
   String userData;

   public MMAdImpl(Context var1) {
      this.contextRef = new WeakReference(var1);
      this.mmWebViewClientListener = new MMAdImpl$BasicWebViewClientListener(this);
      synchronized(MMAdImpl.class) {
         this.internalId = (long)(nextAdViewId++);
         MMLog.v("MMAdImpl", String.format("Assigning MMAdImpl internal id: %d", new Object[]{Long.valueOf(this.internalId)}));
      }
   }

   static String[] getAdTypes() {
      return new String[]{"b", "i"};
   }

   void addView(MMWebView var1, LayoutParams var2) {
   }

   void animateTransition() {
   }

   public String getApid() {
      return this.apid;
   }

   String getCachedName() {
      return this.adType != null && this.apid != null?this.adType + "_" + this.apid:null;
   }

   abstract MMAd getCallingAd();

   Context getContext() {
      return this.contextRef != null?(Context)this.contextRef.get():null;
   }

   int getId() {
      return -1;
   }

   public boolean getIgnoresDensityScaling() {
      return this.ignoreDensityScaling;
   }

   public RequestListener getListener() {
      return this.requestListener;
   }

   public MMRequest getMMRequest() {
      return this.mmRequest;
   }

   MMWebViewClient getMMWebViewClient() {
      MMLog.d("MMAdImpl", "Returning a client for user: DefaultWebViewClient, adimpl=" + this);
      return new BannerWebViewClient(this.mmWebViewClientListener, new MMAdImpl$MMAdImplRedirectionListenerImpl(this));
   }

   String getReqType() {
      return "fetch";
   }

   String getRequestCompletedAction() {
      return "millennialmedia.action.ACTION_FETCH_SUCCEEDED";
   }

   String getRequestFailedAction() {
      return "millennialmedia.action.ACTION_FETCH_FAILED";
   }

   public boolean hasCachedVideoSupport() {
      return true;
   }

   void insertUrlAdMetaValues(Map var1) {
      Context var2 = this.getContext();
      var1.put("apid", this.apid);
      var1.put("do", MMSDK.getOrientation(var2));
      var1.put("olock", MMSDK.getOrientationLocked(var2));
      if(!this.hasCachedVideoSupport()) {
         var1.put("cachedvideo", "false");
      }

      var1.put("reqtype", this.getReqType());
      if(this.mmRequest != null) {
         this.mmRequest.getUrlParams(var1);
      }

      if(HandShake.sharedHandShake(var2).canRequestVideo(var2, this.adType)) {
         var1.put("video", "true");
      } else {
         var1.put("video", "false");
      }

      if(this.adType != null) {
         if(!this.adType.equals("b") && !this.adType.equals("i")) {
            MMLog.e("MMAdImpl", "******* ERROR: INCORRECT AD TYPE IN MMADVIEW OBJECT PARAMETERS (" + this.adType + ") **********");
         } else {
            var1.put("at", this.adType);
         }
      } else {
         MMLog.e("MMAdImpl", "******* SDK DEFAULTED TO MMBannerAdBottom. THIS MAY AFFECT THE ADS YOU RECIEVE!!! **********");
         var1.put("at", "b");
      }
   }

   public boolean isBanner() {
      return false;
   }

   boolean isExpandingToUrl() {
      return false;
   }

   boolean isLifecycleObservable() {
      return false;
   }

   boolean isRefreshable() {
      if(MMSDK.disableAdMinRefresh) {
         MMLog.d("MMAdImpl", "Minimum adrefresh time ignored");
         return true;
      } else {
         long var2 = System.currentTimeMillis();
         int var1 = (int)((var2 - this.lastAdRequest) / 1000L);
         long var4 = HandShake.sharedHandShake(this.getContext()).adRefreshSecs;
         if((long)var1 >= var4) {
            this.lastAdRequest = var2;
            return true;
         } else {
            MMLog.d("MMAdImpl", String.format("Cannot request ad. Last ad request was %d seconds ago. Next ad can be requested in %d seconds.", new Object[]{Integer.valueOf(var1), Long.valueOf(var4 - (long)var1)}));
            return false;
         }
      }
   }

   boolean isTransitionAnimated() {
      return false;
   }

   boolean isUpdatingMraid() {
      return this.controller != null && this.controller.webView != null && !this.controller.webView.isExpanding;
   }

   void prepareTransition(Bitmap var1) {
   }

   void removeProgressBar() {
   }

   void removeView(MMWebView var1) {
   }

   void requestAd() {
      MMAdImplController.assignAdViewController(this);
      if(this.controller != null) {
         this.controller.requestAd();
      }

   }

   public void setApid(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         HandShake.apid = var1;
      }

      this.apid = var1;
   }

   void setClickable(boolean var1) {
   }

   public void setIgnoresDensityScaling(boolean var1) {
      this.ignoreDensityScaling = var1;
   }

   public void setListener(RequestListener var1) {
      this.requestListener = var1;
   }

   public void setMMRequest(MMRequest var1) {
      this.mmRequest = var1;
   }

   public String toString() {
      return "AdType[(" + this.adType + ") InternalId(" + this.internalId + ") LinkedId(" + this.linkForExpansionId + ") isFinishing(" + this.isFinishing + ")]";
   }

   void unresizeToDefault() {
      if(this.controller != null) {
         this.controller.unresizeToDefault();
      }

   }
}
