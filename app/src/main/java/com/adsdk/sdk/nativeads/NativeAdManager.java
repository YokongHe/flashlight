package com.adsdk.sdk.nativeads;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.adsdk.sdk.Gender;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.RequestException;
import com.adsdk.sdk.Util;
import com.adsdk.sdk.nativeads.NativeAd;
import com.adsdk.sdk.nativeads.NativeAdListener;
import com.adsdk.sdk.nativeads.NativeAdRequest;
import com.adsdk.sdk.nativeads.NativeAdView;
import com.adsdk.sdk.nativeads.NativeViewBinder;
import com.adsdk.sdk.nativeads.RequestNativeAd;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NativeAdManager {
   private List adTypes;
   private Context context;
   ExecutorService executor = Executors.newSingleThreadExecutor();
   private Handler handler;
   private boolean includeLocation = false;
   private List keywords;
   private NativeAdListener listener;
   private String publisherId;
   private NativeAdRequest request;
   private String requestUrl;
   private int userAge;
   private Gender userGender;

   public NativeAdManager(Context var1, String var2, boolean var3, String var4, NativeAdListener var5, List var6) {
      if(var4 != null && var4.length() != 0) {
         this.context = var1;
         this.requestUrl = var2;
         this.includeLocation = var3;
         this.publisherId = var4;
         this.listener = var5;
         this.adTypes = var6;
         this.handler = new Handler();
         Util.prepareAndroidAdId(var1);
      } else {
         Log.e("Publisher Id cannot be null or empty");
         throw new IllegalArgumentException("User Id cannot be null or empty");
      }
   }

   private NativeAdRequest getRequest() {
      if(this.request == null) {
         this.request = new NativeAdRequest();
         this.request.setAndroidAdId(Util.getAndroidAdId());
         this.request.setAdDoNotTrack(Util.hasAdDoNotTrack());
         this.request.setPublisherId(this.publisherId);
         this.request.setUserAgent(Util.getDefaultUserAgentString(this.context));
         this.request.setUserAgent2(Util.buildUserAgent());
         Log.d("ADSDK", "WebKit UserAgent:" + this.request.getUserAgent());
      }

      this.request.setRequestUrl(this.requestUrl);
      this.request.setAdTypes(this.adTypes);
      this.request.setGender(this.userGender);
      this.request.setUserAge(this.userAge);
      this.request.setAdTypes(this.adTypes);
      this.request.setKeywords(this.keywords);
      Location var1 = null;
      if(this.includeLocation) {
         var1 = Util.getLocation(this.context);
      }

      if(var1 != null) {
         Log.d("ADSDK", "location is longitude: " + var1.getLongitude() + ", latitude: " + var1.getLatitude());
         this.request.setLatitude(var1.getLatitude());
         this.request.setLongitude(var1.getLongitude());
      } else {
         this.request.setLatitude(0.0D);
         this.request.setLongitude(0.0D);
      }

      return this.request;
   }

   public NativeAdView getNativeAdView(NativeAd var1, NativeViewBinder var2) {
      return new NativeAdView(this.context, var1, var2, this.listener);
   }

   public void requestAd() {
      this.request = this.getRequest();
      Thread var1 = new Thread(new Runnable() {
         public void run() {
            RequestNativeAd var1 = new RequestNativeAd();

            try {
               var1.sendRequest(NativeAdManager.this.request, NativeAdManager.this.handler, NativeAdManager.this.listener, NativeAdManager.this.context);
            } catch (RequestException var2) {
               Log.e("ADSDK", "Exception in native ad request thread", var2);
            }
         }
      });
      var1.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
         public void uncaughtException(Thread var1, Throwable var2) {
            Log.e("ADSDK", "Exception in native ad request thread", var2);
         }
      });
      this.executor.submit(var1);
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
